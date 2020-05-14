package com.example.myquizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_reg;
    EditText edt_1, edt_2, edt_3;
    String name;
    String username;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btn_reg = findViewById(R.id.btn5);

        edt_1 = findViewById(R.id.edt5);
        edt_2 = findViewById(R.id.edt6);
        edt_3 = findViewById(R.id.edt7);

        btn_reg.setOnClickListener(this);

        name = edt_1.getText().toString();
        username = edt_2.getText().toString();
        password = edt_3.getText().toString();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn5:
                Intent in = new Intent(RegistrationActivity.this, WelcomeActivity.class);
                startActivity(in);
                break;


        }
    }
}
