package com.release.plexigo.models

data class RegistrationResponse(
    val `data`: RegistrationData,
    val status: String,
    val statusCode: String
)

data class RegistrationData(
    val message: String,
    val user: Any
)