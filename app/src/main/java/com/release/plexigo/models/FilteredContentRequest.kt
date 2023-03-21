package com.release.plexigo.models

data class FilteredContentRequest(
    val CategorytyId : Int,
    val ContentTypeID : Int,
    val GenreIds : String,
    val LanguageIds :String,
    val OTTPlatformIds :String,
    val PageNo : Int,
    val NumberOfRecord : Int,
    val YearFrom :String,
    val YearTo :String
)