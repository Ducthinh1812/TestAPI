package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView textView,textView1;
    ImageView imageView;
    ArrayList<DetailCat> arrayList;
    String  a= "https://api.thecatapi.com/v1/images/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView2);
        textView1=findViewById(R.id.textView4);
        imageView=findViewById(R.id.textView3);
        Intent intent=getIntent();
        String value1 = intent.getStringExtra("id");
        arrayList=new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET, a + value1, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("aaaa3",response.toString());
                        JSONObject jsonobject = response;
                        try {
                            arrayList.add(new DetailCat(
                                    jsonobject.getString("id"),
                                    jsonobject.getString("url"),
                                    jsonobject.getInt("width"),
                                    jsonobject.getInt("height")
                            ));
                            Log.e("aaaa3",arrayList.get(0).getWidth()+"");
                            textView.setText(arrayList.get(0).getId());
                            textView1.setText("Width: "+arrayList.get(0).getWidth()+"    Height"+arrayList.get(0).getHeight());
                            Picasso.get().load(arrayList.get(0).getUrl())
                                    .into(imageView);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
                requestQueue.add(jsonArrayRequest);
    }
}