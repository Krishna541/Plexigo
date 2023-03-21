package com.release.plexigo.models

data class LikeDislikeContentRequest(
    var ContentID : Int,
    var UserID : Int,
    var Islike : Int
)
