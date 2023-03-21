package com.release.plexigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.release.plexigo.R
import com.release.plexigo.models.TvSeriesEpisode
import kotlinx.android.synthetic.main.activity_edit_profile.*

class TvSeriesEpisodeAdapter(
    var mContext: Context,
    episodes: ArrayList<TvSeriesEpisode>,
    private val onEpisodeClickedListener: OnEpisodeClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val tvSeriesEpisodes: MutableList<TvSeriesEpisode>? = ArrayList<TvSeriesEpisode>()
    var flag = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewItem: View = inflater.inflate(R.layout.card_episode_item, parent, false)
        return MovieVH(viewItem)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val result: TvSeriesEpisode = tvSeriesEpisodes!![position]
        val movieVH = holder as MovieVH
        movieVH.episode_title.text = result.episodename
        movieVH.episode_desc.text = result.overview

//        movieVH.episode_desc.post(new Runnable() {
//            @Override
//            public void run() {
//                int lineCount = movieVH.episode_desc.getLineCount();
//                if (lineCount > 2) {
//                    movieVH.edt_more.setVisibility(View.VISIBLE);
//                    movieVH.episode_desc.setMaxLines(2);
//                    movieVH.episode_desc.setText(result.getOverview());
//                }
//
//            }
//        });
        movieVH.episode_desc.viewTreeObserver.addOnGlobalLayoutListener(object :
            OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                movieVH.episode_desc.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val linecount = movieVH.episode_desc.lineCount
                if (linecount > 2) {
                    movieVH.edt_more.visibility = View.VISIBLE
                    movieVH.episode_desc.maxLines = 2
                    movieVH.episode_desc.text = result.overview
                } else {
                    movieVH.edt_more.visibility = View.GONE
                }
            }
        })
        movieVH.edt_more.setOnClickListener {
            if (flag) {
                movieVH.edt_more.text = "..More"
                movieVH.episode_desc.maxLines = 2
                movieVH.episode_desc.setText(result.overview)
                flag = false
            } else {
                movieVH.edt_more.text = "..Less"
                movieVH.episode_desc.maxLines = Int.MAX_VALUE
                movieVH.episode_desc.setText(result.overview)
                flag = true
            }
        }
        movieVH.episode_duration.setText(result.duration)
        Glide
            .with(mContext)
            .load(result.poster)
            .into(movieVH.episode_poster)
        movieVH.itemView.setOnClickListener { onEpisodeClickedListener.onEpisodeClicked(result) }
    }

    override fun getItemCount(): Int {
        return tvSeriesEpisodes?.size ?: 0
    }

    protected inner class MovieVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val episode_poster: ImageView
        val episode_title: TextView
        val episode_desc: TextView
        val episode_duration: TextView
        val edt_more: TextView

        init {
            episode_poster = itemView.findViewById(R.id.episode_poster)
            episode_title = itemView.findViewById(R.id.episode_title)
            episode_desc = itemView.findViewById(R.id.episode_desc)
            episode_duration = itemView.findViewById(R.id.episode_duration)
            edt_more = itemView.findViewById(R.id.edt_more)
        }
    }

    fun setTvSeriesEpisodes(tvSeriesEpisodes: List<TvSeriesEpisode>?) {
        this.tvSeriesEpisodes!!.clear()
        this.tvSeriesEpisodes.addAll(tvSeriesEpisodes!!)
        notifyDataSetChanged()
    }

    interface OnEpisodeClickListener {
        fun onEpisodeClicked(episode: TvSeriesEpisode?)
    }

    init {
        tvSeriesEpisodes!!.clear()
        if (episodes.size > 0) tvSeriesEpisodes.addAll(episodes)
    }
}
