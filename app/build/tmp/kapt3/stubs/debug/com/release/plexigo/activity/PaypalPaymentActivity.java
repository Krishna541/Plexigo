package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u0004J\b\u0010$\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0004J\b\u0010\'\u001a\u00020!H\u0016J\u0012\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020!H\u0014J\u0006\u0010,\u001a\u00020!R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b\u00a8\u0006."}, d2 = {"Lcom/release/plexigo/activity/PaypalPaymentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "APPROVE_KEY", "", "getAPPROVE_KEY", "()Ljava/lang/String;", "setAPPROVE_KEY", "(Ljava/lang/String;)V", "CHROME_CUSTOM_TAB_REQUEST_CODE", "", "CountryCode", "getCountryCode", "setCountryCode", "Currency", "getCurrency", "setCurrency", "IsPaypalRedirected", "", "getIsPaypalRedirected", "()Z", "setIsPaypalRedirected", "(Z)V", "amount", "getAmount", "setAmount", "movieid", "getMovieid", "setMovieid", "userid", "getUserid", "setUserid", "CreateOrder", "", "OpenIntent", "url", "askexitpopup", "isPackageInstalled", "packageName", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "redirectToContent", "Companion", "app_debug"})
public final class PaypalPaymentActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String userid;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String movieid;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String amount;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Currency;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String CountryCode;
    private final int CHROME_CUSTOM_TAB_REQUEST_CODE = 100;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String APPROVE_KEY = "approve";
    private boolean IsPaypalRedirected = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.PaypalPaymentActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public PaypalPaymentActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserid() {
        return null;
    }
    
    public final void setUserid(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMovieid() {
        return null;
    }
    
    public final void setMovieid(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrency() {
        return null;
    }
    
    public final void setCurrency(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCountryCode() {
        return null;
    }
    
    public final void setCountryCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAPPROVE_KEY() {
        return null;
    }
    
    public final void setAPPROVE_KEY(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getIsPaypalRedirected() {
        return false;
    }
    
    public final void setIsPaypalRedirected(boolean p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void redirectToContent() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void askexitpopup() {
    }
    
    private final void CreateOrder() {
    }
    
    public final void OpenIntent(@org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    public final boolean isPackageInstalled(@org.jetbrains.annotations.Nullable()
    java.lang.String packageName) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/PaypalPaymentActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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