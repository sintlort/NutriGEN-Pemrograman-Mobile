package com.example.nutrigens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.RandomAccess;

public class Activity3 extends AppCompatActivity {
    EditText isiBB, isiTB;
    String gender;
    String hasil;
    String ket;
    RadioButton radioButtonL;
    RadioButton radioButtonP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        getSupportActionBar().setTitle("Kalkulator IMT");
        //fetch data dari form input
        isiBB = (EditText)findViewById(R.id.edit_text_bb);
        isiTB = (EditText)findViewById(R.id.edit_text_tb);
        radioButtonL = (RadioButton)findViewById(R.id.radio_btn_lk);
        radioButtonP = (RadioButton)findViewById(R.id.radio_btn_p);
    }

    public void tampilHasil(View view){
        //mengambil input TB dan BB dalam bentuk String
        String sBerat = isiBB.getText().toString().trim();
        String sTinggi = isiTB.getText().toString().trim();

        //cek form terisi semua atau tidak
        if(isiBB.getText().toString().equals("")||isiTB.getText().toString().equals("")||(!radioButtonP.isChecked()&&!radioButtonL.isChecked())){
            Toast.makeText(getApplicationContext(),"Silahkan Isi Seluruh Data",Toast.LENGTH_SHORT).show();
        }
        else{
            //mengubah nilai string TB dan BB menjadi double
            double Berat = Double.parseDouble(sBerat);
            double Tinggi = Double.parseDouble(sTinggi);

            //rumus IMT = BB/TB**2
            double imt = Berat/(Tinggi*Tinggi*0.0001);
            Log.d("tag","Berat Badan ="+Berat+"\nTinggi Badan = "+Tinggi+"\nIMT = "+imt+"\nJenis Kelamin = "+gender);
            //hasil IMT
            if(gender.equals("Perempuan")){
                if(imt<17){
                    hasil = "Under Weight / Kurus";
                    ket = "Tidak Bagus, sebaiknya perbanyak mengkonsumsi makanan bergizi dan melakukan olahraga rutin serta hindari melakukan begadang";
                }else if(imt>=17||imt<23){
                    hasil = "Normal Weight / Normal";
                    ket = "Bagus, tetap pertahankan dan ingat untuk selalu hidup sehat serta mengkonsumsi makanan bergizi";
                }else if(imt>=23||imt<=27){
                    hasil = "Over Weight / Kegemukan";
                    ket = "Tidak Bagus, massa tubuh anda lebih dari ideal sebaikanya melakukan diet yang sehat dengan mengurangi asupan kalori, rutin berolahraga serta menerapkan pola hidup sehat dan disarankan untuk konsultasi dengan dokter ahli gizi";
                }else if(imt>27){
                    hasil = "Obesitas";
                    ket = "Sangat Tidak Baik, tubuh anda sudah masuk ke dalam golongan obesitas dan sebaiknya berkonsultasi dengan dokter ahli gizi untuk tindakan lebih lanjut";
                }
            }else if(gender.equals("Laki-Laki")){
                if(imt<18){
                    hasil = "Under Weight / Kurus";
                    ket = "Tidak Bagus, sebaiknya perbanyak mengkonsumsi makanan bergizi dan melakukan olahraga rutin serta hindari melakukan begadang";
                }else if(imt>=18||imt<25){
                    hasil = "Normal Weight  / Normal";
                    ket = "Bagus, tetap pertahankan dan ingat untuk selalu hidup sehat serta mengkonsumsi makanan bergizi";
                }else if(imt>=25||imt<=27){
                    hasil = "Over Weight / Kegemukan";
                    ket = "Tidak Bagus, massa tubuh anda lebih dari ideal sebaikanya melakukan diet yang sehat dengan mengurangi asupan kalori, rutin berolahraga serta menerapkan pola hidup sehat dan disarankan untuk konsultasi dengan dokter ahli gizi";
                }else if(imt>27){
                    hasil = "Obesitas";
                    ket = "Sangat Tidak Baik, tubuh anda sudah masuk ke dalam golongan obesitas dan sebaiknya berkonsultasi dengan dokter ahli gizi untuk tindakan lebih lanjut";
                }
            }

            Intent intent5 = new Intent(Activity3.this,HasilIMTActivity.class);
            intent5.putExtra("EXTRA_BB", Berat);
            intent5.putExtra("EXTRA_TB", Tinggi);
            intent5.putExtra("EXTRA_GENDER", gender);
            intent5.putExtra("EXTRA_IMT", imt);
            intent5.putExtra("EXTRA_HASIL", hasil);
            intent5.putExtra("EXTRA_KET", ket);
            startActivity(intent5);
            Log.d("Gender",gender);
        }
    }

    public void onRadioButtonClicked(View view) {
        //cek button gender
        boolean check = ((RadioButton) view).isChecked();

        //cek value button
        switch (view.getId()){
            case R.id.radio_btn_lk:
                if (check)
                    gender = radioButtonL.getText().toString().trim();
                    break;
            case R.id.radio_btn_p:
                if (check)
                    gender = radioButtonP.getText().toString().trim();
                    break;
        }
    }
}
