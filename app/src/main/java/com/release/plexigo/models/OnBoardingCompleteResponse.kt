package com.release.plexigo.models

data class OnBoardingCompleteResponse(
    val `data`: OnBoardingData,
    val status: String,
    val statusCode: String
)

data class OnBoardingData(
    val message: Any,
    val onboardingComplete: List<OnboardingComplete>
)

data class OnboardingComplete(
    val onboardingComplete: String
)