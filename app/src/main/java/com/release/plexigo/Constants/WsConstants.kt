package com.release.plexigo.Constants

object WsConstants {
    //BILLING QA
//     var paymenturl = "http://billingcoreqaapi.plexigo.com/CCARequestHandler/ccavRequestHandler";
//     var CheckExpiry = "https://billingcoreqaapi.plexigo.com/api/ValidateContent/CheckExpiry";
//     var PaymentSuccess = "https://billingcoreqaapi.plexigo.com/success.html?";
//     var PaymentFailure = "https://billingcoreqaapi.plexigo.com/failure.html";
//     var PaymentCancel = "https://billingcoreqaapi.plexigo.com/cancel.html";
//     var svodPaymentUrl = "http://billingcoreqaapi.plexigo.com/SVODRequestHandler/svodRequestHandler";
//     var CheckSVODExpiry = "https://billingcoreqaapi.plexigo.com/api/ValidateContent/CheckSVODExpiry";
    //PROD
    var paymenturl = "https://billingcoreapi.plexigo.com/CCARequestHandler/ccavRequestHandler"
    var CheckExpiry = "https://billingcoreapi.plexigo.com/api/ValidateContent/CheckExpiry"
    var PaymentSuccess = "https://billingcoreapi.plexigo.com/success.html"
    var PaymentFailure = "https://billingcoreapi.plexigo.com/failure.html"
    var PaymentCancel = "https://billingcoreapi.plexigo.com//cancel.html"
    var svodPaymentUrl = "http://billingcoreapi.plexigo.com/SVODRequestHandler/svodRequestHandler"
    var CheckSVODExpiry = "https://billingcoreapi.plexigo.com/api/ValidateContent/CheckSVODExpiry"

    //apis
//    var xApiKey = "03a53461dfdf11ea85d10a5cd31394da";  //qa
    var xApiKey = "f367aa64f65911eaa3d10675b05e64d8" //prod

//      var DOMAIN_URL = "https://userqaapi.plexigo.com/api/"; //qa
    var DOMAIN_URL = "https://userapi.plexigo.com/api/" //prod

    //user apis
    var Sign_up = "user/signup"
    var Sign_in = "user/signin"
    var Change_password = "user/changepassword"
    var Update_Profile = "user/UserUpdateProfile"
    var Forgot_password = "user/forgetpassword"
    var Verify_code = "user/verifycode"
    var Reset_password = "user/resetpassword"
    var OTP_SIGN_IN = "user/signinotp"
    var VERIFY_OTP = "user/verifyotp"
    var SIGNUP_TNC = "user/signuptc"
    var getTopUserList = "user/GetTopUserlist/1/5"
    var getFollowedUserList = "user/GetUserFollowing/"
    var getTopGenres = "user/GetTopGenre/"
    var getFavouritePeople = "user/GetFavouritePeople/"
    var removeFavouritePeople = "user/DeleteFavouritPeople"
    var followUnfollowUser = "user/UserFollower"
    var getUserProfile = "user/GetUserProfile/"
    var getCountries = "user/GetCountry"
    var getStates = "user/GetState/"
    var uploadProfilePicture = "user/UploadProfilePicture"
    var deleteAccount = "user/UserDelete"

    //on boarding apis
    var isOnBoardingComplete = "user/getOnboardingpollcomplete/"
    var getOnBoardingData = "content/getOnboardingdata/"
    var saveOnBoardingData = "user/SaveUserOnbroadingData"

