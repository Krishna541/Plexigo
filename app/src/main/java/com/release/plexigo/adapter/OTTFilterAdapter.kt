package com.release.plexigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.models.OTTModel

class OTTFilterAdapter(var mContext: Context) :
    RecyclerView.Adapter<OTTFilterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_ott_filter_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var ispresent = 0
        GlideApp
            .with(mContext)
            .load(AppConstants.all_otts!![position].imagePath)
            .placeholder(R.drawable.plexigo_new_transperent_logo)
            .into(holder.ott_icon)
        //        holder.ott_icon.setText(AppConstants.all_otts.get(position).getOttPlatform());
        if (AppConstants.SelectedOTTList != null && AppConstants.SelectedOTTList!!.size > 0) {
            for (k in AppConstants.SelectedOTTList!!.indices) {
                if (AppConstants.SelectedOTTList!![k].ottPlatform == AppConstants.all_otts!![position].ottPlatform) {
//                    holder.checkbox.setChecked(true);
//                    holder.selected_layout.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
                    holder.full_layout.setBackgroundColor(mContext.resources.getColor(android.R.color.transparent))
                    ispresent = 1
                    break
                }
            }
            if (ispresent == 0) {
                holder.full_layout.background =
                    mContext.resources.getDrawable(R.drawable.tran_tint_border)
                //                holder.selected_layout.setBackgroundColor(mContext.getResources().getColor(R.color.grey_faint));
//                holder.checkbox.setChecked(false);
            }
        } else {
            if (isAllActive) {
                holder.full_layout.background =
                    mContext.resources.getDrawable(R.drawable.tran_tint_border)
            } else {
                holder.full_layout.setBackgroundColor(mContext.resources.getColor(android.R.color.transparent))
            }
            //            holder.full_layout.setBackground(mContext.getResources().getDrawable(R.drawable.tran_tint_border));
//            holder.checkbox.setChecked(false);
        }
        holder.ott_icon.setOnClickListener { addtoList(position, holder) }
    }

    private fun addtoList(position: Int, holder: ViewHolder) {
        var ispresent = 0
        if (AppConstants.SelectedOTTList != null && AppConstants.SelectedOTTList!!.size > 0) {
            for (k in AppConstants.SelectedOTTList!!.indices) {
                if (AppConstants.SelectedOTTList!![k].ottPlatform == AppConstants.all_otts!![position].ottPlatform) {
                    ispresent = 1
                    AppConstants.SelectedOTTList!!.removeAt(k)
                    holder.full_layout.background =
                        mContext.resources.getDrawable(R.drawable.tran_tint_border)

//                    holder.full_layout.setBackgroundColor(mContext.getResources().getColor(android.R.color.transparent));

//                    holder.selected_layout.setBackgroundColor(mContext.getResources().getColor(R.color.grey_faint));
//                    holder.checkbox.setChecked(false);
                    break
                }
            }
            if (ispresent == 0) {
                AppConstants.SelectedOTTList!!.add(AppConstants.all_otts!![position])
                holder.full_layout.setBackgroundColor(mContext.resources.getColor(android.R.color.transparent))
                //                holder.selected_layout.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));

//                holder.checkbox.setChecked(true);
            }
            if (AppConstants.SelectedOTTList == null || AppConstants.SelectedOTTList!!.size == 0) {
                isAllActive = false
                notifyDataSetChanged()
            }
        } else {
            isAllActive = true
            AppConstants.SelectedOTTList = ArrayList()
            (AppConstants.SelectedOTTList as ArrayList<OTTModel>).add(AppConstants.all_otts!![position])
            holder.full_layout.setBackgroundColor(mContext.resources.getColor(android.R.color.transparent))
            notifyDataSetChanged()

//            holder.full_layout.setBackground(mContext.getResources().getDrawable(R.drawable.tran_tint_border));
//            holder.selected_layout.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
//            holder.checkbox.setChecked(true);
        }
    }

    override fun getItemCount(): Int {
        return AppConstants.all_otts!!.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        //       CheckBox checkbox;
        //        LinearLayout selected_layout;
        //       TextView genre;I
        var ott_icon: ImageView
        var full_layout: RelativeLayout

        //       LinearLayout full_layout;
        init {
            //            genre = (TextView) convertView.findViewById(R.id.genre);
//            selected_layout = convertView.findViewById(R.id.selected_layout);
            ott_icon = convertView.findViewById<View>(R.id.ott_icon) as ImageView
            full_layout = convertView.findViewById(R.id.full_layout)
            //            full_layout = convertView.findViewById(R.id.full_layout);
        }
    }

    companion object {
        var isAllActive = false
    }
}

