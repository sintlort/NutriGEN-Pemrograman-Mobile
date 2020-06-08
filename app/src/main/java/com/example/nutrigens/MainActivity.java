package com.example.nutrigens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttongizi, buttonimt, buttontee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttongizi = (Button) findViewById(R.id.buttongizi);
        buttongizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityGizi();
            }
        });
        buttonimt = (Button) findViewById(R.id.buttonimt);
        buttonimt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityIMT();
            }
        });
        buttontee = (Button) findViewById(R.id.buttontee);
        buttontee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityTEE();
            }
        });

    }

    private void openActivityTEE() {
        Intent intent1 = new Intent(this, tdee_activity.class);
        startActivity(intent1);
    }

    private void openActivityIMT() {
        Intent intent2 = new Intent(this, Activity3.class);
        startActivity(intent2);
    }

    private void openActivityGizi() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
