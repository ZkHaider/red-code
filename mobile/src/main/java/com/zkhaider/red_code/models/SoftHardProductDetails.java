package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/24/15.
 */
public class SoftHardProductDetails {
    @SerializedName("Price")
    private Price mPrice;
    public Price getPrice(){return mPrice;}
    @SerializedName("Description")
    private Description mDescription;
    public Description getDescription()
    {
        return mDescription;
    }

}
