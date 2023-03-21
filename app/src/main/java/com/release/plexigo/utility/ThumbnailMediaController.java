/*
 * This software is the confidential and proprietary product of Nagravision S.A., OpenTV, Inc.
 * or its affiliates, the use of which is governed by
 * (i)the terms and conditions of the agreement you accepted by clicking that you agree or
 * (ii) such other agreement entered into between you and Nagravision S.A., OpenTV, Inc. or their affiliates.
 */
package com.release.plexigo.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.release.plexigo.R;

import nagra.otv.sdk.OTVTrackInfo;
import nagra.otv.sdk.OTVVideoView;

public class ThumbnailMediaController extends FrameLayout {

    private OTVVideoView mPlayerView;
    private SeekBar mProgress;
    private ImageButton mPlayButton;
    private ImageButton mFullscreenButton;
    private ImageButton mRewindButton;
    private ImageButton mFastForwardButton;
    private ImageButton mVideoTrack;
    private ImageButton mMultiAudio;
    private ImageButton mSubtitles;
    private ImageButton imgToggleScaleMode;
    private TextView mCurrentTime;
    private TextView mEndTime;
    private View mControllerView;
    private Context mContext;
    private TrackDialog mDialog;

    private boolean isFullscreen = false;
    private boolean mSeekingTouch = false;
    private boolean mSeekingButton = false;
    private int mVideoPos = 0;
    private int mSeekedTime = 0;
    private boolean mProgressUpdaterRunning = false;

    private final static int FADE_OUT = 0;
    private final static int SHOW_PROGRESS = 1;
    //default timeout in milliseconds
    public final static int VIEW_TIMEOUT_DELAY = 4000;

    /*
     * The video view subclasses RelativeLayout. You can use RelativeLayout.LayoutParams to position the
     * media controller with respect to the video view.
     */
    private RelativeLayout.LayoutParams mLayoutParams;
    /*
     * This listener controls the redrawing of the thumbnail when the user tries to seek.
     * A full seek action triggers onStartTrackingTouch, then multiple onProgressChanged, then onStopTrackingTouch
     * We update the thumbnail while a user is seeking (onProgressChanged), but only move the player head
     * once they have lifted their finger (onStopTrackingTouch).
     */
    private OnSeekBarChangeListener mSeekListener = new OnSeekBarChangeListener() {
        @Override
        public void onStartTrackingTouch(SeekBar bar) {
            setSeeking(true);
        }

        @Override
        public void onStopTrackingTouch(SeekBar bar) {
            if (mSeekingTouch) {
                mPlayerView.seekTo(mSeekedTime);
            }
            setSeeking(false);
            mPlayerView.resume();
        }

        @Override
        public void onProgressChanged(SeekBar bar, int progress, boolean fromuser) {
            mSeekedTime = progress;
            if (mSeekingButton) {
                //seek on button press
                mPlayerView.seekTo(mSeekedTime);
            }
            if (mProgress != null) {
                handleProgress();
            }


            if (mPlayerView == null || !fromuser) {
                // We're not interested in programmatically generated changes to
                // the progress bar's position.
                return;
            }

        }
    };

    /**
     * Updates the text views with the current and end playback position
     */
    private int handleProgress() {
        int position = mPlayerView.getCurrentPosition();
        int duration = mPlayerView.getDuration();

        if (mCurrentTime != null) {
            mCurrentTime.setText(stringForTime(position));
        }

        if (mEndTime != null) {
            mEndTime.setText(stringForTime(duration));
        }
        return position;
    }

