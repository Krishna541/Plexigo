package com.release.plexigo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonMappingException
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.CouponOttAdapter
import com.release.plexigo.models.ActorListDataModel
import com.release.plexigo.models.OttCouponModel
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.fragment_coupon_codes.*
import kotlinx.android.synthetic.main.fragment_home_profile.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException


class CouponCodesFragment : Fragment() {

    private val couponsList: ArrayList<OttCouponModel> = ArrayList<OttCouponModel>()
    private var adapter: CouponOttAdapter? = null
    var queue: RequestQueue? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coupon_codes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }


    private fun initData() {
        queue = Volley.newRequestQueue(activity)
        adapter = CouponOttAdapter(recyclerCoupons!!.context, couponsList)
        recyclerCoupons!!.adapter = adapter
        imgBack!!.setOnClickListener { requireActivity().onBackPressed() }
        couponCodes()
    }

    private fun couponCodes(){
        showLoader()
        val apiInterface = APIClient.getClient("1.1").create(APIInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getCouponCode( requireArguments().getInt("bundleId") ,AppConstants.UserId!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val model = responseModel.data
                            if (model.couponcode != null && model.couponcode.isNotEmpty()
                            ) {
                                recyclerCoupons!!.visibility = View.VISIBLE
                                txtNoCoupons!!.visibility = View.GONE
                                couponsList.addAll(model.couponcode)
                                adapter?.notifyDataSetChanged()
                            } else {
                                txtNoCoupons!!.visibility = View.VISIBLE
                                recyclerCoupons!!.visibility = View.GONE
                            }
                            hideLoader()
                        }else {
                            hideLoader()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT)
                        .show()
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
    }


    fun showLoader() {
        progressbar!!.visibility = View.VISIBLE
    }

    fun hideLoader() {
        progressbar!!.visibility = View.GONE
    }

    companion object {
        fun newInstance(bundleId: Int): CouponCodesFragment {
            val args = Bundle()
            args.putInt("bundleId", bundleId)
            val fragment = CouponCodesFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
