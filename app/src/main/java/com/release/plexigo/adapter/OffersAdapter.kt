package com.release.plexigo.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.models.OfferModel
import java.util.ArrayList


class OffersAdapter(
    var mContext: Context,
    var offerList: ArrayList<OfferModel>,
    private val isDialog: Boolean,
    private val onOfferClick: OnOfferClick?
) : RecyclerView.Adapter<OffersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View
        v = LayoutInflater.from(parent.context).inflate(R.layout.item_offer_dialog, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // change media icon
        val path = offerList[position].imagewide
        if (!TextUtils.isEmpty(path)) {
            GlideApp
                .with(mContext)
                .load(path)
                .transform(RoundedCorners(12))
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .into(holder.imgOffer)

        }
        if (!isDialog && onOfferClick != null) holder.itemView.setOnClickListener(View.OnClickListener {
            onOfferClick.onOfferClicked(
                offerList[position]
            )
        })
    }

    interface OnOfferClick {
        fun onOfferClicked(offer: OfferModel?)
    }

    override fun getItemCount(): Int {
        return offerList.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgOffer: ImageView

        init {
            imgOffer = convertView.findViewById<View>(R.id.imgOffer) as ImageView
        }
    }
}