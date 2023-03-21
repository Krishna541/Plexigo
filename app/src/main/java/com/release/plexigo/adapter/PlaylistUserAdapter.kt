package com.release.plexigo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.release.plexigo.R
import com.release.plexigo.activity.UserPlaylistListingActivity
import com.release.plexigo.models.PlaylistUserModel


class PlaylistUserAdapter constructor(var mContext: Context, private val playListUsers: ArrayList<PlaylistUserModel>) :
    RecyclerView.Adapter<PlaylistUserAdapter.ViewHolder>() {
    public override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_playlist_user, parent, false)
        return ViewHolder(v)
    }

    public override fun getItemViewType(position: Int): Int {
        return position
    }

    public override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        if (!TextUtils.isEmpty(playListUsers.get(position).imagePath)){
            Glide
                .with(mContext)
                .load(playListUsers.get(position).imagePath)
                .into(holder.imgPlaylistUser)
        }
        holder.txtPlaylistUserName.setText(playListUsers.get(position).userName)
        holder.txtPlaylistUserDetails.setText(playListUsers.get(position).playlistCount)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            public override fun onClick(v: View) {
                val intent: Intent =
                    Intent(holder.itemView.getContext(), UserPlaylistListingActivity::class.java)
                intent.putExtra("playlistUserId", playListUsers.get(position).userId)
                holder.itemView.getContext().startActivity(intent)
            }
        })
    }

    public override fun getItemCount(): Int {
        return playListUsers.size
    }

    class ViewHolder constructor(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgPlaylistUser: ImageView
        var txtPlaylistUserName: TextView
        var txtPlaylistUserDetails: TextView

        init {
            imgPlaylistUser = convertView.findViewById(R.id.imgPlaylistUser)
            txtPlaylistUserName = convertView.findViewById(R.id.txtPlaylistUserName)
            txtPlaylistUserDetails = convertView.findViewById(R.id.txtPlaylistUserDetails)
        }
    }
}