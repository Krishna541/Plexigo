package com.release.plexigo.models

data class RemoveContentUserPlayListResponse(
    val `data`: RemovePlayListData,
    val status: String,
    val statusCode: String
)

data class RemovePlayListData(
    val message: String
)