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
import com.release.plexigo.R
import com.release.plexigo.activity.CastDetailActivity
import com.release.plexigo.models.CastModel

class CastCrewAdapter(var mContext: Context,castCrewList: ArrayList<CastModel>) :
    RecyclerView.Adapter<CastCrewAdapter.ViewHolder>() {
    var path = ""
    var castCrewList: ArrayList<CastModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cast_crew_content_detail, parent, false)
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
        path = castCrewList[position].imagepath
        if (!TextUtils.isEmpty(path)) {
            Glide
                .with(mContext)
                .load(path)
                .circleCrop()
                .into(holder.imgCastCrew)
        }
        holder.txtNameCastCrew.setText(castCrewList[position].name)
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, CastDetailActivity::class.java)
            intent.putExtra("name", castCrewList[position].name)
            intent.putExtra("imagepath", castCrewList[position].imagepath)
            intent.putExtra("castCrewId", castCrewList[position].castCrewId)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return castCrewList.size
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
        this.castCrewList = castCrewList
    }
}

