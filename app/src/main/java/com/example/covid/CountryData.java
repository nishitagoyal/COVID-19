package com.example.covid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CountryData extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    private static final String TAG = CountryData.class.getSimpleName();
    ArrayList<CovidCountry> covidCountries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_data);
        recyclerView = findViewById(R.id.rvCovidCountry);
        progressBar = findViewById(R.id.progress_circular_country);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        getDataFromServer();

    }
    private void showRecyclerView()
    {
        CovidCountryAdapter covidCountryAdapter = new CovidCountryAdapter(covidCountries);
        recyclerView.setAdapter(covidCountryAdapter);
    }

    private void getDataFromServer() {
        String url = "https://corona.lmao.ninja/countries";
        covidCountries = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.e(TAG, "onResponse: " + response);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);
                            covidCountries.add(new CovidCountry(data.getString("country"), data.getString("cases")));
                        }
                        showRecyclerView();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG,"Error Response"+error);
                    }
                });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }

}
