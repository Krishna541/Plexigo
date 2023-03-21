package com.release.plexigo.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.WorkSource
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.Constants.WsConstants.CheckSVODExpiry
import com.release.plexigo.R
import com.release.plexigo.activity.ChannelCategoryListingActivity
import com.release.plexigo.activity.FestivalContentListingActivity
import com.release.plexigo.activity.WebPaymentActivity
import com.release.plexigo.adapter.PopularChannelsAdapter
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.util.*


class HomeChannelFragment : Fragment(), PopularChannelsAdapter.OnChannelClick {
    var queue: RequestQueue? = null
    lateinit var apiInterface: APIInterface
    lateinit var recyclerViewChannels: RecyclerView
    lateinit var recyclerViewFilmFestivals: RecyclerView
    var channelsAdapter: PopularChannelsAdapter? = null
    var festivalAdapter: PopularChannelsAdapter? = null
    var channels = ArrayList<ChannelFestivalModel>()
    var festivals = ArrayList<ChannelFestivalModel>()
    var layoutChannelContent: FrameLayout? = null
    var txtTitleFilmFestivals: TextView? = null
    var txtTitlePopularChannels: TextView? = null
    var requestCode = 1001
    private val selectedOffer: OfferModel? = null
    private val plan: SubscriptionPlan? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_channel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewChannels = view.findViewById(R.id.recyclerViewChannels)
        recyclerViewFilmFestivals = view.findViewById(R.id.recyclerViewFilmFestivals)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        channelsAdapter = PopularChannelsAdapter(requireActivity(), channels)
        festivalAdapter = PopularChannelsAdapter(requireActivity(), festivals)
        recyclerViewChannels.setAdapter(channelsAdapter)
        recyclerViewFilmFestivals.setAdapter(festivalAdapter)
        txtTitlePopularChannels = view.findViewById(R.id.txtTitlePopularChannels)
        txtTitleFilmFestivals = view.findViewById(R.id.txtTitleFilmFestivals)
        channelsAdapter!!.setOnChannelClickListener(this)
        festivalAdapter!!.setOnChannelClickListener(object : PopularChannelsAdapter.OnChannelClick {
            override fun onChannelClicked(channelId: Int, channelName: String?, type: String?) {
                val intent = Intent(activity, FestivalContentListingActivity::class.java)
                intent.putExtra("channelId", channelId)
                intent.putExtra("title", "$channelName Movies")
                startActivity(intent)
            }
        })
        layoutChannelContent = view.findViewById(R.id.layoutChannelContent)
        queue = Volley.newRequestQueue(activity)
        popularChannels()
    }//This is for Headers If You Needed//                    callOffersApi();//                                callOffersApi();

    //                                callOffersApi();
    fun popularChannels() {
            Showloader()
            try {
                apiInterface = APIClient.getClient("1.2").create(APIInterface::class.java)
                val userid = if (AppConstants.UserId != null) AppConstants.UserId!!.toInt() else 0
                val request1 = userid
                CoroutineScope(Dispatchers.IO).launch {
                    val response = apiInterface.getPopularChannels(userid)
                    withContext(Dispatchers.Main) {
                        try {
                            HideLoader()
                            if (response.isSuccessful) {
                                try {
                                    val responseModel = response.body()
                                    if (responseModel?.statusCode != null && responseModel?.statusCode == "200") {
                                        val modelObj = responseModel.data
                                        if (modelObj.channels != null && modelObj.channels.isNotEmpty()) {
                                            channels.clear()
                                            channels.addAll(modelObj.channels)
                                            channelsAdapter!!.updateList(channels)
                                            txtTitlePopularChannels!!.visibility = View.VISIBLE
                                            if (channels.size > 0) {
                                                recyclerViewChannels!!.visibility = View.VISIBLE
                                            } else {
                                                recyclerViewChannels!!.visibility = View.GONE
                                            }
                                        }
                                        if (modelObj.festival != null && modelObj.festival.size > 0) {
                                            festivals.clear()
                                            festivals.addAll(modelObj.festival)
                                            festivalAdapter!!.updateList(festivals)
                                            txtTitleFilmFestivals!!.visibility = View.VISIBLE
                                            if (festivals.size > 0) {
                                                recyclerViewFilmFestivals!!.visibility = View.VISIBLE
                                            } else {
                                                recyclerViewFilmFestivals!!.visibility = View.GONE
                                            }
                                        }
                                        HideLoader()
                                        //                                callOffersApi();
                                    } else {
                                        HideLoader()
                                        Toast.makeText(
                                            activity,
                                            "" + responseModel?.status,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        //                                callOffersApi();
                                    }
                                }
                                catch (e: HttpException) {
                                    Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT).show()
                                } catch (e: Throwable) {
                                    Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                        catch (e: HttpException) {
                            Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT).show()
                        } catch (e: Throwable) {
                            Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT).show()
                        }
                        catch (e: TimeoutError) {
                            Toast.makeText(activity, R.string.timeout_message, Toast.LENGTH_SHORT).show()
                        }
                        catch (e: IOException) { Toast.makeText(activity, getString(R.string.internet_not_available), Toast.LENGTH_SHORT).show()
                        }

                    }}
            }
            catch (e: Exception) {
                HideLoader()
                e.printStackTrace()
                Toast.makeText(activity, "" + e.printStackTrace().toString(), Toast.LENGTH_SHORT).show()

            }
        }

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = requireActivity().supportFragmentManager.beginTransaction()
        customProgressDialog.show(ft, "dialog")
        customProgressDialog.setCancelable(false)
    }

    fun HideLoader() {
        customProgressDialog!!.dismiss()
    }

    override fun onChannelClicked(channelId: Int, channelName: String?, type: String?) {

        val intent = Intent(activity, ChannelCategoryListingActivity::class.java)
        intent.putExtra("contentByChannel", true)
        intent.putExtra("channelId", channelId)
        intent.putExtra("title", "$channelName Movies")
        intent.putExtra("type", type)
        startActivity(intent)
    }



    private fun checkIfOfferSubscribed(plan: SubscriptionPlan){
        Showloader()
        val request = CheckIfOfferSubscribed(AppConstants.UserId!!.toInt(),plan.subscriptoinPlanId)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.checkIfOfferSubscribed(WsConstants.CheckSVODExpiry,request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.validationStatus == "Valid") { //already paid
                            popularChannels()
                        } else if (responseModel?.validationStatus == "Expired") { //Plan Expired
                            openSvodPopupLayout(plan)
                        } else if (responseModel?.validationStatus == "Not Purchased") { //Plan Expired
                            openSvodPopupLayout(plan)
                        } else {
                            Toast.makeText(
                                activity,
                                "Validation Status " + responseModel?.validationStatus,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (error: Throwable) {
                    HideLoader()
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
    }


    fun openSvodPopupLayout(plan: SubscriptionPlan) {
        val inflater =
            requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.dialog_payment_subscription, null)
        val pwindo = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val imgPlan = layout.findViewById<ImageView>(R.id.imgPlan)
        val skip = layout.findViewById<Button>(R.id.skip)
        val btnCCAvenue = layout.findViewById<Button>(R.id.btnCCAvenue)
        val txtPlanName = layout.findViewById<TextView>(R.id.txtPlanName)
        val txtPlanPrice = layout.findViewById<TextView>(R.id.txtPlanPrice)
        txtPlanPrice.text = "Offer " + "\u20B9 " + plan.inr + "/- " + plan.plan
        txtPlanName.text = plan.subscriptionPlan
        Glide
            .with(requireContext())
            .load(selectedOffer!!.imagewide)
            .transform(RoundedCorners(12))
            .into(imgPlan)
        skip.setOnClickListener { pwindo.dismiss() }
        btnCCAvenue.setOnClickListener {
            pwindo.dismiss()
            val ip = Intent(activity, WebPaymentActivity::class.java)
            ip.putExtra("userid", AppConstants.UserId)
            ip.putExtra("subscriptionId", plan.subscriptoinPlanId)
            ip.putExtra("plan", plan.plan)
            ip.putExtra("isSvodPurchase", true)
            /*
                    if (movie.getCountry().equals("India")) {
                        ip.putExtra("currency", "INR");
                        ip.putExtra("amount", movie.getInr());
                    } else {
                        ip.putExtra("currency", "USD");
                        ip.putExtra("amount", movie.getUsd());
                    }
    */ip.putExtra("currency", "INR")
            ip.putExtra("amount", plan.inr)
            startActivityForResult(ip, requestCode)
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (this.requestCode == requestCode) {
            if (resultCode == 200) { //success
                Toast.makeText(activity, "Payment Success!", Toast.LENGTH_SHORT).show()
                popularChannels()
            } else if (resultCode == 400) { //failure
                Toast.makeText(activity, "Transaction failed! Please try again", Toast.LENGTH_SHORT)
                    .show()
            } else if (resultCode == 413) { // aborted
                Toast.makeText(activity, "Transaction cancelled !", Toast.LENGTH_SHORT).show()
            } else if (resultCode == 11) { //back pressed from payment page by user
                Toast.makeText(activity, "Transaction cancelled !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        lateinit var customProgressDialog: CustomProgressDialog
        @JvmStatic
        fun newInstance(): HomeChannelFragment {
            val args = Bundle()
            val fragment = HomeChannelFragment()
            fragment.arguments = args
            return fragment
        }
    }
}