package com.release.plexigo.models

data class UpdateProfileApiRequest(
    val UserId : Int,
    val UserName: String,
    val Age: Int,
    val Country: String,
    val State: String,
    val Gender: String,
    val Languages: String,
    val Genres: String
)
