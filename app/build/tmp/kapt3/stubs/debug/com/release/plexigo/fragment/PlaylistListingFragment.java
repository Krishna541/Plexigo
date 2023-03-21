package com.release.plexigo.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001CB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010#\u001a\u00020$J\"\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\rH\u0016J&\u0010-\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00108\u001a\u00020$H\u0002J\u0010\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020$H\u0002J\u0006\u0010=\u001a\u00020$J\b\u0010>\u001a\u00020$H\u0002J\b\u0010?\u001a\u00020$H\u0002J\b\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020$H\u0002J\b\u0010B\u001a\u00020$H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/release/plexigo/fragment/PlaylistListingFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Lcom/release/plexigo/adapter/PlaylistAdapter$OnPlayListItemSelectedListener;", "()V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "bottomSheet", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "playlistAdapter", "Lcom/release/plexigo/adapter/PlaylistAdapter;", "getPlaylistAdapter", "()Lcom/release/plexigo/adapter/PlaylistAdapter;", "setPlaylistAdapter", "(Lcom/release/plexigo/adapter/PlaylistAdapter;)V", "playlists", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/UserPlaylistModel;", "Lkotlin/collections/ArrayList;", "getPlaylists", "()Ljava/util/ArrayList;", "setPlaylists", "(Ljava/util/ArrayList;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "selectedPlaylistForOptions", "hideLoader", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPlayListItemSelected", "playlist", "onViewCreated", "view", "removePlaylist", "renamePlayList", "newTitle", "", "showDeletePlaylistDialog", "showLoader", "showRenamePlaylistDialog", "showUnFollowPlaylistDialog", "unFollowPlaylist", "updatePlaylistType", "userPlayLists", "Companion", "app_debug"})
public final class PlaylistListingFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, com.release.plexigo.adapter.PlaylistAdapter.OnPlayListItemSelectedListener {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> playlists;
    @org.jetbrains.annotations.NotNull()
    private com.release.plexigo.adapter.PlaylistAdapter playlistAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> bottomSheet;
    private final com.release.plexigo.models.UserPlaylistModel selectedPlaylistForOptions = null;
    public com.release.plexigo.network.APIInterface apiInterface;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.fragment.PlaylistListingFragment.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public PlaylistListingFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> getPlaylists() {
        return null;
    }
    
    public final void setPlaylists(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.adapter.PlaylistAdapter getPlaylistAdapter() {
        return null;
    }
    
    public final void setPlaylistAdapter(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.PlaylistAdapter p0) {
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
    
    public final void showLoader() {
    }
    
    public final void hideLoader() {
    }
    
    private final void userPlayLists() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final void showDeletePlaylistDialog() {
    }
    
    private final void showUnFollowPlaylistDialog() {
    }
    
    private final void renamePlayList(java.lang.String newTitle) {
    }
    
    private final void updatePlaylistType() {
    }
    
    private final void removePlaylist() {
    }
    
    private final void unFollowPlaylist() {
    }
    
    private final void showRenamePlaylistDialog() {
    }
    
    @java.lang.Override()
    public void onPlayListItemSelected(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.UserPlaylistModel playlist) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/release/plexigo/fragment/PlaylistListingFragment$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "newInstance", "Lcom/release/plexigo/fragment/PlaylistListingFragment;", "app_debug"})
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
        public final com.release.plexigo.fragment.PlaylistListingFragment newInstance() {
            return null;
        }
    }
}