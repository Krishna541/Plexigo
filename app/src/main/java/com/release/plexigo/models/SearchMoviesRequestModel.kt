package com.release.plexigo.models

import java.io.Serializable

data class SearchMoviesRequestModel(
    var keyword: String,
    var categoryId : Int,
    var searchfor : String,
    var userId: Int,
    var pageNo : Int,
    var numberOfRecord: Int
)
