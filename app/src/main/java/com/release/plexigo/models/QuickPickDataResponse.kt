package com.release.plexigo.models

data class QuickPickDataResponse(
    val `data`: QuickPickData,
    val status: String,
    val statusCode: String
)

data class QuickPickData(
    val content: ArrayList<MovieModel>,
    val message: Any
)

