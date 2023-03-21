package com.release.plexigo.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.*
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.OfferFaqAdapter
import com.release.plexigo.adapter.SubscriptionInfoAdapter
import com.release.plexigo.adapter.SubscriptionPlansAdapter
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_cast_detail.*
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_offer.*
import kotlinx.android.synthetic.main.activity_offer.back_btn
import kotlinx.android.synthetic.main.activity_offer.recyclerSubscriptionPlans
import kotlinx.android.synthetic.main.fragment_coupon_codes.*
import kotlinx.android.synthetic.main.fragment_home_profile.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.text.ParseException
import java.text.SimpleDateFormat

class OfferActivity : AppCompatActivity(), View.OnClickListener,
    SubscriptionPlansAdapter.OnPlanSelected {


    var isExpand = false
    private var selectedOffer: BundleDetailsModel? = null
    private val requestCode = 1100
    var customProgressDialog: CustomProgressDialog? = null
    var bundleId = 0
    private var plan: SubscriptionPlan? = null
    private var imgUrl: String? = null
    private var bottomSheet: BottomSheetBehavior<View>? = null
    private val subscriptionInfoList: ArrayList<SubscriptionInfoModel> =
        ArrayList<SubscriptionInfoModel>()
    private val faqList: ArrayList<FaqModel> = ArrayList<FaqModel>()
    private var bundleDetail: BundleDetailsModel? = null
    lateinit var apiInterface : APIInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer)
        bundleId = intent.getIntExtra("bundleId", 0)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        initView()
        initData()
    }

    private fun initView() {
        bottomSheet = BottomSheetBehavior.from(findViewById<View>(R.id.btmSheetSubscriptionPlans))
        bottomSheet!!.peekHeight = 0
        back_btn!!.setOnClickListener(this)
        faqCardView!!.setOnClickListener(this)
        proceedToPayButton!!.setOnClickListener(this)
        val linearLayoutManager = LinearLayoutManager(this@OfferActivity)
        offerDescriptionRecyclerview!!.layoutManager = linearLayoutManager
        faqRecyclerview.setLayoutManager(LinearLayoutManager(this@OfferActivity))
        faqCardView!!.setOnClickListener {
            isExpand = if (!isExpand) {
                faqRecyclerview.setVisibility(View.VISIBLE)
                faqText.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_baseline_keyboard_arrow_down_24,
                    0
                )
                true
            } else {
                faqRecyclerview.setVisibility(View.GONE)
                faqText.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_arrow_right_gray,
                    0
                )
                false
            }
        }
    }

    private fun initData() {
        getSubscriptionDetail()
    }

    private fun getSubscriptionDetail(){
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getBundleDetail(bundleId,AppConstants.UserId!!)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if(response.isSuccessful){
                        val responseModel = response.body()
                        if(responseModel?.statusCode == "200"){
                            bundleDetail = responseModel.data.bundledetails[0]
                            imgUrl = responseModel.data.bundledetails[0].wideImageURL

                            GlideApp.with(this@OfferActivity)
                                .load(imgUrl)
                                .into(imgOffer)
                            subscriptionInfoList.clear()
                            subscriptionInfoList.addAll(
                                responseModel.data.bundledetails[0].bundleInfo
                            )
                            faqList.addAll(
                                responseModel.data.bundledetails[0].faqs
                            )
                            if (subscriptionInfoList.size > 0) {
                                cardViewMain.setVisibility(View.VISIBLE)
                                val subscriptionInfoAdapter = SubscriptionInfoAdapter(
                                    this@OfferActivity,
                                    subscriptionInfoList
                                )
                                offerDescriptionRecyclerview!!.adapter = subscriptionInfoAdapter
                            }
                            if (faqList.size > 0) {
                                cardViewMain.setVisibility(View.VISIBLE)
                                val faqAdapter = OfferFaqAdapter(this@OfferActivity, faqList)
                                faqRecyclerview.setAdapter(faqAdapter)
                                faqCardView!!.visibility = View.VISIBLE
                            }
                            if (bundleDetail!!.hasOTT === 0 && bundleDetail!!.issubscribed
                                    .equals("0")
                            ) {
                                couponTextView.setVisibility(View.GONE)
                                couponCardView.setVisibility(View.GONE)
                                proceedToPayButton!!.visibility = View.VISIBLE
                            } else if (bundleDetail!!.hasOTT === 0 && bundleDetail!!.issubscribed
                                    .equals("1")
                            ) {
                                proceedToPayButton!!.visibility = View.GONE
                                getCouponCodes()
                            } else if (bundleDetail!!.hasOTT === 1 && bundleDetail!!.issubscribed
                                    .equals("0")
                            ) {
                                proceedToPayButton!!.visibility = View.GONE
                                getCouponCodes()
                            }
                        }else{
                            Toast.makeText(
                                this@OfferActivity,
                                "Something went wrong",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                } catch (e: HttpException) {
                    Toast.makeText(this@OfferActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@OfferActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@OfferActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@OfferActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    private fun getCouponCodes(){
        Showloader()
        val apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getCouponCode( bundleId ,AppConstants.UserId!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            if (model.couponcode != null && model.couponcode.isNotEmpty()
                            ) {
                                val dataModel: CouponListingResponseDataModel = model
                                if (dataModel.couponcode.get(0)
                                        .coupons != null && dataModel.couponcode[0]
                                        .coupons.size > 0
                                ) {
                                    couponTextView.visibility = View.VISIBLE
                                    couponCardView.visibility = View.VISIBLE
                                    cardViewMain.visibility = View.VISIBLE
                                    val couponModel: CouponModel =
                                        dataModel.couponcode[0].coupons[0]
                                    couponTextView.text = getString(R.string.coupon_code).toString() + " " + couponModel.couponcode
                                    txtTotalAmountPaid.text = getString(R.string.total_amount_paid).toString() + " " + couponModel.inrDiscountAmount
                                    txtPaymentDate.text = getString(R.string.payment_date).toString() + " " + getDate(
                                        couponModel.purchasedate
                                    )
                                    txtValidFromDate.text = getString(R.string.validated_from).toString() + " " + getDate(
                                        couponModel.validityStart
                                    )
                                    txtExpiryDate.text = getString(R.string.expire_date).toString() + " " + getDate(
                                        couponModel.validityEnd
                                    )
                                    txtMessage.text = couponModel.message
                                }
                            } else {
                                couponTextView.visibility = View.GONE
                                couponCardView.visibility = View.GONE
                            }
                            HideLoader()
                        }else {
                            HideLoader()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@OfferActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@OfferActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@OfferActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@OfferActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }




    @Throws(ParseException::class)
    private fun getDate(strDate: String): String {
        val date = SimpleDateFormat("mm/dd/yyyy")
            .parse(strDate)
        val dayNumberSuffix = getDayNumberSuffix(date.date)
        val dateFormat = SimpleDateFormat("d'$dayNumberSuffix' MMM yyyy")
        return dateFormat.format(date)
    }

    private fun getDayNumberSuffix(n: Int): String {
        return if (n >= 11 && n <= 13) {
            "th"
        } else when (n % 10) {
            1 -> "st"
            2 -> "nd"
            3 -> "rd"
            else -> "th"
        }
    }

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft: FragmentTransaction = getSupportFragmentManager().beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.isCancelable = false
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.back_btn -> onBackPressed()
            R.id.proceedToPayButton -> proceedToPayButton()
        }
    }

    private fun proceedToPayButton() {
        selectedOffer = bundleDetail
        val subscriptionPlansAdapter =
            SubscriptionPlansAdapter(selectedOffer!!.subscriptionplans, this)
        recyclerSubscriptionPlans.setAdapter(subscriptionPlansAdapter)
        bottomSheet!!.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun onPlanSelected(plan: SubscriptionPlan?) {
        this.plan = plan
        checkIfOfferSubscribed(plan!!)
        bottomSheet!!.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    private  fun checkIfOfferSubscribed(plan: SubscriptionPlan){
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
                            Toast.makeText(
                                this@OfferActivity,
                                "Pack is already activated",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else if (responseModel?.validationStatus == "Expired") { //Plan Expired
                            openSvodPopupLayout(plan)
                        } else if (responseModel?.validationStatus == "Not Purchased") { //Plan Expired
                            openSvodPopupLayout(plan)
                        } else {
                            Toast.makeText(
                                this@OfferActivity,
                                "Validation Status " + responseModel?.validationStatus,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@OfferActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@OfferActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@OfferActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@OfferActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    fun openSvodPopupLayout(plan: SubscriptionPlan) {
        val inflater =
            this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.dialog_payment_subscription, null)
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
        txtPlanName.setText(plan.subscriptionPlan)
        GlideApp
            .with(this)
            .load(selectedOffer?.wideImageURL)
            .transform(RoundedCorners(12))
            .placeholder(R.drawable.plexigo_new_transperent_logo)
            .into(imgPlan)
        skip.setOnClickListener { pwindo.dismiss() }
        btnCCAvenue.setOnClickListener {
            pwindo.dismiss()
            val ip = Intent(this, WebPaymentActivity::class.java)
            ip.putExtra("userid", AppConstants.UserId)
            ip.putExtra("subscriptionId", plan.subscriptoinPlanId)
            ip.putExtra("plan", plan.plan)
            ip.putExtra("isSvodPurchase", true)
            ip.putExtra("currency", "INR")
            ip.putExtra("amount", plan.inr)
            startActivityForResult(ip, requestCode)
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }



    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (this.requestCode == requestCode) {
            if (resultCode == 200) { //success
                finish()
                Toast.makeText(this@OfferActivity, "Payment Success!", Toast.LENGTH_SHORT).show()
                //                callOffersApi();
            } else if (resultCode == 400) { //failure
                finish()
                Toast.makeText(
                    this@OfferActivity,
                    "Transaction failed! Please try again",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (resultCode == 413) { // aborted
                finish()
                Toast.makeText(this@OfferActivity, "Transaction cancelled !", Toast.LENGTH_SHORT)
                    .show()
            } else if (resultCode == 11) { //back pressed from payment page by user
                finish()
                Toast.makeText(this@OfferActivity, "Transaction cancelled !", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}