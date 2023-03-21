package com.release.plexigo.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003Js\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001J\t\u0010-\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006."}, d2 = {"Lcom/release/plexigo/models/Bundle;", "", "bundleId", "", "bundleName", "", "channelId", "channelSubscribed", "hasOTT", "imagevertical", "imagewide", "information", "issubscribed", "subscriptionplans", "", "Lcom/release/plexigo/models/SubscriptionplanX;", "(ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getBundleId", "()I", "getBundleName", "()Ljava/lang/String;", "getChannelId", "getChannelSubscribed", "getHasOTT", "getImagevertical", "getImagewide", "getInformation", "getIssubscribed", "getSubscriptionplans", "()Ljava/util/List;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Bundle {
    private final int bundleId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String bundleName = null;
    private final int channelId = 0;
    private final int channelSubscribed = 0;
    private final int hasOTT = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String imagevertical = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String imagewide = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String information = null;
    private final int issubscribed = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.release.plexigo.models.SubscriptionplanX> subscriptionplans = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.models.Bundle copy(int bundleId, @org.jetbrains.annotations.NotNull()
    java.lang.String bundleName, int channelId, int channelSubscribed, int hasOTT, @org.jetbrains.annotations.NotNull()
    java.lang.String imagevertical, @org.jetbrains.annotations.NotNull()
    java.lang.String imagewide, @org.jetbrains.annotations.NotNull()
    java.lang.String information, int issubscribed, @org.jetbrains.annotations.NotNull()
    java.util.List<com.release.plexigo.models.SubscriptionplanX> subscriptionplans) {
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
    
    public Bundle(int bundleId, @org.jetbrains.annotations.NotNull()
    java.lang.String bundleName, int channelId, int channelSubscribed, int hasOTT, @org.jetbrains.annotations.NotNull()
    java.lang.String imagevertical, @org.jetbrains.annotations.NotNull()
    java.lang.String imagewide, @org.jetbrains.annotations.NotNull()
    java.lang.String information, int issubscribed, @org.jetbrains.annotations.NotNull()
    java.util.List<com.release.plexigo.models.SubscriptionplanX> subscriptionplans) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getBundleId() {
        return 0;
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
    
    public final int component4() {
        return 0;
    }
    
    public final int getChannelSubscribed() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getHasOTT() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImagevertical() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImagewide() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInformation() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getIssubscribed() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.release.plexigo.models.SubscriptionplanX> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.release.plexigo.models.SubscriptionplanX> getSubscriptionplans() {
        return null;
    }
}