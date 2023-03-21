package com.release.plexigo.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.util.EventLogger
import com.google.android.exoplayer2.util.Util
import com.release.plexigo.Common.AddWatchHistoryService
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.ChatAdapter
import com.release.plexigo.models.AddWatchHistoryRequest
import com.release.plexigo.models.ChatModel
import com.release.plexigo.models.CreateSendBirdUserrequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import com.release.plexigo.utility.ThumbnailMediaController
import com.sendbird.android.BaseChannel.SendUserMessageHandler
import com.sendbird.android.OpenChannel
import com.sendbird.android.OpenChannel.OpenChannelEnterHandler
import com.sendbird.android.OpenChannel.OpenChannelGetHandler
import com.sendbird.android.SendBird
import com.sendbird.android.SendBird.ConnectHandler
import kotlinx.android.synthetic.main.activity_exoplayer.*
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import nagra.otv.sdk.OTVVideoView
import nagra.otv.sdk.drm.OTVHttpMediaDrmCallback
import nagra.otv.sdk.utility.MpdParser
import nagra.otv.sdk.utility.MpdParser.MpdDownloadListener
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.util.*


class VideoPlayerActivity : AppCompatActivity() {
    private var startPosition = 0
    private val eventLogger: EventLogger? = null
    var PLAYBACK_TYPE = 0 //  1 -> trailer, 2-> Non Drm content 3-> DRM content 4-> Live
    var haveStartPosition = false
    var isFestivalMovie = false
    private var timeInterval = 30
    private var PollingTimeInterval =
        60 // pollingtimeinterval - seconds  // default time is 6seconds
    var queue: RequestQueue? = null
    private var contentId = 0
    private var timer: Timer? = null
    private var PollingTimer: Timer? = null
    var isQAEnabled = false
    var openChannelObject: OpenChannel? = null
    private val CHECKUSEREXISTAPI =
        "https://api-4356dbe1-58e9-4ff0-9035-ac7e47bf7a68.sendbird.com/v3/users"
    private var CHANNEL_URL: String? = null

    //    String userid;
    var all_chats: ArrayList<ChatModel>? = null
    var adapter: ChatAdapter? = null
        private val CHAT_API_TOKEN = "d8e5f0094ae84ae78e797868d07f5deceb5bf429"
    private var isBackPressed = false
    var firsttime = true
    private val POLLING_START = "1"
    private val POLLING_ONGOING = "2"
    private var STREAM_URI: String? = ""
    private var STREAM_TOKEN: String? = ""
    private var DRM_URI: String? = ""
    private val DRM_HEADERS: MutableMap<String, String> = HashMap()
    private var mMediaController: ThumbnailMediaController? = null
    private var mOTVVideoView: OTVVideoView? = null
    lateinit var apiInterface : APIInterface

    /*
     * To play encrypted content we need to instantiate an object that implements OTVMediaDrmCallback.
     * For standard use the OTVHttpMediaDrmCallback implementation that can be used by passing in the
     * URL or the licence server and setting the expected HTTP headers and values.
     * This callback object must then be attached to an OTVVideoView object before setting a video
     * path.
     */
    private var mDrmCallback: OTVHttpMediaDrmCallback? = null

