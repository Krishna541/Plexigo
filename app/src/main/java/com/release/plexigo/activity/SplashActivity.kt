package com.release.plexigo.activity

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.android.volley.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.release.plexigo.BuildConfig
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import com.sendbird.android.SendBird
import io.branch.referral.Branch
import io.branch.referral.Branch.BranchReferralInitListener
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class SplashActivity : AppCompatActivity() {


    private val SENDBIRD_APP_ID = "4356DBE1-58E9-4FF0-9035-AC7E47BF7A68"
    var isForceUpdate = false
    lateinit var preferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    var fcmToken = ""
    lateinit var apiInterface: APIInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.statusBarColor = resources.getColor(android.R.color.black)
        }
        getFcmToken()
        try {
//            SDKInitializer.init(this, AppConstants.MuviToken);
//            MuviPlayer.init(this, AppConstants.MuviToken);
            //init sendbird chat sdk
            SendBird.init(SENDBIRD_APP_ID, this@SplashActivity)
            //            Branch.enableLogging();
//            Branch.getAutoInstance(SplashActivity.this);
        } catch (e: Exception) {
            e.printStackTrace()
        }
        Handler().postDelayed({
            imgLogo.setVisibility(View.VISIBLE)
            checkUpdate()
        }, 500)
        preferences = PreferenceManager.getDefaultSharedPreferences(this)
        editor = preferences.edit()
        editor.putBoolean("showOffersDialog", true).apply()
        editor.putBoolean("locationRationaleRequestDenied", true).apply()
    }

    @JvmName("getFcmToken1")
    fun getFcmToken(): String {
        FirebaseMessaging.getInstance().token
            .addOnFailureListener { e -> Log.d("Firebase Token error:", e.message.toString()) }
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.d("TAG", "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }
                fcmToken = task.result
                Log.d("FirebaseApp Token: ", fcmToken)
            })
        return fcmToken
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent) // if activity is in foreground (or in backstack but partially visible) launching the same // activity will skip onStart, handle this case with reInitSession
        Branch.sessionBuilder(this).withCallback(branchReferralInitListener).reInit()
    }

    override fun onStart() {
        super.onStart()
        Branch.sessionBuilder(this).withCallback(branchReferralInitListener)
            .withData(if (intent != null) intent.data else null).init()
    }

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog.show(ft, "dialog")
        customProgressDialog.setCancelable(false)
    }

    fun HideLoader() {
        if (customProgressDialog != null && customProgressDialog!!.isVisible) customProgressDialog!!.dismiss()
    }//This is for Headers If You Needed

    //success
    private fun appVersion(){
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getAppVersion()
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            //success
                            var minimumSupported = -1
                            var latestVersion = -1
                            for (i in 0 until responseModel.data.platforms.size) {
                                var platformFound = false
                                if(responseModel.data.platforms[i].platform.equals("android-mobile", ignoreCase = true)){
                                    val versions = responseModel.data.platforms[i].platformVersion
                                    for (j in versions.indices){
                                        minimumSupported = versions[j].minimumSupported.toInt()
                                        latestVersion = versions[j].latestVersion.toInt()
                                        platformFound = true
                                        break
                                    }
                                }
                                if (platformFound) {
                                    break
                                }
                            }
                            if (BuildConfig.VERSION_CODE >= latestVersion) {
                                checkOnBoardingCompleted()
                            } else {
                                isForceUpdate =
                                    BuildConfig.VERSION_CODE < minimumSupported
                                showForceUpdateDialog()
                            }
                        } else {
                            Toast.makeText(
                                this@SplashActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@SplashActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@SplashActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (e.cause is IOException) {
                        Toast.makeText(
                            this@SplashActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this@SplashActivity,
                            "" + e.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    checkOnBoardingCompleted()
                }
            }
        }

    }


    private fun showForceUpdateDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Update Available!")
        builder.setMessage("Please update your app to the latest available version.")
        builder.setCancelable(false)
        builder.setPositiveButton(
            "Update"
        ) { dialog, id -> navigateToPlayStore() }
        if (!isForceUpdate) {
            builder.setNegativeButton(
                "Skip"
            ) { dialog, id -> checkOnBoardingCompleted() }
        }
        val alert = builder.create()
        alert.show()
        val nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE)
        nbutton.setTextColor(resources.getColor(R.color.colorAccent))
        val pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE)
        pbutton.setTextColor(resources.getColor(R.color.colorAccent))
    }


    private fun checkOnBoardingCompleted(){
        if (!TextUtils.isEmpty(PreferenceManager.getDefaultSharedPreferences(this).getString("userid", null))){
            AppConstants.UserId = PreferenceManager.getDefaultSharedPreferences(this).getString("userid", null)
            Showloader()
            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getOnBoardingPollComplete(AppConstants.UserId!!.toInt())
                withContext(Dispatchers.Main) {
                    try {
                        HideLoader()
                        if (response.isSuccessful) {
                            val responseModel = response.body()
                            if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                                val onBoardingComplete = responseModel.data.onboardingComplete
                                for (i in onBoardingComplete.indices) {
                                    if (onBoardingComplete[i].onboardingComplete.equals("no",ignoreCase = true)
                                    ) {
                                        navigateToOnBoarding()
                                    } else {
                                        navigateToDashboard()
                                    }
                                }
                            }else {
                                navigateToDashboard()
                            }
                        }
                    } catch (e: HttpException) {
                        Toast.makeText(this@SplashActivity, "${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    } catch (error: Throwable) {
                        HideLoader()
                        if (error is TimeoutError) {
                            Toast.makeText(
                                this@SplashActivity,
                                R.string.timeout_message,
                                Toast.LENGTH_SHORT
                            ).show()
                        } else if (error.cause is IOException) {
                            Toast.makeText(
                                this@SplashActivity,
                                getString(R.string.internet_not_available),
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                this@SplashActivity,
                                "" + error.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        navigateToDashboard()
                    }
                }
            }

        } else {
            navigateToDashboard()
        }
    }

    fun navigateToDashboard() {
        val intent = Intent(this@SplashActivity, NewHomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun navigateToOnBoarding() {
        val intent = Intent(this@SplashActivity, OnBoardingActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun checkUpdate() {
        Handler().postDelayed({ appVersion() }, 1000)
    }

    fun navigateToPlayStore() {
        val appPackageName = packageName // getPackageName() from Context or Activity object
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$appPackageName")
                )
            )
        } catch (anfe: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                )
            )
        }
    }

    private val branchReferralInitListener = BranchReferralInitListener { linkProperties, error ->
        // do stuff with deep link data (nav to page, display content, etc) }
    }

    companion object {
        lateinit var customProgressDialog: CustomProgressDialog
    }
}