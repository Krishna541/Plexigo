package com.release.plexigo.adapter

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.R
import com.release.plexigo.models.LanguageModel

class TrailerByLanguageAdapter(
    var mContext: Context,
    languages: ArrayList<LanguageModel>,
    bannerPath: String,
    OnVideoSelected: OnVideoSelected?
) :
    RecyclerView.Adapter<TrailerByLanguageAdapter.ViewHolder>() {
    var font: Typeface? = null
    var path = ""
    var type: String? = null
    var languages: ArrayList<LanguageModel>
    private val bannerPath: String
    private val onVideoSelected: OnVideoSelected?
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content_trailer, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!TextUtils.isEmpty(bannerPath)) {
            Glide
                .with(mContext)
                .load(bannerPath)
                .transform(RoundedCorners(15))
                .into(holder.imgTrailer)
        }
        holder.itemView.setOnClickListener {
            onVideoSelected?.onLanguageSelected(
                languages[position]
            )
        }
    }

    override fun getItemCount(): Int {
        return languages.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgTrailer: ImageView

        init {
            imgTrailer = convertView.findViewById(R.id.imgTrailer)
        }
    }

    interface OnVideoSelected {
        fun onLanguageSelected(language: LanguageModel?)
    }

    init {
        this.languages = languages
        this.bannerPath = bannerPath
        onVideoSelected = OnVideoSelected
    }
}
