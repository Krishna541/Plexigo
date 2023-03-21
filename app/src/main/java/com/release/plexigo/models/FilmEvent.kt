package com.release.plexigo.models

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class FilmEvent(
    var eventDate: String,
var eventEndTime: String,

var eventStartTime: String,

var event: ArrayList<FilmEventData>
) : Serializable
