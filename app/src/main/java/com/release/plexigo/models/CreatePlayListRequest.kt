package com.release.plexigo.models

data class CreatePlayListRequest(
    val Title  : String,
    val UserId : Int,
    val Playlisttype : String,
    val ContentId  : Int
)