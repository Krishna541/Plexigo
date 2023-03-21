package com.release.plexigo.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.FollowedUserAdapter
import com.release.plexigo.adapter.PlaylistAdapter
import com.release.plexigo.models.TopUserListModel
import com.release.plexigo.models.UpdateFollowStateRequest
import com.release.plexigo.models.UserPlaylistModel
import com.release.plexigo.models.ViewUserPlaylistDetailModel
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_edit_profile.*

import kotlinx.android.synthetic.main.activity_user_playlist_listing.*
import kotlinx.android.synthetic.main.activity_user_playlist_listing.back_btn
import kotlinx.android.synthetic.main.activity_user_playlist_listing.txtUserName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import retrofit2.HttpException
import java.io.IOException

class UserPlaylistListingActivity : AppCompatActivity(),
    View.OnClickListener {

    private val playList = ArrayList<UserPlaylistModel>()
    private val playlistAdapter = PlaylistAdapter(this,playList, true)
    private val followUserList = ArrayList<TopUserListModel>()
    var followedUserAdapter = FollowedUserAdapter(this,followUserList)
    var queue: RequestQueue? = null
    var playlistDetailModel: ViewUserPlaylistDetailModel? = null
    private var userId = 0
    private var userFollowStatus = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_playlist_listing)
        initView()
        initData()
    }

    private fun initView() {
        recyclerFollowedUsers.adapter = followedUserAdapter
        btnFollowUnfollow.setOnClickListener(View.OnClickListener {
            if (AppConstants.isUserLoggedIn) {
                if (userFollowStatus == 0) {
                    updateFollowState("follow")
                } else {
                    updateFollowState("unfollow")
                }
            } else {
                val intent1 = Intent(this@UserPlaylistListingActivity, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
        })
    }

    private fun initData() {
        userId = intent.getIntExtra("playlistUserId", 0)
        if (AppConstants.UserId.equals(userId.toString(), ignoreCase = true)) {
            btnFollowUnfollow!!.visibility = View.GONE
        }
        queue = Volley.newRequestQueue(this@UserPlaylistListingActivity)
        txtUserName!!.text = intent.getStringExtra("playlistTitle")
        recyclerPlaylistListing!!.adapter = playlistAdapter
        userPlaylists()
        playlistAdapter.setOnPlayListItemSelectedListener(object : PlaylistAdapter.OnPlayListItemSelectedListener {
            override fun onPlayListItemSelected(playlist: UserPlaylistModel?) {
                val intent = Intent(
                    this@UserPlaylistListingActivity,
                    PlaylistContentListingActivity::class.java
                )
                intent.putExtra("playlistId", playlist?.playlistId)
                intent.putExtra("playlistTitle", playlist?.title)
                startActivity(intent)
            }
        })
        back_btn!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.back_btn -> onBackPressed()
        }
    }

    override fun onBackPressed() {
        setResult(RESULT_OK)
        intent = intent
        super.onBackPressed()
    }

    fun showLoader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.setCancelable(false)
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    private fun userPlaylists(){
        showLoader()
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.viewUserPlayList(userId)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            playList.clear()
                            playList.addAll(responseModel.data.playlist)
                            txtPlaylist!!.visibility = View.VISIBLE
                            playlistAdapter.notifyDataSetChanged()
                            recyclerPlaylistListing!!.visibility = View.VISIBLE
                        } else {
                            recyclerPlaylistListing!!.visibility = View.GONE
                        }
                        getUserPlayListDetails(false)
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@UserPlaylistListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@UserPlaylistListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@UserPlaylistListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@UserPlaylistListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun getUserPlayListDetails(followStateUpdate: Boolean){
        showLoader()
        val apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.viewUserPlayListDetail(userId)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            playlistDetailModel  = responseModel.viewPlaylist
                            txtUserName!!.text = playlistDetailModel?.userName
                            imgUserImage!!.visibility = View.VISIBLE
                            if (!TextUtils.isEmpty(playlistDetailModel?.userImage)) {
                                GlideApp
                                    .with(this@UserPlaylistListingActivity)
                                    .load(playlistDetailModel?.userImage)
                                    .circleCrop()
                                    .placeholder(R.drawable.plexigo_new_transperent_logo)
                                    .into(imgUserImage)
                            }
                            txtUserDetails!!.text = playlistDetailModel?.userplaylistfollowedby
                            userFollowStatus = playlistDetailModel?.userFollowFlag!!
                            updateFollowBtnState()
                            if (!followStateUpdate) followedUserList()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@UserPlaylistListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@UserPlaylistListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@UserPlaylistListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@UserPlaylistListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun updateFollowBtnState() {
        if (userFollowStatus == 0) {
            btnFollowUnfollow!!.text = "Follow"
        } else {
            btnFollowUnfollow!!.text = "Unfollow"
        }
    }


    private fun followedUserList(){
        showLoader()
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getFollowedUserList(userId)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.topuserslist != null && modelObj.topuserslist.size > 0) {
                                hideLoader()
                                txtFollowing!!.visibility = View.VISIBLE
                                followUserList.addAll(modelObj.topuserslist)
                                followedUserAdapter.notifyDataSetChanged()
                            }else {
                                hideLoader()
                            }
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@UserPlaylistListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@UserPlaylistListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@UserPlaylistListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@UserPlaylistListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun updateFollowState(followUnfollow: String){
        showLoader()
        val apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        val request = UpdateFollowStateRequest(userId, (if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt(),followUnfollow)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.updateFolloState(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@UserPlaylistListingActivity,
                                responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            getUserPlayListDetails(true)
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@UserPlaylistListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@UserPlaylistListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@UserPlaylistListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@UserPlaylistListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }



    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}