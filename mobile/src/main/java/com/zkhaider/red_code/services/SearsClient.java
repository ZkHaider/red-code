package com.zkhaider.red_code.services;


import retrofit.RestAdapter;
import retrofit.http.Path;
import retrofit.http.Query;
        import retrofit.http.GET;
        import retrofit.http.POST;

        import android.content.Context;
        import android.content.SharedPreferences;

import com.zkhaider.red_code.models.ProductDetails;

/**
 * Created by kcoleman on 11/18/14.
 */

public class SearsClient {

    private static String TAG = "io.sparkstart.atl_startup.AtlantaStartupJobsClient";
    private static String PREFS_NAME = "ATLStartup";
    private static SearsClient sSearsClient;
    private static final String API_URL = "http://api.developer.sears.com/v2.1/";

    private static String mAPIKey;
    private static RestAdapter mRestAdapter;
    private static Context mContext;

    interface IProductDetails {
        @GET("/products/details/Sears/json/{id}")
        ProductDetails getProductDetails(@Path("id") String id, @Query("api_key") String api_key);
    }

    private SearsClient(Context context)
    {
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setLogLevel(RestAdapter.LogLevel.NONE)
                .build();

        mContext = context;
    }

    public static SearsClient get(Context context)
    {
        if (sSearsClient == null)
        {
            sSearsClient = new SearsClient(context);
        }
        return sSearsClient;
    }

    public ProductDetails getProductDetails(String id)
    {
        IProductDetails productDetails = mRestAdapter.create(IProductDetails.class);
        return productDetails.getProductDetails(id, getAPIKey());
    }

    private String getAPIKey()
    {
        return "85WogFIkPnyNG4pHQ18wE8LUsr4tuCtG";
    }
}
