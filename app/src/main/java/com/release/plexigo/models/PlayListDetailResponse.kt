package com.release.plexigo.models

data class PlayListDetailResponse(
    val `data`: PlayListDetailData,
    val status: String,
    val statusCode: String
)
data class PlayListDetailData(
    val message: Any,
    val playlist: ArrayList<PlaylistDetailModel>
)

data class PlaylistDetailModel(
    val followedCount: Any,
    val followedby: Any,
    val isFollow: String,
    val isPlaylistOwner: String,
    val noofContent: String,
    val playlistId: Int,
    val playlistUserId: Int,
    val playlisttype: String,
    val poster: String,
    val title: String,
    val userImage: String
)