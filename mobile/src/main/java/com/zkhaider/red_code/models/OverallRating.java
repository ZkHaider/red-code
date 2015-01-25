package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/25/15.
 */
public class OverallRating {
    @SerializedName("overall_rating")
    private String mOverallRating;

    public String getOverallRating()
    {
        return mOverallRating;
    }
}
