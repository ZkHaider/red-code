package com.zkhaider.red_code.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.zkhaider.red_code.R;
/**
 * Created by Haider on 1/3/2015.
 */
public class SplashActivity extends Activity {

    private ImageView redCodeLogo;
    // Set the display time, in milliseconds (or extract it out as a configurable parameter)
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        redCodeLogo = (ImageView) findViewById(R.id.redCodeLogo);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent openMainActivity =  new Intent(SplashActivity.this, MainActivity.class);
                startActivity(openMainActivity);
                finish();

            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}