package com.release.plexigo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.UserPlaylistModel

class MyPlaylistAdapter(playList: ArrayList<UserPlaylistModel>) :
    RecyclerView.Adapter<MyPlaylistAdapter.ViewHolder>() {
    private val playList: ArrayList<UserPlaylistModel>
    private var onPlayListItemSelectedListener: OnPlayListItemSelectedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_my_playlist, parent, false)
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
        return Math.min(playList.size, 5)
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtPlaylistName: TextView

        init {
            txtPlaylistName = convertView.findViewById(R.id.txtPlaylistName)
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
