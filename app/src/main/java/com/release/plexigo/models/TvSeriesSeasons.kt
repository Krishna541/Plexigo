package com.release.plexigo.models

data class TvSeriesSeasons(
    val airdate: String,
    val episodeCount: String,
    val episodes: ArrayList<TvSeriesEpisode>,
    val overview: String,
    val poster: String,
    val seasonId: Int,
    val seasonname: String
)