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
import android.widget.ImageView;
import android.widget.Toast;

import com.zkhaider.red_code.R;
import com.zkhaider.red_code.models.Product;
import com.zkhaider.red_code.models.ProductRating;
import com.zkhaider.red_code.models.ProductSearch;
import com.zkhaider.red_code.models.Review;
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
    private List<Review> mReviews;
    private int productListSize;

    // Star icons
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;

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
        code = ((ProductActivity)getActivity()).getCode();

        new FetchProductRatingsTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_product_ratings, null);

        // Declare the stars by Id
        star1 = (ImageView) root.findViewById(R.id.star1);
        star2 = (ImageView) root.findViewById(R.id.star2);
        star3 = (ImageView) root.findViewById(R.id.star3);
        star4 = (ImageView) root.findViewById(R.id.star4);
        star5 = (ImageView) root.findViewById(R.id.star5);


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

        double score = 3.5;

        changeStarIcons(score);


        return root;
    }


    private void changeStarIcons(double score) {

        if (score == 0) {
            star1.setImageResource(R.drawable.ic_toggle_star_outline);
            star2.setImageResource(R.drawable.ic_toggle_star_outline);
            star3.setImageResource(R.drawable.ic_toggle_star_outline);
            star4.setImageResource(R.drawable.ic_toggle_star_outline);
            star5.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score < 0) {
            star1.setImageResource(R.drawable.ic_toggle_star_half);
            star2.setImageResource(R.drawable.ic_toggle_star_outline);
            star3.setImageResource(R.drawable.ic_toggle_star_outline);
            star4.setImageResource(R.drawable.ic_toggle_star_outline);
            star5.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score == 1) {
            star1.setImageResource(R.drawable.ic_toggle_star);
            star2.setImageResource(R.drawable.ic_toggle_star_outline);
            star3.setImageResource(R.drawable.ic_toggle_star_outline);
            star4.setImageResource(R.drawable.ic_toggle_star_outline);
            star5.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score < 2 && score > 1) {
            star1.setImageResource(R.drawable.ic_toggle_star);
            star2.setImageResource(R.drawable.ic_toggle_star_half);
            star3.setImageResource(R.drawable.ic_toggle_star_outline);
            star4.setImageResource(R.drawable.ic_toggle_star_outline);
            star5.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score == 2) {
            star1.setImageResource(R.drawable.ic_toggle_star);
            star2.setImageResource(R.drawable.ic_toggle_star);
            star3.setImageResource(R.drawable.ic_toggle_star_outline);
            star4.setImageResource(R.drawable.ic_toggle_star_outline);
            star5.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score > 2 && score < 3) {
            star1.setImageResource(R.drawable.ic_toggle_star);
            star2.setImageResource(R.drawable.ic_toggle_star);
            star3.setImageResource(R.drawable.ic_toggle_star_half);
            star4.setImageResource(R.drawable.ic_toggle_star_outline);
            star5.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score == 3) {
            star1.setImageResource(R.drawable.ic_toggle_star);
            star2.setImageResource(R.drawable.ic_toggle_star);
            star3.setImageResource(R.drawable.ic_toggle_star);
            star4.setImageResource(R.drawable.ic_toggle_star_outline);
            star5.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score > 3 && score < 4) {
            star1.setImageResource(R.drawable.ic_toggle_star);
            star2.setImageResource(R.drawable.ic_toggle_star);
            star3.setImageResource(R.drawable.ic_toggle_star);
            star4.setImageResource(R.drawable.ic_toggle_star_half);
            star5.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score == 4) {
            star1.setImageResource(R.drawable.ic_toggle_star);
            star2.setImageResource(R.drawable.ic_toggle_star);
            star3.setImageResource(R.drawable.ic_toggle_star);
            star4.setImageResource(R.drawable.ic_toggle_star);
            star5.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score > 4 && score < 5) {
            star1.setImageResource(R.drawable.ic_toggle_star);
            star2.setImageResource(R.drawable.ic_toggle_star);
            star3.setImageResource(R.drawable.ic_toggle_star);
            star4.setImageResource(R.drawable.ic_toggle_star);
            star5.setImageResource(R.drawable.ic_toggle_star_half);
        } else if (score == 5) {
            star1.setImageResource(R.drawable.ic_toggle_star);
            star2.setImageResource(R.drawable.ic_toggle_star);
            star3.setImageResource(R.drawable.ic_toggle_star);
            star4.setImageResource(R.drawable.ic_toggle_star);
            star5.setImageResource(R.drawable.ic_toggle_star);
        }

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
                //Toast.makeText(getActivity(), "This product was not found", Toast.LENGTH_LONG).show();
            } else {

                String partNumber = products.get(0).getId().getPartNumber();

                Log.d(".pid.", partNumber);

                ReviewsClient reviewsService = ReviewsClient.get(getActivity());
                Log.d("......", "HERRRR");
                Log.d("......", "HERRRR");
                Log.d("......", "HERRRR");
                Log.d("......", "HERRRR");
                Log.d("......", "HERRRR");
                Log.d("......", "HERRRR");
                ProductRating pr = reviewsService.getProductRating(partNumber);
                mReviews = pr.getData().getReviews();
                changeStarIcons(Double.valueOf(pr.getData().getoverall_rating()));

            }
            mAdapter = new RatingsAdapter(mReviews);
            recyclerView.setAdapter(mAdapter);
            recyclerView.invalidate();
            return null;
        }

        @Override
        protected void onPostExecute(Void a) {
            // Update the UI here

        }
    }
}
