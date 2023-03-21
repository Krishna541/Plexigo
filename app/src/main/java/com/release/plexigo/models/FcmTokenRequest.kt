package com.release.plexigo.models

data class FcmTokenRequest(
    val UserId : Int,
    val DeviceId : String,
    val FCMToken : String
)