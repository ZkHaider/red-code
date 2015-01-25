package com.zkhaider.red_code.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zkhaider.red_code.R;
import com.zkhaider.red_code.models.Product;
import com.zkhaider.red_code.models.ProductSearch;
import com.zkhaider.red_code.services.ReviewsClient;
import com.zkhaider.red_code.services.SearsClient;
import com.zkhaider.red_code.ui.adapters.RatingsAdapter;
import com.zkhaider.red_code.ui.itemdecoration.SpacesItemDecoration;

import java.util.List;

/**
 * Created by Haider on 1/24/2015.
 */
public class RatingsFragment extends Fragment {

    private static Fragment fragment;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<Product> products;
    private int productListSize;

    private String code;

    private String overallRating;

    public static final int DIVIDER_SPACE = 1;

    public static Fragment newInstance() {
        if (fragment == null) {
            fragment = new RatingsFragment();
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        code = ((ProductActivity)getActivity()).code;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_product_ratings, null);

        recyclerView = (RecyclerView) root.findViewById(R.id.ratings_recycler_view);

        // Add Item Decoration
        recyclerView.addItemDecoration(new SpacesItemDecoration(DIVIDER_SPACE));

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        Context context = getActivity();

        mAdapter = new RatingsAdapter();
        recyclerView.setAdapter(mAdapter);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        Context context = getActivity();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private class FetchProductRatingsTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {

            SearsClient service = SearsClient.get(getActivity());

            ProductSearch productSearch = service.getProductSearch(code);
            Log.d(".number.", code);

            products = productSearch.getSearchResults().getProducts();

            if (products != null) {
                productListSize = products.size();
            }

            if (products == null) {
                Toast.makeText(getActivity(), "This product was not found", Toast.LENGTH_LONG).show();
            } else {

                String partNumber = productSearch.getSearchResults().getProducts().get(0).getId().getPartNumber();

                Log.d(".pid.", partNumber);

                ReviewsClient reviewsService = ReviewsClient.get(getActivity());

                reviewsService.getProductRating(code);

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void a) {
            // Update the UI here

        }
    }
}
