package com.release.plexigo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.release.plexigo.R

class HomeLatestReleasesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_latest_releases, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val transaction: FragmentTransaction
        transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.layoutContainer, MovieListingFragment.newInstance("latest-releases"))
        transaction.commit()
    }

    companion object {
        fun newInstance(): HomeLatestReleasesFragment {
            val args = Bundle()
            val fragment = HomeLatestReleasesFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
