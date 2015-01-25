package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/25/15.
 */
public class Author {
    @SerializedName("screenName")
    private String username;

    public String getUsername()
    {
        return username;
    }
}
