package com.release.plexigo.activity

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.release.plexigo.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val url = intent.getStringExtra("urlToLoad")
        webview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progress.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                progress.visibility = View.GONE
                back_btn.visibility = View.VISIBLE
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(this@WebViewActivity, description, Toast.LENGTH_SHORT).show()
            }

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                var url = url
                return if (url.startsWith("tel:")) {
                    val tel = Intent(Intent.ACTION_DIAL, Uri.parse(url))
                    startActivity(tel)
                    true
                } else if (url.contains("mailto:")) {
                    view.context.startActivity(
                        Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    )
                    true
                } else {
                    if (url.endsWith("pdf")) {
                        url = "https://drive.google.com/viewerng/viewer?embedded=true&url=$url"
                    }
                    view.loadUrl(url)
                    true
                }
            }
        }
        webview.settings.javaScriptEnabled = true
        webview.settings.allowFileAccess = true
        webview.settings.domStorageEnabled = true // Open DOM storage function
        webview.webChromeClient = WebChromeClient()
        webview.loadUrl(url!!)
        back_btn.setOnClickListener { onBackPressed() }
    }

    override fun onBackPressed() {
        if (webview!!.canGoBack()) {
            webview!!.goBack()
            return
        }
        super.onBackPressed()
    }
}