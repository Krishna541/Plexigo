package com.release.plexigo.models

data class TopGenreResponseModel(
    val `data`: TopGenreResponseDataModel,
    val status: String,
    val statusCode: String
)

data class TopGenreResponseDataModel(
    val message : String,
    val topGenre : ArrayList<TopGenreModel>
)

data class TopGenreModel(
    val genreID : Int,
    val genreCategory : String,
    var isSelected : Boolean
)