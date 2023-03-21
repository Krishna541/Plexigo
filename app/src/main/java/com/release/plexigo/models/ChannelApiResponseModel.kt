package com.release.plexigo.models

data class ChannelApiResponseModel(
    val `data`: ChannelApiData,
    val status: String,
    val statusCode: String
)

data class ChannelApiData(
    val channelCategories: List<ChannelCategoryModel>,
    val message: Any
)

data class ChannelCategoryModel(
    val channelCategory: String,
    val channelCategoryId: String,
    val content: ArrayList<MovieModel>,
    val pageCount: Int
)