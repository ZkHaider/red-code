package com.zkhaider.red_code.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;
import com.zkhaider.red_code.zxing.ZXingScannerView;

/**
 * Created by Haider on 1/24/2015.
 */
public class SimpleScannerFragment extends Fragment implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private static SimpleScannerFragment fragment;

    public static Fragment newInstance() {
        if (fragment == null) {
            fragment = new SimpleScannerFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mScannerView = new ZXingScannerView(getActivity());
        return mScannerView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        Intent i = new Intent(getActivity(), ProductActivity.class);
        i.putExtra("code",rawResult.toString());
        startActivity(i);
        //mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }
}
