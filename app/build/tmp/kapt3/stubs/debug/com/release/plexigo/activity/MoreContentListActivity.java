package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00101\u001a\u000202H\u0002J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u000202J\u0012\u00105\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000107H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R.\u0010#\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00068"}, d2 = {"Lcom/release/plexigo/activity/MoreContentListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CurrentPageCount", "", "getCurrentPageCount", "()I", "setCurrentPageCount", "(I)V", "Limit", "getLimit", "setLimit", "PageCount", "getPageCount", "setPageCount", "TotalPageCount", "getTotalPageCount", "setTotalPageCount", "adapter", "Lcom/release/plexigo/adapter/SearchContentListAdapter;", "getAdapter", "()Lcom/release/plexigo/adapter/SearchContentListAdapter;", "setAdapter", "(Lcom/release/plexigo/adapter/SearchContentListAdapter;)V", "categoryId", "getCategoryId", "setCategoryId", "endOfList", "", "getEndOfList", "()Z", "setEndOfList", "(Z)V", "isLoading", "setLoading", "movieList", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/MovieModel;", "Lkotlin/collections/ArrayList;", "getMovieList", "()Ljava/util/ArrayList;", "setMovieList", "(Ljava/util/ArrayList;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "GetMovieListing", "", "HideLoader", "Showloader", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MoreContentListActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.release.plexigo.models.MovieModel> movieList;
    private int PageCount = 1;
    private int Limit = 20;
    private int CurrentPageCount = 1;
    private int TotalPageCount = 1;
    private boolean endOfList = false;
    private boolean isLoading = false;
    private int categoryId = 0;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.SearchContentListAdapter adapter;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    private java.util.HashMap _$_findViewCache;
    
    public MoreContentListActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.release.plexigo.models.MovieModel> getMovieList() {
        return null;
    }
    
    public final void setMovieList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.release.plexigo.models.MovieModel> p0) {
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
    
    public final boolean getEndOfList() {
        return false;
    }
    
    public final void setEndOfList(boolean p0) {
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final void setLoading(boolean p0) {
    }
    
    public final int getCategoryId() {
        return 0;
    }
    
    public final void setCategoryId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.SearchContentListAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.SearchContentListAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void GetMovieListing() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
}