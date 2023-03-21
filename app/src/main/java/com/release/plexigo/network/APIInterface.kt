package com.release.plexigo.network

import com.release.plexigo.models.*
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*


interface APIInterface {

    //Splash activity
    @GET("content/getAppVersion")
    suspend fun getAppVersion() : Response<AppVersionResponse>

    @GET("user/getOnboardingpollcomplete/{UserId}")
    suspend fun getOnBoardingPollComplete(@Path("UserId") UserId: Int):Response<OnBoardingCompleteResponse>

    //Login Activity
    @POST("user/signinotp")
    suspend fun loginApi(@Body loginApiRequest: LoginApiRequest):Response<LoginApiResponse>

    //OtpValidationActivity
    @GET("user/signuptc")
    suspend fun getSignUpTermsAndCondition():Response<OnOtpValidationResponse>

    @POST("user/verifyotp")
    suspend fun verifyOtp(@Body verifyOtpRequest: VerifyOtpRequest):Response<VerifyOtpResponse>

    //Registration Activity
    @POST("user/signup")
    suspend fun  registrationApi(@Body registrationRequest: RegistrationRequest) : Response<RegistrationResponse>

    //ForgotPassword
    @POST("user/forgetpassword")
    suspend fun forgotPasswordApi(@Body forgotPasswordRequest: ForgotPasswordRequest) : Response<ForgotPasswordResponse>


    //QuickPickActivity
    @POST("content/QuickPick")
    suspend fun getQuickPickData(@Body quickPickDataRequest: QuickPickDataRequest) : Response<QuickPickDataResponse>


    //ContentDetailActivity
    @POST("content/ContentLike")
    suspend fun callLikeDislikeContent(@Body likeDislikeContentRequest: LikeDislikeContentRequest) : Response<LikeDisLikeActorResponse>

    @GET("content/getmoviedetail/{movieId}/{userid}")
    suspend fun getMovieDetailApi(
        @Path("movieId") movieId : Int,
        @Path("userid") userid : Int
    ):Response<MovieDetailResponse>

    @POST("movie/iscontentlock")
    suspend fun checkGeoAuthorizedContent(@Body geoAuthorizesRequest: ContentGeoAuthorizesRequest) : Response<ContentGeoAuthorizedResponse>

    @POST()
    suspend fun CheckIfUserPpvSubscribed(@Url url: String?,@Body checkUserIsPpvSubscribeRequest: CheckUserIsPpvSubscribeRequest) : Response<UserPpvSubscribeResponse>

    @POST()
    suspend fun checkIfOfferSubscribed(@Url url: String?,@Body checkIfOfferSubscribed: CheckIfOfferSubscribed):Response<UserPpvSubscribeResponse>


    @POST("content/UserWatchHistory")
    suspend fun addWatchHistory(@Body addWatchHistoryRequest: AddWatchHistoryRequest): Response<AddWatchHistoryResponse>

    @GET("content/getContentToken/{contentId}/{userid}")
    suspend fun getContentToken(
        @Path("contentId") contentId : Int,
        @Path("userid") userid : Int
    ):Response<ContentTokenResponse>

    @GET("content/getSimilarContent/{movieId}/{pageNo}/{limit}")
    suspend fun getSimilarMovieListing(
        @Path("movieId") movieId : Int,
        @Path("pageNo") pageNo : Int,
        @Path("limit") limit : Int
    ):Response<MovieListingResponse>

    @GET("user/FeaturePlaylist/{movieId}/{pageNo}/{limit}")
    suspend fun getFeaturedInPlaylists(
        @Path("movieId") movieId : Int,
        @Path("pageNo") pageNo : Int,
        @Path("limit") limit : Int
    ):Response<UserPlayListResponse>


    //CastDetailactivity
    @POST("content/ActorLikeDislike")
    suspend fun callLikeDislikeActor(@Body likeDisLikeActorRequest: LikeDisLikeActorRequest) : Response<LikeDisLikeActorResponse>

    @POST("content/getContentByActor")
    suspend fun getContentByActor(@Body searchMoviesByActorRequest: SearchMoviesByActorRequest) : Response<MovieListingResponse>

    @GET("user/getActorDetail/{actorId}/{UserId}")
    suspend fun getActorDetail(
        @Path("actorId") actorId : Int,
        @Path("UserId") UserId : Int
    ):Response<ActorDetailResponseModel>


    //PlayListingContentActivity
    @GET("user/GetPlaylistContent/{playListId}/{userId}")
    suspend fun getPlayListContent(
        @Path("playListId") playListId : Int,
        @Path("userId") userId : Int
    ) : Response<PlayListContentResponseModel>


