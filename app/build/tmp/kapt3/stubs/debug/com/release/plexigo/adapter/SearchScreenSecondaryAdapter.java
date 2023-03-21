package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0004>?@AB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000201J\u0010\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\u0006H\u0002J\b\u00105\u001a\u00020\u0006H\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0006H\u0016J\u001a\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\u00022\b\b\u0001\u00107\u001a\u00020\u0006H\u0016J\u0018\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010=\u001a\u0002012\u0006\u00104\u001a\u00020\u0006H\u0002R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R \u0010 \u001a\b\u0012\u0004\u0012\u00020!0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/release/plexigo/adapter/SearchScreenSecondaryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "viewType", "", "searchPageListingModel", "Lcom/release/plexigo/models/SearchPageListingModel;", "searchQuery", "", "(Landroid/content/Context;ILcom/release/plexigo/models/SearchPageListingModel;Ljava/lang/String;)V", "actors", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/ActorModel;", "getActors", "()Ljava/util/ArrayList;", "setActors", "(Ljava/util/ArrayList;)V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "movieList", "Lcom/release/plexigo/models/MovieModel;", "getMovieList", "playlistUsers", "Lcom/release/plexigo/models/PlaylistUserModel;", "getPlaylistUsers", "setPlaylistUsers", "playlists", "Lcom/release/plexigo/models/UserPlaylistModel;", "getPlaylists", "setPlaylists", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "t", "Ljava/util/Timer;", "getT", "()Ljava/util/Timer;", "setT", "(Ljava/util/Timer;)V", "HideLoader", "", "Showloader", "followPlaylist", "playlistId", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "showFollowPlaylistDialog", "ActorViewHolder", "MovieContentViewHolder", "PlaylistUserViewHolder", "PlaylistViewHolder", "app_debug"})
public final class SearchScreenSecondaryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    private final int viewType = 0;
    private final com.release.plexigo.models.SearchPageListingModel searchPageListingModel = null;
    @org.jetbrains.annotations.Nullable()
    private java.util.Timer t;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.release.plexigo.models.MovieModel> movieList = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> playlists;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.PlaylistUserModel> playlistUsers;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.ActorModel> actors;
    private com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    @org.jetbrains.annotations.NotNull()
    private com.android.volley.RequestQueue queue;
    private final java.lang.String searchQuery = null;
    
    public SearchScreenSecondaryAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, int viewType, @org.jetbrains.annotations.NotNull()
    com.release.plexigo.models.SearchPageListingModel searchPageListingModel, @org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery) {
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
    public final java.util.Timer getT() {
        return null;
    }
    
    public final void setT(@org.jetbrains.annotations.Nullable()
    java.util.Timer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.MovieModel> getMovieList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> getPlaylists() {
        return null;
    }
    
    public final void setPlaylists(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.PlaylistUserModel> getPlaylistUsers() {
        return null;
    }
    
    public final void setPlaylistUsers(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.PlaylistUserModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.ActorModel> getActors() {
        return null;
    }
    
    public final void setActors(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.ActorModel> p0) {
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
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, @android.annotation.SuppressLint(value = {"RecyclerView"})
    int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    private final void showFollowPlaylistDialog(int playlistId) {
    }
    
    private final void followPlaylist(int playlistId) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/release/plexigo/adapter/SearchScreenSecondaryAdapter$MovieContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "content_img", "Landroid/widget/ImageView;", "getContent_img", "()Landroid/widget/ImageView;", "setContent_img", "(Landroid/widget/ImageView;)V", "movie_name", "Landroid/widget/TextView;", "getMovie_name", "()Landroid/widget/TextView;", "setMovie_name", "(Landroid/widget/TextView;)V", "txtLanguageYear", "getTxtLanguageYear", "setTxtLanguageYear", "app_debug"})
    public static final class MovieContentViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView content_img;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView movie_name;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txtLanguageYear;
        
        public MovieContentViewHolder(@org.jetbrains.annotations.NotNull()
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
        public final android.widget.TextView getMovie_name() {
            return null;
        }
        
        public final void setMovie_name(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtLanguageYear() {
            return null;
        }
        
        public final void setTxtLanguageYear(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/release/plexigo/adapter/SearchScreenSecondaryAdapter$PlaylistViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "imgContentPoster", "Landroid/widget/ImageView;", "getImgContentPoster", "()Landroid/widget/ImageView;", "setImgContentPoster", "(Landroid/widget/ImageView;)V", "txtPlalistDetails", "Landroid/widget/TextView;", "getTxtPlalistDetails", "()Landroid/widget/TextView;", "setTxtPlalistDetails", "(Landroid/widget/TextView;)V", "txtPlaylistName", "getTxtPlaylistName", "setTxtPlaylistName", "app_debug"})
    public static final class PlaylistViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imgContentPoster;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txtPlaylistName;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txtPlalistDetails;
        
        public PlaylistViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View convertView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgContentPoster() {
            return null;
        }
        
        public final void setImgContentPoster(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtPlaylistName() {
            return null;
        }
        
        public final void setTxtPlaylistName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtPlalistDetails() {
            return null;
        }
        
        public final void setTxtPlalistDetails(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/release/plexigo/adapter/SearchScreenSecondaryAdapter$ActorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "imgActor", "Landroid/widget/ImageView;", "getImgActor", "()Landroid/widget/ImageView;", "setImgActor", "(Landroid/widget/ImageView;)V", "txtActorName", "Landroid/widget/TextView;", "getTxtActorName", "()Landroid/widget/TextView;", "setTxtActorName", "(Landroid/widget/TextView;)V", "app_debug"})
    public static final class ActorViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txtActorName;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imgActor;
        
        public ActorViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View convertView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtActorName() {
            return null;
        }
        
        public final void setTxtActorName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgActor() {
            return null;
        }
        
        public final void setImgActor(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/release/plexigo/adapter/SearchScreenSecondaryAdapter$PlaylistUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "imgPlaylistUser", "Landroid/widget/ImageView;", "getImgPlaylistUser", "()Landroid/widget/ImageView;", "setImgPlaylistUser", "(Landroid/widget/ImageView;)V", "txtPlaylistUserName", "Landroid/widget/TextView;", "getTxtPlaylistUserName", "()Landroid/widget/TextView;", "setTxtPlaylistUserName", "(Landroid/widget/TextView;)V", "app_debug"})
    public static final class PlaylistUserViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imgPlaylistUser;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txtPlaylistUserName;
        
        public PlaylistUserViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View convertView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgPlaylistUser() {
            return null;
        }
        
        public final void setImgPlaylistUser(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtPlaylistUserName() {
            return null;
        }
        
        public final void setTxtPlaylistUserName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
}