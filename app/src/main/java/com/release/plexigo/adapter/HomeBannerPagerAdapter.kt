package com.release.plexigo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.release.plexigo.fragment.HomePagerFragment
import com.release.plexigo.models.BannerModel

class HomeBannerPagerAdapter(
    fm: FragmentManager,
    banners: ArrayList<BannerModel>?,
    private val isWhatsNewBanner: Boolean
) :
    FragmentPagerAdapter(fm) {
    private val banners: ArrayList<BannerModel> = ArrayList<BannerModel>()
    override fun getItem(position: Int): Fragment {
        return HomePagerFragment.newInstance(banners[position], isWhatsNewBanner)
    }

    override fun getCount(): Int {
        return Math.max(banners.size, 0)
    }

    init {
        this.banners.clear()
        this.banners.addAll(banners!!)
    }
}
