package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kcoleman on 1/24/15.
 */
public class SearchResults {

    @SerializedName("Products")
    public List<Product> products;

    public List<Product> getProducts()
    {
        return products;
    }
}
