package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/24/15.
 */
public class Description {
    @SerializedName("DescriptionName")
    private String mDescriptionName;
    @SerializedName("Images")
    private Images mImages;
    @SerializedName("BrandName")
    private String mBrandName;

    public Images getImages()
    {
        return mImages;
    }

    public String getDescriptionName()
    {
        return mDescriptionName;
    }
    public String getBrandName()
    {
        return mBrandName;
    }
}
