package com.example.waste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Binslocation extends AppCompatActivity {
    private Spinner spinner, driver;
    EditText locality,landmark,assindriver,address;
    Button submit;
    String Locality,Spinner,Landmark,Assigndriver,Address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binslocation);
        spinner=findViewById(R.id.spinner);
        locality=(EditText)findViewById(R.id.Locality);
        landmark=(EditText)findViewById(R.id.Landmark);
        address=(EditText)findViewById(R.id.Address);
        assindriver=(EditText)findViewById(R.id.assigndriver) ;

        submit=(Button)findViewById(R.id.Submit);

        List<String> categories= new ArrayList<>();
        categories.add(0,"Choose period");
        categories.add("Daily");
        categories.add("Every Two Days");
        categories.add("Every Two Weeks");
        categories.add("Every Month");
        ArrayAdapter<String> dataAdapter;
        dataAdapter= new ArrayAdapter<>( this,android.R.layout.simple_spinner_dropdown_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Choose Categories")){
                }else
                {
                    String item= parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(),"selected: "+item,Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Locality= locality.getText().toString();
                Landmark=landmark.getText().toString();
                Spinner= spinner.getSelectedItem().toString();

                Assigndriver=assindriver.getText().toString();
                Address=address.getText().toString();
                if (Landmark.isEmpty()){
                    Toast.makeText(Binslocation.this, "Fill the blank space ", Toast.LENGTH_SHORT).show();
                }else if (Locality.isEmpty()){
                    Toast.makeText(Binslocation.this, "Fill the blank space", Toast.LENGTH_SHORT).show();

                }else if (Assigndriver.isEmpty()){

                    Toast.makeText(Binslocation.this, "Fill the blank space", Toast.LENGTH_SHORT).show();

                }    else

                {
                    Toast.makeText(Binslocation.this, "sending data", Toast.LENGTH_LONG).show();
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    String url="http://www.olande.co.ke/binslocation.php?locality="+locality.getText().toString()+ "&landmark="+landmark.getText().toString()+"&address="+address.getText().toString()+"&spinner="+spinner.getSelectedItem().toString()+"&assigndriver="+assindriver.getText();
                    JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(Binslocation.this, "response", Toast.LENGTH_LONG).show();
                            try {
                                if (response.getString("status").equals("true")){
                                    Toast.makeText(Binslocation.this, " succesfully  submitted", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Binslocation.this, UserLogins.class);
                                    startActivity(intent);

                                }else {

                                    Toast.makeText(Binslocation.this, response.getString("message"), Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Binslocation.this, error.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    });

                    requestQueue.add(jsonObjectRequest);

                }

            }
        });



    }



}
