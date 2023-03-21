package com.release.plexigo.models

data class CouponCodesResponseModel(
    val `data`: CouponListingResponseDataModel,
    val status: String,
    val statusCode: String
)

data class CouponListingResponseDataModel(
    val couponcode: List<OttCouponModel>,
    val message: Any
)

data class OttCouponModel(
    val coupons: ArrayList<CouponModel>,
    val imagePath: String,
    val ottId: Int,
    val ottName: String
)

data class CouponModel(
    val plan : String,
    val validityStart : String,
    val validityEnd : String,
    val purchasedate : String,
    val inrAmount : String,
    val usdAmount : String,
    val couponcode : String,
    val discountPercent : String,
    val validityInDays : String,
    val message : String,
    val isActive : String,
    val inrDiscountAmount : String,
    val usdDiscountAmount : String
)
