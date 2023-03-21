package com.release.plexigo.Common

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.widget.Toast
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.activity.LoginActivity

class TokenExpire(var ctx: Context) {
    var editor: SharedPreferences.Editor? = null
    var preferences: SharedPreferences
    fun ClearData() {
        try {
            editor = preferences.edit()
            editor?.remove("userid")
            editor?.remove("username")
            editor?.remove("authtoken")
            editor?.remove("emailId")
            editor?.remove("mobileNo")
            editor?.apply()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        AppConstants.isUserLoggedIn = false
        AppConstants.UserId = null
        Toast.makeText(ctx, "Please Login to continue", Toast.LENGTH_SHORT).show()
        val intent = Intent(ctx, LoginActivity::class.java)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
        )
        ctx.startActivity(intent)
    }

    init {
        preferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    }
}
