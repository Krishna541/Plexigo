package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002CDB]\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\b\u00106\u001a\u00020\u0010H\u0016J\u0010\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0010H\u0016J\u0006\u00109\u001a\u00020:J\u0018\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0010H\u0016J\u0018\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0010H\u0016J\u0006\u0010A\u001a\u00020:J\b\u0010B\u001a\u00020:H\u0002R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R.\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020 \u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R.\u0010#\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020 \u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R.\u00103\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020 \u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u0016\u00a8\u0006E"}, d2 = {"Lcom/release/plexigo/adapter/HomeFragmentContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/release/plexigo/adapter/HomeFragmentContentAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "all_contents", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/HomePageListingModel;", "Lkotlin/collections/ArrayList;", "topUserListModel", "Lcom/release/plexigo/models/TopUserListModel;", "curatedText", "", "curatedImage", "curatedLinkText", "curatedCategoryId", "", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "all_sections", "getAll_sections", "()Ljava/util/ArrayList;", "setAll_sections", "(Ljava/util/ArrayList;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "moodPlaylist", "Lcom/release/plexigo/models/UserPlaylistModel;", "getMoodPlaylist", "setMoodPlaylist", "movieList", "Lcom/release/plexigo/models/MovieModel;", "getMovieList", "setMovieList", "playlists", "getPlaylists", "setPlaylists", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "subContentLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getSubContentLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setSubContentLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "topUserListIndex", "topUserPlaylistContent", "getTopUserPlaylistContent", "setTopUserPlaylistContent", "getItemCount", "getItemViewType", "position", "hideLoader", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showLoader", "topUserListContent", "Companion", "ViewHolder", "app_debug"})
public final class HomeFragmentContentAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.release.plexigo.adapter.HomeFragmentContentAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    private int topUserListIndex;
    @org.jetbrains.annotations.NotNull()
    private androidx.recyclerview.widget.RecyclerView.LayoutManager subContentLayoutManager;
    private final java.util.ArrayList<com.release.plexigo.models.TopUserListModel> topUserListModel = null;
    private final java.lang.String curatedText = null;
    private final java.lang.String curatedImage = null;
    private final java.lang.String curatedLinkText = null;
    private final int curatedCategoryId = 0;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.release.plexigo.models.MovieModel> movieList;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.release.plexigo.models.MovieModel> playlists;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.HomePageListingModel> all_sections;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> moodPlaylist;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.release.plexigo.models.MovieModel> topUserPlaylistContent;
    @org.jetbrains.annotations.NotNull()
    private com.android.volley.RequestQueue queue;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.adapter.HomeFragmentContentAdapter.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    
    public HomeFragmentContentAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.HomePageListingModel> all_contents, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.TopUserListModel> topUserListModel, @org.jetbrains.annotations.NotNull()
    java.lang.String curatedText, @org.jetbrains.annotations.NotNull()
    java.lang.String curatedImage, @org.jetbrains.annotations.NotNull()
    java.lang.String curatedLinkText, int curatedCategoryId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView.LayoutManager getSubContentLayoutManager() {
        return null;
    }
    
    public final void setSubContentLayoutManager(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.LayoutManager p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.release.plexigo.models.MovieModel> getMovieList() {
        return null;
    }
    
    public final void setMovieList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.release.plexigo.models.MovieModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.release.plexigo.models.MovieModel> getPlaylists() {
        return null;
    }
    
    public final void setPlaylists(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.release.plexigo.models.MovieModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.HomePageListingModel> getAll_sections() {
        return null;
    }
    
    public final void setAll_sections(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.HomePageListingModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> getMoodPlaylist() {
        return null;
    }
    
    public final void setMoodPlaylist(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.release.plexigo.models.MovieModel> getTopUserPlaylistContent() {
        return null;
    }
    
    public final void setTopUserPlaylistContent(@org.jetbrains.annotations.Nullable()
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
    public com.release.plexigo.adapter.HomeFragmentContentAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.HomeFragmentContentAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    private final void topUserListContent() {
    }
    
    public final void showLoader() {
    }
    
    public final void hideLoader() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\u0004R\u001a\u00103\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&\u00a8\u00066"}, d2 = {"Lcom/release/plexigo/adapter/HomeFragmentContentAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "bottomGradient", "getBottomGradient", "()Landroid/view/View;", "setBottomGradient", "dotsIndicator", "Lcom/smarteist/autoimageslider/IndicatorView/PageIndicatorView;", "getDotsIndicator", "()Lcom/smarteist/autoimageslider/IndicatorView/PageIndicatorView;", "setDotsIndicator", "(Lcom/smarteist/autoimageslider/IndicatorView/PageIndicatorView;)V", "imgTopUser", "Landroid/widget/ImageView;", "getImgTopUser", "()Landroid/widget/ImageView;", "setImgTopUser", "(Landroid/widget/ImageView;)V", "imgTopUserLeft", "getImgTopUserLeft", "setImgTopUserLeft", "imgTopUserRight", "getImgTopUserRight", "setImgTopUserRight", "layoutTopUser", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutTopUser", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setLayoutTopUser", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "more", "Landroid/widget/TextView;", "getMore", "()Landroid/widget/TextView;", "setMore", "(Landroid/widget/TextView;)V", "section_name", "getSection_name", "setSection_name", "sub_content_list", "Landroidx/recyclerview/widget/RecyclerView;", "getSub_content_list", "()Landroidx/recyclerview/widget/RecyclerView;", "setSub_content_list", "(Landroidx/recyclerview/widget/RecyclerView;)V", "topGradient", "getTopGradient", "setTopGradient", "txtUserDetail", "getTxtUserDetail", "setTxtUserDetail", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView section_name;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView more;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txtUserDetail;
        @org.jetbrains.annotations.NotNull()
        private androidx.recyclerview.widget.RecyclerView sub_content_list;
        @org.jetbrains.annotations.NotNull()
        private android.view.View topGradient;
        @org.jetbrains.annotations.NotNull()
        private android.view.View bottomGradient;
        @org.jetbrains.annotations.NotNull()
        private androidx.constraintlayout.widget.ConstraintLayout layoutTopUser;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imgTopUser;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imgTopUserLeft;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imgTopUserRight;
        @org.jetbrains.annotations.NotNull()
        private com.smarteist.autoimageslider.IndicatorView.PageIndicatorView dotsIndicator;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View convertView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getSection_name() {
            return null;
        }
        
        public final void setSection_name(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getMore() {
            return null;
        }
        
        public final void setMore(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtUserDetail() {
            return null;
        }
        
        public final void setTxtUserDetail(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.RecyclerView getSub_content_list() {
            return null;
        }
        
        public final void setSub_content_list(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getTopGradient() {
            return null;
        }
        
        public final void setTopGradient(@org.jetbrains.annotations.NotNull()
        android.view.View p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getBottomGradient() {
            return null;
        }
        
        public final void setBottomGradient(@org.jetbrains.annotations.NotNull()
        android.view.View p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.constraintlayout.widget.ConstraintLayout getLayoutTopUser() {
            return null;
        }
        
        public final void setLayoutTopUser(@org.jetbrains.annotations.NotNull()
        androidx.constraintlayout.widget.ConstraintLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgTopUser() {
            return null;
        }
        
        public final void setImgTopUser(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgTopUserLeft() {
            return null;
        }
        
        public final void setImgTopUserLeft(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgTopUserRight() {
            return null;
        }
        
        public final void setImgTopUserRight(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.smarteist.autoimageslider.IndicatorView.PageIndicatorView getDotsIndicator() {
            return null;
        }
        
        public final void setDotsIndicator(@org.jetbrains.annotations.NotNull()
        com.smarteist.autoimageslider.IndicatorView.PageIndicatorView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/adapter/HomeFragmentContentAdapter$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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