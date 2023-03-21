package com.release.plexigo.models

data class LinkAuthCodeUserRequest(
    val AuthCode : String,
    val UserID : Int
)
