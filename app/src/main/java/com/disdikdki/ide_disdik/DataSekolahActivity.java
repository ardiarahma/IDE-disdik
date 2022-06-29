package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class DataSekolahActivity extends AppCompatActivity {

    ImageView back;
    View jakpus, jakut, jakbar, jaksel, jaktim, p1000;
    RelativeLayout searchByName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_sekolah);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSekolahActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        searchByName = findViewById(R.id.btn_searchBySchoolName);
        searchByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSekolahActivity.this, FindByNameActivity.class);
                startActivity(intent);
            }
        });

        jakpus = findViewById(R.id.btn_jakpus);
        jakpus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSekolahActivity.this, SekolahJakpusActivity.class);
                startActivity(intent);
            }
        });

        jakut = findViewById(R.id.btn_jakut);
        jakut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSekolahActivity.this, SekolahJakutActivity.class);
                startActivity(intent);
            }
        });

        jakbar = findViewById(R.id.btn_jakbar);
        jakbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSekolahActivity.this, SekolahJakbarActivity.class);
                startActivity(intent);
            }
        });

        jaksel = findViewById(R.id.btn_jaksel);
        jaksel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSekolahActivity.this, SekolahJakselActivity.class);
                startActivity(intent);
            }
        });

        jaktim = findViewById(R.id.btn_jaktim);
        jaktim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSekolahActivity.this, SekolahJaktimActivity.class);
                startActivity(intent);
            }
        });

        p1000 = findViewById(R.id.btn_seribu);
        p1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSekolahActivity.this, SekolahP1000Activity.class);
                startActivity(intent);
            }
        });


    }
}