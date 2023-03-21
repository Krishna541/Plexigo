package com.release.plexigo.models

data class LikeDisLikeActorRequest(
    var ActorID : Int,
    var UserID : Int,
    var Islike : Int
)
