package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000201B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010\'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J\u001e\u0010)\u001a\u00020*2\n\u0010+\u001a\u00060\u0002R\u00020\u00002\b\b\u0001\u0010(\u001a\u00020&H\u0016J\u001c\u0010,\u001a\u00060\u0002R\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&H\u0016R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001f\u00a8\u00062"}, d2 = {"Lcom/release/plexigo/adapter/OTTAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/release/plexigo/adapter/OTTAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "all_otts", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/OTTModel;", "Lkotlin/collections/ArrayList;", "plexigo_amount", "", "rentValidity", "listener", "Lcom/release/plexigo/adapter/OTTAdapter$OTTClickHandler;", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Lcom/release/plexigo/adapter/OTTAdapter$OTTClickHandler;)V", "getAll_otts", "()Ljava/util/ArrayList;", "setAll_otts", "(Ljava/util/ArrayList;)V", "getListener", "()Lcom/release/plexigo/adapter/OTTAdapter$OTTClickHandler;", "setListener", "(Lcom/release/plexigo/adapter/OTTAdapter$OTTClickHandler;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "path", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getPlexigo_amount", "setPlexigo_amount", "type", "getType", "setType", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OTTClickHandler", "ViewHolder", "app_debug"})
public final class OTTAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.release.plexigo.adapter.OTTAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String path = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String type;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.OTTModel> all_otts;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String plexigo_amount;
    private final java.lang.String rentValidity = null;
    @org.jetbrains.annotations.NotNull()
    private com.release.plexigo.adapter.OTTAdapter.OTTClickHandler listener;
    
    public OTTAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.OTTModel> all_otts, @org.jetbrains.annotations.NotNull()
    java.lang.String plexigo_amount, @org.jetbrains.annotations.NotNull()
    java.lang.String rentValidity, @org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.OTTAdapter.OTTClickHandler listener) {
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
    public final java.util.ArrayList<com.release.plexigo.models.OTTModel> getAll_otts() {
        return null;
    }
    
    public final void setAll_otts(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.OTTModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlexigo_amount() {
        return null;
    }
    
    public final void setPlexigo_amount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.adapter.OTTAdapter.OTTClickHandler getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.OTTAdapter.OTTClickHandler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.release.plexigo.adapter.OTTAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.OTTAdapter.ViewHolder holder, @android.annotation.SuppressLint(value = {"RecyclerView"})
    int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/release/plexigo/adapter/OTTAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Lcom/release/plexigo/adapter/OTTAdapter;Landroid/view/View;)V", "ott_icon", "Landroid/widget/ImageView;", "getOtt_icon", "()Landroid/widget/ImageView;", "setOtt_icon", "(Landroid/widget/ImageView;)V", "ppv_amount_ott", "Landroid/widget/TextView;", "getPpv_amount_ott", "()Landroid/widget/TextView;", "setPpv_amount_ott", "(Landroid/widget/TextView;)V", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView ott_icon;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView ppv_amount_ott;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View convertView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getOtt_icon() {
            return null;
        }
        
        public final void setOtt_icon(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getPpv_amount_ott() {
            return null;
        }
        
        public final void setPpv_amount_ott(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/release/plexigo/adapter/OTTAdapter$OTTClickHandler;", "", "OnOttClick", "", "ottModel", "Lcom/release/plexigo/models/OTTModel;", "onImageLoaded", "app_debug"})
    public static abstract interface OTTClickHandler {
        
        public abstract void onImageLoaded();
        
        public abstract void OnOttClick(@org.jetbrains.annotations.Nullable()
        com.release.plexigo.models.OTTModel ottModel);
    }
}