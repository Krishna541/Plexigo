package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0010\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&J\u0018\u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0002J\u0012\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006."}, d2 = {"Lcom/release/plexigo/activity/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ReloadafterLogin", "", "getReloadafterLogin", "()Z", "setReloadafterLogin", "(Z)V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "HideLoader", "", "Showloader", "isValidEmailAddress", "email", "", "loginApi", "countryCode", "phoneNumber", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences sharedPreferences;
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences.Editor editor;
    private boolean ReloadafterLogin = true;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    public com.release.plexigo.network.APIInterface apiInterface;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.LoginActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public LoginActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public final void setSharedPreferences(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.SharedPreferences.Editor getEditor() {
        return null;
    }
    
    public final void setEditor(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences.Editor p0) {
    }
    
    public final boolean getReloadafterLogin() {
        return false;
    }
    
    public final void setReloadafterLogin(boolean p0) {
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
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loginApi(java.lang.String countryCode, java.lang.String phoneNumber) {
    }
    
    public final boolean isValidEmailAddress(@org.jetbrains.annotations.Nullable()
    java.lang.String email) {
        return false;
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/LoginActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.release.plexigo.Common.CustomProgressDialog getCustomProgressDialog() {
            return null;
        }
        
        public final void setCustomProgressDialog(@org.jetbrains.annotations.Nullable()
        com.release.plexigo.Common.CustomProgressDialog p0) {
        }
    }
}