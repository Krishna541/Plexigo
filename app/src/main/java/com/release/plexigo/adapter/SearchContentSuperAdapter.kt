package com.release.plexigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.activity.NewHomeActivity
import com.release.plexigo.fragment.ExtendedSearchFragment
import com.release.plexigo.models.*

class SearchContentSuperAdapter constructor(
    var mContext: Context,
    var all_sections: ArrayList<SearchPageListingModel>,
    searchQuery: String
) : RecyclerView.Adapter<SearchContentSuperAdapter.ViewHolder>() {
    var subContentLayoutManager: RecyclerView.LayoutManager
    private val searchQuery: String
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.single_content_main_list, parent, false)
        val viewHolder: ViewHolder = ViewHolder(v)
        viewHolder.setIsRecyclable(false)
        return viewHolder
    }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (all_sections[position].viewType) {
            AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_CONTENT -> {
                val movieList: ArrayList<MovieModel>? =
                    all_sections[position].content as ArrayList<MovieModel>?
                if (movieList != null && movieList.size > 0) {
                    holder.section_name.text = "Top matches in Titles"
                    val subContentListAdapterContent: SearchScreenSecondaryAdapter =
                        SearchScreenSecondaryAdapter(
                            mContext,
                            all_sections[position].viewType,
                            all_sections[position], searchQuery
                        )
                    holder.sub_content_list.setHasFixedSize(true)
                    holder.sub_content_list.layoutManager = LinearLayoutManager(
                        mContext,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    holder.sub_content_list.adapter = subContentListAdapterContent
                    if (movieList.size < 10) {
                        holder.more.visibility = View.GONE
                    } else {
                        holder.more.visibility = View.VISIBLE
                    }
                    holder.more.setOnClickListener(object : View.OnClickListener {
                         override fun onClick(v: View) {
                            (mContext as NewHomeActivity).addFragment(
                                ExtendedSearchFragment.newInstance(
                                    "searchMovies",
                                    "content",
                                    searchQuery,
                                    "Movies/Series"
                                ), true
                            )
                        }
                    })
                }
            }
            AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_ACTOR -> {
                val actors: ArrayList<ActorModel>? =
                    all_sections[position].content as ArrayList<ActorModel>?
                if (actors != null && actors.size > 0) {
                    holder.section_name.text = "Top matches for People"
                    val subContentListAdapterActor: SearchScreenSecondaryAdapter =
                        SearchScreenSecondaryAdapter(
                            mContext,
                            all_sections[position].viewType,
                            all_sections[position], searchQuery
                        )
                    holder.sub_content_list.setHasFixedSize(true)
                    holder.sub_content_list.setLayoutManager(
                        LinearLayoutManager(
                            mContext,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                    )
                    holder.sub_content_list.adapter = subContentListAdapterActor
                    if (actors.size < 10) {
                        holder.more.visibility = View.GONE
                    } else {
                        holder.more.visibility = View.VISIBLE
                    }
                    holder.more.setOnClickListener(object : View.OnClickListener {
                         override fun onClick(v: View) {
                            (mContext as NewHomeActivity).addFragment(
                                ExtendedSearchFragment.newInstance(
                                    "searchActors",
                                    "actor",
                                    searchQuery,
                                    "Actor"
                                ), true
                            )
                        }
                    })
                }
            }
            AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_PLAYLIST -> {
                val playlists: ArrayList<UserPlaylistModel>? =
                    all_sections.get(position).content as ArrayList<UserPlaylistModel>?
                if (playlists != null && playlists.size > 0) {
                    holder.section_name.setText("Top matches for Playlists")
                    val subContentListAdapterPlaylist: SearchScreenSecondaryAdapter =
                        SearchScreenSecondaryAdapter(
                            mContext,
                            all_sections.get(position).viewType,
                            all_sections.get(position), searchQuery
                        )
                    holder.sub_content_list.setHasFixedSize(true)
                    holder.sub_content_list.setLayoutManager(
                        LinearLayoutManager(
                            mContext,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                    )
                    holder.sub_content_list.setAdapter(subContentListAdapterPlaylist)
                    if (playlists.size < 10) {
                        holder.more.setVisibility(View.GONE)
                    } else {
                        holder.more.setVisibility(View.VISIBLE)
                    }
                    holder.more.setOnClickListener(object : View.OnClickListener {
                         override fun onClick(v: View) {
                            (mContext as NewHomeActivity).addFragment(
                                ExtendedSearchFragment.newInstance(
                                    "searchPlaylists",
                                    "",
                                    searchQuery,
                                    "Playlists"
                                ), true
                            )
                        }
                    })
                }
            }
            AppConstants.SEARCH_PAGE_LIST_VIEW_TYPE_PLAYLIST_USER -> {
                val playlistUsers: ArrayList<PlaylistUserModel>? =
                    all_sections.get(position).content as ArrayList<PlaylistUserModel>?
                if (playlistUsers != null && playlistUsers.size > 0) {
                    holder.section_name.setText("Top matches for Users")
                    val subContentListAdapterPlaylistUsers: SearchScreenSecondaryAdapter =
                        SearchScreenSecondaryAdapter(
                            mContext,
                            all_sections.get(position).viewType,
                            all_sections.get(position), searchQuery
                        )
                    holder.sub_content_list.setHasFixedSize(true)
                    holder.sub_content_list.setLayoutManager(
                        LinearLayoutManager(
                            mContext,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                    )
                    holder.sub_content_list.setAdapter(subContentListAdapterPlaylistUsers)
                    if (playlistUsers.size < 10) {
                        holder.more.setVisibility(View.GONE)
                    } else {
                        holder.more.setVisibility(View.VISIBLE)
                    }
                    holder.more.setOnClickListener(object : View.OnClickListener {
                         override fun onClick(v: View) {
                            (mContext as NewHomeActivity).addFragment(
                                ExtendedSearchFragment.newInstance(
                                    "searchPlaylistUser",
                                    "",
                                    searchQuery,
                                    "Users"
                                ), true
                            )
                        }
                    })
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

    class ViewHolder constructor(convertView: View) : RecyclerView.ViewHolder(convertView) {
        var section_name: TextView
        var more: TextView
        var sub_content_list: RecyclerView

        init {
            section_name = convertView.findViewById<View>(R.id.section_name) as TextView
            more = convertView.findViewById<View>(R.id.more) as TextView
            sub_content_list = convertView.findViewById<View>(R.id.sub_content_list) as RecyclerView
            convertView.findViewById<View>(R.id.layoutTopUser).visibility = View.GONE
            convertView.findViewById<View>(R.id.topGradient).visibility = View.GONE
            convertView.findViewById<View>(R.id.bottomGradient).visibility = View.GONE
        }
    }

    init {
        subContentLayoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        this.searchQuery = searchQuery
    }
}