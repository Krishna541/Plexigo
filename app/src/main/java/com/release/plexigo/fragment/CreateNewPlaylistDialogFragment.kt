package com.release.plexigo.fragment

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.models.CreatePlayListRequest
import com.release.plexigo.models.UserPlaylistModel
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.dialog_fragment_create_playlist.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

class CreateNewPlaylistDialogFragment : DialogFragment() {

    private val playlists: ArrayList<UserPlaylistModel> = ArrayList<UserPlaylistModel>()
    lateinit var apiInterface : APIInterface
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isCancelable = false
        val view: View =
            inflater.inflate(R.layout.dialog_fragment_create_playlist, container, false)
        val root = view.findViewById<LinearLayout>(R.id.root)
        val params = root.layoutParams
        params.width = Resources.getSystem().displayMetrics.widthPixels - 200
        params.height = LinearLayout.LayoutParams.WRAP_CONTENT
        root.layoutParams = params
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        initView(view)
        initData()
    }

    private fun initView(view: View) {
        edtPlayListName.requestFocus()
        btnCancel.setOnClickListener(View.OnClickListener { dismiss() })
        btnSave.setOnClickListener(View.OnClickListener {
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
            } else {
                Toast.makeText(activity, "Please enter a valid playlist name.", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun initData() {}
    fun showLoader() {
        if (customProgressDialog == null) customProgressDialog = CustomProgressDialog.newInstance()
        val ft = requireActivity().supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.isCancelable = false
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
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
                            Toast.makeText(
                                context,
                                "Content added to new Playlist $title", Toast.LENGTH_SHORT
                            ).show()
                        }else {
                            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT)
                                .show()
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
                dismiss()
            }
        }
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
        fun newInstance(contentId: Int): CreateNewPlaylistDialogFragment {
            val args = Bundle()
            val fragment = CreateNewPlaylistDialogFragment()
            args.putInt("contentId", contentId)
            fragment.arguments = args
            return fragment
        }
    }
}