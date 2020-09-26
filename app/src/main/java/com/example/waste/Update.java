package com.example.waste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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

public class Update extends AppCompatActivity {

    private Button btnChoose, btnUpload;
    private ProgressBar progressBar;
    EditText locality,landmark,assigndriver,idText,spinner,address;

    String encodedImage;

    String RETRIEVE_URL="http://www.olande.co.ke/retrieve.php";
    String UPDATE_URL="http://www.olande.co.ke/olandeupdate.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        btnUpload = (Button) findViewById(R.id.button_upload);
        locality=(EditText)findViewById(R.id.locality);
        landmark=(EditText)findViewById(R.id.landmark);
        assigndriver=(EditText)findViewById(R.id.assigndriver);
        spinner=(EditText)findViewById(R.id.spinner);
        address=(EditText)findViewById(R.id.address);
        btnChoose=(Button)findViewById(R.id.retrieve);
        idText=(EditText)findViewById(R.id.idText);


         btnChoose.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(Update.this, "Getting Data From Server. Please Wait", Toast.LENGTH_SHORT).show();
                 RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                 StringRequest stringRequest=new StringRequest(Request.Method.POST, RETRIEVE_URL, new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {

                         try {
                             JSONObject jsonObject = new JSONObject(response);
                             locality.setText(jsonObject.getString("locality"));
                             landmark.setText(jsonObject.getString("landmark"));
                             assigndriver.setText(jsonObject.getString("assigndriver"));
                             spinner.setText(jsonObject.getString("spinner"));
                             address.setText(jsonObject.getString("address"));

                         } catch (JSONException e) {
                             e.printStackTrace();
                         }
                     }
                           }, new Response.ErrorListener() {
                             @Override
                             public void onErrorResponse(VolleyError error) {

                     }
                 })
                 {
                     @Override
                     public Map<String, String> getParams() throws AuthFailureError {
                         Map<String,String> params=new HashMap<>();
                         params.put("id",idText.getText().toString());
                         return params;
                     }

                 };

 requestQueue.add(stringRequest);
             }
         });

    btnUpload.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (encodedImage !=null){


                Toast.makeText(Update.this, "sending", Toast.LENGTH_SHORT).show();

                RequestQueue requestQueue= Volley.newRequestQueue(Update.this);

                StringRequest stringRequest =new StringRequest(Request.Method.POST, UPDATE_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Update.this, response, Toast.LENGTH_LONG);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("id", idText.getText().toString());
                        params.put("locality",locality.getText().toString());
                        params.put("landmark",landmark.getText().toString());
                        params.put("assigndriver",assigndriver.getText().toString());
                        params.put("spinner",spinner.getText().toString());
                        params.put("address",address.getText().toString());
                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return super.getHeaders();
                }
                };
                requestQueue.add(stringRequest);

            }
        }
    });

    }
}
