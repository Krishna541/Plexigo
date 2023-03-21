package com.release.plexigo.models

import java.io.Serializable

data class HomeLanguagesResponseModel(
    val `data`: HomeLanguageResponseDataModel,
    val status: String,
    val statusCode: String
)


data class HomeLanguageResponseDataModel(
    val languageGroup: ArrayList<HomeLanguageModel>,
    val message: Any
)

data class HomeLanguageModel(
    var languageGroup: String,
    var languageGroupID: Int,
    var selected: Int
):Serializable