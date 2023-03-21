package com.release.plexigo.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.release.plexigo.R
import java.util.regex.Pattern

class YoutubeTrailerPlaybackActivity : AppCompatActivity(),
    YouTubePlayer.PlayerStateChangeListener, YouTubePlayer.PlaybackEventListener {
    var VIDEO_ID: String? = null
    private var mFirebaseRemoteConfig: FirebaseRemoteConfig? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_trailer_playback)
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600)
            .build()
        mFirebaseRemoteConfig!!.setConfigSettingsAsync(configSettings)
        mFirebaseRemoteConfig!!.setDefaultsAsync(R.xml.remote_config_defaults)
        mFirebaseRemoteConfig!!.fetchAndActivate()
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                    initYoutube()
                } else {
                    Toast.makeText(
                        this@YoutubeTrailerPlaybackActivity, "Youtube Player initialization failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun initYoutube() {
        val DEVELOPER_KEY = mFirebaseRemoteConfig!!.getString("youtube_key")
        try {
            val YoutubeURL = intent.getStringExtra("TrailerUrl")
            val pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*"
            val compiledPattern = Pattern.compile(pattern)
            val matcher = compiledPattern.matcher(YoutubeURL)
            if (matcher.find()) {
                VIDEO_ID = matcher.group()
            } else {
                Toast.makeText(this, "Invalid youtube link", Toast.LENGTH_SHORT).show()
            }
            val youTubePlayerFragment =
                fragmentManager.findFragmentById(R.id.youtube_fragment) as YouTubePlayerFragment
            youTubePlayerFragment.initialize(
                DEVELOPER_KEY,
                object : YouTubePlayer.OnInitializedListener {
                    override fun onInitializationSuccess(
                        provider: YouTubePlayer.Provider,
                        youTubePlayer: YouTubePlayer,
                        b: Boolean
                    ) {
                        if (!b) {
//                    youTubePlayer.cueVideo(VIDEO_ID);
                            youTubePlayer.loadVideo(VIDEO_ID)
                            youTubePlayer.setPlayerStateChangeListener(this@YoutubeTrailerPlaybackActivity)
                            youTubePlayer.setPlaybackEventListener(this@YoutubeTrailerPlaybackActivity)
                        }
                    }

                    override fun onInitializationFailure(
                        provider: YouTubePlayer.Provider,
                        youTubeInitializationResult: YouTubeInitializationResult
                    ) {
                    }
                })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onPlaying() {}
    override fun onPaused() {}
    override fun onStopped() {
//        onBackPressed();
//        Toast.makeText(this, "Video Stopped", Toast.LENGTH_SHORT).show();
    }

    override fun onBuffering(b: Boolean) {}
    override fun onSeekTo(i: Int) {}
    override fun onLoading() {}
    override fun onLoaded(s: String) {}
    override fun onAdStarted() {}
    override fun onVideoStarted() {}
    override fun onVideoEnded() {
        finish()
    }

    override fun onError(errorReason: YouTubePlayer.ErrorReason) {}
}