    @GET("user/GetPlaylistDetails/{playListId}/{userId}")
    suspend fun getPlayListDetail(
        @Path("playListId") playListId : Int,
        @Path("userId") userId : Int
    ) : Response<PlayListDetailResponse>

    @POST("user/RemoveContentUserPlaylist")
    suspend fun removeContentUserPlayList(@Body removePlayListContentRequest :RemovePlayListContentRequest):Response<RemoveContentUserPlayListResponse>

    @POST("user/FollowUserPlaylists")
    suspend fun followUserPlayLists(@Body playListRequest: PlayListRequest) : Response<PlayListResponseModel>

    @POST("user/UnFollowUserPlaylists")
    suspend fun unFollowUserPlayList(@Body playListRequest: PlayListRequest) : Response<PlayListResponseModel>

    @POST("user/Renameplaylist")
    suspend fun renamePlayList(@Body renamePlayListRequest: RenamePlayListRequest) : Response<PlayListResponseModel>

    @POST("user/Removeplaylist")
    suspend fun removePlayList(@Body playListRequest: PlayListRequest) : Response<PlayListResponseModel>

    @POST("user/Updateplaylisttype")
    suspend fun updatePlayListType(@Body updatePlayListTypeRequest: UpdatePlayListTypeRequest) : Response<PlayListResponseModel>

    //onBoardingActivity
    @GET( "content/getOnboardingdata/{UserId}")
    suspend fun getOnBoardingData(@Path("UserId") UserId: String): Response<OnBoardingResponseModel>


    //NewHomeFragment
    @POST("user/getUserFCMToken")
    suspend fun uploadFcmToken(@Body fcmTokenRequest: FcmTokenRequest) : Response<PlayListResponseModel>

    @POST("content/GetBanner")
    suspend fun getBannerApi(@Body quickPickDataRequest: QuickPickDataRequest) : Response<BannerResponseModel>

    @GET("content/getmoviebycategory/7/1/10/{userId}")
    suspend fun getWhatsNewMovies(@Path("userId") userId : String) : Response<BannerResponseModel>


    @POST("content/homepagelist")
    suspend fun getHomePageListing(@Body homePageListingRequest: HomePageListingRequest):Response<HomeApiResponseModel>

    @GET("user/GetTopUserlist/1/5")
    suspend fun getTopUserList():Response<TopUserListResponseModel>

    @POST("content/GetPopularInyourarea")
    suspend fun getPopularInYourArea(@Body popularInAreaListRequest: PopularInAreaListRequest):Response<MovieListingResponse>


    @POST("content/Listofeverymood")
    suspend fun getListForEveryMood(@Body popularInAreaListRequest: PopularInAreaListRequest):Response<UserPlayListResponseModel>

    @GET("content/Getchannel/{userId}")
    suspend fun getChannelApi(@Path("userId") userId : Int):Response<ChannelFestivalResponseModel>


    //HomeTabFragment
    @GET("content/getlanguages")
    suspend fun getLanguages():Response<HomeLanguagesResponseModel>

    @GET("content/getgenre")
    suspend fun getGenre() : Response<HomeGenreResponseModel>

    @GET("content/getOTTPlatforms")
    suspend fun getOTTPlatforms():Response<OTTResponseModel>


    //MovieListingFragment
    @GET("content/getwatchlater")
    suspend fun getLibraryApi():Response<MovieListingResponse>

    @GET("content/GetWatchHistory/{userId}")
    suspend fun getWatchHistory(@Path("userId") userId : Int):Response<WatchHistoryResponseModel>

    @GET("content/getmoviebycategory/{CategoryId}/{PageCount}/{Limit}/{UserId}")
    suspend fun getMovieListing(
        @Path("CategoryId") CategoryId: Int,
        @Path("PageCount") PageCount:Int,
        @Path("Limit") Limit : Int,
        @Path("UserId") UserId : Int
    ):Response<MovieListingResponse>

    @GET("content/getContentbyChannelCategory/{channelId}/{channelCategoryId}/{PageCount}/{Limit}/{userId}")
    suspend fun getcontentByChannelOTT(
        @Path("channelId") channelId: Int,
        @Path("channelCategoryId") channelCategoryId : Int,
        @Path("PageCount") PageCount:Int,
        @Path("Limit") Limit : Int,
        @Path("UserId") UserId : Int
    ):Response<MovieListingResponse>

    @POST("content/getContentFilterbyGenreLanguage")
    suspend fun getFilteredContent(@Body filteredContentRequest: FilteredContentRequest):Response<MovieListingResponse>

//AddtoDialogFragment
    @GET("user/GetUserPlaylists/{UserId}")
    suspend fun getUserPlayList(@Path("UserId") UserId: Int):Response<UserPlayListResponse>

