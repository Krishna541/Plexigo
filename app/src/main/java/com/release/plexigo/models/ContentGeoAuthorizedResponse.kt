package com.release.plexigo.models

data class ContentGeoAuthorizedResponse(
    val city: String,
    val countryLock: String,
    val message: String,
    val pincodeLock: String,
    val result: String
)