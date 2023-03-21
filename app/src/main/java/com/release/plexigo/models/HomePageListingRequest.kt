package com.release.plexigo.models

data class HomePageListingRequest(
    val genreIds : String,
    val languageIds : String,
    val userId : Int,
    val categoryId : Int
)
