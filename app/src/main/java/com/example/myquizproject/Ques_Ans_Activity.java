package com.example.myquizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myquizproject.ExtraClass.Model_Getter_Setter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ques_Ans_Activity extends AppCompatActivity implements View.OnClickListener {

    RequestQueue queue;
    String TAG="courserequest";

    ArrayList<Model_Getter_Setter> arrlst = new ArrayList<Model_Getter_Setter>();

    RadioGroup rg;
    TextView txt_ques,topic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques__ans_);

        arrlst = getIntent().getParcelableArrayListExtra("arr");

        topic = findViewById(R.id.topic);
        txt_ques = findViewById(R.id.tx4);
        rg = findViewById(R.id.rdo1);

        topic.setText(arrlst.get(0).getCat());
        txt_ques.setText(arrlst.get(0).getQues());
        addRadioButtons(arrlst.get(0).getIncorrect_ans().length);

}
    public void addRadioButtons(int number) {
        rg.setOrientation(LinearLayout.VERTICAL);
        //
        for (int i = 0; i <= number; i++) {
            RadioButton rdbtn = new RadioButton(this);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                rdbtn.setId(View.generateViewId());

            }
            //String arr[] = arrlst.get(0).getIncorrect_ans();
            rdbtn.setText(arrlst.get(0).getIncorrect_ans()[i]);
            //rdbtn.setText(arrlst.get(0).getCorrect_ans());
            rdbtn.setOnClickListener(this);
            rg.addView(rdbtn);
        }

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, " Name " + ((RadioButton)v).getText() +" Id is "+v.getId());
    }
}
