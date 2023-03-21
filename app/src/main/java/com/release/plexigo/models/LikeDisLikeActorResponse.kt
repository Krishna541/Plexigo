package com.release.plexigo.models

data class LikeDisLikeActorResponse(
    val `data`: LikeDisLikeData,
    val status: String,
    val statusCode: String
)

data class LikeDisLikeData(
    val message: String
)