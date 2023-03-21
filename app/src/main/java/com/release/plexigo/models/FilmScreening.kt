package com.release.plexigo.models

import java.io.Serializable

data class FilmScreening(
    var screeningDate: String,
var screeningEndTime: String,

var screeningStartTime: String,

var screening: ArrayList<FilmScreeningData>
) : Serializable
