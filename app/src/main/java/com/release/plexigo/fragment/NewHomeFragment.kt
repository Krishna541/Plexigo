package com.release.plexigo.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonMappingException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.AppConstants.HOME_PAGE_LIST_VIEW_TYPE_AREA
import com.release.plexigo.Constants.AppConstants.HOME_PAGE_LIST_VIEW_TYPE_CHANNEL
import com.release.plexigo.Constants.AppConstants.HOME_PAGE_LIST_VIEW_TYPE_CONTENT
import com.release.plexigo.Constants.AppConstants.HOME_PAGE_LIST_VIEW_TYPE_MOOD_LIST
import com.release.plexigo.Constants.AppConstants.HOME_PAGE_LIST_VIEW_TYPE_PLAYLIST
import com.release.plexigo.Constants.AppConstants.HOME_PAGE_LIST_VIEW_TYPE_TOP_USER
import com.release.plexigo.Constants.AppConstants.HOME_TAB_ALL_MOVIES
import com.release.plexigo.Constants.AppConstants.HOME_TAB_ALL_SERIES
import com.release.plexigo.Constants.AppConstants.HOME_TAB_IN_THEATRE
import com.release.plexigo.Constants.AppConstants.HOME_TAB_PPV
import com.release.plexigo.Constants.AppConstants.resetFilters
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.Constants.WsConstants.getListForEveryMood
import com.release.plexigo.R
import com.release.plexigo.activity.NewHomeActivity
import com.release.plexigo.adapter.HomeBannerPagerAdapter
import com.release.plexigo.adapter.HomeFragmentContentAdapter
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_playlist_content_listing.*
import kotlinx.android.synthetic.main.fragment_home_new.*
import kotlinx.android.synthetic.main.single_review_listview_layout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import pl.pzienowicz.autoscrollviewpager.AutoScrollViewPager
import retrofit2.HttpException
import java.io.IOException

class NewHomeFragment : Fragment(), View.OnClickListener {

    var nestedScroll: NestedScrollView? = null
    var preferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    private var fcmToken = ""
    private val homePageContentList: ArrayList<HomePageListingModel> =
        ArrayList<HomePageListingModel>()
    var queue: RequestQueue? = null
    private val picksForYouBanner: ArrayList<BannerModel>? = ArrayList<BannerModel>()
    private val whatsNewBanner: ArrayList<BannerModel>? = ArrayList<BannerModel>()
    var picksForYouAdapter: HomeBannerPagerAdapter? = null
    var whatsNewBannerAdapter: HomeBannerPagerAdapter? = null
    private var isShowPopularChannel = 1
    private var showPopularChannelPosition = 1
    private var isShowOffersPopup = 1
    var curatedText: String? = null
    var curatedImage: String? = null
    var curatedLinkText: String? = null
    var curatedCategoryId = 0
    private var topUserListModel: ArrayList<TopUserListModel>? = null
    lateinit var apiInterface : APIInterface
    var homeFragmentContentAdapter : HomeFragmentContentAdapter ?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFcmToken()

        bannerPicksForYou.clipToPadding = false
        bannerPicksForYou.pageMargin = 30
        bannerPicksForYou.stopAutoScroll()
        bannerPicksForYou.setPadding(50, 0, 50, 0)
        bannerWhatsNew.clipToPadding = false
        bannerWhatsNew.pageMargin = 30
        bannerWhatsNew.setPadding(50, 0, 50, 0)
        recyclerViewHome.setHasFixedSize(true)
        nestedScroll = view.findViewById(R.id.nestedScroll)
        preferences = PreferenceManager.getDefaultSharedPreferences(requireActivity())
        txtOffersNote.setOnClickListener(this)
        queue = Volley.newRequestQueue(activity)

