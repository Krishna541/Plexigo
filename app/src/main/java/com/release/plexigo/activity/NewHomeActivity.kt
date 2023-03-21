package com.release.plexigo.activity

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.preference.PreferenceManager
import com.android.volley.RequestQueue
import com.android.volley.TimeoutError
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GpsTracker
import com.release.plexigo.Common.GpsTracker.OnNegativeButtonClicked
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.fragment.*
import com.release.plexigo.models.GpsCoordinatesRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_new_home.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
import pub.devrel.easypermissions.EasyPermissions.RationaleCallbacks
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * Created by Tarak Bhawalkar on Oct 01, 2020 at 17:30
 */
class NewHomeActivity : AppCompatActivity(),
    OnNegativeButtonClicked, PermissionCallbacks, RationaleCallbacks {
    lateinit var preferences: SharedPreferences
    var editor: SharedPreferences.Editor? = null
    var gpsTracker: GpsTracker? = null
    var queue: RequestQueue? = null
    lateinit var apiInterface: APIInterface
    var navigationItemReselectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_search -> replaceFragment(SearchFragment.newInstance(), true)
                R.id.action_new -> replaceFragment(HomeLatestReleasesFragment.newInstance(), true)
                R.id.action_home -> clearFragmentStack()
                R.id.action_channel -> replaceFragment(HomeChannelFragment.newInstance(), true)
                R.id.action_profile -> if (AppConstants.isUserLoggedIn) {
                    replaceFragment(HomeProfileFragment.newInstance(), true)
                } else {
                    val intent1 = Intent(this@NewHomeActivity, LoginActivity::class.java)
                    startActivity(intent1)
                }
            }
            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_home)
        //        hideSystemUI();
        initView()
        initData()
        queue = Volley.newRequestQueue(this)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.layoutContainerHome, NewHomeFragment.newInstance())
        transaction.commit()
        if (!intent.getBooleanExtra("OPEN_PROFILE_PAGE", true)) {
            hideToolbar()
            bottomNavigationView!!.selectedItemId = R.id.action_profile
        }


        supportFragmentManager.addOnBackStackChangedListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.layoutContainerHome)
            if (fragment != null) {
                bottomNavigationView!!.setOnNavigationItemSelectedListener(
                    null
                )
                if (fragment is NewHomeFragment) {
                    bottomNavigationView!!.selectedItemId =
                        R.id.action_home
                }
                if (fragment is SearchFragment) {
                    bottomNavigationView!!.selectedItemId =
                        R.id.action_search
                }
                if (fragment is HomeWatchlistFragment) {
                    bottomNavigationView!!.selectedItemId =
                        R.id.action_new
                }
                if (fragment is HomeChannelFragment) {
                    bottomNavigationView!!.selectedItemId =
                        R.id.action_channel
                }
                if (fragment is HomeProfileFragment) {
                    bottomNavigationView!!.selectedItemId =
                        R.id.action_profile
                }
                bottomNavigationView!!.setOnNavigationItemSelectedListener(
                    navigationItemReselectedListener
                )
            }
        }
        preferences = PreferenceManager.getDefaultSharedPreferences(this)
        AppConstants.UserId = preferences.getString("userid", null)
        AppConstants.AuthToken = preferences.getString("authtoken", null)
        AppConstants.username = preferences.getString("username", null)
        if (AppConstants.UserId != null) {
            AppConstants.isUserLoggedIn = true
        } else {
            AppConstants.isUserLoggedIn = false
        }
        if (AppConstants.isUserLoggedIn && preferences.getBoolean(
                "locationRationaleRequestDenied",
                true
            )
        ) checkLocationPermission()
    }

    val deviceID: String
        get() = Settings.Secure.getString(
            contentResolver,
            Settings.Secure.ANDROID_ID
        )

    private fun hideSystemUI() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }

    private fun initView() {

        bottomNavigationView.selectedItemId = R.id.action_home

        txtQuickPick.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@NewHomeActivity,
                    QuickPickActivity::class.java
                )
            )
        })
    }

    private fun initData() {
        bottomNavigationView!!.setOnNavigationItemSelectedListener(navigationItemReselectedListener)
    }

    private fun clearFragmentStack() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction: FragmentTransaction
        transaction = supportFragmentManager.beginTransaction()
        if (addToBackStack) transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.replace(R.id.layoutContainerHome, fragment)
        transaction.commit()
    }

    fun addFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction: FragmentTransaction
        transaction = supportFragmentManager.beginTransaction()
        if (addToBackStack) transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.add(R.id.layoutContainerHome, fragment)
        transaction.commit()
    }

    private fun checkLocationPermission() {
        val perms = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        if (EasyPermissions.hasPermissions(this, *perms)) {
            // Already have permission, do the thing
            // ...
            gpsTracker = GpsTracker(this@NewHomeActivity, this@NewHomeActivity)
            if (gpsTracker!!.canGetLocation()) {
                AppConstants.UserLatitude = gpsTracker!!.latitude
                AppConstants.UserLongitude = gpsTracker!!.longitude
                if (AppConstants.isUserLoggedIn) {
                    postGPSCordinates()
                }
            } else {
                gpsTracker!!.showSettingsAlert()
            }
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(
                this, getString(R.string.location_rationale),
                101, *perms
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE && preferences!!.getBoolean(
                "locationRationaleRequestDenied",
                true
            )
            && resultCode == RESULT_OK
        ) {
            checkLocationPermission()
        }
    }

    fun postGPSCordinates() {
        Showloader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request = GpsCoordinatesRequest(
            AppConstants.UserLatitude.toString(),
            AppConstants.UserLongitude.toString(),
            Integer.valueOf(AppConstants.UserId)
        )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.postGpsCoordinates(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {

                        } else {
                            Toast.makeText(
                                this@NewHomeActivity,
                                "GPS sending failed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@NewHomeActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@NewHomeActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@NewHomeActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@NewHomeActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()
        if (AppConstants.isUserLoggedIn) {
            val perms: MutableList<String> = ArrayList()
            perms.add(Manifest.permission.ACCESS_FINE_LOCATION)
            if (!EasyPermissions.somePermissionPermanentlyDenied(this, perms)
                && preferences!!.getBoolean("locationRationaleRequestDenied", true)
            ) {
                checkLocationPermission()
            }
        }
    }

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.setCancelable(false)
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        gpsTracker = GpsTracker(this@NewHomeActivity, this@NewHomeActivity)
        if (gpsTracker!!.canGetLocation()) {
            AppConstants.UserLatitude = gpsTracker!!.latitude
            AppConstants.UserLongitude = gpsTracker!!.longitude
            if (AppConstants.isUserLoggedIn) {
                postGPSCordinates()
            }
        } else {
            gpsTracker!!.showSettingsAlert()
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else {
            permissionRequestNegativeButtonClicked()
        }
    }

    fun showToolbar() {
        findViewById<View>(R.id.toolbar).visibility = View.VISIBLE
    }

    fun hideToolbar() {
        findViewById<View>(R.id.toolbar).visibility = View.GONE
    }

    override fun permissionRequestNegativeButtonClicked() {
        if (AppConstants.isUserLoggedIn) {
            AppConstants.UserLatitude = 0.0
            AppConstants.UserLongitude = 0.0
            postGPSCordinates()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        editor = preferences!!.edit()
        editor!!.remove("showOffersDialog").apply()
        editor!!.remove("locationRationaleRequestDenied").apply()
    }

    override fun onRationaleAccepted(requestCode: Int) {}
    override fun onRationaleDenied(requestCode: Int) {
        editor = preferences!!.edit()
        editor!!.putBoolean("locationRationaleRequestDenied", false).apply()
    }

    companion object {
        private var bottomNavigationView: BottomNavigationView? = null
        var customProgressDialog: CustomProgressDialog? = null
        var mapper: ObjectMapper? = null
            get() {
                if (field != null) {
                    return field
                }
                try {
                    lock.lock()
                    if (field == null) {
                        field = ObjectMapper()
                        field!!.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    }
                    lock.unlock()
                } catch (ex: Exception) {
                    if (ex != null) ex.printStackTrace()
                }
                return field
            }
            private set
        private val lock: Lock = ReentrantLock()
        private const val TAG = "NewHomeActivity"
        fun setChannelsPage() {
            bottomNavigationView!!.selectedItemId = R.id.action_channel
        }
    }
}