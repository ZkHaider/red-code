package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/25/15.
 */
public class ProductRating {
    @SerializedName("Data")
    private Data mData;

    public Data getData()
    {
        return mData;
    }
}