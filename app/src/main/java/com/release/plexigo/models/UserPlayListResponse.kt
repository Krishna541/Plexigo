package com.release.plexigo.models

data class UserPlayListResponse(
    val `data`: UserPlayListModelData,
    val status: String,
    val statusCode: String
)

data class UserPlayListModelData(
    val message : String,
    val pageCount : Int,
    val playlist : ArrayList<UserPlaylistModel>
)

data class UserPlaylistModel(
    var title: String,
    var playlistId : Int,
    var playlisttype :String,
    var noofContent: String,
    var poster : String,
    var widePoster : String,
    var playlistName : String
)