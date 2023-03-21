package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002&\'B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u001c\u0010\u001f\u001a\u00020 2\n\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u001c\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018\u00a8\u0006("}, d2 = {"Lcom/release/plexigo/adapter/SubscriptionInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/release/plexigo/adapter/SubscriptionInfoAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "subscriptionInfoList", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/SubscriptionInfoModel;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "isExpanded", "", "()Z", "setExpanded", "(Z)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "subscriptionDescription", "Lcom/release/plexigo/models/InfoDetailsModel;", "getSubscriptionDescription", "()Ljava/util/ArrayList;", "setSubscriptionDescription", "(Ljava/util/ArrayList;)V", "getSubscriptionInfoList", "setSubscriptionInfoList", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "app_debug"})
public final class SubscriptionInfoAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.release.plexigo.adapter.SubscriptionInfoAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.SubscriptionInfoModel> subscriptionInfoList;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.release.plexigo.models.InfoDetailsModel> subscriptionDescription;
    private boolean isExpanded = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.adapter.SubscriptionInfoAdapter.Companion Companion = null;
    private static int currentPosition = -1;
    
    public SubscriptionInfoAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.SubscriptionInfoModel> subscriptionInfoList) {
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
    public final java.util.ArrayList<com.release.plexigo.models.SubscriptionInfoModel> getSubscriptionInfoList() {
        return null;
    }
    
    public final void setSubscriptionInfoList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.SubscriptionInfoModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.release.plexigo.models.InfoDetailsModel> getSubscriptionDescription() {
        return null;
    }
    
    public final void setSubscriptionDescription(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.release.plexigo.models.InfoDetailsModel> p0) {
    }
    
    public final boolean isExpanded() {
        return false;
    }
    
    public final void setExpanded(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.release.plexigo.adapter.SubscriptionInfoAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.SubscriptionInfoAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/release/plexigo/adapter/SubscriptionInfoAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/release/plexigo/adapter/SubscriptionInfoAdapter;Landroid/view/View;)V", "imgRightArrow", "Landroid/widget/ImageView;", "getImgRightArrow", "()Landroid/widget/ImageView;", "setImgRightArrow", "(Landroid/widget/ImageView;)V", "moreDetails", "Landroid/widget/LinearLayout;", "getMoreDetails", "()Landroid/widget/LinearLayout;", "setMoreDetails", "(Landroid/widget/LinearLayout;)V", "subscriptionInfoValueRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getSubscriptionInfoValueRecyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setSubscriptionInfoValueRecyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "subscriptionTitle", "Landroid/widget/TextView;", "getSubscriptionTitle", "()Landroid/widget/TextView;", "setSubscriptionTitle", "(Landroid/widget/TextView;)V", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imgRightArrow;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView subscriptionTitle;
        @org.jetbrains.annotations.NotNull()
        private android.widget.LinearLayout moreDetails;
        @org.jetbrains.annotations.NotNull()
        private androidx.recyclerview.widget.RecyclerView subscriptionInfoValueRecyclerview;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgRightArrow() {
            return null;
        }
        
        public final void setImgRightArrow(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getSubscriptionTitle() {
            return null;
        }
        
        public final void setSubscriptionTitle(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getMoreDetails() {
            return null;
        }
        
        public final void setMoreDetails(@org.jetbrains.annotations.NotNull()
        android.widget.LinearLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.RecyclerView getSubscriptionInfoValueRecyclerview() {
            return null;
        }
        
        public final void setSubscriptionInfoValueRecyclerview(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/release/plexigo/adapter/SubscriptionInfoAdapter$Companion;", "", "()V", "currentPosition", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}