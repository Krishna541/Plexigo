package com.release.plexigo.activity

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.TimeoutError
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.PlaylistAdapter
import com.release.plexigo.models.CreatePlayListRequest
import com.release.plexigo.models.PopularInAreaListRequest
import com.release.plexigo.models.RemovePlayListContentRequest
import com.release.plexigo.models.UserPlaylistModel
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_playlist_listing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class PlaylistListingActivity() : AppCompatActivity(),
    View.OnClickListener, PlaylistAdapter.OnPlayListItemSelectedListener {

    private val playList: ArrayList<UserPlaylistModel> = ArrayList<UserPlaylistModel>()
    private val playlistAdapter: PlaylistAdapter = PlaylistAdapter(this,playList, false)
    lateinit var apiInterface: APIInterface
    var endOfList = false
    var isLoading:kotlin.Boolean? = false
    var PageCount = 1
    var Limit:Int = 10
    var CurrentPageCount:Int = 1
    var TotalPageCount:Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_listing)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        initView()
        initData()

    }

    private fun initView(){
        recyclerPlaylists.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //Load more data
                    if (endOfList) {
                        return
                    }
                    if (CurrentPageCount != TotalPageCount && !isLoading!!) {
                        isLoading = true
                        CurrentPageCount++
                        PageCount++
                        callFollowedPlaylistApi()
                    } else {
                        endOfList = true
                    }
                }
            }
        })
    }


    private fun initData() {
        recyclerPlaylists!!.adapter = playlistAdapter
        btnCreateNewPlaylist!!.setOnClickListener(this)
        playlistAdapter.setOnPlayListItemSelectedListener(this)
        imgBack!!.setOnClickListener(this)
    }

    public override fun onResume() {
        super.onResume()
        if (intent.getIntExtra("contentId", 0) == 0) {
            findViewById<View>(R.id.txtSelectCloudPlaylist).visibility = View.GONE
            btnCreateNewPlaylist!!.visibility = View.GONE
            suggestedPlaylists()
        } else if (intent.getIntExtra("contentId", 0) == 1) {
            userPlayLists()
        } else {
            txtSelectCloudPlaylist.text = getString(R.string.list_you_follow)
            callFollowedPlaylistApi()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnCreateNewPlaylist -> showCreatePlaylistDialog()
            R.id.imgBack -> onBackPressed()
        }
    }

    override fun onPlayListItemSelected(playlist: UserPlaylistModel?) {
        if (intent.getIntExtra("contentId", 0) != 0) {
            if (playlist?.playlisttype.equals("private" , ignoreCase = true) ||
                playlist?.playlisttype.equals("public" , ignoreCase = true)
            ) {
                //addContentToPlayList(playlist);
                val intent = Intent(
                    this@PlaylistListingActivity,
                    PlaylistContentListingActivity::class.java
                )
                intent.putExtra("playlistId", playlist?.playlistId)
                intent.putExtra("playlistTitle", playlist?.title)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "You can not add content to the playlist that you have followed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            val intent = Intent(this, PlaylistContentListingActivity::class.java)
            intent.putExtra("playlistId", playlist?.playlistId)
            intent.putExtra("playlistTitle", playlist?.title)
            startActivity(intent)
        }
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

    private fun userPlayLists(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getUserPlayList(Integer.valueOf(AppConstants.UserId))
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            playList.clear()
                            playList.addAll(responseModel.data.playlist)
                            playlistAdapter.notifyDataSetChanged()
                            recyclerPlaylists!!.visibility = View.VISIBLE
                            txtNoData!!.visibility = View.GONE
                        } else {
                            recyclerPlaylists!!.visibility = View.GONE
                            txtNoData.text = responseModel?.data?.message
                            txtNoData!!.visibility = View.VISIBLE
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun callFollowedPlaylistApi(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.callFollowedPlaylistApi((if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt(),PageCount,Limit)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            TotalPageCount = responseModel.data.pageCount
                            playList.addAll(responseModel.data.playlist)
                            playlistAdapter.notifyDataSetChanged()
                            recyclerPlaylists!!.visibility = View.VISIBLE
                            txtNoData!!.visibility = View.GONE
                        } else {
                            recyclerPlaylists!!.visibility = View.GONE
                            txtNoData.setText(responseModel?.data?.message)
                            txtNoData!!.visibility = View.VISIBLE
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun suggestedPlaylists(){
        showLoader()
        val userid = if (AppConstants.UserId != null) AppConstants.UserId!!.toInt() else 0
        val request = PopularInAreaListRequest(userid,1,50)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getPlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            playList.clear()
                            playList.addAll(responseModel.data.playlist)
                            playlistAdapter.notifyDataSetChanged()
                            recyclerPlaylists!!.visibility = View.VISIBLE
                            txtNoData!!.visibility = View.GONE
                        } else {
                            recyclerPlaylists!!.visibility = View.GONE
                            txtNoData.setText(responseModel?.data?.message)
                            txtNoData!!.visibility = View.VISIBLE
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    private fun showCreatePlaylistDialog() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.dialog_create_playlist, null)
        val pwindo = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val edtPlayListName = layout.findViewById<EditText>(R.id.edtPlayListName)
        val btnCancel = layout.findViewById<Button>(R.id.btnCancel)
        val btnSave = layout.findViewById<Button>(R.id.btnSave)
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            if (edtPlayListName.text.toString().trim { it <= ' ' }.length > 0) {
                if (edtPlayListName.text.toString().trim { it <= ' ' }.length < 3) {
                    Toast.makeText(
                        this@PlaylistListingActivity,
                        "Playlist name should be at-least 3 characters long.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    createPlaylist(edtPlayListName.text.toString().trim { it <= ' ' })
                }
                pwindo.dismiss()
            } else {
                Toast.makeText(
                    this@PlaylistListingActivity,
                    "Please enter a valid playlist name.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }
    private fun createPlaylist(title: String){
        showLoader()
        val request = CreatePlayListRequest(title,Integer.valueOf(AppConstants.UserId),"private",intent.getIntExtra("contentId", 0))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.createUserPlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@PlaylistListingActivity,
                                "Content added to new Playlist $title", Toast.LENGTH_SHORT
                            ).show()
                            userPlayLists()
                        } else {
                            Toast.makeText(
                                this@PlaylistListingActivity,
                                "Something went wrong",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun addContentToPlayList(playlist: UserPlaylistModel){
        showLoader()
        val request = RemovePlayListContentRequest(playlist.playlistId,Integer.valueOf(AppConstants.UserId),intent.getIntExtra("contentId", 0))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.addContentToPlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@PlaylistListingActivity,
                                "Content added to the Playlist \n" + playlist.title,
                                Toast.LENGTH_SHORT
                            ).show()
                            userPlayLists()
                        }else {
                            Toast.makeText(
                                this@PlaylistListingActivity,
                                responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(
                                this@PlaylistListingActivity,
                                PlaylistContentListingActivity::class.java
                            )
                            intent.putExtra("playlistId", playlist.playlistId)
                            intent.putExtra("playlistTitle", playlist.title)
                        }
                    }

                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistListingActivity,
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