package com.release.plexigo.models

data class SearchSuggestionResponseModel(

    var statusCode: String,

    var status: String,

    var data: SearchSuggestionDataModel

)

data class SearchSuggestionDataModel(

    var search: ArrayList<SearchSuggestionModel>,
    var message: String
)