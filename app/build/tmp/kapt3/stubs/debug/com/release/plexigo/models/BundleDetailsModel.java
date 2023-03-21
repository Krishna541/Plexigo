package com.release.plexigo.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0003j\b\u0012\u0004\u0012\u00020\f`\u0005\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0003j\b\u0012\u0004\u0012\u00020\u0010`\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0003j\b\u0012\u0004\u0012\u00020\f`\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003J\t\u0010%\u001a\u00020\u0007H\u00c6\u0003J\u0019\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0003j\b\u0012\u0004\u0012\u00020\u0010`\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0007H\u00c6\u0003J\u0093\u0001\u0010(\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0003j\b\u0012\u0004\u0012\u00020\f`\u00052\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0003j\b\u0012\u0004\u0012\u00020\u0010`\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\tH\u00d6\u0001J\t\u0010-\u001a\u00020\u0007H\u00d6\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0003j\b\u0012\u0004\u0012\u00020\f`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0003j\b\u0012\u0004\u0012\u00020\u0010`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016\u00a8\u0006."}, d2 = {"Lcom/release/plexigo/models/BundleDetailsModel;", "", "bundleInfo", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/SubscriptionInfoModel;", "Lkotlin/collections/ArrayList;", "bundleName", "", "channelId", "", "channelSubscribed", "faqs", "Lcom/release/plexigo/models/FaqModel;", "hasOTT", "issubscribed", "subscriptionplans", "Lcom/release/plexigo/models/SubscriptionPlan;", "wideImageURL", "(Ljava/util/ArrayList;Ljava/lang/String;ILjava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getBundleInfo", "()Ljava/util/ArrayList;", "getBundleName", "()Ljava/lang/String;", "getChannelId", "()I", "getChannelSubscribed", "getFaqs", "getHasOTT", "getIssubscribed", "getSubscriptionplans", "getWideImageURL", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class BundleDetailsModel {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.release.plexigo.models.SubscriptionInfoModel> bundleInfo = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String bundleName = null;
    private final int channelId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String channelSubscribed = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.release.plexigo.models.FaqModel> faqs = null;
    private final int hasOTT = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String issubscribed = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.release.plexigo.models.SubscriptionPlan> subscriptionplans = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String wideImageURL = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.models.BundleDetailsModel copy(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.SubscriptionInfoModel> bundleInfo, @org.jetbrains.annotations.NotNull()
    java.lang.String bundleName, int channelId, @org.jetbrains.annotations.NotNull()
    java.lang.String channelSubscribed, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FaqModel> faqs, int hasOTT, @org.jetbrains.annotations.NotNull()
    java.lang.String issubscribed, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.SubscriptionPlan> subscriptionplans, @org.jetbrains.annotations.NotNull()
    java.lang.String wideImageURL) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public BundleDetailsModel(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.SubscriptionInfoModel> bundleInfo, @org.jetbrains.annotations.NotNull()
    java.lang.String bundleName, int channelId, @org.jetbrains.annotations.NotNull()
    java.lang.String channelSubscribed, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FaqModel> faqs, int hasOTT, @org.jetbrains.annotations.NotNull()
    java.lang.String issubscribed, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.SubscriptionPlan> subscriptionplans, @org.jetbrains.annotations.NotNull()
    java.lang.String wideImageURL) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.SubscriptionInfoModel> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.SubscriptionInfoModel> getBundleInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBundleName() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getChannelId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChannelSubscribed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FaqModel> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FaqModel> getFaqs() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getHasOTT() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIssubscribed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.SubscriptionPlan> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.SubscriptionPlan> getSubscriptionplans() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWideImageURL() {
        return null;
    }
}