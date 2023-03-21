package com.release.plexigo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.HomeGenreModel

class PreferredGenreAdapter(genreList: ArrayList<HomeGenreModel>?) :
    RecyclerView.Adapter<PreferredGenreAdapter.ViewHolder>() {
    private val genreList: ArrayList<HomeGenreModel>?
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
        if (genreList!![position].selected === 1) {
            holder.txtGenreName.background =
                holder.txtGenreName.context.resources.getDrawable(R.drawable.round_border_white_transparent)
        } else {
            holder.txtGenreName.background =
                holder.txtGenreName.context.resources.getDrawable(R.drawable.round_border_gray_transparent)
        }
        holder.txtGenreName.setText(genreList!![position].genreGroup)
        holder.itemView.setOnClickListener {
            if (onPreferredGenreItemSelectedListener != null) {
                onPreferredGenreItemSelectedListener!!.onPreferredGenreItemSelected(genreList!![position])
            }
        }
    }

    override fun getItemCount(): Int {
        return genreList?.size ?: 0
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtGenreName: TextView

        init {
            txtGenreName = convertView.findViewById(R.id.txtContentLanguage)
        }
    }

    interface OnPreferredGenreItemSelectedListener {
        fun onPreferredGenreItemSelected(genre: HomeGenreModel?)
    }

    fun setOnPreferredGenreItemSelectedListener(onPreferredGenreItemSelectedListener: OnPreferredGenreItemSelectedListener?) {
        this.onPreferredGenreItemSelectedListener = onPreferredGenreItemSelectedListener
    }

    init {
        this.genreList = genreList
    }
}
