package com.release.plexigo.models

data class ActorListingResponseModel(
    var statusCode: String,

    var status: String,

    var data: ActorListDataModel
)
