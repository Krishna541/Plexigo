package com.release.plexigo.models

data class CheckUserIsPpvSubscribeRequest(
    var User_ID : Int,
    var Movie_ID : Int,
    var Validity_period : Int,
    var Validity_recurrence : String
)
