package com.release.plexigo.models

import java.util.ArrayList

data class MovieListingResponse(
    val `data`: MovieListingResponseDataModel,
    val status: String,
    val statusCode: String
)

data class MovieListingResponseDataModel(
    val content: ArrayList<MovieModel>,
    val languageGroup : ArrayList<HomeLanguageModel>,
    val message: Any,
    val pageCount: Int,
    val displayOTT :String
)

data class Content(
    val contentId: Int,
    val contentName: String,
    val externalWebLink: String,
    val imagePath: String,
    val isPlaylist: Int,
    var isWatchLater: String,
    val language: String,
    val ottWideImagePath: Any,
    val synopsis: Any,
    val tag: Any,
    val userLikes: Int,
    val wideImagePath: String,
    val year: Int
)
