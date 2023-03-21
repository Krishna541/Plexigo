package com.release.plexigo.models

import java.io.Serializable

data class CastModel(
    val bio: String,
    val castCrewId: Int,
    val imagepath: String,
    val name: String
):Serializable