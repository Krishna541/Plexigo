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
import com.release.plexigo.R
import com.release.plexigo.models.UserPlaylistModel

class PlaylistAdapter(var mContext: Context, playList: ArrayList<UserPlaylistModel>, smallLayout: Boolean) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {
    private val playList: ArrayList<UserPlaylistModel>
    private val smallLayout: Boolean
    private var onPlayListItemSelectedListener: OnPlayListItemSelectedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout: Int
        layout = if (smallLayout) R.layout.item_playlist_home_page else R.layout.item_playlist
        val v = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.txtPlaylistName.setText(playList[position].title)
        holder.txtPlaylistDetails.setText(playList[position].noofContent)
        if (!TextUtils.isEmpty(playList[position].poster)) {
            Glide
                .with(mContext)
                .load(playList[position].poster)
                .transform(RoundedCorners(12))
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
        var txtPlaylistDetails: TextView

        init {
            imgPlaylistPoster = convertView.findViewById(R.id.imgContentPoster)
            txtPlaylistName = convertView.findViewById(R.id.txtPlaylistName)
            txtPlaylistDetails = convertView.findViewById(R.id.txtPlalistDetails)
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
        this.smallLayout = smallLayout
    }
}
