package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/24/15.
 */
public class Price {
    @SerializedName("SalePrice")

    private String mSalePrice;

    public String getSalePrice()
    {
        return mSalePrice;
    }
}
