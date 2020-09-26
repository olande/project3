package com.example.waste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class Adminlogin extends AppCompatActivity {
EditText username,password;
Button login;
String pass,sname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        username=(EditText)findViewById(R.id.Username);
        password=(EditText)findViewById(R.id.Password);
        login=(Button)findViewById(R.id.submit);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Adminlogin.this, Adminjob.class);
                                startActivity(intent);
            }
        });
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                pass=password.getText().toString();
//                sname=username.getText().toString();
//
//                if (pass.isEmpty()){
//                    Toast.makeText(Adminlogin.this, "CHECK YOUR PASSWORD PLEASE", Toast.LENGTH_SHORT).show();
//                } else if (
//
//                        sname.isEmpty()
//                ) {
//                    Toast.makeText(Adminlogin.this, "CHECK YOUR USERNAME", Toast.LENGTH_SHORT).show();
//                }else{
//
//                    String url="http://www.olande.co.ke/Adminlogin.php?username="+username.getText().toString()+"&password="+password.getText().toString();
//                    RequestQueue requestQueue= Volley. newRequestQueue(Adminlogin.this);
//                    JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//                        @Override
//                        public void onResponse(JSONObject response) {
//                            try {
//                                String string = response.getString("status");
//                                if (string.equals("true")) {
//                                    Toast.makeText(Adminlogin.this, "login successfull", Toast.LENGTH_LONG).show();
//                                    Intent intent = new Intent(Adminlogin.this, Adminjob.class);
//                                    startActivity(intent);
//                                } else {
//                                    Toast.makeText(Adminlogin.this, "Wrong username or Password", Toast.LENGTH_SHORT).show();
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(Adminlogin.this,error.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    );
//
//                    requestQueue.add(request);
//                }
//
//
//
//            }
//        });

    }
}
