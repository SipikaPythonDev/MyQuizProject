package com.example.myquizproject;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.AppCompatSpinner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

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
import com.example.myquizproject.ExtraClass.URLSetup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import android.view.View;
import android.widget.Button;

public class JsonActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnd;

    RequestQueue queue;
    String TAG="courserequest";
    Model_Getter_Setter obj;
    ArrayList<Model_Getter_Setter> arr=new ArrayList<Model_Getter_Setter>();


    AppCompatSpinner spinner,spinner2,spinner3;
    ArrayList<String> arrayList =new ArrayList<String>();
   // String url = URLSetup.url +"amount=10&category=9&difficulty=easy&type=multiple";





    @SuppressLint("WrongViewCast")
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);


        btnd = (Button) findViewById(R.id.btnd);
       // spinner =findViewById(R.id.spin2);
       // spinner2 =findViewById(R.id.spin3);
       // spinner3 = findViewById(R.id.spin4);

        btnd.setOnClickListener(this);


        queue = Volley.newRequestQueue(this);
        String url = URLSetup.url +"https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=multiple";
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        Log.e("==url==", "" + url);
        // Request a string response from the provided URL.
        com.android.volley.toolbox.StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("===response==", "==" + response);
                        pDialog.dismiss();

                        try {
                            JSONObject jobj = null;

                            jobj = new JSONObject(response);

                            JSONArray jarr = jobj.getJSONArray("all");

                            for (int i = 0; i < jarr.length(); i++) {
                                JSONObject jobj1 = null;

                                jobj1 = jarr.getJSONObject(i);
                                String results = jobj1.getString("results");
                                String first = jobj1.getString("first");
                                // String first=null;
                                if(jobj1.has("Results")) {

                                    JSONObject jobj2 = jobj1.getJSONObject("category");
                                    JSONObject jobj3 = jobj2.getJSONObject("type");
                                    JSONObject jobj4 =  jobj3.getJSONObject("difficulty");
                                    JSONObject  jobj5 = jobj4.getJSONObject("question");
                                    JSONObject jobj6 = jobj5.getJSONObject("correct_answer");
                                    JSONObject jobj7 = jobj6.getJSONObject("Incorrect_answers");

                                    // JSONObject jobj =
                                    first = jobj7.getString("first");


                                }


                                //String category;

                                // String difficulty;

                              //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                                       // android.R.layout.simple_spinner_dropdown_item,arrayList);
                               // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                               // spinner.setAdapter(adapter);
                               // spinner2.setAdapter(adapter);
                              //  spinner3.setAdapter(adapter);




                            }



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

    @Override
    public void onClick(View v) {


        //Intent intent=new Intent(JsonActivity.this,ChoiceActivity.class);
       // startActivity(intent);

        Intent in = new Intent(JsonActivity.this, Ques_Ans_Activity.class);
        startActivity(in);





    }
}




