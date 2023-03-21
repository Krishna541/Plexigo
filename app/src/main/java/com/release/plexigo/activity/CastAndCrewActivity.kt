package com.release.plexigo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.adapter.CastAdapter
import com.release.plexigo.models.CastModel
import kotlinx.android.synthetic.main.activity_cast_and_crew.*

class CastAndCrewActivity: AppCompatActivity() {

    var all_casts: ArrayList<CastModel>? = null
    var permalink: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cast_and_crew)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.title = "Cast and Crew"
        toolbar.setNavigationOnClickListener({ onBackPressed() })
        all_casts = intent.getSerializableExtra("casts") as ArrayList<CastModel>?
        val adapter = CastAdapter(this@CastAndCrewActivity, all_casts!!)
        cast_listview.layoutManager = LinearLayoutManager(
            this@CastAndCrewActivity,
            RecyclerView.VERTICAL,
            false
        )
        cast_listview.adapter = adapter
    }

}

