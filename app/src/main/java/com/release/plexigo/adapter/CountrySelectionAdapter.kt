package com.release.plexigo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.CountryModel

class CountrySelectionAdapter(
    countries: ArrayList<CountryModel>,
    onCountrySelected: OnCountrySelected?
) :
    RecyclerView.Adapter<CountrySelectionAdapter.ViewHolder>() {
    var countries: ArrayList<CountryModel>
    private val onCountrySelected: OnCountrySelected?
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
        holder.txtLanguage.setText(countries[position].country_name)
        holder.itemView.setOnClickListener {
            onCountrySelected?.onCountrySelected(
                countries[position]
            )
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtLanguage: TextView

        init {
            txtLanguage = convertView.findViewById(R.id.txtLanguage)
            txtLanguage.setTextColor(Color.parseColor("#FFFFFF"))
        }
    }

    interface OnCountrySelected {
        fun onCountrySelected(country: CountryModel?)
    }

    init {
        this.countries = countries
        this.onCountrySelected = onCountrySelected
    }
}
