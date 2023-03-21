package com.release.plexigo.models

data class LanguageModel(
    val contentId: Int,
    val language: String,
    val languageId: Int,
    val languageShort: String,
    val trailerpath: String,
    val videoAssetTypeID: Int,
    val videopath: String
)