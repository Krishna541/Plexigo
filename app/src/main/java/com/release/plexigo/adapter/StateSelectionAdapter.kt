package com.release.plexigo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.StateModel

class StateSelectionAdapter(states: ArrayList<StateModel>, onStateSelected: OnStateSelected?) :
    RecyclerView.Adapter<StateSelectionAdapter.ViewHolder>() {
    var states: ArrayList<StateModel>
    private val onStateSelected: OnStateSelected?
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_language_content_detail, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtLanguage.setText(states[position].state_name)
        holder.itemView.setOnClickListener { onStateSelected?.onStateSelected(states[position]) }
    }

    override fun getItemCount(): Int {
        return states.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtLanguage: TextView

        init {
            txtLanguage = convertView.findViewById(R.id.txtLanguage)
            txtLanguage.setTextColor(Color.parseColor("#FFFFFF"))
        }
    }

    interface OnStateSelected {
        fun onStateSelected(state: StateModel?)
    }

    init {
        this.states = states
        this.onStateSelected = onStateSelected
    }
}
