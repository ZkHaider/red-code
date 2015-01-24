package com.zkhaider.red_code.ui;


import android.support.v4.app.Fragment;

/**
 * Created by Haider on 1/24/2015.
 */
public class ProductDetailsFragment extends Fragment {

    private static ProductDetailsFragment fragment;

    public static Fragment newInstance() {
        if (fragment == null) {
            fragment = new ProductDetailsFragment();
        }
        return fragment;
    }



}
