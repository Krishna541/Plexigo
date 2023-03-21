package com.release.plexigo.models

import java.io.Serializable

data class OnBoardingResponseModel(
    val `data`: OnBoardingResponseDataModel,
    val status: String,
    val statusCode: String
):Serializable

data class OnBoardingResponseDataModel(
    val message: Any,
    val minActorcount: Int,
    val minContentcount: Int,
    val onboarding: List<OnBoardingModel>,
    val userActorcount: Int,
    val userContentcount: Int
):Serializable

data class OnBoardingModel(
    val area: String,
    val genre: String,
    val imagePath: String,
    val language: String,
    val name: String,
    val obdatatId: Int,
    val obdid: Int,
    val type: String
):Serializable