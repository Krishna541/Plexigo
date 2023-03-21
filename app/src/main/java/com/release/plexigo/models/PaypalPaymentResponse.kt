package com.release.plexigo.models

data class PaypalPaymentResponse(
    val id: String,
    val links: ArrayList<Link>,
    val status: String
)

data class Link(
    val href: String,
    val method: String,
    val rel: String
)