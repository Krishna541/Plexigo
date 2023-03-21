package com.release.plexigo.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.activity.ContentDetailActivity
import com.release.plexigo.models.MovieModel
import kotlinx.android.synthetic.main.activity_edit_profile.*


class QuickPickPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quick_pick_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = requireArguments().getSerializable("movie") as MovieModel?
        val imgQuickPick = view.findViewById<ImageView>(R.id.imgQuickPick)
        if (!TextUtils.isEmpty(movie!!.imagePath)) {
            GlideApp
                .with(requireContext())
                .load(movie.imagePath)
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .transform(RoundedCorners(15))
                .into(imgQuickPick)
        }
        view.setOnClickListener { v ->
            if (TextUtils.isEmpty(movie.externalWebLink)) {
                val intent = Intent(activity, ContentDetailActivity::class.java)
                intent.putExtra("movieId", movie.contentId)
                intent.putExtra("poster_url", movie.wideImagePath)
                requireActivity().startActivity(intent)
            } else {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(movie.externalWebLink)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                if (intent.resolveActivity(v.context.packageManager) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(v.context, "no na", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    companion object {
        fun newInstance(bannerModel: MovieModel?): QuickPickPagerFragment {
            val args = Bundle()
            val fragment = QuickPickPagerFragment()
            args.putSerializable("movie", bannerModel)
            fragment.arguments = args
            return fragment
        }
    }
}