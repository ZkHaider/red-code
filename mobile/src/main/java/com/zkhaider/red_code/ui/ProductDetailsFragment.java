package com.zkhaider.red_code.ui;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.zkhaider.red_code.models.ProductDetails;
import com.zkhaider.red_code.models.ProductSearch;
import com.zkhaider.red_code.services.SearsClient;

import java.net.URL;

/**
 * Created by Haider on 1/24/2015.
 */
public class ProductDetailsFragment extends Fragment {

    private static ProductDetailsFragment fragment;
    private String code;
    private ProductDetails mProductDetails;

    public static Fragment newInstance() {
        if (fragment == null) {
            fragment = new ProductDetailsFragment();
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        code = ((ProductActivity)getActivity()).code;

        new FetchProductDetailsTask().execute();
    }

    private void setupFragment()
    {

    }

    private class FetchProductDetailsTask extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... params)
        {
            SearsClient service = SearsClient.get(getActivity());

            ProductSearch productSearch = service.getProductSearch(code);
            Log.d(".number.",code);

            String partNumber = productSearch.getSearchResults().getProducts().get(0).getId().getPartNumber();

            Log.d(".pid.",partNumber);

            mProductDetails = service.getProductDetails(partNumber);

            return null;
        }

        @Override
        protected void onPostExecute(Void a)
        {
            setupFragment();
        }
    }
}

