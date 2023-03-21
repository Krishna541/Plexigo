package com.release.plexigo.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonMappingException
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.ContentMainListAdapter

import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.util.ArrayList


class ChannelCategoryListingActivity : AppCompatActivity() {
    var queue: RequestQueue? = null
    var channelID = 0
    var channelCategoryModelList = ArrayList<ChannelCategoryModel>()
    var recyclerChannelCategories: RecyclerView? = null
    lateinit var apiInterface: APIInterface
    var txtTitle: TextView? = null
    private var channelType: String? = null
    private var userId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel_category_listing)
        queue = Volley.newRequestQueue(this)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        initView()
        initData()
    }

    private fun initView() {
        recyclerChannelCategories = findViewById(R.id.recyclerChannelCategories)
        txtTitle = findViewById(R.id.txtTitle)
    }

    private fun initData() {
        txtTitle!!.text = intent.getStringExtra("title")
        if (intent.hasExtra("channelId")) {
            channelID = intent.getIntExtra("channelId", 0)
            channelType = intent.getStringExtra("type")
            channelCategories()
        }
    }//This is for Headers If You Needed

    //remove empty sections
    private fun channelCategories() {
        Showloader()
        try {
            //val RequestObj = JSONObject()
            if (!TextUtils.isEmpty(AppConstants.UserId)) {
                // RequestObj.put("userId", Integer.valueOf(AppConstants.UserId))
                userId = Integer.valueOf(AppConstants.UserId)
            } else {
                //RequestObj.put("userId", 0)
                userId = 0
            }
            //RequestObj.put("ChannelID", channelID)
            var ChannelID = channelID
            val request1 = ChannelCategoriesRequest(userId, ChannelID)


            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getChannelCategories(request1)
                withContext(Dispatchers.Main) {
                    try {
                        HideLoader()
                        if (response.isSuccessful) {
                            try {
                                val responseModel = response.body()
                                if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                    HideLoader()
                                    val modelObj = responseModel.data
                                    if (modelObj.channelCategories != null && modelObj.channelCategories.size > 0) {
                                        //remove empty sections
                                        for (k in modelObj.channelCategories.indices) {
                                            if (modelObj.channelCategories[k].content.size > 0) {
                                                channelCategoryModelList.add(modelObj.channelCategories[k])
                                            }
                                        }
                                        val adapter = ContentMainListAdapter(
                                            this@ChannelCategoryListingActivity,
                                            channelCategoryModelList, channelID, channelType!!
                                        )
                                        recyclerChannelCategories!!.adapter = adapter
                                    }
                                } else {
                                    HideLoader()
                                    Toast.makeText(
                                        this@ChannelCategoryListingActivity,
                                        "" + responseModel?.status,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } catch (e: JsonMappingException) {
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                            }
                        }


                    } catch (e: HttpException) {
                        Toast.makeText(
                            this@ChannelCategoryListingActivity,
                            "${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    } catch (e: Throwable) {
                        Toast.makeText(
                            this@ChannelCategoryListingActivity,
                            "${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    } catch (e: TimeoutError) {
                        Toast.makeText(
                            this@ChannelCategoryListingActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    } catch (e: IOException) {
                        Toast.makeText(
                            this@ChannelCategoryListingActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }
        } catch (e: Exception) {
            HideLoader()
            e.printStackTrace()
        }

    }

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog.show(ft, "dialog")
        customProgressDialog.setCancelable(false)
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    fun onBackClicked(view: View?) {
        onBackPressed()
    }

    companion object {
        lateinit var customProgressDialog: CustomProgressDialog
    }
}