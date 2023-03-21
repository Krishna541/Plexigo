package com.release.plexigo.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.TimeoutError
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.SearchContentListAdapter
import com.release.plexigo.models.FilteredContentRequest
import com.release.plexigo.models.MovieModel
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.fragment_movie_listing.*
import kotlinx.android.synthetic.main.fragment_movie_listing.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MovieListingFragment  //    private OnFragmentInteractionListener mListener;
    : Fragment() {
    var movieList: ArrayList<MovieModel>? = null
    private var permalink: String? = null
    var PageCount = 1
    var Limit = 20
    var CurrentPageCount = 1
    var TotalPageCount = 1
    var CategoryId = 101
    var contentTypeId = 0
    var endOfList = false
    var isLoading = false
    var isFilterContent = false
    var isLibraryApiCalling = false
    var IsWatchHistory = false
    private var showContentByChannel = false
    private var channelId = 0
    private var channelCategoryId = 0
    var adapter: SearchContentListAdapter? = null
    private var channelType: String? = null
    lateinit var apiInterface : APIInterface
    var progressbar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            permalink = requireArguments().getString("permalink")
            if (permalink == "all-movies") {
                CategoryId = 0
                contentTypeId = 1
            } else if (permalink == "movies-in-theatres") {
                CategoryId = 19
                contentTypeId = 0
            } else if (permalink == "ppv_movies") {
                CategoryId = 20
                contentTypeId = 0
            } else if (permalink == "coming-soon-on-plexigo") {
                CategoryId = 4
            } else if (permalink == "all-series") {
                CategoryId = 25
                // CategoryId = 0;
                contentTypeId = 3
            } else if (permalink == "latest-releases") {
                CategoryId = 7
            } else if (permalink == "mywatchlist") {
                isLibraryApiCalling = true
            } else if (permalink == "watchhistory") {
                IsWatchHistory = true
            } else if (permalink == "contentByChannel") {
                showContentByChannel = true
                channelCategoryId = requireArguments().getInt("channelCategoryId")
                channelId = requireArguments().getInt("channelId")
                channelType = requireArguments().getString("type")
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_movie_listing, container, false)
        progressbar = v.findViewById(R.id.progressbar)
        if (!AppConstants.IsFilterActive) if (isLibraryApiCalling) {
            libraryApi()
        } else if (IsWatchHistory) {
            watchHistory()
        } else if (showContentByChannel) {
            contentByChannelOTT()
        } else {
            if (CategoryId != 101) {
                movieListing()
            }
        }
        v.movies_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!isLibraryApiCalling && !IsWatchHistory) {
                    if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                        //Load more data
//                        if (endOfList) {
//                            return;
//                        }
                        if (CurrentPageCount != TotalPageCount && !isLoading) {
                            isLoading = true
                            CurrentPageCount++
                            PageCount++
                            if (isFilterContent) {
                                GetFilteredContent()
                            } else if (showContentByChannel) {
                                contentByChannelOTT()
                            } else {
                                movieListing()
                            }
                        } else {
                            endOfList = true
                            return
                        }
                    }
                }
            }
        })
        return v
    }

    override fun onResume() {
        super.onResume()
        if (AppConstants.IsFilterActive) {
            ResetPreviousData()
            isFilterContent = true
            GetFilteredContent()
        } else if (AppConstants.ResetFilter) {
            ResetPreviousData()
            AppConstants.ResetFilter = false
            isFilterContent = false
            movieListing()
        }
    }

    private fun ResetPreviousData() {
        PageCount = 1
        CurrentPageCount = 1
        TotalPageCount = 1
        endOfList = false
        isLoading = false
        if (movieList != null && movieList!!.size > 0) {
            movieList!!.clear()
        }
        movieList = null
        if (adapter != null) {
            adapter!!.notifyDataSetChanged()
        }
    }

    fun Showloader() {
        progressbar!!.visibility = View.VISIBLE
    }

    fun HideLoader() {
        progressbar!!.visibility = View.GONE
    }

    private fun libraryApi(){
        Showloader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getLibraryApi()
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            movieList = model.content
                            if (movieList != null && movieList!!.size > 0) {
                                movies_list!!.visibility = View.VISIBLE
                                no_content!!.visibility = View.GONE
                                adapter = SearchContentListAdapter(
                                    movies_list!!.context,
                                    movieList!!,
                                    false
                                )
                                val layoutManager = GridLayoutManager(
                                    activity, 2
                                )
                                movies_list!!.layoutManager = layoutManager
                                movies_list!!.adapter = adapter
                            } else {
                                no_content!!.visibility = View.VISIBLE
                                movies_list!!.visibility = View.GONE
                            }
                            HideLoader()
                        }else {
                            HideLoader()
                            Toast.makeText(
                                activity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
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

    private fun watchHistory(){
        Showloader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getWatchHistory(AppConstants.UserId!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            movieList = model.watchContent
                            if (movieList != null && movieList!!.size > 0) {
                                movies_list!!.visibility = View.VISIBLE
                                no_content!!.visibility = View.GONE
                                adapter = SearchContentListAdapter(
                                    movies_list!!.context,
                                    movieList!!,
                                    false
                                )
                                val layoutManager = GridLayoutManager(
                                    activity, 2
                                )
                                movies_list!!.layoutManager = layoutManager
                                movies_list!!.adapter = adapter
                            } else {
                                no_content!!.visibility = View.VISIBLE
                                movies_list!!.visibility = View.GONE
                            }
                        }else{
                            Toast.makeText(activity, responseModel?.data?.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
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

    private fun movieListing(){
        Showloader()
        apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getMovieListing(CategoryId,PageCount,Limit,Integer.valueOf(if (AppConstants.UserId == null) "0" else AppConstants.UserId))
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            AppConstants.showOttFilters = model.displayOTT == "Y"
                            val intent = Intent("showOttFilters")
                            intent.putExtra("showOttFilters", AppConstants.showOttFilters)
                            LocalBroadcastManager.getInstance(requireActivity())
                                .sendBroadcast(intent)
                            TotalPageCount = model.pageCount
                            if (movieList != null && movieList!!.size > 0) {
                                if (model.content
                                        .size > 0
                                ) {
                                    movieList!!.addAll(model.content)
                                    adapter!!.notifyDataSetChanged()
                                    isLoading = false
                                }
                            } else {
                                movieList = model.content
                                AppConstants.all_languages = model.languageGroup
                                if (movieList != null && movieList!!.size > 0) {
                                    movies_list!!.visibility = View.VISIBLE
                                    no_content!!.visibility = View.GONE
                                    adapter = SearchContentListAdapter(
                                        movies_list!!.context,
                                        movieList!!,
                                        false
                                    )
                                    val layoutManager = GridLayoutManager(
                                        activity, 2
                                    )
                                    movies_list!!.layoutManager = layoutManager
                                    movies_list!!.adapter = adapter
                                } else {
                                    no_content!!.visibility = View.VISIBLE
                                    movies_list!!.visibility = View.GONE
                                }
                            }
                            HideLoader()
                        }else {
                            HideLoader()
                            Toast.makeText(
                                activity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
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

    private fun GetFilteredContent(){
        Showloader()
        try {
            var genreids = ""
            if (AppConstants.SelectedGenreList != null && AppConstants.SelectedGenreList!!.size > 0) {
                for (j in AppConstants.SelectedGenreList!!.indices) {
                    genreids = if (genreids == "") {
                        genreids + AppConstants.SelectedGenreList!![j].genreGroupID
                    } else {
                        genreids + "," + AppConstants.SelectedGenreList!![j].genreGroupID
                    }
                }
            }
            var languageids = ""
            if (AppConstants.SelectedLanguageList != null && AppConstants.SelectedLanguageList!!.size > 0) {
                for (j in AppConstants.SelectedLanguageList!!.indices) {
                    languageids = if (languageids == "") {
                        languageids + AppConstants.SelectedLanguageList!![j].languageGroupID
                    } else {
                        languageids + "," + AppConstants.SelectedLanguageList!![j].languageGroupID
                    }
                }
            }
            var ottids = ""
            if (AppConstants.SelectedOTTList != null && AppConstants.SelectedOTTList!!.size > 0) {
                for (j in AppConstants.SelectedOTTList!!.indices) {
                    ottids = if (ottids == "") {
                        ottids + AppConstants.SelectedOTTList!![j].ottPlatformId
                    } else {
                        ottids + "," + AppConstants.SelectedOTTList!![j].ottPlatformId
                    }
                }
            }
            apiInterface = APIClient.getClient("1.3").create(APIInterface::class.java)
            val request = FilteredContentRequest(CategoryId,contentTypeId,genreids,languageids,ottids,PageCount,Limit,"","")
            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getFilteredContent(request)
                withContext(Dispatchers.Main) {
                    try {
                        HideLoader()
                        if (response.isSuccessful) {
                            val responseModel = response.body()
                            if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                val model = responseModel.data
                                TotalPageCount = model.pageCount
                                if (movieList != null && movieList!!.size > 0) {
                                    if (model.content.size > 0
                                    ) {
                                        movieList!!.addAll(model.content)
                                        adapter!!.notifyDataSetChanged()
                                        isLoading = false
                                    }
                                } else {
                                    movieList = model.content
                                    if (movieList != null && movieList!!.size > 0) {
                                        movies_list!!.visibility = View.VISIBLE
                                        no_content!!.visibility = View.GONE
                                        adapter = SearchContentListAdapter(
                                            movies_list!!.context,
                                            movieList!!,
                                            false
                                        )
                                        val layoutManager = GridLayoutManager(
                                            activity, 2
                                        )
                                        movies_list!!.layoutManager = layoutManager
                                        movies_list!!.adapter = adapter
                                    } else {
                                        no_content!!.visibility = View.VISIBLE
                                        movies_list!!.visibility = View.GONE
                                    }
                                }
                                HideLoader()
                            }else if (responseModel?.statusCode != null && responseModel.statusCode
                                    .equals("410")
                            ) {
                                HideLoader()
                                no_content!!.visibility = View.VISIBLE
                                movies_list!!.visibility = View.GONE
                            } else {
                                HideLoader()
                                Toast.makeText(
                                    activity,
                                    "" + responseModel?.data?.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    } catch (e: HttpException) {
                        Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    } catch (e: Throwable) {
                        HideLoader()
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

        }catch (e: Exception) {
            HideLoader()
            e.printStackTrace()
        }
    }

    private fun contentByChannelOTT(){
        Showloader()
        apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        var userId = 0
        if (!TextUtils.isEmpty(AppConstants.UserId)) userId = AppConstants.UserId!!.toInt()
        var apiEndPoint = ""
        apiEndPoint =
            if (channelType.equals(
                    "Channel",
                    ignoreCase = true
                )
            ) WsConstants.getContentByChannel else WsConstants.getContentByOTT
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getcontentByChannelOTT( channelId , channelCategoryId , PageCount , Limit ,userId)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            TotalPageCount = model.pageCount
                            if (movieList != null && movieList!!.size > 0) {
                                if (model.content
                                        .size > 0
                                ) {
                                    movieList!!.addAll(model.content)
                                    adapter!!.notifyDataSetChanged()
                                    isLoading = false
                                }
                            } else {
                                movieList = model.content
                                AppConstants.all_languages = model.languageGroup
                                if (movieList != null && movieList!!.size > 0) {
                                    movies_list!!.visibility = View.VISIBLE
                                    no_content!!.visibility = View.GONE
                                    adapter = SearchContentListAdapter(
                                        movies_list!!.context,
                                        movieList!!,
                                        false
                                    )
                                    val layoutManager = GridLayoutManager(
                                        activity, 2
                                    )
                                    movies_list!!.layoutManager = layoutManager
                                    movies_list!!.adapter = adapter
                                } else {
                                    no_content!!.visibility = View.VISIBLE
                                    movies_list!!.visibility = View.GONE
                                }
                            }
                            HideLoader()
                        }else {
                            HideLoader()
                            Toast.makeText(
                                activity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
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


    companion object {
        var customProgressDialog: CustomProgressDialog? = null
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        fun newInstance(permalink: String?): MovieListingFragment {
            val args = Bundle()
            //static for now. please change later
            args.putString("permalink", permalink)
            val fragment = MovieListingFragment()
            fragment.arguments = args
            return fragment
        }

        fun newInstance(
            param1: String?,
            channelId: Int,
            channelCategoryId: Int,
            type: String?
        ): MovieListingFragment {
            val fragment = MovieListingFragment()
            val args = Bundle()
            args.putString("permalink", param1)
            args.putInt("channelId", channelId)
            args.putInt("channelCategoryId", channelCategoryId)
            args.putString("type", type)
            fragment.arguments = args
            return fragment
        }
    }
}
