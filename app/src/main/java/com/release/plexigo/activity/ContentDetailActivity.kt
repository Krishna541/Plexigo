package com.release.plexigo.activity

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.TimeoutError
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Common.GpsTracker
import com.release.plexigo.Common.MySpannable
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.*
import com.release.plexigo.fragment.AddToPlaylistDialogFragment
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_content_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
import retrofit2.HttpException
import java.io.IOException
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.SocketException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ContentDetailActivity : AppCompatActivity(), View.OnClickListener,
    PermissionCallbacks, TrailerByLanguageAdapter.OnVideoSelected,
    TvSeriesEpisodeAdapter.OnEpisodeClickListener {
    var preferences: SharedPreferences? = null
    var contentLanguageAdapter: NewContentLanguageAdapter? = null
    var movie: Contentdetail? = null

    //var movie_Live: LiveMovieDetailModel? = null
    var isFav = false
    var rating: Float? = null
    var requestCode = 1001
    var queue: RequestQueue? = null
    var isLive = false
    var isFestivalMovie = false
    var movieId = 0
    var RECEIVE_PLAYBACKSTATE = 119
    var API_VERSION = "1.3"
    var WatchDuration = 0
    var poster_url: String? = null
    var liveVideoUrl: String? = null
    var LivetimeInterval = 0
    var isQAClicked = false
    private val POLLING_STOP = "0"
    private var contentLanguages: ArrayList<LanguageModel>? = null
    private var trailerLanguages: ArrayList<LanguageModel>? = null
    private var selectedLanguage: LanguageModel? = null
    private val featuredPlaylists: ArrayList<UserPlaylistModel>? = ArrayList()
    var featuredPlaylistAdapter = featuredPlaylists?.let { PlaylistAdapter(this, it, true) }
    private var contentLike = 0
    var selectedTabPosition = 0
    private val tvSeriesEpisodeAdapter =
        TvSeriesEpisodeAdapter(this, ArrayList(), this@ContentDetailActivity)
    private var tabLayoutSeasons: TabLayout? = null
    lateinit var apiInterface: APIInterface
    private val selectedLanguageListener: NewContentLanguageAdapter.OnLanguageSelected = object :
        NewContentLanguageAdapter.OnLanguageSelected {
        override fun onLanguageSelected(language: LanguageModel?) {
            selectedLanguage = language
            contentLanguageAdapter = NewContentLanguageAdapter(
                contentLanguages!!,
                this, selectedLanguage!!
            )
            recyclerContentLanguages!!.adapter = contentLanguageAdapter
            trailerLanguages!!.clear()
            trailerLanguages!!.add(selectedLanguage!!)
            contentLanguageAdapter = NewContentLanguageAdapter(
                contentLanguages!!,
                this, selectedLanguage!!
            )
        }
    }
    private var selectedEpisode: TvSeriesEpisode? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (this.requestCode == requestCode) {
            if (resultCode == 200) { //success
                Toast.makeText(this, "Payment Success!", Toast.LENGTH_SHORT).show()
                PlayVideo()
                //                getVideoDetails();
            } else if (resultCode == 400) { //failure
                Toast.makeText(this, "Transaction failed! Please try again", Toast.LENGTH_SHORT)
                    .show()
            } else if (resultCode == 413) { // aborted
                Toast.makeText(this, "Transaction cancelled !", Toast.LENGTH_SHORT).show()
            } else if (resultCode == 11) { //back pressed from payment page by user
                Toast.makeText(this, "Transaction cancelled !", Toast.LENGTH_SHORT).show()
            }
        } else if (RECEIVE_PLAYBACKSTATE == requestCode) {
            if (resultCode == RESULT_OK) {
                try {
                    if (data != null && data.hasExtra("playback")) {
                        val startposition = data.getIntExtra("playback", 0)
                        AddWatchHistory(startposition)
                        WatchDuration = startposition
                        //                        Toast.makeText(this, "Duration is " + startposition, Toast.LENGTH_SHORT).show();
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun PlayVideo() {
        if (!TextUtils.isEmpty(movie!!.isDRMContent) && movie!!.isDRMContent.equals(
                "y",
                ignoreCase = true
            )
        ) { // DRM content
            GetContentToken()
        } else {
            if (movie!!.contentType.lowercase(Locale.getDefault()).contains("series")) {
                if (selectedEpisode != null) {
                    if (TextUtils.isEmpty(selectedEpisode!!.videopath)) {
                        GetContentToken()
                    } else {
                        val intent = Intent(
                            this@ContentDetailActivity,
                            VideoPlayerActivity::class.java
                        )
                        intent.putExtra("movieUrl", selectedEpisode!!.videopath)
                        intent.putExtra(
                            "WatchDuration",
                            Integer.valueOf(selectedEpisode!!.watchDuration)
                        )
                        intent.putExtra(
                            "contentId",
                            Integer.valueOf(selectedEpisode!!.contentEpisodeID)
                        )
                        intent.putExtra("pollInterval", movie!!.pollInterval)
                        startActivityForResult(intent, RECEIVE_PLAYBACKSTATE)
                    }
                }
            } else {
                if (!TextUtils.isEmpty(selectedLanguage!!.videopath)) { // non DRM
                    val intent = Intent(this@ContentDetailActivity, VideoPlayerActivity::class.java)
                    intent.putExtra("movieUrl", selectedLanguage!!.videopath)
                    intent.putExtra("WatchDuration", WatchDuration)
                    intent.putExtra("contentId", movie!!.contentid)
                    intent.putExtra("pollInterval", movie!!.pollInterval)
                    startActivityForResult(intent, RECEIVE_PLAYBACKSTATE)
                } else {
                    GetMovieDetailApi()
                    Toast.makeText(
                        this@ContentDetailActivity,
                        "No Video details found",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_detail)
        hideSystemUI()
        preferences = PreferenceManager.getDefaultSharedPreferences(this)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        imgActorBanner.clipToOutline = true
        recyclerFeaturedInLists.adapter = featuredPlaylistAdapter
        featuredPlaylistAdapter!!.setOnPlayListItemSelectedListener(object :
            PlaylistAdapter.OnPlayListItemSelectedListener {
            override fun onPlayListItemSelected(playlist: UserPlaylistModel?) {
                val intent =
                    Intent(this@ContentDetailActivity, PlaylistContentListingActivity::class.java)
                intent.putExtra("playlistId", playlist?.playlistId)
                intent.putExtra("playlistTitle", playlist?.title)
                startActivity(intent)
            }
        })
        imgAddToPlaylist.setOnClickListener(this)
        back_btn.setOnClickListener(this)
        qanda.setOnClickListener(this)
        txtSeasonSelection.setOnClickListener(this)
        tabLayoutSeasons = findViewById(R.id.tabLayoutSeasons)
        recyclerEpisodes.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerEpisodes.adapter = tvSeriesEpisodeAdapter
        imgLikeContent.setOnClickListener(View.OnClickListener {
            if (AppConstants.isUserLoggedIn) {
                val likeReset: Int = if (contentLike == 1) {
                    0
                } else {
                    1
                }
                callLikeDislikeContent(likeReset)
            } else {
                val intent1 = Intent(this@ContentDetailActivity, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
        })
        imgDislikeContent.setOnClickListener(View.OnClickListener {
            if (AppConstants.isUserLoggedIn) {
                val likeReset: Int = if (contentLike == 2) {
                    0
                } else {
                    2
                }
                callLikeDislikeContent(likeReset)
            } else {
                val intent1 = Intent(this@ContentDetailActivity, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
        })
        movieId = intent.getIntExtra("movieId", 0)
        poster_url = intent.getStringExtra("poster_url")
        if (intent.hasExtra("WatchDuration") && intent.getIntExtra("WatchDuration", 0) != 0) {
            WatchDuration = intent.getIntExtra("WatchDuration", 0)
        }
        queue = Volley.newRequestQueue(this@ContentDetailActivity)
        GetMovieDetailApi()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        if (AddfavoritesActive) {
            AddfavoritesActive = false
            if (AppConstants.isUserLoggedIn) {
//                AddtoFavorites();
            }
        }
        if (AppConstants.IsPaypalPaymentStarted) {
            AppConstants.IsPaypalPaymentStarted = false
            if (AppConstants.PaypalPaymentStatus == null) {
                return
            }
            if (AppConstants.PaypalPaymentStatus == "success") {
                AppConstants.PaypalPaymentStatus = null
                Toast.makeText(this, "Payment Success!", Toast.LENGTH_SHORT).show()
                PlayVideo()
            } else if (AppConstants.PaypalPaymentStatus == "failure") {
                AppConstants.PaypalPaymentStatus = null
                Toast.makeText(this, "Transaction failed! Please try again", Toast.LENGTH_SHORT)
                    .show()
            } else if (AppConstants.PaypalPaymentStatus == "cancel") {
                AppConstants.PaypalPaymentStatus = null
                Toast.makeText(this, "Transaction cancelled !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun setMovieData() {
        val ottList = ArrayList<OTTModel>()
        for (ottModel in movie!!.ottPlatforms) {
            if (!TextUtils.isEmpty(ottModel.ottPlatform) /* && !TextUtils.isEmpty(ottModel.getUrl())*/) {
                ottList.add(ottModel)
            }
        }
        if (ottList.size > 0) {
            var plexigo_amount = ""
            if (movie!!.country == "India") {
                plexigo_amount = if (movie!!.inr != "0") {
                    "\u20B9 " + movie!!.inr
                } else {
                    "Free"
                }
            } else {
                if (movie!!.usd != null) {
                    plexigo_amount = if (movie!!.usd != "0") {
                        "\u0024 " + movie!!.usd
                    } else {
                        "Free"
                    }
                }
            }
            val ottAdapter = OTTAdapter(this@ContentDetailActivity,
                ottList,
                plexigo_amount,
                movie!!.rentValidity,
                object : OTTAdapter.OTTClickHandler {
                    override fun onImageLoaded() {}
                    override fun OnOttClick(ottModel: OTTModel?) {
                        if (AppConstants.isUserLoggedIn) {
                            if (ottModel?.buttonIcon.equals("book", ignoreCase = true)) {
                                PlayInOtherOtt(ottModel?.url, true)
                            } else {
                                if (ottModel?.ottPlatform == "Plexigo") {
                                    isQAClicked = false
                                    PlayInPlexigo()
                                } else {
                                    PlayInOtherOtt(ottModel?.url, false)
                                }
                            }
                        } else {
                            AppConstants.ReloadMenus = true
                            val intent1 =
                                Intent(this@ContentDetailActivity, LoginActivity::class.java)
                            intent1.putExtra("reload", "false")
                            startActivity(intent1)
                        }
                    }
                })
            otts!!.adapter = ottAdapter
        }
        if (movie!!.showLikes.equals("y", ignoreCase = true)) {
            contentLike = movie!!.userLikes
            if (contentLike == 0) {
                imgLikeContent!!.visibility = View.VISIBLE
                imgDislikeContent!!.visibility = View.VISIBLE
                txtTitleLikeContent!!.text = "Like this content?"
            } else {
                if (contentLike == 1) {
                    imgLikeContent!!.visibility = View.VISIBLE
                    imgDislikeContent!!.visibility = View.GONE
                    txtTitleLikeContent!!.text = "Content Liked!"
                } else {
                    if (contentLike == 2) {
                        imgLikeContent!!.visibility = View.GONE
                        imgDislikeContent!!.visibility = View.VISIBLE
                        txtTitleLikeContent!!.text = "Content Disliked!"
                    }
                }
            }
        }
        try {
            if (movie!!.ppv.equals(
                    "Y",
                    ignoreCase = true
                ) && movie!!.thumbnailText!!.isNotEmpty() && !movie!!.thumbnailText.isNullOrBlank()
            ) {
                txtWatchOnPlexigo.text = movie!!.thumbnailText
                txtWatchOnPlexigo!!.visibility = View.VISIBLE
            }
        } catch (e: Exception) {
            Log.d("TAG", "setMovieData: " + e)
        }


        imgAddToPlaylist!!.visibility = View.VISIBLE
        txtCategoryYear!!.text =
            movie!!.censorrating + " . " + movie!!.contentType + " . " + movie!!.releaseyear

        try {
            if (movie!!.rentValidity.equals(
                    "Y",
                    ignoreCase = true
                ) && movie!!.contentExpiryTime!!.isNotEmpty() && !movie!!.contentExpiryTime.isNullOrBlank()
            ) {
                txtCategoryYear.append(" . " + movie!!.contentExpiryTime)
            }
        } catch (e: Exception) {
            Log.d("TAG", "setMovieData: " + e)
        }

        if (!TextUtils.isEmpty(movie!!.synopsis)) {
            txtContentSynopsis!!.text = movie!!.synopsis
            txtContentSynopsis!!.post {
                val lineCount = txtContentSynopsis!!.lineCount
                if (lineCount > 3) {
                    makeTextViewResizable(txtContentSynopsis, 3, "...More", true, 3)
                }
            }
        }
        if (movie!!.isQnAEnabled != null && movie!!.isQnAEnabled == "Y") {
            qanda!!.visibility = View.VISIBLE
        } else {
            qanda!!.visibility = View.GONE
        }
        getSimilarMovieListing(movie!!.contentid)

        GlideApp
            .with(this)
            .load(movie!!.posterpath)
            .placeholder(R.drawable.plexigo_new_transperent_logo)
            .transform(RoundedCorners(15))
            .into(movie_poster)
        GlideApp
            .with(this)
            .load(movie!!.imagepath)
            .placeholder(R.drawable.plexigo_new_transperent_logo)
            .into(imgActorBanner)
        movie_title!!.text = movie!!.contentname
        back_btn!!.visibility = View.VISIBLE
        if (movie!!.duration != null && movie!!.duration != "0") {
            duration!!.text = movie!!.duration
        } else {
            duration!!.visibility = View.GONE
        }
        var data = ""
        if (movie!!.releaseyear != null && !movie!!.releaseyear.isEmpty()) {
            data = data + movie!!.releaseyear + "  |  "
        }
        if (movie!!.genere != null && !movie!!.genere.isEmpty()) {
            data = data + movie!!.genere
        }
        txtGenre!!.text = data
        WatchDuration = movie!!.watchDuration.toInt()
        contentLanguages = ArrayList()
        trailerLanguages = ArrayList()
        contentLanguages!!.addAll(movie!!.languages)
        if (contentLanguages!!.size > 0) {
            selectedLanguage = contentLanguages!![0]
            contentLanguageAdapter = NewContentLanguageAdapter(
                contentLanguages!!,
                selectedLanguageListener,
                selectedLanguage!!
            )
            recyclerContentLanguages!!.adapter = contentLanguageAdapter
            if (selectedLanguage != null && !TextUtils.isEmpty(selectedLanguage!!.trailerpath)) {
                trailerLanguages!!.add(selectedLanguage!!)
            }
            if (trailerLanguages!!.size > 0) {
                val trailerAdapter =
                    TrailerByLanguageAdapter(this, trailerLanguages!!, movie!!.imagepath, this)
                recyclerTrailerAndVideo!!.adapter = trailerAdapter
                txtTrailerAndVideo!!.visibility = View.VISIBLE
            } else {
                txtTrailerAndVideo!!.visibility = View.GONE
            }
        }
        if (movie!!.castCrew != null && movie!!.castCrew.size > 0) {
            val castCrewAdapter = CastCrewAdapter(this, movie!!.castCrew)
            recyclerCastCrew!!.adapter = castCrewAdapter
            txtCastCrewHeader!!.visibility = View.VISIBLE
        } else {
            txtCastCrewHeader!!.visibility = View.GONE
        }
        if (movie!!.contentType.lowercase(Locale.getDefault()).contains("series")) {
            if (movie!!.seasons.isNotEmpty()) {
                layoutSeriesSeasons!!.visibility = View.VISIBLE
                txtSeasonCount!!.text = movie!!.seasons.size.toString() + " Season(s)"
                txtSeasonSelection!!.text = movie!!.seasons[0].seasonname
                tvSeriesEpisodeAdapter.setTvSeriesEpisodes(movie!!.seasons[0].episodes)
                if (movie!!.seasons[0].episodes != null
                    && movie!!.seasons[0].episodes.size > 0
                ) selectedEpisode = movie!!.seasons[0].episodes[0]
                tabLayoutSeasons!!.removeAllTabs()
                for (season in movie!!.seasons) {
                    val tab = tabLayoutSeasons!!.newTab()
                    tab.text = season.seasonname
                    tabLayoutSeasons!!.addTab(tab)
                }
                tabLayoutSeasons!!.addOnTabSelectedListener(object : OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab) {
                        val season = movie!!.seasons[tab.position]
                        tvSeriesEpisodeAdapter.setTvSeriesEpisodes(season.episodes)
                        //                        tvSeriesEpisodeAdapter.notifyDataSetChanged();
                        txtSeasonSelection!!.text = season.seasonname
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab) {}
                    override fun onTabReselected(tab: TabLayout.Tab) {}
                })
            } else {
                layoutSeriesSeasons!!.visibility = View.GONE
            }
        } else {
            layoutSeriesSeasons!!.visibility = View.GONE
        }
    }

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog.show(ft, "dialog")
        customProgressDialog.setCancelable(false)
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    @Throws(ParseException::class)
    private fun getDate(strDate: String): String {
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            .parse(strDate)
        Log.d("TAG", "getDate: " + date)
        val dayNumberSuffix = getDayNumberSuffix(date.date)
        val dateFormat = SimpleDateFormat("d'$dayNumberSuffix' MMM yyyy")
        return dateFormat.format(date)
    }

    private fun getDayNumberSuffix(n: Int): String {
        return if (n >= 11 && n <= 13) {
            "th"
        } else when (n % 10) {
            1 -> "st"
            2 -> "nd"
            3 -> "rd"
            else -> "th"
        }
    }

    private fun hideSystemUI() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }

    private fun callLikeDislikeContent(likeDislikeReset: Int) {
        val request = LikeDislikeContentRequest(
            movie!!.contentid,
            (if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt(),
            likeDislikeReset
        )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.callLikeDislikeContent(request)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            GetMovieDetailApi()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ContentDetailActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (error: Throwable) {
                    HideLoader()
                    if (error is TimeoutError) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (error.cause is IOException) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@ContentDetailActivity,
                        "" + error.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.imgAddToPlaylist -> if (AppConstants.isUserLoggedIn) {
                AddToPlaylistDialogFragment.newInstance(movie!!.contentid).show(
                    supportFragmentManager, ""
                )
            } else {
                val intent1 = Intent(this@ContentDetailActivity, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
            R.id.back_btn -> onBackPressed()
            R.id.qanda -> if (AppConstants.isUserLoggedIn) {
                checkStoragePermission()
            } else {
                AppConstants.ReloadMenus = true
                val intent1 = Intent(this@ContentDetailActivity, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
        }
    }

    private fun checkStoragePermission() {
        try {
            if (ContextCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1001
                )
            } else {
                isQAClicked = true
                fetchContentUrl()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun checkLocationPermission() {
        val perms = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        if (EasyPermissions.hasPermissions(this, *perms)) {
            val gpsTracker = GpsTracker(this@ContentDetailActivity, null)
            if (gpsTracker.canGetLocation()) {
                AppConstants.UserLatitude = gpsTracker.latitude
                AppConstants.UserLongitude = gpsTracker.longitude
                PlayInPlexigo()
            } else {
                gpsTracker.showSettingsAlert()
            }
        } else {
            EasyPermissions.requestPermissions(
                this, getString(R.string.location_rationale),
                101, *perms
            )
        }
    }

    fun PlayInPlexigo() {
        if (isFestivalMovie) {
            fetchContentUrl()
            return
        }
        if (isLive) {
            PlayLiveEvent(selectedLanguage!!.videopath, 0)
            return
        }

        //Enable Geolock
        if (AppConstants.UserLatitude != null && AppConstants.UserLongitude != null && AppConstants.UserLatitude != 0.0 && AppConstants.UserLongitude != 0.0) {
            IsContentGeoAuthorized()
        } else {
            checkLocationPermission()
        }

    }

    fun PlayInOtherOtt(url: String?, openInBrowser: Boolean) {
        val location = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, location)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "This app is not available on your mobile", Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            101 -> {
                EasyPermissions.onRequestPermissionsResult(
                    requestCode,
                    permissions,
                    grantResults,
                    this
                )
            }
            1001 -> if (grantResults.size > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                isQAClicked = true
                fetchContentUrl()
            } else {
                Toast.makeText(
                    this,
                    "Please allow storage permission to enter in Q&A",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        val gpsTracker = GpsTracker(this@ContentDetailActivity, null)
        if (gpsTracker.canGetLocation()) {
            AppConstants.UserLatitude = gpsTracker.latitude
            AppConstants.UserLongitude = gpsTracker.longitude
            IsContentGeoAuthorized()
        } else {
            gpsTracker.showSettingsAlert()
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

    fun IsContentGeoAuthorized() {
        Showloader()
        val ip = localIpAddress
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request = ContentGeoAuthorizesRequest(
            AppConstants.UserLatitude.toString(), AppConstants.UserLongitude.toString(), ip!!,
            Integer.valueOf(movie!!.contentid), Integer.valueOf(AppConstants.UserId)
        )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.checkGeoAuthorizedContent(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.result == "true") { //video accessible
                            //video accessible
                            if (movie!!.ppv == "Y" && !movie!!.inr
                                    .equals("0") && !movie!!.inr.equals("-1")
                            ) {
                                CheckIfUserPpvSubscribed()
                            } else if (movie!!.ppv.equals("N") && movie!!.rentValidity
                                    .equals("N")
                            ) {
                                showConfirmationDialog()
                            } else {
                                PlayVideo()
                            }
                        } else if (responseModel?.result == "false") { //Video not accessible
                            Toast.makeText(
                                this@ContentDetailActivity,
                                responseModel.message,
                                Toast.LENGTH_LONG
                            ).show()

                        } else {
                            Toast.makeText(
                                this@ContentDetailActivity,
                                "" + responseModel?.result,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ContentDetailActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@ContentDetailActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    private fun showConfirmationDialog() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.dialog_create_playlist, null)
        val pwindo = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val txtTitle = layout.findViewById<TextView>(R.id.txtTitle)
        val edtPlayListName = layout.findViewById<EditText>(R.id.edtPlayListName)
        val btnCancel = layout.findViewById<Button>(R.id.btnCancel)
        val btnSave = layout.findViewById<Button>(R.id.btnSave)
        txtTitle.text = getString(R.string.redirection_message)
        txtTitle.textSize = 16f
        edtPlayListName.visibility = View.GONE
        btnSave.text = "Ok"
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            val intent = Intent(this@ContentDetailActivity, NewHomeActivity::class.java)
            intent.putExtra("OPEN_PROFILE_PAGE", false)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            pwindo.dismiss()
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }


    private fun fetchContentUrl() {
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getContentVideoLink(movie!!.contentid)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val data = responseModel.data
                            val dataArray = data.contentdetail
                            if (dataArray.size > 0) {
                                val contentObject = dataArray[0]
                                val videoPath = contentObject.videopath
                                val timeInterval = contentObject.pollInterval.toInt()
                                if (isQAClicked) {
                                    liveVideoUrl = videoPath.toString()
                                    LivetimeInterval = timeInterval
                                    PlayLiveEventWithQA()
                                } else {
                                    PlayLiveEvent(videoPath.toString(), timeInterval)
                                }
                            } else {
                                Toast.makeText(
                                    this@ContentDetailActivity,
                                    "Video not available at this moment",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ContentDetailActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@ContentDetailActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun PlayLiveEventWithQA() {
        val intent = Intent(this@ContentDetailActivity, VideoPlayerActivity::class.java)
        intent.putExtra("LiveEventUrl", liveVideoUrl)
        intent.putExtra("timeInterval", LivetimeInterval)
        intent.putExtra("isFestivalMovie", isFestivalMovie)
        intent.putExtra("contentId", movie!!.contentid)
        intent.putExtra("pollInterval", movie!!.pollInterval)
        intent.putExtra("isQA", "YES")
        intent.putExtra("channel_url", movie!!.channelID)
        startActivityForResult(intent, RECEIVE_PLAYBACKSTATE)
    }

    private fun CheckIfUserPpvSubscribed() {
        Showloader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        var contentId: String? = ""
        if (movie!!.contentType.lowercase(Locale.getDefault()).contains("series")) {
            if (selectedEpisode != null) {
                contentId = selectedEpisode!!.contentEpisodeID
            }
        } else {
            contentId = movie!!.contentid.toString()
        }
        val request = CheckUserIsPpvSubscribeRequest(
            AppConstants.UserId!!.toInt(),
            contentId!!.toInt(),
            movie!!.ppvValidity,
            if (movie!!.ppvType == "hours") "Hour" else movie!!.ppvType
        )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.CheckIfUserPpvSubscribed(WsConstants.CheckExpiry, request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        if (response.body()?.validationStatus == "Valid") { //already paid
                            PlayVideo()
                        } else if (response.body()?.validationStatus == "Expired") { //Plan Expired
                            OpenPPVPopupLayout()
                        } else if (response.body()?.validationStatus == "Not Purchased") { //Plan Expired
                            OpenPPVPopupLayout()
                        } else {
                            Toast.makeText(
                                this@ContentDetailActivity,
                                "Validation Status " + response.body()?.validationStatus,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ContentDetailActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@ContentDetailActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun OpenPPVPopupLayout() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val tint_layout: View = inflater.inflate(R.layout.black_tint_layout, null)
        val layout: View = inflater.inflate(R.layout.ppv_layout, null)
        val pWindow = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val ppv_movie_name = layout.findViewById<TextView>(R.id.ppv_movie_name)
        val ppv_amount = layout.findViewById<TextView>(R.id.ppv_amount)
        val txtTacText = layout.findViewById<TextView>(R.id.txtTacText)
        val txtTacLink = layout.findViewById<TextView>(R.id.txtTacLink)
        val skip = layout.findViewById<Button>(R.id.skip)
        val btnCCAvenue = layout.findViewById<ImageView>(R.id.btnCCAvenue)
        val btnPayPal = layout.findViewById<ImageView>(R.id.btnPayPal)
        for (paymentGatewayModel in movie!!.paymentGateway) {
            if (paymentGatewayModel.pg.toLowerCase().contains("ccavenue")) {
                btnCCAvenue.visibility = View.VISIBLE
                Glide
                    .with(this)
                    .load(paymentGatewayModel.imagePath)
                    .into(btnCCAvenue)
                continue
            }
            if (paymentGatewayModel.pg.toLowerCase().contains("paypal")) {
                btnPayPal.visibility = View.VISIBLE
                Glide
                    .with(this)
                    .load(paymentGatewayModel.imagePath)
                    .into(btnPayPal)
                continue
            }
        }
        txtTacText.text = movie!!.tacText
        val tacLink = "| Terms & Conditions |"
        val str = SpannableStringBuilder(tacLink)
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                val intent = Intent(this@ContentDetailActivity, WebViewActivity::class.java)
                intent.putExtra("urlToLoad", movie!!.tacLink)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.linkColor = resources.getColor(R.color.colorAccent)
            }
        }
        str.setSpan(clickableSpan, 2, tacLink.length - 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        str.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.colorAccent)),
            2,
            tacLink.length - 2,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        txtTacLink.text = str
        txtTacLink.movementMethod = LinkMovementMethod.getInstance()
        txtTacLink.highlightColor = Color.TRANSPARENT
        txtTacLink.text = str
        ppv_movie_name.text = movie!!.contentname
        //if(preferences.getString("countryCode","").equals("91")) {
        /*}else{
            ppv_amount.setText("$"+movie.getUsd());
        }*/
//        movie.getPpvTitle()
        var plexigo_amount = ""
        if (movie!!.country == "India") {
            plexigo_amount = "\u20B9 " + movie!!.inr
        } else {
            if (movie!!.usd != null) {
                plexigo_amount = "\u0024" + movie!!.usd
            }
        }
        ppv_amount.text = plexigo_amount
        skip.setOnClickListener { pWindow.dismiss() }
        btnCCAvenue.setOnClickListener {
            pWindow.dismiss()
            val ip = Intent(this@ContentDetailActivity, WebPaymentActivity::class.java)
            ip.putExtra("movieid", movie!!.contentid.toString())
            ip.putExtra("userid", AppConstants.UserId)
            if (movie!!.country == "India") {
                ip.putExtra("currency", "INR")
                ip.putExtra("amount", movie!!.inr)
            } else {
                ip.putExtra("currency", "USD")
                ip.putExtra("amount", movie!!.usd)
            }
            startActivityForResult(ip, requestCode)
        }
        btnPayPal.setOnClickListener { //                Toast.makeText(ContentDetailActivity.this, "PayPal payment flow", Toast.LENGTH_SHORT).show();
            val ip = Intent(this@ContentDetailActivity, PaypalPaymentActivity::class.java)
            AppConstants.IsPaypalPaymentStarted = true
            ip.putExtra("movieid", movie!!.contentid.toString())
            ip.putExtra("userid", AppConstants.UserId)
            if (movie!!.country == "India") {
                ip.putExtra("currency", "INR")
                ip.putExtra("amount", movie!!.inr)
                ip.putExtra("CountryCode", "IN")
            } else {
                ip.putExtra("currency", "USD")
                ip.putExtra("amount", movie!!.usd)
                ip.putExtra("CountryCode", "US")
            }
            startActivityForResult(ip, requestCode)
            pWindow.dismiss()
        }
        val popupWindow2 = PopupWindow(
            tint_layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        pWindow.isFocusable = true
        //        popupWindow2.showAtLocation(tint_layout, Gravity.CENTER, 0, 0);
        pWindow.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    fun PlayLiveEvent(videoPath: String?, timeInterval: Int) {
        val intent = Intent(this@ContentDetailActivity, VideoPlayerActivity::class.java)
        intent.putExtra("LiveEventUrl", videoPath)
        intent.putExtra("timeInterval", timeInterval)
        intent.putExtra("isFestivalMovie", isFestivalMovie)
        intent.putExtra("contentId", movie!!.contentid)
        intent.putExtra("WatchDuration", movie!!.watchDuration.toInt())
        intent.putExtra("isQA", "NO")
        intent.putExtra("pollInterval", movie!!.pollInterval)
        startActivityForResult(intent, RECEIVE_PLAYBACKSTATE)
    }

    private fun GetMovieDetailApi() {
        Showloader()
        apiInterface = APIClient.getClient("1.3").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getMovieDetailApi(
                movieId,
                (if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt()
            )
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            rating = 0f
                            val all: ArrayList<Contentdetail> = model.contentdetail
                            if (all.size > 0) {
                                movie = all[0]
                                if (movie!!.isLive == "1") {
                                    isLive = true
                                }
                                if (movie!!.isFilmFestival.toLowerCase() == "y") {
                                    isFestivalMovie = true
                                }
                                setMovieData()
                            }

                        } else {
                            Toast.makeText(
                                this@ContentDetailActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ContentDetailActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@ContentDetailActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    fun AddWatchHistory(duration: Int) {
        Showloader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        var contentId: String? = ""
        if (movie!!.contentType.lowercase(Locale.getDefault()).contains("series")) {
            if (selectedEpisode != null) {
                contentId = selectedEpisode!!.contentEpisodeID
            }
        } else {
            contentId = movie!!.contentid.toString()
        }
        val request = AddWatchHistoryRequest(
            AppConstants.UserId!!.toInt(),
            contentId!!.toInt(),
            duration,
            POLLING_STOP
        )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.addWatchHistory(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            GetMovieDetailApi()
                        }
                    }
                    if (AppConstants.ReloadContentDetail) {
                        AppConstants.ReloadContentDetail = false
                        GetMovieDetailApi()
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ContentDetailActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@ContentDetailActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun GetContentToken() {
        Showloader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val contentId: String
        contentId = if (movie!!.contentType.lowercase(Locale.getDefault()).contains("series")) {
            if (selectedEpisode == null) {
                Toast.makeText(
                    this@ContentDetailActivity,
                    "No Video details found",
                    Toast.LENGTH_SHORT
                ).show()
                HideLoader()
                return
            }
            selectedEpisode!!.contentEpisodeID
        } else {
            selectedLanguage!!.contentId.toString()
        }
        CoroutineScope(Dispatchers.IO).launch {
            val response =
                apiInterface.getContentToken(contentId!!.toInt(), AppConstants.UserId!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.status == "200") {
                            val token = responseModel.contentToken
                            val intent =
                                Intent(this@ContentDetailActivity, VideoPlayerActivity::class.java)
                            intent.putExtra("DashUrl", responseModel.dashURL)
                            intent.putExtra("licenceUrl", responseModel.widevineLicenseURL)
                            var SelectedWatchDuration = 0
                            if (movie!!.contentType.lowercase(Locale.getDefault())
                                    .contains("series")
                            ) {
                                if (selectedEpisode != null) {
                                    SelectedWatchDuration =
                                        selectedEpisode!!.watchDuration.toInt()

                                }
                            } else {
                                SelectedWatchDuration = WatchDuration
                            }
                            intent.putExtra("WatchDuration", SelectedWatchDuration)
                            intent.putExtra("token", token)
                            var contentId: String? = ""
                            if (movie!!.contentType.lowercase(Locale.getDefault())
                                    .contains("series")
                            ) {
                                if (selectedEpisode != null) {
                                    contentId = selectedEpisode!!.contentEpisodeID
                                }
                            } else {
                                contentId = selectedLanguage!!.contentId.toString()
                            }
                            intent.putExtra("contentId", contentId?.toInt())
                            intent.putExtra("pollInterval", movie!!.pollInterval)
                            Log.d("content", "GetContentToken: " + contentId)
                            startActivityForResult(intent, RECEIVE_PLAYBACKSTATE)
                        } else {
                            Toast.makeText(
                                this@ContentDetailActivity,
                                "" + responseModel?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                } catch (e: HttpException) {
                    Toast.makeText(this@ContentDetailActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@ContentDetailActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    fun makeTextViewResizable(
        tv: TextView?, maxLine: Int, expandText: String,
        viewMore: Boolean, maxLineForTitle: Int
    ) {
        if (tv!!.tag == null) {
            tv.tag = tv.text
        }
        val vto = tv.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val obs = tv.viewTreeObserver
                obs.removeGlobalOnLayoutListener(this)
                if (maxLine == 0) {
                    val lineEndIndex = tv.layout.getLineEnd(0)
                    val text = tv.text.subSequence(0, lineEndIndex - expandText.length + 1)
                        .toString() + " " + expandText
                    tv.text = text
                    tv.movementMethod = LinkMovementMethod.getInstance()
                    tv.setText(
                        addClickablePartTextViewResizable(
                            Html.fromHtml(tv.text.toString()), tv, expandText,
                            viewMore, maxLineForTitle
                        ), TextView.BufferType.SPANNABLE
                    )
                } else if (maxLine > 0 && tv.lineCount >= maxLine) {
                    val lineEndIndex = tv.layout.getLineEnd(maxLine - 1)
                    val text = tv.text.subSequence(0, lineEndIndex - expandText.length + 1)
                        .toString() + " " + expandText
                    tv.text = text
                    tv.movementMethod = LinkMovementMethod.getInstance()
                    tv.setText(
                        addClickablePartTextViewResizable(
                            Html.fromHtml(tv.text.toString()), tv, expandText,
                            viewMore, maxLineForTitle
                        ), TextView.BufferType.SPANNABLE
                    )
                } else {
                    val lineEndIndex = tv.layout.getLineEnd(tv.layout.lineCount - 1)
                    val text = tv.text.subSequence(0, lineEndIndex).toString() + " " + expandText
                    tv.text = text
                    tv.movementMethod = LinkMovementMethod.getInstance()
                    tv.setText(
                        addClickablePartTextViewResizable(
                            Html.fromHtml(tv.text.toString()), tv, expandText,
                            viewMore, maxLineForTitle
                        ), TextView.BufferType.SPANNABLE
                    )
                }
            }
        })
    }

    private fun addClickablePartTextViewResizable(
        strSpanned: Spanned, tv: TextView?,
        spanableText: String, viewMore: Boolean, maxLineForTitle: Int
    ): SpannableStringBuilder {
        val str = strSpanned.toString()
        val ssb = SpannableStringBuilder(strSpanned)
        if (str.contains(spanableText)) {
            ssb.setSpan(object : MySpannable(false) {
                override fun onClick(widget: View) {
                    if (viewMore) {
                        tv!!.layoutParams = tv.layoutParams
                        tv.setText(tv.tag.toString(), TextView.BufferType.SPANNABLE)
                        tv.invalidate()
                        makeTextViewResizable(tv, -1, "...Less", false, maxLineForTitle)
                    } else {
                        tv!!.layoutParams = tv.layoutParams
                        tv.setText(tv.tag.toString(), TextView.BufferType.SPANNABLE)
                        tv.invalidate()
                        makeTextViewResizable(tv, maxLineForTitle, "...More", true, maxLineForTitle)
                    }
                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length, 0)
        }
        return ssb
    }

    private fun getSimilarMovieListing(movieId: Int) {
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            apiInterface = APIClient.getClient("").create(APIInterface::class.java)
            val response = apiInterface.getSimilarMovieListing(movieId, 1, 10)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            val similarMoviesList: ArrayList<MovieModel>?
                            similarMoviesList = model.content
                            //   AppConstants.all_languages = model
                            if (similarMoviesList != null && similarMoviesList.size > 0) {
                                txtTitleSimilarMovies!!.visibility = View.VISIBLE
                                recyclerSimilarMovies!!.visibility = View.VISIBLE
                                val subContentListAdapter = SubContentListAdapter(
                                    this@ContentDetailActivity,
                                    similarMoviesList
                                )
                                recyclerSimilarMovies!!.setHasFixedSize(true)
                                recyclerSimilarMovies!!.adapter = subContentListAdapter
                            }
                            getFeaturedInPlaylists(movieId)

                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ContentDetailActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@ContentDetailActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    private fun getFeaturedInPlaylists(movieId: Int) {
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getFeaturedInPlaylists(movieId, 1, 10)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            featuredPlaylists!!.addAll(responseModel.data.playlist)
                            if (featuredPlaylists.size > 0) {
                                txtFeaturedInList!!.visibility = View.VISIBLE
                                recyclerFeaturedInLists!!.visibility = View.VISIBLE
                                featuredPlaylistAdapter?.notifyDataSetChanged()
                            }
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ContentDetailActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@ContentDetailActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@ContentDetailActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    companion object {
        lateinit var customProgressDialog: CustomProgressDialog
        var AddfavoritesActive = false
        val localIpAddress: String?
            get() {
                try {
                    val en = NetworkInterface.getNetworkInterfaces()
                    while (en.hasMoreElements()) {
                        val intf = en.nextElement()
                        val enumIpAddr = intf.inetAddresses
                        while (enumIpAddr.hasMoreElements()) {
                            val inetAddress = enumIpAddr.nextElement()
                            if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                                return inetAddress.getHostAddress()
                            }
                        }
                    }
                } catch (ex: SocketException) {
                    ex.printStackTrace()
                }
                return null
            }
    }

    override fun onLanguageSelected(language: LanguageModel?) {
        if (selectedLanguage != null) {
            var trailerPath = ""
            if (!TextUtils.isEmpty(selectedLanguage!!.trailerpath)) {
                trailerPath = selectedLanguage!!.trailerpath
            }
            if (!TextUtils.isEmpty(trailerPath) && trailerPath.contains("www.youtube.com")) {
                val intent = Intent(
                    this@ContentDetailActivity,
                    YoutubeTrailerPlaybackActivity::class.java
                )
                intent.putExtra("TrailerUrl", trailerPath)
                startActivity(intent)
            } else {
                //cdn link - open in exoplayer
                val intent = Intent(this@ContentDetailActivity, VideoPlayerActivity::class.java)
                intent.putExtra("TrailerUrl", trailerPath)
                intent.putExtra("movieName", movie!!.contentname)
                intent.putExtra("story", movie!!.synopsis)
                intent.putExtra("contentId", selectedLanguage!!.contentId)
                startActivity(intent)
            }
        }
    }

    override fun onEpisodeClicked(episode: TvSeriesEpisode?) {
        selectedEpisode = episode
        if (AppConstants.isUserLoggedIn) {
            if (movie!!.ppv == "Y" && movie!!.inr != "0" && movie!!.inr != "-1") {
                CheckIfUserPpvSubscribed()
            } else {
                if (TextUtils.isEmpty(selectedEpisode!!.videopath)) {
                    GetContentToken()
                } else {
                    val intent = Intent(this@ContentDetailActivity, VideoPlayerActivity::class.java)
                    intent.putExtra("movieUrl", selectedEpisode!!.videopath)
                    intent.putExtra("WatchDuration", selectedEpisode!!.watchDuration)
                    intent.putExtra(
                        "contentId",
                        Integer.valueOf(selectedEpisode!!.contentEpisodeID)
                    )
                    intent.putExtra("pollInterval", movie!!.pollInterval)
                    startActivityForResult(intent, RECEIVE_PLAYBACKSTATE)

//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(selectedEpisode.getVideopath()));
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    if (intent.resolveActivity(this.getPackageManager()) != null) {
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(this, "no na", Toast.LENGTH_LONG).show();
//                    }
                }
            }
        } else {
            val intent1 = Intent(this@ContentDetailActivity, LoginActivity::class.java)
            intent1.putExtra("reload", "false")
            startActivity(intent1)
        }
    }
}
