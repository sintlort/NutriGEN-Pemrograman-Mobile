package com.example.nutrigens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {
    private Button buttonbayi, buttonbalita, buttonanak, buttonremaja, buttondewasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        
        buttonbalita = (Button) findViewById(R.id.buttonbalita);
        buttonbalita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityBalita();
            }
        });
        
        buttonanak = (Button) findViewById(R.id.buttonanak);
        buttonanak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAnak();
            }
        });
        
        buttonremaja = (Button) findViewById(R.id.buttonremaja);
        buttonremaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRemaja();
            }
        });
        
        buttondewasa = (Button) findViewById(R.id.buttondewasa);
        buttondewasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityDewasa();
            }
        });
    }

    private void openActivityDewasa() {
        Intent dewasa = new Intent(this,dewasa_activity.class);
        startActivity(dewasa);
    }

    private void openActivityRemaja() {
        Intent remaja = new Intent(this,remaja_activity.class);
        startActivity(remaja);
    }

    private void openActivityAnak() {
        Intent anak = new Intent(this, anak_activity.class);
        startActivity(anak);
    }

    private void openActivityBalita() {
        Intent balita = new Intent(this,balita_activity.class);
        startActivity(balita);
    }

    private void openActivityBayi() {
        Intent bayi = new Intent(this,bayi_activity.class);
        startActivity(bayi);
    }
}
