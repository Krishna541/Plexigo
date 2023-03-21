package com.release.plexigo.models

data class FestivalResponseModel(
    var statusCode: String,

    var status: String,

    var festivalDataResponseModel: FestivalDataResponseModel
)
