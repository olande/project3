package com.example.waste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driverlogin extends AppCompatActivity {
    EditText username,password;
    String sname,pass;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverlogin);

        username=(EditText)findViewById(R.id.Username);
        password=(EditText)findViewById(R.id.Password);
        Login=(Button)findViewById(R.id.submit);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validemail= "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)" +
                        "*@[A-Za-z0-9]+" +
                        "(\\.[ Za-z0-9]+)" +
                        "*(\\.[A-Za-z]" +
                        "{2,})$";
                String email= username.getText().toString();
                Matcher matcher= Pattern.compile(validemail).matcher(email);
                 if (matcher.matches()){


                     Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_SHORT);


                 }else if ( !matcher.matches()){
                     Toast.makeText(getApplicationContext(),"Enter valid email",Toast.LENGTH_SHORT);
                 }



                pass=password.getText().toString();
                if (pass.isEmpty()){

                    Toast.makeText(Driverlogin.this, "password is missing", Toast.LENGTH_SHORT).show();

                } else{

                    String url="http://www.olande.co.ke/driverlogin.php?username="+username.getText().toString()+"&password="+password.getText().toString();
                    RequestQueue requestQueue= Volley. newRequestQueue(Driverlogin.this);
                    JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String string = response.getString("status");
                                if (string.equals("true")) {
                                    Toast.makeText(Driverlogin.this, "login successfull", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Driverlogin.this, Googlemap.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(Driverlogin.this, "Wrong username or Password", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Driverlogin.this,error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    );
                    requestQueue.add(request);


                }

            }
        });
    }
}
