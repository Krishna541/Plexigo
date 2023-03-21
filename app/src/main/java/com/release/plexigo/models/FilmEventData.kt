package com.release.plexigo.models

import java.io.Serializable

data class FilmEventData(
    var title: String,
    var duration: String,

    var imagepath: String,

    var description: String
) : Serializable