package com.zkhaider.red_code.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.zkhaider.red_code.R;
import com.zkhaider.red_code.materialtabs.MaterialTab;
import com.zkhaider.red_code.materialtabs.MaterialTabHost;
import com.zkhaider.red_code.materialtabs.MaterialTabListener;
import com.zkhaider.red_code.ui.adapters.MainPagerAdapter;

/**
 * Created by Haider on 1/24/2015.
 */
public class ProductActivity extends ActionBarActivity implements MaterialTabListener {

    public static final String TAG = ProductActivity.class.getSimpleName();

    /*
    Material Tabs UI variables
     */
    private MaterialTab[] materialTabs;
    private MaterialTabHost materialTabHost;

    private ViewPager viewPager;
    private MainPagerAdapter viewPagerAdapter;
    private Resources res;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

        setupUI();
    }


    public void setupUI() {
        // Grab resources
        res = this.getResources();

        // Setup Material Tabs and Adapters for tab host
        materialTabHost = (MaterialTabHost) findViewById(R.id.materialTabHost);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), this);

        materialTabs = new MaterialTab[viewPagerAdapter.getCount()];
        setupTabs();

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // Set the material to the one on the viewpager when it is swiped.
                materialTabHost.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setupTabs() {
        // Insert the tabs from the adapter into the material tab host
        for (int i = 0; i < viewPagerAdapter.getCount(); i++) {
            materialTabs[i] = new MaterialTab(this, true);
            materialTabs[i].setIcon(getIcon(i));
            materialTabs[i].setTabListener(this);
            materialTabHost.addTab(materialTabs[i]);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called and materialTabHost enabled = " + materialTabHost.isEnabled());
        Log.d(TAG, "onPause called and materialTabHost activated = " + materialTabHost.isActivated());
        Log.d(TAG, "onPause called and materialTabHost clickable = " + materialTabHost.isClickable());

        if (materialTabHost.isEnabled()) {

        }

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called and materialTabHost enabled = " + materialTabHost.isEnabled());
        Log.d(TAG, "onStop called and materialTabHost activated = " + materialTabHost.isActivated());
        Log.d(TAG, "onStop called and materialTabHost clickable = " + materialTabHost.isClickable());

        if (materialTabHost.isEnabled()) {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called and materialTabHost enabled = " + materialTabHost.isEnabled());
        Log.d(TAG, "onResume called and materialTabHost activated = " + materialTabHost.isActivated());
        Log.d(TAG, "onResume called and materialTabHost clickable = " + materialTabHost.isClickable());
        registerMaterialTabHost();
        if (!materialTabHost.isEnabled() || materialTabHost.isActivated() || materialTabHost.isClickable()) {
            materialTabHost.setActivated(true);
            materialTabHost.setClickable(true);
        }
    }

    private void unregisterMaterialTabHost() {
        // Unresgister the tabhost
        materialTabHost.setVisibility(View.INVISIBLE);
        materialTabHost.setEnabled(false);
    }

    private void registerMaterialTabHost() {
        // Register the material tabhost
        materialTabHost.setVisibility(View.VISIBLE);
        materialTabHost.setEnabled(false);
    }

    @Override
    public void onTabSelected(MaterialTab tab) {
        // when the tab is clicked the pager swipe content to the tab position
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }

    /*
    Grab the drawable icons for the material tabs
     */
    private Drawable getIcon(int position) {
        switch (position) {
            case 0:
                return res.getDrawable(R.drawable.ic_action);
            case 1:
                return res.getDrawable(R.drawable.ic_details);
            case 2:
                return res.getDrawable(R.drawable.ic_submission);
        }
        return null;
    }

}
