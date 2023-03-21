package com.release.plexigo.models

data class UpdateFollowStateRequest(
    val FollowerUserId : Int,
    val UserId : Int,
    val Action : String
)
