package com.release.plexigo.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.android.volley.*
import com.android.volley.toolbox.Volley
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.R
import com.release.plexigo.models.RegistrationRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var queue: RequestQueue? = null
    lateinit var apiInterface: APIInterface
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        queue = Volley.newRequestQueue(this@RegisterActivity)
        register.setOnClickListener {
            val usertext = username.text.toString().trim { it <= ' ' }
            val mobiletext = mobile.text.toString().trim { it <= ' ' }
            val emailtext = email.text.toString().trim { it <= ' ' }
            if (!usertext.equals("", ignoreCase = true)) {
                if (!mobiletext.equals("", ignoreCase = true)) {
                    if (mobiletext.length in 6..15) {
                        if (!emailtext.equals("", ignoreCase = true)) {
                            if (isValidEmailAddress(emailtext)) {
                                RegisterApi(
                                    usertext,
                                    emailtext,
                                    countryCodePicker.getSelectedCountryCode(),
                                    mobiletext
                                )
                            } else {
                                email.setError("Please enter valid Email")
                            }
                        } else {
                            email.setError("Please enter Email")
                        }
                    } else {
                        mobile.setError("Phone number should be 6 and 15 digit")
                    }
                } else {
                    mobile.setError("Please enter Mobile number.")
                }
            } else {
                username.setError("Please enter Username")
            }
        }

/*
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
*/tvLogin.setOnClickListener { finish() }
        login.setOnClickListener(View.OnClickListener { finish() })
    }

    fun RegisterApi(uname: String?, email: String?, countryCode: String?, mobileNo: String?){
        Showloader()
        val request = RegistrationRequest(uname!!,email!!,countryCode!!,mobileNo!!)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.registrationApi(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            Toast.makeText(this@RegisterActivity, "" + responseModel.data.message, Toast.LENGTH_SHORT)
                                .show()

                            val intent = Intent(
                                this@RegisterActivity,
                                OtpValidationActivity::class.java
                            )
                            intent.putExtra("phoneNumber", mobileNo)
                            intent.putExtra("countryCode", countryCode)
                            intent.putExtra("isRegister", true)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@RegisterActivity, "" + responseModel?.data?.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@RegisterActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@RegisterActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@RegisterActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@RegisterActivity,
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
        customProgressDialog!!.setCancelable(false)
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}