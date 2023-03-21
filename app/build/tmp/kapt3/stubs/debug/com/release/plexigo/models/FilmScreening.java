package com.release.plexigo.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u00c6\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012\u00a8\u0006#"}, d2 = {"Lcom/release/plexigo/models/FilmScreening;", "Ljava/io/Serializable;", "screeningDate", "", "screeningEndTime", "screeningStartTime", "screening", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/FilmScreeningData;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getScreening", "()Ljava/util/ArrayList;", "setScreening", "(Ljava/util/ArrayList;)V", "getScreeningDate", "()Ljava/lang/String;", "setScreeningDate", "(Ljava/lang/String;)V", "getScreeningEndTime", "setScreeningEndTime", "getScreeningStartTime", "setScreeningStartTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
public final class FilmScreening implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String screeningDate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String screeningEndTime;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String screeningStartTime;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.FilmScreeningData> screening;
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.models.FilmScreening copy(@org.jetbrains.annotations.NotNull()
    java.lang.String screeningDate, @org.jetbrains.annotations.NotNull()
    java.lang.String screeningEndTime, @org.jetbrains.annotations.NotNull()
    java.lang.String screeningStartTime, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmScreeningData> screening) {
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
    
    public FilmScreening(@org.jetbrains.annotations.NotNull()
    java.lang.String screeningDate, @org.jetbrains.annotations.NotNull()
    java.lang.String screeningEndTime, @org.jetbrains.annotations.NotNull()
    java.lang.String screeningStartTime, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmScreeningData> screening) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScreeningDate() {
        return null;
    }
    
    public final void setScreeningDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScreeningEndTime() {
        return null;
    }
    
    public final void setScreeningEndTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScreeningStartTime() {
        return null;
    }
    
    public final void setScreeningStartTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FilmScreeningData> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FilmScreeningData> getScreening() {
        return null;
    }
    
    public final void setScreening(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmScreeningData> p0) {
    }
}