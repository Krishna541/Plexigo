package com.release.plexigo.models

data class SendVerificationCodeRequest(
    val emailId : String,
    val verificationCode : Int
)
