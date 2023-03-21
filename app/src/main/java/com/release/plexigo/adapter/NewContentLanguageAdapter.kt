package com.release.plexigo.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.models.LanguageModel

class NewContentLanguageAdapter(
    languages: ArrayList<LanguageModel>,
    onLanguageSelected: OnLanguageSelected?,
    selectedLanguage: LanguageModel
) :
    RecyclerView.Adapter<NewContentLanguageAdapter.ViewHolder>() {
    var font: Typeface? = null
    var path = ""
    var type: String? = null
    var languages: ArrayList<LanguageModel>
    private val onLanguageSelected: OnLanguageSelected?
    private val selectedLanguage: LanguageModel
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content_language, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtContentLanguage.setText(languages[position].language)
        if (selectedLanguage.languageId == languages[position].languageId) {
            holder.txtContentLanguage.setCompoundDrawablesRelativeWithIntrinsicBounds(
                ContextCompat.getDrawable(
                    holder.txtContentLanguage.context,
                    R.drawable.ic_selected
                ), null, null, null
            )
        } else {
            holder.txtContentLanguage.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null,
                null,
                null,
                null
            )
        }
        if (onLanguageSelected != null) {
            holder.itemView.setOnClickListener { onLanguageSelected.onLanguageSelected(languages[position]) }
        }
    }

    override fun getItemCount(): Int {
        return languages.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtContentLanguage: TextView

        init {
            txtContentLanguage = convertView.findViewById(R.id.txtContentLanguage)
        }
    }

    interface OnLanguageSelected {
        fun onLanguageSelected(language: LanguageModel?)
    }

    init {
        this.languages = languages
        this.onLanguageSelected = onLanguageSelected
        this.selectedLanguage = selectedLanguage
    }
}