        initData()
        btnAllMovies.setOnClickListener(this)
        btnInTheatre.setOnClickListener(this)
        btnPpv.setOnClickListener(this)
        btnAllSeries.setOnClickListener(this)
        checkBannerSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                bannerPicksForYou.stopAutoScroll()
                bannerWhatsNew.visibility = View.GONE
                bannerPicksForYou.visibility = View.VISIBLE
                txtBannerTitle.setText(R.string.pick_for_you)
                checkBannerSwitch.setText(R.string.whats_new)
                bannerPicksForYou.currentItem = 0
                bannerPicksForYou.startAutoScroll(5000)
            } else {
                bannerWhatsNew.stopAutoScroll()
                bannerWhatsNew.visibility = View.VISIBLE
                bannerPicksForYou.visibility = View.GONE
                txtBannerTitle.setText(R.string.whats_new)
                checkBannerSwitch.setText(R.string.pick_for_you)
                bannerWhatsNew.currentItem = 0
                bannerWhatsNew.startAutoScroll(5000)
            }
        })
        if (loadFCMToken() == null) {
            uploadFCMToken(fcmToken)
        }
    }

    // FCM Token Preference
    fun saveFCMToken(key: String?, value: String?) {
        val sp = activity?.let {
            PreferenceManager
                .getDefaultSharedPreferences(it)
        }
        val edit = sp?.edit()
        edit?.putString(key, value)
        edit?.commit()
    }

    fun loadFCMToken(): String? {
        val sp = activity?.let {
            PreferenceManager
                .getDefaultSharedPreferences(it)
        }
        return sp?.getString("fcm_token", null)
    }

    fun getFcmToken(): String {
        FirebaseMessaging.getInstance().token
            .addOnFailureListener { e ->
                Log.d(
                    "Firebase Token error:",
                    e.message.toString()
                )
            }.addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.d("TAG", "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }
                fcmToken = task.result
                Log.d("FirebaseApp Token: ", fcmToken)
            })
        return fcmToken
    }

    val deviceID: String
        get() = Settings.Secure.getString(
            requireActivity().contentResolver,
            Settings.Secure.ANDROID_ID
        )

    private fun uploadFCMToken(fcmToken: String){
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request  = FcmTokenRequest(Integer.valueOf(if (AppConstants.UserId == null) "0" else AppConstants.UserId),deviceID,fcmToken)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.uploadFcmToken(request)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            if(responseModel.status.equals("success" , ignoreCase = true)){
                                saveFCMToken("fcm_token", fcmToken)
                            }
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun initData() {
        homePageContentList.clear()
        whatsNewMovies()
    }

    private fun callBannerApi(){
        showLoader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request  = QuickPickDataRequest(Integer.valueOf(if (AppConstants.UserId == null) "0" else AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getBannerApi(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val dataModel = responseModel.data
                            picksForYouBanner!!.clear()
                            picksForYouBanner.addAll(dataModel.content)
                            if (picksForYouBanner != null && picksForYouBanner.size > 0) {
                                picksForYouAdapter = HomeBannerPagerAdapter(
                                    childFragmentManager,
                                    picksForYouBanner,
                                    false
                                )
                                bannerPicksForYou!!.adapter = picksForYouAdapter
                                //                                    bannerPicksForYou.setVisibility(View.VISIBLE);
                                bannerPicksForYou!!.setInterval(5000L)
                                //                                    bannerPicksForYou.startAutoScroll(5000);
                            } else {
                                bannerPicksForYou!!.visibility = View.GONE
                            }
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun whatsNewMovies(){
        showLoader()
        apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        val userId = if (AppConstants.UserId == null) "0" else AppConstants.UserId
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getWhatsNewMovies(userId!!)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val dataModel = responseModel.data
                            whatsNewBanner!!.clear()
                            whatsNewBanner.addAll(dataModel.content)
                            if (whatsNewBanner.size > 0) {
                                whatsNewBannerAdapter = HomeBannerPagerAdapter(
                                    childFragmentManager, whatsNewBanner, true
                                )
                                bannerWhatsNew!!.adapter = whatsNewBannerAdapter
                                bannerWhatsNew!!.setInterval(5000L)
                                bannerWhatsNew!!.startAutoScroll(5000)
                            } else {
                                bannerWhatsNew!!.visibility = View.GONE
                            }
                            homePageListing()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }

    private fun homePageListing(){
        showLoader()
        apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        var userId : Int
        if (!TextUtils.isEmpty(AppConstants.UserId)) {
            userId = Integer.valueOf(AppConstants.UserId)
        } else {
            userId = 0
        }
        val request = HomePageListingRequest("","",userId,0)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getHomePageListing(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            isShowPopularChannel = modelObj.showPopularChannel
                            showPopularChannelPosition =
                                modelObj.showpopularchannelposition
                            curatedText = modelObj.curatedText
                            curatedCategoryId = modelObj.curatedCategoryId
                            curatedImage = modelObj.curatedImage
                            curatedLinkText = modelObj.curatedLinkText
                            isShowOffersPopup = modelObj.showOffersPopup
                            if (modelObj.categories.isNotEmpty()) {
                                //remove empty sections
                                for (k in 0 until modelObj.categories.size) {
                                    if (modelObj.categories.get(k).content.size === 0) {
                                        modelObj.categories.removeAt(k)
                                        break
                                    }
                                }
                                for (model in modelObj.categories) {
                                    if (model.categoryId === 99) {
                                        homePageContentList.add(
                                            HomePageListingModel(
                                                HOME_PAGE_LIST_VIEW_TYPE_PLAYLIST,
                                                model
                                            )
                                        )
                                    } else {
                                        homePageContentList.add(
                                            HomePageListingModel(
                                                HOME_PAGE_LIST_VIEW_TYPE_CONTENT,
                                                model
                                            )
                                        )
                                    }
                                }
                            }
                        }else {
                            hideLoader()
                            Toast.makeText(
                                activity,
                                "" + responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    getListForEveryMood()
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun topUserList(){
        showLoader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getTopUserList()
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.topuserslist != null && modelObj.topuserslist.size > 0
                            ) {
                                topUserListModel = modelObj.topuserslist
                                getTopUserListContent(
                                    modelObj.topuserslist[0].playlistId
                                )
                            }
                        }else {
                            Toast.makeText(
                                activity,
                                "" + responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }


    private fun getTopUserListContent(playlistId: Int) {
        showLoader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val userid = if (AppConstants.UserId != null) AppConstants.UserId else "0"
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getPlayListContent(playlistId, userid!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.playlistContent.isNotEmpty()
                            ) {
                                if (AppConstants.isUserLoggedIn) {
                                    homePageContentList.add(
                                        1,
                                        HomePageListingModel(
                                            HOME_PAGE_LIST_VIEW_TYPE_TOP_USER,
                                            modelObj
                                        )
                                    )
                                } else {
                                    homePageContentList.add(
                                        0,
                                        HomePageListingModel(
                                            HOME_PAGE_LIST_VIEW_TYPE_TOP_USER,
                                            modelObj
                                        )
                                    )
                                }
                                channelsApi()
                            }
                        } else {
                            channelsApi()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(
                        requireContext(),
                        "${e.message}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } catch (e: Throwable) {
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                    channelsApi()

                }
            }
        }
    }

    private fun popularInAreaList(){
        if (AppConstants.isUserLoggedIn) {
            showLoader()
            apiInterface = APIClient.getClient("").create(APIInterface::class.java)
            val userid = if (AppConstants.UserId != null) AppConstants.UserId else "0"
            val request = PopularInAreaListRequest(userid!!.toInt(),1,10)
            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getPopularInYourArea(request)
                withContext(Dispatchers.Main) {
                    try {
                        hideLoader()
                        if (response.isSuccessful) {
                            val responseModel = response.body()
                            if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                val modelObj =
                                    responseModel.data
                                if (modelObj.content.size > 0
                                ) {
                                    homePageContentList.add(
                                        0,
                                        HomePageListingModel(
                                            HOME_PAGE_LIST_VIEW_TYPE_AREA,
                                            modelObj
                                        )
                                    )
                                }
                                topUserList()
                            } else {
                                topUserList()
                            }
                        }
                    } catch (e: HttpException) {
                        Toast.makeText(
                            requireContext(),
                            "${e.message}",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } catch (e: Throwable) {
                        if (e is TimeoutError) {
                            Toast.makeText(
                                requireContext(),
                                R.string.timeout_message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        if (e.cause is IOException) {
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.internet_not_available),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        Toast.makeText(
                            requireContext(),
                            "" + e.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }else {
            topUserList()
        }
    }


    private fun getListForEveryMood(){
        showLoader()
        apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        val request = PopularInAreaListRequest(0,1,10)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getListForEveryMood(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            if (model.playlist != null && model.playlist.size > 0) {
                                homePageContentList.add(
                                    0,
                                    HomePageListingModel(
                                        HOME_PAGE_LIST_VIEW_TYPE_MOOD_LIST,
                                        model
                                    )
                                )
                                popularInAreaList()
                            }
                        }else {
                            popularInAreaList()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    if (e is TimeoutError) {
                        Toast.makeText(
                            requireContext(),
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        requireContext(),
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }

    private fun channelsApi(){
        if (isShowPopularChannel == 1) {
            showLoader()
            apiInterface = APIClient.getClient("1.2").create(APIInterface::class.java)
            val userid =
                if (AppConstants.UserId != null) AppConstants.UserId!!.toInt() else 0
            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getChannelApi(userid)
                withContext(Dispatchers.Main) {
                    try {
                        hideLoader()
                        if (response.isSuccessful) {
                            val responseModel = response.body()
                            if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                val modelObj = responseModel.data
                                if (modelObj.channels.isNotEmpty()
                                ) {
                                    homePageContentList.add(
                                        showPopularChannelPosition,
                                        HomePageListingModel(
                                            HOME_PAGE_LIST_VIEW_TYPE_CHANNEL,
                                            modelObj
                                        )
                                    )
                                    val adapter = HomeFragmentContentAdapter(
                                        requireActivity(),
                                        homePageContentList,
                                        topUserListModel!!,
                                        curatedText!!,
                                        curatedImage!!,
                                        curatedLinkText!!,
                                        curatedCategoryId
                                    )
                                    recyclerViewHome!!.adapter = adapter
                                    callBannerApi()
                                }
                            }else {
                                val adapter = HomeFragmentContentAdapter(
                                    requireActivity(),
                                    homePageContentList,
                                    topUserListModel!!,
                                    curatedText!!,
                                    curatedImage!!,
                                    curatedLinkText!!,
                                    curatedCategoryId
                                )
                                recyclerViewHome!!.adapter = adapter
                                callBannerApi()
                            }
                        }
                    } catch (e: HttpException) {
                        Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    } catch (e: Throwable) {
                        if (e is TimeoutError) {
                            Toast.makeText(
                                requireContext(),
                                R.string.timeout_message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        if (e.cause is IOException) {
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.internet_not_available),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        Toast.makeText(
                            requireContext(),
                            "" + e.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }

        }else{
            val adapter = HomeFragmentContentAdapter(
                requireActivity(),
                homePageContentList,
                topUserListModel!!,
                curatedText!!,
                curatedImage!!,
                curatedLinkText!!,
                curatedCategoryId
            )
            recyclerViewHome!!.adapter = adapter
            callBannerApi()
        }

        if (isShowOffersPopup == 1) {
            if (preferences!!.getBoolean("showOffersDialog", true)) {
                /*                new OffersDialogFragment().show(getActivity().getSupportFragmentManager(), "");*/
                txtOffersNote!!.visibility = View.VISIBLE
                editor = preferences!!.edit()
                editor?.putBoolean("showOffersDialog", false)?.apply()
            }
        }

    }

    fun showLoader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = requireActivity().supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.setCancelable(false)
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnAllMovies -> {
                (activity as NewHomeActivity?)!!.replaceFragment(
                    HomeTabFragment.newInstance(
                        HOME_TAB_ALL_MOVIES
                    ), true
                )
                resetFilters()
            }
            R.id.btnInTheatre -> {
                (activity as NewHomeActivity?)!!.replaceFragment(
                    HomeTabFragment.newInstance(
                        HOME_TAB_IN_THEATRE
                    ), true
                )
                resetFilters()
            }
            R.id.btnPpv -> {
                (activity as NewHomeActivity?)!!.replaceFragment(
                    HomeTabFragment.newInstance(
                        HOME_TAB_PPV
                    ), true
                )
                resetFilters()
            }
            R.id.btnAllSeries -> {
                (activity as NewHomeActivity?)!!.replaceFragment(
                    HomeTabFragment.newInstance(
                        HOME_TAB_ALL_SERIES
                    ), true
                )
                resetFilters()
            }
            R.id.txtOffersNote -> {}
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as NewHomeActivity?)!!.showToolbar()
    }

    override fun onPause() {
        super.onPause()
        txtOffersNote!!.visibility = View.GONE
        (activity as NewHomeActivity?)!!.hideToolbar()
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
        fun newInstance(): NewHomeFragment {
            val args = Bundle()
            val fragment = NewHomeFragment()
            fragment.arguments = args
            return fragment
        }
    }
}