package com.release.plexigo.models

data class AddWatchHistoryRequest(
    var UserId : Int,
    var ContentId : Int,
    var WatchDuration : Int,
    var Action : String
)
