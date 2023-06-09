package com.release.plexigo.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u00c6\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bH\u00c6\u0003JQ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006$"}, d2 = {"Lcom/release/plexigo/models/FilmFestival;", "Ljava/io/Serializable;", "filmFestivalName", "", "imagePath", "screenings", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/FilmScreening;", "Lkotlin/collections/ArrayList;", "events", "Lcom/release/plexigo/models/FilmEvent;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getEvents", "()Ljava/util/ArrayList;", "setEvents", "(Ljava/util/ArrayList;)V", "getFilmFestivalName", "()Ljava/lang/String;", "setFilmFestivalName", "(Ljava/lang/String;)V", "getImagePath", "setImagePath", "getScreenings", "setScreenings", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
public final class FilmFestival implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String filmFestivalName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String imagePath;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.FilmScreening> screenings;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.release.plexigo.models.FilmEvent> events;
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.models.FilmFestival copy(@org.jetbrains.annotations.NotNull()
    java.lang.String filmFestivalName, @org.jetbrains.annotations.NotNull()
    java.lang.String imagePath, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmScreening> screenings, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmEvent> events) {
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
    
    public FilmFestival(@org.jetbrains.annotations.NotNull()
    java.lang.String filmFestivalName, @org.jetbrains.annotations.NotNull()
    java.lang.String imagePath, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmScreening> screenings, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmEvent> events) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilmFestivalName() {
        return null;
    }
    
    public final void setFilmFestivalName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImagePath() {
        return null;
    }
    
    public final void setImagePath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FilmScreening> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FilmScreening> getScreenings() {
        return null;
    }
    
    public final void setScreenings(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmScreening> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FilmEvent> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.FilmEvent> getEvents() {
        return null;
    }
    
    public final void setEvents(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.FilmEvent> p0) {
    }
}