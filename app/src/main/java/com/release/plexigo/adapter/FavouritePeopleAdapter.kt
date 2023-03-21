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
import com.release.plexigo.activity.CastDetailActivity
import com.release.plexigo.models.ActorModel
import kotlinx.android.synthetic.main.activity_edit_profile.*

class FavouritePeopleAdapter(var mContext: Context, actorList: ArrayList<ActorModel>) :
    RecyclerView.Adapter<FavouritePeopleAdapter.ViewHolder>() {
    var path = ""
    var actorList: ArrayList<ActorModel>
    private var onPersonLongClick: OnPersonLongClick? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_followed_user, parent, false)
        val layoutParams = v.layoutParams
        layoutParams.width =
            Resources.getSystem().displayMetrics.widthPixels / 3 - 100
        v.layoutParams = layoutParams
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // change media icon
        path = actorList[position].imagepath
        if (!TextUtils.isEmpty(path)) {
            GlideApp
                .with(mContext)
                .load(path)
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .into(holder.imgCastCrew)
        }
        holder.txtNameCastCrew.setText(actorList[position].name)
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, CastDetailActivity::class.java)
            intent.putExtra("name", actorList[position].name)
            intent.putExtra("imagepath", actorList[position].imagepath)
            intent.putExtra("castCrewId", actorList[position].actorId)
            v.context.startActivity(intent)
        }
        holder.itemView.setOnLongClickListener {
            if (onPersonLongClick != null) {
                onPersonLongClick!!.onPersonLongClicked(actorList[position])
            }
            false
        }
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    interface OnPersonLongClick {
        fun onPersonLongClicked(actorModel: ActorModel?)
    }

    fun setOnPersonLongClickListener(onPersonLongClick: OnPersonLongClick?) {
        this.onPersonLongClick = onPersonLongClick
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
        this.actorList = actorList
    }
}

