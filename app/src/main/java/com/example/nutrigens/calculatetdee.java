package com.example.nutrigens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class calculatetdee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatetdee);

        Intent calculatetdee = getIntent();
        int usia = calculatetdee.getIntExtra(tdee_activity.EXTRA_USIA,0);
        int tinggi = calculatetdee.getIntExtra(tdee_activity.EXTRA_TINGGI,0);
        int berat = calculatetdee.getIntExtra(tdee_activity.EXTRA_BERAT,0);
        double tdeevalue = calculatetdee.getDoubleExtra(tdee_activity.EXTRA_TDEE,0);
        String formatted_value = String.format("%.2f",tdeevalue);
        TextView viewusia = (TextView) findViewById(R.id.viewUsia);
        TextView viewtinggi = (TextView) findViewById(R.id.viewTinggi);
        TextView viewberat = (TextView) findViewById(R.id.viewBerat);
        TextView viewcase = (TextView) findViewById(R.id.viewCase);

        viewusia.setText("Usia : "+usia);
        viewtinggi.setText("Tinggi : "+tinggi);
        viewberat.setText("Berat : "+berat);
        viewcase.setText("Perkiraan TDEE atau kebutuhan energi pemeliharaan anda adalah "+formatted_value+" Kalori per hari.");

    }
}
