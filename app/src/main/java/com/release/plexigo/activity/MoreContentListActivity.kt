package com.release.plexigo.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.Volley
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.SearchContentListAdapter
import com.release.plexigo.models.MovieModel
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_more_content_list.*
import kotlinx.android.synthetic.main.activity_more_content_list.movies_list
import kotlinx.android.synthetic.main.activity_more_content_list.progressbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MoreContentListActivity : AppCompatActivity() {
    var movieList: ArrayList<MovieModel>? = null
    var PageCount = 1
    var Limit = 20
    var CurrentPageCount = 1
    var TotalPageCount = 1
    var endOfList = false
    var isLoading = false
    var categoryId = 0
    var adapter: SearchContentListAdapter? = null
    var queue: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_content_list)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener(View.OnClickListener { onBackPressed() })
        supportActionBar!!.setTitle(intent.getStringExtra("section"))
        categoryId = intent.getIntExtra("id", 0)
        queue = Volley.newRequestQueue(this@MoreContentListActivity)
        GetMovieListing()

        movies_list.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //Load more data
                    if (endOfList) {
                        return
                    }
                    if (CurrentPageCount != TotalPageCount && !isLoading) {
                        isLoading = true
                        CurrentPageCount++
                        PageCount++
                        GetMovieListing()
                    } else {
                        endOfList = true
                    }
                }
            }
        })
    }

    private fun GetMovieListing() {
        Showloader()
        val apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getMovieListing(
                categoryId,
                PageCount,
                Limit,
                Integer.valueOf(if (AppConstants.UserId == null) "0" else AppConstants.UserId)
            )
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            AppConstants.showOttFilters = model.displayOTT == "Y"
                            TotalPageCount = model.pageCount
                            if (movieList != null && movieList!!.size > 0) {
                                if (model.content != null && model.content.size > 0) {
                                    movieList!!.addAll(model.content)
                                    adapter!!.notifyDataSetChanged()
                                    isLoading = false
                                }
                            } else {
                                movieList = model.content
                                if (movieList != null && movieList!!.size > 0) {
                                    adapter = SearchContentListAdapter(
                                        this@MoreContentListActivity,
                                        movieList!!,
                                        false
                                    )
                                    val layoutManager =
                                        GridLayoutManager(this@MoreContentListActivity, 2)
                                    movies_list!!.layoutManager = layoutManager
                                    movies_list!!.adapter = adapter
                                } else {
                                    movies_list!!.visibility = View.GONE
                                }
                            }
                            HideLoader()
                        } else {
                            HideLoader()
                            Toast.makeText(
                                this@MoreContentListActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@MoreContentListActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@MoreContentListActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@MoreContentListActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@MoreContentListActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    fun Showloader() {
        progressbar!!.visibility = View.VISIBLE
    }

    fun HideLoader() {
        progressbar!!.visibility = View.GONE
    }
}