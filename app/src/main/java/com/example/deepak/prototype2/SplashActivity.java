package com.example.deepak.prototype2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT= 3000;
    private  static String MyPREFS_NAME = "MyPREFS_NAME";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        sharedPreferences = getSharedPreferences(MyPREFS_NAME, MODE_PRIVATE);

        if (ContextCompat.checkSelfPermission(SplashActivity.this,
                android.Manifest.permission.PACKAGE_USAGE_STATS)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?

                // No explanation needed; request the permission
            ActivityCompat.requestPermissions(SplashActivity.this,
                    new String[]{android.Manifest.permission.PACKAGE_USAGE_STATS},
                    0);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
        } else {
            // Permission has already been granted
        }

        final String first_time_use_status = sharedPreferences.getString("isFirstTimeUsed", "true");
        final String user_id = sharedPreferences.getString("user_id", "null");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!first_time_use_status.equals("true")) {
                    if(user_id.equals("null")){
                        //change activity to login
                        Intent i = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else {
                        Intent i = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
                else{
                    Intent i = new Intent(SplashActivity.this, TourActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}
