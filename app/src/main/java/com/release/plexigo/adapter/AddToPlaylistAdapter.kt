package com.release.plexigo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.UserPlaylistModel

class AddToPlaylistAdapter(playList: ArrayList<UserPlaylistModel>) :
    RecyclerView.Adapter<AddToPlaylistAdapter.ViewHolder>() {
    private val playList: ArrayList<UserPlaylistModel>
    private var onPlayListItemSelectedListener: OnPlayListItemSelectedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout: Int = R.layout.item_my_playlist
        val v = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtPlaylistName.setText(playList[position].title)
        holder.itemView.setOnClickListener {
            if (onPlayListItemSelectedListener != null) {
                onPlayListItemSelectedListener!!.onPlayListItemSelected(playList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return playList.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtPlaylistName: TextView
        var dividerView: View

        init {
            txtPlaylistName = convertView.findViewById(R.id.txtPlaylistName)
            dividerView = convertView.findViewById(R.id.dividerView)
            dividerView.setBackgroundColor(Color.parseColor("#666666"))
            txtPlaylistName.setBackgroundColor(Color.parseColor("#1A043A"))
        }
    }

    interface OnPlayListItemSelectedListener {
        fun onPlayListItemSelected(playlist: UserPlaylistModel?)
    }

    fun setOnPlayListItemSelectedListener(onPlayListItemSelectedListener: OnPlayListItemSelectedListener?) {
        this.onPlayListItemSelectedListener = onPlayListItemSelectedListener
    }

    init {
        this.playList = playList
    }
}
