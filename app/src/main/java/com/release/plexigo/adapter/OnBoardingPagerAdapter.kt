package com.release.plexigo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.release.plexigo.fragment.OnBoardingPagerFragment
import com.release.plexigo.models.OnBoardingModel


class OnBoardingPagerAdapter(
    fm: FragmentManager,
    onBoardingQuestions: ArrayList<OnBoardingModel>?
) :
    FragmentPagerAdapter(fm) {
    private val onBoardingQuestions = ArrayList<OnBoardingModel>()
    override fun getItem(position: Int): Fragment {
        return OnBoardingPagerFragment.newInstance(onBoardingQuestions[position])
    }

    override fun getCount(): Int {
        return Math.max(onBoardingQuestions.size, 0)
    }

    init {
        this.onBoardingQuestions.clear()
        this.onBoardingQuestions.addAll(onBoardingQuestions!!)
    }
}
