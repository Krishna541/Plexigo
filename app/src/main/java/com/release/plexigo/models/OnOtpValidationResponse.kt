package com.release.plexigo.models

data class OnOtpValidationResponse(
    val `data`: OnOtpValidationData,
    val status: String,
    val statusCode: String
)

data class OnOtpValidationData(
    val tacLink: String,
    val tacText: String
)