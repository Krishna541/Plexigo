package com.release.plexigo.activity

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.fasterxml.jackson.core.JsonProcessingException
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.FestivalEventArrayAdapter
import com.release.plexigo.adapter.FestivalScreeningArrayAdapter
import com.release.plexigo.adapter.FilmEventsAdapter
import com.release.plexigo.adapter.FilmScreeningsAdapter
import com.release.plexigo.models.*
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_edit_profile.back_btn
import kotlinx.android.synthetic.main.activity_festival_content_listing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.util.ArrayList
import java.util.HashMap


class FestivalContentListingActivity : AppCompatActivity(), View.OnClickListener {
    var queue: RequestQueue? = null
    lateinit var apiInterface: APIInterface

    private var spnScreenings: Spinner? = null
    private var spnEvents: Spinner? = null

    private var selectedFilmScreening: FilmScreening? = null
    var filmScreenings = ArrayList<FilmScreening>()
    var filmScreeningData = ArrayList<FilmScreeningData>()
    private var filmScreeningAdapter: FilmScreeningsAdapter? = null
    private var selectedFilmEvent: FilmEvent? = null
    var filmEvents = ArrayList<FilmEvent>()
    var filmEventData = ArrayList<FilmEventData>()
    private var filmEventsAdapter: FilmEventsAdapter? = null
    private var festivalId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_festival_content_listing)
        queue = Volley.newRequestQueue(this)
        initView()
        initData()
    }

    private fun initView() {
        spnEvents = findViewById(R.id.spnEvents)
        spnScreenings = findViewById(R.id.spnScreenings)
        back_btn.setOnClickListener(this)
    }

    private fun initData() {
        filmEventsAdapter = FilmEventsAdapter(this, filmEventData)
        filmScreeningAdapter = FilmScreeningsAdapter(this, filmScreeningData)
        recyclerEvents!!.adapter = filmEventsAdapter
        recyclerScreening!!.adapter = filmScreeningAdapter
        festivalId = intent.getIntExtra("channelId", 0)
        festivalDetails()
    }

    fun showLoader() {
        if (FestivalContentListingActivity.Companion.customProgressDialog == null)
            FestivalContentListingActivity.Companion.customProgressDialog =
            CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        FestivalContentListingActivity.Companion.customProgressDialog.show(ft, "dialog")
        FestivalContentListingActivity.Companion.customProgressDialog.setCancelable(false)
    }

    fun hideLoader() {
        if (FestivalContentListingActivity.Companion.customProgressDialog != null)
            FestivalContentListingActivity.Companion.customProgressDialog.dismiss()
    }//This is for Headers If You Needed

    //successresponseModel.getStatus()
    private fun festivalDetails() {
            showLoader()
        try{
        val request = festivalId

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getfestivalDetails(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        try {
                            val responseModel = response.body()
                            if (responseModel?.statusCode != null && responseModel?.statusCode == "200") {
                                //successresponseModel.getStatus()
                                val model = responseModel.festivalDataResponseModel
                                txtFestivalTitle!!.text = model.festival[0].filmFestivalName
                                GlideApp
                                    .with(this@FestivalContentListingActivity)
                                    .load(model.festival[0].imagePath)
                                    .circleCrop()
                                    .placeholder(R.drawable.plexigo_new_transperent_logo)
                                    .into(imgFestival)
                                if (model.festival[0] != null && model.festival[0].events != null && model.festival[0].events.size > 0) {
                                    txtTitleEvents!!.visibility = View.VISIBLE
                                    spnEvents!!.visibility = View.VISIBLE
                                    filmEvents.addAll(model.festival[0].events)
                                    selectedFilmEvent = filmEvents[0]
                                    if (selectedFilmEvent!!.event != null && selectedFilmEvent!!.event.size > 0) {
                                        filmEventData.addAll(selectedFilmEvent!!.event)
                                        filmEventsAdapter!!.notifyDataSetChanged()
                                    }
                                    txtEventTime!!.text =
                                        selectedFilmEvent!!.eventStartTime + " - " + selectedFilmEvent!!.eventEndTime
                                    val eventDateAdapter = FestivalEventArrayAdapter(
                                        this@FestivalContentListingActivity,
                                        android.R.layout.simple_spinner_item,
                                        filmEvents
                                    )
                                    spnEvents!!.adapter = eventDateAdapter
                                    spnEvents!!.onItemSelectedListener =
                                        object : AdapterView.OnItemSelectedListener {
                                            override fun onItemSelected(
                                                parent: AdapterView<*>?,
                                                view: View?,
                                                position: Int,
                                                id: Long
                                            ) {
                                                selectedFilmEvent = filmEvents[position]
                                                txtEventTime!!.text =
                                                    selectedFilmEvent!!.eventStartTime + " - " + selectedFilmEvent!!.eventEndTime
                                                filmEventData.clear()
                                                filmEventData.addAll(selectedFilmEvent!!.event)
                                                filmEventsAdapter!!.notifyDataSetChanged()
                                            }

                                            override fun onNothingSelected(parent: AdapterView<*>?) {}
                                        }
                                } else {
                                    txtTitleEvents!!.visibility = View.GONE
                                    spnEvents!!.visibility = View.GONE
                                }
                                if (model.festival[0] != null && model.festival[0].screenings != null && model.festival[0].screenings.size > 0) {
                                    txtTitleScreenings!!.visibility = View.VISIBLE
                                    spnScreenings!!.visibility = View.VISIBLE
                                    filmScreenings.addAll(model.festival[0].screenings)
                                    selectedFilmScreening = filmScreenings[0]
                                    if (selectedFilmScreening!!.screening != null && selectedFilmScreening!!.screening.size > 0) {
                                        filmScreeningData.addAll(selectedFilmScreening!!.screening)
                                        filmScreeningAdapter!!.notifyDataSetChanged()
                                    }
                                    txtScreeningTime!!.text =
                                        selectedFilmScreening!!.screeningStartTime + " - " + selectedFilmScreening!!.screeningEndTime
                                    val screeningDateAdapter = FestivalScreeningArrayAdapter(
                                        this@FestivalContentListingActivity,
                                        android.R.layout.simple_spinner_item,
                                        filmScreenings
                                    )
                                    spnScreenings!!.adapter = screeningDateAdapter
                                    spnScreenings!!.onItemSelectedListener =
                                        object : AdapterView.OnItemSelectedListener {
                                            override fun onItemSelected(
                                                parent: AdapterView<*>?,
                                                view: View?,
                                                position: Int,
                                                id: Long
                                            ) {
                                                selectedFilmScreening = filmScreenings[position]
                                                txtScreeningTime!!.text =
                                                    selectedFilmScreening!!.screeningStartTime + " - " + selectedFilmScreening!!.screeningEndTime
                                                filmScreeningData.clear()
                                                filmScreeningData.addAll(selectedFilmScreening!!.screening)
                                                filmScreeningAdapter!!.notifyDataSetChanged()
                                            }

                                            override fun onNothingSelected(parent: AdapterView<*>?) {}
                                        }
                                } else {
                                    txtTitleScreenings!!.visibility = View.GONE
                                    spnScreenings!!.visibility = View.GONE
                                }
                            }
                        } catch (e: JsonProcessingException) {
                            e.printStackTrace()
                        }
                    }
                }
                catch (e: HttpException) {
                    Toast.makeText(this@FestivalContentListingActivity, "${e.message}", Toast.LENGTH_SHORT).show()
                } catch (e: Throwable) {
                    Toast.makeText(this@FestivalContentListingActivity, "${e.message}", Toast.LENGTH_SHORT).show()
                }
                catch (e: TimeoutError) {
                    Toast.makeText(this@FestivalContentListingActivity, R.string.timeout_message, Toast.LENGTH_SHORT).show()
                }
                catch (e: IOException) { Toast.makeText(this@FestivalContentListingActivity, getString(R.string.internet_not_available), Toast.LENGTH_SHORT).show()
                }

            }}
        }
        catch (e: Exception) {
            hideLoader()
            e.printStackTrace()
            Toast.makeText(this, "" + e.printStackTrace().toString(), Toast.LENGTH_SHORT).show()

        }

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.back_btn -> onBackPressed()
        }
    }

    companion object {
        lateinit var customProgressDialog: CustomProgressDialog
    }
}