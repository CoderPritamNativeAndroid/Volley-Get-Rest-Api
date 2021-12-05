package com.pritampachal.volleyhttplibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    String startReceived,endReceived;
    ProgressDialog progressDialog;
    ArrayList<RecyclerViewModelClass> arrayList;

    @Override
    public void onBackPressed() {
        arrayList.clear();
        Intent intent=new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        arrayList.clear();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); //Keep always screen on
        recyclerView=findViewById(R.id.recyclerView);
        startReceived=getIntent().getStringExtra("num1");
        endReceived=getIntent().getStringExtra("num2");
        int a1,a2;
        a1=Integer.parseInt(startReceived);
        a2=Integer.parseInt(endReceived);
        progressDialog=new ProgressDialog(MainActivity2.this);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,"https://jsonplaceholder.typicode.com/photos",null,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    recyclerView.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity2.this);
                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    arrayList=new ArrayList<>();
                    for(int i=a1-1;i<=a2-1;i++) {
                        JSONObject jsonObject=response.getJSONObject(i);
                        RecyclerViewModelClass recyclerViewModelClass=new RecyclerViewModelClass(""+jsonObject.getInt("id"),""+jsonObject.getString("url"),""+jsonObject.getInt("albumId"),""+jsonObject.getString("title"));
                        arrayList.add(recyclerViewModelClass);
                    }
                    RecyclerViewAdapterClass recyclerViewAdapterClass=new RecyclerViewAdapterClass(arrayList);
                    recyclerView.setAdapter(recyclerViewAdapterClass);
                    progressDialog.dismiss();
                } catch (Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity2.this, ""+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity2.this, ""+error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(MainActivity2.this).add(jsonArrayRequest);
    }
}
