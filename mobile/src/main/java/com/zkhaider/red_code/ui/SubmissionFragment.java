package com.zkhaider.red_code.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zkhaider.red_code.R;

/**
 * Created by Haider on 1/24/2015.
 */
public class SubmissionFragment extends Fragment {

    private static SubmissionFragment fragment;

    public static Fragment newInstance() {
        if (fragment == null) {
            fragment = new SubmissionFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.submission_layout, null);

        return root;
    }

}
