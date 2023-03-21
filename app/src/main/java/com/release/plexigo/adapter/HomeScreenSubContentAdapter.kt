package com.release.plexigo.adapter

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Typeface
import android.net.Uri
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonMappingException
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Common.GlideApp
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.activity.*
import com.release.plexigo.fragment.ExtendedSearchFragment
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.util.*

class HomeScreenSubContentAdapter(
    var mContext: Context,
    private val size: Int,
    private val viewType: Int,
    homePageListingModel: HomePageListingModel
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    var font: Typeface? = null
    private val homePageListingModel: HomePageListingModel

    //ProgressDialog progress;
    var t: Timer? = null
    var genreList = ArrayList<HomeGenreModel>()
    val movieList: ArrayList<MovieModel> = ArrayList<MovieModel>()
    var languages = ArrayList<HomeLanguageModel>()
    var channels: ArrayList<ChannelFestivalModel> = ArrayList<ChannelFestivalModel>()
    var playlists: ArrayList<MovieModel> = ArrayList<MovieModel>()
    var moodPlaylist: ArrayList<UserPlaylistModel> = ArrayList<UserPlaylistModel>()
    private var customProgressDialog: CustomProgressDialog? = null
    var queue: RequestQueue

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v: View
        val viewHolder: RecyclerView.ViewHolder
        return when (viewType) {
            AppConstants.HOME_PAGE_LIST_VIEW_TYPE_CONTENT -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_content, parent, false)
                viewHolder = MovieContentViewHolder(v)
                movieList.addAll((homePageListingModel.content as HomeApiCategoryModel).content)
                viewHolder
            }
            AppConstants.HOME_PAGE_LIST_VIEW_TYPE_GENRE -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_genre, parent, false)
                viewHolder = GenreViewHolder(v)
                genreList.addAll((homePageListingModel.content as HomeGenreResponseDataModel).genreGroup)
                viewHolder
            }
            AppConstants.HOME_PAGE_LIST_VIEW_TYPE_LANGUAGE -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_language, parent, false)
                viewHolder = LanguageViewHolder(v)
                languages.addAll((homePageListingModel.content as HomeLanguageResponseDataModel).languageGroup)
                viewHolder
            }
            AppConstants.HOME_PAGE_LIST_VIEW_TYPE_CHANNEL -> {
                channels.addAll((homePageListingModel.content as ChannelAndFestivalResponseDataModel).channels)
                channels.addAll((homePageListingModel.content as ChannelAndFestivalResponseDataModel).festival)
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_channel, parent, false)
                val layoutParams = v.layoutParams
                layoutParams.width = Resources.getSystem().displayMetrics.widthPixels / 3 - 50
                layoutParams.height = Resources.getSystem().displayMetrics.widthPixels / 3 - 25
                val cardImage: CardView = v.findViewById(R.id.cardImage)
                val imageParams = cardImage.layoutParams
                imageParams.height = Resources.getSystem().displayMetrics.widthPixels / 3 - 50
                val subscriptionTagWidth =
                    Resources.getSystem().displayMetrics.widthPixels / 3 - 100
                val txtIsSubscribed = v.findViewById<TextView>(R.id.txtIsSubscribed)
                val isSubscribedParams = txtIsSubscribed.layoutParams
                isSubscribedParams.width = subscriptionTagWidth
                txtIsSubscribed.layoutParams = isSubscribedParams
                viewHolder = ChannelViewHolder(v)
                viewHolder
            }
            AppConstants.HOME_PAGE_LIST_VIEW_TYPE_PLAYLIST -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_playlist_home_page, parent, false)
                viewHolder = PlaylistViewHolder(v)
                playlists.addAll((homePageListingModel.content as HomeApiCategoryModel).content)
                viewHolder
            }
            AppConstants.HOME_PAGE_LIST_VIEW_TYPE_AREA -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_content, parent, false)
                viewHolder = MovieContentViewHolder(v)
                movieList.addAll((homePageListingModel.content as MovieListingResponseDataModel).content)
                viewHolder
            }
            AppConstants.HOME_PAGE_LIST_VIEW_TYPE_TOP_USER -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_content, parent, false)
                viewHolder = MovieContentViewHolder(v)
                movieList.addAll((homePageListingModel.content as PlaylistContentDataModel).playlistContent)
                viewHolder
            }
            AppConstants.HOME_PAGE_LIST_VIEW_TYPE_MOOD_LIST -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_playlist_mood, parent, false)
                viewHolder = MoodPlaylistViewHolder(v)
                moodPlaylist.addAll((homePageListingModel.content as UserPlaylistDataModel).playlist)
                viewHolder
            }

            else -> {throw IllegalStateException()}
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        clear cache load from network
        if (holder is MovieContentViewHolder) {
            GlideApp
                .with(mContext)
                .load(movieList[position].imagePath)
                .placeholder(R.drawable.plexigo_new_transperent_logo)
                .into(holder.content_img)
            holder.movie_name.setText(
                movieList[position].contentName
            )
            if (movieList[position].year === 0) {
                holder.txtLanguageYear.setText(
                    movieList[position].language
                )
            } else {
                holder.txtLanguageYear.setText(
                    movieList[position].language
                        .toString() + " . " + movieList[position].year
                )
            }
            holder.content_img.setOnClickListener { v ->
                if (TextUtils.isEmpty(movieList[position].externalWebLink)) {
                    val intent = Intent(mContext, ContentDetailActivity::class.java)
                    intent.putExtra("isLiveContent", movieList[position].isLiveContent)
                    intent.putExtra("movieId", movieList[position].contentId)
                    intent.putExtra("poster_url", movieList[position].imagePath)
                    mContext.startActivity(intent)
                } else {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data =
                        Uri.parse(movieList[position].externalWebLink)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    if (intent.resolveActivity(v.context.packageManager) != null) {
                        mContext.startActivity(intent)
                    } else {
                        Toast.makeText(v.context, "no na", Toast.LENGTH_LONG).show()
                    }
                }
            }
            if (!TextUtils.isEmpty(movieList[position].isWatchLater) && movieList[position].isWatchLater
                    .equals("1" , ignoreCase = true)
            ) {
                holder.add_to_Watchlist.setImageDrawable(
                    mContext.getDrawable(R.drawable.ic_add_watchlist_enabled)
                )
            } else {
                holder.add_to_Watchlist.setImageDrawable(
                    mContext.getDrawable(R.drawable.ic_add_watchlist_disabled)
                )
            }
            holder.add_to_Watchlist.setOnClickListener {
                if (AppConstants.isUserLoggedIn) {
                    if (!TextUtils.isEmpty(movieList[position].isWatchLater) &&
                        movieList[position].isWatchLater.equals("1" , ignoreCase = true)
                    ) {
                        removeFromWatchListApi(movieList[position].contentId, position)
                    }
                    if (TextUtils.isEmpty(movieList[position].isWatchLater) ||
                        movieList[position].isWatchLater.equals("0" , ignoreCase = true)
                    ) {
                        AddToWatchListApi(movieList[position].contentId, position)
                    }
                } else {
                    AppConstants.ReloadMenus = true
                    val intent1 = Intent(mContext, LoginActivity::class.java)
                    intent1.putExtra("reload", "false")
                    mContext.startActivity(intent1)
                }
            }
        }
        if (holder is GenreViewHolder) {
            holder.txtGenre.setText(genreList[position].genreGroup)
            holder.itemView.setOnClickListener {
                AppConstants.SelectedGenreList = ArrayList()
                AppConstants.SelectedGenreList!!.add(genreList[position])
                AppConstants.IsFilterActive = true
                val intent = Intent(mContext, FilterResultsActivity::class.java)
                intent.putExtra("title", genreList[position].genreGroup.toString() + " Movies")
                mContext.startActivity(intent)
            }
        }
        if (holder is LanguageViewHolder) {
            holder.txtLanguage.setText(languages[position].languageGroup)
            holder.itemView.setOnClickListener {
                AppConstants.SelectedLanguageList = ArrayList()
                AppConstants.SelectedLanguageList!!.add(languages[position])
                AppConstants.IsFilterActive = true
                val intent = Intent(mContext, FilterResultsActivity::class.java)
                intent.putExtra(
                    "title",
                    languages[position].languageGroup.toString() + " Movies"
                )
                mContext.startActivity(intent)
            }
        }
        if (holder is ChannelViewHolder) {
            Glide
                .with(mContext)
                .load(channels[position].channelImage)
                .into(holder.imgChannel)
            holder.itemView.setOnClickListener {
                if (channels[position].type.equals("channel" , ignoreCase = true)) {
                    val intent = Intent(mContext, ChannelCategoryListingActivity::class.java)
                    intent.putExtra("contentByChannel", true)
                    intent.putExtra("channelId", channels[position].channelID)
                    if (channels[position].channelID === 11) {
                        intent.putExtra("title", channels[position].channelName)
                    } else {
                        intent.putExtra(
                            "title",
                            channels[position].channelName.toString() + " Movies"
                        )
                    }
                    intent.putExtra("type", "")
                    mContext.startActivity(intent)
                } else {
                    val intent = Intent(mContext, FestivalContentListingActivity::class.java)
                    intent.putExtra("contentByChannel", true)
                    intent.putExtra("channelId", channels[position].channelID)
                    intent.putExtra(
                        "title",
                        channels[position].channelName.toString() + " Movies"
                    )
                    mContext.startActivity(intent)
                }
            }
            if (!TextUtils.isEmpty(channels[position].isSubscribed) && channels[position].isSubscribed
                    .equals("1" , ignoreCase = true)
            ) {
                holder.txtIsSubscribed.visibility = View.VISIBLE
            } else {
                holder.txtIsSubscribed.visibility = View.GONE
            }
        }
        if (holder is PlaylistViewHolder) {
            if (!TextUtils.isEmpty(playlists[position].imagePath)) {
                Glide
                    .with(mContext)
                    .load(playlists[position].imagePath)
                    .into(holder.imgContentPoster)
            }
            holder.txtPlalistDetails.setText(
                playlists[position].language
            )
            holder.txtPlaylistName.setText(
                playlists[position].contentName
            )
            holder.itemView.setOnClickListener {
                val intent = Intent(mContext, PlaylistContentListingActivity::class.java)
                intent.putExtra("playlistId", playlists[position].contentId)
                intent.putExtra("playlistTitle", playlists[position].contentName)
                mContext.startActivity(intent)
            }
        }
        if (holder is MoodPlaylistViewHolder) {
            if (!TextUtils.isEmpty(moodPlaylist[position].widePoster)) {
                Glide
                    .with(mContext)
                    .load(moodPlaylist[position].widePoster)
                    .into(holder.imgPlaylistPoster)
            }
            holder.txtPlaylistName.setText(
                moodPlaylist[position].playlistName
            )
            holder.itemView.setOnClickListener {
                (mContext as NewHomeActivity).replaceFragment(
                    ExtendedSearchFragment.newInstance(
                        "moodPlaylist",
                        moodPlaylist[position].playlistName,
                        moodPlaylist[position].playlistId
                    ), true
                )

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun getItemCount(): Int {
        return if (viewType == AppConstants.HOME_PAGE_LIST_VIEW_TYPE_CONTENT) Math.min(
            size,
            10
        ) else size
    }

    class MovieContentViewHolder(convertView: View) :
        RecyclerView.ViewHolder(convertView) {
        var content_img: ImageView
        var add_to_Watchlist: ImageView
        var movie_name: TextView
        var txtLanguageYear: TextView

        init {
            content_img = convertView.findViewById<View>(R.id.content_img) as ImageView
            movie_name = convertView.findViewById(R.id.movie_name)
            txtLanguageYear = convertView.findViewById(R.id.txtLanguageYear)
            add_to_Watchlist = convertView.findViewById(R.id.add_to_Watchlist)
        }
    }

    class GenreViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtGenre: TextView

        init {
            txtGenre = convertView.findViewById(R.id.txtGenre)
        }
    }

    class LanguageViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtLanguage: TextView

        init {
            txtLanguage = convertView.findViewById(R.id.txtLanguage)
        }
    }

    class ChannelViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgChannel: ImageView
        var txtIsSubscribed: TextView

        init {
            imgChannel = convertView.findViewById(R.id.imgChannel)
            txtIsSubscribed = convertView.findViewById(R.id.txtIsSubscribed)
        }
    }

    class PlaylistViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var imgContentPoster: ImageView
        var txtPlaylistName: TextView
        var txtPlalistDetails: TextView

        init {
            imgContentPoster = convertView.findViewById<View>(R.id.imgContentPoster) as ImageView
            txtPlaylistName = convertView.findViewById(R.id.txtPlaylistName)
            txtPlalistDetails = convertView.findViewById(R.id.txtPlalistDetails)
        }
    }

    class MoodPlaylistViewHolder(convertView: View) :
        RecyclerView.ViewHolder(convertView) {
        var imgPlaylistPoster: ImageView
        var txtPlaylistName: TextView

        init {
            imgPlaylistPoster = convertView.findViewById(R.id.imgContentPoster)
            txtPlaylistName = convertView.findViewById(R.id.txtPlaylistName)
        }
    }

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = (mContext as FragmentActivity).supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.setCancelable(false)
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    fun AddToWatchListApi(movieid: Int, position: Int){
        Showloader()
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request  = WatchListApiRequest(movieid,Integer.valueOf(AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.addWatchLaterApi(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                mContext,
                                responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            movieList[position].isWatchLater = "1"
                            notifyItemChanged(position)
                        }else{
                            Toast.makeText(
                                mContext,
                                responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(mContext, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    Toast.makeText(mContext, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    fun removeFromWatchListApi(movieid: Int, position: Int){
        Showloader()
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request  = WatchListApiRequest(movieid,Integer.valueOf(AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.removeWatchLaterApi(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                mContext,
                                responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            movieList[position].isWatchLater = "0"
                            notifyItemChanged(position)
                        }else{
                            Toast.makeText(
                                mContext,
                                responseModel?.data?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(mContext, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    Toast.makeText(mContext, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun showFollowPlaylistDialog(playlistId: Int) {
        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.dialog_create_playlist, null)
        val pwindo = PopupWindow(
            layout,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT,
            true
        )
        val txtTitle = layout.findViewById<TextView>(R.id.txtTitle)
        val edtPlayListName = layout.findViewById<EditText>(R.id.edtPlayListName)
        val btnCancel = layout.findViewById<Button>(R.id.btnCancel)
        val btnSave = layout.findViewById<Button>(R.id.btnSave)
        txtTitle.text = "Add to my Playlists"
        txtTitle.textSize = 16f
        edtPlayListName.visibility = View.GONE
        btnSave.text = "Ok"
        btnCancel.setOnClickListener { pwindo.dismiss() }
        btnSave.setOnClickListener {
            followPlaylist(playlistId)
            pwindo.dismiss()
        }
        pwindo.isFocusable = true
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0)
    }

    private fun followPlaylist(playlistId: Int){
        Showloader()
        val apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        val request  = PlayListRequest(playlistId,Integer.valueOf(AppConstants.UserId))
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.followUserPlayLists(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                mContext,
                                responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(mContext, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    Toast.makeText(mContext, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    init {
        this.homePageListingModel = homePageListingModel
        queue = Volley.newRequestQueue(mContext)
    }


}

