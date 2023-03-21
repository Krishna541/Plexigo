package com.release.plexigo.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\tH\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\u0001H\u00c6\u0003J\t\u0010$\u001a\u00020\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003Js\u0010\'\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0007H\u00d6\u0001J\t\u0010,\u001a\u00020\tH\u00d6\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014\u00a8\u0006-"}, d2 = {"Lcom/release/plexigo/models/HomeApiDataModel;", "", "categories", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/HomeApiCategoryModel;", "Lkotlin/collections/ArrayList;", "curatedCategoryId", "", "curatedImage", "", "curatedLinkText", "curatedText", "message", "showOffersPopup", "showPopularChannel", "showpopularchannelposition", "(Ljava/util/ArrayList;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;III)V", "getCategories", "()Ljava/util/ArrayList;", "getCuratedCategoryId", "()I", "getCuratedImage", "()Ljava/lang/String;", "getCuratedLinkText", "getCuratedText", "getMessage", "()Ljava/lang/Object;", "getShowOffersPopup", "getShowPopularChannel", "getShowpopularchannelposition", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class HomeApiDataModel {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.release.plexigo.models.HomeApiCategoryModel> categories = null;
    private final int curatedCategoryId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String curatedImage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String curatedLinkText = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String curatedText = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object message = null;
    private final int showOffersPopup = 0;
    private final int showPopularChannel = 0;
    private final int showpopularchannelposition = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.models.HomeApiDataModel copy(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.HomeApiCategoryModel> categories, int curatedCategoryId, @org.jetbrains.annotations.NotNull()
    java.lang.String curatedImage, @org.jetbrains.annotations.NotNull()
    java.lang.String curatedLinkText, @org.jetbrains.annotations.NotNull()
    java.lang.String curatedText, @org.jetbrains.annotations.NotNull()
    java.lang.Object message, int showOffersPopup, int showPopularChannel, int showpopularchannelposition) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public HomeApiDataModel(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.HomeApiCategoryModel> categories, int curatedCategoryId, @org.jetbrains.annotations.NotNull()
    java.lang.String curatedImage, @org.jetbrains.annotations.NotNull()
    java.lang.String curatedLinkText, @org.jetbrains.annotations.NotNull()
    java.lang.String curatedText, @org.jetbrains.annotations.NotNull()
    java.lang.Object message, int showOffersPopup, int showPopularChannel, int showpopularchannelposition) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.HomeApiCategoryModel> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.HomeApiCategoryModel> getCategories() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getCuratedCategoryId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCuratedImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCuratedLinkText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCuratedText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getMessage() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int getShowOffersPopup() {
        return 0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getShowPopularChannel() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getShowpopularchannelposition() {
        return 0;
    }
}