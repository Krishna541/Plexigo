package com.release.plexigo.models

import java.io.Serializable

data class ActorListDataModel(
    var actors: ArrayList<ActorModel>,

    var pageCount: Int,

    var message: String
)

data class ActorModel(

    var actorId: Int,

    var name: String,

    var imagepath: String

) : Serializable
