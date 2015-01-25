package com.zkhaider.red_code.services;


import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.http.Path;
import retrofit.http.Query;
        import retrofit.http.GET;
        import retrofit.http.POST;

        import android.content.Context;
        import android.content.SharedPreferences;
import android.util.Log;

import com.zkhaider.red_code.models.Price;
import com.zkhaider.red_code.models.ProductDetails;
import com.zkhaider.red_code.models.ProductSearch;

/**
 * Created by kcoleman on 11/18/14.
 */

public class SearsClient {

    private static SearsClient sSearsClient;
    private static final String API_URL = "http://api.developer.sears.com/v2.1";

    private static RestAdapter mRestAdapter;

    interface IProductDetails {
        @GET("/products/details/Sears/json/{id}")
        ProductDetails getProductDetails(@Path("id") String id, @Query("apikey") String api_key);
    }

    interface IProductSearch {
        @GET("/products/search/Sears/json/keyword/{code}")
        ProductSearch getProductSearch(@Path("code") String id, @Query("apikey") String api_key);
    }

    interface IPriceSearch {
        @GET("/products/details/Sears/json/{id}")
        Price getPrice(@Path("id") String id, @Query("apikey") String api_key);
    }

    private SearsClient(Context context)
    {
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .build();

    }

    public static SearsClient get(Context context)
    {
        if (sSearsClient == null) {
            sSearsClient = new SearsClient(context);
        }
        return sSearsClient;
    }

    public ProductDetails getProductDetails(String id)
    {
        IProductDetails productDetails = mRestAdapter.create(IProductDetails.class);
        return productDetails.getProductDetails(id, getAPIKey());
    }

    public ProductSearch getProductSearch(String code)
    {
        IProductSearch productSearch = mRestAdapter.create(IProductSearch.class);

        ProductSearch ps = new ProductSearch();

        try {
            ps = productSearch.getProductSearch(code, getAPIKey());
        } catch (RetrofitError e) {
            Log.d(".retro.", e.toString());
        }

        return ps;
    }

    public Price getPrice(String id) {

        IPriceSearch priceSearch = mRestAdapter.create(IPriceSearch.class);

        return priceSearch.getPrice(id, getAPIKey());
    }

    private String getAPIKey()
    {
        return "85WogFIkPnyNG4pHQ18wE8LUsr4tuCtG";
    }
}

