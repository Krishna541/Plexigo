package com.release.plexigo.models

data class ActorDetailResponseModel(
    val `data`: ActorDetailData,
    val status: String,
    val statusCode: String
)

data class ActorDetailData(
    val actordetail: List<Actordetail>,
    val message: Any
)

data class Actordetail(
    val actorId: Int,
    val actorName: String,
    val imagePath: String,
    val job: String,
    val profilePath: String,
    val profileflag: Int,
    val userLikes: Int,
    val wideImagePath: String
)