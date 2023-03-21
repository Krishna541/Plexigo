package com.release.plexigo.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.FilterOttAdapter
import com.release.plexigo.models.OTTModel
import kotlinx.android.synthetic.main.activity_filter_ott.*

class FilterOttActivity : AppCompatActivity(),
    FilterOttAdapter.OnFilterOttItemSelectedListener, View.OnClickListener {
    var filterOttAdapter: FilterOttAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_ott)
        initData()
    }

    private fun initData() {
        filterOttAdapter = FilterOttAdapter(this ,ArrayList(AppConstants.all_otts))
        recyclerFilterOtt!!.adapter = filterOttAdapter
        filterOttAdapter!!.setOnFilterOttItemSelectedListener(this)
        txtSelectAll!!.setOnClickListener(this)
        txtUnselectAll!!.setOnClickListener(this)
        back_btn!!.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.txtSelectAll -> {
                if (AppConstants.SelectedOTTList != null) {
                    AppConstants.SelectedOTTList!!.clear()
                    AppConstants.SelectedOTTList!!.addAll(AppConstants.all_otts!!)
                } else {
                    AppConstants.SelectedOTTList = ArrayList(AppConstants.all_otts)
                }
                filterOttAdapter!!.notifyDataSetChanged()
            }
            R.id.txtUnselectAll -> {
                if (AppConstants.SelectedOTTList != null) AppConstants.SelectedOTTList!!.clear()
                filterOttAdapter!!.notifyDataSetChanged()
            }
            R.id.back_btn -> onBackPressed()
        }
    }

    override fun onFilterOttItemSelectedListener(ottModel: OTTModel?) {
        if (AppConstants.SelectedOTTList == null) {
            AppConstants.SelectedOTTList = ArrayList()
            (AppConstants.SelectedOTTList as ArrayList<OTTModel>).add(ottModel!!)
        } else {
            var listUpdated = false
            for (i in AppConstants.SelectedOTTList!!.indices) {
                if (AppConstants.SelectedOTTList!![i].ottPlatform.equals(
                        ottModel?.ottPlatform,
                        ignoreCase = true
                    )
                ) {
                    AppConstants.SelectedOTTList!!.removeAt(i)
                    listUpdated = true
                    break
                }
            }
            if (!listUpdated) {
                AppConstants.SelectedOTTList!!.add(ottModel!!)
            }
        }
        filterOttAdapter!!.notifyDataSetChanged()
        if (AppConstants.SelectedGenreList != null && AppConstants.SelectedGenreList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else if (AppConstants.SelectedLanguageList != null && AppConstants.SelectedLanguageList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else if (AppConstants.SelectedOTTList != null && AppConstants.SelectedOTTList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else {
            if (AppConstants.IsFilterActive) {
                AppConstants.IsFilterActive = false
                AppConstants.ResetFilter = true
            }
        }
    }

    override fun onFilterOttItemSelectedListener(ottModel: OTTModel?, isSelected: Boolean) {
        if (AppConstants.SelectedOTTList == null) {
            AppConstants.SelectedOTTList = ArrayList()
            (AppConstants.SelectedOTTList as ArrayList<OTTModel>).add(ottModel!!)
        } else {
            if (isSelected) {
                AppConstants.SelectedOTTList!!.add(ottModel!!)
            } else {
                AppConstants.SelectedOTTList!!.remove(ottModel)
            }
        }
        filterOttAdapter!!.notifyDataSetChanged()
        if (AppConstants.SelectedGenreList != null && AppConstants.SelectedGenreList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else if (AppConstants.SelectedLanguageList != null && AppConstants.SelectedLanguageList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else if (AppConstants.SelectedOTTList != null && AppConstants.SelectedOTTList!!.size > 0) {
            AppConstants.IsFilterActive = true
        } else {
            if (AppConstants.IsFilterActive) {
                AppConstants.IsFilterActive = false
                AppConstants.ResetFilter = true
            }
        }
    }
}