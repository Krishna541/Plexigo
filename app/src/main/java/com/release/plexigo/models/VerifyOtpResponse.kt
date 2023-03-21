package com.release.plexigo.models

data class VerifyOtpResponse(
    val `data`: VerifyOtpData,
    val status: String,
    val statusCode: String
)

data class VerifyOtpData(
    val message: String,
    val user: User
)

data class User(
    val authToken: String,
    val countryCode: String,
    val emailId: String,
    val eventLogin: Any,
    val expires: Int,
    val phoneNumber: String,
    val producerLogin: Any,
    val userId: Int,
    val username: String
)