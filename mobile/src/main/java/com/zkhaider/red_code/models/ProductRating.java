package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/25/15.
 */
public class ProductRating {
    @SerializedName("Data")
    private OverallRating mData;

    public OverallRating getData()
    {
        return mData;
    }
}
