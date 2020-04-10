package com.example.covid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class StateData extends AppCompatActivity {

    ListView list;
    String [] state = {"Adilabad","Agra","Ahemdabad","Ahmadnagar","Aizwal",
            "Ajmer","Alappuzha","Alwar","Ambala","Amritsar","Anantapur","Andaman & Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam",
            "Bihar","Chattisgarh","Delhi","Goa","Gujarat",
            "Haryana","Himachal Pradesh","Jharkhand","Jammu and Kashmir","Karnatka","Kerala","Madhya Pradesh","Maharashtra",
            "Manipur", "Mizoram","Odisha","Punjab","Rajasthan","Tamil Nadu",
            "Telangana","Uttar Pradesh","Uttarakhand","West Bengal"};
    Integer[] imageId = {R.drawable.adilabad,R.drawable.agra,R.drawable.ahmadabad,R.drawable.ahmadnagar,R.drawable.aizawl,
            R.drawable.ajmer,R.drawable.alappuzha,R.drawable.alwar,R.drawable.ambala,R.drawable.amritsar,R.drawable.anantapur,R.drawable.andaman_islands,
            R.drawable.andhra_pradesh,R.drawable.arunachal_pradesh,R.drawable.assam,
            R.drawable.bihar,R.drawable.chhattisgarh,R.drawable.delhi,R.drawable.goa,R.drawable.gujarat,R.drawable.haryana,R.drawable.himachal_pradesh,R.drawable.jharkhand,
            R.drawable.jnk,R.drawable.karnataka,R.drawable.kerala,R.drawable.madhya_pradesh,R.drawable.maharashtra,
            R.drawable.manipur,R.drawable.mizoram,R.drawable.odisha,R.drawable.punjab,R.drawable.rajasthan,R.drawable.tamil_nadu,R.drawable.telangana,R.drawable.uttar_pradesh,R.drawable.uttarakhand,R.drawable.west_bengal};
            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_data);
        StateAdapter adapter = new StateAdapter(StateData.this,state,imageId);
        list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
    }
}
