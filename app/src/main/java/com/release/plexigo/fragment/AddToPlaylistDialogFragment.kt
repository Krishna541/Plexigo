package com.release.plexigo.fragment

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.android.volley.*
import com.android.volley.toolbox.Volley

import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.AddToPlaylistAdapter
import com.release.plexigo.models.CreatePlayListRequest
import com.release.plexigo.models.RemovePlayListContentRequest
import com.release.plexigo.models.UserPlaylistModel
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.fragment_dialog_add_to_playlist.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class AddToPlaylistDialogFragment : DialogFragment(),
    AddToPlaylistAdapter.OnPlayListItemSelectedListener {

    var queue: RequestQueue? = null
    private val playlists: ArrayList<UserPlaylistModel> = ArrayList<UserPlaylistModel>()
    private var addToPlaylistAdapter: AddToPlaylistAdapter? = null
    lateinit var apiInterface: APIInterface
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        isCancelable = false
        val view: View =
            inflater.inflate(R.layout.fragment_dialog_add_to_playlist, container, false)
        val root: ConstraintLayout = view.findViewById(R.id.root)
        val params = root.layoutParams
        params.width = Resources.getSystem().displayMetrics.widthPixels - 200
        params.height = (Resources.getSystem().displayMetrics.heightPixels / 2.5).toInt()
        root.layoutParams = params
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        queue = Volley.newRequestQueue(activity)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        initView()
        initData()
    }

    private fun initView() {
        addToPlaylistAdapter = AddToPlaylistAdapter(playlists)
        recyclerPlaylists.adapter = addToPlaylistAdapter
        btnCancel.setOnClickListener({ dismiss() })
    }

    private fun initData() {
        userPlayLists()
        addToPlaylistAdapter!!.setOnPlayListItemSelectedListener(this)
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
                            playlists.clear()
                            playlists.add(UserPlaylistModel("Create new List...", 0,"","","","",""))
                            playlists.addAll(responseModel.data.playlist)
                            addToPlaylistAdapter!!.notifyDataSetChanged()
                        } else {
                            playlists.add(UserPlaylistModel("Create new List...", 0,"","","","",""))
                            addToPlaylistAdapter!!.notifyDataSetChanged()
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


    fun showLoader() {
        if (customProgressDialog == null) customProgressDialog = CustomProgressDialog.newInstance()
        val ft = requireActivity().supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.isCancelable = false
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    private fun showCreatePlaylistDialog() {
        val inflater =
            requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
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
            if (edtPlayListName.text.toString().trim { it <= ' ' }.isNotEmpty()) {
                if (edtPlayListName.text.toString().trim { it <= ' ' }.length < 3) {
                    Toast.makeText(
                        activity,
                        "Playlist name should be at-least 3 characters long.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    createPlaylist(edtPlayListName.text.toString().trim { it <= ' ' })
                }
                pwindo.dismiss()
            } else {
                Toast.makeText(activity, "Please enter a valid playlist name.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
        dismiss()
    }


    private fun createPlaylist(title: String){
        showLoader()
        val request = CreatePlayListRequest(title,Integer.valueOf(AppConstants.UserId),"private",requireArguments().getInt("contentId", 0))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.createUserPlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
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


    private fun addContentToPlayList(playlist: UserPlaylistModel){
        showLoader()
        val request = RemovePlayListContentRequest(playlist.playlistId,Integer.valueOf(AppConstants.UserId),requireArguments().getInt("contentId", 0))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.addContentToPlayList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                activity, """Content added to the Playlist ${playlist.title}""".trimIndent(), Toast.LENGTH_SHORT
                            ).show()
                            userPlayLists()
                        }else{
                            Toast.makeText(
                                activity,
                                responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    dismiss()
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

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
        fun newInstance(contentId: Int): AddToPlaylistDialogFragment {
            val args = Bundle()
            val fragment = AddToPlaylistDialogFragment()
            args.putInt("contentId", contentId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onPlayListItemSelected(playlist: UserPlaylistModel?) {
        if (playlist?.playlistId === 0) {
            CreateNewPlaylistDialogFragment.newInstance(requireArguments().getInt("contentId", 0)).show(
                parentFragmentManager, ""
            )
            dismiss()
        } else {
            if (playlist?.playlisttype.equals("private",ignoreCase = true) ||
                playlist?.playlisttype.equals("public",ignoreCase = true)
            ) {
                addContentToPlayList(playlist!!)
            } else {
                Toast.makeText(
                    activity,
                    "You can not add content to the playlist that you have followed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}