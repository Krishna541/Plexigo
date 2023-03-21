package com.release.plexigo.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Bundle
import android.text.TextUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import kotlinx.android.synthetic.main.activity_web_payment.*

class WebPaymentActivity : AppCompatActivity() {
    var userid: String? = null
    var movieid: String? = null
    var amount: String? = null
    var plan: String? = null
    var subscriptionId = 0
    var isSvodPurchase = false
    var sharedPreferences: SharedPreferences? = null
    var IsUSD = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_payment)
        userid = intent.getStringExtra("userid")
        movieid = intent.getStringExtra("movieid")
        amount = intent.getStringExtra("amount")
        subscriptionId = intent.getIntExtra("subscriptionId", 0)
        isSvodPurchase = intent.getBooleanExtra("isSvodPurchase", false)
        plan = intent.getStringExtra("plan")
        if (intent.hasExtra("currency") && intent.getStringExtra("currency") != null && intent.getStringExtra(
                "currency"
            ) == "USD"
        ) {
            IsUSD = true
        }
        //        amount="1";
        if (!isSvodPurchase && (userid == null || movieid == null)) {
            return
        }
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        try {
            webview.setWebViewClient(object : WebViewClient() {
                override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    if (url.contains(WsConstants.PaymentSuccess)) {
                        val ij = intent
                        setResult(200, ij)
                        finish()
                    } else if (url.contains(WsConstants.PaymentFailure)) {
                        val ij = intent
                        setResult(400, ij)
                        finish()
                    } else if (url.contains(WsConstants.PaymentCancel)) {
                        val ij = intent
                        setResult(413, ij)
                        finish()
                    } else {
//                        Showloader();
                    }
                }

                override fun onPageFinished(view: WebView, url: String) {
                    // hide print and view logs button by class name
//                    HideLoader();
//                    Log.d("ganesh", url);
                }
            })

//            String s= AppConstants.paymenturl +"?user_id="+userid+"&movie_id="+movieid+"&amount="+amount;
            var paymentUrl: String? = ""
            if (isSvodPurchase) {
                paymentUrl += WsConstants.svodPaymentUrl
                paymentUrl += "?SubscriptionId=$subscriptionId&Plan=$plan"
            } else {
                paymentUrl += WsConstants.paymenturl
                paymentUrl += "?movie_id=$movieid"
            }
            paymentUrl += "&user_id=$userid&amount=$amount"
            val email = sharedPreferences!!.getString("emailId", null)
            if (!TextUtils.isEmpty(email)) {
                paymentUrl += "&billing_email=$email"
            }
            val mobileNo = sharedPreferences!!.getString("mobileNo", null)
            if (!TextUtils.isEmpty(email)) {
                paymentUrl += "&billing_tel=$mobileNo"
            }
            paymentUrl += if (IsUSD) {
                "&currency=USD"
            } else {
                "&currency=INR"
            }
            paymentUrl += "&app_name=PLEXIGO"
            webview.loadUrl(paymentUrl!!)
            webview.getSettings().loadWithOverviewMode = true
            webview.getSettings().useWideViewPort = true
            webview.getSettings().builtInZoomControls = true
            webview.getSettings().javaScriptCanOpenWindowsAutomatically = true
            webview.getSettings().domStorageEnabled = true
            webview.getSettings().javaScriptEnabled = true
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun askexitpopup() {
        val builder1 = AlertDialog.Builder(this@WebPaymentActivity)
        builder1.setMessage("Are you sure you want cancel this transaction ?")
        builder1.setCancelable(true)
        builder1.setPositiveButton(
            "Yes"
        ) { dialog, id ->
            dialog.cancel()
            val ij = intent
            setResult(11, ij)
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

    override fun onBackPressed() {
        if (webview!!.canGoBack()) {
            webview!!.goBack()
        } else {
            askexitpopup()
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

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}