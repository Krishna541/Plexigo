package com.release.plexigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R

class SortCategoriesAdapter(var mContext: Context) :
    RecyclerView.Adapter<SortCategoriesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_sort_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        if(position == AppConstants.defaultSortposition){
//            holder.radiobox.setChecked(true);
//        }else{
        holder.radiobox.isChecked = false
        //        }
        holder.sort_category.setText(AppConstants.all_languages!![position].languageGroup)
        holder.full_layout.setOnClickListener {
            holder.radiobox.isChecked = true
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return AppConstants.all_languages!!.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var radiobox: RadioButton
        var sort_category: TextView
        var full_layout: LinearLayout

        init {
            sort_category = convertView.findViewById<View>(R.id.sort_category) as TextView
            radiobox = convertView.findViewById<View>(R.id.radiobox) as RadioButton
            full_layout = convertView.findViewById(R.id.full_layout)
        }
    }
}
