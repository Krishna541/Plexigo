package com.release.plexigo.models

data class OffersResponseModel(
    val `data`: OffersResponseDataModel,
    val status: String,
    val statusCode: String
)

data class OffersResponseDataModel(
    val bundles: ArrayList<OfferModel>,
    val message: Any,
    val pageCount: Int
)

data class Bundle(
    val bundleId: Int,
    val bundleName: String,
    val channelId: Int,
    val channelSubscribed: Int,
    val hasOTT: Int,
    val imagevertical: String,
    val imagewide: String,
    val information: String,
    val issubscribed: Int,
    val subscriptionplans: List<SubscriptionplanX>
)

data class SubscriptionplanX(
    val couponCode: String,
    val discountPercent: String,
    val inr: String,
    val inrDiscount: String,
    val plan: String,
    val subscriptionPlan: String,
    val subscriptoinPlanId: Int,
    val usd: String,
    val usdDiscount: String
)