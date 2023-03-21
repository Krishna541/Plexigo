package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002()B\'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u001c\u0010!\u001a\u00020\"2\n\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u001eH\u0016J\u001c\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u001eH\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/release/plexigo/adapter/SubscriptionPlansAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/release/plexigo/adapter/SubscriptionPlansAdapter$ViewHolder;", "subscriptionPlans", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/SubscriptionPlan;", "Lkotlin/collections/ArrayList;", "onPlanSelected", "Lcom/release/plexigo/adapter/SubscriptionPlansAdapter$OnPlanSelected;", "(Ljava/util/ArrayList;Lcom/release/plexigo/adapter/SubscriptionPlansAdapter$OnPlanSelected;)V", "font", "Landroid/graphics/Typeface;", "getFont", "()Landroid/graphics/Typeface;", "setFont", "(Landroid/graphics/Typeface;)V", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getSubscriptionPlans", "()Ljava/util/ArrayList;", "setSubscriptionPlans", "(Ljava/util/ArrayList;)V", "type", "getType", "setType", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnPlanSelected", "ViewHolder", "app_debug"})
public final class SubscriptionPlansAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.release.plexigo.adapter.SubscriptionPlansAdapter.ViewHolder> {
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Typeface font;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String path = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String type;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.SubscriptionPlan> subscriptionPlans;
    private final com.release.plexigo.adapter.SubscriptionPlansAdapter.OnPlanSelected onPlanSelected = null;
    
    public SubscriptionPlansAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.SubscriptionPlan> subscriptionPlans, @org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.SubscriptionPlansAdapter.OnPlanSelected onPlanSelected) {
        super();
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
    public final java.util.ArrayList<com.release.plexigo.models.SubscriptionPlan> getSubscriptionPlans() {
        return null;
    }
    
    public final void setSubscriptionPlans(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.SubscriptionPlan> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.release.plexigo.adapter.SubscriptionPlansAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.SubscriptionPlansAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/release/plexigo/adapter/SubscriptionPlansAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Lcom/release/plexigo/adapter/SubscriptionPlansAdapter;Landroid/view/View;)V", "txtLanguage", "Landroid/widget/TextView;", "getTxtLanguage", "()Landroid/widget/TextView;", "setTxtLanguage", "(Landroid/widget/TextView;)V", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txtLanguage;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View convertView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtLanguage() {
            return null;
        }
        
        public final void setTxtLanguage(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/release/plexigo/adapter/SubscriptionPlansAdapter$OnPlanSelected;", "", "onPlanSelected", "", "plan", "Lcom/release/plexigo/models/SubscriptionPlan;", "app_debug"})
    public static abstract interface OnPlanSelected {
        
        public abstract void onPlanSelected(@org.jetbrains.annotations.Nullable()
        com.release.plexigo.models.SubscriptionPlan plan);
    }
}