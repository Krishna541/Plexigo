package com.release.plexigo.fragment

import android.content.res.Resources
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.core.JsonProcessingException
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.activity.NewHomeActivity
import com.release.plexigo.adapter.OffersAdapter
import com.release.plexigo.models.OfferModel
import com.release.plexigo.models.OffersResponseModel
import com.release.plexigo.models.PopularInAreaListRequest
import com.release.plexigo.models.SearchMoviesRequestModel
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


class OffersDialogFragment : DialogFragment(), OffersAdapter.OnOfferClick {
    private lateinit var recyclerOffers: RecyclerView
    lateinit var apiInterface: APIInterface
    private lateinit var btnCancel: ImageView
    private lateinit var btnExploreMore: Button
    private lateinit var txtNoOffers: TextView
    var queue: RequestQueue? = null
    private val offerList = ArrayList<OfferModel>()
    private var offersAdapter: OffersAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isCancelable = false
        val view = inflater.inflate(R.layout.fragment_dialog_offers, container, false)
        val root = view.findViewById<ConstraintLayout>(R.id.root)
        val params = root.layoutParams
        params.width = Resources.getSystem().displayMetrics.widthPixels - 200
        params.height = (Resources.getSystem().displayMetrics.heightPixels / 1.5).toInt()
        root.layoutParams = params
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        queue = Volley.newRequestQueue(activity)
        initView(view)
        initData()
    }

    private fun initView(view: View) {
        recyclerOffers = view.findViewById(R.id.recyclerOffers)
        btnCancel = view.findViewById(R.id.btnCancel)
        btnExploreMore = view.findViewById(R.id.btnExploreMore)
        txtNoOffers = view.findViewById(R.id.txtNoOffers)
        offersAdapter = OffersAdapter(requireContext(),offerList, false, this)
        recyclerOffers.setAdapter(offersAdapter)
        btnCancel.setOnClickListener(View.OnClickListener { dismiss() })
        btnExploreMore.setOnClickListener(View.OnClickListener {
            dismiss()
            (activity as NewHomeActivity?)!!.replaceFragment(HomeChannelFragment.newInstance(), true)
        })
    }

    private fun initData() {
        callOffersApi()
    }

    private fun callOffersApi() {
        showLoader()
        try {

            var user_Id = if (AppConstants.UserId == null) "0"
            else (AppConstants.UserId)!!.toInt()

            val requestObj = JSONObject()
            if (!TextUtils.isEmpty(AppConstants.UserId)) {
                requestObj.put("UserId",
                    Integer.valueOf(AppConstants.UserId))
            } else {
                requestObj.put("UserId", 0)
            }
            requestObj.put("PageNo", 1)
            requestObj.put("NumberOfRecord", 10)



            val request = PopularInAreaListRequest(user_Id as Int,
                1, 10 )

            CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getBundleListing(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            val msg: String? = null
                            try {
                                val responseModel = NewHomeActivity.mapper!!.readValue(
                                    response.toString(),
                                    OffersResponseModel::class.java
                                )
                                if (responseModel.statusCode != null && responseModel.statusCode == "200") {
                                    hideLoader()
                                    val dataModel = responseModel.data
                                    if (dataModel.bundles != null && dataModel.bundles.size > 0) {
                                        offerList.clear()
                                        offerList.addAll(dataModel.bundles)
                                        offersAdapter!!.notifyDataSetChanged()
                                    } else {
                                        recyclerOffers!!.visibility = View.GONE
                                        txtNoOffers!!.visibility = View.VISIBLE
                                    }
                                } else {
                                    hideLoader()
                                    txtNoOffers!!.visibility = View.VISIBLE
                                }
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                                hideLoader()
                                txtNoOffers!!.visibility = View.VISIBLE
                            }
                        }


                    }
                    catch (e: HttpException) {
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

    fun showLoader() {
        if (customProgressDialog == null) customProgressDialog = CustomProgressDialog.newInstance()
        val ft = requireActivity().supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.isCancelable = false
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    override fun onOfferClicked(offer: OfferModel?) {}

    companion object {
        lateinit var customProgressDialog: CustomProgressDialog
    }
}