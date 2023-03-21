package com.release.plexigo.models

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class FestivalDataResponseModel(
    var festival: ArrayList<FilmFestival>
) : Serializable
