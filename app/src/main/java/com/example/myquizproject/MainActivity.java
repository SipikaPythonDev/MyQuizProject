package com.example.myquizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_name,edt_pass;
    Button btn_sub,btn_can,btn_reg;
    String name,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name=getIntent().getStringExtra( "A");
        pass=getIntent().getStringExtra( "B");

        edt_name=findViewById(R.id.edt1);
        edt_pass=findViewById(R.id.edt2);

        btn_sub=findViewById(R.id.btn1);
        btn_can=findViewById(R.id.btn2);
        btn_reg=findViewById(R.id.btn3);

        btn_sub.setOnClickListener(this);
        btn_can.setOnClickListener(this);
        btn_reg.setOnClickListener(this);







    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn1:
                Log.d("submit button clicked", "submit the data");
                String name = edt_name.getText().toString();
                String pass = edt_pass.getText().toString();
                if (name.equals(name) && pass.equals(pass)) {
                    Intent in = new Intent(MainActivity.this, WelcomeActivity.class);
                    in.putExtra("A", name);
                    startActivity(in);

                } else {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn2:
                Log.d("cancle button clicked", "Cancle");
                Toast.makeText(getApplicationContext(), "Successfully Cancelled", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn3:
                Log.d("reg button clicked", "Registration Successfully Completed");
                Intent in = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(in);

                break;








        }
}}
