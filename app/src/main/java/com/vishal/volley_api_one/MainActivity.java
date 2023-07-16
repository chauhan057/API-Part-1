package com.vishal.volley_api_one;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         TextView tv=(TextView) findViewById(R.id.tv);

         String url ="https://jsonplaceholder.typicode.com/todos/1";

      JsonObjectRequest request =new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
          @Override
          public void onResponse(JSONObject response) {
              String title = null;
              int id,userId;
              boolean completed;

              try {
                   id =response.getInt("id");
                   userId =response.getInt("userId");
                  title = response.getString("title");
                  completed =response.getBoolean("completed");
              } catch (JSONException e) {
                  throw new RuntimeException(e);
              }
              tv.setText("id = "+id+"\n"+"Userid = "+userId+"\n"+"Title = "+title+"\n"+"Task = "+completed);
          }
      }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(request);

       /*

        // or

        RequestQueue queue =Volley.newRequestQueue(this);
        queue.add(request);

        */
    }
}