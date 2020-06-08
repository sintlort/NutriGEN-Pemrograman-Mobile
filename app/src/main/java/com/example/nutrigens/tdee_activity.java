package com.example.nutrigens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class tdee_activity extends AppCompatActivity {

    public static final String EXTRA_USIA = "com.example.nutrigens.EXTRA_USIA";
    public static final String EXTRA_TINGGI = "com.example.nutrigens.EXTRA_TINGGI";
    public static final String EXTRA_BERAT = "com.example.nutrigens.EXTRA_BERAT";
    public static final String EXTRA_TDEE = "com.example.nutrigens.EXTRA_TDEE";

    int activitycase, aktif;
    double bmr, tdevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdee_activity);
        //Ada yang merah, tidak tahu kenapa tidak didetect.
        Button button = (Button)findViewById(R.id.calculate);

        Spinner tdeespinner = (Spinner) findViewById(R.id.spinner);
        Spinner aktifitas = (Spinner) findViewById(R.id.aktifitasspinner);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(tdee_activity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.gender));

        ArrayAdapter<String> aktifitasAdapter = new ArrayAdapter<String>(tdee_activity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.aktifitas));

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        aktifitasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tdeespinner.setAdapter(spinnerAdapter);

        aktifitas.setAdapter(aktifitasAdapter);

        tdeespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        activitycase=1;
                        break;
                    case 2:
                        activitycase=2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        aktifitas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        aktif =1;
                        break;
                    case 1:
                        aktif =2;
                        break;
                    case 2:
                        aktif =2;
                        break;
                    case 3:
                        aktif =2;
                        break;
                    case 4:
                        aktif =2;
                        break;
                    case 5:
                        aktif =2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculateTDEE();
            }
        });
    }

    private void openCalculateTDEE() {
        EditText usia = (EditText) findViewById(R.id.editText1);
        int valueusia = Integer.parseInt(usia.getText().toString());

        EditText tinggi = (EditText) findViewById(R.id.editText2);
        int valuetinggi = Integer.parseInt(tinggi.getText().toString());

        EditText berat = (EditText) findViewById(R.id.editText3);

        int valueberat = Integer.parseInt(berat.getText().toString());

        Intent tdee = new Intent(this,calculatetdee.class);

        tdee.putExtra(EXTRA_USIA,valueusia);

        tdee.putExtra(EXTRA_TINGGI,valuetinggi);

        tdee.putExtra(EXTRA_BERAT,valueberat);
        //Laki Laki
        if(activitycase==1){
            if(aktif<=2){
                bmr = (valuetinggi*6.25)+(valueberat*9.99)-(valueusia*4.92)+5;
                tdevalue = bmr;
                tdee.putExtra(EXTRA_TDEE,tdevalue);
                startActivity(tdee);
            }
            else if(aktif>=3){
                bmr = (valuetinggi*6.25)+(valueberat*9.99)-(valueusia*4.92)+5;
                tdevalue = bmr*1.55;
                tdee.putExtra(EXTRA_TDEE,tdevalue);
                startActivity(tdee);
            }
        }
        //Perempuan
        else if(activitycase==2){
            if(aktif<=2){
                bmr = (valuetinggi*6.25)+(valueberat*9.99)-(valueusia*4.92)-161;
                tdevalue = bmr;
                tdee.putExtra(EXTRA_TDEE,tdevalue);
                startActivity(tdee);
            }
            else if(aktif>=3){
                bmr = (valuetinggi*6.25)+(valueberat*9.99)-(valueusia*4.92)-161;
                tdevalue = bmr*1.55;
                tdee.putExtra(EXTRA_TDEE,tdevalue);
                startActivity(tdee);
            }
        }

    }
}
