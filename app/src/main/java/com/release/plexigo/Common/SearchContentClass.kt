package com.release.plexigo.Common

import android.content.Context
import android.widget.Toast
import com.android.volley.*
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonMappingException
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.coroutines.*
import org.json.JSONException
import retrofit2.HttpException
import java.io.IOException


class SearchContentClass(var ctx: Context, var listener: SearchDataListener) {
    var apiInterface: APIInterface
    private var apiJob: Job? = null
    fun searchContent(
        searchtext: String,
        searchFor: String,
        categoryId: Int,
        pageNo: Int,
        noOfRecords: Int
    ) {
        searchMovies(searchtext, searchFor, categoryId, 1, 40)
    }

    fun performSearch(searchQuery: String, pageNo: Int, noOfRecords: Int) {
        searchMovies(searchQuery, "content", 0, pageNo, noOfRecords)
        searchPlaylists(searchQuery)
        searchActors(searchQuery, pageNo, noOfRecords)
        searchPlaylistUsers(searchQuery, pageNo, noOfRecords)
    }

    fun stopSearch() {
        try {
            apiJob?.cancel()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    interface SearchDataListener {
        fun OnContentListLoaded(all_movies: ArrayList<MovieModel>?)
        fun onPlaylistLoaded(playlists: ArrayList<UserPlaylistModel>?)
        fun onActorsLoaded(actors: ArrayList<ActorModel>?)
        fun onPlayListUsersLoaded(playlistUsers: ArrayList<PlaylistUserModel>?)
    }

    private fun searchMovies(
        searchString: String,
        searchFor: String,
        categoryId: Int,
        pageNo: Int,
        noOfRecords: Int) {
      //  val requestObject = JSONObject()
        try {
            apiInterface = APIClient.getClient("1.2").create(APIInterface::class.java)
            val userId = if (AppConstants.UserId == null) "0"  else (AppConstants.UserId)!!
            val request = SearchMoviesRequestModel(searchString, categoryId, searchFor, userId.toInt(), pageNo, noOfRecords )

            apiJob = CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getSearchMovies(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                val responseModel = response.body()
                                if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                    //successresponseModel.getStatus()
                                    val model = responseModel.data
                                    listener.OnContentListLoaded(model.content)
                                } else {
                                    listener.OnContentListLoaded(null)
                                }
                            } catch (e: JsonMappingException) {
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                            }
                        }
                    }
                    catch (e: HttpException) {
                        Toast.makeText(ctx, "${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    } catch (error: Throwable) {
                        if (error is TimeoutError) {
                            Toast.makeText(ctx, R.string.timeout_message, Toast.LENGTH_SHORT).show()
                        }
                        if (error.cause is IOException) {
                            Toast.makeText(
                                ctx,
                                ctx.getString(R.string.internet_not_available),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        Toast.makeText(ctx, "" + error.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun searchPlaylists(searchString: String?) {
        try {
            apiInterface = APIClient.getClient("").create(APIInterface::class.java)
            val userId = if (AppConstants.UserId == null) "0" else (AppConstants.UserId)!!
            val request = SearchPlaylistsRequestModel(
                searchString!!, userId.toInt())

            apiJob = CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getSearchPlayList(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                val responseModel = response.body()
                                if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                    //successresponseModel.getStatus()w
                                    val model = responseModel.data
                                    listener.onPlaylistLoaded(model.playlist)
                                } else {
                                    listener.onPlaylistLoaded(null)
                                }
                            } catch (e: JsonMappingException) {
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                            }
                        }
                    }
                    catch (e: HttpException) {
                        Toast.makeText(ctx, "${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    } catch (e: Throwable) {
                        Toast.makeText(ctx, "${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }}

        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    fun searchActors(searchString: String?, pageNo: Int, noOfRecords: Int) {
        try {
            apiInterface = APIClient.getClient("").create(APIInterface::class.java)
            val userId = if (AppConstants.UserId == null) "0"  else (AppConstants.UserId)!!
            val request = SearchActorsRequestModel(
                searchString!!,"actor", userId.toInt(),
                pageNo,noOfRecords)
           apiJob = CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getSearchActors(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                val responseModel = response.body()
                                if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                    //successresponseModel.getStatus()w
                                    val model = responseModel.data
                                    listener.onActorsLoaded(model.actors)
                                } else {
                                    listener.onActorsLoaded(null)
                                }
                            } catch (e: JsonMappingException) {
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                            }
                        }
                    }
                    catch (e: HttpException) {
                        Toast.makeText(ctx, "${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    } catch (e: Throwable) {
                        Toast.makeText(ctx, "${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    }

                }
            }



        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    fun searchPlaylistUsers(searchString: String?, pageNo: Int, noOfRecords: Int) {
        try {
            apiInterface = APIClient.getClient("").create(APIInterface::class.java)
            val userId = if (AppConstants.UserId == null) "0" else (AppConstants.UserId)!!
            val request = SearchPlaylistUsersRequestModel(searchString!!, "playlistuser", userId.toInt(), pageNo,noOfRecords)

            apiJob = CoroutineScope(Dispatchers.IO).launch {
                val response = apiInterface.getSearchPlaylistUsers(request)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            try {
                                val responseModel = response.body()
                                if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                                    //successresponseModel.getStatus()w
                                    val model = responseModel.data
                                    listener.onPlayListUsersLoaded(model.playlistUser)
                                } else {
                                    listener.onPlayListUsersLoaded(null)
                                }
                            } catch (e: JsonMappingException) {
                                e.printStackTrace()
                            } catch (e: JsonProcessingException) {
                                e.printStackTrace()
                            }
                        }
                    }
                    catch (e: HttpException) {
                        Toast.makeText(ctx, "${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    } catch (e: Throwable) {
                        Toast.makeText(ctx, "${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }}


        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    init {
       apiInterface = APIClient.getClient("").create(APIInterface::class.java)
    }
}