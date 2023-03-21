package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\u0006\u0010,\u001a\u00020*J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020*H\u0016J\u0010\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\rH\u0016J\u0012\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\u0012\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u00107\u001a\u00020*H\u0002J\u0012\u00108\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010:\u001a\u00020*H\u0002J\u0010\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\u000fH\u0002J\b\u0010=\u001a\u00020*H\u0002J\b\u0010>\u001a\u00020*H\u0002J\u0006\u0010?\u001a\u00020*J\u0012\u0010@\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010A\u001a\u00020*H\u0002J\b\u0010B\u001a\u00020*H\u0002J\b\u0010C\u001a\u00020*H\u0002J\b\u0010D\u001a\u00020*H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(\u00a8\u0006F"}, d2 = {"Lcom/release/plexigo/activity/PlaylistContentListingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Lcom/release/plexigo/adapter/SearchContentListAdapter$OnPlayListItemDeleteClickListener;", "()V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "bottomSheet", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "playListTitle", "", "playlistContentAdapter", "Lcom/release/plexigo/adapter/SearchContentListAdapter;", "getPlaylistContentAdapter", "()Lcom/release/plexigo/adapter/SearchContentListAdapter;", "setPlaylistContentAdapter", "(Lcom/release/plexigo/adapter/SearchContentListAdapter;)V", "playlistContentList", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/MovieModel;", "getPlaylistContentList", "()Ljava/util/ArrayList;", "setPlaylistContentList", "(Ljava/util/ArrayList;)V", "playlistDetailModel", "Lcom/release/plexigo/models/PlaylistDetailModel;", "getPlaylistDetailModel", "()Lcom/release/plexigo/models/PlaylistDetailModel;", "setPlaylistDetailModel", "(Lcom/release/plexigo/models/PlaylistDetailModel;)V", "showDeleteButton", "", "getShowDeleteButton", "()Z", "setShowDeleteButton", "(Z)V", "followPlaylist", "", "getPlayListDetails", "hideLoader", "initData", "initView", "onBackPressed", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeletePlayListBtnClicked", "playlistContent", "playListContent", "removeContentFromPlaylist", "movieModel", "removePlaylist", "renamePlayList", "newTitle", "showDeletePlaylistDialog", "showFollowPlaylistDialog", "showLoader", "showRemovePlaylistDialog", "showRenamePlaylistDialog", "showUnFollowPlaylistDialog", "unFollowPlaylist", "updatePlaylistType", "Companion", "app_debug"})
public final class PlaylistContentListingActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener, com.release.plexigo.adapter.SearchContentListAdapter.OnPlayListItemDeleteClickListener {
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.SearchContentListAdapter playlistContentAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.MovieModel> playlistContentList;
    private boolean showDeleteButton = false;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.models.PlaylistDetailModel playlistDetailModel;
    private java.lang.String playListTitle = "";
    private com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> bottomSheet;
    public com.release.plexigo.network.APIInterface apiInterface;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.PlaylistContentListingActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public PlaylistContentListingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.SearchContentListAdapter getPlaylistContentAdapter() {
        return null;
    }
    
    public final void setPlaylistContentAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.SearchContentListAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.MovieModel> getPlaylistContentList() {
        return null;
    }
    
    public final void setPlaylistContentList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.MovieModel> p0) {
    }
    
    public final boolean getShowDeleteButton() {
        return false;
    }
    
    public final void setShowDeleteButton(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.models.PlaylistDetailModel getPlaylistDetailModel() {
        return null;
    }
    
    public final void setPlaylistDetailModel(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.PlaylistDetailModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
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
    
    private final void playListContent() {
    }
    
    private final void getPlayListDetails() {
    }
    
    private final void showRenamePlaylistDialog() {
    }
    
    private final void showRemovePlaylistDialog(com.release.plexigo.models.MovieModel movieModel) {
    }
    
    private final void removeContentFromPlaylist(com.release.plexigo.models.MovieModel movieModel) {
    }
    
    private final void showFollowPlaylistDialog() {
    }
    
    private final void followPlaylist() {
    }
    
    private final void showUnFollowPlaylistDialog() {
    }
    
    private final void unFollowPlaylist() {
    }
    
    private final void renamePlayList(java.lang.String newTitle) {
    }
    
    private final void showDeletePlaylistDialog() {
    }
    
    private final void removePlaylist() {
    }
    
    private final void updatePlaylistType() {
    }
    
    @java.lang.Override()
    public void onDeletePlayListBtnClicked(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.MovieModel playlistContent) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/PlaylistContentListingActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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