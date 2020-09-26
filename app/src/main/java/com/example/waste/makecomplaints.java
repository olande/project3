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

public class makecomplaints extends AppCompatActivity {

    EditText userid,binno,location,complaints;
    Button  submit;
    String userId,Binno,Location,Complaints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makecomplaints);
             userid=(EditText)findViewById(R.id. userId);
             binno=(EditText)findViewById(R.id.Binumber);
             location=(EditText)findViewById(R.id.location);
             submit=(Button)findViewById(R.id.submit);
             complaints=(EditText)findViewById(R.id.complains);

             submit.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Binno=binno.getText().toString();
                     Location=location.getText().toString();
                     Complaints=complaints.getText().toString();
                     userId=userid.getText().toString();

          if (userId.isEmpty()){
              Toast.makeText(makecomplaints.this, "fill up empty space", Toast.LENGTH_SHORT).show();
          }else if (Binno.isEmpty()){
              Toast.makeText(makecomplaints.this, "fill up space", Toast.LENGTH_SHORT).show();
          }else if (Complaints.isEmpty()){
              Toast.makeText(makecomplaints.this, "fill up empty space", Toast.LENGTH_SHORT).show();
          }
          else if (Location.isEmpty()){
              Toast.makeText(makecomplaints.this, "fill up space", Toast.LENGTH_SHORT).show();
          }else{
              Toast.makeText(makecomplaints.this, "sending data", Toast.LENGTH_LONG).show();
              RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
              String url="http://www.olande.co.ke/wasteusercomplaints.php?userid="+userid.getText().toString()+ "&binno="+binno.getText().toString()+"&location="+location.getText()+"&complaints="+complaints.getText().toString();
              JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                  @Override
                  public void onResponse(JSONObject response) {
                      Toast.makeText(makecomplaints.this, "response", Toast.LENGTH_LONG).show();
                      try {
                          if (response.getString("status").equals("true")){
                              Toast.makeText(makecomplaints.this, "register success", Toast.LENGTH_SHORT).show();
//                              Intent intent = new Intent(makecomplaints.this, UserLogins.class);
//                              startActivity(intent);
                          }else {

                              Toast.makeText(makecomplaints.this, response.getString("message"), Toast.LENGTH_LONG).show();
                          }
                      } catch (JSONException e) {
                          e.printStackTrace();
                      }
                  }
              }, new Response.ErrorListener() {
                  @Override
                  public void onErrorResponse(VolleyError error) {
                      Toast.makeText(makecomplaints.this, error.getMessage(), Toast.LENGTH_LONG).show();
                  }
              });

              requestQueue.add(jsonObjectRequest);


          }


     }
 });


    }
}
