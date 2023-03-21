package com.release.plexigo.models

import com.sendbird.android.shadow.com.google.gson.annotations.SerializedName

data class SaveOnBoardingRequest(
    @SerializedName("UserId")
    var UserId: Int ,

    @SerializedName("onboardingdatalist")
    var onboardingdatalist : ArrayList<OnBoardingRequestModel>
)
