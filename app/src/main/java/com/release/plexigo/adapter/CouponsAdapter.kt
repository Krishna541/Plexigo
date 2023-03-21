package com.release.plexigo.adapter

import android.content.Context
import android.text.Spannable
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.CouponModel

class CouponsAdapter(var mContext: Context, couponsList: ArrayList<CouponModel>) :
    RecyclerView.Adapter<CouponsAdapter.ViewHolder>() {
    var couponsList: ArrayList<CouponModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coupon_code, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtPlanName.setText(couponsList[position].plan)
        holder.txtCouponCode.text = "Coupon Code : " + couponsList[position].couponcode
        holder.txtDiscountedPrice.text = "\u20B9 " + couponsList[position].inrDiscountAmount
        holder.txtOriginalPrice.setText(
            "\u20B9 " + couponsList[position].inrAmount,
            TextView.BufferType.SPANNABLE
        )
        holder.txtValidity.text =
            "Valid - " + couponsList[position].validityInDays.toString() + " days"
        holder.txtDiscountedPercent.setText(
            couponsList[position].discountPercent.toString() + " % Off"
        )
        holder.txtMessage.text = "Note : " + couponsList[position].message
        val spannable = holder.txtOriginalPrice.text as Spannable
        spannable.setSpan(
            StrikethroughSpan(),
            0,
            holder.txtOriginalPrice.text.length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE
        )
    }

    override fun getItemCount(): Int {
        return couponsList.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtPlanName: TextView
        var txtCouponCode: TextView
        var txtDiscountedPrice: TextView
        var txtOriginalPrice: TextView
        var txtValidity: TextView
        var txtDiscountedPercent: TextView
        var txtMessage: TextView

        init {
            txtPlanName = convertView.findViewById(R.id.txtPlanName)
            txtCouponCode = convertView.findViewById(R.id.txtCouponCode)
            txtDiscountedPrice = convertView.findViewById(R.id.txtDiscountedPrice)
            txtOriginalPrice = convertView.findViewById(R.id.txtOriginalPrice)
            txtValidity = convertView.findViewById(R.id.txtValidity)
            txtDiscountedPercent = convertView.findViewById(R.id.txtDiscountedPercent)
            txtMessage = convertView.findViewById(R.id.txtMessage)
        }
    }

    init {
        this.couponsList = couponsList
    }
}

