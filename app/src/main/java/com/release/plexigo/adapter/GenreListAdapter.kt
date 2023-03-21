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

class GenreListAdapter(var mContext: Context) :
    RecyclerView.Adapter<GenreListAdapter.ViewHolder>() {
    var showAllGenres = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_genre_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (showAllGenres) {
            populateData(holder, position)
        } else {
            if (position == 3) {
                holder.selected_layout.background =
                    mContext.resources.getDrawable(R.drawable.bg_two_corner_view_more)
                holder.genre.text = "+ " + (AppConstants.all_genres!!.size - 3) + " More"
                holder.full_layout.setOnClickListener {
                    showAllGenres = true
                    notifyDataSetChanged()
                }
            } else {
                populateData(holder, position)
            }
        }
    }

    private fun populateData(holder: ViewHolder, position: Int) {
        var ispresent = 0
        holder.genre.setText(AppConstants.all_genres!![position].genreGroup)
        if (AppConstants.SelectedGenreList != null && AppConstants.SelectedGenreList!!.size > 0) {
            for (k in AppConstants.SelectedGenreList!!.indices) {
                if (AppConstants.SelectedGenreList!![k].genreGroup
                        .equals(AppConstants.all_genres!![position].genreGroup)
                ) {
//                    holder.checkbox.setChecked(true);
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
        if (AppConstants.SelectedGenreList != null && AppConstants.SelectedGenreList!!.size > 0) {
            for (k in AppConstants.SelectedGenreList!!.indices) {
                if (AppConstants.SelectedGenreList!![k].genreGroup
                        .equals(AppConstants.all_genres!![position].genreGroup)
                ) {
                    ispresent = 1
                    AppConstants.SelectedGenreList!!.removeAt(k)
                    holder.selected_layout.background =
                        mContext.resources.getDrawable(R.drawable.bg_two_corner_filter_unselected)
                    break
                }
            }
            if (ispresent == 0) {
                AppConstants.SelectedGenreList!!.add(AppConstants.all_genres!![position])
                holder.selected_layout.background =
                    mContext.resources.getDrawable(R.drawable.bg_two_corner_accent_color)
            }
        } else {
            AppConstants.SelectedGenreList = ArrayList()
            AppConstants.SelectedGenreList!!.add(AppConstants.all_genres!![position])
            holder.selected_layout.background =
                mContext.resources.getDrawable(R.drawable.bg_two_corner_accent_color)
        }
    }

    override fun getItemCount(): Int {
        return if (showAllGenres) AppConstants.all_genres!!.size else 4
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        //       CheckBox checkbox;
        var selected_layout: LinearLayout
        var genre: TextView
        var full_layout: LinearLayout

        init {
            genre = convertView.findViewById<View>(R.id.genre) as TextView
            selected_layout = convertView.findViewById(R.id.selected_layout)
            //            checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
            full_layout = convertView.findViewById(R.id.full_layout)
        }
    }
}
