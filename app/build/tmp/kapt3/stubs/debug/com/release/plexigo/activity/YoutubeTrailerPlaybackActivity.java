package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u000eH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/release/plexigo/activity/YoutubeTrailerPlaybackActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/youtube/player/YouTubePlayer$PlayerStateChangeListener;", "Lcom/google/android/youtube/player/YouTubePlayer$PlaybackEventListener;", "()V", "VIDEO_ID", "", "getVIDEO_ID", "()Ljava/lang/String;", "setVIDEO_ID", "(Ljava/lang/String;)V", "mFirebaseRemoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "initYoutube", "", "onAdStarted", "onBuffering", "b", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "errorReason", "Lcom/google/android/youtube/player/YouTubePlayer$ErrorReason;", "onLoaded", "s", "onLoading", "onPaused", "onPlaying", "onSeekTo", "i", "", "onStopped", "onVideoEnded", "onVideoStarted", "app_debug"})
public final class YoutubeTrailerPlaybackActivity extends androidx.appcompat.app.AppCompatActivity implements com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener, com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String VIDEO_ID;
    private com.google.firebase.remoteconfig.FirebaseRemoteConfig mFirebaseRemoteConfig;
    private java.util.HashMap _$_findViewCache;
    
    public YoutubeTrailerPlaybackActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getVIDEO_ID() {
        return null;
    }
    
    public final void setVIDEO_ID(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void initYoutube() {
    }
    
    @java.lang.Override()
    public void onPlaying() {
    }
    
    @java.lang.Override()
    public void onPaused() {
    }
    
    @java.lang.Override()
    public void onStopped() {
    }
    
    @java.lang.Override()
    public void onBuffering(boolean b) {
    }
    
    @java.lang.Override()
    public void onSeekTo(int i) {
    }
    
    @java.lang.Override()
    public void onLoading() {
    }
    
    @java.lang.Override()
    public void onLoaded(@org.jetbrains.annotations.NotNull()
    java.lang.String s) {
    }
    
    @java.lang.Override()
    public void onAdStarted() {
    }
    
    @java.lang.Override()
    public void onVideoStarted() {
    }
    
    @java.lang.Override()
    public void onVideoEnded() {
    }
    
    @java.lang.Override()
    public void onError(@org.jetbrains.annotations.NotNull()
    com.google.android.youtube.player.YouTubePlayer.ErrorReason errorReason) {
    }
}