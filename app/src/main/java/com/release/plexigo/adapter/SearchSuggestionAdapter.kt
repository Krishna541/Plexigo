package com.release.plexigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.TextView
import com.release.plexigo.R
import com.release.plexigo.models.SearchSuggestionModel
import java.util.*
import kotlin.collections.ArrayList

class SearchSuggestionAdapter constructor(context: Context, dataList: java.util.ArrayList<SearchSuggestionModel>) :
    ArrayAdapter<SearchSuggestionModel?>(
        context, 0, dataList as List<SearchSuggestionModel?>
    ) {
    private var dataList: List<SearchSuggestionModel>
    private lateinit var dataListAllItems: List<SearchSuggestionModel>
    private val listFilter: ListFilter = ListFilter()
    init {
        dataListAllItems = dataList
    }
    public override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // convertView which is recyclable view
        var currentItemView: View? = convertView

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext())
                .inflate(R.layout.item_search_suggestion, parent, false)
        }

        // get the position of the view from the ArrayAdapter
        val searchSuggestionModel: SearchSuggestionModel? = getItem(position)

        // then according to the position of the view assign the desired image for the same
        val txtSearchSuggestion: TextView = currentItemView!!.findViewById(R.id.txtSearchSuggestion)
        txtSearchSuggestion.setText(searchSuggestionModel!!.keyword)

        // then return the recyclable view
        return (currentItemView)
    }

    public override fun getDropDownView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        // convertView which is recyclable view
        var currentItemView: View? = convertView

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext())
                .inflate(R.layout.item_search_suggestion, parent, false)
        }

        // get the position of the view from the ArrayAdapter
        val searchSuggestionModel: SearchSuggestionModel? = getItem(position)

        // then according to the position of the view assign the desired image for the same
        val txtSearchSuggestion: TextView = currentItemView!!.findViewById(R.id.txtSearchSuggestion)
        txtSearchSuggestion.setText(searchSuggestionModel!!.keyword)

        // then return the recyclable view
        return (currentItemView)
    }

    public override fun getFilter(): Filter {
        return listFilter
    }

    inner class ListFilter constructor() : Filter() {
        private val lock: Any = Any()
        override fun performFiltering(prefix: CharSequence?): FilterResults {
            val results: FilterResults = FilterResults()
            if (dataListAllItems == null) {
                synchronized(lock) { dataListAllItems = ArrayList(dataList) }
            }
            if (prefix == null || prefix.length == 0) {
                synchronized(lock) {
                    results.values = dataListAllItems
                    results.count = dataListAllItems.size
                }
            } else {
                val searchStrLowerCase: String = prefix.toString().lowercase(Locale.getDefault())
                val matchValues: java.util.ArrayList<SearchSuggestionModel> = java.util.ArrayList()
                for (dataItem: SearchSuggestionModel in dataListAllItems) {
                    if (dataItem.keyword.lowercase(Locale.getDefault())
                            .startsWith(searchStrLowerCase)
                    ) {
                        matchValues.add(dataItem)
                    }
                }
                results.values = matchValues
                results.count = matchValues.size
            }
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults) {
            if (results.values != null) {
                dataList = results.values as List<SearchSuggestionModel>
            } else {
                dataList = emptyList()
            }
            if (results.count > 0) {
                notifyDataSetChanged()
            } else {
                notifyDataSetInvalidated()
            }
        }
    }

    init {
        this.dataList = dataList
    }
}