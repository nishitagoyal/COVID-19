package com.example.covid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CovidCountryAdapter extends RecyclerView.Adapter <CovidCountryAdapter.ViewHolder>{

    ArrayList<CovidCountry> covidCountries;

    public CovidCountryAdapter(ArrayList<CovidCountry> covidCountries)
    {
        this.covidCountries = covidCountries;
    }

    @NonNull
    @Override
    public CovidCountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_covid_layout,viewGroup,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidCountryAdapter.ViewHolder viewHolder, int i) {

        CovidCountry covidCountry = covidCountries.get(i);
        viewHolder.tvTotalCases.setText(covidCountry.getmCases());
        viewHolder.tvCountryName.setText(covidCountry.getmCovidCountry());
    }

    @Override
    public int getItemCount() {
        return covidCountries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTotalCases, tvCountryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTotalCases = itemView.findViewById(R.id.tvTotalCases);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);
        }
    }
}
