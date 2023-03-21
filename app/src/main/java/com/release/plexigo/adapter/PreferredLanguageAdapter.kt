package com.release.plexigo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.HomeLanguageModel

class PreferredLanguageAdapter(languages: ArrayList<HomeLanguageModel>?) :
    RecyclerView.Adapter<PreferredLanguageAdapter.ViewHolder>() {
    private val languages: ArrayList<HomeLanguageModel>?
    private var onPreferredGenreItemSelectedListener: OnPreferredGenreItemSelectedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content_language, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (languages!![position].selected === 1) {
            holder.txtGenreName.background =
                holder.txtGenreName.context.resources.getDrawable(R.drawable.round_border_white_transparent)
        } else {
            holder.txtGenreName.background =
                holder.txtGenreName.context.resources.getDrawable(R.drawable.round_border_gray_transparent)
        }
        holder.txtGenreName.setText(languages!![position].languageGroup)
        holder.itemView.setOnClickListener {
            if (onPreferredGenreItemSelectedListener != null) {
                //                    Toast.makeText(v.getContext(), languages.get(position).getLanguageGroup(), Toast.LENGTH_SHORT).show();
                onPreferredGenreItemSelectedListener!!.onPreferredGenreItemSelected(languages!![position])
            }
        }
    }

    override fun getItemCount(): Int {
        return languages?.size ?: 0
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtGenreName: TextView

        init {
            txtGenreName = convertView.findViewById(R.id.txtContentLanguage)
        }
    }

    interface OnPreferredGenreItemSelectedListener {
        fun onPreferredGenreItemSelected(language: HomeLanguageModel?)
    }

    fun setOnPreferredLanguageItemSelectedListener(onPreferredGenreItemSelectedListener: OnPreferredGenreItemSelectedListener?) {
        this.onPreferredGenreItemSelectedListener = onPreferredGenreItemSelectedListener
    }

    init {
        this.languages = languages
    }
}

