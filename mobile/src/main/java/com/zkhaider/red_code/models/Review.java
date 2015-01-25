package com.zkhaider.red_code.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kcoleman on 1/25/15.
 */
public class Review {
    @SerializedName("author")
    private Author mAuthor;

    @SerializedName("content")
    private String mContent;

    @SerializedName("summary")
    private String mSummary;

    @SerializedName("attribute_rating")
    private AttributeRating mAttributeRating;

    public Author getAuthor()
    {
        return mAuthor;
    }
    public AttributeRating getAttributeRating()
    {
        return mAttributeRating;
    }
    public String getSummary()
    {
        return mSummary;
    }
    public String getContent()
    {
        return mContent;
    }
}
