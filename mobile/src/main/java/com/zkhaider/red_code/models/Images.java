package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/24/15.
 */
public class Images {

    @SerializedName("MainImageUrl")
    private String mMainImageUrl;

    public String getMainImageUrl()
    {
        return mMainImageUrl;
    }
}
