package com.release.plexigo.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonMappingException
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.activity.NewHomeActivity
import com.release.plexigo.activity.PlaylistContentListingActivity
import com.release.plexigo.adapter.PlaylistAdapter
import com.release.plexigo.adapter.PlaylistUserAdapter
import com.release.plexigo.adapter.SearchActorGridAdapter
import com.release.plexigo.adapter.SearchContentListAdapter
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.util.ArrayList
import java.util.HashMap


class ExtendedSearchFragment : Fragment() {
    lateinit var apiInterface: APIInterface
    lateinit var recyclerView: RecyclerView
    lateinit var imgBack: ImageView
    var no_content: TextView? = null
    var txtExtendedSearchTitle: TextView? = null
    var progressbar: ProgressBar? = null
    private var searchQuery: String? = null
    private var searchFor: String? = null
    private var isActorSearch = false
    private var isPlaylistSearch = false
    private var isPlaylistUserSearch = false
    private var isSearchMoviesByActor = false
    var PageCount = 1
    var Limit = 20
    var CurrentPageCount = 1
    var TotalPageCount = 1
    var CategoryId = 101
    var endOfList = false
    var isLoading = false
    var actorId = 0
    var movieList: ArrayList<MovieModel>? = ArrayList()
    var actors: ArrayList<ActorModel>? = ArrayList()
    var playlists: ArrayList<UserPlaylistModel>? = ArrayList()
    var playlistUsers: ArrayList<PlaylistUserModel>? = ArrayList()
    var searchContentListAdapter: SearchContentListAdapter? = null
    var searchActorGridAdapter: SearchActorGridAdapter? = null
    var playlistAdapter: PlaylistAdapter? = null
    var playlistUserAdapter: PlaylistUserAdapter? = null
    var queue: RequestQueue? = null
    private var permalink: String? = null
    private var isPopularInArea = false
    private var isMoodPlaylistContent = false
    private var moodPlaylistId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        queue = Volley.newRequestQueue(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_extended_search, container, false)
        recyclerView = v.findViewById(R.id.movies_list)
        no_content = v.findViewById(R.id.no_content)
        txtExtendedSearchTitle = v.findViewById(R.id.txtExtendedSearchTitle)
        progressbar = v.findViewById(R.id.progressbar)
        imgBack = v.findViewById(R.id.imgBack)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        imgBack.setOnClickListener(View.OnClickListener { requireActivity().onBackPressed() })
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //Load more data
//                    if (endOfList) {
//                        return
//                    }
                    if (CurrentPageCount != TotalPageCount && !isLoading) {
                        isLoading = true
                        CurrentPageCount++
                        PageCount++
                        if (isActorSearch) {
                            searchActors()
                        } else {
                            if (isPlaylistSearch) {
                                searchPlaylists()
                            } else {
                                if (isPlaylistUserSearch) {
                                    searchPlaylistUsers()
                                } else {
                                    if (isSearchMoviesByActor) {
                                        searchMoviesByActor()
                                    } else {
                                        if (isPopularInArea) {
                                            popularInAreaList()
                                        } else {
                                            searchMovies()
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        endOfList = true
                        return
                    }
                }
            }
        })
        return v
    }