    @POST("user/CreateUserPlaylist")
    suspend fun createUserPlayList(@Body createPlayListRequest: CreatePlayListRequest):Response<PlayListResponseModel>

    @POST("user/AddContentinUserPlaylist")
    suspend fun addContentToPlayList(@Body removePlayListContentRequest: RemovePlayListContentRequest):Response<PlayListResponseModel>



    //HomeScreenSubContentadapter
    @POST("content/addwatchlater")
    suspend fun addWatchLaterApi(@Body watchLaterApiRequest: WatchListApiRequest) : Response<PlayListResponseModel>


    @POST("content/removewatchlater")
    suspend fun removeWatchLaterApi(@Body watchLaterApiRequest: WatchListApiRequest) : Response<PlayListResponseModel>


    @POST("content/ChannelContentListing")
    suspend fun getChannelCategories(@Body channelCategoriesRequest: ChannelCategoriesRequest) : Response<ChannelApiResponseModel>



    @POST("movie/UserGPSCoordinates")
    suspend fun postGpsCoordinates(@Body gpsCoordinatesRequest: GpsCoordinatesRequest) : Response<GpsCoordinatesResponse>


    //HomeChannelFragment
    //popularChannels
    @GET("content/Getchannel/{UserId}")
    suspend fun getPopularChannels(@Path("UserId") UserId: Int ) : Response<ChannelFestivalResponseModel>


    //PlayListingActivity
    @GET("user/GetFollowUserPlaylist/{UserId}/{PageCount}/{Limit}")
    suspend fun callFollowedPlaylistApi(
        @Path("UserId") UserId: Int,
        @Path("PageCount") PageCount: Int,
        @Path("Limit") Limit: Int
    ):Response<UserPlayListResponseModel>

    @POST("user/GetPlaylists")
    suspend fun getPlayList(@Body popularInAreaListRequest: PopularInAreaListRequest):Response<UserPlayListResponseModel>


    //FestivalContentListingActivity
    //festivalDetails
    @GET("content/getFilmFestivalDetails/")
    suspend fun getfestivalDetails(@Path("festivalId") festivalId: Int) : Response<FestivalResponseModel>


    //SearchContentClass
    //searchMovies
    @POST("content/Search")
    suspend fun getSearchMovies(@Body searchMoviesRequest: SearchMoviesRequestModel) : Response<MovieListingResponse>

    //SearchContentClass
    //searchPlayList
    @POST("user/SearchUserPlaylists")
    suspend fun getSearchPlayList(@Body searchPlaylistsRequest: SearchPlaylistsRequestModel) : Response<UserPlayListResponseModel>

    //SearchContentClass
    //searchActors
    @POST("user/SearchActor")
    suspend fun getSearchActors(@Body searchActorsRequest: SearchActorsRequestModel) : Response<ActorListingResponseModel>


    //SearchContentClass
    //searchPlaylistUsers
    @POST("user/SearchPlaylistUser")
    suspend fun getSearchPlaylistUsers(@Body searchPlaylistUsersRequest: SearchPlaylistUsersRequestModel) : Response<PlaylistUserResponseModel>


    @GET("user/ViewUserPlaylist/{UserId}")
    suspend fun viewUserPlayList(@Path("UserId") UserId: Int):Response<UserPlayListResponseModel>

    @GET("user/ViewUserPlaylistDetails/{UserId}")
    suspend fun viewUserPlayListDetail(@Path("UserId") UserId: Int) : Response<ViewUserPlaylistDetailResponseModel>

    @GET("user/GetUserFollowing/{UserId}/1/10")
    suspend fun getFollowedUserList(@Path("UserId") UserId: Int) : Response<TopUserListResponseModel>

    @POST("user/UserFollower")
    suspend fun updateFolloState(@Body updateFollowStateRequest: UpdateFollowStateRequest) : Response<PlayListResponseModel>

    @GET("user/GetUserProfile/{UserId}")
    suspend fun getUserProfile(@Path("UserId") UserId: Int) : Response<UserProfileDetailResponseModel>

    @POST("Content/BundleListing/")
    suspend fun getBundleListing(@Body popularInAreaListRequest: PopularInAreaListRequest) : Response<OffersResponseModel>

    @GET("user/GetTopGenre/{UserId}")
    suspend fun getTopGenre(@Path("UserId") UserId: Int):Response<TopGenreResponseModel>

