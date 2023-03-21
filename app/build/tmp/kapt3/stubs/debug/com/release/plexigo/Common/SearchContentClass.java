package com.release.plexigo.Common;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ \u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ.\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ0\u0010$\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J \u0010%\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010&\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\'\u001a\u00020\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006)"}, d2 = {"Lcom/release/plexigo/Common/SearchContentClass;", "", "ctx", "Landroid/content/Context;", "listener", "Lcom/release/plexigo/Common/SearchContentClass$SearchDataListener;", "(Landroid/content/Context;Lcom/release/plexigo/Common/SearchContentClass$SearchDataListener;)V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "apiJob", "Lkotlinx/coroutines/Job;", "getCtx", "()Landroid/content/Context;", "setCtx", "(Landroid/content/Context;)V", "getListener", "()Lcom/release/plexigo/Common/SearchContentClass$SearchDataListener;", "setListener", "(Lcom/release/plexigo/Common/SearchContentClass$SearchDataListener;)V", "performSearch", "", "searchQuery", "", "pageNo", "", "noOfRecords", "searchActors", "searchString", "searchContent", "searchtext", "searchFor", "categoryId", "searchMovies", "searchPlaylistUsers", "searchPlaylists", "stopSearch", "SearchDataListener", "app_debug"})
public final class SearchContentClass {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context ctx;
    @org.jetbrains.annotations.NotNull()
    private com.release.plexigo.Common.SearchContentClass.SearchDataListener listener;
    @org.jetbrains.annotations.NotNull()
    private com.release.plexigo.network.APIInterface apiInterface;
    private kotlinx.coroutines.Job apiJob;
    
    public SearchContentClass(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx, @org.jetbrains.annotations.NotNull()
    com.release.plexigo.Common.SearchContentClass.SearchDataListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getCtx() {
        return null;
    }
    
    public final void setCtx(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.Common.SearchContentClass.SearchDataListener getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.Common.SearchContentClass.SearchDataListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
    }
    
    public final void searchContent(@org.jetbrains.annotations.NotNull()
    java.lang.String searchtext, @org.jetbrains.annotations.NotNull()
    java.lang.String searchFor, int categoryId, int pageNo, int noOfRecords) {
    }
    
    public final void performSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery, int pageNo, int noOfRecords) {
    }
    
    public final void stopSearch() {
    }
    
    private final void searchMovies(java.lang.String searchString, java.lang.String searchFor, int categoryId, int pageNo, int noOfRecords) {
    }
    
    public final void searchPlaylists(@org.jetbrains.annotations.Nullable()
    java.lang.String searchString) {
    }
    
    public final void searchActors(@org.jetbrains.annotations.Nullable()
    java.lang.String searchString, int pageNo, int noOfRecords) {
    }
    
    public final void searchPlaylistUsers(@org.jetbrains.annotations.Nullable()
    java.lang.String searchString, int pageNo, int noOfRecords) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007H&J$\u0010\b\u001a\u00020\u00032\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0007H&J$\u0010\u000b\u001a\u00020\u00032\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u0007H&J$\u0010\u000e\u001a\u00020\u00032\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0007H&\u00a8\u0006\u0011"}, d2 = {"Lcom/release/plexigo/Common/SearchContentClass$SearchDataListener;", "", "OnContentListLoaded", "", "all_movies", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/MovieModel;", "Lkotlin/collections/ArrayList;", "onActorsLoaded", "actors", "Lcom/release/plexigo/models/ActorModel;", "onPlayListUsersLoaded", "playlistUsers", "Lcom/release/plexigo/models/PlaylistUserModel;", "onPlaylistLoaded", "playlists", "Lcom/release/plexigo/models/UserPlaylistModel;", "app_debug"})
    public static abstract interface SearchDataListener {
        
        public abstract void OnContentListLoaded(@org.jetbrains.annotations.Nullable()
        java.util.ArrayList<com.release.plexigo.models.MovieModel> all_movies);
        
        public abstract void onPlaylistLoaded(@org.jetbrains.annotations.Nullable()
        java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> playlists);
        
        public abstract void onActorsLoaded(@org.jetbrains.annotations.Nullable()
        java.util.ArrayList<com.release.plexigo.models.ActorModel> actors);
        
        public abstract void onPlayListUsersLoaded(@org.jetbrains.annotations.Nullable()
        java.util.ArrayList<com.release.plexigo.models.PlaylistUserModel> playlistUsers);
    }
}