package com.release.plexigo.models

import java.io.Serializable

data class BannerResponseModel(
    val `data`: BannerResponseDataModel,
    val status: String,
    val statusCode: String
)

data class BannerResponseDataModel(
    val content: ArrayList<BannerModel>,
    val message: Any
)

data class BannerModel(
    val contentId: Int,
    val contentName: String,
    val duration: String,
    val externalWebLink: String,
    val genere: Any,
    val imagePath: String,
    val language: String,
    val nImagePath: String,
    val ottPlatforms: Any,
    val ottWideImagePath: String,
    val releaseDate: Any,
    val sequenceId: Int,
    val synopsis: String,
    val tag: String,
    val trailerpath: Any,
    val year: Int,
    val wideImagePath : String
):Serializable
