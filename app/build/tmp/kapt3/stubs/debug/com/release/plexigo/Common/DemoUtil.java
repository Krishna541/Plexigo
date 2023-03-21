package com.release.plexigo.Common;

import java.lang.System;

/**
 * Utility methods for demo application.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/release/plexigo/Common/DemoUtil;", "", "()V", "buildAudioPropertyString", "", "format", "Lcom/google/android/exoplayer2/Format;", "buildBitrateString", "buildLanguageString", "buildResolutionString", "buildSampleMimeTypeString", "buildTrackIdString", "buildTrackName", "getDrmUuid", "Ljava/util/UUID;", "drmScheme", "joinWithSeparator", "first", "second", "app_debug"})
public final class DemoUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.release.plexigo.Common.DemoUtil INSTANCE = null;
    
    private DemoUtil() {
        super();
    }
    
    /**
     * Derives a DRM [UUID] from `drmScheme`.
     *
     * @param drmScheme A protection scheme UUID string; or `"widevine"`, `"playready"` or
     * `"clearkey"`.
     * @return The derived [UUID].
     * @throws UnsupportedDrmException If no [UUID] could be derived from `drmScheme`.
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.Throws(exceptionClasses = {com.google.android.exoplayer2.drm.UnsupportedDrmException.class})
    public final java.util.UUID getDrmUuid(@org.jetbrains.annotations.Nullable()
    java.lang.String drmScheme) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        return null;
    }
    
    /**
     * Builds a track name for display.
     *
     * @param format [Format] of the track.
     * @return a generated name specific to the track.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String buildTrackName(@org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.Format format) {
        return null;
    }
    
    private final java.lang.String buildResolutionString(com.google.android.exoplayer2.Format format) {
        return null;
    }
    
    private final java.lang.String buildAudioPropertyString(com.google.android.exoplayer2.Format format) {
        return null;
    }
    
    private final java.lang.String buildLanguageString(com.google.android.exoplayer2.Format format) {
        return null;
    }
    
    private final java.lang.String buildBitrateString(com.google.android.exoplayer2.Format format) {
        return null;
    }
    
    private final java.lang.String joinWithSeparator(java.lang.String first, java.lang.String second) {
        return null;
    }
    
    private final java.lang.String buildTrackIdString(com.google.android.exoplayer2.Format format) {
        return null;
    }
    
    private final java.lang.String buildSampleMimeTypeString(com.google.android.exoplayer2.Format format) {
        return null;
    }
}