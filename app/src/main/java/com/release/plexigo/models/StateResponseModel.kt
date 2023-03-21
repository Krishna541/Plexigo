package com.release.plexigo.models

data class StateResponseModel(
    val `data`: StateResponseDataModel,
    val status: String,
    val statusCode: String
)

data class StateResponseDataModel(
    val message: Any,
    val state: ArrayList<StateModel>
)

data class StateModel(
    val state_name: String
)