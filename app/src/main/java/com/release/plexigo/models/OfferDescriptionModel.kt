package com.release.plexigo.models

data class OfferDescriptionModel(
    val `data`: SubscriptionDetailDataModel,
    val status: String,
    val statusCode: String
)

data class SubscriptionDetailDataModel(
    val bundledetails: List<BundleDetailsModel>,
    val message: Any
)

data class BundleDetailsModel(
    val bundleInfo: ArrayList<SubscriptionInfoModel>,
    val bundleName: String,
    val channelId: Int,
    val channelSubscribed: String,
    val faqs: ArrayList<FaqModel>,
    val hasOTT: Int,
    val issubscribed: String,
    val subscriptionplans: ArrayList<SubscriptionPlan>,
    val wideImageURL: String
)
data class SubscriptionInfoModel(
    val infoDetails: ArrayList<InfoDetailsModel>,
    val infoType: String
)

data class FaqModel(
    val answer: String,
    val question: String
)
data class InfoDetailsModel(
    val id: Int,
    val value: String
)

//data class SubscriptionplanX(
//    val couponCode: String,
//    val discountPercent: String,
//    val inr: String,
//    val inrDiscount: Int,
//    val plan: String,
//    val subscriptionPlan: String,
//    val subscriptoinPlanId: Int,
//    val usd: String,
//    val usdDiscount: Int
//)