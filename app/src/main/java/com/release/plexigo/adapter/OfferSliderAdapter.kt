package com.release.plexigo.adapter

import android.content.Context
import android.content.res.Resources
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.models.OfferModel

class OfferSliderAdapter(
    private val mContext: Context,
    offerList: ArrayList<OfferModel>,
    onOfferClick: OnOfferClick
) :
    PagerAdapter() {
    private val offerList: ArrayList<OfferModel> = offerList
    private val onOfferClick: OnOfferClick
    override fun getCount(): Int {
        return offerList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` === view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {}
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val v: View = LayoutInflater.from(container.context)
            .inflate(R.layout.item_offer_dialog, container, false)

//        LayoutInflater inflater = LayoutInflater.from(mContext);
//        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.item_offer_dialog, container, false);
        val layoutParams = v.layoutParams
        layoutParams.width = Resources.getSystem().displayMetrics.widthPixels / 3 - 50
        layoutParams.height = Resources.getSystem().displayMetrics.widthPixels / 3 - 25
        val cardImage: CardView = v.findViewById(R.id.cardImage)
        val imageParams = cardImage.layoutParams
        imageParams.height = Resources.getSystem().displayMetrics.widthPixels / 3 - 50
        val subscriptionTagWidth = Resources.getSystem().displayMetrics.widthPixels / 3 - 100
        val txtIsSubscribed = v.findViewById<TextView>(R.id.txtIsSubscribed)
        val isSubscribedParams = txtIsSubscribed.layoutParams
        isSubscribedParams.width = subscriptionTagWidth
        txtIsSubscribed.layoutParams = isSubscribedParams
        container.addView(v)
        val imgOffer = v.findViewById<View>(R.id.imgOffer) as ImageView
        if (!TextUtils.isEmpty(offerList[position].imagewide)) {
            GlideApp
                .with(mContext)
                .load(offerList[position].imagewide)
                .transform(RoundedCorners(10))
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .into(imgOffer)
        }
        if (offerList[position].hasOTT === 0 && offerList[position].issubscribed === 1) {
            txtIsSubscribed.visibility = View.VISIBLE
        } else {
            txtIsSubscribed.visibility = View.GONE
        }
        imgOffer.setOnClickListener { onOfferClick.onOfferClicked(offerList[position]) }
        return v
    }

    interface OnOfferClick {
        fun onOfferClicked(offer: OfferModel?)
    }

    init {
        this.onOfferClick = onOfferClick
    }
}
