package com.release.plexigo.activity

import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.release.plexigo.BuildConfig
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.models.LinkAuthCodeUserRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_verify_auth_code.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException

class VerifyAuthCodeActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_auth_code)
        imgBtnBack.setOnClickListener(View.OnClickListener { onBackPressed() })
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        initView()
    }

    fun showLoader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.setCancelable(false)
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    fun linkAuthCodeUser(otp : String?) {
        showLoader()
        val request = LinkAuthCodeUserRequest(
            otp!!,
            Integer.valueOf(sharedPreferences!!.getString("userid", null))
        )
        val apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.linkAuthCodeUser(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@VerifyAuthCodeActivity,
                                "" + responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        } else {
                            Toast.makeText(
                                this@VerifyAuthCodeActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@VerifyAuthCodeActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    Toast.makeText(this@VerifyAuthCodeActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
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
                if (s.toString().length == 1) {
                    edtOtp5!!.requestFocus()
                } else {
                    if (TextUtils.isEmpty(edtOtp3!!.text)) edtOtp3!!.requestFocus()
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
        edtOtp5!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().length == 1) {
                    edtOtp6!!.requestFocus()
                } else {
                    if (TextUtils.isEmpty(edtOtp4!!.text)) edtOtp4!!.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        edtOtp5!!.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && TextUtils.isEmpty(edtOtp5!!.text)) {
                edtOtp4!!.requestFocus()
                return@OnKeyListener true
            }
            false
        })
        edtOtp6!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().isEmpty() && TextUtils.isEmpty(edtOtp5!!.text)) {
                    edtOtp5!!.requestFocus()
                }
                if (s.toString().length == 1) {
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        edtOtp6!!.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && TextUtils.isEmpty(edtOtp6!!.text)) {
                edtOtp5!!.requestFocus()
                return@OnKeyListener true
            }
            false
        })
        btnContinue!!.setOnClickListener(View.OnClickListener {
            val otp: String
            if (TextUtils.isEmpty(edtOtp1!!.text.toString()) ||
                TextUtils.isEmpty(edtOtp2!!.text.toString()) ||
                TextUtils.isEmpty(edtOtp3!!.text.toString()) ||
                TextUtils.isEmpty(edtOtp4!!.text.toString()) ||
                TextUtils.isEmpty(edtOtp5!!.text.toString()) ||
                TextUtils.isEmpty(edtOtp6!!.text.toString())
            ) {
                Toast.makeText(
                    this@VerifyAuthCodeActivity,
                    "Please insert Valid Authentication Code",
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }
            otp = edtOtp1!!.text.toString() +
                    edtOtp2!!.text.toString() +
                    edtOtp3!!.text.toString() +
                    edtOtp4!!.text.toString() +
                    edtOtp5!!.text.toString() +
                    edtOtp6!!.text.toString()
            linkAuthCodeUser(otp)
        })
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}