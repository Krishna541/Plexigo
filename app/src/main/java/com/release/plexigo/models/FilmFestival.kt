package com.release.plexigo.models

import java.io.Serializable

data class FilmFestival(
    var filmFestivalName: String,

var imagePath: String,

var screenings: ArrayList<FilmScreening>,

var events: ArrayList<FilmEvent>
) : Serializable
