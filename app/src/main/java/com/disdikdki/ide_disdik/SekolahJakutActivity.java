package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class SekolahJakutActivity extends AppCompatActivity {

    ImageView back;
    WebView statSekolah;
    CardView btnPaud, btnPkbm, btnSd, btnSlb, btnSmp, btnSma, btnSmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekolah_jakut);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        statSekolah = findViewById(R.id.chart);
        statSekolah.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=38&standalone=1&height=300");
        WebSettings webSettings = statSekolah.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);

        btnPaud = findViewById(R.id.btn_paud);
        btnPaud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahJakutActivity.this, JuPaudActivity.class);
                startActivity(intent);
            }
        });

        btnPkbm = findViewById(R.id.btn_pkbm);
        btnPkbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahJakutActivity.this, JuPkbmActivity.class);
                startActivity(intent);
            }
        });

        btnSd = findViewById(R.id.btn_sd);
        btnSd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahJakutActivity.this, JuSdActivity.class);
                startActivity(intent);
            }
        });

        btnSlb = findViewById(R.id.btn_slb);
        btnSlb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahJakutActivity.this, JuSlbActivity.class);
                startActivity(intent);
            }
        });

        btnSmp = findViewById(R.id.btn_smp);
        btnSmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahJakutActivity.this, JuSmpActivity.class);
                startActivity(intent);
            }
        });

        btnSma = findViewById(R.id.btn_sma);
        btnSma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahJakutActivity.this, JuSmaActivity.class);
                startActivity(intent);
            }
        });

        btnSmk = findViewById(R.id.btn_smk);
        btnSmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahJakutActivity.this, JuSmkActivity.class);
                startActivity(intent);
            }
        });

    }
}