    override fun onResume() {
        super.onResume()
        if (arguments != null) {
            txtExtendedSearchTitle!!.text = requireArguments().getString("title")
            permalink = requireArguments().getString("permalink")
            movieList!!.clear()
            actors!!.clear()
            playlists!!.clear()
            playlistUsers!!.clear()
            PageCount = 1
            CurrentPageCount = 1
            TotalPageCount = 1
            if (permalink.equals("searchMovies", ignoreCase = true)) {
                CategoryId = 0
                searchFor = requireArguments().getString("searchFor")
                searchQuery = requireArguments().getString("searchQuery")
                searchMovies()
            }
            if (permalink.equals("searchActors", ignoreCase = true)) {
                isActorSearch = true
                searchFor = requireArguments().getString("searchFor")
                searchQuery = requireArguments().getString("searchQuery")
                searchActors()
            }
            if (permalink.equals("searchPlaylists", ignoreCase = true)) {
                isPlaylistSearch = true
                searchQuery = requireArguments().getString("searchQuery")
                searchPlaylists()
            }
            if (permalink.equals("searchPlaylistUser", ignoreCase = true)) {
                isPlaylistUserSearch = true
                searchQuery = requireArguments().getString("searchQuery")
                searchPlaylistUsers()
            }
            if (permalink.equals("searchMoviesByActor", ignoreCase = true)) {
                isSearchMoviesByActor = true
                actorId = requireArguments().getInt("actorId", 0)
                searchMoviesByActor()
            }
            if (permalink.equals("popularInArea", ignoreCase = true)) {
                isPopularInArea = true
                popularInAreaList()
            }
            if (permalink.equals("moodPlaylist", ignoreCase = true)) {
                isMoodPlaylistContent = true
                moodPlaylistId = requireArguments().getInt("moodPlaylistId")
                getMoodPlaylistContent()
            }
        }
    }

