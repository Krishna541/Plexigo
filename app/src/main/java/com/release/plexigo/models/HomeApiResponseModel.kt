package com.release.plexigo.models

data class HomeApiResponseModel(
    val `data`: HomeApiDataModel,
    val status: String,
    val statusCode: String
)

data class HomeApiDataModel(
    val categories: ArrayList<HomeApiCategoryModel>,
    val curatedCategoryId: Int,
    val curatedImage: String,
    val curatedLinkText: String,
    val curatedText: String,
    val message: Any,
    val showOffersPopup: Int,
    val showPopularChannel: Int,
    val showpopularchannelposition: Int
)

data class HomeApiCategoryModel(
    val category: String,
    val categoryId: Int,
    val content: ArrayList<MovieModel>,
    val pageCount: Int
)

data class HomeApiContent(
    val contentId: Int,
    val contentName: String,
    val externalWebLink: String,
    val imagePath: String,
    val isPlaylist: Int,
    val isWatchLater: String,
    val language: String,
    val ottWideImagePath: String,
    val synopsis: String,
    val tag: String,
    val userLikes: Int,
    val wideImagePath: String,
    val year: Int
)