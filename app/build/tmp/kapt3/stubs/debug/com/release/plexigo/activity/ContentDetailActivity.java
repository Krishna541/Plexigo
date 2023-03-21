package com.release.plexigo.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 \u00b7\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u00b7\u0001B\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\u000eJ\b\u0010r\u001a\u00020pH\u0002J\u0006\u0010s\u001a\u00020pJ\b\u0010t\u001a\u00020pH\u0002J\u0006\u0010u\u001a\u00020pJ\u0006\u0010v\u001a\u00020pJ\u0006\u0010w\u001a\u00020pJ\u0018\u0010x\u001a\u00020p2\b\u0010y\u001a\u0004\u0018\u00010\b2\u0006\u0010z\u001a\u000203J\u0006\u0010{\u001a\u00020pJ\u0018\u0010|\u001a\u00020p2\b\u0010}\u001a\u0004\u0018\u00010\b2\u0006\u0010~\u001a\u00020\u000eJ\b\u0010\u007f\u001a\u00020pH\u0002J\t\u0010\u0080\u0001\u001a\u00020pH\u0002J\u0007\u0010\u0081\u0001\u001a\u00020pJ;\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\b2\u0007\u0010\u0089\u0001\u001a\u0002032\u0007\u0010\u008a\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020p2\u0007\u0010\u008c\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u008d\u0001\u001a\u00020pH\u0002J\t\u0010\u008e\u0001\u001a\u00020pH\u0002J\t\u0010\u008f\u0001\u001a\u00020pH\u0002J\u0012\u0010\u0090\u0001\u001a\u00020\b2\u0007\u0010\u0091\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0092\u0001\u001a\u00020\b2\u0007\u0010\u0093\u0001\u001a\u00020\u000eH\u0002J\u0011\u0010\u0094\u0001\u001a\u00020p2\u0006\u0010F\u001a\u00020\u000eH\u0002J\u0011\u0010\u0095\u0001\u001a\u00020p2\u0006\u0010F\u001a\u00020\u000eH\u0002J\t\u0010\u0096\u0001\u001a\u00020pH\u0002J7\u0010\u0097\u0001\u001a\u00020p2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u000e2\u0007\u0010\u0099\u0001\u001a\u00020\b2\u0007\u0010\u0089\u0001\u001a\u0002032\u0007\u0010\u008a\u0001\u001a\u00020\u000eJ&\u0010\u009a\u0001\u001a\u00020p2\u0006\u0010_\u001a\u00020\u000e2\u0007\u0010\u009b\u0001\u001a\u00020\u000e2\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0014J\t\u0010\u009e\u0001\u001a\u00020pH\u0016J\u0013\u0010\u009f\u0001\u001a\u00020p2\b\u0010\u00a0\u0001\u001a\u00030\u00a1\u0001H\u0016J\u0015\u0010\u00a2\u0001\u001a\u00020p2\n\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u00a4\u0001H\u0014J\t\u0010\u00a5\u0001\u001a\u00020pH\u0014J\u0014\u0010\u00a6\u0001\u001a\u00020p2\t\u0010\u00a7\u0001\u001a\u0004\u0018\u00010cH\u0016J\u0014\u0010\u00a8\u0001\u001a\u00020p2\t\u0010\u00a9\u0001\u001a\u0004\u0018\u00010(H\u0016J!\u0010\u00aa\u0001\u001a\u00020p2\u0006\u0010_\u001a\u00020\u000e2\u000e\u0010\u00ab\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u00ac\u0001H\u0016J!\u0010\u00ad\u0001\u001a\u00020p2\u0006\u0010_\u001a\u00020\u000e2\u000e\u0010\u00ab\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u00ac\u0001H\u0016J1\u0010\u00ae\u0001\u001a\u00020p2\u0006\u0010_\u001a\u00020\u000e2\u000e\u0010\u00af\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u00b0\u00012\b\u0010\u00b1\u0001\u001a\u00030\u00b2\u0001H\u0016\u00a2\u0006\u0003\u0010\u00b3\u0001J\t\u0010\u00b4\u0001\u001a\u00020pH\u0014J\u0007\u0010\u00b5\u0001\u001a\u00020pJ\t\u0010\u00b6\u0001\u001a\u00020pH\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000203X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000203X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u001a\u00109\u001a\u000203X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\u001a\u0010;\u001a\u000203X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\u001c\u0010=\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\n\"\u0004\b?\u0010\fR\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010\u0012R\u001c\u0010I\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\n\"\u0004\bK\u0010\fR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001e\u0010X\u001a\u0004\u0018\u00010YX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010^\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010_\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0010\"\u0004\ba\u0010\u0012R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010g\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0010\"\u0004\bi\u0010\u0012R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010l\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00b8\u0001"}, d2 = {"Lcom/release/plexigo/activity/ContentDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Lpub/devrel/easypermissions/EasyPermissions$PermissionCallbacks;", "Lcom/release/plexigo/adapter/TrailerByLanguageAdapter$OnVideoSelected;", "Lcom/release/plexigo/adapter/TvSeriesEpisodeAdapter$OnEpisodeClickListener;", "()V", "API_VERSION", "", "getAPI_VERSION", "()Ljava/lang/String;", "setAPI_VERSION", "(Ljava/lang/String;)V", "LivetimeInterval", "", "getLivetimeInterval", "()I", "setLivetimeInterval", "(I)V", "POLLING_STOP", "RECEIVE_PLAYBACKSTATE", "getRECEIVE_PLAYBACKSTATE", "setRECEIVE_PLAYBACKSTATE", "WatchDuration", "getWatchDuration", "setWatchDuration", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "contentLanguageAdapter", "Lcom/release/plexigo/adapter/NewContentLanguageAdapter;", "getContentLanguageAdapter", "()Lcom/release/plexigo/adapter/NewContentLanguageAdapter;", "setContentLanguageAdapter", "(Lcom/release/plexigo/adapter/NewContentLanguageAdapter;)V", "contentLanguages", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/LanguageModel;", "contentLike", "featuredPlaylistAdapter", "Lcom/release/plexigo/adapter/PlaylistAdapter;", "getFeaturedPlaylistAdapter", "()Lcom/release/plexigo/adapter/PlaylistAdapter;", "setFeaturedPlaylistAdapter", "(Lcom/release/plexigo/adapter/PlaylistAdapter;)V", "featuredPlaylists", "Lcom/release/plexigo/models/UserPlaylistModel;", "isFav", "", "()Z", "setFav", "(Z)V", "isFestivalMovie", "setFestivalMovie", "isLive", "setLive", "isQAClicked", "setQAClicked", "liveVideoUrl", "getLiveVideoUrl", "setLiveVideoUrl", "movie", "Lcom/release/plexigo/models/Contentdetail;", "getMovie", "()Lcom/release/plexigo/models/Contentdetail;", "setMovie", "(Lcom/release/plexigo/models/Contentdetail;)V", "movieId", "getMovieId", "setMovieId", "poster_url", "getPoster_url", "setPoster_url", "preferences", "Landroid/content/SharedPreferences;", "getPreferences", "()Landroid/content/SharedPreferences;", "setPreferences", "(Landroid/content/SharedPreferences;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "rating", "", "getRating", "()Ljava/lang/Float;", "setRating", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "requestCode", "getRequestCode", "setRequestCode", "selectedEpisode", "Lcom/release/plexigo/models/TvSeriesEpisode;", "selectedLanguage", "selectedLanguageListener", "Lcom/release/plexigo/adapter/NewContentLanguageAdapter$OnLanguageSelected;", "selectedTabPosition", "getSelectedTabPosition", "setSelectedTabPosition", "tabLayoutSeasons", "Lcom/google/android/material/tabs/TabLayout;", "trailerLanguages", "tvSeriesEpisodeAdapter", "Lcom/release/plexigo/adapter/TvSeriesEpisodeAdapter;", "AddWatchHistory", "", "duration", "CheckIfUserPpvSubscribed", "GetContentToken", "GetMovieDetailApi", "HideLoader", "IsContentGeoAuthorized", "OpenPPVPopupLayout", "PlayInOtherOtt", "url", "openInBrowser", "PlayInPlexigo", "PlayLiveEvent", "videoPath", "timeInterval", "PlayLiveEventWithQA", "PlayVideo", "Showloader", "addClickablePartTextViewResizable", "Landroid/text/SpannableStringBuilder;", "strSpanned", "Landroid/text/Spanned;", "tv", "Landroid/widget/TextView;", "spanableText", "viewMore", "maxLineForTitle", "callLikeDislikeContent", "likeDislikeReset", "checkLocationPermission", "checkStoragePermission", "fetchContentUrl", "getDate", "strDate", "getDayNumberSuffix", "n", "getFeaturedInPlaylists", "getSimilarMovieListing", "hideSystemUI", "makeTextViewResizable", "maxLine", "expandText", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEpisodeClicked", "episode", "onLanguageSelected", "language", "onPermissionsDenied", "perms", "", "onPermissionsGranted", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "setMovieData", "showConfirmationDialog", "Companion", "app_debug"})
public final class ContentDetailActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener, pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks, com.release.plexigo.adapter.TrailerByLanguageAdapter.OnVideoSelected, com.release.plexigo.adapter.TvSeriesEpisodeAdapter.OnEpisodeClickListener {
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences preferences;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.NewContentLanguageAdapter contentLanguageAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.models.Contentdetail movie;
    private boolean isFav = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Float rating;
    private int requestCode = 1001;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    private boolean isLive = false;
    private boolean isFestivalMovie = false;
    private int movieId = 0;
    private int RECEIVE_PLAYBACKSTATE = 119;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String API_VERSION = "1.3";
    private int WatchDuration = 0;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String poster_url;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String liveVideoUrl;
    private int LivetimeInterval = 0;
    private boolean isQAClicked = false;
    private final java.lang.String POLLING_STOP = "0";
    private java.util.ArrayList<com.release.plexigo.models.LanguageModel> contentLanguages;
    private java.util.ArrayList<com.release.plexigo.models.LanguageModel> trailerLanguages;
    private com.release.plexigo.models.LanguageModel selectedLanguage;
    private final java.util.ArrayList<com.release.plexigo.models.UserPlaylistModel> featuredPlaylists = null;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.PlaylistAdapter featuredPlaylistAdapter;
    private int contentLike = 0;
    private int selectedTabPosition = 0;
    private final com.release.plexigo.adapter.TvSeriesEpisodeAdapter tvSeriesEpisodeAdapter = null;
    private com.google.android.material.tabs.TabLayout tabLayoutSeasons;
    public com.release.plexigo.network.APIInterface apiInterface;
    private final com.release.plexigo.adapter.NewContentLanguageAdapter.OnLanguageSelected selectedLanguageListener = null;
    private com.release.plexigo.models.TvSeriesEpisode selectedEpisode;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.activity.ContentDetailActivity.Companion Companion = null;
    public static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private static boolean AddfavoritesActive = false;
    private java.util.HashMap _$_findViewCache;
    
    public ContentDetailActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.SharedPreferences getPreferences() {
        return null;
    }
    
    public final void setPreferences(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.NewContentLanguageAdapter getContentLanguageAdapter() {
        return null;
    }
    
    public final void setContentLanguageAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.NewContentLanguageAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.models.Contentdetail getMovie() {
        return null;
    }
    
    public final void setMovie(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.Contentdetail p0) {
    }
    
    public final boolean isFav() {
        return false;
    }
    
    public final void setFav(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getRating() {
        return null;
    }
    
    public final void setRating(@org.jetbrains.annotations.Nullable()
    java.lang.Float p0) {
    }
    
    public final int getRequestCode() {
        return 0;
    }
    
    public final void setRequestCode(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    public final boolean isLive() {
        return false;
    }
    
    public final void setLive(boolean p0) {
    }
    
    public final boolean isFestivalMovie() {
        return false;
    }
    
    public final void setFestivalMovie(boolean p0) {
    }
    
    public final int getMovieId() {
        return 0;
    }
    
    public final void setMovieId(int p0) {
    }
    
    public final int getRECEIVE_PLAYBACKSTATE() {
        return 0;
    }
    
    public final void setRECEIVE_PLAYBACKSTATE(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAPI_VERSION() {
        return null;
    }
    
    public final void setAPI_VERSION(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getWatchDuration() {
        return 0;
    }
    
    public final void setWatchDuration(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPoster_url() {
        return null;
    }
    
    public final void setPoster_url(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLiveVideoUrl() {
        return null;
    }
    
    public final void setLiveVideoUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getLivetimeInterval() {
        return 0;
    }
    
    public final void setLivetimeInterval(int p0) {
    }
    
    public final boolean isQAClicked() {
        return false;
    }
    
    public final void setQAClicked(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.PlaylistAdapter getFeaturedPlaylistAdapter() {
        return null;
    }
    
    public final void setFeaturedPlaylistAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.PlaylistAdapter p0) {
    }
    
    public final int getSelectedTabPosition() {
        return 0;
    }
    
    public final void setSelectedTabPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void PlayVideo() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    public final void setMovieData() {
    }
    
    public final void Showloader() {
    }
    
    public final void HideLoader() {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    private final java.lang.String getDate(java.lang.String strDate) throws java.text.ParseException {
        return null;
    }
    
    private final java.lang.String getDayNumberSuffix(int n) {
        return null;
    }
    
    private final void hideSystemUI() {
    }
    
    private final void callLikeDislikeContent(int likeDislikeReset) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void checkStoragePermission() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void checkLocationPermission() {
    }
    
    public final void PlayInPlexigo() {
    }
    
    public final void PlayInOtherOtt(@org.jetbrains.annotations.Nullable()
    java.lang.String url, boolean openInBrowser) {
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
    
    public final void IsContentGeoAuthorized() {
    }
    
    private final void showConfirmationDialog() {
    }
    
    private final void fetchContentUrl() {
    }
    
    private final void PlayLiveEventWithQA() {
    }
    
    private final void CheckIfUserPpvSubscribed() {
    }
    
    public final void OpenPPVPopupLayout() {
    }
    
    public final void PlayLiveEvent(@org.jetbrains.annotations.Nullable()
    java.lang.String videoPath, int timeInterval) {
    }
    
    private final void GetMovieDetailApi() {
    }
    
    public final void AddWatchHistory(int duration) {
    }
    
    public final void GetContentToken() {
    }
    
    public final void makeTextViewResizable(@org.jetbrains.annotations.Nullable()
    android.widget.TextView tv, int maxLine, @org.jetbrains.annotations.NotNull()
    java.lang.String expandText, boolean viewMore, int maxLineForTitle) {
    }
    
    private final android.text.SpannableStringBuilder addClickablePartTextViewResizable(android.text.Spanned strSpanned, android.widget.TextView tv, java.lang.String spanableText, boolean viewMore, int maxLineForTitle) {
        return null;
    }
    
    private final void getSimilarMovieListing(int movieId) {
    }
    
    private final void getFeaturedInPlaylists(int movieId) {
    }
    
    @java.lang.Override()
    public void onLanguageSelected(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.LanguageModel language) {
    }
    
    @java.lang.Override()
    public void onEpisodeClicked(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.models.TvSeriesEpisode episode) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/release/plexigo/activity/ContentDetailActivity$Companion;", "", "()V", "AddfavoritesActive", "", "getAddfavoritesActive", "()Z", "setAddfavoritesActive", "(Z)V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "localIpAddress", "", "getLocalIpAddress", "()Ljava/lang/String;", "app_debug"})
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
        
        public final boolean getAddfavoritesActive() {
            return false;
        }
        
        public final void setAddfavoritesActive(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLocalIpAddress() {
            return null;
        }
    }
}