package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/24/15.
 */
public class Product {
    @SerializedName("Id")

    private Id mId;

    public Id getId()
    {
        return mId;
    }
}
