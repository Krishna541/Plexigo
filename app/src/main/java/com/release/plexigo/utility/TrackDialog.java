package com.release.plexigo.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import nagra.otv.sdk.OTVTrackInfo;
import nagra.otv.sdk.OTVVideoTrackInfo;
import nagra.otv.sdk.OTVVideoView;

public class TrackDialog {

    private OTVVideoView mPlayerView;
    private Context mContext;

    public TrackDialog(Context context, OTVVideoView playerView) {
        mContext = context;
        mPlayerView = playerView;
    }

    /**
     * @param title
     * @param tracks
     * @param canSelectNoTrack
     * @return
     */
    public AlertDialog createTrackDialog(String title, final SparseArray<OTVTrackInfo> tracks,
                                         final boolean canSelectNoTrack) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        // If there's a "no tracks" option, apply this offset so the expected track gets selected
        final int disableButtonOffset = canSelectNoTrack ? 1 : 0;

        ArrayList<String> trackItems = new ArrayList<>();
        if (canSelectNoTrack) {
            trackItems.add("Off");
        }

        int activeItem = -1;
        for (int index = 0; index < tracks.size(); index++) {
            OTVTrackInfo track = tracks.valueAt(index);
            String displayTrackName = track.getName().equals("") ? String.format(Locale.ENGLISH,
                    "Track %d",
                    index + 1) : track.getName();
            String characteristics = track.getCharacteristics().toLowerCase();
            if (track.getTrackType() == OTVTrackInfo.MEDIA_TRACK_TYPE_VIDEO) {
                List<OTVVideoTrackInfo> videoTrackInfos = track.getVideoTrackInfos();
                StringBuilder sb = new StringBuilder();
                String comma = "";
                if (videoTrackInfos != null) {
                    for (OTVVideoTrackInfo videoTrackInfo : videoTrackInfos) {
                        sb.append(comma);
                        comma = ", ";
                        sb.append(String.format(Locale.ENGLISH,
                                "%dx%d",
                                videoTrackInfo.getWidth(),
                                videoTrackInfo.getHeight()));
                    }
                    if (sb.toString().isEmpty()) {
                        displayTrackName = String.format(Locale.ENGLISH, "Track %d", index + 1);
                    } else {
                        displayTrackName = sb.toString();
                    }

                    String codecs = videoTrackInfos.get(0).getCodecs();
                    if (codecs != null && codecs.startsWith("avc")) {
                        displayTrackName = displayTrackName + " [AVC]";
                    } else if (codecs != null && codecs.startsWith("hev")) {
                        displayTrackName = displayTrackName + " [HEVC]";
                    }
                }
            } else if (track.getTrackType() == OTVTrackInfo.MEDIA_TRACK_TYPE_AUDIO) {
                if (!characteristics.isEmpty() && characteristics.equalsIgnoreCase(
                        "public.accessibility.describes-video")) {
                    displayTrackName = displayTrackName + " (AD)";
                }
                int et = track.getEncodeType();
                switch (et) {
                    case OTVTrackInfo.AUDIO_TRACK_ENCODING_TYPE_AAC:
                        displayTrackName = displayTrackName + " [AAC]";
                        break;
                    default:
                        break;
                }
            } else if (track.getTrackType() == OTVTrackInfo.MEDIA_TRACK_TYPE_TIMEDTEXT) {
                if (!characteristics.isEmpty()) {
                    String[] characterisicsArray = characteristics.split(",");
                    for (int j = 0; j < characterisicsArray.length; j++) {
                        if (characterisicsArray[j].equalsIgnoreCase(
                                "public.accessibility.transcribes-spoken-dialog") || characterisicsArray[j].equalsIgnoreCase(
                                "public.accessibility.describes-music-and-sound") || characterisicsArray[j].equalsIgnoreCase(
                                "public.easy-to-read")) {
                            displayTrackName = displayTrackName + " (HoH)";
                            break;
                        }
                    }
                }
                int et = track.getEncodeType();
                switch (et) {
                    case OTVTrackInfo.SUBTITLE_TRACK_ENCODING_TYPE_DVB_BITMAP:
                        displayTrackName = displayTrackName + " [DVB bitmap]";
                        break;
                    case OTVTrackInfo.SUBTITLE_TRACK_ENCODING_TYPE_EIA_608:
                        displayTrackName = displayTrackName + " [CC608]";
                        break;
                    case OTVTrackInfo.SUBTITLE_TRACK_ENCODING_TYPE_EIA_708:
                        displayTrackName = displayTrackName + " [CC708]";
                        break;
                    case OTVTrackInfo.SUBTITLE_TRACK_ENCODING_TYPE_ID3:
                        displayTrackName = displayTrackName + " [ID3]";
                        break;
                    case OTVTrackInfo.SUBTITLE_TRACK_ENCODING_TYPE_WEBVTT:
                        displayTrackName = displayTrackName + " [WebVTT]";
                        break;
                    case OTVTrackInfo.SUBTITLE_TRACK_ENCODING_TYPE_SRT:
                        displayTrackName = displayTrackName + " [SRT]";
                        break;
                    case OTVTrackInfo.SUBTITLE_TRACK_ENCODING_TYPE_SMPTE:
                        displayTrackName = displayTrackName + " [SMPTE]";
                        break;
                    default:
                        break;
                }
            }
            trackItems.add(displayTrackName);
            if (track.isActive()) {
                activeItem = index;
            }
        }

        final int selectedItem = activeItem + disableButtonOffset;
        builder.setTitle(title)
                .setSingleChoiceItems(trackItems.toArray(new String[0]), selectedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (canSelectNoTrack && which == 0 && selectedItem != 0) {
                            mPlayerView.deselectTrack(tracks.keyAt(selectedItem - 1));
                        } else if (which - disableButtonOffset >= 0) {
                            mPlayerView.selectTrack(tracks.keyAt(which - disableButtonOffset));
                        }
                    }
                })
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }
}
