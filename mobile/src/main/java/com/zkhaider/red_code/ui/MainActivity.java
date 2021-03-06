package com.zkhaider.red_code.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.elasticode.ElastiCode;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.zkhaider.red_code.R;
import com.zkhaider.red_code.fab.FloatingActionButton;
import com.zkhaider.red_code.fab.FloatingActionMenu;

import java.util.Observable;
import java.util.Observer;


public class MainActivity extends ActionBarActivity {

    public static final String ELASTICODE_KEY = "sf04o2sy8pfcdu93ii2dpmvd";

    /*
    AppStart variabes
     */
    // Setup ENUM which will check to see if the user is starting new, latest version, or normal
    public enum  AppStart {
        FIRST_TIME, FIRST_TIME_VERSION, NORMAL;
    }

    /*
    App version code not the version name, used on the last start of the app
    */
    private final String LAST_APP_VERSION = "last_app_version";

    /*
    Cache the result of checkAppStart()
     */
    private AppStart appStart = null;

    /*
    Variables initialized below
     */
    private Context context;
    private SharedPreferences preferences;

    public static final String TAG = "MainActivity";

    private FloatingActionMenu floatingActionMenu;
    private FloatingActionButton barcodeScan;
    private FloatingActionButton qrcodeScan;
    private ImageButton scanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_fragment_capture);

        Observer obs = new Observer() {
            @Override
            public void update(Observable observable, Object data) {
                // If we got true then startSession was finished
                // Else restartSession
                if ((Boolean)data) {
                    // Add code here for defining the cases / dynamic objects
                    // and continue wiht the app flow
                } else {
                    // Elasticode was updated may want to refresh the screen UI
                }
            }
        };
        ElastiCode.devModeWithLogging();

        ElastiCode.startSession(ELASTICODE_KEY, obs, this);

        ElastiCode.setConnectionTimeout(2000);
        ElastiCode.setSOConnectionTimeout(4000);


        scanButton = (ImageButton) findViewById(R.id.scanButton);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.scanContainer, SimpleScannerFragment.newInstance());
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();

                scanButton.setVisibility(View.GONE);
            }
        });



    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanResult != null) {
            // Handle scan result
            String re = scanResult.getContents();
            Log.d(TAG, re);
        }

        // Else continue with any other code here
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
