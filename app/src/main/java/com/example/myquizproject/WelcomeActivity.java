package com.example.myquizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button btn_str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        btn_str = findViewById(R.id.btn1);

        btn_str = findViewById(R.id.btn1);


        btn_str.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WelcomeActivity.this, ChoiceActivity.class);
                startActivity(intent);

               // Intent in =new Intent(WelcomeActivity.this,JsonActivity.class);
                //startActivity(in);

            }
}

        );
    }}

