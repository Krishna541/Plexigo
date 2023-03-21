package com.release.plexigo.Constants

import com.release.plexigo.models.HomeGenreModel
import com.release.plexigo.models.HomeLanguageModel
import com.release.plexigo.models.OTTModel


object AppConstants {
    var MuviToken = "cd6bf5ce336aec5f6b407e881f760846"
    var UserId: String? = null
    var username: String? = null
    var DeviceType = "Android"
    var ReloadHomepage = false
    var isUserLoggedIn = false
    var AuthToken: String? = null
    var ccaccessCode = "AVFX91HE97AP53XFPA"
    var ccmerchantId = "257549"
    var UserLatitude: Double? = null
    var UserLongitude: Double? = null
    var all_genres: List<HomeGenreModel>? = null
    var all_languages: MutableList<HomeLanguageModel>? = null
    var all_otts: List<OTTModel>? = null

    //    public static List<GenreListOutputModel.SortBy> all_sort;
    var SelectedGenreList: MutableList<HomeGenreModel>? = null
    var SelectedLanguageList: MutableList<HomeLanguageModel>? = null
    var SelectedOTTList: MutableList<OTTModel>? = null
  //  var SelectedChannelList: List<ChannelModel>? = null
    var IsFilterActive = false
    var ResetFilter = false
    var ReloadMenus = false
    var ReloadContentDetail = false
    var IsPaypalPaymentStarted = false
    var PaypalPaymentStatus: String? = null
    const val HOME_PAGE_LIST_VIEW_TYPE_CONTENT = 0
    const val HOME_PAGE_LIST_VIEW_TYPE_GENRE = 1
    const val HOME_PAGE_LIST_VIEW_TYPE_LANGUAGE = 2
    const val HOME_PAGE_LIST_VIEW_TYPE_CHANNEL = 3
    const val HOME_PAGE_LIST_VIEW_TYPE_PLAYLIST = 4
    const val HOME_PAGE_LIST_VIEW_TYPE_TOP_USER = 5
    const val HOME_PAGE_LIST_VIEW_TYPE_AREA = 6
    const val HOME_PAGE_LIST_VIEW_TYPE_MOOD_LIST = 7
    const val SEARCH_PAGE_LIST_VIEW_TYPE_CONTENT = 0
    const val SEARCH_PAGE_LIST_VIEW_TYPE_ACTOR = 1
    const val SEARCH_PAGE_LIST_VIEW_TYPE_PLAYLIST = 2
    const val SEARCH_PAGE_LIST_VIEW_TYPE_PLAYLIST_USER = 3
    const val HOME_TAB_ALL_MOVIES = 0
    const val HOME_TAB_IN_THEATRE = 1
    const val HOME_TAB_PPV = 2
    const val HOME_TAB_COMING_SOON = 3
    const val HOME_TAB_ALL_SERIES = 4
    var showOttFilters = false
    var preferredGenre: ArrayList<HomeGenreModel>? = null
    var preferredLanguages: ArrayList<HomeLanguageModel>? = null
    fun resetFilters() {
        if (all_languages != null) {
            all_languages!!.clear()
            all_languages = null
        }
        IsFilterActive = false
        ResetFilter = false
        if (SelectedGenreList != null && SelectedGenreList!!.size > 0) {
            SelectedGenreList!!.clear()
        }
        if (SelectedLanguageList != null && SelectedLanguageList!!.size > 0) {
            SelectedLanguageList!!.clear()
        }
        if (SelectedOTTList != null && SelectedOTTList!!.size > 0) {
            SelectedOTTList!!.clear()
        }
    }
}