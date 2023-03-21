package com.release.plexigo.models

data class DeleteAccountResponse(
    val `data`: DeleteAccountData,
    val status: String,
    val statusCode: String
)

data class DeleteAccountData(
    val message: String,
    val user: Any
)