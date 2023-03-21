package com.release.plexigo.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.release.plexigo.models.FilmScreening
import java.util.ArrayList

class FestivalScreeningArrayAdapter(
    context: Context,
    resId: Int,
    screenings: ArrayList<FilmScreening>
) : ArrayAdapter<FilmScreening?>(context, resId, screenings as List<FilmScreening?>) {
    private val screenings: List<FilmScreening>
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val label = super.getView(position, convertView, parent) as TextView
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.text = screenings[position].screeningDate

        // And finally return your dynamic (or custom) view for each spinner item
        return label
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val label = super.getView(position, convertView, parent) as TextView
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.text = screenings[position].screeningDate

        // And finally return your dynamic (or custom) view for each spinner item
        return label
    }

    init {
        this.screenings = screenings
    }
}
