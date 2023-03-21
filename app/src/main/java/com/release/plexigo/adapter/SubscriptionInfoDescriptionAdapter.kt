package com.release.plexigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.InfoDetailsModel

class SubscriptionInfoDescriptionAdapter(
    var mContext: Context,
    subscriptionDescription: ArrayList<InfoDetailsModel>,
    infoType: String
) :
    RecyclerView.Adapter<SubscriptionInfoDescriptionAdapter.ViewHolder>() {
    var subscriptionInfoList: ArrayList<InfoDetailsModel>
    var infoType: String
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.offer_subscription_info_value_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (infoType.equals("How touse", ignoreCase = true)) {
            holder.imgSubscriptionValue.visibility = View.GONE
            holder.txtSubscriptionValue.visibility = View.VISIBLE
            holder.txtSubscriptionValue.text = (position + 1).toString()
        } else {
            holder.imgSubscriptionValue.visibility = View.VISIBLE
            holder.txtSubscriptionValue.visibility = View.GONE
        }
        holder.subscriptionTitleValue.setText(subscriptionInfoList[position].value)
    }

    override fun getItemCount(): Int {
        return subscriptionInfoList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var subscriptionTitleValue: TextView
        var txtSubscriptionValue: TextView
        var imgSubscriptionValue: ImageView

        init {
            subscriptionTitleValue =
                view.findViewById<View>(R.id.subscriptionTitleValue) as TextView
            imgSubscriptionValue = view.findViewById<View>(R.id.imgSubscriptionValue) as ImageView
            txtSubscriptionValue = view.findViewById<View>(R.id.txtSubscriptionValue) as TextView
        }
    }

    init {
        subscriptionInfoList = subscriptionDescription
        this.infoType = infoType
    }
}
