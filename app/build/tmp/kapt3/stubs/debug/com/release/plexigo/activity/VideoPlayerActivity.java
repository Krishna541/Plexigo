package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 k2\u00020\u0001:\u0001kB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020QH\u0002J\u0006\u0010S\u001a\u00020QJ\u001a\u0010T\u001a\u00020Q2\u0006\u0010U\u001a\u00020\u000b2\b\u0010V\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010W\u001a\u00020QJ\b\u0010X\u001a\u00020QH\u0002J\b\u0010Y\u001a\u00020QH\u0002J\u0010\u0010Z\u001a\u00020Q2\b\u0010[\u001a\u0004\u0018\u00010\u0004J\b\u0010\\\u001a\u00020QH\u0004J\b\u0010]\u001a\u00020QH\u0016J\u0010\u0010^\u001a\u00020Q2\u0006\u0010_\u001a\u00020`H\u0016J\u0012\u0010a\u001a\u00020Q2\b\u0010b\u001a\u0004\u0018\u00010cH\u0014J\b\u0010d\u001a\u00020QH\u0016J\b\u0010e\u001a\u00020QH\u0016J\b\u0010f\u001a\u00020QH\u0016J\b\u0010g\u001a\u00020QH\u0016J\b\u0010h\u001a\u00020QH\u0016J\b\u0010i\u001a\u00020QH\u0004J\b\u0010j\u001a\u00020QH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u000e\u00106\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00100\"\u0004\b8\u00102R\u001a\u00109\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00100\"\u0004\b:\u00102R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006l"}, d2 = {"Lcom/release/plexigo/activity/VideoPlayerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CHANNEL_URL", "", "CHAT_API_TOKEN", "CHECKUSEREXISTAPI", "DRM_HEADERS", "", "DRM_URI", "PLAYBACK_TYPE", "", "getPLAYBACK_TYPE", "()I", "setPLAYBACK_TYPE", "(I)V", "POLLING_ONGOING", "POLLING_START", "PollingTimeInterval", "PollingTimer", "Ljava/util/Timer;", "STREAM_TOKEN", "STREAM_URI", "adapter", "Lcom/release/plexigo/adapter/ChatAdapter;", "getAdapter", "()Lcom/release/plexigo/adapter/ChatAdapter;", "setAdapter", "(Lcom/release/plexigo/adapter/ChatAdapter;)V", "all_chats", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/ChatModel;", "getAll_chats", "()Ljava/util/ArrayList;", "setAll_chats", "(Ljava/util/ArrayList;)V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "contentId", "eventLogger", "Lcom/google/android/exoplayer2/util/EventLogger;", "firsttime", "", "getFirsttime", "()Z", "setFirsttime", "(Z)V", "haveStartPosition", "getHaveStartPosition", "setHaveStartPosition", "isBackPressed", "isFestivalMovie", "setFestivalMovie", "isQAEnabled", "setQAEnabled", "mDrmCallback", "Lnagra/otv/sdk/drm/OTVHttpMediaDrmCallback;", "mMediaController", "Lcom/release/plexigo/utility/ThumbnailMediaController;", "mOTVVideoView", "Lnagra/otv/sdk/OTVVideoView;", "openChannelObject", "Lcom/sendbird/android/OpenChannel;", "getOpenChannelObject", "()Lcom/sendbird/android/OpenChannel;", "setOpenChannelObject", "(Lcom/sendbird/android/OpenChannel;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "startPosition", "timeInterval", "timer", "CheckUserIsExist", "", "CreateSendbirdUser", "HideLoader", "PollingSavePlaybackDuration", "duration", "action", "Showloader", "fetchContentUrl", "hideSystemUI", "initSendBird", "access_token", "initializePlayer", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "releasePlayer", "showSystemUI", "Companion", "app_debug"})
public final class VideoPlayerActivity extends androidx.appcompat.app.AppCompatActivity {
    private int startPosition = 0;
    private final com.google.android.exoplayer2.util.EventLogger eventLogger = null;
    private int PLAYBACK_TYPE = 0;
    private boolean haveStartPosition = false;
    private boolean isFestivalMovie = false;
    private int timeInterval = 30;
    private int PollingTimeInterval = 60;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    private int contentId = 0;
    private java.util.Timer timer;
    private java.util.Timer PollingTimer;
    private boolean isQAEnabled = false;
    @org.jetbrains.annotations.Nullable()
    private com.sendbird.android.OpenChannel openChannelObject;
    private final java.lang.String CHECKUSEREXISTAPI = "https://api-4356dbe1-58e9-4ff0-9035-ac7e47bf7a68.sendbird.com/v3/users";
    private java.lang.String CHANNEL_URL;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.release.plexigo.models.ChatModel> all_chats;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.ChatAdapter adapter;
    private final java.lang.String CHAT_API_TOKEN = "d8e5f0094ae84ae78e797868d07f5deceb5bf429";
    private boolean isBackPressed = false;
    private boolean firsttime = true;
    private final java.lang.String POLLING_START = "1";
    private final java.lang.String POLLING_ONGOING = "2";
    private java.lang.String STREAM_URI = "";
    private java.lang.String STREAM_TOKEN = "";
    private java.lang.String DRM_URI = "";
    private final java.util.Map<java.lang.String, java.lang.String> DRM_HEADERS = null;
    private com.release.plexigo.utility.ThumbnailMediaController mMediaController;
    private nagra.otv.sdk.OTVVideoView mOTVVideoView;
    public com.release.plexigo.network.APIInterface apiInterface;
    private nagra.otv.sdk.drm.OTVHttpMediaDrmCallback mDrmCallback;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.VideoPlayerActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private static final java.lang.String TAG = "encryptedwidevine";
    private java.util.HashMap _$_findViewCache;
    
    public VideoPlayerActivity() {
        super();
    }
    
    public final int getPLAYBACK_TYPE() {
        return 0;
    }
    
    public final void setPLAYBACK_TYPE(int p0) {
    }
    
    public final boolean getHaveStartPosition() {
        return false;
    }
    
    public final void setHaveStartPosition(boolean p0) {
    }
    
    public final boolean isFestivalMovie() {
        return false;
    }
    
    public final void setFestivalMovie(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    public final boolean isQAEnabled() {
        return false;
    }
    
    public final void setQAEnabled(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.sendbird.android.OpenChannel getOpenChannelObject() {
        return null;
    }
    
    public final void setOpenChannelObject(@org.jetbrains.annotations.Nullable()
    com.sendbird.android.OpenChannel p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.release.plexigo.models.ChatModel> getAll_chats() {
        return null;
    }
    
    public final void setAll_chats(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.release.plexigo.models.ChatModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.ChatAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.ChatAdapter p0) {
    }
    
    public final boolean getFirsttime() {
        return false;
    }
    
    public final void setFirsttime(boolean p0) {
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
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull()
    android.content.res.Configuration newConfig) {
    }
    
    private final void hideSystemUI() {
    }
    
    private final void showSystemUI() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    protected final void initializePlayer() {
    }
    
    protected final void releasePlayer() {
    }
    
    private final void fetchContentUrl() {
    }
    
    public final void initSendBird(@org.jetbrains.annotations.Nullable()
    java.lang.String access_token) {
    }
    
    private final void CheckUserIsExist() {
    }
    
    private final void CreateSendbirdUser() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    private final void PollingSavePlaybackDuration(int duration, java.lang.String action) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/release/plexigo/activity/VideoPlayerActivity$Companion;", "", "()V", "TAG", "", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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