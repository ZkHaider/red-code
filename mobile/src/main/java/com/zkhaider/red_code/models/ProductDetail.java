package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/24/15.
 */
public class ProductDetail {

    @SerializedName("SoftHardProductDetails")
    private SoftHardProductDetails mSoftHardProductDetails;

    public SoftHardProductDetails getSoftHardProductDetails()
    {
        return mSoftHardProductDetails;
    }
}
