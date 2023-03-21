package com.release.plexigo.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.core.JsonProcessingException
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.activity.PlaylistContentListingActivity
import com.release.plexigo.adapter.PlaylistAdapter
import com.release.plexigo.models.PlayListRequest
import com.release.plexigo.models.RenamePlayListRequest
import com.release.plexigo.models.UpdatePlayListTypeRequest
import com.release.plexigo.models.UserPlaylistModel
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.fragment_playlist_listing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

class PlaylistListingFragment : Fragment(), View.OnClickListener,
    PlaylistAdapter.OnPlayListItemSelectedListener {
    var playlists: ArrayList<UserPlaylistModel> = ArrayList<UserPlaylistModel>()
    var playlistAdapter: PlaylistAdapter = PlaylistAdapter(requireContext(),playlists, false)
    var queue: RequestQueue? = null
    private var bottomSheet: BottomSheetBehavior<View>? = null
    private val selectedPlaylistForOptions: UserPlaylistModel? = null
    lateinit var apiInterface : APIInterface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        queue = Volley.newRequestQueue(activity)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        recyclerPlaylists.setAdapter(playlistAdapter)
        bottomSheet = BottomSheetBehavior.from(view.findViewById(R.id.btmSheetPlaylistOptions))
        bottomSheet!!.peekHeight = 0
        userPlayLists()
        playlistAdapter.setOnPlayListItemSelectedListener(this)
        txtRenamePlaylist.setOnClickListener(this)
        txtDeletePlaylist.setOnClickListener(this)
        txtPublicPrivatePlaylist.setOnClickListener(this)
    }

    fun showLoader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = childFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.isCancelable = false
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    //This is for Headers If You Needed
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
                            playlists.clear()
                            playlists.addAll(responseModel.data.playlist)
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
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.txtRenamePlaylist -> {
                showRenamePlaylistDialog()
                bottomSheet!!.setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
            R.id.txtDeletePlaylist -> {
                showDeletePlaylistDialog()
                bottomSheet!!.setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
            R.id.txtPublicPrivatePlaylist -> {
                updatePlaylistType()
                bottomSheet!!.setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
        }
    }

    private fun showDeletePlaylistDialog() {
        val inflater =
            requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.dialog_create_playlist, null)
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

    private fun showUnFollowPlaylistDialog() {
        val inflater =
            requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.dialog_create_playlist, null)
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


    private fun renamePlayList(newTitle: String){
        showLoader()
        val request  =  RenamePlayListRequest(selectedPlaylistForOptions!!.playlistId,newTitle)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.renamePlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(activity, "Successfully Updated", Toast.LENGTH_SHORT)
                                .show()
                            userPlayLists()
                        } else {
                            Toast.makeText(
                                activity,
                                responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
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
        if (selectedPlaylistForOptions?.playlisttype
                .equals("public" , ignoreCase = true)
        ) newPlayListType = "private" else {
            if (selectedPlaylistForOptions?.playlisttype.equals("private" , ignoreCase = true)) {
                newPlayListType = "public"
            }
        }
        val request  =  UpdatePlayListTypeRequest(selectedPlaylistForOptions!!.playlistId, newPlayListType)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.updatePlayListType(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(activity, "Successfully Updated", Toast.LENGTH_SHORT)
                                .show()
                            userPlayLists()
                        }else {
                            Toast.makeText(
                                activity,
                                responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun removePlaylist(){
        showLoader()
        val request  =  PlayListRequest(selectedPlaylistForOptions!!.playlistId, Integer.valueOf(AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.removePlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                activity,
                                responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            userPlayLists()
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun unFollowPlaylist(){
        showLoader()
        val request  = PlayListRequest(selectedPlaylistForOptions!!.playlistId,Integer.valueOf(AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.unFollowUserPlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                activity,
                                responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            userPlayLists()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    private fun showRenamePlaylistDialog() {
        val inflater =
            requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.dialog_create_playlist, null)
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
        txtTitle.text = "Rename Playlist"
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            if (edtPlayListName.text.toString().trim { it <= ' ' }.length > 0) {
                if (edtPlayListName.text.toString().trim { it <= ' ' }.length < 3) {
                    Toast.makeText(
                        activity,
                        "Playlist name should be at-least 3 characters long.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    renamePlayList(edtPlayListName.text.toString().trim { it <= ' ' })
                }
                pwindo.dismiss()
            } else {
                Toast.makeText(activity, "Please enter a valid playlist name.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    override fun onPlayListItemSelected(playlist: UserPlaylistModel?) {
        val intent = Intent(activity, PlaylistContentListingActivity::class.java)
        intent.putExtra("playlistId", playlist?.playlistId)
        intent.putExtra("playlistTitle", playlist?.title)
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        userPlayLists()
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
        fun newInstance(): PlaylistListingFragment {
            val args = Bundle()
            val fragment = PlaylistListingFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
