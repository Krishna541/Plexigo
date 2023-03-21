package com.release.plexigo.models

data class MovieDetailResponse(
    val `data`: MovieDetailData,
    val status: String,
    val statusCode: String
)

data class MovieDetailData(
    val contentdetail: ArrayList<Contentdetail>,
    val message: Any
)