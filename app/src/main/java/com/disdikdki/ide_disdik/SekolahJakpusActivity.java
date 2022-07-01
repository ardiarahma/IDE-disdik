package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SekolahJakpusActivity extends AppCompatActivity {

    ImageView back;
    WebView statSekolah;
    CardView btnPaud, btnPkbm, btnSd, btnSmp, btnSma, btnSmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekolah_jakpus);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        statSekolah = findViewById(R.id.chart);
        statSekolah.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=33&standalone=1&height=300");
        WebSettings webSettings = statSekolah.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);

        btnPaud = findViewById(R.id.btn_paud);
        btnPaud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahJakpusActivity.this, JpPaudActivity.class);
                startActivity(intent);
            }
        });

        btnPkbm = findViewById(R.id.btn_pkbm);
        btnPkbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahJakpusActivity.this, JpPkbmActivity.class);
                startActivity(intent);
            }
        });


    }
}