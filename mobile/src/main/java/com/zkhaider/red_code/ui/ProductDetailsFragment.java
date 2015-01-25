package com.zkhaider.red_code.ui;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.zkhaider.red_code.R;
import com.zkhaider.red_code.models.Price;
import com.zkhaider.red_code.models.Product;
import com.zkhaider.red_code.models.ProductDetails;
import com.zkhaider.red_code.models.ProductSearch;
import com.zkhaider.red_code.services.SearsClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haider on 1/24/2015.
 */
public class ProductDetailsFragment extends Fragment {

    public static final String TAG = ProductDetailsFragment.class.getSimpleName();

    private static ProductDetailsFragment fragment;
    private List<Product> products;
    private int productListSize;
    private String code;
    private ProductDetails mProductDetails;
    private Price price;

    /*
    UI Elements
     */
    private ImageView image;
    private TextView mBrandName;
    private TextView mProductName;
    private TextView mPrice;

    public static Fragment newInstance() {
        if (fragment == null) {
            fragment = new ProductDetailsFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_product_details, null);

        image = (ImageView) root.findViewById(R.id.imageUrl);
        mBrandName = (TextView) root.findViewById(R.id.brandName);
        mProductName = (TextView) root.findViewById(R.id.productName);
        mPrice = (TextView) root.findViewById(R.id.productPriceNumber);



        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        code = ((ProductActivity)getActivity()).code;

        new FetchProductDetailsTask().execute();
    }

    private void setupFragment()
    {

        String tempImageUrl = mProductDetails
                .getProductDetail()
                .getSoftHardProductDetails()
                .getDescription()
                .getImages()
                .getMainImageUrl();

        Picasso.with(getActivity()).load(tempImageUrl)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .resize(100, 100)
                .centerInside()
                .into(image);

        String tempName = mProductDetails
                .getProductDetail()
                .getSoftHardProductDetails()
                .getDescription()
                .getDescriptionName();

        Log.d(TAG, "ProductName: " + tempName);
        mProductName.setText(tempName);


        String tempPrice = price.getSalePrice();
        Log.d(TAG, "TempPrice: " + tempPrice);
        mPrice.setText(tempPrice);

    }

    private class FetchProductDetailsTask extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... params)
        {
            SearsClient service = SearsClient.get(getActivity());

            ProductSearch productSearch = service.getProductSearch(code);
            Log.d(".number.",code);

            products = productSearch.getSearchResults().getProducts();

            if (products != null) {
                productListSize = products.size();
            }

            if (products == null) {
                Toast.makeText(getActivity(), "This product was not found", Toast.LENGTH_LONG).show();
            } else {

                String partNumber = productSearch.getSearchResults().getProducts().get(0).getId().getPartNumber();

                Log.d(".pid.", partNumber);


                mProductDetails = service.getProductDetails(partNumber);
                price = service.getPrice(partNumber);

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void a)
        {
            if (products != null) {
                setupFragment();
            }
        }
    }
}