    private final OnClickListener mPlayListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            showControllerForced(VIEW_TIMEOUT_DELAY);
            if (mPlayerView.isPlaying()) {
                mPlayerView.pause();
            } else {
                mPlayerView.start();
            }
            updateButtonImage();
        }
    };

    private final OnClickListener mRewindListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            showControllerForced(VIEW_TIMEOUT_DELAY);
            int rewindTime = 10000;
            int currentTime = mPlayerView.getCurrentPosition();
            int seekPos = currentTime - rewindTime;
            mSeekingButton = true;
            if (seekPos > 0) {
                mProgress.setProgress(seekPos);
            } else {
                mProgress.setProgress(0);
            }
            mSeekingButton = false;
        }
    };

    private final OnClickListener mFastForwardListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            showControllerForced(VIEW_TIMEOUT_DELAY);
            int skipTime = 10000;
            int currentTime = mPlayerView.getCurrentPosition();
            int seekPos = currentTime + skipTime;
            mSeekingButton = true;
            if (seekPos < mPlayerView.getDuration()) {
                mProgress.setProgress(seekPos);
            } else {
                mProgress.setProgress(mPlayerView.getDuration());
            }
            mSeekingButton = false;
        }
    };

    private final OnClickListener mToggleScaleModeListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mPlayerView != null) {
                if (mPlayerView.getVideoScalingMode() == 1) {
                    mPlayerView.setVideoScalingMode(2);
                    imgToggleScaleMode.setImageResource(R.drawable.ic_collapse);
                } else {
                    if (mPlayerView.getVideoScalingMode() == 2) {
                        mPlayerView.setVideoScalingMode(1);
                        imgToggleScaleMode.setImageResource(R.drawable.ic_expand);
                    }

                }
            }
        }
    };

    private View.OnClickListener mFullscreenListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            isFullscreen = !isFullscreen;
            if (isFullscreen) {
                ((Activity) mContext).getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                ((Activity) mContext).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                if (android.provider.Settings.System.getInt(mContext.getContentResolver(),
                        Settings.System.ACCELEROMETER_ROTATION, 0) == 1) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ((Activity) mContext).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                        }
                    }, 1000);

                } else {
                    ((Activity) mContext).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mPlayerView.getLayoutParams();
                params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                params.height = (int) (250 * mContext.getApplicationContext().getResources().getDisplayMetrics().density);
                mPlayerView.setLayoutParams(params);
            } else {
                ((Activity) mContext).getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                ((Activity) mContext).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
                if (android.provider.Settings.System.getInt(mContext.getContentResolver(),
                        Settings.System.ACCELEROMETER_ROTATION, 0) == 1) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ((Activity) mContext).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                        }
                    }, 1000);

                }
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mPlayerView.getLayoutParams();
                params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                mPlayerView.setLayoutParams(params);
            }

            updateButtonImage();
        }
    };

    /**
     * updates the images used for the media controller button
     */
    public void updateButtonImage() {
        if (mPlayButton == null || mFullscreenButton == null) {
            return;
        }
        if (mPlayerView.isPlaying()) {
            mPlayButton.setImageResource(R.drawable.pause_light);
        } else {
            mPlayButton.setImageResource(R.drawable.play_light);
        }
        if (!isFullscreen) {
            mFullscreenButton.setImageResource(R.drawable.fullscreen_exit_light);
        } else {
            mFullscreenButton.setImageResource(R.drawable.fullscreen_light);
        }
    }

    /*
     * This runnable is responsible for keeping the progress bar in line with the playback position.
     */
    private Runnable mProgressRunner = new Runnable() {
        int mInterval = 1000;

        @Override
        public void run() {
            if (!mSeekingTouch) {
                mProgress.setProgress(mPlayerView.getCurrentPosition());
            }
            if (mPlayerView.getCurrentPosition() < mPlayerView.getDuration()) {
                mProgress.postDelayed(mProgressRunner, mInterval);
                return;
            }
            mProgressUpdaterRunning = false;
        }
    };

    public ThumbnailMediaController(Context context) {
        super(context);
        mContext = context;

        mLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        mLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    }

    public void setMediaPlayer(OTVVideoView player) {
        mPlayerView = player;
        createControllerView();
    }

    public void startMediaController() {
        mProgress.setMax(mPlayerView.getDuration());
        startProgressUpdater();
    }

    private void createControllerView() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mControllerView = inflater.inflate(R.layout.media_controller, mPlayerView, false);

        //initiate all views and their listeners
        mProgress = mControllerView.findViewById(R.id.mediacontroller_progress);
        mCurrentTime = mControllerView.findViewById(R.id.text_current_time);
        mEndTime = mControllerView.findViewById(R.id.text_end_time);
        mPlayButton = mControllerView.findViewById(R.id.play_btn);
        mFullscreenButton = mControllerView.findViewById(R.id.fullscreen_btn);
        mRewindButton = mControllerView.findViewById(R.id.rewind_btn);
        mFastForwardButton = mControllerView.findViewById(R.id.ffwd_btn);
        mVideoTrack = mControllerView.findViewById(R.id.video_button);
        mMultiAudio = mControllerView.findViewById(R.id.audio_button);
        mSubtitles = mControllerView.findViewById(R.id.subtitle_button);
        imgToggleScaleMode = mControllerView.findViewById(R.id.imgToggleScaleMode);

        mProgress.setOnSeekBarChangeListener(mSeekListener);
        mPlayButton.setOnClickListener(mPlayListener);
        mFullscreenButton.setOnClickListener(mFullscreenListener);
        mRewindButton.setOnClickListener(mRewindListener);
        mFastForwardButton.setOnClickListener(mFastForwardListener);
        mDialog = new TrackDialog(mContext, mPlayerView);
        mPlayerView.addView(mControllerView, mLayoutParams);
        imgToggleScaleMode.setOnClickListener(mToggleScaleModeListener);
        showController(VIEW_TIMEOUT_DELAY);
    }

    private void setSeeking(boolean seeking) {
        if (mSeekingTouch && !seeking) {
            mPlayerView.seekTo(mSeekedTime);
            mPlayerView.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
                @Override
                public void onSeekComplete(MediaPlayer mediaPlayer) {
                    startProgressUpdater();
                }
            });
        }
        mSeekingTouch = seeking;
        if (seeking) {
            showControllerForced(VIEW_TIMEOUT_DELAY);
        }
    }

    private void startProgressUpdater() {
        if (mProgressUpdaterRunning) {
            return;
        }
        mProgressUpdaterRunning = true;

        mPlayerView.post(mProgressRunner);
    }

    /*
     * Turns time values into properly formatted strings based on length
     */
    private String stringForTime(int timeMs) {

        StringBuilder formattedDate = new StringBuilder();
        int hours = ((timeMs / 1000) / 60) / 60;
        int minutes = ((timeMs / 1000) / 60) % 60;
        int seconds = timeMs / 1000 % 60;
        if (hours != 0) {
            formattedDate.append(hours).append(":").append(String.format("%1$02d", minutes)).append(":").append(String.format("%1$02d", seconds));
        } else {
            formattedDate.append(String.format("%1$02d", minutes)).append(":").append(String.format("%1$02d", seconds));
        }
        return formattedDate.toString();
    }

    /**
     * creates a listener that will in turn create a dialog view based upon the passed OTVTrackInfo array
     *
     * @param type             a string name of the track type
     * @param track            a sparseArray used by the dialog to create extra tracks
     * @param canSelectNoTrack tells the listener if there should be an option for no track to be used
     * @return
     */
    private OnClickListener createTrackListener(final String type, final SparseArray<OTVTrackInfo> track, final boolean canSelectNoTrack) {
        return new OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = mDialog.createTrackDialog("Set " + type + " Track", track, canSelectNoTrack);
                dialog.show();
                ThumbnailMediaController.this.showController(VIEW_TIMEOUT_DELAY);
            }
        };
    }

    /**
     * pulls the track info from the OTVVideoView and passes it onto button listeners that allow for track selection
     */
    public void updateTracks() {
        SparseArray<OTVTrackInfo> videoTrack = getTracks(OTVTrackInfo.MEDIA_TRACK_TYPE_VIDEO);
        //for all multitrack buttons they will not show unless there is more than 1 track
        if (videoTrack.get(0).getVideoTrackInfos().size() > 1) {
            mVideoTrack.setVisibility(VISIBLE);
            OnClickListener videoListener = createTrackListener("video", videoTrack, false);
            mVideoTrack.setOnClickListener(videoListener);
        } else {
            mVideoTrack.setVisibility(GONE);
        }

        SparseArray<OTVTrackInfo> audioTrack = getTracks(OTVTrackInfo.MEDIA_TRACK_TYPE_AUDIO);
        if (audioTrack.size() > 1) {
            mMultiAudio.setVisibility(VISIBLE);
            OnClickListener audioListener = createTrackListener("audio", audioTrack, false);
            mMultiAudio.setOnClickListener(audioListener);
            //this sets the button to align to the right of the parent when the previous button
            // used for alignment in the relative container view isnt visible
            if (mVideoTrack.getVisibility() == GONE) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mMultiAudio.getLayoutParams();
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                mMultiAudio.setLayoutParams(params);
            }
        } else {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mMultiAudio.getLayoutParams();
            params.addRule(RelativeLayout.LEFT_OF, R.id.video_button);
            mMultiAudio.setLayoutParams(params);
            mMultiAudio.setVisibility(GONE);
        }

        SparseArray<OTVTrackInfo> subtitleTrack = getTracks(OTVTrackInfo.MEDIA_TRACK_TYPE_TIMEDTEXT);
        if (subtitleTrack.size() > 0) {
            mSubtitles.setVisibility(VISIBLE);
            OnClickListener subtitleListener = createTrackListener("subtitle", subtitleTrack, true);
            mSubtitles.setOnClickListener(subtitleListener);
            if (mMultiAudio.getVisibility() == GONE && mVideoTrack.getVisibility() == GONE) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mSubtitles.getLayoutParams();
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                mSubtitles.setLayoutParams(params);
            } else if (mMultiAudio.getVisibility() == GONE && mVideoTrack.getVisibility() == VISIBLE) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mSubtitles.getLayoutParams();
                params.addRule(RelativeLayout.LEFT_OF, R.id.video_button);
                mSubtitles.setLayoutParams(params);
            }
        } else {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mSubtitles.getLayoutParams();
            params.addRule(RelativeLayout.LEFT_OF, R.id.audio_button);
            mSubtitles.setLayoutParams(params);
            mSubtitles.setVisibility(GONE);
        }
    }

    /**
     * Hides the controller
     */
    public void hideController() {
        mControllerView.setVisibility(GONE);
    }

    /**
     * Shows the controller for a set amount of time (the default 5 seconds is VIEW_TIMEOUT_DELAY).
     */
    public void showController(int timeout) {
        if (mControllerView.getVisibility() == GONE) {
            mControllerView.setVisibility(VISIBLE);

            mHandler.sendEmptyMessage(SHOW_PROGRESS);

            Message msg = mHandler.obtainMessage(FADE_OUT);
            if (timeout != 0) {
                mHandler.removeMessages(FADE_OUT);
                mHandler.sendMessageDelayed(msg, timeout);
            }
        } else {
            hideController();
        }
    }

    /**
     * Shows the controller for a set amount of time (the default 5 seconds is VIEW_TIMEOUT_DELAY).
     */
    public void showControllerForced(int timeout) {
        mControllerView.setVisibility(VISIBLE);

        mHandler.sendEmptyMessage(SHOW_PROGRESS);

        Message msg = mHandler.obtainMessage(FADE_OUT);
        if (timeout != 0) {
            mHandler.removeMessages(FADE_OUT);
            mHandler.sendMessageDelayed(msg, timeout);
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mVideoPos = 0;
            switch (msg.what) {
                case FADE_OUT:
                    hideController();
                    break;
                case SHOW_PROGRESS:
                    if (mControllerView.getVisibility() == VISIBLE && mPlayerView != null && mPlayerView.isPlaying()) {

                        msg = obtainMessage(SHOW_PROGRESS);
                        sendMessageDelayed(msg, 1000 - (mVideoPos % 1000));
                    }
                    break;
                default:
                    break;
            }
        }
    };

    /*
     * Expects type to be one of OTVTrackInfo.MEDIA_TRACK_TYPE_*
     * If this is called before video is prepared it will crash
     * Using a SparseArray to preserve index relative to OTVVideoView.getOTVTrackInfo() for track selection
     */
    private SparseArray<OTVTrackInfo> getTracks(int mediaType) {
        OTVTrackInfo[] allTracks = mPlayerView.getOTVTrackInfo();

        SparseArray<OTVTrackInfo> tracks = new SparseArray<>();

        if (allTracks != null) {
            for (int index = 0; index < allTracks.length; index++) {
                OTVTrackInfo track = allTracks[index];

                if (track.getTrackType() == mediaType) {
                    tracks.put(index, track);
                }
            }
        }
        return tracks;
    }

    public void fullscreenButtonClick(boolean isFullScreen) {
        this.isFullscreen = isFullScreen;
        mFullscreenButton.performClick();
    }

    public void showToggleScaleModeButton(boolean show) {
        if (!show && imgToggleScaleMode != null) {
            imgToggleScaleMode.setVisibility(View.GONE);
        }
    }

}
