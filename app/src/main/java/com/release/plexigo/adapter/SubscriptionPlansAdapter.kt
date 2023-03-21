package com.release.plexigo.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.SubscriptionPlan

class SubscriptionPlansAdapter(
    subscriptionPlans: ArrayList<SubscriptionPlan>,
    onPlanSelected: OnPlanSelected?
) :
    RecyclerView.Adapter<SubscriptionPlansAdapter.ViewHolder>() {
    var font: Typeface? = null
    var path = ""
    var type: String? = null
    var subscriptionPlans: ArrayList<SubscriptionPlan>
    private val onPlanSelected: OnPlanSelected?
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
        holder.txtLanguage.setText(subscriptionPlans[position].subscriptionPlan)
        holder.itemView.setOnClickListener { //                onLanguageSelected.onLanguageSelected(subscriptionPlans.get(position).getSubscriptionPlan());
            onPlanSelected?.onPlanSelected(subscriptionPlans[position])
        }
    }

    override fun getItemCount(): Int {
        return subscriptionPlans.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtLanguage: TextView

        init {
            txtLanguage = convertView.findViewById(R.id.txtLanguage)
        }
    }

    interface OnPlanSelected {
        fun onPlanSelected(plan: SubscriptionPlan?)
    }

    init {
        this.subscriptionPlans = subscriptionPlans
        this.onPlanSelected = onPlanSelected
    }
}
