package com.release.plexigo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.R
import java.util.regex.Pattern


class ContactUsFragment : Fragment() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var message: EditText
    lateinit var submit: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_contact_us, container, false)
        name = v.findViewById(R.id.name)
        email = v.findViewById(R.id.email)
        message = v.findViewById(R.id.message)
        submit = v.findViewById(R.id.submit)
        submit.setOnClickListener(View.OnClickListener {
            val nametext = name.getText().toString().trim { it <= ' ' }
            val emailtext = email.getText().toString().trim { it <= ' ' }
            val messagetext = message.getText().toString()
            if (nametext != null && !nametext.equals("", ignoreCase = true)) {
                if (emailtext != null && !emailtext.equals("", ignoreCase = true)) {
                    if (isValidEmailAddress(emailtext)) {
                        if (messagetext != null && !messagetext.equals("", ignoreCase = true)) {
//                                Contact(nametext, emailtext, messagetext);
                        } else {
                            message.setError("Please enter Message")
                        }
                    } else {
                        email.setError("Please enter valid Email")
                    }
                } else {
                    email.setError("Please enter Email")
                }
            } else {
                name.setError("Please enter Name")
            }
        })
        return v
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
        val ft = requireActivity().supportFragmentManager.beginTransaction()
        customProgressDialog.show(ft, "dialog")
        customProgressDialog.setCancelable(false)
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    companion object {
        lateinit var customProgressDialog: CustomProgressDialog
    }
}