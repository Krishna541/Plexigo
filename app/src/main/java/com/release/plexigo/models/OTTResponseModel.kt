package com.release.plexigo.models

data class OTTResponseModel(
    val `data`: OTTResponseDataModel,
    val status: String,
    val statusCode: String
)

data class OTTResponseDataModel(
    val message: Any,
    val ottPlatforms: List<OTTModel>
)
