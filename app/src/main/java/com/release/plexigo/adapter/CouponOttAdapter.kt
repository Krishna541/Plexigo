package com.release.plexigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.models.OttCouponModel

class CouponOttAdapter(var mContext: Context, ottCouponModels: ArrayList<OttCouponModel>) :
    RecyclerView.Adapter<CouponOttAdapter.ViewHolder>() {
    var ottCouponModels: ArrayList<OttCouponModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coupon, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        GlideApp
            .with(mContext)
            .load(ottCouponModels[position].imagePath)
            .placeholder(R.drawable.plexigo_new_transperent_logo)
            .into(holder.imgOtt)
        holder.txtOttName.setText(ottCouponModels[position].ottName)
        holder.recyclerCouponCodes.adapter =
            CouponsAdapter(mContext, ottCouponModels[position].coupons)
    }

    override fun getItemCount(): Int {
        return ottCouponModels.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgOtt: ImageView
        var txtOttName: TextView
        var recyclerCouponCodes: RecyclerView

        init {
            txtOttName = convertView.findViewById(R.id.txtOttName)
            imgOtt = convertView.findViewById(R.id.imgOtt)
            recyclerCouponCodes = convertView.findViewById(R.id.recyclerCouponCodes)
        }
    }

    init {
        this.ottCouponModels = ottCouponModels
    }
}