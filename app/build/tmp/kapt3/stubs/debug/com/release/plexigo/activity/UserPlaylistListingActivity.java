package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020!J\b\u0010&\u001a\u00020!H\u0002J\b\u0010\'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0006\u0010/\u001a\u00020!J\b\u00100\u001a\u00020!H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020!H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/release/plexigo/activity/UserPlaylistListingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "followUserList", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/TopUserListModel;", "followedUserAdapter", "Lcom/release/plexigo/adapter/FollowedUserAdapter;", "getFollowedUserAdapter", "()Lcom/release/plexigo/adapter/FollowedUserAdapter;", "setFollowedUserAdapter", "(Lcom/release/plexigo/adapter/FollowedUserAdapter;)V", "playList", "Lcom/release/plexigo/models/UserPlaylistModel;", "playlistAdapter", "Lcom/release/plexigo/adapter/PlaylistAdapter;", "playlistDetailModel", "Lcom/release/plexigo/models/ViewUserPlaylistDetailModel;", "getPlaylistDetailModel", "()Lcom/release/plexigo/models/ViewUserPlaylistDetailModel;", "setPlaylistDetailModel", "(Lcom/release/plexigo/models/ViewUserPlaylistDetailModel;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "userFollowStatus", "", "userId", "followedUserList", "", "getUserPlayListDetails", "followStateUpdate", "", "hideLoader", "initData", "initView", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoader", "updateFollowBtnState", "updateFollowState", "followUnfollow", "", "userPlaylists", "Companion", "app_debug"})
public final class UserPlaylistListingActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    private final java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> playList = null;
    private final com.release.plexigo.adapter.PlaylistAdapter playlistAdapter = null;
    private final java.util.ArrayList<com.release.plexigo.models.TopUserListModel> followUserList = null;
    @org.jetbrains.annotations.NotNull()
    private com.release.plexigo.adapter.FollowedUserAdapter followedUserAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.models.ViewUserPlaylistDetailModel playlistDetailModel;
    private int userId = 0;
    private int userFollowStatus = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.UserPlaylistListingActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public UserPlaylistListingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.adapter.FollowedUserAdapter getFollowedUserAdapter() {
        return null;
    }
    
    public final void setFollowedUserAdapter(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.FollowedUserAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.models.ViewUserPlaylistDetailModel getPlaylistDetailModel() {
        return null;
    }
    
    public final void setPlaylistDetailModel(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.ViewUserPlaylistDetailModel p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void initData() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public final void showLoader() {
    }
    
    public final void hideLoader() {
    }
    
    private final void userPlaylists() {
    }
    
    private final void getUserPlayListDetails(boolean followStateUpdate) {
    }
    
    private final void updateFollowBtnState() {
    }
    
    private final void followedUserList() {
    }
    
    private final void updateFollowState(java.lang.String followUnfollow) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/UserPlaylistListingActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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
    }
}