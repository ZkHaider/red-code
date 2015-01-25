package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kcoleman on 1/25/15.
 */
public class ProductRating {

    @SerializedName("data")
    private Data mData;
    public Data getData()
    {
        return mData;
    }
}
