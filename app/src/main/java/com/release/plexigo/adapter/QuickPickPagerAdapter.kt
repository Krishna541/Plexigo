package com.release.plexigo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.release.plexigo.fragment.QuickPickPagerFragment
import com.release.plexigo.models.MovieModel

/**
 * Created by Tarak Bhawalkar on Oct 06, 2020 at 17:16
 */
class QuickPickPagerAdapter(fm: FragmentManager, movies: ArrayList<MovieModel>?) :
    FragmentPagerAdapter(fm) {
    private val movies: ArrayList<MovieModel> = ArrayList<MovieModel>()
    override fun getItem(position: Int): Fragment {
        return QuickPickPagerFragment.newInstance(movies[position])
    }

    override fun getCount(): Int {
        return Math.max(movies.size, 0)
    }

    init {
        this.movies.clear()
        this.movies.addAll(movies!!)
    }
}