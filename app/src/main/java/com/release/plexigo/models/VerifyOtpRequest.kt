package com.release.plexigo.models

data class VerifyOtpRequest(
    val countryCode : String,
    val PhoneNumber : String,
    val DeviceType : String,
    val DeviceId : String,
    val DeviceVersion : String,
    val otp : String
)
