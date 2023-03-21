package com.release.plexigo.models

data class ViewUserPlaylistDetailResponseModel(
    val message: String,
    val status: String,
    val statusCode: String,
    val viewPlaylist: ViewUserPlaylistDetailModel
)

data class ViewUserPlaylistDetailModel(
    val userContent: String,
    val userFollowFlag: Int,
    val userId: Int,
    val userImage: String,
    val userName: String,
    val userplaylistfollowedby: String
)