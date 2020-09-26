package com.example.waste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Report extends AppCompatActivity {
private Button Search,Delete;
private EditText textid;
private TextView Bino,Area,Time,Driver,Status;
    String encodedImage;

    String RETRIEVE_URL="http://www.olande.co.ke/retrieve.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

    Search= findViewById(R.id.search);
    Bino= findViewById(R.id.binno);
    Area= findViewById(R.id.area);
    Time= findViewById(R.id.time);
    textid=findViewById(R.id.textid);
    Search.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Toast.makeText(Report.this, "Getting Data From Server. Please Wait", Toast.LENGTH_SHORT).show();
            RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

            StringRequest stringRequest= new StringRequest(Request.Method.POST, RETRIEVE_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        Bino.setText(jsonObject.getString("Bino"));
                        Area.setText(jsonObject.getString("Area"));
                        Time.setText(jsonObject.getString("Time"));
                        Driver.setText(jsonObject.getString("Driver"));


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }



            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
                @Override
                public Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params=new HashMap<>();
                    params.put("id",textid.getText().toString());
                    return params;
                }
            };

            requestQueue.add(stringRequest);
        }
    });


    }
}
