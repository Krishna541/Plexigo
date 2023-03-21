package com.release.plexigo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.models.HomeLanguageModel

class FilterLanguageAdapter(languages: ArrayList<HomeLanguageModel>?) :
    RecyclerView.Adapter<FilterLanguageAdapter.ViewHolder>() {
    private val languages: ArrayList<HomeLanguageModel>?
    private var onFilterLanguageItemSelectedListener: OnFilterLanguageItemSelectedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content_language, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        if (AppConstants.SelectedLanguageList != null && AppConstants.SelectedLanguageList!!.size > 0) {
            for (i in AppConstants.SelectedLanguageList!!.indices) {
                if (AppConstants.SelectedLanguageList!![i].languageGroup.equals(
                        languages!![position].languageGroup,ignoreCase = true
                    )
                ) {
                    holder.txtLanguage.background =
                        holder.txtLanguage.context.resources.getDrawable(R.drawable.round_border_white_transparent)
                    break
                } else {
                    holder.txtLanguage.background =
                        holder.txtLanguage.context.resources.getDrawable(R.drawable.round_border_gray_transparent)
                }
            }
        } else {
            holder.txtLanguage.background =
                holder.txtLanguage.context.resources.getDrawable(R.drawable.round_border_gray_transparent)
        }
        holder.txtLanguage.setText(languages!![position].languageGroup)
        holder.itemView.setOnClickListener {
            if (onFilterLanguageItemSelectedListener != null) {
                onFilterLanguageItemSelectedListener!!.onFilterLanguageItemSelected(languages!![position])
            }
        }
    }

    override fun getItemCount(): Int {
        return languages?.size ?: 0
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtLanguage: TextView

        init {
            txtLanguage = convertView.findViewById(R.id.txtContentLanguage)
        }
    }

    interface OnFilterLanguageItemSelectedListener {
        fun onFilterLanguageItemSelected(language: HomeLanguageModel?)
    }

    fun setOnFilterLanguageItemSelectedListener(onFilterLanguageItemSelectedListener: OnFilterLanguageItemSelectedListener?) {
        this.onFilterLanguageItemSelectedListener = onFilterLanguageItemSelectedListener
    }

    init {
        this.languages = languages
    }
}

