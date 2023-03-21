package com.release.plexigo.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.android.volley.*
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.activity.*
import com.release.plexigo.adapter.*
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_playlist_listing.*
import kotlinx.android.synthetic.main.activity_user_playlist_listing.*
import kotlinx.android.synthetic.main.fragment_home_profile.*
import kotlinx.android.synthetic.main.fragment_home_profile.recyclerFollowedUsers
import kotlinx.android.synthetic.main.fragment_movie_listing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class HomeProfileFragment() : Fragment(), View.OnClickListener,
    OfferSliderAdapter.OnOfferClick, FavouritePeopleAdapter.OnPersonLongClick,
    SubscriptionPlansAdapter.OnPlanSelected {
    private val offerList: ArrayList<OfferModel> = ArrayList<OfferModel>()
    var offersAdapter: OfferSliderAdapter? = null
    private val watchedMovieList: ArrayList<MovieModel> = ArrayList<MovieModel>()
    private val followedPlaylists: ArrayList<UserPlaylistModel> = ArrayList<UserPlaylistModel>()
    lateinit var followedPlaylistAdapter: PlaylistAdapter
    private val myPlaylists: ArrayList<UserPlaylistModel> = ArrayList<UserPlaylistModel>()
    lateinit var myPlaylistAdapter: MyPlaylistAdapter
    private val followUserList: ArrayList<TopUserListModel> = ArrayList<TopUserListModel>()
    lateinit var followedUserAdapter: FollowedUserAdapter
    private val topGenresList: ArrayList<TopGenreModel> = ArrayList<TopGenreModel>()
    var topGenreAdapter: TopGenreAdapter = TopGenreAdapter(topGenresList)
    private val favouritePeople: ArrayList<ActorModel> = ArrayList<ActorModel>()
    lateinit var favouritePeopleAdapter: FavouritePeopleAdapter
    var layoutKnowBetter: ConstraintLayout? = null
    var preferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    private var selectedOffer: OfferModel? = null
    private var plan: SubscriptionPlan? = null
    private val requestCode = 1100
    private var bottomSheet: BottomSheetBehavior<View>? = null
    lateinit var apiInterface : APIInterface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        initView(view)
        initData()
    }

    private fun initView(view: View) {
        followedPlaylistAdapter = PlaylistAdapter(requireActivity(),followedPlaylists, true)
        recyclerFollowedList.adapter = followedPlaylistAdapter
        followedPlaylistAdapter.setOnPlayListItemSelectedListener(object : PlaylistAdapter.OnPlayListItemSelectedListener {
            override fun onPlayListItemSelected(playlist: UserPlaylistModel?) {
                    val intent = Intent(activity, PlaylistContentListingActivity::class.java)
                    intent.putExtra("playlistId", playlist?.playlistId)
                    intent.putExtra("playlistTitle", playlist?.title)
                    startActivity(intent)
        }})

        myPlaylistAdapter = MyPlaylistAdapter(myPlaylists)
        recyclerYourPlaylists.adapter = myPlaylistAdapter
        myPlaylistAdapter.setOnPlayListItemSelectedListener(object : MyPlaylistAdapter.OnPlayListItemSelectedListener {
            override fun onPlayListItemSelected(playlist: UserPlaylistModel?) {
                    val intent = Intent(activity, PlaylistContentListingActivity::class.java)
                    intent.putExtra("playlistId", playlist?.playlistId)
                    intent.putExtra("playlistTitle", playlist?.title)
                    startActivity(intent)
            }
        })

        txtMoreYourList.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, PlaylistListingActivity::class.java)
            intent.putExtra("contentId", 1)
            requireActivity().startActivity(intent)
        })
        txtMoreFollowedPlaylist.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, PlaylistListingActivity::class.java)
            intent.putExtra("contentId", 2)
            requireActivity().startActivity(intent)
        })

        followedUserAdapter = FollowedUserAdapter(requireContext(),followUserList)
        favouritePeopleAdapter = FavouritePeopleAdapter(requireContext(),favouritePeople)
        recyclerFollowedUsers.adapter = followedUserAdapter
        recyclerTopGenres.adapter = topGenreAdapter
        recyclerFavouritePeople.adapter = favouritePeopleAdapter
        favouritePeopleAdapter.setOnPersonLongClickListener(this)
        layoutKnowBetter = view.findViewById(R.id.layoutKnowBetter)
        btnLetsDoIt.setOnClickListener(this)
        txtSettings.setOnClickListener(this)
        nestedScroll.isNestedScrollingEnabled = false
        sliderOffers.clipToPadding = false
        sliderOffers.pageMargin = 30
        sliderOffers.setPadding(50, 0, 50, 0)
        bottomSheet = BottomSheetBehavior.from(view.findViewById(R.id.btmSheetSubscriptionPlans))
        bottomSheet!!.peekHeight = 0
    }

    private fun initData() {
        preferences = PreferenceManager.getDefaultSharedPreferences(requireActivity())
        txtName!!.text = preferences?.getString("username", null)
    }

    override fun onResume() {
        super.onResume()
        userProfileDetails()
    }

    override fun onClick(v: View) {
        var intent: Intent
        when (v.id) {
            R.id.txtSettings -> (activity as NewHomeActivity?)?.replaceFragment(
                ProfileSettingsFragment.newInstance(),
                true
            )
            R.id.btnLetsDoIt -> navigateToOnBoarding()
        }
    }

    private fun userProfileDetails(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getUserProfile(AppConstants.UserId!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            if (TextUtils.isEmpty(
                                    responseModel.data.userprofile[0].imagePath
                                )
                            ) {
                                GlideApp
                                    .with(requireContext())
                                    .load("https://plexigostatic1.s3.ap-south-1.amazonaws.com/DefaultPosters/Defaultuser31X31.png")
                                    .placeholder(R.drawable.plexigo_new_transperent_logo)
                                    .circleCrop()
                                    .into(imgUser)

                            } else {
                                GlideApp
                                    .with(requireContext())
                                    .load(responseModel.data.userprofile[0].imagePath)
                                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                                    .skipMemoryCache(true)
                                    .circleCrop()
                                    .placeholder(R.drawable.plexigo_new_transperent_logo)
                                    .into(imgUser)
                            }
                            AppConstants.preferredGenre = null
                            AppConstants.preferredGenre = responseModel.data.userprofile[0].preferenceGenre

                            AppConstants.preferredLanguages = null
                            AppConstants.preferredLanguages = responseModel.data.userprofile[0].preferenceLanguage
                            callOffersApi()
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

    private fun callOffersApi(){
        showLoader()
        var userId : Int
        if (!TextUtils.isEmpty(AppConstants.UserId)) {
            userId =  Integer.valueOf(AppConstants.UserId)
        } else {
            userId = 0
        }
        val request = PopularInAreaListRequest(userId , 1 ,10)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getBundleListing(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val dataModel = responseModel.data
                            if (dataModel.bundles != null && dataModel.bundles.size > 0
                            ) {
                                sliderOffers!!.adapter = null
                                offerList.clear()
                                offerList.addAll(dataModel.bundles)
                                offersAdapter = OfferSliderAdapter(
                                    requireContext(),
                                    offerList,
                                    this@HomeProfileFragment
                                )
                                sliderOffers!!.adapter = offersAdapter
                                pagerIndicator!!.setViewPager((sliderOffers)!!)
                                sliderOffers!!.setInterval(5000L)
                                sliderOffers!!.startAutoScroll(5000)
                                pagerIndicator!!.setViewPager((sliderOffers)!!)
                            } else {
                                sliderOffers!!.visibility = View.GONE
                            }
                            callWatchlistApi()
                        }else {
                            hideLoader()
                            callWatchlistApi()
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

    private fun callWatchlistApi(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getWatchHistory(AppConstants.UserId!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            if (model.watchContent != null && model.watchContent
                                    .size > 0
                            ) {
                                watchedMovieList.clear()
                                watchedMovieList.addAll(model.watchContent)
                                txtYourWatchlistTitle!!.visibility = View.VISIBLE
                                recyclerWatchedMovieList!!.visibility = View.VISIBLE
                                val watchedMovieListAdapter = SubContentListAdapter(
                                    requireActivity(), watchedMovieList
                                )
                                recyclerWatchedMovieList!!.setHasFixedSize(true)
                                recyclerWatchedMovieList!!.adapter = watchedMovieListAdapter
                            } else {
                                recyclerWatchedMovieList!!.visibility = View.GONE
                                txtYourWatchlistTitle!!.visibility = View.GONE
                                Log.e("profileApi", "watch history fail")
                            }
                            callFollowedPlaylistApi()
                        }else {
                            recyclerWatchedMovieList!!.visibility = View.GONE
                            txtYourWatchlistTitle!!.visibility = View.GONE
                            callFollowedPlaylistApi()
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

    private fun callFollowedPlaylistApi(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.callFollowedPlaylistApi((if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt(),1,10)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            followedPlaylists.clear()
                            followedPlaylists.addAll(responseModel.data.playlist)
                            if (responseModel.data.playlist.size > 5) {
                                txtMoreFollowedPlaylist!!.visibility = View.VISIBLE
                            }
                            txtFollowedListTitle!!.visibility = View.VISIBLE
                            recyclerFollowedList!!.visibility = View.VISIBLE
                            followedPlaylistAdapter.notifyDataSetChanged()
                        }else {
                            followedPlaylists.clear()
                            followedPlaylistAdapter.notifyDataSetChanged()
                            recyclerFollowedList!!.visibility = View.GONE
                            txtFollowedListTitle!!.visibility = View.GONE
                            Log.e("profileApi", "followed playlist fail")
                        }
                        callMyPlayList()
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireActivity(), "${e.message}", Toast.LENGTH_SHORT)
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

    private fun callMyPlayList(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getUserPlayList(Integer.valueOf(AppConstants.UserId))
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            myPlaylists.clear()
                            myPlaylists.addAll(responseModel.data.playlist)
                            myPlaylistAdapter.notifyDataSetChanged()
                            recyclerYourPlaylists!!.visibility = View.VISIBLE
                            txtYourListTitle!!.visibility = View.VISIBLE
                            viewYourPlaylist!!.visibility = View.VISIBLE
                            if (responseModel.data.playlist.size > 5) {
                                txtMoreYourList!!.visibility = View.VISIBLE
                            }
                            followedUserList()
                        }else {
                            recyclerYourPlaylists!!.visibility = View.GONE
                            txtMoreYourList!!.visibility = View.GONE
                            viewYourPlaylist!!.visibility = View.GONE
                            txtYourListTitle!!.visibility = View.GONE
                            Log.e("profileApi", "my playlist fail")
                            followedUserList()
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

    private  fun followedUserList(){
        showLoader()
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getFollowedUserList((if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj: TopUserListResponseDataModel =
                                responseModel.data
                            if (modelObj.topuserslist != null && modelObj.topuserslist
                                    .size > 0
                            ) {
                                hideLoader()
                                followUserList.clear()
                                followUserList.addAll(modelObj.topuserslist)
                                txtYouAreFollowing!!.visibility = View.VISIBLE
                                followedUserAdapter.notifyDataSetChanged()
                                topGenres()
                            }
                        }else {
                            hideLoader()
                            txtYouAreFollowing!!.visibility = View.GONE
                            followUserList.clear()
                            followedUserAdapter.notifyDataSetChanged()
                            Log.e("profileApi", "followed user fail")
                            topGenres()
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

    private fun topGenres(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getTopGenre((if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.topGenre != null && modelObj.topGenre
                                    .size > 0
                            ) {
                                hideLoader()
                                topGenresList.clear()
                                topGenresList.addAll(modelObj.topGenre)
                                txtTopGenres!!.visibility = View.VISIBLE
                                txtTopGenresNote!!.visibility = View.VISIBLE
                                topGenreAdapter.notifyDataSetChanged()
                                getFavouritePeople()
                            }
                        }else {
                            hideLoader()
                            txtTopGenres!!.visibility = View.GONE
                            txtTopGenresNote!!.visibility = View.GONE
                            topGenresList.clear()
                            topGenreAdapter.notifyDataSetChanged()
                            Log.e("profileApi", "top genre fail")
                            getFavouritePeople()
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

    private fun getFavouritePeople(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getFavouritePeople((if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model: ActorListDataModel = responseModel.data
                            if (model.actors != null && model.actors.size > 0) {
                                txtFavouritePeople!!.visibility = View.VISIBLE
                                txtFavouritePeopleNote!!.visibility = View.VISIBLE
                                favouritePeople.clear()
                                favouritePeople.addAll(model.actors)
                                favouritePeopleAdapter.notifyDataSetChanged()
                            }
                        }else {
                            hideLoader()
                            txtFavouritePeople!!.visibility = View.GONE
                            txtFavouritePeopleNote!!.visibility = View.GONE
                            favouritePeople.clear()
                            favouritePeopleAdapter.notifyDataSetChanged()
                            Log.e("profileApi", "fav people fail")
                        }
                        checkOnBoardingCompleted()
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


    fun showLoader() {
        if (customProgressDialog == null) customProgressDialog = CustomProgressDialog.newInstance()
        val ft = requireActivity().supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.isCancelable = false
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    override fun onOfferClicked(offer: OfferModel?) {
        val intent = Intent(activity, OfferActivity::class.java)
        intent.putExtra("bundleId", offer!!.bundleId)
        startActivity(intent)
//        if (offer?.hasOTT === 0 && offer?.issubscribed === 0) {
//            selectedOffer = offer
//            val subscriptionPlansAdapter =
//                SubscriptionPlansAdapter(selectedOffer!!.subscriptionplans, this)
//            recyclerSubscriptionPlans!!.adapter = subscriptionPlansAdapter
//            bottomSheet!!.setState(BottomSheetBehavior.STATE_EXPANDED)
//        } else if (offer?.hasOTT === 0 && offer?.issubscribed === 1) {
//            (activity as NewHomeActivity?)?.addFragment(
//                CouponCodesFragment.newInstance(offer.bundleId),
//                true
//            )
//        } else if (offer?.hasOTT === 1 && offer?.issubscribed === 0) {
//            (activity as NewHomeActivity?)?.addFragment(
//                CouponCodesFragment.newInstance(offer.bundleId),
//                true
//            )
//        }

    }

    override fun onPersonLongClicked(actorModel: ActorModel?) {
        showDeleteFromFavouriteDialog(actorModel!!)
    }

    private fun showDeleteFromFavouriteDialog(actorModel: ActorModel) {
        val inflater =
            requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.dialog_create_playlist, null)
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
        txtTitle.text = "Remove " + actorModel.name.toString() + " from favourites?"
        txtTitle.textSize = 16f
        edtPlayListName.visibility = View.GONE
        btnSave.text = "Ok"
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            removeFromFavouritesList(actorModel)
            pwindo.dismiss()
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    private fun removeFromFavouritesList(actorModel: ActorModel){
        showLoader()
        val request = RemoveFromFavouriteListRequest(actorModel.actorId , (if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt() )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.removeFromFavouritesList(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(activity, "" + responseModel.data.message, Toast.LENGTH_SHORT)
                                .show()
                            getFavouritePeople()
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


    override fun onPlanSelected(plan: SubscriptionPlan?) {
        this.plan = plan
        checkIfOfferSubscribed(plan!!)
        bottomSheet!!.state = BottomSheetBehavior.STATE_COLLAPSED
    }


    private  fun checkIfOfferSubscribed(plan: SubscriptionPlan){
        showLoader()
        val request = CheckIfOfferSubscribed(AppConstants.UserId!!.toInt(),plan.subscriptoinPlanId)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.checkIfOfferSubscribed(WsConstants.CheckSVODExpiry,request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.validationStatus == "Valid") { //already paid
                            callOffersApi()
                        } else if (responseModel?.validationStatus == "Expired") { //Plan Expired
                            openSvodPopupLayout(plan)
                        } else if (responseModel?.validationStatus == "Not Purchased") { //Plan Expired
                            openSvodPopupLayout(plan)
                        } else {
                            Toast.makeText(
                                activity,
                                "Validation Status " + responseModel?.validationStatus,
                                Toast.LENGTH_SHORT
                            ).show()
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

    fun openSvodPopupLayout(plan: SubscriptionPlan) {
        val inflater =
            requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.dialog_payment_subscription, null)
        val pwindo = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val imgPlan = layout.findViewById<ImageView>(R.id.imgPlan)
        val skip = layout.findViewById<Button>(R.id.skip)
        val btnCCAvenue = layout.findViewById<Button>(R.id.btnCCAvenue)
        val txtPlanName = layout.findViewById<TextView>(R.id.txtPlanName)
        val txtPlanPrice = layout.findViewById<TextView>(R.id.txtPlanPrice)
        txtPlanPrice.text = "Offer " + "\u20B9 " + plan.inr + "/- " + plan.plan
        txtPlanName.setText(plan.subscriptionPlan)
        GlideApp
            .with(requireContext())
            .load(selectedOffer?.imagewide)
            .transform(RoundedCorners(12))
            .placeholder(R.drawable.plexigo_new_transperent_logo)
            .into(imgUserProfile)
        skip.setOnClickListener { pwindo.dismiss() }
        btnCCAvenue.setOnClickListener {
            pwindo.dismiss()
            val ip = Intent(activity, WebPaymentActivity::class.java)
            ip.putExtra("userid", AppConstants.UserId)
            ip.putExtra("subscriptionId", plan.subscriptoinPlanId)
            ip.putExtra("plan", plan.plan)
            ip.putExtra("isSvodPurchase", true)
            ip.putExtra("currency", "INR")
            ip.putExtra("amount", plan.inr)
            startActivityForResult(ip, requestCode)
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (this.requestCode == requestCode) {
            if (resultCode == 200) { //success
                Toast.makeText(activity, "Payment Success!", Toast.LENGTH_SHORT).show()
                //                callOffersApi();
            } else if (resultCode == 400) { //failure
                Toast.makeText(activity, "Transaction failed! Please try again", Toast.LENGTH_SHORT)
                    .show()
            } else if (resultCode == 413) { // aborted
                Toast.makeText(activity, "Transaction cancelled !", Toast.LENGTH_SHORT).show()
            } else if (resultCode == 11) { //back pressed from payment page by user
                Toast.makeText(activity, "Transaction cancelled !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkOnBoardingCompleted(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getOnBoardingPollComplete(AppConstants.UserId!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            val onBoardingComplete = responseModel.data.onboardingComplete
                            for (i in onBoardingComplete.indices) {
                                if (onBoardingComplete[i].onboardingComplete.equals("no",ignoreCase = true)
                                ) {
                                    layoutKnowBetter!!.visibility = View.VISIBLE
                                } else {
                                    layoutKnowBetter!!.visibility = View.GONE
                                }
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

    fun navigateToOnBoarding() {
        val intent = Intent(activity, OnBoardingActivity::class.java)
        startActivity(intent)
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
        fun newInstance(): HomeProfileFragment {
            val args = Bundle()
            val fragment = HomeProfileFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
