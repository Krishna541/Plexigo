package com.release.plexigo.models

data class WatchHistoryResponseModel(
    val `data`: WatchHistoryDataResponseModel,
    val status: String,
    val statusCode: String
)

data class WatchHistoryDataResponseModel(
    val message: String,
    val pageCount: Int,
    val watchContent: ArrayList<MovieModel>
)

data class WatchContent(
    val contentId: Int,
    val contentName: String,
    val imagePath: String,
    val isWatchLater: String,
    val language: String,
    val watchDuration: Int,
    val watchPercent: Int,
    val year: Int
)