package com.release.plexigo.activity;

import java.lang.System;

/**
 * Created by Tarak Bhawalkar on Oct 01, 2020 at 17:30
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 W2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001WB\u0005\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020/J\u0016\u00101\u001a\u00020/2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205J\b\u00106\u001a\u00020/H\u0002J\b\u00107\u001a\u00020/H\u0002J\b\u00108\u001a\u00020/H\u0002J\u0006\u00109\u001a\u00020/J\b\u0010:\u001a\u00020/H\u0002J\b\u0010;\u001a\u00020/H\u0002J\"\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\u0012\u0010B\u001a\u00020/2\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\b\u0010E\u001a\u00020/H\u0014J\u001e\u0010F\u001a\u00020/2\u0006\u0010=\u001a\u00020>2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0HH\u0016J\u001e\u0010I\u001a\u00020/2\u0006\u0010=\u001a\u00020>2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0HH\u0016J\u0010\u0010J\u001a\u00020/2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010K\u001a\u00020/2\u0006\u0010=\u001a\u00020>H\u0016J+\u0010L\u001a\u00020/2\u0006\u0010=\u001a\u00020>2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0N2\u0006\u0010O\u001a\u00020PH\u0016\u00a2\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020/H\u0014J\b\u0010S\u001a\u00020/H\u0016J\u0006\u0010T\u001a\u00020/J\u0016\u0010U\u001a\u00020/2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205J\u0006\u0010V\u001a\u00020/R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u0006X"}, d2 = {"Lcom/release/plexigo/activity/NewHomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/release/plexigo/Common/GpsTracker$OnNegativeButtonClicked;", "Lpub/devrel/easypermissions/EasyPermissions$PermissionCallbacks;", "Lpub/devrel/easypermissions/EasyPermissions$RationaleCallbacks;", "()V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "deviceID", "", "getDeviceID", "()Ljava/lang/String;", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "gpsTracker", "Lcom/release/plexigo/Common/GpsTracker;", "getGpsTracker", "()Lcom/release/plexigo/Common/GpsTracker;", "setGpsTracker", "(Lcom/release/plexigo/Common/GpsTracker;)V", "navigationItemReselectedListener", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "getNavigationItemReselectedListener", "()Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "setNavigationItemReselectedListener", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;)V", "preferences", "Landroid/content/SharedPreferences;", "getPreferences", "()Landroid/content/SharedPreferences;", "setPreferences", "(Landroid/content/SharedPreferences;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "HideLoader", "", "Showloader", "addFragment", "fragment", "Landroidx/fragment/app/Fragment;", "addToBackStack", "", "checkLocationPermission", "clearFragmentStack", "hideSystemUI", "hideToolbar", "initData", "initView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPermissionsDenied", "perms", "", "onPermissionsGranted", "onRationaleAccepted", "onRationaleDenied", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "permissionRequestNegativeButtonClicked", "postGPSCordinates", "replaceFragment", "showToolbar", "Companion", "app_debug"})
public final class NewHomeActivity extends androidx.appcompat.app.AppCompatActivity implements com.release.plexigo.Common.GpsTracker.OnNegativeButtonClicked, pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks, pub.devrel.easypermissions.EasyPermissions.RationaleCallbacks {
    public android.content.SharedPreferences preferences;
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences.Editor editor;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.Common.GpsTracker gpsTracker;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    public com.release.plexigo.network.APIInterface apiInterface;
    @org.jetbrains.annotations.NotNull()
    private com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener navigationItemReselectedListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.NewHomeActivity.Companion Companion = null;
    private static com.google.android.material.bottomnavigation.BottomNavigationView bottomNavigationView;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    @org.jetbrains.annotations.Nullable()
    private static com.fasterxml.jackson.databind.ObjectMapper mapper;
    private static final java.util.concurrent.locks.Lock lock = null;
    private static final java.lang.String TAG = "NewHomeActivity";
    private java.util.HashMap _$_findViewCache;
    
    public NewHomeActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getPreferences() {
        return null;
    }
    
    public final void setPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.SharedPreferences.Editor getEditor() {
        return null;
    }
    
    public final void setEditor(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences.Editor p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.Common.GpsTracker getGpsTracker() {
        return null;
    }
    
    public final void setGpsTracker(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.Common.GpsTracker p0) {
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
    public final com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener getNavigationItemReselectedListener() {
        return null;
    }
    
    public final void setNavigationItemReselectedListener(@org.jetbrains.annotations.NotNull()
    com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceID() {
        return null;
    }
    
    private final void hideSystemUI() {
    }
    
    private final void initView() {
    }
    
    private final void initData() {
    }
    
    private final void clearFragmentStack() {
    }
    
    public final void replaceFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, boolean addToBackStack) {
    }
    
    public final void addFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, boolean addToBackStack) {
    }
    
    private final void checkLocationPermission() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void postGPSCordinates() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    public void onPermissionsGranted(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> perms) {
    }
    
    @java.lang.Override()
    public void onPermissionsDenied(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> perms) {
    }
    
    public final void showToolbar() {
    }
    
    public final void hideToolbar() {
    }
    
    @java.lang.Override()
    public void permissionRequestNegativeButtonClicked() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onRationaleAccepted(int requestCode) {
    }
    
    @java.lang.Override()
    public void onRationaleDenied(int requestCode) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00108F@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/release/plexigo/activity/NewHomeActivity$Companion;", "", "()V", "TAG", "", "bottomNavigationView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "lock", "Ljava/util/concurrent/locks/Lock;", "<set-?>", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "mapper", "getMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "setMapper", "(Lcom/fasterxml/jackson/databind/ObjectMapper;)V", "setChannelsPage", "", "app_debug"})
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
        
        @org.jetbrains.annotations.Nullable()
        public final com.fasterxml.jackson.databind.ObjectMapper getMapper() {
            return null;
        }
        
        private final void setMapper(com.fasterxml.jackson.databind.ObjectMapper p0) {
        }
        
        public final void setChannelsPage() {
        }
    }
}