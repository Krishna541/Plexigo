package com.release.plexigo.models

data class ForgotPasswordResponse(
    val `data`: ForgotPassWordData,
    val status: String,
    val statusCode: String
)
data class ForgotPassWordData(
    val message: String,
    val user: Any
)