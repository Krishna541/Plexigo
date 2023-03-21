package com.release.plexigo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.models.OTTModel

class OTTAdapter(
    var mContext: Context,
    all_otts: ArrayList<OTTModel>,
    plexigo_amount: String,
    rentValidity: String,
    listener: OTTClickHandler
) :
    RecyclerView.Adapter<OTTAdapter.ViewHolder>() {
    var path = ""
    var type: String? = null
    var all_otts: ArrayList<OTTModel>
    var plexigo_amount: String
    private val rentValidity: String
    var listener: OTTClickHandler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_ott_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        // change media icon
        path = all_otts[position].wideImagePath
        if (!TextUtils.isEmpty(path)){
            GlideApp
                .with(mContext)
                .load(path)
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .listener(object : RequestListener<Drawable?> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable?>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable?>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        listener.onImageLoaded()
                        holder.ott_icon.visibility = View.VISIBLE
                        return false
                    }
                })
                .into(holder.ott_icon)
        }
        holder.ppv_amount_ott.text = all_otts[position].buttonText
        if (all_otts[position].buttonIcon.equals("book" , true)) {
            holder.ppv_amount_ott.setCompoundDrawablesWithIntrinsicBounds(
                mContext.resources.getDrawable(
                    R.drawable.ic_book_ticket
                ), null, null, null
            )
        }
        /*
        if (all_otts.get(position).getOttPlatform().equals("Plexigo") && rentValidity.toLowerCase().equals("n")) {

            if (plexigo_amount.equalsIgnoreCase("free")) {
                holder.ppv_amount_ott.setText("Watch Now for Free");
            } else {
                if (!plexigo_amount.endsWith("-1")) {
                    holder.ppv_amount_ott.setText("Rent for " + plexigo_amount);
                } else {
                    holder.ppv_amount_ott.setText("Book Now");
                    holder.ppv_amount_ott.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.drawable.ic_book_ticket), null, null, null);
                }
            }
        } else {
            holder.ppv_amount_ott.setText("Watch on " + all_otts.get(position).getOttPlatform());
        }
*/holder.itemView.setOnClickListener {
            listener.OnOttClick(all_otts[position])
            /*  Intent intent = new Intent(mContext, CastDetailActivity.class);
        //                intent.putExtra("permalink", all_casts.get(position).getPermalink());
                    mContext.startActivity(intent);*/
        }
    }

    override fun getItemCount(): Int {
        return all_otts.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var ott_icon: ImageView
        var ppv_amount_ott: TextView

        init {
            ott_icon = convertView.findViewById<View>(R.id.ott_icon) as ImageView
            ppv_amount_ott = convertView.findViewById<View>(R.id.ppv_amount_ott) as TextView
        }
    }

    interface OTTClickHandler {
        fun onImageLoaded()
        fun OnOttClick(ottModel: OTTModel?)
    }

    init {
        this.all_otts = all_otts
        this.plexigo_amount = plexigo_amount
        this.rentValidity = rentValidity
        this.listener = listener
    }
}

