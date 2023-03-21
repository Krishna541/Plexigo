package com.release.plexigo.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.activity.*
import com.release.plexigo.fragment.ExtendedSearchFragment
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import com.smarteist.autoimageslider.IndicatorView.PageIndicatorView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.util.*
import kotlin.collections.ArrayList

class HomeFragmentContentAdapter(
    var mContext: Context,
    all_contents: ArrayList<HomePageListingModel>,
    topUserListModel: ArrayList<TopUserListModel>,
    curatedText: String,
    curatedImage: String,
    curatedLinkText: String,
    curatedCategoryId: Int
) :
    RecyclerView.Adapter<HomeFragmentContentAdapter.ViewHolder>() {
    private var topUserListIndex: Int
    var subContentLayoutManager: RecyclerView.LayoutManager
    private val topUserListModel: ArrayList<TopUserListModel>
    private val curatedText: String
    private val curatedImage: String
    private val curatedLinkText: String
    private val curatedCategoryId: Int
    var movieList: ArrayList<MovieModel>? = null
    var playlists: ArrayList<MovieModel>? = null
    var all_sections: ArrayList<HomePageListingModel>
    var moodPlaylist: ArrayList<UserPlaylistModel>? = null
    var topUserPlaylistContent: ArrayList<MovieModel>? = null
    var queue: RequestQueue
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_content_main_list, parent, false)
        val viewHolder = ViewHolder(v)
        viewHolder.setIsRecyclable(false)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position % 2 == 0) {
            holder.topGradient.visibility = View.GONE
            holder.bottomGradient.visibility = View.GONE
        } else {
            holder.topGradient.visibility = View.VISIBLE
            holder.bottomGradient.visibility = View.VISIBLE
        }
        holder.layoutTopUser.visibility = View.GONE
        holder.dotsIndicator.visibility = View.GONE
        if (all_sections[position].viewType === AppConstants.HOME_PAGE_LIST_VIEW_TYPE_CONTENT) {
            val contentModel: HomeApiCategoryModel =
                all_sections[position].content as HomeApiCategoryModel
            holder.section_name.text = contentModel.category
            movieList = contentModel.content
            if (contentModel.category.lowercase(Locale.getDefault()).contains("live")) {
                for (i in movieList!!.indices) {
                    movieList!![i].isLiveContent = true
                }
            }
            val subContemtListAdapter = HomeScreenSubContentAdapter(
                mContext,
                movieList!!.size,
                all_sections[position].viewType,
                all_sections[position]
            )
            holder.sub_content_list.setHasFixedSize(true)
            holder.sub_content_list.layoutManager =
                LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
            holder.sub_content_list.adapter = subContemtListAdapter
            if (movieList!!.size < 10) {
                holder.more.visibility = View.INVISIBLE
            } else {
                holder.more.visibility = View.VISIBLE
            }
            holder.more.setOnClickListener {
                val intent = Intent(mContext, MoreContentListActivity::class.java)
                intent.putExtra("section", holder.section_name.text.toString())
                intent.putExtra("id", contentModel.categoryId)
                mContext.startActivity(intent)
            }
            if (curatedCategoryId == contentModel.categoryId) {
                holder.imgTopUserLeft.visibility = View.GONE
                holder.imgTopUserRight.visibility = View.GONE
                holder.layoutTopUser.visibility = View.VISIBLE
                if (!TextUtils.isEmpty(curatedImage)) {
                    GlideApp
                        .with(mContext)
                        .load(curatedImage)
                        .circleCrop()
                        .placeholder(R.drawable.plexigo_new_transperent_logo)
                        .into(holder.imgTopUser)
                }
                val completeCuratedText = "$curatedLinkText : $curatedText"
                val str = SpannableStringBuilder(completeCuratedText)
                val clickableSpan: ClickableSpan = object : ClickableSpan() {
                    override fun onClick(textView: View) {}
                    override fun updateDrawState(ds: TextPaint) {
                        super.updateDrawState(ds)
                        ds.isUnderlineText = true
                        ds.linkColor = mContext.resources.getColor(R.color.colorAccent)
                    }
                }
                str.setSpan(
                    clickableSpan,
                    0,
                    curatedLinkText.length,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE
                )
                str.setSpan(
                    ForegroundColorSpan(mContext.resources.getColor(R.color.white)),
                    curatedLinkText.length + 2,
                    completeCuratedText.length,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE
                )
                str.setSpan(
                    ForegroundColorSpan(mContext.resources.getColor(R.color.colorAccent)),
                    0,
                    curatedLinkText.length,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE
                )
                holder.txtUserDetail.movementMethod = LinkMovementMethod.getInstance()
                holder.txtUserDetail.highlightColor = Color.TRANSPARENT
                holder.txtUserDetail.text = str
            }
        } else {
            if (all_sections[position].viewType === AppConstants.HOME_PAGE_LIST_VIEW_TYPE_GENRE) {
                val genres: HomeGenreResponseDataModel =
                    all_sections[position].content as HomeGenreResponseDataModel
                holder.section_name.text = "Genre"
                val subContemtListAdapter = HomeScreenSubContentAdapter(
                    mContext, genres.genreGroup.size, all_sections[position].viewType,
                    all_sections[position]
                )
                holder.sub_content_list.setHasFixedSize(true)
                holder.sub_content_list.layoutManager =
                    LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
                holder.sub_content_list.adapter = subContemtListAdapter

/*
                if (genres.getAll_genres().size() < 10) {
                    holder.more.setVisibility(View.INVISIBLE);
                } else {
                    holder.more.setVisibility(View.VISIBLE);
                }
*/holder.more.visibility = View.INVISIBLE
                holder.more.setOnClickListener { /* Intent intent = new Intent(mContext, MoreContentListActivity.class);
                                    intent.putExtra("section", holder.section_name.getText().toString());
                                    intent.putExtra("id", genreModel.getCategoryId());
                                    mContext.startActivity(intent);*/
                }
            } else {
                if (all_sections[position].viewType === AppConstants.HOME_PAGE_LIST_VIEW_TYPE_LANGUAGE) {
                    val languages: HomeLanguageResponseDataModel =
                        all_sections[position].content as HomeLanguageResponseDataModel
                    holder.section_name.text = "Movies by Language"
                    val subContemtListAdapter = HomeScreenSubContentAdapter(
                        mContext,
                        languages.languageGroup.size,
                        all_sections[position].viewType,
                        all_sections[position]
                    )
                    holder.sub_content_list.setHasFixedSize(true)
                    holder.sub_content_list.layoutManager =
                        LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
                    holder.sub_content_list.adapter = subContemtListAdapter

/*
                    if (languages.getLanguages().size() < 10) {
                        holder.more.setVisibility(View.INVISIBLE);
                    } else {
                        holder.more.setVisibility(View.VISIBLE);
                    }
*/holder.more.visibility = View.INVISIBLE
                    holder.more.setOnClickListener { /* Intent intent = new Intent(mContext, MoreContentListActivity.class);
                                        intent.putExtra("section", holder.section_name.getText().toString());
                                        intent.putExtra("id", genreModel.getCategoryId());
                                        mContext.startActivity(intent);*/
                    }
                } else {
                    if (all_sections[position].viewType === AppConstants.HOME_PAGE_LIST_VIEW_TYPE_CHANNEL) {
                        val channels: ChannelAndFestivalResponseDataModel =
                            all_sections[position].content as ChannelAndFestivalResponseDataModel
                        if (channels.festival != null && channels.festival.size > 0) {
                            holder.section_name.text = "Popular Channel & Festival"
                        } else {
                            holder.section_name.text = "Popular Channel"
                        }
                        val subContemtListAdapter = HomeScreenSubContentAdapter(
                            mContext,
                            channels.channels.size + channels.festival.size,
                            all_sections[position].viewType,
                            all_sections[position]
                        )
                        holder.sub_content_list.setHasFixedSize(true)
                        holder.sub_content_list.layoutManager =
                            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
                        holder.sub_content_list.adapter = subContemtListAdapter
                        if (channels.channels.size < 10) {
                            holder.more.visibility = View.GONE
                        } else {
                            holder.more.visibility = View.VISIBLE
                        }
                        holder.more.setOnClickListener {
                            NewHomeActivity.setChannelsPage()
                            /* Intent intent = new Intent(mContext, MoreContentListActivity.class);
                                            intent.putExtra("section", holder.section_name.getText().toString());
                                            intent.putExtra("id", genreModel.getCategoryId());
                                            mContext.startActivity(intent);*/
                        }
                    } else {
                        if (all_sections[position].viewType === AppConstants.HOME_PAGE_LIST_VIEW_TYPE_PLAYLIST) {
                            val playlist: HomeApiCategoryModel =
                                all_sections[position].content as HomeApiCategoryModel
                            holder.section_name.setText(playlist.category)
                            playlists = playlist.content
                            val subContemtListAdapter = HomeScreenSubContentAdapter(
                                mContext, playlists!!.size, all_sections[position].viewType,
                                all_sections[position]
                            )
                            holder.sub_content_list.setHasFixedSize(true)
                            holder.sub_content_list.layoutManager =
                                LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
                            holder.sub_content_list.adapter = subContemtListAdapter
                            if (playlists!!.size < 10) {
                                holder.more.visibility = View.INVISIBLE
                            } else {
                                holder.more.visibility = View.VISIBLE
                            }
                            holder.more.setOnClickListener {
                                val intent = Intent(mContext, PlaylistListingActivity::class.java)
                                mContext.startActivity(intent)
                            }
                        } else {
                            if (all_sections[position].viewType === AppConstants.HOME_PAGE_LIST_VIEW_TYPE_TOP_USER) {
                                val playlist: PlaylistContentDataModel =
                                    all_sections[position].content as PlaylistContentDataModel
                                val topUserListModel: TopUserListModel =
                                    topUserListModel[topUserListIndex]
                                holder.section_name.text =
                                    "Top " + this.topUserListModel.size + " User Lists"
                                topUserPlaylistContent = playlist.playlistContent
                                val subContemtListAdapter = HomeScreenSubContentAdapter(
                                    mContext,
                                    topUserPlaylistContent!!.size,
                                    all_sections[position].viewType,
                                    all_sections[position]
                                )
                                holder.sub_content_list.setHasFixedSize(true)
                                holder.sub_content_list.layoutManager = LinearLayoutManager(
                                    mContext, LinearLayoutManager.HORIZONTAL, false
                                )
                                holder.sub_content_list.adapter = subContemtListAdapter
                                holder.layoutTopUser.visibility = View.VISIBLE
                                if (!TextUtils.isEmpty(topUserListModel.imagepath)) {
                                    GlideApp
                                        .with(mContext)
                                        .load(topUserListModel.imagepath)
                                        .circleCrop()
                                        .placeholder(R.drawable.plexigo_new_transperent_logo)
                                        .into(holder.imgTopUser)
                                }
                                val playlistDetails: String = topUserListModel.userName
                                    .toString() + " : " + topUserListModel.title
                                val str = SpannableStringBuilder(playlistDetails)
                                val clickableSpan: ClickableSpan = object : ClickableSpan() {
                                    override fun onClick(textView: View) {
                                        val intent: Intent
                                        if (AppConstants.isUserLoggedIn) {
                                            intent = Intent(
                                                mContext,
                                                UserPlaylistListingActivity::class.java
                                            )
                                            intent.putExtra(
                                                "playlistUserId",
                                                topUserListModel.userId
                                            )
                                        } else {
                                            intent = Intent(mContext, LoginActivity::class.java)
                                        }
                                        mContext.startActivity(intent)
                                    }

                                    override fun updateDrawState(ds: TextPaint) {
                                        super.updateDrawState(ds)
                                        ds.isUnderlineText = true
                                        ds.linkColor =
                                            mContext.resources.getColor(R.color.colorAccent)
                                    }
                                }
                                str.setSpan(
                                    clickableSpan,
                                    0,
                                    topUserListModel.userName.length,
                                    Spannable.SPAN_INCLUSIVE_INCLUSIVE
                                )
                                str.setSpan(
                                    ForegroundColorSpan(mContext.resources.getColor(R.color.white)),
                                    topUserListModel.userName.length + 2,
                                    playlistDetails.length,
                                    Spannable.SPAN_INCLUSIVE_INCLUSIVE
                                )
                                str.setSpan(
                                    ForegroundColorSpan(mContext.resources.getColor(R.color.colorAccent)),
                                    0,
                                    topUserListModel.userName.length,
                                    Spannable.SPAN_INCLUSIVE_INCLUSIVE
                                )
                                holder.txtUserDetail.movementMethod =
                                    LinkMovementMethod.getInstance()
                                holder.txtUserDetail.highlightColor = Color.TRANSPARENT
                                holder.txtUserDetail.text = str
                                holder.more.visibility = View.GONE
                                if (topUserListIndex == 0) {
                                    holder.imgTopUserLeft.visibility = View.GONE
                                } else {
                                    holder.imgTopUserLeft.visibility = View.VISIBLE
                                }
                                if (topUserListIndex == this.topUserListModel.size - 1) {
                                    holder.imgTopUserRight.visibility = View.GONE
                                } else {
                                    holder.imgTopUserRight.visibility = View.VISIBLE
                                }
                                holder.imgTopUserRight.setOnClickListener {
                                    topUserListIndex++
                                    topUserListContent()
                                }
                                holder.imgTopUserLeft.setOnClickListener {
                                    topUserListIndex--
                                    topUserListContent()
                                }
                                holder.dotsIndicator.visibility = View.VISIBLE
                                holder.dotsIndicator.count = this.topUserListModel.size
                                holder.dotsIndicator.setSelected(topUserListIndex)
                            } else {
                                if (all_sections[position].viewType === AppConstants.HOME_PAGE_LIST_VIEW_TYPE_AREA) {
                                    val playlist =
                                        all_sections[position].content as MovieListingResponseDataModel
                                    holder.section_name.text = "Popular in your area"
                                    movieList = playlist.content
                                    val subContemtListAdapter = HomeScreenSubContentAdapter(
                                        mContext,
                                        movieList!!.size,
                                        all_sections[position].viewType,
                                        all_sections[position]
                                    )
                                    holder.sub_content_list.setHasFixedSize(true)
                                    holder.sub_content_list.layoutManager = LinearLayoutManager(
                                        mContext, LinearLayoutManager.HORIZONTAL, false
                                    )
                                    holder.sub_content_list.adapter = subContemtListAdapter
                                    if (playlist.pageCount > 1) holder.more.visibility =
                                        View.VISIBLE else holder.more.visibility =
                                        View.GONE
                                    holder.more.setOnClickListener {
                                        (mContext as NewHomeActivity).replaceFragment(
                                            ExtendedSearchFragment.newInstance(
                                                "popularInArea",
                                                "Popular in your area"
                                            ),
                                            true
                                        )
                                    }
                                } else {
                                    if (all_sections[position].viewType === AppConstants.HOME_PAGE_LIST_VIEW_TYPE_MOOD_LIST) {
                                        val playlist: UserPlaylistDataModel =
                                            all_sections[position].content as UserPlaylistDataModel
                                        holder.section_name.text = "List for every mood"
                                        moodPlaylist = playlist.playlist
                                        val subContemtListAdapter = HomeScreenSubContentAdapter(
                                            mContext,
                                            moodPlaylist!!.size,
                                            all_sections[position].viewType,
                                            all_sections[position]
                                        )
                                        holder.sub_content_list.setHasFixedSize(true)
                                        holder.sub_content_list.layoutManager = LinearLayoutManager(
                                            mContext, LinearLayoutManager.HORIZONTAL, false
                                        )
                                        holder.sub_content_list.adapter = subContemtListAdapter
                                        holder.more.visibility = View.GONE
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return all_sections[position].viewType
    }

    override fun getItemCount(): Int {
        return all_sections.size
    }

    class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var section_name: TextView
        var more: TextView
        var txtUserDetail: TextView
        var sub_content_list: RecyclerView
        var topGradient: View
        var bottomGradient: View
        var layoutTopUser: ConstraintLayout
        var imgTopUser: ImageView
        var imgTopUserLeft: ImageView
        var imgTopUserRight: ImageView
        var dotsIndicator: PageIndicatorView

        init {
            section_name = convertView.findViewById(R.id.section_name)
            more = convertView.findViewById(R.id.more)
            sub_content_list = convertView.findViewById(R.id.sub_content_list)
            topGradient = convertView.findViewById(R.id.topGradient)
            bottomGradient = convertView.findViewById(R.id.bottomGradient)
            txtUserDetail = convertView.findViewById(R.id.txtUserDetail)
            layoutTopUser = convertView.findViewById(R.id.layoutTopUser)
            imgTopUser = convertView.findViewById(R.id.imgTopUser)
            imgTopUserLeft = convertView.findViewById(R.id.imgTopUserLeft)
            imgTopUserRight = convertView.findViewById(R.id.imgTopUserRight)
            dotsIndicator = convertView.findViewById(R.id.dotsIndicator)
        }
    }//This is for Headers If You Needed

    //                    HideLoader();
//                    GetLanguageApi();

    private fun topUserListContent(){
        showLoader()
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val userid = if (AppConstants.UserId != null) AppConstants.UserId else "0"
        val playlistId: Int = topUserListModel[topUserListIndex].playlistId
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getPlayListContent(playlistId, userid!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.playlistContent != null && modelObj.playlistContent.isNotEmpty()
                            ) {
                                hideLoader()
                                topUserPlaylistContent!!.clear()
                                topUserPlaylistContent!!.addAll(modelObj.playlistContent)
                                notifyDataSetChanged()
                            }
                        } else {
                            Toast.makeText(
                                mContext,
                                "" + responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(
                        mContext,
                        "${e.message}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } catch (e: Throwable) {
                    Toast.makeText(
                        mContext,
                        "${e.message}",
                        Toast.LENGTH_SHORT
                    )
                        .show()

                }
            }
        }

    }

    fun showLoader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft: FragmentTransaction =
            (mContext as NewHomeActivity).getSupportFragmentManager().beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.setCancelable(false)
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }

    init {
        all_sections = all_contents
        subContentLayoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        this.topUserListModel = topUserListModel
        this.curatedText = curatedText
        this.curatedImage = curatedImage
        this.curatedLinkText = curatedLinkText
        this.curatedCategoryId = curatedCategoryId
        topUserListIndex = 0
        queue = Volley.newRequestQueue(mContext)
    }
}

