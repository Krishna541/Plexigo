package com.release.plexigo.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020FJ\u0010\u0010H\u001a\u00020F2\u0006\u0010#\u001a\u00020$H\u0002J\"\u0010I\u001a\u00020F2\u0006\u00104\u001a\u0002052\u0006\u0010J\u001a\u0002052\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J$\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u0002052\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010PH\u0016J&\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u001a\u0010Z\u001a\u00020F2\u0006\u0010[\u001a\u00020S2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u000e\u0010\\\u001a\u00020F2\u0006\u0010#\u001a\u00020$J\u0006\u0010]\u001a\u00020FR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010=X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010?\"\u0004\bD\u0010A\u00a8\u0006_"}, d2 = {"Lcom/release/plexigo/fragment/HomeChannelFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/release/plexigo/adapter/PopularChannelsAdapter$OnChannelClick;", "()V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "channels", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/ChannelFestivalModel;", "getChannels", "()Ljava/util/ArrayList;", "setChannels", "(Ljava/util/ArrayList;)V", "channelsAdapter", "Lcom/release/plexigo/adapter/PopularChannelsAdapter;", "getChannelsAdapter", "()Lcom/release/plexigo/adapter/PopularChannelsAdapter;", "setChannelsAdapter", "(Lcom/release/plexigo/adapter/PopularChannelsAdapter;)V", "festivalAdapter", "getFestivalAdapter", "setFestivalAdapter", "festivals", "getFestivals", "setFestivals", "layoutChannelContent", "Landroid/widget/FrameLayout;", "getLayoutChannelContent", "()Landroid/widget/FrameLayout;", "setLayoutChannelContent", "(Landroid/widget/FrameLayout;)V", "plan", "Lcom/release/plexigo/models/SubscriptionPlan;", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "recyclerViewChannels", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewChannels", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewChannels", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerViewFilmFestivals", "getRecyclerViewFilmFestivals", "setRecyclerViewFilmFestivals", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "selectedOffer", "Lcom/release/plexigo/models/OfferModel;", "txtTitleFilmFestivals", "Landroid/widget/TextView;", "getTxtTitleFilmFestivals", "()Landroid/widget/TextView;", "setTxtTitleFilmFestivals", "(Landroid/widget/TextView;)V", "txtTitlePopularChannels", "getTxtTitlePopularChannels", "setTxtTitlePopularChannels", "HideLoader", "", "Showloader", "checkIfOfferSubscribed", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onChannelClicked", "channelId", "channelName", "", "type", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "openSvodPopupLayout", "popularChannels", "Companion", "app_debug"})
public final class HomeChannelFragment extends androidx.fragment.app.Fragment implements com.release.plexigo.adapter.PopularChannelsAdapter.OnChannelClick {
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    public com.release.plexigo.network.APIInterface apiInterface;
    public androidx.recyclerview.widget.RecyclerView recyclerViewChannels;
    public androidx.recyclerview.widget.RecyclerView recyclerViewFilmFestivals;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.PopularChannelsAdapter channelsAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.PopularChannelsAdapter festivalAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> channels;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> festivals;
    @org.jetbrains.annotations.Nullable()
    private android.widget.FrameLayout layoutChannelContent;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView txtTitleFilmFestivals;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView txtTitlePopularChannels;
    private int requestCode = 1001;
    private final com.release.plexigo.models.OfferModel selectedOffer = null;
    private final com.release.plexigo.models.SubscriptionPlan plan = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.fragment.HomeChannelFragment.Companion Companion = null;
    public static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public HomeChannelFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerViewChannels() {
        return null;
    }
    
    public final void setRecyclerViewChannels(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerViewFilmFestivals() {
        return null;
    }
    
    public final void setRecyclerViewFilmFestivals(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.PopularChannelsAdapter getChannelsAdapter() {
        return null;
    }
    
    public final void setChannelsAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.PopularChannelsAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.PopularChannelsAdapter getFestivalAdapter() {
        return null;
    }
    
    public final void setFestivalAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.PopularChannelsAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> getChannels() {
        return null;
    }
    
    public final void setChannels(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> getFestivals() {
        return null;
    }
    
    public final void setFestivals(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.FrameLayout getLayoutChannelContent() {
        return null;
    }
    
    public final void setLayoutChannelContent(@org.jetbrains.annotations.Nullable()
    android.widget.FrameLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getTxtTitleFilmFestivals() {
        return null;
    }
    
    public final void setTxtTitleFilmFestivals(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getTxtTitlePopularChannels() {
        return null;
    }
    
    public final void setTxtTitlePopularChannels(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    public final int getRequestCode() {
        return 0;
    }
    
    public final void setRequestCode(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void popularChannels() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    @java.lang.Override()
    public void onChannelClicked(int channelId, @org.jetbrains.annotations.Nullable()
    java.lang.String channelName, @org.jetbrains.annotations.Nullable()
    java.lang.String type) {
    }
    
    private final void checkIfOfferSubscribed(com.release.plexigo.models.SubscriptionPlan plan) {
    }
    
    public final void openSvodPopupLayout(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.models.SubscriptionPlan plan) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.release.plexigo.fragment.HomeChannelFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/release/plexigo/fragment/HomeChannelFragment$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "newInstance", "Lcom/release/plexigo/fragment/HomeChannelFragment;", "app_debug"})
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
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.release.plexigo.fragment.HomeChannelFragment newInstance() {
            return null;
        }
    }
}