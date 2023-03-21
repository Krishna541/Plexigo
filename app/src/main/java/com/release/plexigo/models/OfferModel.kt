package com.release.plexigo.models

import java.io.Serializable

data class OfferModel(

    val bundleId: Int,
    val bundleName: String,
    val channelId: Int,
    val channelSubscribed: Int,
    val hasOTT: Int,
    val imagevertical: String,
    val imagewide: String,
    val information: String,
    val issubscribed: Int,
    val subscriptionplans: ArrayList<SubscriptionPlan>
//    var bundleId: Int = 0,
//
//    var bundleName: String,
//
//    var imageVertical: String,
//
//    var imageWidePath: String,
//
//
//    var subsctiptionPlans: ArrayList<SubscriptionPlan>,
//
//    val hasOTT: Int,
//
//    val issubscribed: Int

) : Serializable
