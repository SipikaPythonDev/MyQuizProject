package com.example.myquizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.widget.AppCompatSpinner;

import android.app.ProgressDialog;
//import android.os.Bundle;
import android.util.Log;


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


import android.widget.Toast;


public class ChoiceActivity extends AppCompatActivity{

    Button btn_btnd;
    String[]  category1 = {"Any Category" , "General Knowledge", "History", "Science:Computers", "Art" };
    String[] catid = {"0","9","23","18","25"};

    String[] difficulty = {"Any Difficulty", "Easy", "Medium", "Hard"};
    String [] type ={"Any Type", "Multiple Choice", "True/False"};
    String [] type1 ={"Any Type", "multiple", "boolean"};
    //ArrayList<String> in_arr = new ArrayList<String>();

    RequestQueue queue;
    String TAG="courserequest";
    Model_Getter_Setter obj;
    ArrayList<Model_Getter_Setter> arr=new ArrayList<Model_Getter_Setter>();

    AppCompatSpinner spinner,spinner2,spinner3;
    ArrayList<String> arrayList =new ArrayList<String>();
    String cat,diff,typee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);


        final Spinner spin = (Spinner) findViewById(R.id.spin2);
        Spinner spin1 = (Spinner) findViewById(R.id.spin3);
        final Spinner spin2 = (Spinner) findViewById(R.id.spin4);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, difficulty);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(adapter);
        spin1.setAdapter(adapter1);
        spin2.setAdapter(adapter2);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cat = catid[position];

                Toast.makeText(ChoiceActivity.this, category1[position] + " === " + cat + " == ", Toast.LENGTH_SHORT).show();

                //Toast.makeText(getApplicationContext(), "Selected User: "+category[position] ,Toast.LENGTH_SHORT).show();
                //  catid ='9';

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                diff = difficulty[position];
                Toast.makeText(ChoiceActivity.this, diff, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typee = type1[position];
                Toast.makeText(ChoiceActivity.this, diff, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn_btnd = findViewById(R.id.btnd);

        btn_btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //https://opentdb.com/api.php?amount=10&category=11&difficulty=medium&type=multiple
                setQuestioneer();


            }
        });



    }

    void setQuestioneer(){
        queue = Volley.newRequestQueue(this);
        //String url = getIntent().getStringExtra("url");
        String url = "https://opentdb.com/api.php?amount=10&category="+cat+"&difficulty="+diff.toLowerCase()+"&type="+typee.toLowerCase();

        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        Log.e("==url==", "" + url);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("===response==", "==" + response);
                        pDialog.dismiss();

                        try {
                            JSONObject jobj = new JSONObject(response);
                            JSONArray jarr = jobj.getJSONArray("results");

                            for (int i = 0; i < jarr.length(); i++) {

                                JSONObject jobj1 = jarr.getJSONObject(i);
                                String category = jobj1.getString("category");
                                String type = jobj1.getString("type");
                                String difficulty = jobj1.getString("difficulty");
                                String question = jobj1.getString("question");
                                String correct_answer = jobj1.getString("correct_answer");
                                JSONArray incorrect_arr = jobj1.getJSONArray("incorrect_answers");
                                String[] in_arr=new String[incorrect_arr.length()];
                                for(int j=0; j<incorrect_arr.length(); j++){
                                    String s=incorrect_arr.getString(j);

                                    in_arr[j]=s;

                                }
                                obj = new Model_Getter_Setter(category,question,in_arr,correct_answer);
                                arr.add(obj);

                            }
                            Intent intent = new Intent(ChoiceActivity.this, Ques_Ans_Activity.class);
                            intent.putExtra("arr",arr);
                            startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("===error==", "==" + error);
                pDialog.dismiss();
            }
        });
        stringRequest.setTag(TAG);

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


}









