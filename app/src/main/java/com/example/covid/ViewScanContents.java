package com.example.covid;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewScanContents extends AppCompatActivity {

    DataBaseHelper databaseHelper;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scan_contents);
        listView = findViewById(R.id.listView);
        databaseHelper = new DataBaseHelper(this);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = databaseHelper.getListContents();
        if(data.getCount()==0)
        {
            Toast.makeText(ViewScanContents.this,"Well Done! You are maintaining Social Distancing",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(data.moveToNext())
            {
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
