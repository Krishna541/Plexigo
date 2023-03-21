package com.release.plexigo.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.FaqModel

class OfferFaqAdapter(var mContext: Context, faqList: ArrayList<FaqModel>) :
    RecyclerView.Adapter<OfferFaqAdapter.ViewHolder>() {
    var faqList: ArrayList<FaqModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.offer_faq_item_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("faq", "onBindViewHolder: $faqList")
        holder.questions.setText(faqList[position].question)
        holder.answers.setText(faqList[position].answer)
    }

    override fun getItemCount(): Int {
        return faqList.size
    }

    class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var questions: TextView
        var answers: TextView

        init {
            questions = convertView.findViewById(R.id.questions)
            answers = convertView.findViewById(R.id.answer)
        }
    }

    init {
        this.faqList = faqList
    }
}
