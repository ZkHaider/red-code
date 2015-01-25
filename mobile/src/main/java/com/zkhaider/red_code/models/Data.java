package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kcoleman on 1/25/15.
 */
public class Data {
    @SerializedName("reviews")
    private List<Review> mReviews;
    public List<Review> getReviews()
    {
        return mReviews;
    }

    @SerializedName("overall_rating")
    private String moverall_rating;
    public String getoverall_rating(){return moverall_rating;}
}
