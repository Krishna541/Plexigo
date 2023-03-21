package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u0006\u00100\u001a\u00020-J\u0006\u00101\u001a\u00020-J\b\u00102\u001a\u00020-H\u0016J\u0012\u00103\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0006\u00106\u001a\u00020-R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00068"}, d2 = {"Lcom/release/plexigo/activity/FilterMoviesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter1", "Lcom/release/plexigo/adapter/SortCategoriesAdapter;", "getAdapter1", "()Lcom/release/plexigo/adapter/SortCategoriesAdapter;", "setAdapter1", "(Lcom/release/plexigo/adapter/SortCategoriesAdapter;)V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "genreFilterAdapter", "Lcom/release/plexigo/adapter/GenreListAdapter;", "getGenreFilterAdapter", "()Lcom/release/plexigo/adapter/GenreListAdapter;", "setGenreFilterAdapter", "(Lcom/release/plexigo/adapter/GenreListAdapter;)V", "isResetWithoutApply", "", "()Z", "setResetWithoutApply", "(Z)V", "languageFilterAdapter", "Lcom/release/plexigo/adapter/LanguageFilterAdapter;", "getLanguageFilterAdapter", "()Lcom/release/plexigo/adapter/LanguageFilterAdapter;", "setLanguageFilterAdapter", "(Lcom/release/plexigo/adapter/LanguageFilterAdapter;)V", "ottFilterAdapter", "Lcom/release/plexigo/adapter/OTTFilterAdapter;", "getOttFilterAdapter", "()Lcom/release/plexigo/adapter/OTTFilterAdapter;", "setOttFilterAdapter", "(Lcom/release/plexigo/adapter/OTTFilterAdapter;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "GetGenreApi", "", "GetOTTsApi", "HideLoader", "Showloader", "languagesList", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setData", "Companion", "app_debug"})
public final class FilterMoviesActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.GenreListAdapter genreFilterAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.LanguageFilterAdapter languageFilterAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.OTTFilterAdapter ottFilterAdapter;
    private boolean isResetWithoutApply = false;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.SortCategoriesAdapter adapter1;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    public com.release.plexigo.network.APIInterface apiInterface;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.FilterMoviesActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public FilterMoviesActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.GenreListAdapter getGenreFilterAdapter() {
        return null;
    }
    
    public final void setGenreFilterAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.GenreListAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.LanguageFilterAdapter getLanguageFilterAdapter() {
        return null;
    }
    
    public final void setLanguageFilterAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.LanguageFilterAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.OTTFilterAdapter getOttFilterAdapter() {
        return null;
    }
    
    public final void setOttFilterAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.OTTFilterAdapter p0) {
    }
    
    public final boolean isResetWithoutApply() {
        return false;
    }
    
    public final void setResetWithoutApply(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.SortCategoriesAdapter getAdapter1() {
        return null;
    }
    
    public final void setAdapter1(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.SortCategoriesAdapter p0) {
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
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public final void setData() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    public final void GetGenreApi() {
    }
    
    public final void GetOTTsApi() {
    }
    
    public final void languagesList() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/FilterMoviesActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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