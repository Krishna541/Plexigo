package com.release.plexigo.adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.ChatModel

class ChatAdapter(var mContext: Context, all_chats: ArrayList<ChatModel>) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    var font: Typeface? = null
    var all_chats: ArrayList<ChatModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_chat_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.message.setText(all_chats[position].message)
        holder.datetime.setText(all_chats[position].timestring)
    }

    override fun getItemCount(): Int {
        return all_chats.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var message: TextView
        var datetime: TextView

        init {
            message = convertView.findViewById<View>(R.id.message) as TextView
            datetime = convertView.findViewById(R.id.datetime)
        }
    }

    init {
        this.all_chats = all_chats
    }
}

