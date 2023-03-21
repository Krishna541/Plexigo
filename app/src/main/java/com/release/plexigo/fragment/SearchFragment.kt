package com.release.plexigo.fragment

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.android.volley.*
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonMappingException
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.SearchContentClass
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.activity.NewHomeActivity
import com.release.plexigo.adapter.*
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.util.*


class SearchFragment : Fragment() {
    //    SearchView searchView;
    lateinit var apiInterface: APIInterface
    var searchContentClass: SearchContentClass? = null
    var searchContentSuperAdapter: SearchContentSuperAdapter? = null
    var searchSuggestionAdapter: SearchSuggestionAdapter? = null
    private var searchPageContentList = ArrayList<SearchPageListingModel>()
    private val searchSuggestions = ArrayList<SearchSuggestionModel>()
    private var searchQuery: String? = null
    var recentSearchResult = ArrayList<MovieModel>()
    var recentSearchAdapter: SubContentListAdapter? = null
    var listForEveryOccasion = ArrayList<UserPlaylistModel>()
    var listForEveryOccasionAdapter: MoodPlaylistAdapter? = null
    var popularUsersList = ArrayList<TopUserListModel>()
    var popularUserAdapter: FollowedUserAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_search, container, false)

        val nestedScroll = v.findViewById<NestedScrollView>(R.id.nestedScroll)
        nestedScroll.isNestedScrollingEnabled = false

        recentSearchAdapter = SubContentListAdapter(requireActivity(), recentSearchResult)
        v.recyclerRecentSearches.adapter = recentSearchAdapter
        listForEveryOccasionAdapter = MoodPlaylistAdapter(requireContext(), listForEveryOccasion)
        v.recyclerListForEveryOccasion.adapter = listForEveryOccasionAdapter
        listForEveryOccasionAdapter!!.setOnPlayListItemSelectedListener(object :
            MoodPlaylistAdapter.OnPlayListItemSelectedListener {
            override fun onPlayListItemSelected(playlist: UserPlaylistModel?) {
//                Intent intent = new Intent(getActivity(), PlaylistContentListingActivity.class);
//                intent.putExtra("playlistId", playlist.getPlaylistId());
//                intent.putExtra("playlistTitle", playlist.getTitle());
//                startActivity(intent);
                (activity as NewHomeActivity?)!!.replaceFragment(
                    ExtendedSearchFragment.newInstance(
                        "moodPlaylist",
                        playlist!!.playlistName,
                        playlist.playlistId
                    ), true
                )
            }
        })
        popularUserAdapter = FollowedUserAdapter(requireContext(), popularUsersList)
        v.recyclerPopularUsers.adapter = popularUserAdapter
        searchSuggestionAdapter = SearchSuggestionAdapter(requireActivity(), searchSuggestions)
        v.searchView.setAdapter(searchSuggestionAdapter)
        v.searchView.setHorizontallyScrolling(false)
        v.searchView.isSingleLine = true
        v.searchView.imeOptions = EditorInfo.IME_ACTION_DONE
        v.searchView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, arg1, pos, id ->
                v.searchView.setText("")
                v.searchView.setText(searchSuggestions[pos].keyword)
                v.searchView.setSelection(searchView.getText().length)
            }
        v.searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                try {
                    if (!TextUtils.isEmpty(s.toString()) && s.toString().isNotEmpty()) {
                        searchPageContentList.clear()
                        searchQuery = s.toString()
                        Search(s.toString())
                        layoutSearchLanding.visibility = View.GONE
                        layoutSearchResults.visibility = View.VISIBLE
                    } else {
                        if (s.toString().isEmpty()) {
                            layoutSearchLanding.visibility = View.VISIBLE
                            layoutSearchResults.visibility = View.GONE
                        }
                        searchContentClass!!.stopSearch()
                        search_movies_list.visibility = View.GONE
                        no_content.visibility = View.GONE
                        progress.visibility = View.GONE
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (s.toString().isNotEmpty()) getSearchSuggestions(s.toString())
            }
        })
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        recentSearchResults()
        return v
    }

    private fun Search(newText: String) {
        if (searchContentClass == null) {
            searchContentClass = SearchContentClass(requireActivity(),
                object : SearchContentClass.SearchDataListener {
                    override fun OnContentListLoaded(all_movies: ArrayList<MovieModel>?) {
                        Log.e("onSearchResult", "moviesReceived")
                        if (all_movies != null && all_movies.size > 0) {
                            searchPageContentList.clear()
                            searchPageContentList.add(
                                SearchPageListingModel(
                                    AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_CONTENT,
                                    all_movies
                                )
                            )
                            sortSearchResultList()
                        } else {
                            progress!!.visibility = View.GONE
                            // no_content.setVisibility(View.VISIBLE);
                        }
                    }

                    override fun onPlaylistLoaded(playlists: ArrayList<UserPlaylistModel>?) {
                        Log.e("onSearchResult", "playlistsReceived")
                        if (playlists != null && playlists.size > 0) {
                            searchPageContentList.add(
                                SearchPageListingModel(
                                    AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_PLAYLIST,
                                    playlists
                                )
                            )
                            sortSearchResultList()
                        } else {
                            progress!!.visibility = View.GONE
                            //                        no_content.setVisibility(View.VISIBLE);
                        }
                    }

                    override fun onActorsLoaded(actors: ArrayList<ActorModel>?) {
                        Log.e("onSearchResult", "actorsReceived")
                        if (actors != null && actors.size > 0) {
                            searchPageContentList.add(
                                SearchPageListingModel(
                                    AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_ACTOR,
                                    actors
                                )
                            )
                            sortSearchResultList()
                        } else {
                            progress!!.visibility = View.GONE
                            //                        no_content.setVisibility(View.VISIBLE);
                        }
                    }

                    override fun onPlayListUsersLoaded(playlistUsers: ArrayList<PlaylistUserModel>?) {
                        Log.e("onSearchResult", "playlistUsersReceived")
                        if (playlistUsers != null && playlistUsers.size > 0) {
                            searchPageContentList.add(
                                SearchPageListingModel(
                                    AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_PLAYLIST_USER,
                                    playlistUsers
                                )
                            )
                            sortSearchResultList()
                        } else {
                            progress!!.visibility = View.GONE
                            //                        no_content.setVisibility(View.VISIBLE);
                        }
                    }
                })
        } else {
            searchContentClass?.stopSearch()
            no_content.visibility = View.VISIBLE
            search_movies_list.visibility = View.VISIBLE
        }


        //        no_content.setVisibility(View.GONE);
        if (progress!!.visibility != View.VISIBLE) {
            progress!!.visibility = View.VISIBLE
        }
        search_movies_list.visibility = View.INVISIBLE
        searchContentClass!!.performSearch(newText, 1, 30)
    }

    private fun sortSearchResultList() {
        Collections.sort(searchPageContentList, object : Comparator<SearchPageListingModel?> {
            override fun compare(o1: SearchPageListingModel?, o2: SearchPageListingModel?): Int {
                return if (o1?.viewType!! > o2?.viewType!!) {
                    1
                } else {
                    if (o1.viewType < o2.viewType) {
                        -1
                    } else {
                        0
                    }
                }
            }
        })


        no_content.visibility = View.GONE
        progress.visibility = View.GONE
        search_movies_list.visibility = View.VISIBLE
        searchContentSuperAdapter =
            SearchContentSuperAdapter(requireActivity(), searchPageContentList, searchQuery!!)
        search_movies_list.adapter = searchContentSuperAdapter
        hideLoader() //sunil
    }

    private fun getSearchSuggestions(searchQuery: String) {
        val requestObject = JSONObject()
        val userid = if (AppConstants.UserId != null) AppConstants.UserId!!.toInt() else 0
        try {
//            requestObject.put("KeyWord", searchQuery)
//            requestObject.put("UserId", userid)

            val request = SearchSuggestionsRequestModel(
                searchQuery!!,
                userid
            )

            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getSuggestiveSearch(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                Log.e("onSearchResult", "searchSuggestionsReceived")
                                val responseModel = response.body()
                                if (responseModel?.statusCode != null && responseModel.statusCode == "200" && responseModel.data.search != null) {
                                    progress!!.visibility = View.GONE
                                    searchSuggestions.clear()
                                    searchSuggestions.addAll(responseModel.data.search)
                                    searchSuggestionAdapter!!.notifyDataSetChanged()
                                    Handler().post {
                                        if (searchSuggestions.size > 0) {
                                            searchView!!.showDropDown()
                                            searchView!!.requestFocus()
                                        }
                                    }
                                }
                            } catch (e: JsonMappingException) {
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                            }
                        }
                    } catch (e: HttpException) {
                        Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT).show()
                    } catch (error: Throwable) {
                        hideLoader()
                        if (error is TimeoutError) {
                            Toast.makeText(activity, R.string.timeout_message, Toast.LENGTH_SHORT)
                                .show()
                        }
                        if (error.cause is IOException) {
                            Toast.makeText(
                                activity,
                                getString(R.string.internet_not_available),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        Toast.makeText(activity, "" + error.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    //This is for Headers If You Needed
    private fun recentSearchResults() {
        showLoader()
        val requestObject = JSONObject()
        val userid = if (AppConstants.UserId != null) AppConstants.UserId!!.toInt() else 0
        try {
            requestObject.put("KeyWord", "")
            requestObject.put("UserId", userid)


            val request = RecentSearchResultsRequestModel(
                "",
                userid
            )


            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getrecentSearch(request)
                withContext(Dispatchers.Main) {
                    try {
                        hideLoader()
                        if (response.isSuccessful) {
                            try {
                                Log.e("onSearchResult", "searchSuggestionsReceived")

                                val responseModel = response.body()!!
                                if (responseModel.statusCode != null && responseModel.statusCode == "200") {
                                    progress.visibility = View.GONE
                                    no_content.visibility = View.GONE
                                    recentSearchResult.clear()
                                    recentSearchResult.addAll(responseModel.data.content)
                                    recentSearchAdapter!!.notifyDataSetChanged()
                                    getListForEveryOccasion()
                                }
                            } catch (e: JsonMappingException) {
                                hideLoader()
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                                hideLoader()
                            }
                        }

                    } catch (e: HttpException) {
                        Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT).show()
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

        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    private fun getListForEveryOccasion() {
        //showLoader();
        val requestObj = JSONObject()
        try {


            val request = PopularInAreaListRequest(0, 1, 10)


            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getListForEveryMood(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                Log.e("onSearchResult", "searchSuggestionsReceived")
                                val responseModel = response.body()
                                if (responseModel?.statusCode != null && responseModel.statusCode == "200" &&
                                    responseModel?.data.playlist != null
                                ) {
                                    progress!!.visibility = View.GONE
                                    no_content!!.visibility = View.GONE
                                    listForEveryOccasion.clear()
                                    listForEveryOccasion.addAll(responseModel.data.playlist)
                                    listForEveryOccasionAdapter!!.notifyDataSetChanged()
                                    popularUsers()
                                }
                            } catch (e: JsonMappingException) {
                                hideLoader()
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                hideLoader()
                                e.printStackTrace()
                            }
                        }
                    } catch (e: HttpException) {
                        Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT)
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


        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }//This is for Headers If You Needed

    //  showLoader();
    private fun popularUsers() {
        //  showLoader();
        val requestObject = JSONObject()
        val userid = if (AppConstants.UserId != null) AppConstants.UserId!!.toInt() else 0
        try {
            requestObject.put("KeyWord", "")
            requestObject.put("UserId", userid)


            val request = PopularUsersRequestModel(
                "",
                userid
            )


            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getPopularUsers(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                Log.e("onSearchResult", "searchSuggestionsReceived")
                                val responseModel = response.body()
                                if (responseModel?.statusCode != null && responseModel.statusCode == "200" &&
                                    responseModel.data.topuserslist != null
                                ) {
                                    progress!!.visibility = View.GONE
                                    no_content!!.visibility = View.GONE
                                    popularUsersList.clear()
                                    popularUsersList.addAll(responseModel.data.topuserslist)
                                    popularUserAdapter!!.notifyDataSetChanged()
                                }
                            } catch (e: JsonMappingException) {
                                hideLoader()
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                hideLoader()
                                e.printStackTrace()
                            }
                        }


                    } catch (e: HttpException) {
                        Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT)
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


        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    fun showLoader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = childFragmentManager.beginTransaction()
        customProgressDialog.show(ft, "dialog")
        customProgressDialog.setCancelable(false)
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    companion object {
        lateinit var customProgressDialog: CustomProgressDialog
        fun newInstance(): SearchFragment {
            val args = Bundle()
            val fragment = SearchFragment()
            fragment.arguments = args
            return fragment
        }
    }


}