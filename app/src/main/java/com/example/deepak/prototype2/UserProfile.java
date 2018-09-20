package com.example.deepak.prototype2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class UserProfile extends Activity  {
    //Button b2;
//    TextView b1;
//    EditText ed1,ed2;
//    ImageView imageView,imageView2,imageView3,imageView1;
//    TextView bt1;
//    TextView tx1;
//    int counter = 3;
    private  static String MyPREFS_NAME = "MyPREFS_NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);



        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences(MyPREFS_NAME, MODE_PRIVATE);

        TextView email,weight,height,workad,homeadd,gender,age;
        email = (TextView)findViewById(R.id.blood_group);
        weight= (TextView)findViewById(R.id.education);
        height= (TextView)findViewById(R.id.occupation);
        workad= (TextView)findViewById(R.id.mobileNumber);
        homeadd= (TextView)findViewById(R.id.gender);
        gender= (TextView)findViewById(R.id.marriage);
        age= (TextView)findViewById(R.id.dob);
        String email1,weight1,height1,age1,workadd1,homeadd1,gender1;
        email1=sharedPreferences.getString("user_email","lorem@ipsum.com");
        weight1=sharedPreferences.getString("user_weight","65 kg");
        height1=sharedPreferences.getString("user_height","5' 4''");
        homeadd1=sharedPreferences.getString("user_homeadd","#2, Green Park, Andheri");
        workadd1=sharedPreferences.getString("user_workadd","Amadeus Labs, Prestige Tech Park");
        age1 = sharedPreferences.getString("user_age","19 Years");
        gender1=sharedPreferences.getString("user_gender","Male");
        email.setText(email1);
        weight.setText(weight1);
        height.setText(height1);
        workad.setText(workadd1);
        homeadd.setText(homeadd1);
        gender.setText(gender1);
        age.setText(age1);
        ImageView btn_edit = (ImageView)findViewById(R.id.edit_btn);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserProfile.this, UserProfileEditor.class);
                startActivity(i);
                finish();
            }
        });


//        b1 = (TextView)findViewById(R.id.textView);
//        ed1 = (EditText)findViewById(R.id.editText);
//        ed2 = (EditText)findViewById(R.id.editText2);
//        bt1=(TextView)findViewById(R.id.login_button);
//        imageView = (ImageView) findViewById(R.id.imageView_Login);
//        imageView.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.logo));
//
//
//
//
//
//        bt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Login.this, MainActivity.class);
//                startActivity(i);
//                finish();
//
//            }
//        });
//
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(UserProfile.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}