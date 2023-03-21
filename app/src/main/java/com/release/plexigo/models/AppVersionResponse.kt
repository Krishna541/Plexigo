package com.release.plexigo.models

data class AppVersionResponse(
    val `data`: AppVersionData,
    val status: String,
    val statusCode: String
)

data class AppVersionData(
    val message: Any,
    val platforms: List<Platform>
)

data class Platform(
    val platform: String,
    val platformVersion: List<PlatformVersion>
)

data class PlatformVersion(
    val latestVersion: String,
    val minimumSupported: String
)