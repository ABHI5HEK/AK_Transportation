package com.example.aktransportation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        listView = findViewById(R.id.mycontacts);
        contactList = new ArrayList<>();
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        try {
            final URL url = new URL("https://jsonplaceholder.typicode.com/todos");
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                    url.toString(),
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                for (int i=0;i<response.length();i++){
                                    JSONObject obj= response.getJSONObject(i);
                                    contactList.add(obj.getString("title"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("serum","Something Went wrong");

                        }
                    });

            requestQueue.add(jsonArrayRequest);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }






        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contactList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = "text" + i+ " " + ((TextView) view).getText().toString();
                Toast.makeText(ContactsActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });

    }


}