package com.release.plexigo.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.android.volley.*
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.OnBoardingPagerAdapter
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_on_boarding.*
import kotlinx.android.synthetic.main.fragment_movie_listing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException


class OnBoardingActivity : AppCompatActivity(), View.OnClickListener {



    private val onBoardingQuestions: ArrayList<OnBoardingModel>? = ArrayList()
    private val onBoardingQuestionsMovies = ArrayList<OnBoardingModel>()
    private val onBoardingQuestionsActors = ArrayList<OnBoardingModel>()
    private val onBoardingUserResponse = ArrayList<OnBoardingRequestModel>()
    private var currentItem: OnBoardingModel? = null
    private var userContentCount = 0
    private var minContentCount = 0
    private var userActorCount = 0
    private var minActorCount = 0
    lateinit var apiInterface: APIInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        initView()
        initData()
    }

    private fun initView() {
        hideSystemUI()
        btnSkip.setOnClickListener(this)
        sliderOnBoardingMovies.setCycle(false)
        sliderOnBoardingMovies.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                currentItem = onBoardingQuestionsMovies[position]
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        sliderOnBoardingActor.setCycle(false)
        sliderOnBoardingActor.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                currentItem = onBoardingQuestionsActors[position]
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun initData() {
        onBoardingData()
    }

    override fun onClick(v: View) {
        var responseUpdated = false
        when (v.id) {
            R.id.btnLike -> {
                for (userResponse in onBoardingUserResponse) {
                    if (currentItem!!.obdid == userResponse.obdid) {
                        userResponse.response = "likes"
                        responseUpdated = true
                        break
                    }
                }
                if (!responseUpdated) {
                    onBoardingUserResponse.add(
                        OnBoardingRequestModel(
                            currentItem!!.obdid,
                            currentItem!!.type,
                            "likes"
                        )
                    )
                }
                if (sliderOnBoardingMovies!!.visibility == View.VISIBLE) {
                    sliderOnBoardingMovies!!.scrollOnce()
                } else {
                    sliderOnBoardingActor!!.scrollOnce()
                }
                updateRemainingCount()
            }
            R.id.btnDislike -> {
                for (userResponse in onBoardingUserResponse) {
                    if (currentItem!!.obdid == userResponse.obdid) {
                        userResponse.response = "dislikes"
                        responseUpdated = true
                        break
                    }
                }
                if (!responseUpdated) {
                    onBoardingUserResponse.add(
                        OnBoardingRequestModel(
                            currentItem!!.obdid,
                            currentItem!!.type,
                            "dislikes"
                        )
                    )
                }
                if (sliderOnBoardingMovies!!.visibility == View.VISIBLE) {
                    sliderOnBoardingMovies!!.scrollOnce()
                } else {
                    sliderOnBoardingActor!!.scrollOnce()
                }
                updateRemainingCount()
            }
            R.id.btnNoIdea ->
                if (sliderOnBoardingMovies!!.visibility == View.VISIBLE) {
                if (currentItem!!.obdid == onBoardingQuestionsMovies[onBoardingQuestionsMovies.size - 1].obdid) {
                    if (userActorCount >= minActorCount) {
                        btnSkip!!.performClick()
                    } else {
                        val adp = OnBoardingPagerAdapter(
                            supportFragmentManager,
                            onBoardingQuestionsActors
                        )
                        sliderOnBoardingActor!!.adapter = adp
                        currentItem = onBoardingQuestionsActors[0]
                        sliderOnBoardingActor!!.currentItem = 0
                        txtRateTitlePerson!!.text = "Finally, rate these personalities"
                        txtRemainingQuestion!!.text =
                            "Just " + (minActorCount - userActorCount) + " to go..."
                        sliderOnBoardingMovies!!.visibility = View.GONE
                        sliderOnBoardingActor!!.visibility = View.VISIBLE
                    }
                } else {
                    sliderOnBoardingMovies!!.scrollOnce()
                }
            } else {
                if (currentItem!!.obdid == onBoardingQuestionsActors[onBoardingQuestionsActors.size - 1].obdid) {
                    btnSkip!!.performClick()
                } else {
                    sliderOnBoardingActor!!.scrollOnce()
                }
            }
            R.id.btnSkip -> if (onBoardingUserResponse.size > 0) saveOnBoardingData() else navigateToDashboard()
        }
    }

    private fun updateRemainingCount() {
        if (sliderOnBoardingMovies!!.visibility == View.VISIBLE) {
            userContentCount++
            if (userContentCount >= minContentCount) {
                if (userActorCount >= minActorCount) {
                    btnSkip!!.performClick()
                } else {
                    val adp =
                        OnBoardingPagerAdapter(supportFragmentManager, onBoardingQuestionsActors)
                    sliderOnBoardingActor!!.adapter = adp
                    currentItem = onBoardingQuestionsActors[0]
                    sliderOnBoardingActor!!.currentItem = 0
                    txtRateTitlePerson!!.text = "Finally, rate these personalities"
                    txtRemainingQuestion!!.text =
                        "Just " + (minActorCount - userActorCount) + " to go..."
                    sliderOnBoardingMovies!!.visibility = View.GONE
                    sliderOnBoardingActor!!.visibility = View.VISIBLE
                }
            } else {
                if (currentItem!!.obdid == onBoardingQuestionsMovies[onBoardingQuestionsMovies.size - 1].obdid) {
                    val adp =
                        OnBoardingPagerAdapter(supportFragmentManager, onBoardingQuestionsActors)
                    sliderOnBoardingActor!!.adapter = adp
                    currentItem = onBoardingQuestionsActors[0]
                    sliderOnBoardingActor!!.currentItem = 0
                    txtRateTitlePerson!!.text = "Finally, rate these personalities"
                    txtRemainingQuestion!!.text =
                        "Just " + (minActorCount - userActorCount) + " to go..."
                    sliderOnBoardingMovies!!.visibility = View.GONE
                    sliderOnBoardingActor!!.visibility = View.VISIBLE
                } else {
                    txtRemainingQuestion!!.text =
                        "Good job! Just " + (minContentCount - userContentCount) + " to go..."
                }
            }
        } else {
            userActorCount++
            if (userActorCount >= minActorCount) {
                btnSkip!!.performClick()
            } else {
                if (currentItem!!.obdid == onBoardingQuestionsActors[onBoardingQuestionsActors.size - 1].obdid) {
                    btnSkip!!.performClick()
                } else {
                    txtRemainingQuestion!!.text =
                        "Almost there! Just " + (minActorCount - userActorCount) + " to go..."
                }
            }
        }
    }

    fun showLoader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = this@OnBoardingActivity.supportFragmentManager.beginTransaction()
        customProgressDialog.show(ft, "dialog")
        customProgressDialog.setCancelable(false)
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    private fun hideSystemUI() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }

    fun onBoardingData() {
        showLoader()
        val request = AppConstants.UserId
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getOnBoardingData(request!!)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val dataModel = responseModel.data
                            userContentCount = dataModel.userContentcount
                            minContentCount = dataModel.minContentcount
                            userActorCount = dataModel.userActorcount
                            minActorCount = dataModel.minActorcount

                            onBoardingQuestions!!.clear()
                            onBoardingQuestions.addAll(dataModel.onboarding)
                            for (onBoardingModel in onBoardingQuestions) {
                                if (onBoardingModel.type.equals(
                                        "Content",
                                        ignoreCase = true
                                    )
                                ) {
                                    onBoardingQuestionsMovies.add(onBoardingModel)
                                } else {
                                    onBoardingQuestionsActors.add(onBoardingModel)
                                }
                            }
                            if (onBoardingQuestions.size > 0) {
                                Log.d(
                                    "onBoard",
                                    "onBoardingData: movies" + onBoardingQuestionsMovies + "lsls" + userContentCount + minContentCount
                                )
                                if (userContentCount < minContentCount) {
                                    val adp = OnBoardingPagerAdapter(
                                        supportFragmentManager,
                                        onBoardingQuestionsMovies
                                    )
                                    sliderOnBoardingMovies.adapter = adp
                                    currentItem = onBoardingQuestionsMovies[0]
                                    sliderOnBoardingMovies.currentItem = 0
                                    txtRateTitlePerson.text = "Please rate these titles"
                                    txtRemainingQuestion.text =
                                        "Just " + (minContentCount - userContentCount) + " to go..."
                                    sliderOnBoardingMovies.visibility = View.VISIBLE
                                    sliderOnBoardingActor.visibility = View.GONE
                                } else {
                                    if (userActorCount < minActorCount) {
                                        val adp = OnBoardingPagerAdapter(
                                            supportFragmentManager,
                                            onBoardingQuestionsActors
                                        )
                                        sliderOnBoardingActor!!.adapter = adp
                                        currentItem = onBoardingQuestionsActors[0]
                                        sliderOnBoardingActor!!.currentItem = 0
                                        txtRateTitlePerson!!.text =
                                            "Rate these personalities"
                                        txtRemainingQuestion!!.text =
                                            "Just " + (minActorCount - userActorCount) + " to go..."
                                        sliderOnBoardingMovies!!.visibility = View.GONE
                                        sliderOnBoardingActor!!.visibility = View.VISIBLE
                                    } else {
                                    }
                                }

                                btnDislike!!.setOnClickListener(this@OnBoardingActivity)
                                btnLike!!.setOnClickListener(this@OnBoardingActivity)
                                btnNoIdea!!.setOnClickListener(this@OnBoardingActivity)
                            } else {
                                sliderOnBoardingMovies!!.visibility = View.GONE
                                sliderOnBoardingActor!!.visibility = View.GONE
                            }
                        } else {
                            Toast.makeText(
                                this@OnBoardingActivity,
                                "" + responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(
                        this@OnBoardingActivity,
                        "${e.message}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } catch (e: Throwable) {
                    Toast.makeText(
                        this@OnBoardingActivity,
                        "${e.message}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }
    }

    private fun saveOnBoardingData(){
        showLoader()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request = SaveOnBoardingRequest(Integer.valueOf(AppConstants.UserId),
            onBoardingUserResponse
        )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.saveOnBoardingData(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            navigateToDashboard()
                        }else{
                            Toast.makeText(this@OnBoardingActivity, "" + responseModel?.status, Toast.LENGTH_SHORT).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@OnBoardingActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (error: Throwable) {
                    if (error is TimeoutError) {
                        Toast.makeText(
                            this@OnBoardingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (error.cause is IOException) {
                        Toast.makeText(
                            this@OnBoardingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@OnBoardingActivity,
                        "" + error.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun navigateToDashboard() {
        val intent = Intent(this, NewHomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        lateinit var customProgressDialog: CustomProgressDialog
    }
}