    // A listener to thumbnail detection events
    /*
    private IOTVThumbnailListener mThumbnailListener = new IOTVThumbnailListener() {
        @Override
        public void noThumbnails() {
            // Couldn't find thumbnails for the given stream
            android.util.Log.d(TAG, "Selected stream has no thumbnails in the manifest");
        }

        @Override
        public void preparing() {
            // Got a DASH manifest with thumbnails. Preparing thumbnails
            android.util.Log.d(TAG, "Found thumbnails in this stream. Please wait until they are available");
        }

        @Override
        public void prepared(final OTVThumbnailView xView) {
            if (xView != null) {
                mMediaController.setThumbnailView(xView);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mOTVVideoView.addView(xView);
                    }
                });
            }
        }

        @Override
        public void error(int reason) {
            // Failed to fetch thumbnails for some reason
            android.util.Log.w(TAG, "Error preparing thumbnails. Reason - " + OTVThumbnailError.getErrorString(reason));
        }
    };
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        setContentView(R.layout.activity_exoplayer)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        queue = Volley.newRequestQueue(this)
        if (intent.hasExtra("TrailerUrl")) {
            PLAYBACK_TYPE = 1
            STREAM_URI = intent.getStringExtra("TrailerUrl")
        }
        if (intent.hasExtra("movieUrl")) {
            PLAYBACK_TYPE = 2
            STREAM_URI = intent.getStringExtra("movieUrl")
        }
        if (intent.hasExtra("DashUrl")) {
            PLAYBACK_TYPE = 3
            STREAM_URI = intent.getStringExtra("DashUrl")
            STREAM_TOKEN = intent.getStringExtra("token")
            DRM_URI = intent.getStringExtra("licenceUrl")
            mDrmCallback = OTVHttpMediaDrmCallback(DRM_URI)
            run {

                // Server headers
                DRM_HEADERS["Accept"] = "application/octet-stream"
                DRM_HEADERS["Content-Type"] = "application/octet-stream"
                DRM_HEADERS.put("nv-tenant-id", "VSD02FY1")
            }
            run {

                // Set-up callback instance with specific headers for this licence server
                for ((key, value) in DRM_HEADERS) {
                    mDrmCallback!!.setKeyRequestProperty(key, value)
                }
                // Content token is a specific implementation of an SSP licence server
                mDrmCallback!!.setKeyRequestProperty("nv-authorizations", STREAM_TOKEN)
            }
        }
        if (intent.hasExtra("LiveEventUrl")) {
            STREAM_URI = intent.getStringExtra("LiveEventUrl")
            isFestivalMovie = intent.getBooleanExtra("isFestivalMovie", false)
            timeInterval = intent.getIntExtra("timeInterval", 30)
            PLAYBACK_TYPE = 4
            if (intent.hasExtra("isQA") && intent.getStringExtra("isQA") == "YES") {
                AppConstants.ReloadContentDetail = true
                try {
                    all_chats = ArrayList()
                    isQAEnabled = true
                    CHANNEL_URL = intent.getStringExtra("channel_url")
                    if (CHANNEL_URL == null) {
                        Toast.makeText(this, "No chat channel id found", Toast.LENGTH_SHORT).show()
                    } else {
                        chatwindow.visibility = View.VISIBLE
                        chatlayout.visibility = View.VISIBLE
                        send.setOnClickListener(View.OnClickListener {
                            if (message.text.toString().trim { it <= ' ' }.isEmpty()) {
                                Toast.makeText(
                                    this@VideoPlayerActivity,
                                    "Please enter message",
                                    Toast.LENGTH_SHORT
                                ).show()
                                return@OnClickListener
                            }
                            val cal = Calendar.getInstance()
                            val hour = cal[Calendar.HOUR]
                            val minute = cal[Calendar.MINUTE]
                            val msg = message.getText().toString().trim { it <= ' ' }
                            val model = ChatModel(msg ,"$hour:$minute")
                            all_chats!!.add(model)
                            if (adapter == null) {
                                val LayoutManager = LinearLayoutManager(
                                    this@VideoPlayerActivity,
                                    RecyclerView.VERTICAL,
                                    false
                                )
                                LayoutManager.stackFromEnd = true
                                adapter = ChatAdapter(this@VideoPlayerActivity, all_chats!!)
                                chatwindow.setLayoutManager(LayoutManager)
                                chatwindow.setAdapter(adapter)
                            } else {
                                adapter!!.notifyDataSetChanged()
                            }
                            message.setText("")
                            if (openChannelObject != null) {
                                openChannelObject!!.sendUserMessage(msg,
                                    SendUserMessageHandler { userMessage, e ->
                                        if (e != null) {    // Error.
                                            return@SendUserMessageHandler
                                        }

                                        // success
                                    })
                            }
                        })
                        CheckUserIsExist()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        if (intent.hasExtra("WatchDuration") && intent.getIntExtra("WatchDuration", 0) != 0) {
            val seconds = intent.getIntExtra("WatchDuration", 0)
            if (seconds != 0) {
                startPosition = seconds * 1000
                //                Toast.makeText(this, ""+startPosition, Toast.LENGTH_SHORT).show();
                haveStartPosition = true
            }
        }
        if (intent.hasExtra("contentId")) {
            Log.d(
                TAG,
                "onCreate: $contentId"
            )
            contentId = intent.getIntExtra("contentId",0)
            // contentId = getIntent().getIntExtra("contentId", 0);

        }
        if (intent.hasExtra("pollInterval") && intent.getStringExtra("pollInterval") != null) {
            try {
                PollingTimeInterval = Integer.valueOf(intent.getStringExtra("pollInterval"))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        com.google.android.exoplayer2.util.Log.e("Pollcount", "timer $PollingTimeInterval")
        //        url = playurl;
        val getDrmTypesListener: MpdDownloadListener = object : MpdDownloadListener {
            override fun onSuccess(mpdParser: MpdParser) {
                Log.d(TAG, "Got Supported DRM types")
                for (type in mpdParser.supportedDrmTypes) {
                    Log.d(
                        TAG,
                        type!!
                    )
                }
                Log.d(TAG, "Got DRM UUIDs")
                for (uuid in mpdParser.drmUUIDs) {
                    Log.d(
                        TAG,
                        uuid!!
                    )
                }
            }

            override fun onFail(mpdParser: MpdParser, e: Throwable) {
                Log.e(TAG, "Couldn't download manifest for stream", e)
            }
        }
        MpdParser(STREAM_URI!!, getDrmTypesListener)
    }

    override fun onBackPressed() {
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
//         In landscape
            mMediaController!!.fullscreenButtonClick(false)
            return
        }
        if (PLAYBACK_TYPE == 2 || PLAYBACK_TYPE == 3 || PLAYBACK_TYPE == 4) {
            isBackPressed = true
            startPosition = Math.max(0, mOTVVideoView!!.currentPosition)
            var seconds = (startPosition / 1000)
            if (seconds == (mOTVVideoView!!.duration / 1000)) {
                seconds = 0
            }
            intent!!.putExtra("playback", seconds)
            setResult(RESULT_OK, intent)
        }
        super.onBackPressed()
    }

    public override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initializePlayer()
            if (mOTVVideoView != null) {
                mOTVVideoView!!.start()
            }
        }
    }

    public override fun onResume() {
        super.onResume()
        if (Util.SDK_INT <= 23 || mOTVVideoView == null) {
            initializePlayer()
            if (mOTVVideoView != null) {
                mOTVVideoView!!.start()
            }
        }
    }

    public override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
            if (mOTVVideoView != null) {
                mOTVVideoView!!.stopPlayback()
            }
            releasePlayer()
        }
    }

    public override fun onStop() {
        if (PLAYBACK_TYPE == 2 || PLAYBACK_TYPE == 3 || PLAYBACK_TYPE == 4) {
            if (!isBackPressed) {
                startPosition = Math.max(0, mOTVVideoView!!.currentPosition)
                var seconds = (startPosition / 1000)
                if (seconds == (mOTVVideoView!!.duration / 1000)) {
                    seconds = 0
                }
                val addToWatchlistIntent = Intent(this, AddWatchHistoryService::class.java)
                addToWatchlistIntent.putExtra("playback", seconds)
                addToWatchlistIntent.putExtra("contentId", contentId)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(addToWatchlistIntent)
                } else {
                    startService(addToWatchlistIntent)
                }
            }
        }
        if (Util.SDK_INT > 23) {
            if (mOTVVideoView != null) {
                mOTVVideoView!!.stopPlayback()
            }
            releasePlayer()
        }
        super.onStop()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (mOTVVideoView!!.parent != null) {
            val parent = mOTVVideoView!!.parent as ViewGroup
            parent.removeView(mOTVVideoView)
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            val params = mOTVVideoView!!.layoutParams as FrameLayout.LayoutParams
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.height = ViewGroup.LayoutParams.MATCH_PARENT
            mOTVVideoView!!.layoutParams = params
            hideSystemUI()
        } else {
            val params = mOTVVideoView!!.layoutParams as FrameLayout.LayoutParams
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.height = (250 * applicationContext.resources.displayMetrics.density).toInt()
            mOTVVideoView!!.layoutParams = params
            showSystemUI()
        }
        frame!!.addView(mOTVVideoView)
    }

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        val decorView = window.decorView
        decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY // Set the content to appear under the system bars so that the
                    // content doesn't resize when the system bars hide and show.
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN // Hide the nav bar and status bar
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private fun showSystemUI() {
        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    public override fun onDestroy() {
        super.onDestroy()
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
        if (PollingTimer != null) {
            PollingTimer!!.cancel()
            PollingTimer = null
        }
        //        releaseAdsLoader();
    }

    protected fun initializePlayer() {

        // Attaching player view
        mOTVVideoView = OTVVideoView(this)
        mOTVVideoView!!.setMediaDrmCallback(mDrmCallback)
        mOTVVideoView!!.videoScalingMode = 2
        mMediaController = ThumbnailMediaController(this)
        mMediaController!!.setMediaPlayer(mOTVVideoView)
        var showToggleScaleMode = true
        val screenWidth = applicationContext.resources.displayMetrics.widthPixels
        val screenHeight = applicationContext.resources.displayMetrics.heightPixels
        showToggleScaleMode = 1080.toDouble() / 1920 != screenWidth.toDouble() / screenHeight
        mMediaController!!.showToggleScaleModeButton(showToggleScaleMode)
        //            mOTVVideoView.setThumbnailListener(mThumbnailListener, 20000);
        mOTVVideoView!!.setOnTouchListener { view, motionEvent ->
            mMediaController!!.showController(ThumbnailMediaController.VIEW_TIMEOUT_DELAY)
            false
        }
        mOTVVideoView!!.setOnPreparedListener {
            // Only once we get this event, the media controller would have access to properties such
            // as duration or position
            mMediaController!!.startMediaController()
            // Start playback
            mOTVVideoView!!.start()
            //                    mMediaController.updateTracks();
        }

        // For encrypted streams we must set the DRM callback before setting the video path
        mOTVVideoView!!.setVideoPath(STREAM_URI!!)
        frame!!.addView(mOTVVideoView)
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
//         In landscape
            val params = mOTVVideoView!!.layoutParams as FrameLayout.LayoutParams
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.height = ViewGroup.LayoutParams.MATCH_PARENT
            mOTVVideoView!!.layoutParams = params
        } else {
            val params = mOTVVideoView!!.layoutParams as FrameLayout.LayoutParams
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.height = (250 * applicationContext.resources.displayMetrics.density).toInt()
            mOTVVideoView!!.layoutParams = params
        }
        if (PLAYBACK_TYPE == 1 || PLAYBACK_TYPE == 2) {  // Non DRM movie or Trailer
            if (haveStartPosition) {
                mOTVVideoView!!.seekTo(startPosition)
            }
        } else if (PLAYBACK_TYPE == 4) {
            if (isFestivalMovie) {
                val delay = timeInterval * 1000 // delay for 0 sec.
                val period = timeInterval * 1000
                if (timer == null) {
                    timer = Timer()
                    timer!!.scheduleAtFixedRate(object : TimerTask() {
                        override fun run() {
                            fetchContentUrl()
                        }
                    }, 0, period.toLong())
                }
            }
            if (haveStartPosition) {
                mOTVVideoView!!.seekTo(startPosition)
            }
        } else if (PLAYBACK_TYPE == 3) { // DRM content
            if (haveStartPosition) {
                mOTVVideoView!!.seekTo(startPosition)
            }
        }
        if (mOTVVideoView != null) mOTVVideoView!!.addExoEventListener(object :
            Player.EventListener {
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                if (playbackState == Player.STATE_IDLE || !playWhenReady) {
                    mOTVVideoView!!.keepScreenOn = false
                } else if (playbackState == Player.STATE_ENDED) {
                    onBackPressed()
                    finish()
                    HideLoader()
                } else if (playbackState == Player.STATE_BUFFERING) {
                    Showloader()
                } else if (playbackState == Player.STATE_READY) {
                    HideLoader()
                    mOTVVideoView!!.keepScreenOn = true
                    //                    Toast.makeText(ExoplayerActivity.this, "READYNA", Toast.LENGTH_SHORT).show();
                    if (PLAYBACK_TYPE == 2 || PLAYBACK_TYPE == 3 || PLAYBACK_TYPE == 4) {
                        if (PollingTimer == null) {
                            PollingTimer = Timer()
                            PollingTimer!!.scheduleAtFixedRate(object : TimerTask() {
                                override fun run() {
                                    val position = Math.max(0, mOTVVideoView!!.currentPosition)
                                    var seconds = (position / 1000)
                                    if (seconds == (mOTVVideoView!!.duration / 1000)) {
                                        seconds = 0
                                    }
                                    if (firsttime) {
                                        firsttime = false
                                        if (haveStartPosition) {
                                            PollingSavePlaybackDuration(
                                                (startPosition / 1000),
                                                POLLING_START
                                            )
                                        } else {
                                            PollingSavePlaybackDuration(1, POLLING_START)
                                        }
                                        com.google.android.exoplayer2.util.Log.e(
                                            "Pollcount",
                                            "one $POLLING_START"
                                        )
                                    } else {
//                                    if(seconds != 0) {
                                        PollingSavePlaybackDuration(seconds, POLLING_ONGOING)
                                        com.google.android.exoplayer2.util.Log.e(
                                            "Pollcount",
                                            "next called $POLLING_ONGOING"
                                        )
                                        //                                    }
                                    }
                                }
                            }, 1000, (PollingTimeInterval * 1000).toLong())
                        }
                    }
                } else { // STATE_IDLE, STATE_ENDED
                    // This prevents the screen from getting dim/lock
                    mOTVVideoView!!.keepScreenOn = true
                }
            }
        })
    }

    protected fun releasePlayer() {
        if (mOTVVideoView != null) {
            frame!!.removeView(mOTVVideoView)
            mOTVVideoView!!.pause()
        }
    }

    private fun fetchContentUrl(){
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getContentVideoLink(contentId)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            val data = responseModel.data
                            val dataArray = data.contentdetail
                            if (dataArray.size > 0) {
                                val contentObject = dataArray[0]
                                com.google.android.exoplayer2.util.Log.e(
                                    "interval  $timeInterval",
                                    Calendar.getInstance()[Calendar.SECOND].toString() + contentObject.videopath
                                )
                                if (STREAM_URI != contentObject.videopath) {
                                    STREAM_URI = contentObject.videopath.toString()
                                    if (mOTVVideoView != null) {
                                        mOTVVideoView!!.pause()
                                    }
                                    releasePlayer()
                                    initializePlayer()
                                    if (mOTVVideoView != null) {
                                        mOTVVideoView!!.start()
                                    }

                                    // disconnect chat and hide chat view
                                    isQAEnabled = false
                                    chatwindow!!.visibility = View.GONE
                                    chatlayout!!.visibility = View.GONE
                                    if (openChannelObject != null) {
                                        try {
                                            SendBird.disconnect {
                                                com.google.android.exoplayer2.util.Log.d(
                                                    "sendbird",
                                                    "chat disconnected"
                                                )
                                            }
                                        } catch (e: Exception) {
                                            e.printStackTrace()
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@VideoPlayerActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@VideoPlayerActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@VideoPlayerActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@VideoPlayerActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    fun initSendBird(access_token: String?) {
        // Connect to sendbird server
        SendBird.connect(AppConstants.UserId, access_token,
            ConnectHandler { user, e ->
                if (e != null) {    // Error.
                    return@ConnectHandler
                }
            })

        //Enter in a channel
        OpenChannel.getChannel(CHANNEL_URL,
            OpenChannelGetHandler { openChannel, e ->
                if (e != null) {    // Error.
                    return@OpenChannelGetHandler
                }
                openChannel.enter(OpenChannelEnterHandler { e ->
                    if (e != null) {    // Error.
                        return@OpenChannelEnterHandler
                    }
                })
                openChannelObject = openChannel
            })
    }

    private fun CheckUserIsExist(){
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.checkUserExist(AppConstants.UserId!!)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val json = JSONObject(response.body()!!.toString())
                        if (json.has("user_id") && json.getString("user_id") != null) {
                            if (json.has("access_token") && !json.getString("access_token")
                                    .isEmpty()
                            ) {
                                val access_token = json.getString("access_token")
                                initSendBird(access_token)
                            } else {
                                Toast.makeText(
                                    this@VideoPlayerActivity,
                                    "No access token found ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else if (json.has("code") && json.getInt("code") == 400201) {  //user not founc
                            CreateSendbirdUser()
                        } else {
                            if (json.has("message") && json.getString("message") != null) {
                                Toast.makeText(
                                    this@VideoPlayerActivity,
                                    "chat " + json.getString("message"),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@VideoPlayerActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@VideoPlayerActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@VideoPlayerActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@VideoPlayerActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    private fun CreateSendbirdUser(){
        Showloader()
        val request = CreateSendBirdUserrequest(AppConstants.UserId!!,AppConstants.username!!,true,"")
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.createSendbirdUser(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val json = JSONObject(response.body()!!.toString())
                        if (json.has("user_id") && !json.getString("user_id")
                                .isEmpty()
                        ) {
                            if (json.has("access_token") && !json.getString("access_token")
                                    .isEmpty()
                            ) {
                                val access_token = json.getString("access_token")
                                initSendBird(access_token)
                            } else {
                                Toast.makeText(
                                    this@VideoPlayerActivity,
                                    "No access token found ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else if (json.has("code") && json.getInt("code") == 400202) {  //already there
                            //                                CreateSendbirdUser();
                        } else {
                            if (json.has("message") && json.getString("message") != null) {
                                Toast.makeText(
                                    this@VideoPlayerActivity,
                                    "chat " + json.getString("message"),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@VideoPlayerActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@VideoPlayerActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@VideoPlayerActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@VideoPlayerActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.setCancelable(false)
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    private fun  PollingSavePlaybackDuration(duration: Int, action: String?){
        Showloader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request = AddWatchHistoryRequest(AppConstants.UserId!!.toInt(),contentId!!.toInt(),duration,action!!)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.addWatchHistory(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                        }
                    }

                } catch (e: HttpException) {
                    Toast.makeText(this@VideoPlayerActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@VideoPlayerActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@VideoPlayerActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@VideoPlayerActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    companion object {
        var customProgressDialog: CustomProgressDialog? = null
        private const val TAG = "encryptedwidevine"
    }
}