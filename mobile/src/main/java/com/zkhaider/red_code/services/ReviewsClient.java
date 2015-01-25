package com.zkhaider.red_code.services;

import android.content.Context;

import com.zkhaider.red_code.models.ProductRating;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by kcoleman on 1/25/15.
 */
public class ReviewsClient {

    private static ReviewsClient sReviewsClient;
    private static final String API_URL = "http://www.sears.com/content/pdp/";

    private static RestAdapter mRestAdapter;

    interface IProductRatings {
        @GET("/ratings/single/search/Sears/{id}")
        ProductRating getProductRating(@Path("id") String id);
    }


    private ReviewsClient(Context context)
    {

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("User-Agent", "Retrofit-Sample-App");
            }
        };

        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(requestInterceptor)
                .build();
    }

    public static ReviewsClient get(Context context)
    {
        if (sReviewsClient == null)
        {
            sReviewsClient = new ReviewsClient(context);
        }
        return sReviewsClient;
    }

    public ProductRating getProductRating(String id)
    {
        IProductRatings productDetails = mRestAdapter.create(IProductRatings.class);
        return productDetails.getProductRating(id);
    }
}
