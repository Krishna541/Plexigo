package com.release.plexigo.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.TimeoutError
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.SearchContentListAdapter
import com.release.plexigo.models.LikeDisLikeActorRequest
import com.release.plexigo.models.MovieModel
import com.release.plexigo.models.SearchMoviesByActorRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_cast_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class CastDetailActivity : AppCompatActivity() {
    lateinit var customProgressDialog: CustomProgressDialog
    private var actorId = 0
    var PageCount = 1
    var Limit:Int = 20
    var CurrentPageCount:Int = 1
    var TotalPageCount:Int = 1
    var endOfList = false
    var isLoading = false
    var movieList: ArrayList<MovieModel>? = ArrayList()
    var queue: RequestQueue? = null
    var searchContentListAdapter: SearchContentListAdapter? = null
    private var userLike = 0
    lateinit var apiInterface: APIInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cast_detail)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val name = intent.getStringExtra("name")
        val imagepath = intent.getStringExtra("imagepath")
        actorId = intent.getIntExtra("castCrewId", 0)
        backBtn.setOnClickListener { onBackPressed() }
        back_btn.setOnClickListener { onBackPressed() }
        if (actorId == 0) {
            mainLayout.visibility = View.GONE
            layoutNoData.visibility = View.VISIBLE
        } else {
            mainLayout.visibility = View.VISIBLE
            layoutNoData.visibility = View.GONE
            setStarCastData(name, imagepath)
        }
        recyclerFilmography.addOnScrollListener(object : RecyclerView.OnScrollListener() {
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
                        searchMoviesByActor()
                    } else {
                        endOfList = true
                    }
                }
            }
        })
        btnLike.setOnClickListener(View.OnClickListener {
            if (AppConstants.isUserLoggedIn) {
                val likeReset: Int = if (userLike == 1) {
                    0
                } else {
                    1
                }
                callLikeDislikeActor(likeReset)
            } else {
                val intent1 = Intent(this@CastDetailActivity, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
        })
        btnDislike.setOnClickListener(View.OnClickListener {
            if (AppConstants.isUserLoggedIn) {
                val likeReset: Int = if (userLike == 2) {
                    0
                } else {
                    2
                }
                callLikeDislikeActor(likeReset)
            } else {
                val intent1 = Intent(this@CastDetailActivity, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            }
        })
    }

    private fun callLikeDislikeActor(likeDislikeReset: Int){
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request : LikeDisLikeActorRequest = LikeDisLikeActorRequest(actorId,(if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt(),likeDislikeReset )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.callLikeDislikeActor(request)
            withContext(Dispatchers.Main){
                try {
                    if (response.isSuccessful) {
                        if(response.code() == 200) {
                            getActorDetail(false)
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@CastDetailActivity, "${e.message}", Toast.LENGTH_SHORT).show()
                } catch (error: Throwable) {
                    if (error is TimeoutError) {
                        Toast.makeText(
                            this@CastDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (error.cause is IOException) {
                        Toast.makeText(
                            this@CastDetailActivity,
                            this@CastDetailActivity.getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@CastDetailActivity,
                        "" + error.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    fun setStarCastData(name: String?, imagepath: String?) {
        txtActorName!!.text = name
        if (!TextUtils.isEmpty(imagepath)) {
            GlideApp
                .with(this)
                .load(imagepath)
                .circleCrop()
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .into(imgActor)
        }
        getActorDetail(true)
    }

    fun showLoader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog.show(ft, "dialog")
        customProgressDialog.setCancelable(false)
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    fun searchMoviesByActor(){
        showLoader()
        val request = SearchMoviesByActorRequest(actorId, (if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt(),PageCount,Limit)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getContentByActor(request)
            withContext(Dispatchers.Main){
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            TotalPageCount = model.pageCount
                            if (movieList != null && movieList!!.size > 0) {
                                if (model.content.isNotEmpty()) {
                                    movieList!!.addAll(model.content)
                                    searchContentListAdapter!!.notifyDataSetChanged()
                                    isLoading = false
                                }
                            } else {
                                movieList = model.content as ArrayList<MovieModel>
                                AppConstants.all_languages = model.languageGroup
                                if (movieList != null && movieList!!.size > 0) {
                                    recyclerFilmography!!.visibility = View.VISIBLE
                                    searchContentListAdapter = SearchContentListAdapter(
                                        recyclerFilmography!!.context, movieList!!, false
                                    )
                                    recyclerFilmography!!.adapter = searchContentListAdapter
                                } else {
                                    recyclerFilmography!!.visibility = View.GONE
                                }
                            }
                        } else {
                            val model = responseModel!!.data
                            Toast.makeText(
                                this@CastDetailActivity,
                                "" + model.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@CastDetailActivity, "${e.message}", Toast.LENGTH_SHORT).show()
                } catch (error: Throwable) {
                    hideLoader()
                    if (error is TimeoutError) {
                        Toast.makeText(
                            this@CastDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (error.cause is IOException) {
                        Toast.makeText(
                            this@CastDetailActivity,
                            this@CastDetailActivity.getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@CastDetailActivity,
                        "" + error.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    fun getActorDetail(isFromOnCreate: Boolean){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getActorDetail(actorId,(if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt())
            withContext(Dispatchers.Main){
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()!!
                        val model = responseModel.data
                        if (responseModel.statusCode != null && responseModel.statusCode == "200") {
                            if (!model.actordetail.isEmpty() || model.actordetail.size != 0) {
                                userLike = model.actordetail[0].userLikes
                                when (userLike) {
                                    0 -> {
                                        txtAreYouFan!!.text = "Are you a fan?"
                                        btnDislike.setVisibility(View.VISIBLE)
                                        btnLike!!.visibility = View.VISIBLE
                                    }
                                    1 -> {
                                        btnLike!!.visibility = View.VISIBLE
                                        btnDislike.setVisibility(View.GONE)
                                        txtAreYouFan!!.text = "You're a fan!"
                                    }
                                    2 -> {
                                        btnDislike.setVisibility(View.VISIBLE)
                                        btnLike!!.visibility = View.GONE
                                        txtAreYouFan!!.text = "Not a fan!"
                                    }
                                }
                            } else {
                            }
                        } else {
                            Toast.makeText(
                                this@CastDetailActivity,
                                "" + model.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                    if (isFromOnCreate) {
                        searchMoviesByActor()
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@CastDetailActivity, "${e.message}", Toast.LENGTH_SHORT).show()
                } catch (error: Throwable) {
                    hideLoader()
                    if (isFromOnCreate) {
                        searchMoviesByActor()
                    }
                    if (error is TimeoutError) {
                        Toast.makeText(
                            this@CastDetailActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (error.cause is IOException) {
                        Toast.makeText(
                            this@CastDetailActivity,
                            this@CastDetailActivity.getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@CastDetailActivity,
                        "" + error.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }



}