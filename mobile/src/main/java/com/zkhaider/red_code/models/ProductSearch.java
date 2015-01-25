package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/24/15.
 */
public class ProductSearch {
    @SerializedName("SearchResults")
    private SearchResults mSearchResults;

    public SearchResults getSearchResults()
    {
        return mSearchResults;
    }
}
