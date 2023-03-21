package com.release.plexigo.models

data class SearchMoviesByActorRequest(
    var ActorID : Int,
    var UserID : Int,
    var PageNo : Int,
    var NumberOfRecord : Int
)
