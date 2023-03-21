package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/release/plexigo/activity/OTPReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "otpListener", "Lcom/release/plexigo/activity/OTPReceiver$OTPReceiveListener;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "setOTPListener", "OTPReceiveListener", "app_debug"})
public class OTPReceiver extends android.content.BroadcastReceiver {
    private com.release.plexigo.activity.OTPReceiver.OTPReceiveListener otpListener;
    
    public OTPReceiver() {
        super();
    }
    
    public final void setOTPListener(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.activity.OTPReceiver.OTPReceiveListener otpListener) {
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/release/plexigo/activity/OTPReceiver$OTPReceiveListener;", "", "onOTPReceived", "", "otppp", "", "app_debug"})
    public static abstract interface OTPReceiveListener {
        
        public abstract void onOTPReceived(@org.jetbrains.annotations.Nullable()
        java.lang.String otppp);
    }
}