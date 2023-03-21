package com.release.plexigo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.models.HomeGenreModel

class FilterGenreAdapter(genreList: ArrayList<HomeGenreModel>?) :
    RecyclerView.Adapter<FilterGenreAdapter.ViewHolder>() {
    private val genreList: ArrayList<HomeGenreModel>? = genreList
    private var onFilterGenreItemSelectedListener: OnFilterGenreItemSelectedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content_language, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (AppConstants.SelectedGenreList != null && AppConstants.SelectedGenreList!!.size > 0) {
            for (i in AppConstants.SelectedGenreList!!.indices) {
                if (AppConstants.SelectedGenreList!![i].genreGroup.equals(
                        genreList!![position].genreGroup,ignoreCase = true
                    )
                ) {
                    holder.txtGenreName.background =
                        holder.txtGenreName.context.resources.getDrawable(R.drawable.round_border_white_transparent)
                    break
                } else {
                    holder.txtGenreName.background =
                        holder.txtGenreName.context.resources.getDrawable(R.drawable.round_border_gray_transparent)
                }
            }
        } else {
            holder.txtGenreName.background =
                holder.txtGenreName.context.resources.getDrawable(R.drawable.round_border_gray_transparent)
        }
        holder.txtGenreName.text = genreList!![position].genreGroup
        holder.itemView.setOnClickListener {
            if (onFilterGenreItemSelectedListener != null) {
                onFilterGenreItemSelectedListener!!.onFilterGenreItemSelected(genreList!![position])
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

    interface OnFilterGenreItemSelectedListener {
        fun onFilterGenreItemSelected(genre: HomeGenreModel?)
    }

    fun setOnFilterGenreItemSelectedListener(onFilterGenreItemSelectedListener: OnFilterGenreItemSelectedListener?) {
        this.onFilterGenreItemSelectedListener = onFilterGenreItemSelectedListener
    }

}

