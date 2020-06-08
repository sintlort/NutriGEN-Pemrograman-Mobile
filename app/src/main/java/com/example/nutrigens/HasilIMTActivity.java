package com.example.nutrigens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HasilIMTActivity extends AppCompatActivity {
    TextView txtBB, txtTB, txtGender, txtIMT, txtHasil, txtKet;
    String gender, hasil, ket;
    double tb, bb, imt;
    double defaultValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imthasil);
        txtBB = (TextView)findViewById(R.id.text_view_hasil_bb);
        txtTB = (TextView)findViewById(R.id.text_view_hasil_tb);
        txtGender = (TextView)findViewById(R.id.text_view_hasil_gender);
        txtIMT = (TextView)findViewById(R.id.text_view_hasil_imt);
        txtHasil = (TextView)findViewById(R.id.text_view_hasil);
        txtKet = (TextView)findViewById(R.id.text_view_hasil_ket);

        //mengambil variable dari activity lain
        Intent intent = getIntent();
        //String Pesan
        gender = intent.getStringExtra("EXTRA_GENDER");
        bb = intent.getDoubleExtra("EXTRA_BB",defaultValue);
        tb = intent.getDoubleExtra("EXTRA_TB",defaultValue);
        imt = intent.getDoubleExtra("EXTRA_IMT",defaultValue);
        hasil = intent.getStringExtra("EXTRA_HASIL");
        ket = intent.getStringExtra("EXTRA_KET");

        txtBB.setText("Berat Badan : "+bb);
        txtTB.setText("Tinggi Badan : "+tb);
        txtGender.setText("Jenis Kelamin : "+gender);
        txtIMT.setText("Indeks Massa Tubuh : "+String.format("%.2f",imt));
        txtHasil.setText("Hasil : "+hasil);
        txtKet.setText("Keterangan : "+ket);
    }
}
