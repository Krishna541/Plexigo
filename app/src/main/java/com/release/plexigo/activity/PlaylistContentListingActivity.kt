package com.release.plexigo.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.TimeoutError
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.SearchContentListAdapter
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_playlist_content_listing.*
import kotlinx.android.synthetic.main.activity_playlist_content_listing.txtUserName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class PlaylistContentListingActivity : AppCompatActivity(),
    View.OnClickListener, SearchContentListAdapter.OnPlayListItemDeleteClickListener {
    var playlistContentAdapter: SearchContentListAdapter? = null
    var playlistContentList = ArrayList<MovieModel>()
    var showDeleteButton = false
    var playlistDetailModel: PlaylistDetailModel? = null
    private var playListTitle: String? = ""
    private var bottomSheet: BottomSheetBehavior<View>? = null
    lateinit var apiInterface : APIInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_content_listing)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        initView()
        initData()
    }

    private fun initView() {
        bottomSheet = BottomSheetBehavior.from(findViewById(R.id.btmSheetPlaylistOptions))
        bottomSheet!!.peekHeight = 0
        imgPlaylistOptions.setOnClickListener(this)
        txtRenamePlaylist.setOnClickListener(this)
        txtDeletePlaylist.setOnClickListener(this)
        txtPublicPrivatePlaylist.setOnClickListener(this)
    }

    private fun initData() {
        txtUserName!!.text = intent.getStringExtra("playlistTitle")
        playListTitle = intent.getStringExtra("playlistTitle")
        playlistContentAdapter =
            SearchContentListAdapter(this, playlistContentList, showDeleteButton)
        recyclerPlaylistContent!!.adapter = playlistContentAdapter
        playListContent()
        playlistContentAdapter!!.setOnPlayListItemDeleteClickListener(this)
        imgBack!!.setOnClickListener(this)
        imgFollowPlaylist!!.setOnClickListener(this)
        imgUnFollowPlaylist!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.imgBack -> onBackPressed()
            R.id.imgFollowPlaylist -> if (AppConstants.isUserLoggedIn) showFollowPlaylistDialog() else {
                AppConstants.ReloadMenus = true
                val intent1 = Intent(this, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
            R.id.imgUnFollowPlaylist -> if (AppConstants.isUserLoggedIn) showUnFollowPlaylistDialog() else {
                AppConstants.ReloadMenus = true
                val intent1 = Intent(this, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
            R.id.txtRenamePlaylist -> if (AppConstants.isUserLoggedIn) {
                showRenamePlaylistDialog()
                bottomSheet!!.setState(BottomSheetBehavior.STATE_COLLAPSED)
            } else {
                AppConstants.ReloadMenus = true
                val intent1 = Intent(this, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
            R.id.txtDeletePlaylist -> if (AppConstants.isUserLoggedIn) {
                showDeletePlaylistDialog()
                bottomSheet!!.setState(BottomSheetBehavior.STATE_COLLAPSED)
            } else {
                AppConstants.ReloadMenus = true
                val intent1 = Intent(this, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
            R.id.txtPublicPrivatePlaylist -> if (AppConstants.isUserLoggedIn) {
                updatePlaylistType()
                bottomSheet!!.setState(BottomSheetBehavior.STATE_COLLAPSED)
            } else {
                AppConstants.ReloadMenus = true
                val intent1 = Intent(this, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
            R.id.imgPlaylistOptions -> {
                if (playlistDetailModel!!.playlisttype.equals(
                        "public",
                        ignoreCase = true
                    )
                ) txtPublicPrivatePlaylist!!.text =
                    "Make Playlist Private" else {
                    if (playlistDetailModel!!.playlisttype.equals("private", ignoreCase = true)) {
                        txtPublicPrivatePlaylist!!.text = "Make Playlist Public"
                    } else {
                        txtPublicPrivatePlaylist!!.visibility = View.GONE
                    }
                }
                bottomSheet!!.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
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

    //This is for Headers If You Needed
    private fun playListContent() {
        showLoader()
        val userid = if (AppConstants.UserId != null) AppConstants.UserId else "0"
        val playListId = intent.getIntExtra(
            "playlistId",
            0
        )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getPlayListContent(playListId, userid!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            playlistContentList.clear()
                            playlistContentList.addAll(responseModel.data.playlistContent)
                            playlistContentAdapter!!.notifyDataSetChanged()
                            recyclerPlaylistContent!!.visibility = View.VISIBLE
                            txtNoData!!.visibility = View.GONE
                        } else {
                            recyclerPlaylistContent!!.visibility = View.GONE
                            txtNoData!!.text = responseModel?.data?.message
                            txtNoData!!.visibility = View.VISIBLE
                        }
                        getPlayListDetails()
                    }
                } catch (e: HttpException) {
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
                        "${e.message}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    private  fun getPlayListDetails(){
        showLoader()
        val userid = if (AppConstants.UserId != null) AppConstants.UserId else "0"
        val playListId = intent.getIntExtra(
            "playlistId",
            0
        )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getPlayListDetail(playListId, userid!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            playlistDetailModel =
                                responseModel.data.playlist[0]
                            playListTitle = playlistDetailModel?.title
                            txtUserName!!.text = playlistDetailModel?.title
                            if (playlistDetailModel?.isPlaylistOwner
                                    .equals("Y", ignoreCase = true)
                            ) {
                                showDeleteButton = true
                                if (playlistDetailModel?.playlisttype
                                        .equals("public", ignoreCase = true)
                                ) {
                                    txtPublicPlaylist!!.visibility = View.VISIBLE
                                    txtPrivatePlaylist!!.visibility = View.GONE
                                } else {
                                    txtPublicPlaylist!!.visibility = View.GONE
                                    if (playlistDetailModel?.playlisttype
                                            .equals("private", ignoreCase = true)
                                    ) {
                                        txtPrivatePlaylist!!.visibility = View.VISIBLE
                                        txtPublicPlaylist!!.visibility = View.GONE
                                    } else {
                                        txtPrivatePlaylist!!.visibility = View.GONE
                                    }
                                }
                                playlistContentAdapter = SearchContentListAdapter(
                                    this@PlaylistContentListingActivity,
                                    playlistContentList,
                                    showDeleteButton
                                )
                                recyclerPlaylistContent!!.adapter = playlistContentAdapter
                                playlistContentAdapter!!.setOnPlayListItemDeleteClickListener(
                                    this@PlaylistContentListingActivity
                                )
                                imgFollowPlaylist!!.visibility = View.GONE
                                imgPlaylistOptions!!.visibility = View.VISIBLE
                            } else {
                                if (playlistDetailModel?.isFollow
                                        .equals("Y", ignoreCase = true)
                                ) {
                                    imgUnFollowPlaylist!!.visibility = View.VISIBLE
                                    imgFollowedPlaylist!!.visibility = View.VISIBLE
                                    imgFollowPlaylist!!.visibility = View.GONE
                                } else {
                                    imgFollowedPlaylist!!.visibility = View.GONE
                                    imgUnFollowPlaylist!!.visibility = View.GONE
                                    imgFollowPlaylist!!.visibility = View.VISIBLE
                                }
                                imgPlaylistOptions!!.visibility = View.GONE
                                imgUserImage!!.visibility = View.VISIBLE
                            }
                            if (!TextUtils.isEmpty(playlistDetailModel?.userImage)){
                                Glide
                                    .with(this@PlaylistContentListingActivity)
                                    .load(playlistDetailModel?.userImage)
                                    .circleCrop()
                                    .into(imgUserImage)
                            }
                            txtUserDetails!!.text = playlistDetailModel?.noofContent
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
                        "${e.message}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


    }


    private fun showRenamePlaylistDialog() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.dialog_create_playlist, null)
        val pwindo = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val txtTitle = layout.findViewById<TextView>(R.id.txtTitle)
        val edtPlayListName = layout.findViewById<EditText>(R.id.edtPlayListName)
        edtPlayListName.setText(playListTitle)
        edtPlayListName.setSelection(edtPlayListName.text.length)
        edtPlayListName.requestFocus()
        val btnCancel = layout.findViewById<Button>(R.id.btnCancel)
        val btnSave = layout.findViewById<Button>(R.id.btnSave)
        txtTitle.text = "Rename Playlist"
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            if (edtPlayListName.text.toString().trim { it <= ' ' }.isNotEmpty()) {
                if (edtPlayListName.text.toString().trim { it <= ' ' }.length < 3) {
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
                        "Playlist name should be at-least 3 characters long.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    renamePlayList(edtPlayListName.text.toString().trim { it <= ' ' })
                }
                pwindo.dismiss()
            } else {
                Toast.makeText(
                    this@PlaylistContentListingActivity,
                    "Please enter a valid playlist name.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    private fun showRemovePlaylistDialog(movieModel: MovieModel?) {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.dialog_create_playlist, null)
        val pwindo = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val txtTitle = layout.findViewById<TextView>(R.id.txtTitle)
        val edtPlayListName = layout.findViewById<EditText>(R.id.edtPlayListName)
        val btnCancel = layout.findViewById<Button>(R.id.btnCancel)
        val btnSave = layout.findViewById<Button>(R.id.btnSave)
        txtTitle.text = "Remove from Playlist?"
        txtTitle.textSize = 16f
        edtPlayListName.visibility = View.GONE
        btnSave.text = "Ok"
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            removeContentFromPlaylist(movieModel)
            pwindo.dismiss()
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }
    private fun removeContentFromPlaylist(movieModel: MovieModel?){
        showLoader()
        val request  = RemovePlayListContentRequest(intent.getIntExtra("playlistId", 0),Integer.valueOf(AppConstants.UserId), movieModel!!.contentId)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.removeContentUserPlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@PlaylistContentListingActivity,
                                responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            playListContent()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistContentListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    private fun showFollowPlaylistDialog() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.dialog_create_playlist, null)
        val pwindo = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val txtTitle = layout.findViewById<TextView>(R.id.txtTitle)
        val edtPlayListName = layout.findViewById<EditText>(R.id.edtPlayListName)
        val btnCancel = layout.findViewById<Button>(R.id.btnCancel)
        val btnSave = layout.findViewById<Button>(R.id.btnSave)
        txtTitle.text = "Add to my Playlists"
        txtTitle.textSize = 16f
        edtPlayListName.visibility = View.GONE
        btnSave.text = "Ok"
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            followPlaylist()
            pwindo.dismiss()
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    private fun followPlaylist(){
        showLoader()
        val request  = PlayListRequest(intent.getIntExtra("playlistId", 0),Integer.valueOf(AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.followUserPlayLists(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@PlaylistContentListingActivity,
                                responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistContentListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun showUnFollowPlaylistDialog() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.dialog_create_playlist, null)
        val pwindo = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val txtTitle = layout.findViewById<TextView>(R.id.txtTitle)
        val edtPlayListName = layout.findViewById<EditText>(R.id.edtPlayListName)
        val btnCancel = layout.findViewById<Button>(R.id.btnCancel)
        val btnSave = layout.findViewById<Button>(R.id.btnSave)
        txtTitle.text = "Unfollow Playlist?"
        txtTitle.textSize = 16f
        edtPlayListName.visibility = View.GONE
        btnSave.text = "Ok"
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            unFollowPlaylist()
            pwindo.dismiss()
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    private fun unFollowPlaylist(){
        showLoader()
        val request  = PlayListRequest(intent.getIntExtra("playlistId", 0),Integer.valueOf(AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.unFollowUserPlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@PlaylistContentListingActivity,
                                responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            playListContent()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistContentListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun renamePlayList(newTitle: String){
        showLoader()
        val request  =  RenamePlayListRequest( intent.getIntExtra("playlistId", 0),newTitle)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.renamePlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@PlaylistContentListingActivity,
                                "Successfully Updated",
                                Toast.LENGTH_SHORT
                            ).show()
                            getPlayListDetails()
                        }else{
                            Toast.makeText(
                                this@PlaylistContentListingActivity,
                                responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistContentListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    private fun showDeletePlaylistDialog() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.dialog_create_playlist, null)
        val pwindo = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val txtTitle = layout.findViewById<TextView>(R.id.txtTitle)
        val edtPlayListName = layout.findViewById<EditText>(R.id.edtPlayListName)
        val btnCancel = layout.findViewById<Button>(R.id.btnCancel)
        val btnSave = layout.findViewById<Button>(R.id.btnSave)
        txtTitle.text = "Delete Playlist?"
        txtTitle.textSize = 16f
        edtPlayListName.visibility = View.GONE
        btnSave.text = "Ok"
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            removePlaylist()
            pwindo.dismiss()
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    private fun removePlaylist() {
        showLoader()
        val request  =  PlayListRequest(intent.getIntExtra("playlistId", 0), Integer.valueOf(AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.removePlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@PlaylistContentListingActivity,
                                responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            onBackPressed()
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistContentListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun updatePlaylistType(){
        showLoader()
        var newPlayListType = ""
        if (playlistDetailModel!!.playlisttype.equals(
                "public",
                ignoreCase = true
            )
        ) newPlayListType = "private" else {
            if (playlistDetailModel!!.playlisttype.equals("private", ignoreCase = true)) {
                newPlayListType = "public"
            }
        }
        val request  =  UpdatePlayListTypeRequest(intent.getIntExtra("playlistId", 0), newPlayListType)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.updatePlayListType(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@PlaylistContentListingActivity,
                                "Successfully Updated",
                                Toast.LENGTH_SHORT
                            ).show()
                            getPlayListDetails()
                        }else{
                            Toast.makeText(
                                this@PlaylistContentListingActivity,
                                responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlaylistContentListingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PlaylistContentListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PlaylistContentListingActivity,
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

    override fun onDeletePlayListBtnClicked(playlistContent: MovieModel?) {
        showRemovePlaylistDialog(playlistContent)
    }
}