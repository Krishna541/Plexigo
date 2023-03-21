package com.release.plexigo.adapter

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.activity.UserPlaylistListingActivity
import com.release.plexigo.models.TopUserListModel

class FollowedUserAdapter(var mContext: Context, followedUserList: ArrayList<TopUserListModel>) :
    RecyclerView.Adapter<FollowedUserAdapter.ViewHolder>() {
    var path = ""
    var followedUserList: ArrayList<TopUserListModel>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_followed_user, parent, false)
        val layoutParams = v.layoutParams
        layoutParams.width =
            Resources.getSystem().displayMetrics.widthPixels / 3 - 100
        //        v.setLayoutParams(layoutParams);
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // change media icon
        path = followedUserList[position].imagepath
        if (!TextUtils.isEmpty(path)) {
            GlideApp
                .with(mContext)
                .load(path)
                .circleCrop()
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .into(holder.imgCastCrew)
        }
        holder.txtNameCastCrew.setText(followedUserList[position].userName)
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, UserPlaylistListingActivity::class.java)
            intent.putExtra("playlistUserId", followedUserList[position].userId)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return followedUserList.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgCastCrew: ImageView
        var txtNameCastCrew: TextView

        init {
            txtNameCastCrew = convertView.findViewById<View>(R.id.txtNameCastCrew) as TextView
            imgCastCrew = convertView.findViewById<View>(R.id.imgCastCrew) as ImageView
        }
    }

    init {
        this.followedUserList = followedUserList
    }
}

