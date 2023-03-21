package com.release.plexigo.models

data class PaypalOrderRequest(
    val Amount : String,
    val User_ID : String,
    val Movie_ID : String,
    val Currency : String,
    val CountryCode : String
)
