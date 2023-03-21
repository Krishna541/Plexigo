package com.release.plexigo.models

data class PlaylistUserResponseModel(
    var statusCode: String,

    var status: String,

    var data: PlaylistUserDataModel
)

data class PlaylistUserDataModel(
    val playlistUser : ArrayList<PlaylistUserModel>,
    val message : String
)