package com.release.plexigo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.activity.FilterResultsActivity
import com.release.plexigo.models.ChannelCategoryModel
import com.release.plexigo.models.MovieModel


class ContentMainListAdapter(
    var mContext: Context,
    var all_sections: ArrayList<ChannelCategoryModel>,
    channelId: Int,
    channelType: String
) : RecyclerView.Adapter<ContentMainListAdapter.ViewHolder>() {
    var subContentLayoutManager: RecyclerView.LayoutManager
    private val channelId: Int
    private val channelType: String
    var movieList: ArrayList<MovieModel> = ArrayList<MovieModel>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_content_main_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.section_name.text = all_sections[position].channelCategory
        movieList = all_sections[position].content
        val subContemtListAdapter = SubContentListAdapter(mContext, movieList)
        holder.sub_content_list.setHasFixedSize(true)
        holder.sub_content_list.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        holder.sub_content_list.adapter = subContemtListAdapter
        if (movieList!!.size < 10) {
            holder.more.visibility = View.INVISIBLE
        } else {
            holder.more.visibility = View.VISIBLE
        }
        holder.more.setOnClickListener {
            val intent = Intent(mContext, FilterResultsActivity::class.java)
            intent.putExtra("contentByChannel", true)
            intent.putExtra("channelId", channelId)
            intent.putExtra("channelCategoryId", all_sections[position].channelCategoryId)
            intent.putExtra("title", all_sections[position].channelCategory + " Movies")
            intent.putExtra("type", channelType)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return all_sections.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var section_name: TextView
        var more: TextView
        var sub_content_list: RecyclerView

        init {
            section_name = convertView.findViewById<View>(R.id.section_name) as TextView
            more = convertView.findViewById<View>(R.id.more) as TextView
            sub_content_list = convertView.findViewById<View>(R.id.sub_content_list) as RecyclerView
            convertView.findViewById<View>(R.id.layoutTopUser).visibility = View.GONE
            convertView.findViewById<View>(R.id.topGradient).visibility =
                View.GONE
            convertView.findViewById<View>(R.id.bottomGradient).visibility =
                View.GONE
        }
    }

    init {
        subContentLayoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        this.channelId = channelId
        this.channelType = channelType
    }
}