package com.release.plexigo.models

data class RemovePlayListContentRequest(
    val PlaylistId : Int,
    val UserId : Int,
    val ContentId : Int
)
