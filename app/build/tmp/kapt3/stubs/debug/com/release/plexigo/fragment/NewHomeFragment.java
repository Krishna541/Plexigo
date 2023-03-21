package com.release.plexigo.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0001sB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020SH\u0002J\u0006\u0010U\u001a\u00020\u0011J\b\u0010V\u001a\u00020SH\u0002J\u0010\u0010W\u001a\u00020S2\u0006\u0010X\u001a\u00020\u000bH\u0002J\u0006\u0010Y\u001a\u00020SJ\b\u0010Z\u001a\u00020SH\u0002J\b\u0010[\u001a\u00020SH\u0002J\b\u0010\\\u001a\u0004\u0018\u00010\u0011J\u0010\u0010]\u001a\u00020S2\u0006\u0010^\u001a\u00020_H\u0016J&\u0010`\u001a\u0004\u0018\u00010_2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010g\u001a\u00020SH\u0016J\b\u0010h\u001a\u00020SH\u0016J\u001a\u0010i\u001a\u00020S2\u0006\u0010j\u001a\u00020_2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010k\u001a\u00020SH\u0002J\u001a\u0010l\u001a\u00020S2\b\u0010m\u001a\u0004\u0018\u00010\u00112\b\u0010n\u001a\u0004\u0018\u00010\u0011J\u0006\u0010o\u001a\u00020SJ\b\u0010p\u001a\u00020SH\u0002J\u0010\u0010q\u001a\u00020S2\u0006\u0010$\u001a\u00020\u0011H\u0002J\b\u0010r\u001a\u00020SH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u0011\u0010\u001c\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u0016\u0012\u0004\u0012\u00020>\u0018\u00010,j\n\u0012\u0004\u0012\u00020>\u0018\u0001`.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010L\u001a\u0016\u0012\u0004\u0012\u00020M\u0018\u00010,j\n\u0012\u0004\u0012\u00020M\u0018\u0001`.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010N\u001a\u0016\u0012\u0004\u0012\u00020>\u0018\u00010,j\n\u0012\u0004\u0012\u00020>\u0018\u0001`.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010O\u001a\u0004\u0018\u000108X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010:\"\u0004\bQ\u0010<\u00a8\u0006t"}, d2 = {"Lcom/release/plexigo/fragment/NewHomeFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "apiInterface", "Lcom/release/plexigo/network/APIInterface;", "getApiInterface", "()Lcom/release/plexigo/network/APIInterface;", "setApiInterface", "(Lcom/release/plexigo/network/APIInterface;)V", "curatedCategoryId", "", "getCuratedCategoryId", "()I", "setCuratedCategoryId", "(I)V", "curatedImage", "", "getCuratedImage", "()Ljava/lang/String;", "setCuratedImage", "(Ljava/lang/String;)V", "curatedLinkText", "getCuratedLinkText", "setCuratedLinkText", "curatedText", "getCuratedText", "setCuratedText", "deviceID", "getDeviceID", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "fcmToken", "homeFragmentContentAdapter", "Lcom/release/plexigo/adapter/HomeFragmentContentAdapter;", "getHomeFragmentContentAdapter", "()Lcom/release/plexigo/adapter/HomeFragmentContentAdapter;", "setHomeFragmentContentAdapter", "(Lcom/release/plexigo/adapter/HomeFragmentContentAdapter;)V", "homePageContentList", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/HomePageListingModel;", "Lkotlin/collections/ArrayList;", "isShowOffersPopup", "isShowPopularChannel", "nestedScroll", "Landroidx/core/widget/NestedScrollView;", "getNestedScroll", "()Landroidx/core/widget/NestedScrollView;", "setNestedScroll", "(Landroidx/core/widget/NestedScrollView;)V", "picksForYouAdapter", "Lcom/release/plexigo/adapter/HomeBannerPagerAdapter;", "getPicksForYouAdapter", "()Lcom/release/plexigo/adapter/HomeBannerPagerAdapter;", "setPicksForYouAdapter", "(Lcom/release/plexigo/adapter/HomeBannerPagerAdapter;)V", "picksForYouBanner", "Lcom/release/plexigo/models/BannerModel;", "preferences", "Landroid/content/SharedPreferences;", "getPreferences", "()Landroid/content/SharedPreferences;", "setPreferences", "(Landroid/content/SharedPreferences;)V", "queue", "Lcom/android/volley/RequestQueue;", "getQueue", "()Lcom/android/volley/RequestQueue;", "setQueue", "(Lcom/android/volley/RequestQueue;)V", "showPopularChannelPosition", "topUserListModel", "Lcom/release/plexigo/models/TopUserListModel;", "whatsNewBanner", "whatsNewBannerAdapter", "getWhatsNewBannerAdapter", "setWhatsNewBannerAdapter", "callBannerApi", "", "channelsApi", "getFcmToken", "getListForEveryMood", "getTopUserListContent", "playlistId", "hideLoader", "homePageListing", "initData", "loadFCMToken", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onViewCreated", "view", "popularInAreaList", "saveFCMToken", "key", "value", "showLoader", "topUserList", "uploadFCMToken", "whatsNewMovies", "Companion", "app_debug"})
public final class NewHomeFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.Nullable()
    private androidx.core.widget.NestedScrollView nestedScroll;
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences preferences;
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences.Editor editor;
    private java.lang.String fcmToken = "";
    private final java.util.ArrayList<com.release.plexigo.models.HomePageListingModel> homePageContentList = null;
    @org.jetbrains.annotations.Nullable()
    private com.android.volley.RequestQueue queue;
    private final java.util.ArrayList<com.release.plexigo.models.BannerModel> picksForYouBanner = null;
    private final java.util.ArrayList<com.release.plexigo.models.BannerModel> whatsNewBanner = null;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.HomeBannerPagerAdapter picksForYouAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.HomeBannerPagerAdapter whatsNewBannerAdapter;
    private int isShowPopularChannel = 1;
    private int showPopularChannelPosition = 1;
    private int isShowOffersPopup = 1;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String curatedText;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String curatedImage;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String curatedLinkText;
    private int curatedCategoryId = 0;
    private java.util.ArrayList<com.release.plexigo.models.TopUserListModel> topUserListModel;
    public com.release.plexigo.network.APIInterface apiInterface;
    @org.jetbrains.annotations.Nullable()
    private com.release.plexigo.adapter.HomeFragmentContentAdapter homeFragmentContentAdapter;
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.fragment.NewHomeFragment.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.release.plexigo.Common.CustomProgressDialog customProgressDialog;
    private java.util.HashMap _$_findViewCache;
    
    public NewHomeFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.core.widget.NestedScrollView getNestedScroll() {
        return null;
    }
    
    public final void setNestedScroll(@org.jetbrains.annotations.Nullable()
    androidx.core.widget.NestedScrollView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.SharedPreferences getPreferences() {
        return null;
    }
    
    public final void setPreferences(@org.jetbrains.annotations.Nullable()
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
    public final com.android.volley.RequestQueue getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.Nullable()
    com.android.volley.RequestQueue p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.HomeBannerPagerAdapter getPicksForYouAdapter() {
        return null;
    }
    
    public final void setPicksForYouAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.HomeBannerPagerAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.HomeBannerPagerAdapter getWhatsNewBannerAdapter() {
        return null;
    }
    
    public final void setWhatsNewBannerAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.HomeBannerPagerAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCuratedText() {
        return null;
    }
    
    public final void setCuratedText(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCuratedImage() {
        return null;
    }
    
    public final void setCuratedImage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCuratedLinkText() {
        return null;
    }
    
    public final void setCuratedLinkText(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getCuratedCategoryId() {
        return 0;
    }
    
    public final void setCuratedCategoryId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.network.APIInterface getApiInterface() {
        return null;
    }
    
    public final void setApiInterface(@org.jetbrains.annotations.NotNull()
    com.release.plexigo.network.APIInterface p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.release.plexigo.adapter.HomeFragmentContentAdapter getHomeFragmentContentAdapter() {
        return null;
    }
    
    public final void setHomeFragmentContentAdapter(@org.jetbrains.annotations.Nullable()
    com.release.plexigo.adapter.HomeFragmentContentAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void saveFCMToken(@org.jetbrains.annotations.Nullable()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String loadFCMToken() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFcmToken() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceID() {
        return null;
    }
    
    private final void uploadFCMToken(java.lang.String fcmToken) {
    }
    
    private final void initData() {
    }
    
    private final void callBannerApi() {
    }
    
    private final void whatsNewMovies() {
    }
    
    private final void homePageListing() {
    }
    
    private final void topUserList() {
    }
    
    private final void getTopUserListContent(int playlistId) {
    }
    
    private final void popularInAreaList() {
    }
    
    private final void getListForEveryMood() {
    }
    
    private final void channelsApi() {
    }
    
    public final void showLoader() {
    }
    
    public final void hideLoader() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/release/plexigo/fragment/NewHomeFragment$Companion;", "", "()V", "customProgressDialog", "Lcom/release/plexigo/Common/CustomProgressDialog;", "getCustomProgressDialog", "()Lcom/release/plexigo/Common/CustomProgressDialog;", "setCustomProgressDialog", "(Lcom/release/plexigo/Common/CustomProgressDialog;)V", "newInstance", "Lcom/release/plexigo/fragment/NewHomeFragment;", "app_debug"})
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
        
        @org.jetbrains.annotations.NotNull()
        public final com.release.plexigo.fragment.NewHomeFragment newInstance() {
            return null;
        }
    }
}