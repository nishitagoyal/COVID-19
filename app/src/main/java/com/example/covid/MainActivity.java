package com.example.covid;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button generateButton, readButton , viewButton;
    String PhoneValue,NameValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
//                .getBoolean("isFirstRun", true);
//
//        if (isFirstRun){
//            startActivity(new Intent(MainActivity.this, SplashScreen.class));
//            //Toast.makeText(MainActivity.this, "Run only once", Toast.LENGTH_LONG).show();
//        }
//        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
//                .putBoolean("isFirstRun", false).commit();

        Intent intent = getIntent();
        PhoneValue = intent.getStringExtra("Phone");
        NameValue = intent.getStringExtra("Name");


        //Toast.makeText(getApplicationContext(),NameValue + " " + PhoneValue, Toast.LENGTH_SHORT).show();

        generateButton = findViewById(R.id.generatecode);
        readButton = findViewById(R.id.readcode);
        viewButton = findViewById(R.id.viewlist);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGenerateCode();
            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenReadCode();
            }
        });
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewScanContents.class);
                startActivity(intent); }
        });
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        return true;
                    case R.id.navigation_dashboard:
                        // mTextMessage.setText(R.string.title_dashboard);
                        // mTextMessage.setText(R.string.title_home);
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        overridePendingTransition(0,0);
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
    public void OpenGenerateCode()
    {
        Intent GCintent = new Intent(this,GenerateCode.class);
        GCintent.putExtra("Name",NameValue);
        GCintent.putExtra("Phone",PhoneValue);
        startActivity(GCintent);
    }
    public void OpenReadCode()
    {
        Intent RCintent = new Intent(this,ReadCode.class);
        startActivity(RCintent);
    }

}
