package com.release.plexigo.activity

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.KeyEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.android.volley.TimeoutError
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.models.LoginApiRequest
import com.release.plexigo.models.VerifyOtpRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_otp_validation.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class OtpValidationActivity : AppCompatActivity() {
    private var countryCode: String? = null
    private var phoneNumber: String? = null
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var apiInterface: APIInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_validation)
        imgBtnBack.setOnClickListener { onBackPressed() }
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val intent = intent
        countryCode = intent.getStringExtra("countryCode")
        phoneNumber = intent.getStringExtra("phoneNumber")
        val isRegister = intent.getBooleanExtra("isRegister", false)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        if (isRegister) {
            singUpTnc()
        } else {
            layoutTncSignup.visibility = View.GONE
        }
        val message =
            "Enter OTP Code sent to your Mobile number or Email ID.  +$countryCode$phoneNumber"
        val str = SpannableStringBuilder(message)
        str.setSpan(StyleSpan(Typeface.BOLD), 6, 14, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        str.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.colorAccent)),
            message.length - (countryCode!!.length + phoneNumber!!.length + 1),
            message.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        txtVerificationMessage.setText(str)
        initView()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }//This is for Headers If You Needed

    private fun singUpTnc(){
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getSignUpTermsAndCondition()
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            txtTncMessage!!.text = responseModel.data.tacText
                            val link = responseModel.data.tacLink
                            val tacLink = "| Terms & Conditions |"
                            val str = SpannableStringBuilder(tacLink)
                            str.setSpan(
                                ForegroundColorSpan(resources.getColor(R.color.colorAccent)),
                                2,
                                tacLink.length - 2,
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE
                            )
                            val clickableSpan: ClickableSpan = object : ClickableSpan() {
                                override fun onClick(textView: View) {
                                    val intent = Intent(
                                        this@OtpValidationActivity,
                                        WebViewActivity::class.java
                                    )
                                    intent.putExtra("urlToLoad", link)
                                    startActivity(intent)
                                }

                                override fun updateDrawState(ds: TextPaint) {
                                    super.updateDrawState(ds)
                                    ds.isUnderlineText = true
                                    ds.linkColor = resources.getColor(R.color.colorAccent)
                                }
                            }
                            str.setSpan(
                                clickableSpan,
                                2,
                                tacLink.length - 2,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            str.setSpan(
                                ForegroundColorSpan(resources.getColor(R.color.colorAccent)),
                                2,
                                tacLink.length - 2,
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE
                            )
                            txtTncLink!!.text = str
                            txtTncLink!!.movementMethod = LinkMovementMethod.getInstance()
                            txtTncLink!!.highlightColor = Color.TRANSPARENT
                            txtTncLink!!.text = str
                            layoutTncSignup!!.visibility = View.VISIBLE
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@OtpValidationActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@OtpValidationActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@OtpValidationActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@OtpValidationActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun initView() {
        edtOtp1!!.requestFocus()
        edtOtp1!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().length == 1) {
                    edtOtp2!!.requestFocus()
                } else {
                    if (s.toString().length == 2) {
                        edtOtp2!!.setText(s[1].toString())
                    }
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        edtOtp2!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().length == 1) {
                    edtOtp3!!.requestFocus()
                } else {
                    if (TextUtils.isEmpty(edtOtp1!!.text)) edtOtp1!!.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        edtOtp2!!.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && TextUtils.isEmpty(edtOtp2!!.text)) {
                edtOtp1!!.requestFocus()
                return@OnKeyListener true
            }
            false
        })
        edtOtp3!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().length == 1) {
                    edtOtp4!!.requestFocus()
                } else {
                    if (TextUtils.isEmpty(edtOtp2!!.text)) edtOtp2!!.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        edtOtp3!!.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && TextUtils.isEmpty(edtOtp3!!.text)) {
                edtOtp2!!.requestFocus()
                return@OnKeyListener true
            }
            false
        })
        edtOtp4!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().isEmpty() && TextUtils.isEmpty(edtOtp3!!.text)) {
                    edtOtp3!!.requestFocus()
                }
                if (s.toString().length == 1) {
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        edtOtp4!!.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && TextUtils.isEmpty(edtOtp4!!.text)) {
                edtOtp3!!.requestFocus()
                return@OnKeyListener true
            }
            false
        })
        btnContinue!!.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(edtOtp1!!.text.toString()) ||
                TextUtils.isEmpty(edtOtp2!!.text.toString()) ||
                TextUtils.isEmpty(edtOtp3!!.text.toString()) ||
                TextUtils.isEmpty(edtOtp4!!.text.toString())
            ) {
                Toast.makeText(
                    this@OtpValidationActivity,
                    "Please insert Valid OTP",
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }
            val otp: String = edtOtp1!!.text.toString() +
                    edtOtp2!!.text.toString() +
                    edtOtp3!!.text.toString() +
                    edtOtp4!!.text.toString()
            verifyOtp(otp)
        })
        txtResendOtp!!.setOnClickListener { resendOtp() }
    }


    fun verifyOtp(otp: String?){
        Showloader()
        val android_id = Settings.Secure.getString(
            contentResolver,
            Settings.Secure.ANDROID_ID
        )
        val release = Build.VERSION.RELEASE
        val request = VerifyOtpRequest(countryCode!!,phoneNumber!!,"Android",android_id,release,otp!!)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.verifyOtp(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            val userid = responseModel.data.user.userId.toString()
                            val username = responseModel.data.user.username
                            val authtoken = responseModel.data.user.authToken
                            val emailId = responseModel.data.user.emailId
                            val countryCode = responseModel.data.user.countryCode
                            val mobile = responseModel.data.user.phoneNumber
                            AppConstants.AuthToken = authtoken
                            editor = sharedPreferences!!.edit()
                            editor.putString("userid", userid)
                            editor.putString("username", username)
                            editor.putString("authtoken", authtoken)
                            editor.putString("emailId", emailId)
                            editor.putString("countryCode", countryCode)
                            editor.putString("mobileNo", mobile)
                            editor.apply()
                            AppConstants.isUserLoggedIn = true
                            AppConstants.UserId = userid
                            Toast.makeText(
                                this@OtpValidationActivity,
                                "Login Success",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(
                                this@OtpValidationActivity,
                                NewHomeActivity::class.java
                            )
                            intent.addFlags(
                                Intent.FLAG_ACTIVITY_NEW_TASK or
                                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                            )
                            startActivity(intent)
                        }else{
                            Toast.makeText(
                                this@OtpValidationActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@OtpValidationActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@OtpValidationActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@OtpValidationActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@OtpValidationActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
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

    private fun resendOtp(){
        Showloader()
        val request = LoginApiRequest(countryCode!!,phoneNumber!!)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.loginApi(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            Toast.makeText(
                                this@OtpValidationActivity,
                                "" + responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }else{
                            Toast.makeText(
                                this@OtpValidationActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@OtpValidationActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@OtpValidationActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@OtpValidationActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@OtpValidationActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}