package com.release.plexigo.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u0082\u0001B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010Z\u001a\u00020[H\u0002J\b\u0010\\\u001a\u00020[H\u0002J\b\u0010]\u001a\u00020[H\u0002J\b\u0010^\u001a\u00020[H\u0002J\u0010\u0010_\u001a\u00020[2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010`\u001a\u00020[H\u0002J\b\u0010a\u001a\u00020[H\u0002J\b\u0010b\u001a\u00020[H\u0002J\u0006\u0010c\u001a\u00020[J\b\u0010d\u001a\u00020[H\u0002J\u0010\u0010e\u001a\u00020[2\u0006\u0010f\u001a\u00020\u000fH\u0002J\u0006\u0010g\u001a\u00020[J\"\u0010h\u001a\u00020[2\u0006\u0010M\u001a\u00020N2\u0006\u0010i\u001a\u00020N2\b\u0010j\u001a\u0004\u0018\u00010kH\u0016J\u0010\u0010l\u001a\u00020[2\u0006\u0010m\u001a\u00020\u000fH\u0016J&\u0010n\u001a\u0004\u0018\u00010\u000f2\u0006\u0010o\u001a\u00020p2\b\u0010q\u001a\u0004\u0018\u00010r2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u0012\u0010u\u001a\u00020[2\b\u0010v\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010w\u001a\u00020[2\b\u0010x\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010y\u001a\u00020[2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010z\u001a\u00020[H\u0016J\u001a\u0010{\u001a\u00020[2\u0006\u0010f\u001a\u00020\u000f2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u000e\u0010|\u001a\u00020[2\u0006\u0010E\u001a\u00020FJ\u0010\u0010}\u001a\u00020[2\u0006\u0010x\u001a\u00020\u0018H\u0002J\u0010\u0010~\u001a\u00020[2\u0006\u0010x\u001a\u00020\u0018H\u0002J\u0006\u0010\u007f\u001a\u00020[J\t\u0010\u0080\u0001\u001a\u00020[H\u0002J\t\u0010\u0081\u0001\u001a\u00020[H\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u0017j\b\u0012\u0004\u0012\u00020!`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001e\u0010(\u001a\u0012\u0012\u0004\u0012\u00020)0\u0017j\b\u0012\u0004\u0012\u00020)`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u0012\u0012\u0004\u0012\u00020)0\u0017j\b\u0012\u0004\u0012\u00020)`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>0\u0017j\b\u0012\u0004\u0012\u00020>`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020QX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001e\u0010V\u001a\u0012\u0012\u0004\u0012\u00020W0\u0017j\b\u0012\u0004\u0012\u00020W`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010X\u001a\u0012\u0012\u0004\u0012\u00020Y0\u0017j\b\u0012\u0004\u0012\u00020Y`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/release/plexigo/fragment/HomeProfileFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Lcom/release/plexigo/adapter/OfferSliderAdapter$OnOfferClick;", "Lcom/release/plexigo/adapter/FavouritePeopleAdapter$OnPersonLongClick;", "Lcom/release/plexigo/adapter/SubscriptionPlansAdapter$OnPlanSelected;", "()V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "bottomSheet", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "favouritePeople", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/ActorModel;", "Lkotlin/collections/ArrayList;", "favouritePeopleAdapter", "Lcom/release/plexigo/adapter/FavouritePeopleAdapter;", "getFavouritePeopleAdapter", "()Lcom/release/plexigo/adapter/FavouritePeopleAdapter;", "setFavouritePeopleAdapter", "(Lcom/release/plexigo/adapter/FavouritePeopleAdapter;)V", "followUserList", "Lcom/release/plexigo/models/TopUserListModel;", "followedPlaylistAdapter", "Lcom/release/plexigo/adapter/PlaylistAdapter;", "getFollowedPlaylistAdapter", "()Lcom/release/plexigo/adapter/PlaylistAdapter;", "setFollowedPlaylistAdapter", "(Lcom/release/plexigo/adapter/PlaylistAdapter;)V", "followedPlaylists", "Lcom/release/plexigo/models/UserPlaylistModel;", "followedUserAdapter", "Lcom/release/plexigo/adapter/FollowedUserAdapter;", "getFollowedUserAdapter", "()Lcom/release/plexigo/adapter/FollowedUserAdapter;", "setFollowedUserAdapter", "(Lcom/release/plexigo/adapter/FollowedUserAdapter;)V", "layoutKnowBetter", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutKnowBetter", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setLayoutKnowBetter", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "myPlaylistAdapter", "Lcom/release/plexigo/adapter/MyPlaylistAdapter;", "getMyPlaylistAdapter", "()Lcom/release/plexigo/adapter/MyPlaylistAdapter;", "setMyPlaylistAdapter", "(Lcom/release/plexigo/adapter/MyPlaylistAdapter;)V", "myPlaylists", "offerList", "Lcom/release/plexigo/models/OfferModel;", "offersAdapter", "Lcom/release/plexigo/adapter/OfferSliderAdapter;", "getOffersAdapter", "()Lcom/release/plexigo/adapter/OfferSliderAdapter;", "setOffersAdapter", "(Lcom/release/plexigo/adapter/OfferSliderAdapter;)V", "plan", "Lcom/release/plexigo/models/SubscriptionPlan;", "preferences", "Landroid/content/SharedPreferences;", "getPreferences", "()Landroid/content/SharedPreferences;", "setPreferences", "(Landroid/content/SharedPreferences;)V", "requestCode", "", "selectedOffer", "topGenreAdapter", "Lcom/release/plexigo/adapter/TopGenreAdapter;", "getTopGenreAdapter", "()Lcom/release/plexigo/adapter/TopGenreAdapter;", "setTopGenreAdapter", "(Lcom/release/plexigo/adapter/TopGenreAdapter;)V", "topGenresList", "Lcom/release/plexigo/models/TopGenreModel;", "watchedMovieList", "Lcom/release/plexigo/models/MovieModel;", "callFollowedPlaylistApi", "", "callMyPlayList", "callOffersApi", "callWatchlistApi", "checkIfOfferSubscribed", "checkOnBoardingCompleted", "followedUserList", "getFavouritePeople", "hideLoader", "initData", "initView", "view", "navigateToOnBoarding", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onOfferClicked", "offer", "onPersonLongClicked", "actorModel", "onPlanSelected", "onResume", "onViewCreated", "openSvodPopupLayout", "removeFromFavouritesList", "showDeleteFromFavouriteDialog", "showLoader", "topGenres", "userProfileDetails", "Companion", "app_debug"})
public final class HomeProfileFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, com.release.plexigo.adapter.OfferSliderAdapter.OnOfferClick, com.release.plexigo.adapter.FavouritePeopleAdapter.OnPersonLongClick, com.release.plexigo.adapter.SubscriptionPlansAdapter.OnPlanSelected {
    private final java.util.ArrayList<com.release.plexigo.models.OfferModel> offerList = null;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.OfferSliderAdapter offersAdapter;
    private final java.util.ArrayList<com.release.plexigo.models.MovieModel> watchedMovieList = null;
    private final java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> followedPlaylists = null;
    public com.release.plexigo.adapter.PlaylistAdapter followedPlaylistAdapter;
    private final java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> myPlaylists = null;
    public com.release.plexigo.adapter.MyPlaylistAdapter myPlaylistAdapter;
    private final java.util.ArrayList<com.release.plexigo.models.TopUserListModel> followUserList = null;
    public com.release.plexigo.adapter.FollowedUserAdapter followedUserAdapter;
    private final java.util.ArrayList<com.release.plexigo.models.TopGenreModel> topGenresList = null;
    @org.jetbrains.annotations.NotNull()
    private com.release.plexigo.adapter.TopGenreAdapter topGenreAdapter;
    private final java.util.ArrayList<com.release.plexigo.models.ActorModel> favouritePeople = null;
    public com.release.plexigo.adapter.FavouritePeopleAdapter favouritePeopleAdapter;
    @org.jetbrains.annotations.Nullable()
    private androidx.constraintlayout.widget.ConstraintLayout layoutKnowBetter;
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences preferences;
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences.Editor editor;
    private com.release.plexigo.models.OfferModel selectedOffer;
    private com.release.plexigo.models.SubscriptionPlan plan;
    private final int requestCode = 1100;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> bottomSheet;
    public com.release.plexigo.network.APIInterface apiInterface;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.fragment.HomeProfileFragment.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public HomeProfileFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.OfferSliderAdapter getOffersAdapter() {
        return null;
    }
    
    public final void setOffersAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.OfferSliderAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.adapter.PlaylistAdapter getFollowedPlaylistAdapter() {
        return null;
    }
    
    public final void setFollowedPlaylistAdapter(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.PlaylistAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.adapter.MyPlaylistAdapter getMyPlaylistAdapter() {
        return null;
    }
    
    public final void setMyPlaylistAdapter(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.MyPlaylistAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.adapter.FollowedUserAdapter getFollowedUserAdapter() {
        return null;
    }
    
    public final void setFollowedUserAdapter(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.FollowedUserAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.adapter.TopGenreAdapter getTopGenreAdapter() {
        return null;
    }
    
    public final void setTopGenreAdapter(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.TopGenreAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.adapter.FavouritePeopleAdapter getFavouritePeopleAdapter() {
        return null;
    }
    
    public final void setFavouritePeopleAdapter(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.FavouritePeopleAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.constraintlayout.widget.ConstraintLayout getLayoutKnowBetter() {
        return null;
    }
    
    public final void setLayoutKnowBetter(@org.jetbrains.annotations.Nullable()
    androidx.constraintlayout.widget.ConstraintLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.SharedPreferences getPreferences() {
        return null;
    }
    
    public final void setPreferences(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.SharedPreferences.Editor getEditor() {
        return null;
    }
    
    public final void setEditor(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences.Editor p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
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
    
    private final void initView(android.view.View view) {
    }
    
    private final void initData() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final void userProfileDetails() {
    }
    
    private final void callOffersApi() {
    }
    
    private final void callWatchlistApi() {
    }
    
    private final void callFollowedPlaylistApi() {
    }
    
    private final void callMyPlayList() {
    }
    
    private final void followedUserList() {
    }
    
    private final void topGenres() {
    }
    
    private final void getFavouritePeople() {
    }
    
    public final void showLoader() {
    }
    
    public final void hideLoader() {
    }
    
    @java.lang.Override()
    public void onOfferClicked(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.OfferModel offer) {
    }
    
    @java.lang.Override()
    public void onPersonLongClicked(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.ActorModel actorModel) {
    }
    
    private final void showDeleteFromFavouriteDialog(com.release.plexigo.models.ActorModel actorModel) {
    }
    
    private final void removeFromFavouritesList(com.release.plexigo.models.ActorModel actorModel) {
    }
    
    @java.lang.Override()
    public void onPlanSelected(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.SubscriptionPlan plan) {
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
    
    private final void checkOnBoardingCompleted() {
    }
    
    public final void navigateToOnBoarding() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/release/plexigo/fragment/HomeProfileFragment$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "newInstance", "Lcom/release/plexigo/fragment/HomeProfileFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.release.plexigo.Common.CustomProgressDialog getCustomProgressDialog() {
            return null;
        }
        
        public final void setCustomProgressDialog(@org.jetbrains.annotations.Nullable()
        com.release.plexigo.Common.CustomProgressDialog p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.release.plexigo.fragment.HomeProfileFragment newInstance() {
            return null;
        }
    }
}