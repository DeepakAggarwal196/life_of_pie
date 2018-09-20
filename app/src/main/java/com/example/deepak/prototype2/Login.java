package com.example.deepak.prototype2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends Activity  {
    //Button b2;
    TextView b1;
    EditText ed1,ed2;
    ImageView imageView,imageView2,imageView3,imageView1;
    TextView bt1;
    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        b1 = (TextView)findViewById(R.id.textView);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        bt1=(TextView)findViewById(R.id.login_button);
        imageView = (ImageView) findViewById(R.id.imageView_Login);
        imageView.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.logo));





        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
//
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }
}