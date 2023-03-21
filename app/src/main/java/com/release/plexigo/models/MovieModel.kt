package com.release.plexigo.models

import java.io.Serializable

data class MovieModel(
    val contentId: Int,
    val imagePath: String,
    val contentName: String,
    val language: String,
    var watchDuration : Int,
    val year: Int,
    var isWatchLater: String,
    val externalWebLink: String,
    val duration: String,
    val genere: String,
    val wideImagePath: String,
    val isPlaylistOwner: String,
    val synopsis: String,

    var isLiveContent: Boolean = false


//    val nImagePath: String,
//    val ottPlatforms: List<OTTModel>,
//    val ottWideImagePath: Any,
//    val releaseDate: String,
//    val sequenceId: Int,
//
//    val tag: Any,
//    val trailerpath: Any,
):Serializable
