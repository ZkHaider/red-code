package com.zkhaider.red_code.ui.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zkhaider.red_code.ui.ProductDetailsFragment;
import com.zkhaider.red_code.ui.RatingsFragment;
import com.zkhaider.red_code.ui.SubmissionFragment;

/**
 * Created by Haider on 1/24/2015.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public MainPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return RatingsFragment.newInstance();
            case 1:
                return ProductDetailsFragment.newInstance();
            case 2:
                return SubmissionFragment.newInstance();
            default:
                return RatingsFragment.newInstance();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }


}
