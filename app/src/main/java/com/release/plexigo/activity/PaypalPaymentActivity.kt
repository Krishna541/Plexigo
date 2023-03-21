package com.release.plexigo.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.release.plexigo.BuildConfig
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.models.PaypalOrderRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_paypal_payment.*
import kotlinx.android.synthetic.main.fragment_home_watchlist.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

class PaypalPaymentActivity : AppCompatActivity() {
    var userid: String? = null
    var movieid: String? = null
    var amount: String? = null
    var Currency: String? = null
    var CountryCode: String? = null
    private val CHROME_CUSTOM_TAB_REQUEST_CODE = 100
    var APPROVE_KEY = "approve"
    var IsPaypalRedirected = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paypal_payment)

//        progressbar = findViewById(R.id.progressbar);
//        message = findViewById(R.id.message);
        if (intent.data != null) {
            val params = intent.data!!.pathSegments
            //redirect back from paypal payment
            if (params[0] == "success") {
//                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                /*Intent ij = getIntent();
                setResult(200, ij);*/
                if (AppConstants.IsPaypalPaymentStarted) {
                    AppConstants.PaypalPaymentStatus = "success"
                }
                titletext.setText("Transaction Successful")
            } else if (params[0] == "failure") {
//                Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
                if (AppConstants.IsPaypalPaymentStarted) {
                    AppConstants.PaypalPaymentStatus = "failure"
                }
                titletext.setText("Transaction Failed")
            } else if (params[0] == "cancel") {
//                Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show();
                if (AppConstants.IsPaypalPaymentStarted) {
                    AppConstants.PaypalPaymentStatus = "cancel"
                }
                titletext.setText("Transaction Cancelled")
            }
            titlehelptext.setVisibility(View.INVISIBLE)
            redirectToContent()
        } else {
            //redirected from movie detail page to start paypal payment.
            /*if (getIntent().hasExtra("currency") && getIntent().getStringExtra("currency") != null && getIntent().getStringExtra("currency").equals("USD")) {
                Currency = "USD";
            } else {
                Currency = "INR";
            }*/
            userid = intent.getStringExtra("userid")
            movieid = intent.getStringExtra("movieid")
            amount = intent.getStringExtra("amount")
            Currency = intent.getStringExtra("currency")
            CountryCode = intent.getStringExtra("CountryCode")


//        String url ="http://www.google.com";
//        OpenIntent(url);
            CreateOrder()
        }
    }

    fun redirectToContent() {
        Handler().postDelayed({ finish() }, 500)
    }

    override fun onResume() {
        super.onResume()
        if (IsPaypalRedirected) {
            if (AppConstants.PaypalPaymentStatus == null) {
                AppConstants.PaypalPaymentStatus = "cancel"
                finish()
            }
        }
    }

    override fun onBackPressed() {
//        super.onBackPressed();
        if (AppConstants.PaypalPaymentStatus == null) {
            askexitpopup()
        }
    }

    private fun askexitpopup() {
        val builder1 = AlertDialog.Builder(this@PaypalPaymentActivity)
        builder1.setMessage("Are you sure you want cancel this transaction ?")
        builder1.setCancelable(true)
        builder1.setPositiveButton(
            "Yes"
        ) { dialog, id ->
            dialog.cancel()
            AppConstants.PaypalPaymentStatus = "cancel"
            finish()
        }
        builder1.setNegativeButton(
            "No"
        ) { dialog, id -> dialog.cancel() }
        val alert = builder1.create()
        alert.show()
        val nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE)
        nbutton.setTextColor(resources.getColor(R.color.colorAccent))
        val pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE)
        pbutton.setTextColor(resources.getColor(R.color.colorAccent))
    }

    private fun CreateOrder(){
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request = PaypalOrderRequest(amount!!,userid!!,movieid!!,Currency!!,CountryCode!!)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.createPaypalPaymentOrder(request)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        var url: String? = null
                        val responseModel = response.body()
                        if (responseModel?.status == "CREATED" ) {
                                if(responseModel.links.size >  0){
                                    val links = responseModel.links
                                    for (i in 0 until links.size) {
                                        if (links[i].rel == APPROVE_KEY
                                        ) {
                                            url = links[i].href
                                            break
                                        }
                                    }
                                    if (url != null) {
                                        IsPaypalRedirected = true
                                        OpenIntent(url)
                                    }
                                }
                        }else {
                            Toast.makeText(
                                this@PaypalPaymentActivity,
                                "Error occured. Please try again",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@PaypalPaymentActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {

                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@PaypalPaymentActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@PaypalPaymentActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@PaypalPaymentActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }


    fun OpenIntent(url: String?) {
        val packageName = "com.android.chrome"
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        // check if chrome is installed if installed always open in chrome
        // so we can have OneTouch Feature !
        if (isPackageInstalled(packageName)) {
            customTabsIntent.intent.setPackage(packageName)
        }
        customTabsIntent.intent.data = Uri.parse(url)
        startActivityForResult(customTabsIntent.intent, CHROME_CUSTOM_TAB_REQUEST_CODE)
    }

    fun isPackageInstalled(packageName: String?): Boolean {
        return try {
            val packageManager = applicationContext.packageManager
            packageManager.getPackageInfo(packageName!!, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            Log.d("firing ", "Fire in the hole")
            false
        }
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}