package com.example.covid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;

public class Dashboard extends AppCompatActivity {


    TextView TVTotalDeaths,TVTotalConfirmed,TVTotalRecovered;
    ProgressBar progressBar;
    Button countryButton,stateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        TVTotalConfirmed = findViewById(R.id.TotalConfirmed);
        TVTotalDeaths = findViewById(R.id.TotalDeaths);
        TVTotalRecovered = findViewById(R.id.TotalRecovered);
        progressBar= findViewById(R.id.progress_circular_dashboard);
        countryButton = findViewById(R.id.countrywise);
        stateButton = findViewById(R.id.statewise);
        countryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CountryData.class);
                startActivity(intent);
            }
        });
        stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),StateData.class);
                startActivity(intent);

            }
        });
        getData();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        // mTextMessage.setText(R.string.title_home);
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_dashboard:
                        // mTextMessage.setText(R.string.title_dashboard);
                        return true;
                    case R.id.navigation_about:
                        // mTextMessage.setText(R.string.title_notifications);
                        startActivity(new Intent(getApplicationContext(),About.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://corona.lmao.ninja/all";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    TVTotalConfirmed.setText(jsonObject.getString("cases"));
                    TVTotalDeaths.setText(jsonObject.getString("deaths"));
                    TVTotalRecovered.setText(jsonObject.getString("recovered"));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressBar.setVisibility(View.GONE);
                Log.e("Error Response",error.toString());
            }
        });

        queue.add(stringRequest);

    }
}
