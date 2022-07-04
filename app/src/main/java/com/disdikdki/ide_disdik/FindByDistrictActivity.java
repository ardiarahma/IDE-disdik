package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class FindByDistrictActivity extends AppCompatActivity {

    WebView sebaran_sekolah;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_by_district);

        sebaran_sekolah = findViewById(R.id.chart);
//        sebaran_sekolah.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=16&standalone=1&height=400");

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindByDistrictActivity.this, DataSekolahActivity.class);
                startActivity(intent);
            }
        });

    }
}