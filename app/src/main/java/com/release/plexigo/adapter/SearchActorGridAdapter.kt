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
import com.release.plexigo.activity.NewHomeActivity
import com.release.plexigo.fragment.ExtendedSearchFragment
import com.release.plexigo.models.ActorModel
import java.util.ArrayList


class SearchActorGridAdapter constructor(
    var mContext: Context,
    private val actors: ArrayList<ActorModel>
) : RecyclerView.Adapter<SearchActorGridAdapter.ViewHolder>() {
    public override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_actor_grid, parent, false)
        //        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();

//        layoutParams.width = (Resources.getSystem().getDisplayMetrics().widthPixels / 3) - 100;
//        v.setLayoutParams(layoutParams);
        return ViewHolder(v)
    }

    public override fun getItemViewType(position: Int): Int {
        return position
    }

    public override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        // change media icon
        if (!TextUtils.isEmpty(actors.get(position).imagepath)) {
            Glide
                .with(mContext)
                .load(actors.get(position).imagepath)
                .transform(RoundedCorners(12))
                .into(holder.imgActor)

        }
        holder.txtActorName.setText(actors.get(position).name)
        //        holder.category.setText(all_casts.get(position).getCast_type());
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            public override fun onClick(v: View) {
                (mContext as NewHomeActivity).replaceFragment(
                    ExtendedSearchFragment.newInstance(
                        "searchMoviesByActor",
                        actors.get(position).actorId
                    ), true
                )
            }
        })
    }

    public override fun getItemCount(): Int {
        return actors.size
    }

    inner class ViewHolder constructor(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgActor: ImageView
        var txtActorName: TextView

        init {
            txtActorName = convertView.findViewById(R.id.txtActorName)
            imgActor = convertView.findViewById(R.id.imgActor)
        }
    }
}