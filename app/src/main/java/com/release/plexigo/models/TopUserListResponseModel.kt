package com.release.plexigo.models

data class TopUserListResponseModel(
    val `data`: TopUserListResponseDataModel,
    val status: String,
    val statusCode: String
)

data class TopUserListResponseDataModel(
    val message: Any,
    val pageCount: Int,
    val topuserslist: ArrayList<TopUserListModel>
)

data class TopUserListModel(
    val imagepath: String,
    val playlistId: Int,
    val title: String,
    val userId: Int,
    val userName: String
)