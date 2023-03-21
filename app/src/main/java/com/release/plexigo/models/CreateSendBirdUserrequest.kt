package com.release.plexigo.models

data class CreateSendBirdUserrequest(
    val user_id : String,
    val nickname: String,
    val issue_access_token: Boolean,
    val profile_url: String
)
