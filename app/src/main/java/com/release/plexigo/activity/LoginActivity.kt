package com.release.plexigo.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.android.volley.*
import com.android.volley.toolbox.Volley
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.R
import com.release.plexigo.models.LoginApiRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var ReloadafterLogin = true
    var queue: RequestQueue? = null
    lateinit var apiInterface: APIInterface
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        if (intent.hasExtra("reload") && intent.getStringExtra("reload")
                .equals("false", ignoreCase = true)
        ) {
            ReloadafterLogin = false
        }
        val tvSignUp = findViewById<TextView>(R.id.tvSignUp)

//        close_btn = findViewById(R.id.close_btn);
        queue = Volley.newRequestQueue(this@LoginActivity)
        login.setOnClickListener(View.OnClickListener {
            val phoneNo = mobile.text.toString().trim { it <= ' ' }
            val countryCode = countryCodePicker.selectedCountryCode
            if (!TextUtils.isEmpty(phoneNo) && phoneNo.isNotEmpty()) {
                if (phoneNo.length in 6..15) {
                    // requestPermissions(); //sunil
                    loginApi(countryCode, phoneNo)
                } else {
                    mobile.error = "Phone number should be 6 and 15 digit"
                }
            } else {
                mobile.error = "Enter Mobile Number"
            }
        })
        register.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        })
        tvSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        forgot_password.setOnClickListener(View.OnClickListener {
            val ij = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(ij)
        })
    }

    private fun loginApi(countryCode: String, phoneNumber: String){
        Showloader()
        val request = LoginApiRequest(countryCode,phoneNumber)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.loginApi(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            Toast.makeText(
                                this@LoginActivity,
                                "" + responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(
                                this@LoginActivity,
                                OtpValidationActivity::class.java
                            )
                            intent.putExtra("phoneNumber", phoneNumber)
                            intent.putExtra("countryCode", countryCode)
                            startActivity(intent)

                        }else{
                            Toast.makeText(
                                this@LoginActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@LoginActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@LoginActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@LoginActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    fun isValidEmailAddress(email: String?): Boolean {
        val ePattern =
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
        val p = Pattern.compile(ePattern)
        val m = p.matcher(email)
        return m.matches()
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
        //    ImageView close_btn;
        var customProgressDialog: CustomProgressDialog? = null
    }
}