    @GET("user/GetFavouritePeople/{UserId}/1/10")
    suspend fun getFavouritePeople(
        @Path("UserId") UserId: Int
    ):Response<ActorListingResponseModel>

    @POST("user/DeleteFavouritPeople")
    suspend fun removeFromFavouritesList(@Body removeFromFavouriteListRequest: RemoveFromFavouriteListRequest) : Response<PlayListResponseModel>

    @GET("content/getCouponCode/{bundleId}/{UserId}")
    suspend fun getCouponCode(
        @Path("bundleId") bundleId: Int,
        @Path("UserId") UserId: Int
    ):Response<CouponCodesResponseModel>

    @POST("user/UserDelete")
    suspend fun deleteAccount(@Body quickPickDataRequest: QuickPickDataRequest):Response<DeleteAccountResponse>

    //EditprofileActivity
    @GET("user/GetCountry")
    suspend fun getCountries():Response<CountryResponseModel>

    @GET("user/GetState/{country}")
    suspend fun getStates(
        @Path("country") country : String
    ):Response<StateResponseModel>

    @POST("user/UserUpdateProfile")
    suspend fun updateUserProfile(@Body updateProfileApiRequest: UpdateProfileApiRequest) : Response<PlayListResponseModel>

    @POST("user/UploadProfilePicture")
    suspend fun uploadProfilePicture(
        @Body file : RequestBody
    ):Response<PlayListResponseModel>

    @POST("user/LinkAuthCodeUser")
    suspend fun linkAuthCodeUser(@Body linkAuthCodeUserRequest: LinkAuthCodeUserRequest):Response<PlayListResponseModel>


    @POST("user/SuggestiveSearch")
    suspend fun getSuggestiveSearch(@Body searchSuggestionsRequest : SearchSuggestionsRequestModel) : Response<SearchSuggestionResponseModel>


    @POST("content/RecentSearch")
    suspend fun getrecentSearch(@Body recentSearchResultsRequest : RecentSearchResultsRequestModel) : Response<MovieListingResponse>


    @POST("user/GetPopularUser")
    suspend fun getPopularUsers(@Body popularUsersRequest : PopularUsersRequestModel) : Response<TopUserListResponseModel>


    //ExtendedSearchFragment
    //getMoodPlaylistContent
    @GET("user/GetListofeverymoodContent/{moodPlaylistId}/{UserId}")
    suspend fun getMoodPlaylistContentInterface(
        @Path("moodPlaylistId") moodPlaylistId: Int,
        @Path("UserId") UserId : Int
    ):Response<PlayListContentResponseModel>


    @POST("movie/UpdateRequestApprovalStatus")
    suspend fun updaterequestApprovedStatus(@Body updateRequestApprovedAPiRequest: UpdateRequestApprovedAPiRequest) : Response<PlayListResponseModel>


    @POST("user/SaveUserOnbroadingData")
    suspend fun saveOnBoardingData(@Body saveOnBoardingRequest: SaveOnBoardingRequest) : Response<PlayListResponseModel>


    @POST("paypal/CreatePayPalOrder")
    suspend fun createPaypalPaymentOrder(@Body paypalOrderRequest: PaypalOrderRequest):Response<PaypalPaymentResponse>

    @POST("user/resetpassword")
    suspend fun resetPassword(@Body resetPasswordRequest: ResetPasswordRequest):Response<PlayListResponseModel>

    @POST("user/verifycode")
    suspend fun sendVerificationCode(@Body sendVerificationCodeRequest: SendVerificationCodeRequest):Response<VerifyOtpResponse>

    @GET("content/GetContentVideoLink/{contentId}")
    suspend fun getContentVideoLink( @Path("contentId") contentId : Int):Response<MovieDetailResponse>

    @GET("https://api-4356dbe1-58e9-4ff0-9035-ac7e47bf7a68.sendbird.com/v3/users/{userId}")
    suspend fun checkUserExist(@Path("userId") userId : String) : Response<ResponseBody>

    @POST("https://api-4356dbe1-58e9-4ff0-9035-ac7e47bf7a68.sendbird.com/v3/users")
    suspend fun createSendbirdUser(@Body createSendBirdUserrequest: CreateSendBirdUserrequest):Response<ResponseBody>

    @POST("movie/CheckGPSContentValid")
    suspend fun checkGPSContentValidApi(@Body gpsCoordinatesRequest: GpsCoordinatesRequest):Response<ResponseBody>

    @GET("content/GetBundleDetail/{bundleId}/{UserId}")
    suspend fun getBundleDetail(
        @Path("bundleId") bundleId: Int,
        @Path("UserId") UserId : String
    ):Response<OfferDescriptionModel>
}