package com.release.plexigo.models

data class SearchActorsRequestModel(
    var KeyWord: String,
    var SearchFor : String,
    var UserId: Int,
    var PageNo : Int,
    var NumberOfRecord: Int
)
