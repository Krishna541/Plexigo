package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\'H\u0002J\u0006\u0010.\u001a\u00020,J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J\u0006\u00102\u001a\u00020,J\b\u00103\u001a\u00020,H\u0002J\b\u00104\u001a\u00020,H\u0002J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u00020,2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0012\u0010;\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010<\u001a\u00020,H\u0016J\b\u0010=\u001a\u00020,H\u0002J\u0006\u0010>\u001a\u00020,J\b\u0010?\u001a\u00020,H\u0002J\b\u0010@\u001a\u00020,H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\'0&j\b\u0012\u0004\u0012\u00020\'`(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/release/plexigo/activity/PlaylistListingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Lcom/release/plexigo/adapter/PlaylistAdapter$OnPlayListItemSelectedListener;", "()V", "CurrentPageCount", "", "getCurrentPageCount", "()I", "setCurrentPageCount", "(I)V", "Limit", "getLimit", "setLimit", "PageCount", "getPageCount", "setPageCount", "TotalPageCount", "getTotalPageCount", "setTotalPageCount", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "endOfList", "", "getEndOfList", "()Z", "setEndOfList", "(Z)V", "isLoading", "()Ljava/lang/Boolean;", "setLoading", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "playList", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/UserPlaylistModel;", "Lkotlin/collections/ArrayList;", "playlistAdapter", "Lcom/release/plexigo/adapter/PlaylistAdapter;", "addContentToPlayList", "", "playlist", "callFollowedPlaylistApi", "createPlaylist", "title", "", "hideLoader", "initData", "initView", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPlayListItemSelected", "onResume", "showCreatePlaylistDialog", "showLoader", "suggestedPlaylists", "userPlayLists", "Companion", "app_debug"})
public final class PlaylistListingActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener, com.release.plexigo.adapter.PlaylistAdapter.OnPlayListItemSelectedListener {
    private final java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> playList = null;
    private final com.release.plexigo.adapter.PlaylistAdapter playlistAdapter = null;
    public com.release.plexigo.network.APIInterface apiInterface;
    private boolean endOfList = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean isLoading = false;
    private int PageCount = 1;
    private int Limit = 10;
    private int CurrentPageCount = 1;
    private int TotalPageCount = 1;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.PlaylistListingActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public PlaylistListingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
    }
    
    public final boolean getEndOfList() {
        return false;
    }
    
    public final void setEndOfList(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isLoading() {
        return null;
    }
    
    public final void setLoading(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    public final int getPageCount() {
        return 0;
    }
    
    public final void setPageCount(int p0) {
    }
    
    public final int getLimit() {
        return 0;
    }
    
    public final void setLimit(int p0) {
    }
    
    public final int getCurrentPageCount() {
        return 0;
    }
    
    public final void setCurrentPageCount(int p0) {
    }
    
    public final int getTotalPageCount() {
        return 0;
    }
    
    public final void setTotalPageCount(int p0) {
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
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onPlayListItemSelected(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.UserPlaylistModel playlist) {
    }
    
    public final void showLoader() {
    }
    
    public final void hideLoader() {
    }
    
    private final void userPlayLists() {
    }
    
    public final void callFollowedPlaylistApi() {
    }
    
    private final void suggestedPlaylists() {
    }
    
    private final void showCreatePlaylistDialog() {
    }
    
    private final void createPlaylist(java.lang.String title) {
    }
    
    private final void addContentToPlayList(com.release.plexigo.models.UserPlaylistModel playlist) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/PlaylistListingActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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