    fun searchMovies() {
        try {
            var user_Id = if (AppConstants.UserId == null) "0" else AppConstants.UserId
            val request = SearchMoviesRequestModel(searchQuery!!,
                0, searchFor!!, user_Id!!.toInt(),
                PageCount!!, Limit!! )
            val apiInterface = APIClient.getClient("1.2").create(APIInterface::class.java)
            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getSearchMovies(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                val responseModel = response.body()
                                if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                    //successresponseModel.getStatus()
                                    val model = responseModel?.data
                                    TotalPageCount = model!!.pageCount
                                    if (movieList != null && movieList!!.size > 0) {
                                        if (model.content != null && model.content.size > 0) {
                                            movieList!!.addAll(model.content)
                                            searchContentListAdapter!!.notifyDataSetChanged()
                                            isLoading = false
                                        }
                                    } else {
                                        movieList = model.content
                                        AppConstants.all_languages = model.languageGroup
                                        if (movieList != null && movieList!!.size > 0) {
                                            recyclerView!!.visibility = View.VISIBLE
                                            no_content!!.visibility = View.GONE
                                            searchContentListAdapter = SearchContentListAdapter(
                                                recyclerView!!.context, movieList!!, false
                                            )
                                            val layoutManager = GridLayoutManager(activity, 2)
                                            recyclerView!!.layoutManager = layoutManager
                                            recyclerView!!.adapter = searchContentListAdapter
                                        } else {
                                            no_content!!.visibility = View.VISIBLE
                                            recyclerView!!.visibility = View.GONE
                                        }
                                    }
                                } else {

                                    Toast.makeText(activity, "" + responseModel?.data?.message, Toast.LENGTH_SHORT)
                                        .show()
                                }
                            } catch (e: JsonMappingException) {
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                            }
                        }

                    }
                    catch (e: HttpException) {
                        Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT).show()
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

        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    fun searchMoviesByActor() {
        val requestObject = JSONObject()
        try {

            var user_Id = if (AppConstants.UserId == null) "0" else AppConstants.UserId
            val request = SearchMoviesByActorRequest(
                actorId!!, user_Id!!.toInt(),
                PageCount,Limit)


            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getContentByActor(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                val responseModel = response.body()
                                if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                    //successresponseModel.getStatus()
                                    val model = responseModel.data
                                    TotalPageCount = model.pageCount
                                    if (movieList != null && movieList!!.size > 0) {
                                        if (model.content != null && model.content.size > 0) {
                                            movieList!!.addAll(model.content)
                                            searchContentListAdapter!!.notifyDataSetChanged()
                                            isLoading = false
                                        }
                                    } else {
                                        movieList = model.content
                                        AppConstants.all_languages = model.languageGroup
                                        if (movieList != null && movieList!!.size > 0) {
                                            recyclerView!!.visibility = View.VISIBLE
                                            no_content!!.visibility = View.GONE
                                            searchContentListAdapter = SearchContentListAdapter(
                                                recyclerView!!.context, movieList!!, false
                                            )
                                            val layoutManager = GridLayoutManager(activity, 2)
                                            recyclerView!!.layoutManager = layoutManager
                                            recyclerView!!.adapter = searchContentListAdapter
                                        } else {
                                            no_content!!.visibility = View.VISIBLE
                                            recyclerView!!.visibility = View.GONE
                                        }
                                    }
                                } else {
                                    val model = responseModel?.data
                                    Toast.makeText(activity, "" + model?.message, Toast.LENGTH_SHORT)
                                        .show()
                                }
                            } catch (e: JsonMappingException) {
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                            }
                        }


                    }
                    catch (e: HttpException) {
                        Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT)
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



        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    fun searchActors() {
        val requestObject = JSONObject()
        try {

            var user_Id = if (AppConstants.UserId == null) "0" else AppConstants.UserId
            val request = SearchActorsRequestModel(
                searchQuery!!,searchFor!!, user_Id!!.toInt(),
                PageCount,Limit)

            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getSearchActors(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                val responseModel = NewHomeActivity.mapper!!.readValue(
                                    response.toString(),
                                    ActorListingResponseModel::class.java
                                )
                                if (responseModel.statusCode != null && responseModel.statusCode == "200") {
                                    //successresponseModel.getStatus()w
                                    val model = responseModel.data
                                    TotalPageCount = model.pageCount
                                    if (actors != null && actors!!.size > 0) {
                                        if (model.actors != null && model.actors.size > 0) {
                                            actors!!.addAll(model.actors)
                                            searchActorGridAdapter!!.notifyDataSetChanged()
                                            isLoading = false
                                        }
                                    } else {
                                        actors = model.actors
                                        if (actors != null && actors!!.size > 0) {
                                            recyclerView!!.visibility = View.VISIBLE
                                            no_content!!.visibility = View.GONE
                                            searchActorGridAdapter =
                                                SearchActorGridAdapter(recyclerView!!.context, actors!!)
                                            val layoutManager = GridLayoutManager(activity, 3)
                                            recyclerView!!.layoutManager = layoutManager
                                            recyclerView!!.adapter = searchActorGridAdapter
                                        } else {
                                            no_content!!.visibility = View.VISIBLE
                                            recyclerView!!.visibility = View.GONE
                                        }
                                    }
                                }
                            } catch (e: JsonMappingException) {
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                            }
                        }

                    }catch (e: HttpException) {
                        Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT)
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


        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    fun searchPlaylists() {
        val requestObject = JSONObject()
        try {



            var user_Id = if (AppConstants.UserId == null) "0" else AppConstants.UserId
            val request = SearchPlaylistsRequestModel(
                searchQuery!!, user_Id!!.toInt())


            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getSearchPlayList(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                val responseModel = NewHomeActivity.mapper!!.readValue(
                                    response.toString(),
                                    UserPlayListResponse::class.java
                                )
                                if (responseModel.statusCode != null && responseModel.statusCode == "200") {
                                    val model = responseModel.data
                                    if (playlists != null && playlists!!.size > 0) {
                                        if (model.playlist != null && model.playlist.size > 0) {
                                            playlists!!.addAll(model.playlist)
                                            searchActorGridAdapter!!.notifyDataSetChanged()
                                            isLoading = false
                                        }
                                    } else {
                                        playlists = model.playlist
                                        if (playlists != null && playlists!!.size > 0) {
                                            recyclerView!!.visibility = View.VISIBLE
                                            no_content!!.visibility = View.GONE
                                            playlistAdapter = PlaylistAdapter(requireContext(),playlists!!, false)
                                            val layoutManager = GridLayoutManager(activity, 2)
                                            recyclerView!!.layoutManager = layoutManager
                                            recyclerView!!.adapter = playlistAdapter
                                            playlistAdapter!!.setOnPlayListItemSelectedListener(object :
                                                PlaylistAdapter.OnPlayListItemSelectedListener {
                                                override fun onPlayListItemSelected(playlist: UserPlaylistModel?) {
                                                    val intent = Intent(
                                                        activity,
                                                        PlaylistContentListingActivity::class.java
                                                    )
                                                    intent.putExtra("playlistId", playlist!!.playlistId)
                                                    intent.putExtra("playlistTitle", playlist.title)
                                                    startActivity(intent)
                                                }
                                            })
                                        } else {
                                            no_content!!.visibility = View.VISIBLE
                                            recyclerView!!.visibility = View.GONE
                                        }
                                    }
                                }
                            } catch (e: JsonMappingException) {
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                            }
                        }

                    }
                    catch (e: JsonMappingException) {
                        e.printStackTrace()
                    } catch (e: JsonProcessingException) {
                        e.printStackTrace()
                    }
                }
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    fun searchPlaylistUsers() {
        val requestObject = JSONObject()
        try {



            var user_Id = if (AppConstants.UserId == null) "0"
            else (AppConstants.UserId)!!.toInt()
            val request = SearchPlaylistUsersRequestModel(
                searchQuery!!, "playlistuser",
                user_Id as Int, PageCount,Limit)


            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getSearchPlaylistUsers(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                val responseModel = NewHomeActivity.mapper!!.readValue(
                                    response.toString(),
                                    PlaylistUserResponseModel::class.java
                                )
                                if (responseModel.statusCode != null && responseModel.statusCode == "200") {
                                    val model = responseModel.data
                                    if (playlistUsers != null && playlistUsers!!.size > 0) {
                                        if (model.playlistUser != null && model.playlistUser.size > 0) {
                                            playlistUsers!!.addAll(model.playlistUser)
                                            playlistUserAdapter!!.notifyDataSetChanged()
                                            isLoading = false
                                        }
                                    } else {
                                        playlistUsers = model.playlistUser
                                        if (playlistUsers != null && playlistUsers!!.size > 0) {
                                            recyclerView!!.visibility = View.VISIBLE
                                            no_content!!.visibility = View.GONE
                                            playlistUserAdapter = PlaylistUserAdapter(requireContext(),playlistUsers!!)
                                            val layoutManager = GridLayoutManager(activity, 2)
                                            recyclerView!!.layoutManager = layoutManager
                                            recyclerView!!.adapter = playlistUserAdapter
                                        } else {
                                            no_content!!.visibility = View.VISIBLE
                                            recyclerView!!.visibility = View.GONE
                                        }
                                    }
                                }
                            }catch (e: HttpException) {
                                Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT)
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
                    catch (e: JsonMappingException) {
                        e.printStackTrace()
                    } catch (e: JsonProcessingException) {
                        e.printStackTrace()
                    }
                }
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }
    fun popularInAreaList() {
            val requestObject = JSONObject()
            try {

                var user_Id = if (AppConstants.UserId == null) "0"
                else (AppConstants.UserId)
                val request = PopularInAreaListRequest(user_Id!!.toInt(),PageCount,Limit)
                CoroutineScope(Dispatchers.IO).launch {
                    val response = apiInterface.getPopularInYourArea(request)
                    withContext(Dispatchers.Main) {
                        try {
                            if (response.isSuccessful) {
                                try {
                                    val responseModel = response.body()
                                    if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                        //successresponseModel.getStatus()
                                        val model = responseModel.data
                                        TotalPageCount = model.pageCount
                                        if (movieList != null && movieList!!.size > 0) {
                                            if (model.content != null && model.content.size > 0) {
                                                movieList!!.addAll(model.content)
                                                searchContentListAdapter!!.notifyDataSetChanged()
                                                isLoading = false
                                            }
                                        } else {
                                            movieList = model.content
                                            if (movieList != null && movieList!!.size > 0) {
                                                recyclerView!!.visibility = View.VISIBLE
                                                no_content!!.visibility = View.GONE
                                                searchContentListAdapter = SearchContentListAdapter(
                                                    recyclerView!!.context, movieList!!, false
                                                )
                                                val layoutManager = GridLayoutManager(activity, 2)
                                                recyclerView!!.layoutManager = layoutManager
                                                recyclerView!!.adapter = searchContentListAdapter
                                            } else {
                                                no_content!!.visibility = View.VISIBLE
                                                recyclerView!!.visibility = View.GONE
                                            }
                                        }
                                    } else {
                                        val model = responseModel?.data
                                        Toast.makeText(activity, "" + model?.message, Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                } catch (e: JsonMappingException) {
                                    e.printStackTrace()
                                } catch (e: JsonProcessingException) {
                                    e.printStackTrace()
                                }
                            }
                        }
                        catch (e: HttpException) {
                            Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT)
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




            } catch (e: JSONException) {
                e.printStackTrace()
            }

        }

    fun getMoodPlaylistContent() {
        val userid = if (AppConstants.UserId != null) AppConstants.UserId else "0"

        try
        {
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getMoodPlaylistContentInterface(moodPlaylistId,userid!!.toInt())

            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        try {
                            val responseModel = response.body()
                            if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                val model = responseModel.data
                                if (movieList != null && movieList!!.size > 0) {
                                    if (model.playlistContent != null && model.playlistContent.size > 0) {
                                        movieList!!.addAll(model.playlistContent)
                                        searchContentListAdapter!!.notifyDataSetChanged()
                                        isLoading = false
                                    }
                                } else {
                                    movieList = model.playlistContent
                                    if (movieList != null && movieList!!.size > 0) {
                                        recyclerView!!.visibility = View.VISIBLE
                                        no_content!!.visibility = View.GONE
                                        searchContentListAdapter = SearchContentListAdapter(
                                            recyclerView!!.context,
                                            movieList!!,
                                            false
                                        )
                                        val layoutManager = GridLayoutManager(activity, 2)
                                        recyclerView!!.layoutManager = layoutManager
                                        recyclerView!!.adapter = searchContentListAdapter
                                    } else {
                                        no_content!!.visibility = View.VISIBLE
                                        recyclerView!!.visibility = View.GONE
                                    }
                                }
                            }
                        } catch (e: JsonProcessingException) {
                            e.printStackTrace()
                        }
                    }

                }
                catch (e: HttpException) {
                    Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT)
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

    } catch (e: JSONException) {
        e.printStackTrace()
    }

    }

    companion object {
        fun newInstance(
            param1: String?,
            searchFor: String?,
            searchQuery: String?,
            title: String?
        ): ExtendedSearchFragment {
            val fragment = ExtendedSearchFragment()
            val args = Bundle()
            args.putString("permalink", param1)
            args.putString("searchFor", searchFor)
            args.putString("searchQuery", searchQuery)
            args.putString("title", title)
            fragment.arguments = args
            return fragment
        }

        fun newInstance(param1: String?, actorId: Int): ExtendedSearchFragment {
            val fragment = ExtendedSearchFragment()
            val args = Bundle()
            args.putString("permalink", param1)
            args.putInt("actorId", actorId)
            fragment.arguments = args
            return fragment
        }

        fun newInstance(param1: String?, title: String?): ExtendedSearchFragment {
            val fragment = ExtendedSearchFragment()
            val args = Bundle()
            args.putString("permalink", param1)
            args.putString("title", title)
            fragment.arguments = args
            return fragment
        }

        @JvmStatic
        fun newInstance(
            param1: String?,
            title: String?,
            moodPlaylistId: Int
        ): ExtendedSearchFragment {
            val fragment = ExtendedSearchFragment()
            val args = Bundle()
            args.putString("permalink", param1)
            args.putString("title", title)
            args.putInt("moodPlaylistId", moodPlaylistId)
            fragment.arguments = args
            return fragment
        }
    }
}