package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001*B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010 \u001a\u00020\nH\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0016J\u001c\u0010#\u001a\u00020$2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020\nH\u0016J\u001c\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nH\u0016R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0006j\b\u0012\u0004\u0012\u00020\u0017`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/release/plexigo/adapter/ContentMainListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/release/plexigo/adapter/ContentMainListAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "all_sections", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/ChannelCategoryModel;", "Lkotlin/collections/ArrayList;", "channelId", "", "channelType", "", "(Landroid/content/Context;Ljava/util/ArrayList;ILjava/lang/String;)V", "getAll_sections", "()Ljava/util/ArrayList;", "setAll_sections", "(Ljava/util/ArrayList;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "movieList", "Lcom/release/plexigo/models/MovieModel;", "getMovieList", "setMovieList", "subContentLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getSubContentLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setSubContentLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class ContentMainListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.release.plexigo.adapter.ContentMainListAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.ChannelCategoryModel> all_sections;
    @org.jetbrains.annotations.NotNull()
    private androidx.recyclerview.widget.RecyclerView.LayoutManager subContentLayoutManager;
    private final int channelId = 0;
    private final java.lang.String channelType = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.MovieModel> movieList;
    
    public ContentMainListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.ChannelCategoryModel> all_sections, int channelId, @org.jetbrains.annotations.NotNull()
    java.lang.String channelType) {
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
    public final java.util.ArrayList<com.release.plexigo.models.ChannelCategoryModel> getAll_sections() {
        return null;
    }
    
    public final void setAll_sections(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.ChannelCategoryModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView.LayoutManager getSubContentLayoutManager() {
        return null;
    }
    
    public final void setSubContentLayoutManager(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.LayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.MovieModel> getMovieList() {
        return null;
    }
    
    public final void setMovieList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.MovieModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.release.plexigo.adapter.ContentMainListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.ContentMainListAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/release/plexigo/adapter/ContentMainListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Lcom/release/plexigo/adapter/ContentMainListAdapter;Landroid/view/View;)V", "more", "Landroid/widget/TextView;", "getMore", "()Landroid/widget/TextView;", "setMore", "(Landroid/widget/TextView;)V", "section_name", "getSection_name", "setSection_name", "sub_content_list", "Landroidx/recyclerview/widget/RecyclerView;", "getSub_content_list", "()Landroidx/recyclerview/widget/RecyclerView;", "setSub_content_list", "(Landroidx/recyclerview/widget/RecyclerView;)V", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView section_name;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView more;
        @org.jetbrains.annotations.NotNull()
        private androidx.recyclerview.widget.RecyclerView sub_content_list;
        
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
        public final androidx.recyclerview.widget.RecyclerView getSub_content_list() {
            return null;
        }
        
        public final void setSub_content_list(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView p0) {
        }
    }
}