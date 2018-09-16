package com.example.deepak.prototype2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT= 3000;
    private  static String MyPREFS_NAME = "MyPREFS_NAME";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        sharedPreferences = getSharedPreferences(MyPREFS_NAME, MODE_PRIVATE);

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
