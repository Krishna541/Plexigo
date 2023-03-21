package com.release.plexigo.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.android.volley.*
import com.android.volley.toolbox.Volley
import com.release.plexigo.adapter.QuickPickPagerAdapter
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.models.MovieModel
import com.release.plexigo.models.QuickPickDataRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_quick_pick.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class QuickPickActivity : AppCompatActivity() {
    var queue: RequestQueue? = null
    private val movies: ArrayList<MovieModel>? = ArrayList()
    lateinit var apiInterface: APIInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_pick)
        hideSystemUI()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        bannerPicksForYou.clipToPadding = false
        bannerPicksForYou.pageMargin = 30
        bannerPicksForYou.setPadding(80, 0, 80, 0)
        queue = Volley.newRequestQueue(this)
        findViewById<View>(R.id.back_btn).setOnClickListener { onBackPressed() }
        quickPickData()
        btnViewDetails.setOnClickListener(View.OnClickListener { v ->
            val movie = movies!![bannerPicksForYou.currentItem]
            if (TextUtils.isEmpty(movie.externalWebLink)) {
                val intent = Intent(this@QuickPickActivity, ContentDetailActivity::class.java)
                intent.putExtra("movieId", movie.contentId)
                intent.putExtra("poster_url", movie.imagePath)
                this@QuickPickActivity.startActivity(intent)
            } else {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(movie.externalWebLink)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                if (intent.resolveActivity(v.context.packageManager) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(v.context, "no na", Toast.LENGTH_LONG).show()
                }
            }
        })
        btnSkip.setOnClickListener(View.OnClickListener {
            if (movies!!.size > 1) {
                if (bannerPicksForYou.currentItem == movies.size - 1) {
                    bannerPicksForYou.currentItem = 0
                } else {
                    bannerPicksForYou.scrollOnce()
                }
            } else {
                onBackPressed()
            }
        })
        bannerPicksForYou.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                txtGenre.text = movies!![position].genere
                txtLanguageDuration.text = movies[position].language + " . " + movies[position].duration
                txtMovieSynopsis.text = movies[position].synopsis
                txtMovieSynopsis.movementMethod = ScrollingMovementMethod()
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }//This is for Headers If You Needed

    //                                    imageSlider.startAutoScroll(5000);
    private fun quickPickData(){
        showLoader()
        val request = QuickPickDataRequest((if (AppConstants.UserId == null) "0" else AppConstants.UserId)!!.toInt())
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getQuickPickData(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if(responseModel?.statusCode != null && responseModel.statusCode == "200"){
                            movies!!.clear()
                            movies.addAll(responseModel.data.content)
                            if (movies.size > 0) {
                                val adp = QuickPickPagerAdapter(
                                    supportFragmentManager, movies
                                )
                                bannerPicksForYou!!.adapter = adp
                                bannerPicksForYou!!.currentItem = 0
                                bannerPicksForYou!!.visibility = View.VISIBLE
                                //                                    imageSlider.startAutoScroll(5000);
                                txtGenre!!.text = movies[0].genere
                                txtLanguageDuration!!.text =
                                    movies[0].language + " . " + movies[0].duration
                                txtMovieSynopsis!!.text = movies[0].synopsis
                                txtMovieSynopsis!!.movementMethod =
                                    ScrollingMovementMethod()
                            } else {
                                bannerPicksForYou!!.visibility = View.GONE
                            }
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@QuickPickActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@QuickPickActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@QuickPickActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@QuickPickActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    fun showLoader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = this@QuickPickActivity.supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.setCancelable(false)
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    private fun hideSystemUI() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}