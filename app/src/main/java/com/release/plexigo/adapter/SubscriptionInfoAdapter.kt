package com.release.plexigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.InfoDetailsModel
import com.release.plexigo.models.SubscriptionInfoModel

class SubscriptionInfoAdapter(
    var mContext: Context,
    subscriptionInfoList: ArrayList<SubscriptionInfoModel>
) :
    RecyclerView.Adapter<SubscriptionInfoAdapter.ViewHolder>() {
    var subscriptionInfoList: ArrayList<SubscriptionInfoModel>
    var subscriptionDescription: ArrayList<InfoDetailsModel>? = null
    var isExpanded = false
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.offer_subscription_info_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.subscriptionTitle.setText(subscriptionInfoList[position].infoType)
        subscriptionDescription = subscriptionInfoList[position].infoDetails
        holder.subscriptionInfoValueRecyclerview.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        val subscriptionInfoDescriptionAdapter = SubscriptionInfoDescriptionAdapter(
            mContext, subscriptionDescription!!, subscriptionInfoList[position].infoType
        )
        holder.subscriptionInfoValueRecyclerview.adapter = subscriptionInfoDescriptionAdapter
        if (subscriptionInfoList[position].infoType.equals("Terms and Conditions",true)) {
            currentPosition = position
            holder.moreDetails.visibility = View.GONE
            holder.imgRightArrow.visibility = View.VISIBLE
        } else {
            holder.imgRightArrow.visibility = View.GONE
            holder.moreDetails.visibility = View.VISIBLE
        }
        holder.itemView.setOnClickListener {
            if (currentPosition == position) {
                if (!isExpanded) {
                    holder.moreDetails.visibility = View.VISIBLE
                    holder.imgRightArrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                    isExpanded = true
                } else {
                    holder.moreDetails.visibility = View.GONE
                    holder.imgRightArrow.setImageResource(R.drawable.ic_arrow_right_gray)
                    isExpanded = false
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return subscriptionInfoList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgRightArrow: ImageView
        var subscriptionTitle: TextView
        var moreDetails: LinearLayout
        var subscriptionInfoValueRecyclerview: RecyclerView

        init {
            imgRightArrow = view.findViewById<View>(R.id.rightArrow) as ImageView
            subscriptionTitle = view.findViewById<View>(R.id.subscriptionTitle) as TextView
            moreDetails = view.findViewById<View>(R.id.moreDetails) as LinearLayout
            subscriptionInfoValueRecyclerview =
                view.findViewById<View>(R.id.subscriptionInfoValueRecyclerview) as RecyclerView
        }
    }

    companion object {
        private var currentPosition = -1
    }

    init {
        this.subscriptionInfoList = subscriptionInfoList
    }
}