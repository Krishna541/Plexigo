package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u001f\u001a\u00020\u00172\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/release/plexigo/adapter/PopularChannelsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/release/plexigo/adapter/PopularChannelsAdapter$ChannelViewHolder;", "mContext", "Landroid/content/Context;", "channels", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/ChannelFestivalModel;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getChannels", "()Ljava/util/ArrayList;", "setChannels", "(Ljava/util/ArrayList;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "onChannelClickListener", "Lcom/release/plexigo/adapter/PopularChannelsAdapter$OnChannelClick;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnChannelClickListener", "updateList", "ChannelViewHolder", "OnChannelClick", "app_debug"})
public final class PopularChannelsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.release.plexigo.adapter.PopularChannelsAdapter.ChannelViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> channels;
    private com.release.plexigo.adapter.PopularChannelsAdapter.OnChannelClick onChannelClickListener;
    
    public PopularChannelsAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> channels) {
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
    public final java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> getChannels() {
        return null;
    }
    
    public final void setChannels(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.release.plexigo.adapter.PopularChannelsAdapter.ChannelViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.PopularChannelsAdapter.ChannelViewHolder holder, @android.annotation.SuppressLint(value = {"RecyclerView"})
    int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.release.plexigo.models.ChannelFestivalModel> channels) {
    }
    
    public final void setOnChannelClickListener(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.PopularChannelsAdapter.OnChannelClick onChannelClickListener) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/release/plexigo/adapter/PopularChannelsAdapter$ChannelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "imgChannel", "Landroid/widget/ImageView;", "getImgChannel", "()Landroid/widget/ImageView;", "setImgChannel", "(Landroid/widget/ImageView;)V", "txtIsSubscribed", "Landroid/widget/TextView;", "getTxtIsSubscribed", "()Landroid/widget/TextView;", "setTxtIsSubscribed", "(Landroid/widget/TextView;)V", "app_debug"})
    public static final class ChannelViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imgChannel;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txtIsSubscribed;
        
        public ChannelViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View convertView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgChannel() {
            return null;
        }
        
        public final void setImgChannel(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtIsSubscribed() {
            return null;
        }
        
        public final void setTxtIsSubscribed(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/adapter/PopularChannelsAdapter$OnChannelClick;", "", "onChannelClicked", "", "channelId", "", "channelName", "", "type", "app_debug"})
    public static abstract interface OnChannelClick {
        
        public abstract void onChannelClicked(int channelId, @org.jetbrains.annotations.Nullable()
        java.lang.String channelName, @org.jetbrains.annotations.Nullable()
        java.lang.String type);
    }
}