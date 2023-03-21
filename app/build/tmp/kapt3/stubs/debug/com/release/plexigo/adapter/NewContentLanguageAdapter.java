package com.release.plexigo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002)*B/\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016J\u001c\u0010\"\u001a\u00020#2\n\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\u001fH\u0016J\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u001fH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a\u00a8\u0006+"}, d2 = {"Lcom/release/plexigo/adapter/NewContentLanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/release/plexigo/adapter/NewContentLanguageAdapter$ViewHolder;", "languages", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/LanguageModel;", "Lkotlin/collections/ArrayList;", "onLanguageSelected", "Lcom/release/plexigo/adapter/NewContentLanguageAdapter$OnLanguageSelected;", "selectedLanguage", "(Ljava/util/ArrayList;Lcom/release/plexigo/adapter/NewContentLanguageAdapter$OnLanguageSelected;Lcom/release/plexigo/models/LanguageModel;)V", "font", "Landroid/graphics/Typeface;", "getFont", "()Landroid/graphics/Typeface;", "setFont", "(Landroid/graphics/Typeface;)V", "getLanguages", "()Ljava/util/ArrayList;", "setLanguages", "(Ljava/util/ArrayList;)V", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "type", "getType", "setType", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnLanguageSelected", "ViewHolder", "app_debug"})
public final class NewContentLanguageAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.release.plexigo.adapter.NewContentLanguageAdapter.ViewHolder> {
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Typeface font;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String path = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String type;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.LanguageModel> languages;
    private final com.release.plexigo.adapter.NewContentLanguageAdapter.OnLanguageSelected onLanguageSelected = null;
    private final com.release.plexigo.models.LanguageModel selectedLanguage = null;
    
    public NewContentLanguageAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.LanguageModel> languages, @org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.NewContentLanguageAdapter.OnLanguageSelected onLanguageSelected, @org.jetbrains.annotations.NotNull()
    com.release.plexigo.models.LanguageModel selectedLanguage) {
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
    public final java.util.ArrayList<com.release.plexigo.models.LanguageModel> getLanguages() {
        return null;
    }
    
    public final void setLanguages(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.LanguageModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.release.plexigo.adapter.NewContentLanguageAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.adapter.NewContentLanguageAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/release/plexigo/adapter/NewContentLanguageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Lcom/release/plexigo/adapter/NewContentLanguageAdapter;Landroid/view/View;)V", "txtContentLanguage", "Landroid/widget/TextView;", "getTxtContentLanguage", "()Landroid/widget/TextView;", "setTxtContentLanguage", "(Landroid/widget/TextView;)V", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView txtContentLanguage;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View convertView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtContentLanguage() {
            return null;
        }
        
        public final void setTxtContentLanguage(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/release/plexigo/adapter/NewContentLanguageAdapter$OnLanguageSelected;", "", "onLanguageSelected", "", "language", "Lcom/release/plexigo/models/LanguageModel;", "app_debug"})
    public static abstract interface OnLanguageSelected {
        
        public abstract void onLanguageSelected(@org.jetbrains.annotations.Nullable()
        com.release.plexigo.models.LanguageModel language);
    }
}