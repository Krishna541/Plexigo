package com.release.plexigo.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/release/plexigo/models/SaveOnBoardingRequest;", "", "UserId", "", "onboardingdatalist", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/OnBoardingRequestModel;", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "getUserId", "()I", "setUserId", "(I)V", "getOnboardingdatalist", "()Ljava/util/ArrayList;", "setOnboardingdatalist", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class SaveOnBoardingRequest {
    @com.sendbird.android.shadow.com.google.gson.annotations.SerializedName(value = "UserId")
    private int UserId;
    @org.jetbrains.annotations.NotNull()
    @com.sendbird.android.shadow.com.google.gson.annotations.SerializedName(value = "onboardingdatalist")
    private java.util.ArrayList<com.release.plexigo.models.OnBoardingRequestModel> onboardingdatalist;
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.models.SaveOnBoardingRequest copy(int UserId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.OnBoardingRequestModel> onboardingdatalist) {
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
    
    public SaveOnBoardingRequest(int UserId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.OnBoardingRequestModel> onboardingdatalist) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getUserId() {
        return 0;
    }
    
    public final void setUserId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.OnBoardingRequestModel> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.OnBoardingRequestModel> getOnboardingdatalist() {
        return null;
    }
    
    public final void setOnboardingdatalist(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.OnBoardingRequestModel> p0) {
    }
}