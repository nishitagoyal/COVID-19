package com.example.covid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

import java.util.jar.Attributes;

public class SplashScreen extends AppCompatActivity {

    private PinView pinView;
    private Button next;
    private TextView textU;
    String NameValue,PhoneValue;
    private EditText userName, userPhone;
    private ConstraintLayout first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        next = findViewById(R.id.button);
        userName = findViewById(R.id.username);
        userPhone = findViewById(R.id.userPhone);
        first = findViewById(R.id.firstStep);
        first.setVisibility(View.VISIBLE);
        NameValue = userName.getText().toString();
        PhoneValue = userPhone.getText().toString();

        if(userName.getText()==null && userPhone.getText()==null) {
            next.setEnabled(false);
            Toast.makeText(getApplicationContext(),"All fields required!!",Toast.LENGTH_LONG).show();
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                //Intent intent1 = new Intent(getApplicationContext(),GenerateCode.class);
                intent.putExtra("Name",userName.getText().toString());
                intent.putExtra("Phone",userPhone.getText().toString());
                //Toast.makeText(getApplicationContext(), userName.getText().toString() + " " + userPhone.getText().toString(),Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }
}
