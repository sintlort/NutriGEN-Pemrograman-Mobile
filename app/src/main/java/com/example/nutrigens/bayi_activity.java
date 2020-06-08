package com.example.nutrigens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class bayi_activity extends AppCompatActivity {
    RecyclerView recyclerView;

    String string1[], string2[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayi_activity);

        recyclerView = findViewById(R.id.recyclerView);

        string1 = getResources().getStringArray(R.array.listgizi);
        string2 = getResources().getStringArray(R.array.detailgizi);

        MyAdapter myAdapter = new MyAdapter(this, string1, string2);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