    //content apis
    var GetBanners = "content/GetBanner"
    var GetMovieListingByCategory = "content/getmoviebycategory/"
    var GetMovieDetail = "content/getmoviedetail"
    var getFilteredContent = "content/getContentFilterbyGenreLanguage"
    var getContentbyChannelCategory = "content/getContentbyChannelCategory/"
    var getAppVersion = "content/getAppVersion"
    var getContentVideoLink = "content/GetContentVideoLink/"
    var getOffersCombo = "Content/BundleListing/"
    var getContentByOTT = "content/getcontentbyottplatform/"
    var getContentByChannel = "content/getcontentbyChannel/"
    var getQuickPicks = "content/QuickPick"
    var getActorDetail = "user/getActorDetail/"
    var actorLikeDislike = "content/ActorLikeDislike"
    var contentLikeDislike = "content/ContentLike"
    var getFestivalDetails = "content/getFilmFestivalDetails/"

    //home page
    var GetCategories = "content/GetCategories"
    var GetGenres = "content/getgenre"
    var GetLanguages = "content/getlanguages"
    var GetHomePage = "content/homepagelist"
    var GetOTTs = "content/getOTTPlatforms"
    var getChannels = "Content/ChannelListing"
    var getChannelsAndFestivals = "content/Getchannel/"
    var getPopularInArea = "content/GetPopularInyourarea"
    var getListForEveryMood = "content/Listofeverymood"

    //movie
    var CheckGPSContentValid = "movie/CheckGPSContentValid"
    var UpdateRequestApproval = "movie/UpdateRequestApprovalStatus"
    var isContentLock = "movie/iscontentlock"
    var AddtoWatchlist = "content/addwatchlater"
    var RemoveFromWatchlist = "content/removewatchlater"

    //    public static String GetFavorites = "content/getfavorites";
    var GetLibrary = "content/getwatchlater"
    var AddWatchHistory = "content/UserWatchHistory"
    var GetWatchHistory = "content/GetWatchHistory"
    var GetContentToken = "content/getContentToken"
    var GetSimilarContent = "content/getSimilarContent/"
    var PostGpsCordinates = "movie/UserGPSCoordinates"
    var getFeaturedInPlaylists = "user/FeaturePlaylist/"

    //Paypal Api
    var CreatePaypalOrder = "paypal/CreatePayPalOrder"

    //Channel
    var getChannelCategories = "content/ChannelContentListing"

    //Link to tv
    var linkAuthCodeUser = "user/LinkAuthCodeUser"

    //coupon codes
    var getCouponCodes = "content/getCouponCode"

    // Playlist
    var getUserPlaylist = "user/GetUserPlaylists/"
    var createNewPlaylist = "user/CreateUserPlaylist"
    var addContentToUserPlaylist = "user/AddContentinUserPlaylist"
    var renamePlaylist = "user/Renameplaylist"
    var updatePlaylistType = "user/Updateplaylisttype"
    var removePlayList = "user/Removeplaylist"
    var followPlaylist = "user/FollowUserPlaylists"
    var getPlayListContent = "user/GetPlaylistContent/"
    var removeContentFromPlaylist = "user/RemoveContentUserPlaylist"
    var unfollowPlaylist = "user/UnFollowUserPlaylists"
    var getPlaylistDetails = "user/GetPlaylistDetails/"
    var viewUserPlaylistDetails = "user/ViewUserPlaylistDetails/"
    var viewUserPlaylist = "user/ViewUserPlaylist/"
    var getFollowedPlaylists = "user/GetFollowUserPlaylist/"
    var getMoodPlaylistContent = "user/GetListofeverymoodContent/"

    // Search APIs
    var SearchContent = "content/Search"
    var searchActors = "user/SearchActor"
    var searchPlayList = "user/SearchUserPlaylists"
    var searchPlaylistUser = "user/SearchPlaylistUser"
    var suggestiveSearch = "user/SuggestiveSearch"
    var getContentByActor = "content/getContentByActor"
    var getSuggestedPlaylists = "user/GetPlaylists"
    var recentSearch = "content/RecentSearch"
    var getListForEveryOccasion = "user/ListEveryOccasion"
    var getPopularUsers = "user/GetPopularUser"

    // Call FCM API for Firebase Notification
    var getUserFcmToken = "user/getUserFCMToken"
}