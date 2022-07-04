package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DataSkpdActivity extends AppCompatActivity {

    ImageView back;
    CardView dinas, sudin, upt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_skpd);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSkpdActivity.this, DataSekolahActivity.class);
                startActivity(intent);
            }
        });

        dinas = findViewById(R.id.btn_dataDinas);
        dinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSkpdActivity.this, DataDinasActivity.class);
                startActivity(intent);
            }
        });

        sudin = findViewById(R.id.btn_dataSudin);
        sudin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSkpdActivity.this, DataSudinActivity.class);
                startActivity(intent);
            }
        });

        upt = findViewById(R.id.btn_dataUPT);
        upt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSkpdActivity.this, DataUptActivity.class);
                startActivity(intent);
            }
        });
    }
}