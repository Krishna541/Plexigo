package com.release.plexigo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.models.UserPlaylistModel
import java.util.ArrayList


class MoodPlaylistAdapter(var mContext: Context, private val playList: ArrayList<UserPlaylistModel>) :
    RecyclerView.Adapter<MoodPlaylistAdapter.ViewHolder>() {
    private var onPlayListItemSelectedListener: OnPlayListItemSelectedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout: Int
        layout = R.layout.item_playlist_mood
        val v = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.txtPlaylistName.text = playList[position].playlistName
        if (!TextUtils.isEmpty(playList[position].widePoster)) {
            GlideApp
                .with(mContext)
                .load(playList[position].widePoster)
                .transform(RoundedCorners(12))
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .into(holder.imgPlaylistPoster)
        }
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
        var imgPlaylistPoster: ImageView
        var txtPlaylistName: TextView

        init {
            imgPlaylistPoster = convertView.findViewById(R.id.imgContentPoster)
            txtPlaylistName = convertView.findViewById(R.id.txtPlaylistName)
        }
    }

    interface OnPlayListItemSelectedListener {
        fun onPlayListItemSelected(playlist: UserPlaylistModel?)
    }

    fun setOnPlayListItemSelectedListener(onPlayListItemSelectedListener: OnPlayListItemSelectedListener?) {
        this.onPlayListItemSelectedListener = onPlayListItemSelectedListener
    }
}