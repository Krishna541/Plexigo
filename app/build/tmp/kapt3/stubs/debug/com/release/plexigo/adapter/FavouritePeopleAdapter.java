package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002&\'B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u001c\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u001c\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001bH\u0016J\u0010\u0010%\u001a\u00020\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006("}, d2 = {"Lcom/release/plexigo/adapter/FavouritePeopleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/release/plexigo/adapter/FavouritePeopleAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "actorList", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/ActorModel;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getActorList", "()Ljava/util/ArrayList;", "setActorList", "(Ljava/util/ArrayList;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "onPersonLongClick", "Lcom/release/plexigo/adapter/FavouritePeopleAdapter$OnPersonLongClick;", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnPersonLongClickListener", "OnPersonLongClick", "ViewHolder", "app_debug"})
public final class FavouritePeopleAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.release.plexigo.adapter.FavouritePeopleAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String path = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.ActorModel> actorList;
    private com.release.plexigo.adapter.FavouritePeopleAdapter.OnPersonLongClick onPersonLongClick;
    
    public FavouritePeopleAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.ActorModel> actorList) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.ActorModel> getActorList() {
        return null;
    }
    
    public final void setActorList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.ActorModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.release.plexigo.adapter.FavouritePeopleAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.FavouritePeopleAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setOnPersonLongClickListener(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.FavouritePeopleAdapter.OnPersonLongClick onPersonLongClick) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/release/plexigo/adapter/FavouritePeopleAdapter$OnPersonLongClick;", "", "onPersonLongClicked", "", "actorModel", "Lcom/release/plexigo/models/ActorModel;", "app_debug"})
    public static abstract interface OnPersonLongClick {
        
        public abstract void onPersonLongClicked(@org.jetbrains.annotations.Nullable()
        com.release.plexigo.models.ActorModel actorModel);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/release/plexigo/adapter/FavouritePeopleAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Lcom/release/plexigo/adapter/FavouritePeopleAdapter;Landroid/view/View;)V", "imgCastCrew", "Landroid/widget/ImageView;", "getImgCastCrew", "()Landroid/widget/ImageView;", "setImgCastCrew", "(Landroid/widget/ImageView;)V", "txtNameCastCrew", "Landroid/widget/TextView;", "getTxtNameCastCrew", "()Landroid/widget/TextView;", "setTxtNameCastCrew", "(Landroid/widget/TextView;)V", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imgCastCrew;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txtNameCastCrew;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View convertView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgCastCrew() {
            return null;
        }
        
        public final void setImgCastCrew(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtNameCastCrew() {
            return null;
        }
        
        public final void setTxtNameCastCrew(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
}