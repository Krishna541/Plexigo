package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/release/plexigo/adapter/StateSelectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/release/plexigo/adapter/StateSelectionAdapter$ViewHolder;", "states", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/StateModel;", "Lkotlin/collections/ArrayList;", "onStateSelected", "Lcom/release/plexigo/adapter/StateSelectionAdapter$OnStateSelected;", "(Ljava/util/ArrayList;Lcom/release/plexigo/adapter/StateSelectionAdapter$OnStateSelected;)V", "getStates", "()Ljava/util/ArrayList;", "setStates", "(Ljava/util/ArrayList;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnStateSelected", "ViewHolder", "app_debug"})
public final class StateSelectionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.release.plexigo.adapter.StateSelectionAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.StateModel> states;
    private final com.release.plexigo.adapter.StateSelectionAdapter.OnStateSelected onStateSelected = null;
    
    public StateSelectionAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.StateModel> states, @org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.StateSelectionAdapter.OnStateSelected onStateSelected) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.StateModel> getStates() {
        return null;
    }
    
    public final void setStates(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.StateModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.release.plexigo.adapter.StateSelectionAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.StateSelectionAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/release/plexigo/adapter/StateSelectionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Lcom/release/plexigo/adapter/StateSelectionAdapter;Landroid/view/View;)V", "txtLanguage", "Landroid/widget/TextView;", "getTxtLanguage", "()Landroid/widget/TextView;", "setTxtLanguage", "(Landroid/widget/TextView;)V", "app_debug"})
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/release/plexigo/adapter/StateSelectionAdapter$OnStateSelected;", "", "onStateSelected", "", "state", "Lcom/release/plexigo/models/StateModel;", "app_debug"})
    public static abstract interface OnStateSelected {
        
        public abstract void onStateSelected(@org.jetbrains.annotations.Nullable()
        com.release.plexigo.models.StateModel state);
    }
}