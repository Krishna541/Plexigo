package com.release.plexigo.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010G\u001a\u00020HH\u0002J\u0006\u0010I\u001a\u00020HJ\b\u0010J\u001a\u00020HH\u0002J\u0006\u0010K\u001a\u00020HJ\b\u0010L\u001a\u00020HH\u0002J\b\u0010M\u001a\u00020HH\u0002J\b\u0010N\u001a\u00020HH\u0002J\u0012\u0010O\u001a\u00020H2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J&\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010X\u001a\u00020HH\u0016J\b\u0010Y\u001a\u00020HH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010\'\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R\u001a\u00101\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001a\u00103\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R\u001a\u00105\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R.\u00107\u001a\u0016\u0012\u0004\u0012\u000209\u0018\u000108j\n\u0012\u0004\u0012\u000209\u0018\u0001`:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"Lcom/release/plexigo/fragment/MovieListingFragment;", "Landroidx/fragment/app/Fragment;", "()V", "CategoryId", "", "getCategoryId", "()I", "setCategoryId", "(I)V", "CurrentPageCount", "getCurrentPageCount", "setCurrentPageCount", "IsWatchHistory", "", "getIsWatchHistory", "()Z", "setIsWatchHistory", "(Z)V", "Limit", "getLimit", "setLimit", "PageCount", "getPageCount", "setPageCount", "TotalPageCount", "getTotalPageCount", "setTotalPageCount", "adapter", "Lcom/release/plexigo/adapter/SearchContentListAdapter;", "getAdapter", "()Lcom/release/plexigo/adapter/SearchContentListAdapter;", "setAdapter", "(Lcom/release/plexigo/adapter/SearchContentListAdapter;)V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "channelCategoryId", "channelId", "channelType", "", "contentTypeId", "getContentTypeId", "setContentTypeId", "endOfList", "getEndOfList", "setEndOfList", "isFilterContent", "setFilterContent", "isLibraryApiCalling", "setLibraryApiCalling", "isLoading", "setLoading", "movieList", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/MovieModel;", "Lkotlin/collections/ArrayList;", "getMovieList", "()Ljava/util/ArrayList;", "setMovieList", "(Ljava/util/ArrayList;)V", "permalink", "progressbar", "Landroid/widget/ProgressBar;", "getProgressbar", "()Landroid/widget/ProgressBar;", "setProgressbar", "(Landroid/widget/ProgressBar;)V", "showContentByChannel", "GetFilteredContent", "", "HideLoader", "ResetPreviousData", "Showloader", "contentByChannelOTT", "libraryApi", "movieListing", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "watchHistory", "Companion", "app_debug"})
public final class MovieListingFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.release.plexigo.models.MovieModel> movieList;
    private java.lang.String permalink;
    private int PageCount = 1;
    private int Limit = 20;
    private int CurrentPageCount = 1;
    private int TotalPageCount = 1;
    private int CategoryId = 101;
    private int contentTypeId = 0;
    private boolean endOfList = false;
    private boolean isLoading = false;
    private boolean isFilterContent = false;
    private boolean isLibraryApiCalling = false;
    private boolean IsWatchHistory = false;
    private boolean showContentByChannel = false;
    private int channelId = 0;
    private int channelCategoryId = 0;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.SearchContentListAdapter adapter;
    private java.lang.String channelType;
    public com.release.plexigo.network.APIInterface apiInterface;
    @org.jetbrains.annotations.Nullable()
    private android.widget.ProgressBar progressbar;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.fragment.MovieListingFragment.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private static final java.lang.String ARG_PARAM1 = "param1";
    private static final java.lang.String ARG_PARAM2 = "param2";
    private java.util.HashMap _$_findViewCache;
    
    public MovieListingFragment() {
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
    
    public final int getCategoryId() {
        return 0;
    }
    
    public final void setCategoryId(int p0) {
    }
    
    public final int getContentTypeId() {
        return 0;
    }
    
    public final void setContentTypeId(int p0) {
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
    
    public final boolean isFilterContent() {
        return false;
    }
    
    public final void setFilterContent(boolean p0) {
    }
    
    public final boolean isLibraryApiCalling() {
        return false;
    }
    
    public final void setLibraryApiCalling(boolean p0) {
    }
    
    public final boolean getIsWatchHistory() {
        return false;
    }
    
    public final void setIsWatchHistory(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.SearchContentListAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.SearchContentListAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ProgressBar getProgressbar() {
        return null;
    }
    
    public final void setProgressbar(@org.jetbrains.annotations.Nullable()
    android.widget.ProgressBar p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    public void onResume() {
    }
    
    private final void ResetPreviousData() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    private final void libraryApi() {
    }
    
    private final void watchHistory() {
    }
    
    private final void movieListing() {
    }
    
    private final void GetFilteredContent() {
    }
    
    private final void contentByChannelOTT() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J*\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/release/plexigo/fragment/MovieListingFragment$Companion;", "", "()V", "ARG_PARAM1", "", "ARG_PARAM2", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "newInstance", "Lcom/release/plexigo/fragment/MovieListingFragment;", "permalink", "param1", "channelId", "", "channelCategoryId", "type", "app_debug"})
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
        public final com.release.plexigo.fragment.MovieListingFragment newInstance(@org.jetbrains.annotations.Nullable()
        java.lang.String permalink) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.release.plexigo.fragment.MovieListingFragment newInstance(@org.jetbrains.annotations.Nullable()
        java.lang.String param1, int channelId, int channelCategoryId, @org.jetbrains.annotations.Nullable()
        java.lang.String type) {
            return null;
        }
    }
}