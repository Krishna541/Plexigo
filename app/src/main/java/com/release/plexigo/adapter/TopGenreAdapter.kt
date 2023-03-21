package com.release.plexigo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.activity.FilterResultsActivity
import com.release.plexigo.models.HomeGenreModel
import com.release.plexigo.models.TopGenreModel
import com.release.plexigo.models.UserPlaylistModel

class TopGenreAdapter(genreList: ArrayList<TopGenreModel>) :
    RecyclerView.Adapter<TopGenreAdapter.ViewHolder>() {
    private val genreList: ArrayList<TopGenreModel>
    private var onPlayListItemSelectedListener: OnPlayListItemSelectedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_top_genre, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtGenreName.setText(genreList[position].genreCategory)
        holder.itemView.setOnClickListener { v ->
            val genre: TopGenreModel = genreList[position]
            AppConstants.SelectedGenreList = ArrayList()
            AppConstants.SelectedGenreList!!.add(
                HomeGenreModel(
                    genre.genreID,
                    genre.genreCategory,
                    0
                )
            )
            AppConstants.IsFilterActive = true
            val intent = Intent(v.context, FilterResultsActivity::class.java)
            intent.putExtra("title", genreList[position].genreCategory.toString() + " Movies")
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return Math.min(genreList.size, 5)
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtGenreName: TextView

        init {
            txtGenreName = convertView.findViewById(R.id.txtGenreName)
        }
    }

    interface OnPlayListItemSelectedListener {
        fun onPlayListItemSelected(playlist: UserPlaylistModel?)
    }

    fun setOnPlayListItemSelectedListener(onPlayListItemSelectedListener: OnPlayListItemSelectedListener?) {
        this.onPlayListItemSelectedListener = onPlayListItemSelectedListener
    }

    init {
        this.genreList = genreList
    }
}
