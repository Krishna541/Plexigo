package com.release.plexigo.models

data class RegistrationRequest(
    val username : String,
    val emailid : String,
    val countryCode : String,
    val mobileno: String
)