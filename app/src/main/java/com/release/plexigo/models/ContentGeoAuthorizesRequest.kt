package com.release.plexigo.models

data class ContentGeoAuthorizesRequest(
    var Lat : String,
    var Long : String,
    var ipAddress : String,
    var contentId : Int,
    var UserId : Int
)
