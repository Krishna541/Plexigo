package com.release.plexigo.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.models.ForgotPasswordRequest
import com.release.plexigo.models.ResetPasswordRequest
import com.release.plexigo.models.SendVerificationCodeRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.util.regex.Pattern

class ForgotPasswordActivity : AppCompatActivity() {
    //    Toolbar toolbar;
    var email_text: String? = null
    var userId = 0
    var queue: RequestQueue? = null
    var doStep = 0 // 0 - enter email , 1 - enter code, 2-reset password;
    lateinit var apiInterface: APIInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)


        queue = Volley.newRequestQueue(this@ForgotPasswordActivity)

        apiInterface = APIClient.getClient("").create(APIInterface::class.java)

        submit.setOnClickListener(View.OnClickListener {
            if (doStep == 0) { //send email
                val emailtxt = email.getText().toString().trim { it <= ' ' }
                if (!emailtxt.isEmpty() && !emailtxt.equals("", ignoreCase = true)) {
                    if (isValidEmailAddress(emailtxt)) {
                        email_text = emailtxt
                        ForgotPassword()
                    } else {
                        email.error = "Please enter Valid Email"
                    }
                } else {
                    email.error = "Please enter Email"
                }
            } else if (doStep == 1) { // send verification code
                val verification_Code = verification_code.text.toString().trim { it <= ' ' }
                if (!verification_Code.isEmpty() && !verification_Code.equals(
                        "",
                        ignoreCase = true
                    )
                ) {
                    SendVerificationCode(Integer.valueOf(verification_Code))
                } else {
                    verification_code.error = "Please enter code"
                }
            } else if (doStep == 2) {
                val passtext = password.getText().toString()
                val confirmpasstext = confirm_password.getText().toString()
                if (passtext.length > 5) {
                    if (confirmpasstext.length > 5) {
                        if (passtext.equals(confirmpasstext, ignoreCase = true)) {
                            ResetPassword(passtext)
                        } else {
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "Passwords do not match",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            this@ForgotPasswordActivity,
                            "Re-entered Password must be at least 6 characters",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@ForgotPasswordActivity,
                        "Password must be at least 6 characters",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    fun isValidEmailAddress(email: String?): Boolean {
        val ePattern =
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
        val p = Pattern.compile(ePattern)
        val m = p.matcher(email)
        return m.matches()
    }

    fun ForgotPassword(){
        Showloader()
        val request = ForgotPasswordRequest(email_text!!)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.forgotPasswordApi(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "" + responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            verification_code!!.visibility = View.VISIBLE
                            email!!.isEnabled = false
                            doStep = 1 //verification code is enabled
                        }else{
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ForgotPasswordActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    Toast.makeText(this@ForgotPasswordActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    }

    private fun SendVerificationCode(code: Int){
        Showloader()
        val request = SendVerificationCodeRequest(email_text!!,code)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.sendVerificationCode(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                           if(responseModel.data.user != null){
                               userId = responseModel.data.user.userId
                               verification_code!!.isEnabled = false
                               email!!.isEnabled = false
                               password!!.visibility = View.VISIBLE
                               confirm_password!!.visibility = View.VISIBLE
                               doStep = 2 //Reset password is enabled
                           }
                        }else{
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ForgotPasswordActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    Toast.makeText(this@ForgotPasswordActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }


    private fun ResetPassword(passwordtext: String?){
        Showloader()
        val request = ResetPasswordRequest(userId,passwordtext!!)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.resetPassword(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "" + responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }else{
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ForgotPasswordActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    Toast.makeText(this@ForgotPasswordActivity, "${e.message}", Toast.LENGTH_SHORT)
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

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}