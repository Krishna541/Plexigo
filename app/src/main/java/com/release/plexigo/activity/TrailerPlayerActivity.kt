package com.release.plexigo.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.R
import kotlinx.android.synthetic.main.activity_trailer_player.*

class TrailerPlayerActivity : AppCompatActivity() {
    //    ProgressBar progressbar;
    var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trailer_player)
        url = intent.getStringExtra("TrailerUrl")
        Showloader()
        try {
            webview.setWebViewClient(object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    request: WebResourceRequest
                ): Boolean {
                    return super.shouldOverrideUrlLoading(view, request)
                }

                override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView, url: String) {
                    // hide print and view logs button by class name
                    HideLoader()
                    full_layout.setVisibility(View.GONE)
                    webview.setVisibility(View.VISIBLE)
                    //                    Log.d("ganesh", url);
                }
            })
            webview.setWebChromeClient(MyChrome())

//            String s= AppConstants.paymenturl +"?user_id="+userid+"&movie_id="+movieid+"&amount="+amount;
            webview.loadUrl(url!!)
            //            webview.getSettings().setLoadWithOverviewMode(true);
            webview.getSettings().useWideViewPort = true
            //            webview.getSettings().setBuiltInZoomControls(true);
//            webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            webview.getSettings().domStorageEnabled = true
            webview.getSettings().javaScriptEnabled = true
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    internal inner class MyChrome : WebChromeClient() {
        private var mCustomView: View? = null
        private var mCustomViewCallback: CustomViewCallback? = null
        protected var mFullscreenContainer: FrameLayout? = null
        private var mOriginalOrientation = 0
        private var mOriginalSystemUiVisibility = 0
        override fun getDefaultVideoPoster(): Bitmap? {
            return if (mCustomView == null) {
                null
            } else BitmapFactory.decodeResource(applicationContext.resources, 2130837573)
        }

        override fun onHideCustomView() {
            (window.decorView as FrameLayout).removeView(mCustomView)
            mCustomView = null
            window.decorView.systemUiVisibility = mOriginalSystemUiVisibility
            requestedOrientation = mOriginalOrientation
            mCustomViewCallback!!.onCustomViewHidden()
            mCustomViewCallback = null
        }

        override fun onShowCustomView(
            paramView: View,
            paramCustomViewCallback: CustomViewCallback
        ) {
            if (mCustomView != null) {
                onHideCustomView()
                return
            }
            mCustomView = paramView
            mOriginalSystemUiVisibility = window.decorView.systemUiVisibility
            mOriginalOrientation = requestedOrientation
            mCustomViewCallback = paramCustomViewCallback
            (window.decorView as FrameLayout).addView(mCustomView, FrameLayout.LayoutParams(-1, -1))
            window.decorView.systemUiVisibility = 3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
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