package com.release.plexigo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.activity.CastDetailActivity
import com.release.plexigo.activity.ContentDetailActivity
import com.release.plexigo.activity.PlaylistContentListingActivity
import com.release.plexigo.activity.UserPlaylistListingActivity
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.util.*

class SearchScreenSecondaryAdapter(
    var mContext: Context,
    private val viewType: Int,
    searchPageListingModel: SearchPageListingModel,
    searchQuery: String
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    private val searchPageListingModel: SearchPageListingModel

    //ProgressDialog progress;
    var t: Timer? = null
    val movieList: ArrayList<MovieModel> = ArrayList<MovieModel>()
    var playlists: ArrayList<UserPlaylistModel> = ArrayList<UserPlaylistModel>()
    var playlistUsers: ArrayList<PlaylistUserModel> = ArrayList<PlaylistUserModel>()
    var actors: ArrayList<ActorModel> = ArrayList<ActorModel>()
    private var customProgressDialog: CustomProgressDialog? = null
    var queue: RequestQueue
    private val searchQuery: String
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v: View
        val viewHolder: RecyclerView.ViewHolder
        val layoutParams: ViewGroup.LayoutParams
        return when (viewType) {
            AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_CONTENT -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_content, parent, false)
                viewHolder = MovieContentViewHolder(v)
                movieList.addAll((searchPageListingModel.content as ArrayList<MovieModel>))
                viewHolder
            }
            AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_PLAYLIST -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_playlist_home_page, parent, false)
                viewHolder = PlaylistViewHolder(v)
                playlists.addAll((searchPageListingModel.content as ArrayList<UserPlaylistModel>))
                viewHolder
            }
            AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_ACTOR -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_followed_user, parent, false)
                layoutParams = v.layoutParams
                layoutParams.width = Resources.getSystem().displayMetrics.widthPixels / 3 - 100
                v.layoutParams = layoutParams
                viewHolder = ActorViewHolder(v)
                actors.addAll((searchPageListingModel.content as ArrayList<ActorModel>))
                viewHolder
            }
            AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_PLAYLIST_USER -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_followed_user, parent, false)
                layoutParams = v.layoutParams
                layoutParams.width = Resources.getSystem().displayMetrics.widthPixels / 3 - 100
                v.layoutParams = layoutParams
                viewHolder = PlaylistUserViewHolder(v)
                playlistUsers.addAll((searchPageListingModel.content as ArrayList<PlaylistUserModel>))
                viewHolder
            }
            else -> {throw IllegalStateException()}
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
//        clear cache load from network
        if (holder is MovieContentViewHolder) {
            Glide
                .with(mContext)
                .load(movieList[position].imagePath)
                .transform(RoundedCorners(12))
                .into(holder.content_img)
            holder.movie_name.setText(movieList[position].contentName)
            if (movieList[position].year === 0) {
                holder.txtLanguageYear.setText(movieList[position].language)
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
        }
        if (holder is PlaylistViewHolder) {
            try {
                Glide
                    .with(mContext)
                    .load(playlists[position].poster)
                    .into(holder.imgContentPoster)
            } catch (e: Exception) {
                e.printStackTrace()
                Glide
                    .with(mContext)
                    .load(R.drawable.ic_user)
                    .into(holder.imgContentPoster)
            }
            holder.txtPlalistDetails.setText(playlists[position].noofContent)
            holder.txtPlaylistName.setText(playlists[position].title)
            holder.itemView.setOnClickListener {
                val intent = Intent(mContext, PlaylistContentListingActivity::class.java)
                intent.putExtra("playlistId", playlists[position].playlistId)
                intent.putExtra("playlistTitle", playlists[position].title)
                mContext.startActivity(intent)
            }
            /*
                ((PlaylistViewHolder) holder).imgFollowPlaylist.setVisibility(View.GONE);
                ((PlaylistViewHolder) holder).imgFollowPlaylist.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (AppConstants.isUserLoggedIn) {
                            showFollowPlaylistDialog(playlists.get(position).getPlaylistId());
                        } else {
                            AppConstants.ReloadMenus = true;
                            Intent intent1 = new Intent(mContext, LoginActivity.class);
                            intent1.putExtra("reload", "false");
                            mContext.startActivity(intent1);
                        }
                    }
                });
    */
        }
        if (holder is ActorViewHolder) {
            holder.txtActorName.setText(actors[position].name)
            if (!TextUtils.isEmpty(actors[position].imagepath)){
                Glide
                    .with(mContext)
                    .load(actors[position].imagepath)
                    .circleCrop()
                    .into(holder.imgActor)
            }
            holder.itemView.setOnClickListener { // ((NewHomeActivity) mContext).replaceFragment(ExtendedSearchFragment.newInstance("searchMoviesByActor", actors.get(position).getActorId()), true);
                val intent = Intent(mContext, CastDetailActivity::class.java)
                intent.putExtra("name", actors[position].name)
                intent.putExtra("imagepath", actors[position].imagepath)
                intent.putExtra("castCrewId", actors[position].actorId)
                mContext.startActivity(intent)
            }
        }
        if (holder is PlaylistUserViewHolder) {
            if (!TextUtils.isEmpty(playlistUsers[position].imagePath)) {
                Glide
                    .with(mContext)
                    .load(playlistUsers[position].imagePath)
                    .circleCrop()
                    .into(holder.imgPlaylistUser)
            }
            holder.txtPlaylistUserName.setText(
                playlistUsers[position].userName
            )
            holder.itemView.setOnClickListener {
                val intent = Intent(mContext, UserPlaylistListingActivity::class.java)
                intent.putExtra("playlistUserId", playlistUsers[position].userId)
                mContext.startActivity(intent)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun getItemCount(): Int {
        return Math.min((searchPageListingModel.content as ArrayList<Any?>).size, 10)
    }

    class MovieContentViewHolder(convertView: View) :
        RecyclerView.ViewHolder(convertView) {
        var content_img: ImageView
        var movie_name: TextView
        var txtLanguageYear: TextView

        init {
            content_img = convertView.findViewById<View>(R.id.content_img) as ImageView
            movie_name = convertView.findViewById(R.id.movie_name)
            txtLanguageYear = convertView.findViewById(R.id.txtLanguageYear)
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

    class ActorViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var txtActorName: TextView
        var imgActor: ImageView

        init {
            txtActorName = convertView.findViewById(R.id.txtNameCastCrew)
            imgActor = convertView.findViewById(R.id.imgCastCrew)
        }
    }

    class PlaylistUserViewHolder(convertView: View) :
        RecyclerView.ViewHolder(convertView) {
        var imgPlaylistUser: ImageView
        var txtPlaylistUserName: TextView

        init {
            imgPlaylistUser = convertView.findViewById(R.id.imgCastCrew)
            txtPlaylistUserName = convertView.findViewById(R.id.txtNameCastCrew)
        }
    }

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = (mContext as FragmentActivity).supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.isCancelable = false
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
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
        this.searchPageListingModel = searchPageListingModel
        queue = Volley.newRequestQueue(mContext)
        this.searchQuery = searchQuery
    }
}
