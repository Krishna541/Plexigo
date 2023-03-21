package com.release.plexigo.fragment

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.models.OnBoardingModel
import kotlinx.android.synthetic.main.activity_edit_profile.*


class OnBoardingPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val onBoardingModel = requireArguments().getSerializable("onBoarding") as OnBoardingModel?
        val imgOnBoarding = view.findViewById<ImageView>(R.id.imgOnBoardingContent)
        val cardContent = view.findViewById<CardView>(R.id.cardContent)
        val imgOnBoardingPerson = view.findViewById<ImageView>(R.id.imgOnBoardingPerson)
        val txtName = view.findViewById<TextView>(R.id.txtName)
        if (onBoardingModel!!.type.equals("Content", ignoreCase = true)) {
            val layoutParams = imgOnBoarding.layoutParams
            val width = (Resources.getSystem().displayMetrics.widthPixels * 0.7).toInt()
            layoutParams.width = width
            layoutParams.height = (width * 1.778).toInt()
            imgOnBoarding.layoutParams = layoutParams
            txtName.visibility = View.GONE
            imgOnBoardingPerson.visibility = View.GONE
            cardContent.visibility = View.VISIBLE
            Log.d("model", "onViewCreated: "+onBoardingModel)
            GlideApp
                .with(requireContext())
                .load(onBoardingModel.imagePath)
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .into(imgOnBoarding)
        } else {
            val layoutParams = imgOnBoardingPerson.layoutParams
            layoutParams.width = (Resources.getSystem().displayMetrics.widthPixels * 0.6).toInt()
            layoutParams.height = (Resources.getSystem().displayMetrics.widthPixels * 0.6).toInt()
            imgOnBoardingPerson.layoutParams = layoutParams
            txtName.visibility = View.VISIBLE
            txtName.text = onBoardingModel.name
            imgOnBoardingPerson.visibility = View.VISIBLE
            cardContent.visibility = View.GONE
            GlideApp
                .with(requireContext())
                .load(onBoardingModel.imagePath)
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .into(imgOnBoardingPerson)
        }
    }

    companion object {
        fun newInstance(onBoarding: OnBoardingModel?): OnBoardingPagerFragment {
            val args = Bundle()
            val fragment = OnBoardingPagerFragment()
            Log.d("inside", "newInstance: inside fragment")
            args.putSerializable("onBoarding", onBoarding)
            fragment.arguments = args
            return fragment
        }
    }
}