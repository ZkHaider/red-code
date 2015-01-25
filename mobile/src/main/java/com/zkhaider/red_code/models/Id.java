package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/24/15.
 */
public class Id {
    @SerializedName("PartNumber")
    private String mPartNumber;

    public String getPartNumber()
    {
        return mPartNumber;
    }
}
