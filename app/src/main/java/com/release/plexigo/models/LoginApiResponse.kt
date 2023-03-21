package com.release.plexigo.models

data class LoginApiResponse(
    val `data`: LoginData,
    val status: String,
    val statusCode: String
)

data class LoginData(
    val message: String,
    val user: Any
)