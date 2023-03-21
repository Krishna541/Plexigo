package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003<=>B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.J\u0006\u00100\u001a\u00020,J\u0006\u00101\u001a\u00020,J\b\u00102\u001a\u00020.H\u0016J\u0010\u00103\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0016J\u001e\u00104\u001a\u00020,2\n\u00105\u001a\u00060\u0002R\u00020\u00002\b\b\u0001\u0010/\u001a\u00020.H\u0016J\u001c\u00106\u001a\u00060\u0002R\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020.H\u0016J\u0016\u0010:\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.J\u0010\u0010;\u001a\u00020,2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!\u00a8\u0006?"}, d2 = {"Lcom/release/plexigo/adapter/SearchContentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/release/plexigo/adapter/SearchContentListAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "movieList", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/MovieModel;", "Lkotlin/collections/ArrayList;", "showDeleteButton", "", "(Landroid/content/Context;Ljava/util/ArrayList;Z)V", "font", "Landroid/graphics/Typeface;", "getFont", "()Landroid/graphics/Typeface;", "setFont", "(Landroid/graphics/Typeface;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getMovieList", "()Ljava/util/ArrayList;", "setMovieList", "(Ljava/util/ArrayList;)V", "onPlayListItemDeleteClickListener", "Lcom/release/plexigo/adapter/SearchContentListAdapter$OnPlayListItemDeleteClickListener;", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "type", "getType", "setType", "AddToWatchListApi", "", "movieid", "", "position", "HideLoader", "Showloader", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeFromWatchListApi", "setOnPlayListItemDeleteClickListener", "Companion", "OnPlayListItemDeleteClickListener", "ViewHolder", "app_debug"})
public final class SearchContentListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.release.plexigo.adapter.SearchContentListAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Typeface font;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String path = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String type;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.MovieModel> movieList;
    @org.jetbrains.annotations.NotNull()
    private com.android.volley.RequestQueue queue;
    private final boolean showDeleteButton = false;
    private com.release.plexigo.adapter.SearchContentListAdapter.OnPlayListItemDeleteClickListener onPlayListItemDeleteClickListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.adapter.SearchContentListAdapter.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    
    public SearchContentListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.MovieModel> movieList, boolean showDeleteButton) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Typeface getFont() {
        return null;
    }
    
    public final void setFont(@org.jetbrains.annotations.Nullable()
    android.graphics.Typeface p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPath() {
        return null;
    }
    
    public final void setPath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.MovieModel> getMovieList() {
        return null;
    }
    
    public final void setMovieList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.MovieModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.NotNull()
    com.android.volley.RequestQueue p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.release.plexigo.adapter.SearchContentListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.SearchContentListAdapter.ViewHolder holder, @android.annotation.SuppressLint(value = {"RecyclerView"})
    int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void AddToWatchListApi(int movieid, int position) {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    public final void removeFromWatchListApi(int movieid, int position) {
    }
    
    public final void setOnPlayListItemDeleteClickListener(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.SearchContentListAdapter.OnPlayListItemDeleteClickListener onPlayListItemDeleteClickListener) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/release/plexigo/adapter/SearchContentListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Lcom/release/plexigo/adapter/SearchContentListAdapter;Landroid/view/View;)V", "add_to_Watchlist", "Landroid/widget/ImageView;", "getAdd_to_Watchlist", "()Landroid/widget/ImageView;", "setAdd_to_Watchlist", "(Landroid/widget/ImageView;)V", "content_img", "getContent_img", "setContent_img", "imgRemovePlaylistContent", "getImgRemovePlaylistContent", "setImgRemovePlaylistContent", "langyear", "Landroid/widget/TextView;", "getLangyear", "()Landroid/widget/TextView;", "setLangyear", "(Landroid/widget/TextView;)V", "movie_name", "getMovie_name", "setMovie_name", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView content_img;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView add_to_Watchlist;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imgRemovePlaylistContent;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView movie_name;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView langyear;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View convertView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getContent_img() {
            return null;
        }
        
        public final void setContent_img(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getAdd_to_Watchlist() {
            return null;
        }
        
        public final void setAdd_to_Watchlist(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgRemovePlaylistContent() {
            return null;
        }
        
        public final void setImgRemovePlaylistContent(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getMovie_name() {
            return null;
        }
        
        public final void setMovie_name(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getLangyear() {
            return null;
        }
        
        public final void setLangyear(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/release/plexigo/adapter/SearchContentListAdapter$OnPlayListItemDeleteClickListener;", "", "onDeletePlayListBtnClicked", "", "playlistContent", "Lcom/release/plexigo/models/MovieModel;", "app_debug"})
    public static abstract interface OnPlayListItemDeleteClickListener {
        
        public abstract void onDeletePlayListBtnClicked(@org.jetbrains.annotations.Nullable()
        com.release.plexigo.models.MovieModel playlistContent);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/adapter/SearchContentListAdapter$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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