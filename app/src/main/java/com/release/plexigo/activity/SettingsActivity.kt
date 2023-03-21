package com.release.plexigo.activity

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import kotlinx.android.synthetic.main.settings_activity.*

class SettingsActivity : AppCompatActivity(), View.OnClickListener {

    var preferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Settings"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener(View.OnClickListener { onBackPressed() })
        loginregisterlayout.setOnClickListener(this)
        editprofilelayout.setOnClickListener(this)
        playontvlayout.setOnClickListener(this)
        preferences = PreferenceManager.getDefaultSharedPreferences(this)
        AppConstants.UserId = preferences?.getString("userid", "0")
        AppConstants.username = preferences?.getString("username", null)
        if (AppConstants.UserId != null && !AppConstants.UserId.equals("0", ignoreCase = true)) {
            loginorregister.text = "Logged in as " + AppConstants.username
            login_helper.text = "Log in with a different account"
            editprofilelayout.visibility = View.VISIBLE
            editprofileborder.visibility = View.VISIBLE
            playontvlayout.visibility = View.VISIBLE
            playontvborder.visibility = View.VISIBLE
        } else {
            loginorregister.text = "Login / Register"
            login_helper.visibility = View.GONE
            editprofilelayout.visibility = View.GONE
            editprofileborder.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        if (AppConstants.UserId != null && !AppConstants.UserId.equals("0", ignoreCase = true)) {
            loginorregister!!.text = "Logged in as " + AppConstants.username
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.loginregisterlayout -> if (AppConstants.UserId != null && !AppConstants.UserId.equals(
                    "0",
                    ignoreCase = true
                )
            ) {
                askexitpopup()
            } else {
                val intent = Intent(this@SettingsActivity, LoginActivity::class.java)
                startActivity(intent)
            }
            R.id.editprofilelayout -> {
                val ij = Intent(this@SettingsActivity, EditProfileActivity::class.java)
                startActivity(ij)
            }
            R.id.playontvlayout -> {
                val ijk = Intent(this@SettingsActivity, PlayOnTvActivity::class.java)
                startActivity(ijk)
            }
        }
    }

    private fun askexitpopup() {
        val builder1 = AlertDialog.Builder(this@SettingsActivity)
        builder1.setMessage("Are you sure you want to sign out ?")
        builder1.setCancelable(true)
        builder1.setPositiveButton(
            "Yes"
        ) { dialog, id ->
            dialog.cancel()
            logout()
        }
        builder1.setNegativeButton(
            "No"
        ) { dialog, id -> dialog.cancel() }
        val alert11 = builder1.create()
        alert11.show()
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
            val intent = Intent(this@SettingsActivity, NewHomeActivity::class.java)
            intent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
            startActivity(intent)
        } catch (e: Exception) {
        }


        /*LogoutInput input = new LogoutInput();
        input.setAuthToken(AppConstants.MuviToken);
        String loginhistoryid = preferences.getString("login_history_id", "0");
        input.setLogin_history_id(loginhistoryid);

        LogoutAsync async = new LogoutAsync(input, new LogoutAsync.LogoutListener() {
            @Override
            public void onLogoutPreExecuteStarted() {
                Showloader();
            }

            @Override
            public void onLogoutPostExecuteCompleted(LogoutOutputModel outputModel, int code, String message, String response) {
                HideLoader();
                if(code == 200){
                    Toast.makeText(SettingsActivity.this, message, Toast.LENGTH_SHORT).show();
                    editor = preferences.edit();
                    editor.remove("userid");
                    editor.remove("username");
                    editor.remove("login_history_id");
                    editor.apply();
                    AppConstants.isUserLoggedIn = false;
                    AppConstants.UserId = null;
                    Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else{
                    Toast.makeText(SettingsActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        }, this);
        async.execute();*/
    }

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.isCancelable = false
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}