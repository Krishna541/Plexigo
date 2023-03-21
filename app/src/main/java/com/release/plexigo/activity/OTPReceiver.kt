package com.release.plexigo.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

open class OTPReceiver : BroadcastReceiver() {
    private var otpListener: OTPReceiveListener? = null
    fun setOTPListener(otpListener: OTPReceiveListener?) {
        this.otpListener = otpListener
    }

    override fun onReceive(context: Context, intent: Intent) {
        val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        for (smsMessage in smsMessages) {
            val message_body = smsMessage.messageBody
            Log.e("onOTPReceived1", message_body.trim { it <= ' ' }.substring(0, 4))
            val i = Intent("onOtpReceived")
            i.putExtra("bundle", message_body.trim { it <= ' ' }.substring(0, 4))
            context.sendBroadcast(i)
        }
    }

    interface OTPReceiveListener {
        fun onOTPReceived(otppp: String?)
    }
}