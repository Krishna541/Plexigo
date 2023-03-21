package com.release.plexigo.fragment

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.TimeoutError
import com.android.volley.toolbox.Volley
import com.release.plexigo.Common.SearchContentClass
import com.release.plexigo.Common.SearchContentClass.SearchDataListener
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.AppConstants.HOME_TAB_ALL_MOVIES
import com.release.plexigo.Constants.AppConstants.HOME_TAB_ALL_SERIES
import com.release.plexigo.Constants.AppConstants.HOME_TAB_COMING_SOON
import com.release.plexigo.Constants.AppConstants.HOME_TAB_IN_THEATRE
import com.release.plexigo.Constants.AppConstants.HOME_TAB_PPV
import com.release.plexigo.Constants.AppConstants.resetFilters
import com.release.plexigo.R
import com.release.plexigo.activity.FilterMoviesActivity
import com.release.plexigo.activity.FilterOttActivity
import com.release.plexigo.activity.NewHomeActivity
import com.release.plexigo.adapter.FilterGenreAdapter
import com.release.plexigo.adapter.FilterLanguageAdapter
import com.release.plexigo.adapter.SearchContentListAdapter
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.fragment_home_tab.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class HomeTabFragment : Fragment(), View.OnClickListener,
    FilterLanguageAdapter.OnFilterLanguageItemSelectedListener,
    FilterGenreAdapter.OnFilterGenreItemSelectedListener {

    var searchContentClass: SearchContentClass? = null
    private var categoryId = 0
    var allGenres: ArrayList<HomeGenreModel> = ArrayList<HomeGenreModel>()
    var allLanguages: ArrayList<HomeLanguageModel> = ArrayList<HomeLanguageModel>()
    var languageAdapter: FilterLanguageAdapter? = null
    var genreAdapter: FilterGenreAdapter? = null
    var queue: RequestQueue? = null
    lateinit var apiInterface: APIInterface
    var txtFilterOtt: TextView? = null
    var txtClearFilter:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalBroadcastManager.getInstance(requireActivity())
            .registerReceiver(mMessageReceiver, IntentFilter("showOttFilters"))
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(requireActivity()).unregisterReceiver(mMessageReceiver)
        super.onDestroy()
    }

    private val mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // Get extra data included in the Intent
            val message = intent.getBooleanExtra("showOttFilters", false)
            if (message) {
                txtFilterOtt!!.visibility = View.VISIBLE
            } else {
                txtFilterOtt!!.visibility = View.GONE
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        queue = Volley.newRequestQueue(activity)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        initView()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        genreAdapter = FilterGenreAdapter(allGenres)
        recyclerFilterGenres!!.adapter = genreAdapter
        languageAdapter = FilterLanguageAdapter(allLanguages)
        recyclerFilterLanguages!!.adapter = languageAdapter
        languageAdapter!!.setOnFilterLanguageItemSelectedListener(this)
        genreAdapter!!.setOnFilterGenreItemSelectedListener(this)
        txtFilterOtt!!.setOnClickListener(this)
        txtClearFilter!!.setOnClickListener(this)
        languagesList()
    }

    private fun initView() {
        txtFilterOtt = requireView().findViewById(R.id.txtFilterOtt)
        txtClearFilter = requireView().findViewById(R.id.txtClearFilter)
        val selectedTab = requireArguments().getInt("selectedTab")
        when (selectedTab) {
            HOME_TAB_ALL_MOVIES -> {
                categoryId = 0
                replaceFragment(MovieListingFragment.newInstance("all-movies"))
                btnTabTitle!!.text = getString(R.string.all_movies)
                btnAllMovies!!.visibility = View.GONE
                edtSearch!!.hint = "Search Movie by name"
            }
            HOME_TAB_IN_THEATRE -> {
                categoryId = 19
                replaceFragment(MovieListingFragment.newInstance("movies-in-theatres"))
                btnTabTitle!!.text = getString(R.string.in_theatre)
                btnInTheatre!!.visibility = View.GONE
                edtSearch!!.hint = "Search Movie by name"
            }
            HOME_TAB_PPV -> {
                categoryId = 20
                replaceFragment(MovieListingFragment.newInstance("ppv_movies"))
                btnTabTitle!!.text = getString(R.string.pvod)
                btnPpv!!.visibility = View.GONE
                edtSearch!!.hint = "Search Movie by name"
            }
            HOME_TAB_COMING_SOON -> {
                categoryId = 4
                replaceFragment(MovieListingFragment.newInstance("coming-soon-on-plexigo"))
                edtSearch!!.hint = "Search Movie by name"
            }
            HOME_TAB_ALL_SERIES -> {
                categoryId = 25
                replaceFragment(MovieListingFragment.newInstance("all-series"))
                btnTabTitle!!.text = getString(R.string.all_series)
                btnAllSeries!!.visibility = View.GONE
                edtSearch!!.hint = "Search Series by name"
            }
        }
        btnAllMovies!!.setOnClickListener(this)
        btnInTheatre!!.setOnClickListener(this)
        btnPpv!!.setOnClickListener(this)
        btnComingSoon!!.setOnClickListener(this)
        btnAllSeries!!.setOnClickListener(this)
        btnFilter!!.setOnClickListener(this)
        edtSearch!!.setOnTouchListener(OnTouchListener { v, event ->
            val DRAWABLE_LEFT = 0
            val DRAWABLE_TOP = 1
            val DRAWABLE_RIGHT = 2
            val DRAWABLE_BOTTOM = 3
            if (event.action == MotionEvent.ACTION_UP) {
                if (edtSearch!!.compoundDrawables[DRAWABLE_RIGHT] != null) {
                    if (event.rawX >= edtSearch!!.right - edtSearch!!.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
                        // your action here
                        searchContentClass!!.stopSearch()
                        containerSearchList!!.visibility = View.GONE
                        layoutContainerTab!!.visibility = View.VISIBLE
                        //                        no_content.setVisibility(View.GONE);
                        edtSearch!!.setCompoundDrawablesWithIntrinsicBounds(
                            requireActivity().resources.getDrawable(
                                R.drawable.ic_search_black_24dp
                            ), null, null, null
                        )
                        progress!!.visibility = View.GONE
                        edtSearch!!.setText("")
                        return@OnTouchListener true
                    }
                }
            }
            false
        })
        edtSearch!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(newText: CharSequence, start: Int, before: Int, count: Int) {
                try {
                    if (newText != null && !newText.toString().isEmpty()) {
                        Search(newText.toString())
                        layoutContainerTab!!.visibility = View.GONE
                        edtSearch!!.setCompoundDrawablesWithIntrinsicBounds(
                            activity!!.resources.getDrawable(R.drawable.ic_search_black_24dp),
                            null,
                            activity!!.resources.getDrawable(R.drawable.ic_close),
                            null
                        )
                    } else {
                        searchContentClass!!.stopSearch()
                        containerSearchList!!.visibility = View.GONE
                        layoutContainerTab!!.visibility = View.VISIBLE
                        //                        no_content.setVisibility(View.GONE);
                        edtSearch!!.setCompoundDrawablesWithIntrinsicBounds(
                            activity!!.resources.getDrawable(
                                R.drawable.ic_search_black_24dp
                            ), null, null, null
                        )
                        progress!!.visibility = View.GONE
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })

//        genreAdapter = new FilterGenreAdapter(allGenres);
//        recyclerFilterGenre.setAdapter(genreAdapter);
//        languageAdapter = new FilterLanguageAdapter(allLanguages);
//        recyclerFilterLanguages.setAdapter(languageAdapter);
//
//        languageAdapter.setOnFilterLanguageItemSelectedListener(this);
//        genreAdapter.setOnFilterGenreItemSelectedListener(this);
//        txtFilterOtt.setOnClickListener(this);
//        getLanguagesList();
        if (AppConstants.IsFilterActive) {
            txtClearFilter!!.visibility = View.VISIBLE
        } else {
            txtClearFilter!!.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    private fun initData() {}
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnAllMovies -> {
                (activity as NewHomeActivity?)!!.replaceFragment(
                    newInstance(HOME_TAB_ALL_MOVIES),
                    false
                )
                resetFilters()
            }
            R.id.btnInTheatre -> {
                (activity as NewHomeActivity?)!!.replaceFragment(
                    newInstance(HOME_TAB_IN_THEATRE),
                    false
                )
                resetFilters()
            }
            R.id.btnAllSeries -> {
                (activity as NewHomeActivity?)!!.replaceFragment(
                    newInstance(HOME_TAB_ALL_SERIES),
                    false
                )
                resetFilters()
            }
            R.id.btnPpv -> {
                (activity as NewHomeActivity?)!!.replaceFragment(newInstance(HOME_TAB_PPV), false)
                resetFilters()
            }
            R.id.btnComingSoon -> {
                (activity as NewHomeActivity?)!!.replaceFragment(
                    newInstance(HOME_TAB_COMING_SOON),
                    false
                )
                resetFilters()
            }
            R.id.btnFilter -> {
                val i = Intent(activity, FilterMoviesActivity::class.java)
                startActivity(i)
            }
            R.id.txtFilterOtt -> {
                val filterOtt = Intent(activity, FilterOttActivity::class.java)
                startActivity(filterOtt)
            }
            R.id.txtClearFilter -> clearFilter()
        }
    }

    private fun clearFilter() {
        resetFilters()
        AppConstants.SelectedLanguageList = null
        AppConstants.SelectedGenreList = null
        txtClearFilter!!.visibility = View.GONE
        languageAdapter!!.notifyDataSetChanged()
        genreAdapter!!.notifyDataSetChanged()
        initView()
    }

    fun replaceFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction
        transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.layoutContainerTab, fragment!!)
        transaction.commit()
    }

    private fun Search(newText: String) {
        if (searchContentClass == null) {
            searchContentClass = SearchContentClass(requireActivity(),object : SearchDataListener {
                override fun OnContentListLoaded(all_movies: ArrayList<MovieModel>?) {
                    if (all_movies != null && all_movies.size > 0) {
                        val adp = SearchContentListAdapter(activity!!, all_movies, false)
                        val layoutManager = GridLayoutManager(activity, 2)
                        recyclerSearchList!!.layoutManager = layoutManager
                        recyclerSearchList!!.adapter = adp
                        progress!!.visibility = View.GONE
                        containerSearchList!!.visibility = View.VISIBLE
                    } else {
                        progress!!.visibility = View.GONE
                        containerSearchList!!.visibility = View.GONE
                    }
                }

                override fun onPlaylistLoaded(playlists: ArrayList<UserPlaylistModel>?) {
                }

                override fun onActorsLoaded(actors: ArrayList<ActorModel>?) {
                }

                override fun onPlayListUsersLoaded(playlistUsers: ArrayList<PlaylistUserModel>?) {
                }
            })
        } else {
            searchContentClass!!.stopSearch()
            containerSearchList!!.visibility = View.VISIBLE
        }
        if (progress!!.visibility != View.VISIBLE) {
            progress!!.visibility = View.VISIBLE
        }
        containerSearchList!!.visibility = View.GONE
        searchContentClass!!.searchContent(newText, "content", categoryId, 1, 40)
    }


    private fun languagesList(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getLanguages()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.languageGroup.isNotEmpty()
                            ) {
                                allLanguages.addAll(modelObj.languageGroup)
                                languageAdapter!!.notifyDataSetChanged()
                                genreList()
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

    private fun genreList(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getGenre()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj =
                                responseModel.data
                            if (modelObj.genreGroup.isNotEmpty()) {
                                allGenres.addAll(modelObj.genreGroup)
                                genreAdapter!!.notifyDataSetChanged()
                                ottsList()
                            } else {
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

    private fun ottsList(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getOTTPlatforms()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.ottPlatforms.isNotEmpty()
                            ) {
                                AppConstants.all_otts = modelObj.ottPlatforms
                            }
                        } else {
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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1100 && resultCode == Activity.RESULT_OK) {
            initView()
        }
    }

    companion object {
        fun newInstance(selectedTab: Int): HomeTabFragment {
            val args = Bundle()
            val fragment = HomeTabFragment()
            args.putInt("selectedTab", selectedTab)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onFilterLanguageItemSelected(language: HomeLanguageModel?) {
        if (AppConstants.SelectedLanguageList == null) {
            AppConstants.SelectedLanguageList = ArrayList<HomeLanguageModel>()
            AppConstants.SelectedLanguageList!!.add(language!!)
            txtClearFilter!!.visibility = View.VISIBLE
        } else {
            var listUpdated = false
            for (i in AppConstants.SelectedLanguageList!!.indices) {
                if (AppConstants.SelectedLanguageList!![i].languageGroup
                        .equals(language?.languageGroup , ignoreCase = true)
                ) {
                    AppConstants.SelectedLanguageList!!.removeAt(i)
                    listUpdated = true
                    break
                }
            }
            if (!listUpdated) {
                AppConstants.SelectedLanguageList!!.add(language!!)
            }
        }
        if (AppConstants.SelectedGenreList != null && AppConstants.SelectedGenreList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else if (AppConstants.SelectedLanguageList != null && AppConstants.SelectedLanguageList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else if (AppConstants.SelectedOTTList != null && AppConstants.SelectedOTTList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else {
            if (AppConstants.IsFilterActive) {
                AppConstants.IsFilterActive = false
                AppConstants.ResetFilter = true
            }
        }
        languageAdapter?.notifyDataSetChanged()
        initView()
    }

    override fun onFilterGenreItemSelected(genre: HomeGenreModel?) {
        if (AppConstants.SelectedGenreList == null) {
            AppConstants.SelectedGenreList = ArrayList<HomeGenreModel>()
            AppConstants.SelectedGenreList!!.add(genre!!)
            txtClearFilter!!.visibility = View.VISIBLE
        } else {
            var listUpdated = false
            for (i in AppConstants.SelectedGenreList!!.indices) {
                if (AppConstants.SelectedGenreList!![i].genreGroup
                        .equals(genre?.genreGroup , ignoreCase = true)
                ) {
                    AppConstants.SelectedGenreList!!.removeAt(i)
                    listUpdated = true
                    break
                }
            }
            if (!listUpdated) {
                AppConstants.SelectedGenreList!!.add(genre!!)
            }
        }
        if (AppConstants.SelectedGenreList != null && AppConstants.SelectedGenreList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else if (AppConstants.SelectedLanguageList != null && AppConstants.SelectedLanguageList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else if (AppConstants.SelectedOTTList != null && AppConstants.SelectedOTTList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else {
            if (AppConstants.IsFilterActive) {
                AppConstants.IsFilterActive = false
                AppConstants.ResetFilter = true
            }
        }
        genreAdapter?.notifyDataSetChanged()
        initView()
    }
}
