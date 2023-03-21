package com.release.plexigo.models

data class UserPlayListResponseModel(
    val `data`: UserPlaylistDataModel,
    val status: String,
    val statusCode: String
)

data class UserPlaylistDataModel(
    val message: String,
    val pageCount : Int,
    val playlist: ArrayList<UserPlaylistModel>
)

data class Playlist(
    val playlistId: Int,
    val playlistName: String,
    val widePoster: String
)