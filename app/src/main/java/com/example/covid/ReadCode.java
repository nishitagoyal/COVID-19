package com.example.covid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ReadCode extends AppCompatActivity {

    DataBaseHelper databaseHelper;
    IntentResult result;
    String Name = "Nishita";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_code);
        databaseHelper = new DataBaseHelper(this);
        IntentIntegrator intentIntegrator = new IntentIntegrator(ReadCode.this);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        intentIntegrator.setCameraId(0);
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setPrompt("Scanning");
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setBarcodeImageEnabled(true);
        intentIntegrator.initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        Name = result.getContents();

        if(result!=null && result.getContents()!=null)
        {
            new AlertDialog.Builder(ReadCode.this)
                    .setTitle("Scanned Result")
                    .setMessage(result.getContents())
                    .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AddData(Name);
                            Intent intent = new Intent(ReadCode.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }).create().show();
        }
        super.onActivityResult(requestCode, resultCode, data);
        //Log.d("FIND","I am about to enter AddData");
    }

    public void AddData(String Name)
    {
        //Log.d("INSIDE","I am inside AddData");
        boolean insertData = databaseHelper.addData(Name);
        if(insertData == true)
        {
            Toast.makeText(ReadCode.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(ReadCode.this,"Something Went Wrong, Try Again! ",Toast.LENGTH_LONG).show();
        }

    }
}
