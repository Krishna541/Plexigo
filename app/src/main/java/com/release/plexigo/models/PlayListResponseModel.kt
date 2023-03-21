package com.release.plexigo.models

data class PlayListResponseModel(
    val `data`: PlayListData,
    val status: String,
    val statusCode: String
)

data class PlayListData(
    val message: String
)
