package com.release.plexigo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.activity.ContentDetailActivity
import com.release.plexigo.activity.LoginActivity
import com.release.plexigo.models.MovieModel
import com.release.plexigo.models.WatchListApiRequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class SearchContentListAdapter(
    var mContext: Context,
    movieList: ArrayList<MovieModel>,
    showDeleteButton: Boolean
) :
    RecyclerView.Adapter<SearchContentListAdapter.ViewHolder>() {
    var font: Typeface? = null
    var path = ""
    var type: String? = null
    var movieList: ArrayList<MovieModel>
    var queue: RequestQueue
    private val showDeleteButton: Boolean
    private var onPlayListItemDeleteClickListener: OnPlayListItemDeleteClickListener? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_content, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        // change media icon
        path = movieList[position].imagePath
        //        if (path == null) {
//            path = movieList.get(position).getPoster();
//        }

        //        if (path == null) {
//            path = movieList.get(position).getPoster();
//        }
        Glide
            .with(mContext)
            .load(path)
            .transform(RoundedCorners(12))
            .into(holder.content_img)
//        Glide.with(mContext)
//            .load(path)
//            .override(300, 400)
//            .into(holder.content_img)
        holder.movie_name.setText(movieList[position].contentName)
        holder.content_img.setOnClickListener { v ->
            if (TextUtils.isEmpty(movieList[position].externalWebLink)) {
                val intent = Intent(mContext, ContentDetailActivity::class.java)
                intent.putExtra("movieId", movieList[position].contentId)
                intent.putExtra("poster_url", movieList[position].imagePath)
                if (movieList[position].watchDuration !== 0) {
                    intent.putExtra("WatchDuration", movieList[position].watchDuration)
                }
                mContext.startActivity(intent)
            } else {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(movieList[position].externalWebLink)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                if (intent.resolveActivity(v.context.packageManager) != null) {
                    mContext.startActivity(intent)
                } else {
                    Toast.makeText(v.context, "no na", Toast.LENGTH_LONG).show()
                }
            }
        }
        if (!TextUtils.isEmpty(movieList[position].isWatchLater) && movieList[position].isWatchLater == "1"
        ) {
            holder.add_to_Watchlist.setImageDrawable(mContext.getDrawable(R.drawable.ic_add_watchlist_enabled))
        } else {
            holder.add_to_Watchlist.setImageDrawable(mContext.getDrawable(R.drawable.ic_add_watchlist_disabled))
        }
        holder.add_to_Watchlist.setOnClickListener {
            if (AppConstants.isUserLoggedIn) {
                if (!TextUtils.isEmpty(movieList[position].isWatchLater) &&
                    movieList[position].isWatchLater == "1"
                ) {
                    removeFromWatchListApi(movieList[position].contentId, position)
                }
                if (TextUtils.isEmpty(movieList[position].isWatchLater) ||
                    movieList[position].isWatchLater == "0"
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
        if (movieList[position].year === 0) {
            holder.langyear.setText(movieList[position].language)
        } else {
            holder.langyear.setText(
                movieList[position].language.toString() + " . " + movieList[position].year
            )
        }
        if (showDeleteButton) holder.imgRemovePlaylistContent.visibility =
            View.VISIBLE else holder.imgRemovePlaylistContent.visibility =
            View.GONE
        holder.imgRemovePlaylistContent.setOnClickListener {
            if (onPlayListItemDeleteClickListener != null) {
                onPlayListItemDeleteClickListener!!.onDeletePlayListBtnClicked(movieList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class ViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var content_img: ImageView
        var add_to_Watchlist: ImageView
        var imgRemovePlaylistContent: ImageView
        var movie_name: TextView
        var langyear: TextView

        init {
            content_img = convertView.findViewById<View>(R.id.content_img) as ImageView
            movie_name = convertView.findViewById(R.id.movie_name)
            add_to_Watchlist = convertView.findViewById(R.id.add_to_Watchlist)
            langyear = convertView.findViewById(R.id.txtLanguageYear)
            imgRemovePlaylistContent = convertView.findViewById(R.id.imgRemovePlaylistContent)
        }
    }

    fun AddToWatchListApi(movieid: Int, position: Int) {
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

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = (mContext as FragmentActivity).supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.setCancelable(false)
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    fun removeFromWatchListApi(movieid: Int, position: Int) {
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

    fun setOnPlayListItemDeleteClickListener(onPlayListItemDeleteClickListener: OnPlayListItemDeleteClickListener?) {
        this.onPlayListItemDeleteClickListener = onPlayListItemDeleteClickListener
    }

    interface OnPlayListItemDeleteClickListener {
        fun onDeletePlayListBtnClicked(playlistContent: MovieModel?)
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }

    init {
        this.movieList = movieList
        queue = Volley.newRequestQueue(mContext)
        this.showDeleteButton = showDeleteButton
    }
}
