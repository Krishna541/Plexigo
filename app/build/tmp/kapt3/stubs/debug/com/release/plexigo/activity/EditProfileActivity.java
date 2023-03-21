package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MJ\u0010\u0010N\u001a\u00020I2\u0006\u0010O\u001a\u00020>H\u0002J\u0006\u0010P\u001a\u00020IJ\"\u0010Q\u001a\u00020I2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\b\u0010T\u001a\u0004\u0018\u00010UH\u0014J\u0010\u0010V\u001a\u00020I2\u0006\u0010W\u001a\u00020\u001bH\u0016J\u0012\u0010X\u001a\u00020I2\b\u0010O\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010Y\u001a\u00020I2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0014J\u0012\u0010\\\u001a\u00020I2\b\u0010]\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010^\u001a\u00020IJ\b\u0010_\u001a\u00020IH\u0002J\u0012\u0010`\u001a\u00020I2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\u001a\u0010a\u001a\u00020I2\u0006\u0010b\u001a\u00020c2\b\u0010T\u001a\u0004\u0018\u00010dH\u0002J\b\u0010e\u001a\u00020IH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006f"}, d2 = {"Lcom/release/plexigo/activity/EditProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Lcom/release/plexigo/adapter/CountrySelectionAdapter$OnCountrySelected;", "Lcom/release/plexigo/adapter/StateSelectionAdapter$OnStateSelected;", "()V", "IMAGE_PICKER", "", "allCountries", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/CountryModel;", "getAllCountries", "()Ljava/util/ArrayList;", "setAllCountries", "(Ljava/util/ArrayList;)V", "allStates", "Lcom/release/plexigo/models/StateModel;", "getAllStates", "setAllStates", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "bottomSheet", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "countrySelectionAdapter", "Lcom/release/plexigo/adapter/CountrySelectionAdapter;", "getCountrySelectionAdapter", "()Lcom/release/plexigo/adapter/CountrySelectionAdapter;", "setCountrySelectionAdapter", "(Lcom/release/plexigo/adapter/CountrySelectionAdapter;)V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "genreAdapter", "Lcom/release/plexigo/adapter/PreferredGenreAdapter;", "getGenreAdapter", "()Lcom/release/plexigo/adapter/PreferredGenreAdapter;", "setGenreAdapter", "(Lcom/release/plexigo/adapter/PreferredGenreAdapter;)V", "languageAdapter", "Lcom/release/plexigo/adapter/PreferredLanguageAdapter;", "getLanguageAdapter", "()Lcom/release/plexigo/adapter/PreferredLanguageAdapter;", "setLanguageAdapter", "(Lcom/release/plexigo/adapter/PreferredLanguageAdapter;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "seekbarProgress", "Landroidx/appcompat/widget/AppCompatSeekBar;", "getSeekbarProgress", "()Landroidx/appcompat/widget/AppCompatSeekBar;", "setSeekbarProgress", "(Landroidx/appcompat/widget/AppCompatSeekBar;)V", "selectedCountry", "selectedGender", "", "selectedState", "stateSelectionAdapter", "Lcom/release/plexigo/adapter/StateSelectionAdapter;", "getStateSelectionAdapter", "()Lcom/release/plexigo/adapter/StateSelectionAdapter;", "setStateSelectionAdapter", "(Lcom/release/plexigo/adapter/StateSelectionAdapter;)V", "userProfile", "Lcom/release/plexigo/models/UserProfileModel;", "countryList", "", "getBytes", "", "inputStream", "Ljava/io/InputStream;", "getStates", "country", "hideLoader", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "view", "onCountrySelected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStateSelected", "state", "showLoader", "updateProfileApi", "updateUi", "uploadProfileImage", "fileToUpload", "Ljava/io/File;", "Landroid/net/Uri;", "userProfileDetails", "app_debug"})
public final class EditProfileActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener, com.release.plexigo.adapter.CountrySelectionAdapter.OnCountrySelected, com.release.plexigo.adapter.StateSelectionAdapter.OnStateSelected {
    private final int IMAGE_PICKER = 10001;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    private java.lang.String selectedGender = "";
    private com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    @org.jetbrains.annotations.Nullable()
    private androidx.appcompat.widget.AppCompatSeekBar seekbarProgress;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.PreferredLanguageAdapter languageAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.PreferredGenreAdapter genreAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.CountryModel> allCountries;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.StateModel> allStates;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.CountrySelectionAdapter countrySelectionAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.StateSelectionAdapter stateSelectionAdapter;
    private com.release.plexigo.models.StateModel selectedState;
    private com.release.plexigo.models.CountryModel selectedCountry;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> bottomSheet;
    private com.release.plexigo.models.UserProfileModel userProfile;
    public com.release.plexigo.network.APIInterface apiInterface;
    private java.util.HashMap _$_findViewCache;
    
    public EditProfileActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.appcompat.widget.AppCompatSeekBar getSeekbarProgress() {
        return null;
    }
    
    public final void setSeekbarProgress(@org.jetbrains.annotations.Nullable()
    androidx.appcompat.widget.AppCompatSeekBar p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.PreferredLanguageAdapter getLanguageAdapter() {
        return null;
    }
    
    public final void setLanguageAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.PreferredLanguageAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.PreferredGenreAdapter getGenreAdapter() {
        return null;
    }
    
    public final void setGenreAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.PreferredGenreAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.CountryModel> getAllCountries() {
        return null;
    }
    
    public final void setAllCountries(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.CountryModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.StateModel> getAllStates() {
        return null;
    }
    
    public final void setAllStates(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.StateModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.CountrySelectionAdapter getCountrySelectionAdapter() {
        return null;
    }
    
    public final void setCountrySelectionAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.CountrySelectionAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.StateSelectionAdapter getStateSelectionAdapter() {
        return null;
    }
    
    public final void setStateSelectionAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.StateSelectionAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateUi(com.release.plexigo.models.UserProfileModel userProfile) {
    }
    
    private final void countryList() {
    }
    
    private final void getStates(java.lang.String country) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void showLoader() {
    }
    
    public final void hideLoader() {
    }
    
    private final void updateProfileApi() {
    }
    
    @java.lang.Override()
    public void onCountrySelected(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.CountryModel country) {
    }
    
    @java.lang.Override()
    public void onStateSelected(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.StateModel state) {
    }
    
    private final void uploadProfileImage(java.io.File fileToUpload, android.net.Uri data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final byte[] getBytes(@org.jetbrains.annotations.Nullable()
    java.io.InputStream inputStream) throws java.io.IOException {
        return null;
    }
    
    private final void userProfileDetails() {
    }
}