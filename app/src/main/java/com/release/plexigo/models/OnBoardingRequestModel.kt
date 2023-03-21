package com.release.plexigo.models

import com.sendbird.android.shadow.com.google.gson.annotations.SerializedName

data class OnBoardingRequestModel(
    @SerializedName("obdid")
    var obdid: Int,
    @SerializedName("Type")
    var type: String,

    @SerializedName("Response")
    var response: String
)
