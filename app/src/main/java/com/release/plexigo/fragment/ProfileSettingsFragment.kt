package com.release.plexigo.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Parcelable
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fasterxml.jackson.core.JsonProcessingException
import com.release.plexigo.BuildConfig
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.activity.EditProfileActivity
import com.release.plexigo.activity.NewHomeActivity
import com.release.plexigo.activity.VerifyAuthCodeActivity
import com.release.plexigo.activity.WebViewActivity
import com.release.plexigo.models.QuickPickDataRequest
import com.release.plexigo.models.UserProfileModel
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.fragment_home_profile.*
import kotlinx.android.synthetic.main.fragment_profile_settings.*
import kotlinx.android.synthetic.main.fragment_profile_settings.back_btn
import kotlinx.android.synthetic.main.fragment_profile_settings.imgUser
import kotlinx.android.synthetic.main.fragment_profile_settings.txtName
import kotlinx.android.synthetic.main.fragment_profile_settings.txtSettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.io.Serializable

class ProfileSettingsFragment : Fragment(), View.OnClickListener {
    var preferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    private var profileDetailModel: UserProfileModel? = null
    lateinit var apiInterface: APIInterface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initData()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
    }

    override fun onResume() {
        super.onResume()
        userProfileDetails()
    }

    private fun initView(view: View) {
        txtContactUs.setOnClickListener(this)
        txtHelp.setOnClickListener(this)
        txtAboutUs.setOnClickListener(this)
        txtLogout.setOnClickListener(this)
        txtLinktoTv.setOnClickListener(this)
        txtTermsCondition.setOnClickListener(this)
        txtSettings.setOnClickListener(this)
        txtPrivacy.setOnClickListener(this)
        imgEditProfile.setOnClickListener(this)
        txtCookies.setOnClickListener(this)
        txtDeleteAccount.setOnClickListener(this)
    }

    private fun initData() {
        preferences = PreferenceManager.getDefaultSharedPreferences(requireActivity())
        txtName!!.text = preferences!!.getString("username", null)
        txtAppVersion!!.text = "Version : " + BuildConfig.VERSION_NAME
        back_btn!!.setOnClickListener { requireActivity().onBackPressed() }
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.txtContactUs -> {
                intent = Intent(activity, WebViewActivity::class.java)
                intent.putExtra("urlToLoad", "https://www.plexigo.com/faq")
                startActivity(intent)
            }
            R.id.txtAboutUs -> {
                intent = Intent(activity, WebViewActivity::class.java)
                intent.putExtra("urlToLoad", "https://www.plexigo.com/about-us-1")
                startActivity(intent)
            }
            R.id.txtHelp -> {
                intent = Intent(activity, WebViewActivity::class.java)
                intent.putExtra("urlToLoad", "https://www.plexigo.com/help")
                startActivity(intent)
            }
            R.id.txtLogout -> confirmSignOut()
            R.id.txtLinktoTv -> authenticateCode()
            R.id.txtTermsCondition -> {
                intent = Intent(activity, WebViewActivity::class.java)
                intent.putExtra("urlToLoad", "https://plexigo.com/terms-condition")
                startActivity(intent)
            }
            R.id.txtPrivacy -> {
                intent = Intent(activity, WebViewActivity::class.java)
                intent.putExtra("urlToLoad", "https://plexigo.com/privacy-policy")
                startActivity(intent)
            }
            R.id.imgEditProfile -> {
                intent = Intent(activity, EditProfileActivity::class.java)
                intent.putExtra("profileDetail", profileDetailModel as Serializable)
                startActivity(intent)
            }
            R.id.txtCookies -> {
                intent = Intent(activity, WebViewActivity::class.java)
                intent.putExtra("urlToLoad", "https://www.plexigo.com/cookies-policy")
                startActivity(intent)
            }
            R.id.txtDeleteAccount -> confirmDeleteAccount()
        }
    }

    private fun confirmDeleteAccount() {
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
        txtTitle.text = "Delete Account?"
        txtTitle.textSize = 16f
        edtPlayListName.visibility = View.GONE
        btnSave.text = "Yes"
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            deleteAccount()
            pwindo.dismiss()
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    private fun deleteAccount(){
        showLoader()
        val request = QuickPickDataRequest(Integer.valueOf(AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.deleteAccount(request)
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
                            logout()
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



    private fun logout() {
        try {
            editor = preferences!!.edit()
            editor?.remove("userid")
            editor?.remove("username")
            editor?.remove("authtoken")
            editor?.remove("emailId")
            editor?.remove("mobileNo")
            editor?.apply()
            AppConstants.isUserLoggedIn = false
            AppConstants.UserId = null
            val intent = Intent(activity, NewHomeActivity::class.java)
            intent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
            startActivity(intent)
        } catch (e: Exception) {
        }
    }

    private fun authenticateCode() {
        val i = Intent(activity, VerifyAuthCodeActivity::class.java)
        startActivity(i)
    }

    private fun confirmSignOut() {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Are you sure you want to Logout ?")
        builder.setCancelable(true)
        builder.setPositiveButton(
            "Yes"
        ) { dialog, id ->
            dialog.cancel()
            logout()
        }
        builder.setNegativeButton(
            "No"
        ) { dialog, id -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
        val nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE)
        nbutton.setTextColor(requireActivity().resources.getColor(R.color.colorAccent))
        val pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE)
        pbutton.setTextColor(requireActivity().resources.getColor(R.color.colorAccent))
    }

    //This is for Headers If You Needed
    private fun userProfileDetails(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getUserProfile(AppConstants.UserId!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            profileDetailModel =
                                responseModel.data.userprofile[0]
                            txtPlaylistNumber!!.text =
                                """${if (TextUtils.isEmpty(profileDetailModel?.playlistCount)) "0" else profileDetailModel?.playlistCount} 
 Playlist"""
                            txtFollowerNumber!!.text =
                                """${if (TextUtils.isEmpty(profileDetailModel?.followerCount)) "0" else profileDetailModel?.followerCount} 
 Followers"""
                            txtFollowingNumber!!.text =
                                """${if (TextUtils.isEmpty(profileDetailModel?.followingCount)) "0" else profileDetailModel?.followingCount} 
 Following"""
                            if (TextUtils.isEmpty(profileDetailModel!!.imagePath)) {
                                GlideApp
                                    .with(requireContext())
                                    .load("https://plexigostatic1.s3.ap-south-1.amazonaws.com/DefaultPosters/Defaultuser31X31.png")
                                    .circleCrop()
                                    .placeholder(R.drawable.plexigo_new_transperent_logo)
                                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                                    .skipMemoryCache(true)
                                    .into(imgUser)
                            } else {
                                GlideApp
                                    .with(requireContext())
                                    .load(profileDetailModel!!.imagePath)
                                    .circleCrop()
                                    .placeholder(R.drawable.plexigo_new_transperent_logo)
                                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                                    .skipMemoryCache(true)
                                    .into(imgUser)
                            }
                            AppConstants.preferredGenre = null
                            AppConstants.preferredGenre = profileDetailModel?.preferenceGenre
                            AppConstants.preferredLanguages = null
                            AppConstants.preferredLanguages =
                                profileDetailModel?.preferenceLanguage
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
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = requireFragmentManager().beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.isCancelable = false
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
        fun newInstance(): ProfileSettingsFragment {
            val args = Bundle()
            val fragment = ProfileSettingsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
