package com.release.plexigo.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonMappingException
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.GenreListAdapter
import com.release.plexigo.adapter.LanguageFilterAdapter
import com.release.plexigo.adapter.OTTFilterAdapter
import com.release.plexigo.adapter.SortCategoriesAdapter
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_filter_movies.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class FilterMoviesActivity : AppCompatActivity() {
    var genreFilterAdapter: GenreListAdapter? = null
    var languageFilterAdapter: LanguageFilterAdapter? = null
    var ottFilterAdapter: OTTFilterAdapter? = null
    var isResetWithoutApply = false
    var adapter1: SortCategoriesAdapter? = null
    var queue: RequestQueue? = null
    lateinit var apiInterface : APIInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_movies)
        queue = Volley.newRequestQueue(this@FilterMoviesActivity)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.title = "Filter By"
        nestedScroll.isNestedScrollingEnabled = false
        reset.setOnClickListener(View.OnClickListener {
            if (AppConstants.SelectedGenreList != null && AppConstants.SelectedGenreList!!.size > 0) {
                AppConstants.SelectedGenreList!!.clear()
                AppConstants.SelectedGenreList = null
                genreFilterAdapter!!.notifyDataSetChanged()
            }
            if (AppConstants.SelectedLanguageList != null && AppConstants.SelectedLanguageList!!.size > 0) {
                AppConstants.SelectedLanguageList!!.clear()
                AppConstants.SelectedLanguageList = null
                languageFilterAdapter!!.notifyDataSetChanged()
            }
            if (AppConstants.SelectedOTTList != null && AppConstants.SelectedOTTList!!.size > 0) {
                AppConstants.SelectedOTTList!!.clear()
                AppConstants.SelectedOTTList = null
                OTTFilterAdapter.isAllActive = false
                ottFilterAdapter!!.notifyDataSetChanged()
            }
            isResetWithoutApply = true
            /* if(!AppConstants.defaultSort.equals("defaultSort")){
                        AppConstants.defaultSort ="sortasc";
                        AppConstants.defaultSortposition = 2;
                        adapter1.notifyDataSetChanged();
                    }*/
        })
        apply.setOnClickListener(View.OnClickListener {
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
            if (isResetWithoutApply) {
                isResetWithoutApply = false
            }
            finish()
        })
        toolbar.setNavigationOnClickListener(View.OnClickListener { onBackPressed() })
        if (AppConstants.all_genres != null && AppConstants.all_languages != null && AppConstants.all_otts != null) {
            setData()
        } else {
            GetGenreApi()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (isResetWithoutApply) {
            isResetWithoutApply = false
            AppConstants.IsFilterActive = false
            AppConstants.ResetFilter = true
        }
        finish()
    }

    fun setData() {
        if (AppConstants.all_genres != null && AppConstants.all_genres!!.size > 0) {
            genreFilterAdapter = GenreListAdapter(this@FilterMoviesActivity)
            val LayoutManager = GridLayoutManager(this@FilterMoviesActivity, 2)
            genre_list!!.layoutManager = LayoutManager
            genre_list!!.adapter = genreFilterAdapter
            filter_text!!.visibility = View.VISIBLE
            genreTopLayout!!.visibility = View.VISIBLE
        }
        if (AppConstants.all_languages != null && AppConstants.all_languages!!.size > 0) {
            languageFilterAdapter = LanguageFilterAdapter(this@FilterMoviesActivity)
            val LayoutManagerone = GridLayoutManager(this@FilterMoviesActivity, 2)
            languages!!.layoutManager = LayoutManagerone
            languages!!.adapter = languageFilterAdapter
            sort_text!!.visibility = View.VISIBLE
            LanguageTopLayout!!.visibility = View.VISIBLE
        }
        if (AppConstants.showOttFilters && AppConstants.all_otts != null && AppConstants.all_otts!!.size > 0) {
            ottFilterAdapter = OTTFilterAdapter(this@FilterMoviesActivity)
            val LayoutManager = GridLayoutManager(this@FilterMoviesActivity, 4)
            otts!!.layoutManager = LayoutManager
            otts!!.adapter = ottFilterAdapter
            ott_text!!.visibility = View.VISIBLE
            OTTTopLayout!!.visibility = View.VISIBLE
        }
        button_layout!!.visibility = View.VISIBLE
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

    fun GetGenreApi(){
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getGenre()
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.genreGroup.isNotEmpty()) {
                                AppConstants.all_genres = modelObj.genreGroup
                                GetOTTsApi()
                            } else {
                            }
                        } else {
                            Toast.makeText(
                                this@FilterMoviesActivity,
                                "" + responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@FilterMoviesActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@FilterMoviesActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@FilterMoviesActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@FilterMoviesActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }

    fun GetOTTsApi(){
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getOTTPlatforms()
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.ottPlatforms != null && modelObj.ottPlatforms.size > 0) {
                                AppConstants.all_otts = modelObj.ottPlatforms
                            }
                            languagesList()
                        } else {
                            HideLoader()
                            Toast.makeText(
                                this@FilterMoviesActivity,
                                "" + responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@FilterMoviesActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@FilterMoviesActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@FilterMoviesActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@FilterMoviesActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }

    fun languagesList(){
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getLanguages()
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.languageGroup != null && modelObj.languageGroup.size > 0) {
                                AppConstants.all_languages = modelObj.languageGroup
                                setData()
                                HideLoader()
                            }
                        } else {
                            Toast.makeText(
                                this@FilterMoviesActivity,
                                "" + responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@FilterMoviesActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@FilterMoviesActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@FilterMoviesActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@FilterMoviesActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }


    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}