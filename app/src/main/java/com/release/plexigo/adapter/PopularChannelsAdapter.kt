package com.release.plexigo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.models.ChannelFestivalModel

class PopularChannelsAdapter constructor(
    var mContext: Context,
    channels: ArrayList<ChannelFestivalModel>?
) : RecyclerView.Adapter<PopularChannelsAdapter.ChannelViewHolder>() {
    var channels: ArrayList<ChannelFestivalModel> = ArrayList()
    private var onChannelClickListener: OnChannelClick? = null
    public override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val v: View
        val viewHolder: ChannelViewHolder
        v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_channel, parent, false)
        val layoutParams: ViewGroup.LayoutParams = v.getLayoutParams()
        layoutParams.width = (Resources.getSystem().getDisplayMetrics().widthPixels / 3) - 35
        layoutParams.height = (Resources.getSystem().getDisplayMetrics().widthPixels / 3) - 25
        val cardImage: CardView = v.findViewById(R.id.cardImage)
        val imageParams: ViewGroup.LayoutParams = cardImage.getLayoutParams()
        imageParams.height = (Resources.getSystem().getDisplayMetrics().widthPixels / 3) - 50
        val subscriptionTagWidth: Int =
            (Resources.getSystem().getDisplayMetrics().widthPixels / 3) - 100
        val txtIsSubscribed: TextView = v.findViewById(R.id.txtIsSubscribed)
        val isSubscribedParams: ViewGroup.LayoutParams = txtIsSubscribed.getLayoutParams()
        isSubscribedParams.width = subscriptionTagWidth
        txtIsSubscribed.setLayoutParams(isSubscribedParams)
        viewHolder = ChannelViewHolder(v)
        return viewHolder
    }

    public override fun onBindViewHolder(holder: ChannelViewHolder, @SuppressLint("RecyclerView") position: Int) {
//        clear cache load from network
        Log.e("channelImage", channels.get(position).channelImage)
        GlideApp
            .with(mContext)
            .load(channels.get(position).channelImage)
            .placeholder(R.drawable.plexigo_new_transperent_logo)
            .into(holder.imgChannel)

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            public override fun onClick(v: View) {
                if (onChannelClickListener != null) {
                    onChannelClickListener!!.onChannelClicked(
                        channels[position].channelID,
                        channels[position].channelName.toString(),
                        ""
                    )
                }
                //                Toast.makeText(mContext, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        })
        if (!TextUtils.isEmpty(channels[position].isSubscribed) && (channels.get(position).isSubscribed == "1")
        ) {
            holder.txtIsSubscribed.visibility = View.VISIBLE
        } else {
            holder.txtIsSubscribed.visibility = View.GONE
        }
    }

    public override fun getItemCount(): Int {
        return channels.size
    }

    fun updateList(channels: ArrayList<ChannelFestivalModel>?) {
        this.channels.clear()
        this.channels.addAll((channels)!!)
        notifyDataSetChanged()
    }

    class ChannelViewHolder constructor(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgChannel: ImageView
        var txtIsSubscribed: TextView

        init {
            imgChannel = convertView.findViewById(R.id.imgChannel)
            txtIsSubscribed = convertView.findViewById(R.id.txtIsSubscribed)
        }
    }

    fun setOnChannelClickListener(onChannelClickListener: OnChannelClick?) {
        this.onChannelClickListener = onChannelClickListener
    }

    interface OnChannelClick {
        fun onChannelClicked(channelId: Int, channelName: String?, type: String?)
    }

    init {
        this.channels.addAll((channels)!!)
    }
}