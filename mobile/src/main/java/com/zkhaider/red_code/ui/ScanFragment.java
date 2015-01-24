package com.zkhaider.red_code.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.integration.android.IntentIntegrator;
import com.zkhaider.red_code.R;

/**
 * Created by Haider on 1/24/2015.
 */
public class ScanFragment extends Fragment {

    private String scanResult;
    private IntentIntegrator intentIntegrator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.custom_fragment_capture, null);

        // Add other code here

        return root;
    }



}
