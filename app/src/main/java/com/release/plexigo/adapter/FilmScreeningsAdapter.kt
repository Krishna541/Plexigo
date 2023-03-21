package com.release.plexigo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.activity.ContentDetailActivity
import com.release.plexigo.models.FilmScreeningData
import java.util.ArrayList

class FilmScreeningsAdapter(
    var mContext: Context,
    var filmScreeningData: ArrayList<FilmScreeningData>
) : RecyclerView.Adapter<FilmScreeningsAdapter.ViewHolder>() {
    var path = ""
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_festival_event, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        path = filmScreeningData[position].wideImagePath
        GlideApp
            .with(mContext)
            .load(path)
            .placeholder(R.drawable.plexigo_new_transperent_logo)
            .into(holder.imgEvent)
        holder.txtEventDuration.text = filmScreeningData[position].duration
        holder.txtEventName.text = filmScreeningData[position].contentName
        holder.txtEventDescription.text = "Language: " + filmScreeningData[position].language
        holder.itemView.setOnClickListener { //                if (TextUtils.isEmpty(filmEventData.get(position).getExternalWebLink())) {
            val intent = Intent(mContext, ContentDetailActivity::class.java)
            intent.putExtra("poster_url", filmScreeningData[position].imagePath)
            intent.putExtra("movieId", filmScreeningData[position].contentId)
            mContext.startActivity(intent)
            /*

                    } else {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(filmEventData.get(position).getExternalWebLink()));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                            mContext.startActivity(intent);
                        } else {
                            Toast.makeText(v.getContext(), "no na", Toast.LENGTH_LONG).show();
                        }
                    }
    */
        }
    }

    override fun getItemCount(): Int {
        return filmScreeningData.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgEvent: ImageView
        var txtEventName: TextView
        var txtEventDescription: TextView
        var txtEventDuration: TextView

        init {
            imgEvent = convertView.findViewById<View>(R.id.imgEvent) as ImageView
            txtEventName = convertView.findViewById(R.id.txtEventName)
            txtEventDuration = convertView.findViewById(R.id.txtEventDuration)
            txtEventDescription = convertView.findViewById(R.id.txtEventDescription)
        }
    }
}