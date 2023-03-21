package com.release.plexigo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.R
import com.release.plexigo.adapter.CastAdapter
import com.release.plexigo.models.CastModel
import java.util.ArrayList


class CastAndCrewFragment : Fragment() {
    lateinit var all_casts: ArrayList<CastModel>
    lateinit var cast_listview: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_cast_and_crew, container, false)
        all_casts = requireArguments().getSerializable("casts") as ArrayList<CastModel>
        cast_listview = v.findViewById(R.id.cast_listview)
        val adapter = CastAdapter(requireActivity(), all_casts!!)
        val layoutManager = GridLayoutManager(activity, 3)
        cast_listview.setLayoutManager(layoutManager)
        cast_listview.setAdapter(adapter)
        return v
    }
}