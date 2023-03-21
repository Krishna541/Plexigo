package com.release.plexigo.adapter

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Typeface
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.R
import com.release.plexigo.activity.CastDetailActivity
import com.release.plexigo.models.CastModel
import kotlinx.android.synthetic.main.activity_edit_profile.*

class CastAdapter(var mContext: Context, all_casts: ArrayList<CastModel>) :
    RecyclerView.Adapter<CastAdapter.ViewHolder>() {
    var font: Typeface? = null
    var path = ""
    var type: String? = null
    var all_casts: ArrayList<CastModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_cast_listview_layout, parent, false)
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
        path = all_casts[position].imagepath
        if (!TextUtils.isEmpty(path)) {
            Glide
                .with(mContext)
                .load(path)
                .transform(RoundedCorners(12))
                .into(holder.cast_img)
        }
        holder.actor.setText(all_casts[position].name)
        //        holder.category.setText(all_casts.get(position).getCast_type());
        holder.full_layout.setOnClickListener {
            val intent = Intent(mContext, CastDetailActivity::class.java)
            intent.putExtra("name", all_casts[position].name)
            intent.putExtra("bio", all_casts[position].bio)
            intent.putExtra("imagepath", all_casts[position].imagepath)
            //                intent.putExtra("permalink", all_casts.get(position).getPermalink());
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return all_casts.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var cast_img: ImageView
        var actor: TextView
        var full_layout: ConstraintLayout

        init {
            actor = convertView.findViewById<View>(R.id.actor) as TextView
            cast_img = convertView.findViewById<View>(R.id.cast_img) as ImageView
            full_layout = convertView.findViewById(R.id.full_layout)
        }
    }

    init {
        this.all_casts = all_casts
    }
}
