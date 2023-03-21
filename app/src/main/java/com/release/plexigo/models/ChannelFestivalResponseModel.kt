package com.release.plexigo.models

data class ChannelFestivalResponseModel(
    val `data`: ChannelAndFestivalResponseDataModel,
    val status: String,
    val statusCode: String
)

data class ChannelAndFestivalResponseDataModel(
    val channels: List<ChannelFestivalModel>,
    val festival: List<ChannelFestivalModel>,
    val message: String,
    val position: String
)

data class ChannelFestivalModel(
    val channelID: Int,
    val channelImage: String,
    val channelName: String,
    val isSubscribed: String,
    val type: String
)