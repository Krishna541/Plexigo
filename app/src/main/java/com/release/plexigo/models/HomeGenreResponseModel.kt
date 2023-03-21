package com.release.plexigo.models

import java.io.Serializable

data class HomeGenreResponseModel(
    val `data`: HomeGenreResponseDataModel,
    val status: String,
    val statusCode: String
)

data class HomeGenreResponseDataModel(
    val genreGroup: List<HomeGenreModel>,
    val message: Any
)

data class HomeGenreModel(
    var genreGroupID: Int,
    var genreGroup: String,
    var selected: Int
):Serializable