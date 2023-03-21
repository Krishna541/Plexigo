package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\"\u0010%\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00152\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\u0012\u0010)\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J+\u0010,\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040.2\u0006\u0010/\u001a\u000200H\u0016\u00a2\u0006\u0002\u00101R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019\u00a8\u00063"}, d2 = {"Lcom/release/plexigo/activity/PlayOnTvActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ABORT", "", "getABORT", "()Ljava/lang/String;", "FAILED", "getFAILED", "SUCCESS", "getSUCCESS", "Status", "TIMEOUT", "getTIMEOUT", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "requestID", "getRequestID", "setRequestID", "CheckGPSContentValidApi", "", "HideLoader", "Showloader", "SuccessPopup", "status", "UpdateRequestApprovalApi", "checkLocationPermission", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "app_debug"})
public final class PlayOnTvActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    private int requestCode = 2002;
    private int requestID = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String SUCCESS = "Success";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String FAILED = "Failed";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ABORT = "Abort";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TIMEOUT = "TimeOut";
    private java.lang.String Status;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.PlayOnTvActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public PlayOnTvActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    public final int getRequestCode() {
        return 0;
    }
    
    public final void setRequestCode(int p0) {
    }
    
    public final int getRequestID() {
        return 0;
    }
    
    public final void setRequestID(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSUCCESS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFAILED() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getABORT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTIMEOUT() {
        return null;
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkLocationPermission() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void CheckGPSContentValidApi() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    private final void UpdateRequestApprovalApi(java.lang.String status) {
    }
    
    private final void SuccessPopup(java.lang.String status) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/PlayOnTvActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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