package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/24/15.
 */
public class ProductDetails {
    @SerializedName("ProductDetail")
    private ProductDetail mProductDetail;

    public ProductDetail getProductDetail()
    {
        return mProductDetail;
    }

}
