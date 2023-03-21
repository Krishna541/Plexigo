package com.release.plexigo.models

data class ContentTokenResponse(
    val contentToken: String,
    val dashURL: String,
    val fairplayCertificateURL: String,
    val fairplayLicenseURL: String,
    val hlsURL: String,
    val message: String,
    val status: String,
    val statusCode: String,
    val widevineLicenseURL: String
)