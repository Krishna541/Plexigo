package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020,J\b\u0010.\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u00020,H\u0002J\u0010\u00101\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u000103J\u0012\u00104\u001a\u00020,2\b\u00105\u001a\u0004\u0018\u000106H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/release/plexigo/activity/ChannelCategoryListingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "channelCategoryModelList", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/ChannelCategoryModel;", "getChannelCategoryModelList", "()Ljava/util/ArrayList;", "setChannelCategoryModelList", "(Ljava/util/ArrayList;)V", "channelID", "", "getChannelID", "()I", "setChannelID", "(I)V", "channelType", "", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "recyclerChannelCategories", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerChannelCategories", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerChannelCategories", "(Landroidx/recyclerview/widget/RecyclerView;)V", "txtTitle", "Landroid/widget/TextView;", "getTxtTitle", "()Landroid/widget/TextView;", "setTxtTitle", "(Landroid/widget/TextView;)V", "userId", "HideLoader", "", "Showloader", "channelCategories", "initData", "initView", "onBackClicked", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class ChannelCategoryListingActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    private int channelID = 0;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.ChannelCategoryModel> channelCategoryModelList;
    @org.jetbrains.annotations.Nullable()
    private androidx.recyclerview.widget.RecyclerView recyclerChannelCategories;
    public com.release.plexigo.network.APIInterface apiInterface;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView txtTitle;
    private java.lang.String channelType;
    private int userId = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.ChannelCategoryListingActivity.Companion Companion = null;
    public static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public ChannelCategoryListingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    public final int getChannelID() {
        return 0;
    }
    
    public final void setChannelID(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.ChannelCategoryModel> getChannelCategoryModelList() {
        return null;
    }
    
    public final void setChannelCategoryModelList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.ChannelCategoryModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerChannelCategories() {
        return null;
    }
    
    public final void setRecyclerChannelCategories(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getTxtTitle() {
        return null;
    }
    
    public final void setTxtTitle(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void initData() {
    }
    
    private final void channelCategories() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    public final void onBackClicked(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/ChannelCategoryListingActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.release.plexigo.Common.CustomProgressDialog getCustomProgressDialog() {
            return null;
        }
        
        public final void setCustomProgressDialog(@org.jetbrains.annotations.NotNull()
        com.release.plexigo.Common.CustomProgressDialog p0) {
        }
    }
}