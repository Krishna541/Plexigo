package com.release.plexigo.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.fragment.MovieListingFragment


class FilterResultsActivity : AppCompatActivity() {
    private lateinit var imgBack: ImageView
    private lateinit var txtTitle: TextView
    private lateinit var btnFilter: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_results)
        initView()
    }

    private fun initView() {
        imgBack = findViewById(R.id.imgBack)
        txtTitle = findViewById<TextView>(R.id.txtTitle)
        btnFilter = findViewById<ImageButton>(R.id.btnFilter)
        val nestedScroll: NestedScrollView = findViewById<NestedScrollView>(R.id.nestedScroll)
        nestedScroll.setNestedScrollingEnabled(false)
        txtTitle.setText(intent.getStringExtra("title"))
        initData()
        imgBack.setOnClickListener(View.OnClickListener { onBackPressed() })
        AppConstants.showOttFilters = true
    }

    private fun initData() {
        if (intent.getBooleanExtra("contentByChannel", false)) {
            btnFilter.setVisibility(View.GONE)
            addFragment(
                MovieListingFragment.newInstance(
                    "contentByChannel",
                    intent.getIntExtra("channelId", 0),
                    intent.getIntExtra("channelCategoryId", 0),
                    intent.getStringExtra("type")
                )
            )
        } else {
            addFragment(MovieListingFragment.newInstance("all-movies"))
        }
        btnFilter.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@FilterResultsActivity,
                    FilterMoviesActivity::class.java
                )
            )
        })
    }

    fun addFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction
        transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.layoutChannelContent, fragment!!)
        transaction.commit()
    }

    public override fun onDestroy() {
        super.onDestroy()
        AppConstants.IsFilterActive = false
    }
}