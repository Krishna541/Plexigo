package com.release.plexigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.models.FilmEventData
import java.util.ArrayList


class FilmEventsAdapter(var mContext: Context, var filmEventData: ArrayList<FilmEventData>) :
    RecyclerView.Adapter<FilmEventsAdapter.ViewHolder>() {
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
        path = filmEventData[position].imagepath
        GlideApp
            .with(mContext)
            .load(path)
            .placeholder(R.drawable.plexigo_new_transperent_logo)
            .into(holder.imgEvent)
        holder.txtEventDuration.text = filmEventData[position].duration
        holder.txtEventName.text = filmEventData[position].title
        holder.txtEventDescription.text = filmEventData[position].description

/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(filmEventData.get(position).getExternalWebLink())) {
                    Intent intent = new Intent(mContext, ContentDetailActivity.class);
                    intent.putExtra("poster_url", filmEventData.get(position).getImagePath());
                    intent.putExtra("movieId", filmEventData.get(position).getContentId());
                    mContext.startActivity(intent);

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

            }
        });

*/
    }

    override fun getItemCount(): Int {
        return filmEventData.size
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