package com.release.plexigo.activity

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import kotlinx.android.synthetic.main.activity_reviews.*

class ReviewsActivity : AppCompatActivity() {
    var isLoginclicked = false
    var contentId: String? = null
    var ratingGiven = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviews)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.title = "Reviews"
        toolbar.setNavigationOnClickListener(View.OnClickListener { onBackPressed() })
        login_text.paintFlags = login_text.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        if (!AppConstants.isUserLoggedIn) {
            login.visibility = View.VISIBLE
            postreview.visibility = View.GONE
            login.setOnClickListener(View.OnClickListener {
                isLoginclicked = true
                AppConstants.ReloadMenus = true
                val intent1 = Intent(this@ReviewsActivity, LoginActivity::class.java)
                intent1.putExtra("reload", "false")
                startActivity(intent1)
            })
        }
        post.setOnClickListener(View.OnClickListener {
            //                PostReview();
        })
        rating.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, v, b ->
            ratingGiven = v
        }
        contentId = intent.getStringExtra("contentid")
        //        getReviews();
    }

    /*
    private void PostReview() {
        AddContentRatingInputModel inputModel = new AddContentRatingInputModel();
        inputModel.setAuthToken(AppConstants.MuviToken);
        inputModel.setContent_id(contentId);
        inputModel.setUser_id(AppConstants.UserId);
        inputModel.setRating(String.valueOf(ratingGiven));
        inputModel.setReview(review.getText().toString().trim());

        AddContentRatingAsync async = new AddContentRatingAsync(inputModel, new AddContentRatingAsync.AddContentRatingListener() {
            @Override
            public void onAddContentRatingPreExecuteStarted() {
                Showloader();
            }

            @Override
            public void onAddContentRatingPostExecuteCompleted(AddContentRatingOutputModel addContentRatingOutputModel, int code, String message, String response) {
                HideLoader();
                if(code == 200){
                    Toast.makeText(ReviewsActivity.this, message, Toast.LENGTH_SHORT).show();
                    getReviews();
                }else{
                    Toast.makeText(ReviewsActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        }, ReviewsActivity.this);
        async.execute();
    }
*/
    override fun onResume() {
        super.onResume()
        if (isLoginclicked) {
            isLoginclicked = false
            if (AppConstants.isUserLoggedIn) {
//                getReviews();
            }
        }
    }

    /*
    private void getReviews() {
        ViewContentRatingInputModel inputModel = new ViewContentRatingInputModel();
        inputModel.setAuthToken(AppConstants.MuviToken);
        if(AppConstants.isUserLoggedIn) {
            inputModel.setUser_id(AppConstants.UserId);
        }
        inputModel.setContent_id(contentId);
        ViewContentRatingAsync async = new ViewContentRatingAsync(inputModel, new ViewContentRatingAsync.ViewContentRatingListener() {
            @Override
            public void onViewContentRatingPreExecuteStarted() {
                Showloader();
            }

            @Override
            public void onViewContentRatingPostExecuteCompleted(ViewContentRatingOutputModel viewContentRatingOutputModel, int code, String message, String response) {
                HideLoader();
                if(code == 200){
                    if(viewContentRatingOutputModel.getRatingArray() != null && viewContentRatingOutputModel.getRatingArray().size()>0){
                        ArrayList<ViewContentRatingOutputModel.Rating> all_reviews = viewContentRatingOutputModel.getRatingArray();
                        LinearLayoutManager LayoutManager = new LinearLayoutManager(ReviewsActivity.this, RecyclerView.VERTICAL, false);
                        ReviewsAdapter adapter = new ReviewsAdapter(ReviewsActivity.this, all_reviews);
                        reviews_list.setLayoutManager(LayoutManager);
                        reviews_list.setAdapter(adapter);
                    }
                    if(AppConstants.isUserLoggedIn){
                        login.setVisibility(View.GONE);
                        if(viewContentRatingOutputModel.getShowrating() == 1){
                            postreview.setVisibility(View.VISIBLE);
                        }else{
                            postreview.setVisibility(View.GONE);
                        }
                    }else{
                        login.setVisibility(View.VISIBLE);
                    }
                }else{
                    Toast.makeText(ReviewsActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        }, ReviewsActivity.this);

        async.execute();
    }
*/
    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog!!.show(ft, "dialog")
        customProgressDialog!!.setCancelable(false)
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog!!.dismiss()
    }

    companion object {
        var customProgressDialog: CustomProgressDialog? = null
    }
}