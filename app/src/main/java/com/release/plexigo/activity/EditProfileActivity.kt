package com.release.plexigo.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSeekBar
import com.android.volley.RequestQueue
import com.android.volley.TimeoutError
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.Constants.WsConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.CountrySelectionAdapter
import com.release.plexigo.adapter.PreferredGenreAdapter
import com.release.plexigo.adapter.PreferredLanguageAdapter
import com.release.plexigo.adapter.StateSelectionAdapter
import com.release.plexigo.models.*
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.HttpException
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.io.InputStream


class EditProfileActivity : AppCompatActivity(), View.OnClickListener,
    CountrySelectionAdapter.OnCountrySelected, StateSelectionAdapter.OnStateSelected {
    private val IMAGE_PICKER = 10001
    var queue: RequestQueue? = null
    private var selectedGender = ""
    private lateinit var customProgressDialog: CustomProgressDialog
    var seekbarProgress: AppCompatSeekBar? = null
    var languageAdapter: PreferredLanguageAdapter? = null
    var genreAdapter: PreferredGenreAdapter? = null
    var allCountries = ArrayList<CountryModel>()
    var allStates = ArrayList<StateModel>()
    var countrySelectionAdapter: CountrySelectionAdapter? = null
    var stateSelectionAdapter: StateSelectionAdapter? = null
    private var selectedState: StateModel? = null
    private var selectedCountry: CountryModel? = null
    private var bottomSheet: BottomSheetBehavior<View>? = null
    private var userProfile: UserProfileModel? = null
    lateinit var apiInterface : APIInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        seekbarProgress = findViewById(R.id.seekbarProgress)
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        languageAdapter = PreferredLanguageAdapter(AppConstants.preferredLanguages)
        recyclerPreferredLanguages.adapter = languageAdapter
        languageAdapter!!.setOnPreferredLanguageItemSelectedListener(object : PreferredLanguageAdapter.OnPreferredGenreItemSelectedListener {
            override fun onPreferredGenreItemSelected(language: HomeLanguageModel?) {
                for (i in AppConstants.preferredLanguages?.indices!!) {
                    if (AppConstants.preferredLanguages!![i].languageGroup.equals(
                            language?.languageGroup,
                            ignoreCase = true
                        )
                    ) {
                        if (AppConstants.preferredLanguages!![i].selected == 0) {
                            AppConstants.preferredLanguages!![i].selected = 1
                        } else {
                            AppConstants.preferredLanguages!![i].selected = 0
                        }
                    }
                }
                languageAdapter!!.notifyDataSetChanged()
            }
        })
        genreAdapter = PreferredGenreAdapter(AppConstants.preferredGenre)
        recyclerPreferredGenre.adapter = genreAdapter
        genreAdapter!!.setOnPreferredGenreItemSelectedListener(object : PreferredGenreAdapter.OnPreferredGenreItemSelectedListener {
            override fun onPreferredGenreItemSelected(genre: HomeGenreModel?) {
                for (i in AppConstants.preferredGenre?.indices!!) {
                    if (AppConstants.preferredGenre?.get(i)?.genreGroup.equals(
                            genre?.genreGroup,
                            ignoreCase = true
                        )
                    ) {
                        if (AppConstants.preferredGenre!![i].selected == 0) {
                            AppConstants.preferredGenre!![i].selected = 1
                        } else {
                            AppConstants.preferredGenre!![i].selected = 0
                        }
                    }
                }
                genreAdapter!!.notifyDataSetChanged()
            }
        })
        bottomSheet = BottomSheetBehavior.from(findViewById(R.id.btmSheetCountryState))
        bottomSheet!!.peekHeight = 0
        txtCountryState.setOnClickListener(this)
        countrySelectionAdapter = CountrySelectionAdapter(allCountries, this)
        recyclerCountryState.setAdapter(countrySelectionAdapter)
        txtChangePhoto.setOnClickListener(this)
        stateSelectionAdapter = StateSelectionAdapter(allStates, this)
        btnDone.setOnClickListener(this)
        back_btn.setOnClickListener(this)
        queue = Volley.newRequestQueue(this@EditProfileActivity)
        userProfile = intent.getSerializableExtra("profileDetail") as UserProfileModel?
        countryList()
        radioGrpGender.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.rBtnMale) {
                selectedGender = "M"
            } else if (checkedId == R.id.rBtnFemale) {
                selectedGender = "F"
            } else if (checkedId == R.id.rBtnOther) {
                selectedGender = "O"
            }
        })
    }

    private fun updateUi(userProfile: UserProfileModel?) {
        txtUserName!!.text = userProfile!!.userName
        txtUserEmail!!.text = userProfile.email
        txtCompletedProgress!!.text = userProfile.profileCompletePercentage + " % completed"
        seekbarProgress!!.progress = userProfile.profileCompletePercentage.toDouble().toInt()
        selectedGender = userProfile.gender
        if ("M".equals(selectedGender, ignoreCase = true)) {
            radioGrpGender!!.check(R.id.rBtnMale)
        } else if ("F".equals(selectedGender, ignoreCase = true)) {
            radioGrpGender!!.check(R.id.rBtnFemale)
        } else {
            radioGrpGender!!.check(R.id.rBtnOther)
        }
        if (TextUtils.isEmpty(userProfile.imagePath)) {
            Glide
                .with(this)
                .load("https://plexigostatic1.s3.ap-south-1.amazonaws.com/DefaultPosters/Defaultuser31X31.png")
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imgUserProfile)
        } else {
            Glide
                .with(this)
                .load(userProfile.imagePath)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .circleCrop()
                .into(imgUserProfile)
        }
        if (!TextUtils.isEmpty(userProfile.country) && !TextUtils.isEmpty(userProfile.state)) {
            for (country in allCountries) {
                if (country.country_phone_code.equals(userProfile.country, ignoreCase = true)) {
                    txtCountryState!!.text = country.country_name + ", " + userProfile.state
                    break
                }
            }
        }
    }

    //This is for Headers If You Needed
    private fun countryList(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getCountries()
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.country != null && modelObj.country.isNotEmpty()) {
                                allCountries.clear()
                                allCountries.addAll(modelObj.country)
                                updateUi(userProfile)
                            }
                        }else {
                            Toast.makeText(
                                this@EditProfileActivity,
                                "" + responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@EditProfileActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@EditProfileActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@EditProfileActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@EditProfileActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun getStates(country: String){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getStates(country)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            val modelObj = responseModel.data
                            if (modelObj.state != null && modelObj.state.size > 0) {
                                allStates.clear()
                                allStates.addAll(modelObj.state)
                                stateSelectionAdapter!!.notifyDataSetChanged()
                                recyclerCountryState!!.adapter = stateSelectionAdapter
                                bottomSheet!!.state = BottomSheetBehavior.STATE_EXPANDED
                                txtBottomSheetTitle!!.text = "Select State"
                            }
                        }else {
                            Toast.makeText(
                                this@EditProfileActivity,
                                "" + responseModel?.status,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@EditProfileActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@EditProfileActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@EditProfileActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@EditProfileActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.txtCountryState -> {
                recyclerCountryState!!.adapter = countrySelectionAdapter
                bottomSheet!!.state = BottomSheetBehavior.STATE_EXPANDED
                txtBottomSheetTitle!!.text = "Select Country"
            }
            R.id.back_btn -> onBackPressed()
            R.id.btnDone -> updateProfileApi()
            R.id.txtChangePhoto -> ImagePicker.with(this)
                .cropSquare() //Crop image(Optional), Check Customization for more option
                .compress(1024) //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                ) //Final image resolution will be less than 1080 x 1080(Optional)
                .start(IMAGE_PICKER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_PICKER && data!!.data != null) {
            val selectedImage = File(data.data!!.path)
            Glide
                .with(this)
                .load(selectedImage)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imgUserProfile)
            uploadProfileImage(selectedImage, data.data)
        }
    }

    fun showLoader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog.show(ft, "dialog")
        customProgressDialog.setCancelable(false)
    }

    fun hideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    private fun updateProfileApi(){
        val languages = StringBuilder()
        val genre = StringBuilder()
        for (i in AppConstants.preferredGenre?.indices!!) {
            if (AppConstants.preferredGenre!![i].selected == 1) {
                genre.append(AppConstants.preferredGenre!![i].genreGroupID).append(",")
            }
        }
        for (i in AppConstants.preferredLanguages?.indices!!) {
            if (AppConstants.preferredLanguages?.get(i)?.selected == 1) {
                languages.append(AppConstants.preferredLanguages!![i].languageGroupID).append(",")
            }
        }
        val selectedLanguages =
            if (languages.length > 0) languages.substring(0, languages.length - 1) else ""
        val selectedGenre = if (genre.length > 0) genre.substring(0, genre.length - 1) else ""
        showLoader()
        val request = UpdateProfileApiRequest(Integer.valueOf(AppConstants.UserId), userProfile!!.userName,30,
            if (selectedCountry == null) userProfile!!.country else selectedCountry!!.country_phone_code,
            if (selectedState == null) userProfile!!.state else selectedState!!.state_name,
            selectedGender,selectedLanguages,selectedGenre
        )
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.updateUserProfile(request)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@EditProfileActivity,
                                "" + responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                            userProfileDetails()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@EditProfileActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@EditProfileActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@EditProfileActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@EditProfileActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    override fun onCountrySelected(country: CountryModel?) {
        bottomSheet!!.state = BottomSheetBehavior.STATE_COLLAPSED
        selectedCountry = country
        userProfile!!.country = selectedCountry!!.country_phone_code
        updateUi(userProfile)
        getStates(country!!.country_name)
    }

    override fun onStateSelected(state: StateModel?) {
        selectedState = state
        userProfile!!.state = selectedState!!.state_name
        updateUi(userProfile)
        bottomSheet!!.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    private fun uploadProfileImage(fileToUpload: File, data: Uri?){
        showLoader()


        val builder = MultipartBody.Builder().setType(MultipartBody.FORM)
        val requestFile: RequestBody =
            RequestBody.create(MediaType.parse("multipart/form-data"), fileToUpload)
        builder.addFormDataPart("X-Api-Key",WsConstants.xApiKey)
            .addFormDataPart("UserId" ,  AppConstants.UserId)
            .addFormDataPart("FileToUpload" , fileToUpload.name, requestFile)

        val requestBody: RequestBody = builder.build()
        val reqFile: RequestBody = RequestBody.create(
            MediaType.parse("image"),
            fileToUpload
        )

        val body: MultipartBody.Part =
            MultipartBody.Part.createFormData("image", fileToUpload.name, requestFile)
        val id : RequestBody = RequestBody.create(MediaType.parse("UserId") , AppConstants.UserId)
//        val fullName: RequestBody =
//            RequestBody.create(MediaType.parse("multipart/form-data"), "Your Name")
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.uploadProfilePicture(requestBody)
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            Toast.makeText(
                                this@EditProfileActivity,
                                "" + responseModel.data.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@EditProfileActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@EditProfileActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@EditProfileActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@EditProfileActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    @Throws(IOException::class)
    fun getBytes(inputStream: InputStream?): ByteArray {
        val byteBuffer = ByteArrayOutputStream()
        val bufferSize = 1024
        val buffer = ByteArray(bufferSize)
        var len = 0
        while (inputStream!!.read(buffer).also { len = it } != -1) {
            byteBuffer.write(buffer, 0, len)
        }
        return byteBuffer.toByteArray()
    }


    private fun userProfileDetails(){
        showLoader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.getUserProfile(AppConstants.UserId!!.toInt())
            withContext(Dispatchers.Main) {
                try {
                    hideLoader()
                    if (response.isSuccessful) {
                        val responseModel = response.body()
                        if (responseModel?.statusCode != null && responseModel.statusCode == "200") {
                            updateUi(responseModel.data.userprofile[0])
                        }
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@EditProfileActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    hideLoader()
                    if (e is TimeoutError) {
                        Toast.makeText(
                            this@EditProfileActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (e.cause is IOException) {
                        Toast.makeText(
                            this@EditProfileActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@EditProfileActivity,
                        "" + e.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}