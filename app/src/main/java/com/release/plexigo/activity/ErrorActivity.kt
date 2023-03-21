package com.release.plexigo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import kotlinx.android.synthetic.main.activity_error.*

class ErrorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        api.text = WsConstants.isContentLock
        if (intent.getStringExtra("Lat") != null) {
            lat.setText("Lat   :   " + intent.getStringExtra("Lat"))
        }
        if (intent.getStringExtra("Long") != null) {
            longi.setText("Long   :   " + intent.getStringExtra("Long"))
        }
        if (intent.getStringExtra("ipAddress") != null) {
            ipadd.setText("ipAddress   :   " + intent.getStringExtra("ipAddress"))
        }
        if (intent.getStringExtra("contentId") != null) {
            contentid.setText("contentId   :   " + intent.getStringExtra("contentId"))
        }
        if (intent.getStringExtra("error") != null) {
            response.setText("error   :   " + intent.getStringExtra("error"))
        }
    }
}