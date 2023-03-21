package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0002J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+J\u0010\u0010/\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0012\u00101\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u000103H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)\u00a8\u00065"}, d2 = {"Lcom/release/plexigo/activity/ChatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CHANNEL_URL", "", "getCHANNEL_URL", "()Ljava/lang/String;", "setCHANNEL_URL", "(Ljava/lang/String;)V", "CHAT_API_TOKEN", "CHECKUSEREXISTAPI", "adapter", "Lcom/release/plexigo/adapter/ChatAdapter;", "getAdapter", "()Lcom/release/plexigo/adapter/ChatAdapter;", "setAdapter", "(Lcom/release/plexigo/adapter/ChatAdapter;)V", "all_chats", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/ChatModel;", "getAll_chats", "()Ljava/util/ArrayList;", "setAll_chats", "(Ljava/util/ArrayList;)V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "openChannelObject", "Lcom/sendbird/android/OpenChannel;", "getOpenChannelObject", "()Lcom/sendbird/android/OpenChannel;", "setOpenChannelObject", "(Lcom/sendbird/android/OpenChannel;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "CheckUserIsExist", "", "CreateSendbirdUser", "HideLoader", "Showloader", "initSendBird", "access_token", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class ChatActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private com.sendbird.android.OpenChannel openChannelObject;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    private final java.lang.String CHECKUSEREXISTAPI = "https://api-4356dbe1-58e9-4ff0-9035-ac7e47bf7a68.sendbird.com/v3/users";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String CHANNEL_URL;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.release.plexigo.models.ChatModel> all_chats;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.ChatAdapter adapter;
    public com.release.plexigo.network.APIInterface apiInterface;
    private final java.lang.String CHAT_API_TOKEN = "d8e5f0094ae84ae78e797868d07f5deceb5bf429";
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.ChatActivity.Companion Companion = null;
    public static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public ChatActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.sendbird.android.OpenChannel getOpenChannelObject() {
        return null;
    }
    
    public final void setOpenChannelObject(@org.jetbrains.annotations.Nullable()
    com.sendbird.android.OpenChannel p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCHANNEL_URL() {
        return null;
    }
    
    public final void setCHANNEL_URL(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
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
    
    public final void initSendBird(@org.jetbrains.annotations.Nullable()
    java.lang.String access_token) {
    }
    
    private final void CheckUserIsExist() {
    }
    
    public final void CreateSendbirdUser() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/release/plexigo/activity/ChatActivity$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "app_debug"})
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