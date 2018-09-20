package com.example.deepak.prototype2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserProfileEditor extends Activity {
    private  static String MyPREFS_NAME = "MyPREFS_NAME";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_editor);

        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences(MyPREFS_NAME, MODE_PRIVATE);
        final SharedPreferences.Editor edit = sharedPreferences.edit();

        final TextView email;

        email = (TextView)findViewById(R.id.email_editor);
        final EditText weight= (EditText) findViewById(R.id.weight_editor);
        final EditText height= (EditText) findViewById(R.id.height_editor);
        final EditText workad= (EditText) findViewById(R.id.workadd_editor);
        final EditText homeadd= (EditText) findViewById(R.id.homeadd_editor);
        final EditText gender= (EditText) findViewById(R.id.gendr_editor);
        final EditText age= (EditText) findViewById(R.id.age_editor);
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
        Button btn = (Button)findViewById(R.id.button_editor);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight1,height1,age1,workadd1,homeadd1,gender1;
                weight1=weight.getText().toString();
                height1 = height.getText().toString();
                workadd1=workad.getText().toString();
                homeadd1=homeadd.getText().toString();
                gender1=gender.getText().toString();
                age1=age.getText().toString();
                edit.putString("user_weight", weight1);
                edit.putString("user_height", height1);
                edit.putString("user_homeadd", homeadd1);
                edit.putString("user_workadd", workadd1);
                edit.putString("user_age", age1);
                edit.putString("user_gender", gender1);
                edit.commit();
                Intent i = new Intent(UserProfileEditor.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(UserProfileEditor.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
