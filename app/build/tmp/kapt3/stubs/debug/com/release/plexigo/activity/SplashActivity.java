package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\b\u0010&\u001a\u00020$H\u0002J\b\u0010\'\u001a\u00020$H\u0002J\u0006\u0010(\u001a\u00020$J\r\u0010\u0014\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\b)J\u0006\u0010*\u001a\u00020$J\u0006\u0010+\u001a\u00020$J\u0006\u0010,\u001a\u00020$J\u0012\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0014J\b\u00103\u001a\u00020$H\u0014J\b\u00104\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u00066"}, d2 = {"Lcom/release/plexigo/activity/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "SENDBIRD_APP_ID", "", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "branchReferralInitListener", "Lio/branch/referral/Branch$BranchReferralInitListener;", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "fcmToken", "getFcmToken", "()Ljava/lang/String;", "setFcmToken", "(Ljava/lang/String;)V", "isForceUpdate", "", "()Z", "setForceUpdate", "(Z)V", "preferences", "Landroid/content/SharedPreferences;", "getPreferences", "()Landroid/content/SharedPreferences;", "setPreferences", "(Landroid/content/SharedPreferences;)V", "HideLoader", "", "Showloader", "appVersion", "checkOnBoardingCompleted", "checkUpdate", "getFcmToken1", "navigateToDashboard", "navigateToOnBoarding", "navigateToPlayStore", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onStart", "showForceUpdateDialog", "Companion", "app_debug"})
public final class SplashActivity extends androidx.appcompat.app.AppCompatActivity {
    private final java.lang.String SENDBIRD_APP_ID = "4356DBE1-58E9-4FF0-9035-AC7E47BF7A68";
    private boolean isForceUpdate = false;
    public android.content.SharedPreferences preferences;
    public android.content.SharedPreferences.Editor editor;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fcmToken = "";
    public com.release.plexigo.network.APIInterface apiInterface;
    private final io.branch.referral.Branch.BranchReferralInitListener branchReferralInitListener = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.SplashActivity.Companion Companion = null;
    public static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public SplashActivity() {
        super();
    }
    
    public final boolean isForceUpdate() {
        return false;
    }
    
    public final void setForceUpdate(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getPreferences() {
        return null;
    }
    
    public final void setPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences.Editor getEditor() {
        return null;
    }
    
    public final void setEditor(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences.Editor p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFcmToken() {
        return null;
    }
    
    public final void setFcmToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmName(name = "getFcmToken1")
    public final java.lang.String getFcmToken1() {
        return null;
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    private final void appVersion() {
    }
    
    private final void showForceUpdateDialog() {
    }
    
    private final void checkOnBoardingCompleted() {
    }
    
    public final void navigateToDashboard() {
    }
    
    public final void navigateToOnBoarding() {
    }
    
    public final void checkUpdate() {
    }
    
    public final void navigateToPlayStore() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/SplashActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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