package com.release.plexigo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.models.OTTModel

class FilterOttAdapter(var mContext: Context, ottList: ArrayList<OTTModel>?) :
    RecyclerView.Adapter<FilterOttAdapter.ViewHolder>() {
    private val ottList: ArrayList<OTTModel>?
    private var onFilterOttItemSelectedListener: OnFilterOttItemSelectedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filter_ott, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.setIsRecyclable(false)
        if (AppConstants.SelectedOTTList != null && AppConstants.SelectedOTTList!!.size > 0) {
            for (i in AppConstants.SelectedOTTList!!.indices) {
                if (AppConstants.SelectedOTTList!![i].ottPlatform.equals(
                        ottList!![position].ottPlatform,
                        ignoreCase = true
                    )
                ) {
                    holder.switchOtt.isChecked = true
                    break
                } else {
                    holder.switchOtt.isChecked = false
                }
            }
        } else {
            holder.switchOtt.isChecked = false
        }
        if (ottList!![position].wideImagePath != null) {
            GlideApp
                .with(mContext)
                .load(ottList[position].wideImagePath)
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .into(holder.imgOtt)
        }
        holder.itemView.setOnClickListener {
            if (onFilterOttItemSelectedListener != null) {
                onFilterOttItemSelectedListener!!.onFilterOttItemSelectedListener(ottList[position])
            }
        }
        holder.switchOtt.setOnCheckedChangeListener { buttonView, isChecked ->
            if (onFilterOttItemSelectedListener != null) {
                onFilterOttItemSelectedListener!!.onFilterOttItemSelectedListener(
                    ottList[position],
                    isChecked
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return ottList?.size ?: 0
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgOtt: ImageView
        var switchOtt: SwitchCompat

        init {
            imgOtt = convertView.findViewById(R.id.imgOtt)
            switchOtt = convertView.findViewById(R.id.switchOtt)
        }
    }

    interface OnFilterOttItemSelectedListener {
        fun onFilterOttItemSelectedListener(ottModel: OTTModel?)
        fun onFilterOttItemSelectedListener(ottModel: OTTModel?, isSelected: Boolean)
    }

    fun setOnFilterOttItemSelectedListener(onFilterOttItemSelectedListener: OnFilterOttItemSelectedListener?) {
        this.onFilterOttItemSelectedListener = onFilterOttItemSelectedListener
    }

    init {
        this.ottList = ottList
    }
}