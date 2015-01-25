package com.zkhaider.red_code.ui;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.elasticode.ElastiCode;
import com.zkhaider.red_code.R;
import com.zkhaider.red_code.materialdialogs.MaterialDialog;

/**
 * Created by Haider on 1/24/2015.
 */
public class SubmissionFragment extends Fragment {

    private static SubmissionFragment fragment;

    private ImageButton fab;

    public static Fragment newInstance() {
        if (fragment == null) {
            fragment = new SubmissionFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.submission_layout, null);

        fab = (ImageButton) root.findViewById(R.id.submitButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(getActivity())
                        .title(R.string.materialTitle)
                        .icon(R.drawable.ic_elasticode_logo_fixed)
                        .content(R.string.materialContent)
                        .positiveText(R.string.materialAgree)
                        .icon(R.drawable.ic_barcode_icon)
                        .callback(new MaterialDialog.ButtonCallback() {
                            @Override
                            public void onPositive(MaterialDialog dialog) {
                                super.onPositive(dialog);

                                String android_id = Settings.Secure.getString(getActivity().getContentResolver(),
                                        Settings.Secure.ANDROID_ID);

                                ElastiCode.event("User: " + android_id + " is interested.");
                            }
                        })
                        .show();
            }
        });

        return root;
    }

}
