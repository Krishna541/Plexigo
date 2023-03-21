package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020/J\b\u00101\u001a\u00020/H\u0002J\b\u00102\u001a\u00020/H\u0002J\u0010\u00103\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0016J\u0012\u00106\u001a\u00020/2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\u0006\u00109\u001a\u00020/R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/release/plexigo/activity/FestivalContentListingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "festivalId", "", "filmEventData", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/FilmEventData;", "getFilmEventData", "()Ljava/util/ArrayList;", "setFilmEventData", "(Ljava/util/ArrayList;)V", "filmEvents", "Lcom/release/plexigo/models/FilmEvent;", "getFilmEvents", "setFilmEvents", "filmEventsAdapter", "Lcom/release/plexigo/adapter/FilmEventsAdapter;", "filmScreeningAdapter", "Lcom/release/plexigo/adapter/FilmScreeningsAdapter;", "filmScreeningData", "Lcom/release/plexigo/models/FilmScreeningData;", "getFilmScreeningData", "setFilmScreeningData", "filmScreenings", "Lcom/release/plexigo/models/FilmScreening;", "getFilmScreenings", "setFilmScreenings", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "selectedFilmEvent", "selectedFilmScreening", "spnEvents", "Landroid/widget/Spinner;", "spnScreenings", "festivalDetails", "", "hideLoader", "initData", "initView", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoader", "Companion", "app_debug"})
public final class FestivalContentListingActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    public com.release.plexigo.network.APIInterface apiInterface;
    private android.widget.Spinner spnScreenings;
    private android.widget.Spinner spnEvents;
    private com.release.plexigo.models.FilmScreening selectedFilmScreening;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.FilmScreening> filmScreenings;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.FilmScreeningData> filmScreeningData;
    private com.release.plexigo.adapter.FilmScreeningsAdapter filmScreeningAdapter;
    private com.release.plexigo.models.FilmEvent selectedFilmEvent;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.FilmEvent> filmEvents;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.FilmEventData> filmEventData;
    private com.release.plexigo.adapter.FilmEventsAdapter filmEventsAdapter;
    private int festivalId = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.FestivalContentListingActivity.Companion Companion = null;
    public static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public FestivalContentListingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FilmScreening> getFilmScreenings() {
        return null;
    }
    
    public final void setFilmScreenings(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmScreening> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FilmScreeningData> getFilmScreeningData() {
        return null;
    }
    
    public final void setFilmScreeningData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmScreeningData> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FilmEvent> getFilmEvents() {
        return null;
    }
    
    public final void setFilmEvents(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmEvent> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FilmEventData> getFilmEventData() {
        return null;
    }
    
    public final void setFilmEventData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmEventData> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void initData() {
    }
    
    public final void showLoader() {
    }
    
    public final void hideLoader() {
    }
    
    private final void festivalDetails() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/FestivalContentListingActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.release.plexigo.Common.CustomProgressDialog getCustomProgressDialog() {
            return null;
        }
        
        public final void setCustomProgressDialog(@org.jetbrains.annotations.NotNull()
        com.release.plexigo.Common.CustomProgressDialog p0) {
        }
    }
}