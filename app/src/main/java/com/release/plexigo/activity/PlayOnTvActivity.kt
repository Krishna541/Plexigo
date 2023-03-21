package com.release.plexigo.activity

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GpsTracker
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.SearchContentListAdapter
import com.release.plexigo.models.GpsCoordinatesRequest
import com.release.plexigo.models.MovieModel
import com.release.plexigo.models.SearchMoviesByActorRequest
import com.release.plexigo.models.UpdateRequestApprovedAPiRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_cast_detail.*
import kotlinx.android.synthetic.main.content_play_on_tv.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

class PlayOnTvActivity : AppCompatActivity() {
    var queue: RequestQueue? = null
    var requestCode = 2002
    var requestID = 0
    val SUCCESS = "Success"
    val FAILED = "Failed"
    val ABORT = "Abort"
    val TIMEOUT = "TimeOut"
    private var Status: String? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (this.requestCode == requestCode) {
            if (resultCode == 200) { //success
                Toast.makeText(this, "Payment Success!", Toast.LENGTH_SHORT).show()
                Status = SUCCESS
                UpdateRequestApprovalApi("Success")
            } else if (resultCode == 400) { //failure
                Status = FAILED
                Toast.makeText(this, "Transaction failed! Please try again", Toast.LENGTH_SHORT)
                    .show()
                UpdateRequestApprovalApi("Failed")
            } else if (resultCode == 413) { // aborted
                Status = ABORT
                Toast.makeText(this, "Transaction cancelled !", Toast.LENGTH_SHORT).show()
                UpdateRequestApprovalApi("Cancelled")
            } else if (resultCode == 11) { //back pressed from payment page by user
                //temporary
//                Status = SUCCESS;
//                UpdateRequestApprovalApi();
                Toast.makeText(this, "Transaction cancelled !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_play_on_tv)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Watch On TV"
        queue = Volley.newRequestQueue(this@PlayOnTvActivity)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener(View.OnClickListener { onBackPressed() })
        send_gps.setOnClickListener(View.OnClickListener {
            if (AppConstants.UserLatitude != null && AppConstants.UserLongitude != null) {
                CheckGPSContentValidApi()
            } else {
                checkLocationPermission()
            }
        })

    }

    private fun checkLocationPermission() {
        try {
            if (ContextCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    101
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            101 -> {


                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty()
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    val gpsTracker = GpsTracker(this@PlayOnTvActivity, null)
                    if (gpsTracker.canGetLocation()) {
                        AppConstants.UserLatitude = gpsTracker.latitude
                        AppConstants.UserLongitude = gpsTracker.longitude
                        CheckGPSContentValidApi()
                    } else {
                        gpsTracker.showSettingsAlert()
                    }
                } else {
                    Toast.makeText(
                        this@PlayOnTvActivity,
                        "Please enable location access to play content",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return
            }
        }
    }

    private fun CheckGPSContentValidApi(){
        Showloader()
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request = GpsCoordinatesRequest(AppConstants.UserLatitude.toString(),AppConstants.UserLongitude.toString(),Integer.valueOf(AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.checkGPSContentValidApi(request)
            withContext(Dispatchers.Main){
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val json = JSONObject(response.body()!!.toString())
                        val contentid = json.getInt("contentID")
                        val ppvRateINR = json.getInt("ppvRateINR").toString()
                        requestID = json.getInt("requestID")
                        Toast.makeText(
                            this@PlayOnTvActivity,
                            "Request ID $requestID",
                            Toast.LENGTH_SHORT
                        ).show()
                        val ip = Intent(this@PlayOnTvActivity, WebPaymentActivity::class.java)
                        ip.putExtra("movieid", contentid.toString())
                        ip.putExtra("userid", AppConstants.UserId)
                        ip.putExtra("amount", ppvRateINR)
                        startActivityForResult(ip, requestCode)
                    } else { //Video not accessible
                        val json = JSONObject(response.body()!!.toString())
                        Toast.makeText(
                            this@PlayOnTvActivity,
                            "" + json.getString("message"),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlayOnTvActivity, "${e.message}", Toast.LENGTH_SHORT).show()
                } catch (error: Throwable) {
                    HideLoader()
                    if (error is TimeoutError) {
                        Toast.makeText(
                            this@PlayOnTvActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (error.cause is IOException) {
                        Toast.makeText(
                            this@PlayOnTvActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(this@PlayOnTvActivity, "" + error.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
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

    private fun UpdateRequestApprovalApi(status: String){
        Showloader()
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request = UpdateRequestApprovedAPiRequest(requestID,Status!!)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.updaterequestApprovedStatus(request)
            withContext(Dispatchers.Main){
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            SuccessPopup(status)
                        }else{
                            Toast.makeText(
                                this@PlayOnTvActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PlayOnTvActivity, "${e.message}", Toast.LENGTH_SHORT).show()
                } catch (e: Throwable) {
                    Toast.makeText(this@PlayOnTvActivity, "${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun SuccessPopup(status: String) {
        val builder1 = AlertDialog.Builder(this@PlayOnTvActivity)
        builder1.setMessage(status)
        builder1.setCancelable(true)
        builder1.setPositiveButton(
            "OK"
        ) { dialog, id ->
            dialog.cancel()
            finish()
        }
        val alert11 = builder1.create()
        alert11.show()
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}