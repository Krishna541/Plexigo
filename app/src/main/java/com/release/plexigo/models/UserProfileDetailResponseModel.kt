package com.release.plexigo.models

import java.io.Serializable

data class UserProfileDetailResponseModel(
    val `data`: UserProfileDetailModel,
    val status: String,
    val statusCode: String
)

data class UserProfileDetailModel(
    val message: Any,
    val userprofile: ArrayList<UserProfileModel>
)

data class UserProfileModel(
    val age: String,
    var country: String,
    val email: String,
    val followerCount: String,
    val followingCount: String,
    val gender: String,
    val imagePath: String,
    val joinedOn: String,
    val playlistCount: String,
    val preferenceGenre: ArrayList<HomeGenreModel>,
    val preferenceLanguage: ArrayList<HomeLanguageModel>,
    val profileCompletePercentage: String,
    var state: String,
    val userId: Int,
    val userName: String
):Serializable

data class PreferenceGenre(
    val genreGroup: String,
    val genreGroupID: Int,
    val selected: Int
)

data class PreferenceLanguage(
    val languageGroup: String,
    val languageGroupID: Int,
    val selected: Int
)