package com.release.plexigo.models

import java.io.Serializable

data class FilmScreeningData(
    var screeningId: Int,
    var contentId: Int,

    var contentName: String,

    var imagePath: String,

    var year: Int,

    var language: String,

    var wideImagePath: String,

    var duration: String

) : Serializable
