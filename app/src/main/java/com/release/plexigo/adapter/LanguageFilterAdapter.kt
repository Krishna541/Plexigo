package com.release.plexigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R

class LanguageFilterAdapter(var mContext: Context) :
    RecyclerView.Adapter<LanguageFilterAdapter.ViewHolder>() {
    var showAllLanguages = false
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_genre_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (showAllLanguages) {
            populateData(holder, position)
        } else {
            if (position == 3) {
                holder.selected_layout.background =
                    mContext.resources.getDrawable(R.drawable.bg_two_corner_view_more)
                holder.language.text = "+ " + (AppConstants.all_languages!!.size - 3) + " More"
                holder.full_layout.setOnClickListener {
                    showAllLanguages = true
                    notifyDataSetChanged()
                }
            } else {
                populateData(holder, position)
            }
        }
    }

    private fun populateData(holder: ViewHolder, position: Int) {
        var ispresent = 0
        holder.language.setText(AppConstants.all_languages!![position].languageGroup)
        if (AppConstants.SelectedLanguageList != null && AppConstants.SelectedLanguageList!!.size > 0) {
            for (k in AppConstants.SelectedLanguageList!!.indices) {
                if (AppConstants.SelectedLanguageList!![k].languageGroup.equals(
                        AppConstants.all_languages!![position].languageGroup
                    )
                ) {
                    holder.selected_layout.background =
                        mContext.resources.getDrawable(R.drawable.bg_two_corner_accent_color)
                    ispresent = 1
                    break
                }
            }
            if (ispresent == 0) {
                holder.selected_layout.background =
                    mContext.resources.getDrawable(R.drawable.bg_two_corner_filter_unselected)
            }
        } else {
            holder.selected_layout.background =
                mContext.resources.getDrawable(R.drawable.bg_two_corner_filter_unselected)
        }
        holder.full_layout.setOnClickListener { addtoList(position, holder) }
    }

    private fun addtoList(position: Int, holder: ViewHolder) {
        var ispresent = 0
        if (AppConstants.SelectedLanguageList != null && AppConstants.SelectedLanguageList!!.size > 0) {
            for (k in AppConstants.SelectedLanguageList!!.indices) {
                if (AppConstants.SelectedLanguageList!![k].languageGroup.equals(
                        AppConstants.all_languages!![position].languageGroup
                    )
                ) {
                    ispresent = 1
                    AppConstants.SelectedLanguageList!!.removeAt(k)
                    holder.selected_layout.background =
                        mContext.resources.getDrawable(R.drawable.bg_two_corner_filter_unselected)
                    break
                }
            }
            if (ispresent == 0) {
                AppConstants.SelectedLanguageList!!.add(AppConstants.all_languages!![position])
                holder.selected_layout.background =
                    mContext.resources.getDrawable(R.drawable.bg_two_corner_accent_color)
            }
        } else {
            AppConstants.SelectedLanguageList = ArrayList()
            AppConstants.SelectedLanguageList!!.add(AppConstants.all_languages!![position])
            holder.selected_layout.background =
                mContext.resources.getDrawable(R.drawable.bg_two_corner_accent_color)
        }
    }

    override fun getItemCount(): Int {
        return if (showAllLanguages) AppConstants.all_languages!!.size else {
            4
        }
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        //       CheckBox checkbox;
        var selected_layout: LinearLayout
        var language: TextView
        var full_layout: LinearLayout

        init {
            language = convertView.findViewById<View>(R.id.genre) as TextView
            //            checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
            selected_layout = convertView.findViewById(R.id.selected_layout)
            full_layout = convertView.findViewById(R.id.full_layout)
        }
    }
}

