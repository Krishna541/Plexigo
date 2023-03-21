package com.release.plexigo.models

data class PlayListContentResponseModel(
    val `data`: PlaylistContentDataModel,
    val status: String,
    val statusCode: String
)
data class PlaylistContentDataModel(
    val message: String,
    val playlistContent: ArrayList<MovieModel>
)

data class PlaylistContent(
    val contentId: Int,
    val contentName: String,
    val duration: String,
    val externalWebLink: String,
    val genre: String,
    val imagePath: String,
    val isPlaylistOwner: String,
    val isWatchLater: String,
    val language: String,
    val wideImagePath: String,
    val year: Int
)