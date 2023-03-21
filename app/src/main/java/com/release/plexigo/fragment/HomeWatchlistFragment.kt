package com.release.plexigo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.release.plexigo.R

class HomeWatchlistFragment : Fragment() {
    var tabWatchlist: TabLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_watchlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabWatchlist = view.findViewById(R.id.tabWatchlist)
        tabWatchlist!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> replaceFragment(MovieListingFragment.newInstance("watchhistory"), false)
                    1 -> replaceFragment(PlaylistListingFragment.newInstance(), false)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        val transaction: FragmentTransaction
        transaction = childFragmentManager.beginTransaction()
        transaction.add(
            R.id.layoutContainerWatchlist,
            MovieListingFragment.newInstance("watchhistory")
        )
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction: FragmentTransaction
        transaction = childFragmentManager.beginTransaction()
        if (addToBackStack) transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.replace(R.id.layoutContainerWatchlist, fragment)
        transaction.commit()
    }

    companion object {
        fun newInstance(): HomeWatchlistFragment {
            val args = Bundle()
            val fragment = HomeWatchlistFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
