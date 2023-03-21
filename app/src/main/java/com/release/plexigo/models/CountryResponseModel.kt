package com.release.plexigo.models

data class CountryResponseModel(
    val `data`: CountryResponseDataModel,
    val status: String,
    val statusCode: String
)
data class CountryResponseDataModel(
    val country: List<CountryModel>,
    val message: Any
)

data class CountryModel(
    val country_name: String,
    val country_phone_code: String,
    val country_short_name: String
)