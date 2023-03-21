package com.release.plexigo.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.R
import com.release.plexigo.activity.ContentDetailActivity
import com.release.plexigo.models.BannerModel
import kotlinx.android.synthetic.main.activity_edit_profile.*


class HomePagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bannerModel = requireArguments().getSerializable("banner") as BannerModel?
        val imgBanner = view.findViewById<ImageView>(R.id.imgBanner)
        /*
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mOTVVideoView.getLayoutParams();
        params.width = params.MATCH_PARENT;
        params.height = (int) (250 * getApplicationContext().getResources().getDisplayMetrics().density);
        mOTVVideoView.setLayoutParams(params);
*/
        val txtContentName = view.findViewById<TextView>(R.id.txtContentName)
        val txtContentLanguage = view.findViewById<TextView>(R.id.txtContentLanguage)
        val txtYear = view.findViewById<TextView>(R.id.txtYear)
        val imagePath: String
        imagePath = if (requireArguments().getBoolean(
                "isWhatsNewBanner",
                false )
        ){ bannerModel!!.wideImagePath }else {bannerModel!!.imagePath}
        GlideApp
            .with(requireContext())
            .load(imagePath)
            .placeholder(R.drawable.plexigo_new_transperent_logo)
            .into(imgBanner)
        txtContentLanguage.text = bannerModel.language
        txtContentName.text = bannerModel.contentName
        txtYear.text = bannerModel.year.toString()
        view.setOnClickListener { v ->
            if (TextUtils.isEmpty(bannerModel.externalWebLink)) {
                val intent = Intent(activity, ContentDetailActivity::class.java)
                intent.putExtra("movieId", bannerModel.contentId)
                intent.putExtra("poster_url", bannerModel.nImagePath)
                requireActivity().startActivity(intent)
            } else {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(bannerModel.externalWebLink)
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
        fun newInstance(bannerModel: BannerModel?, isWhatsNewBanner: Boolean): HomePagerFragment {
            val args = Bundle()
            val fragment = HomePagerFragment()
            args.putSerializable("banner", bannerModel)
            args.putSerializable("isWhatsNewBanner", isWhatsNewBanner)
            fragment.arguments = args
            return fragment
        }
    }
}