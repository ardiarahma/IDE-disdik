package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class SekolahJakbarActivity extends AppCompatActivity {
    ImageView back;
    WebView statSekolah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekolah_jakbar);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahJakbarActivity.this, DataSekolahActivity.class);
                startActivity(intent);
            }
        });

        statSekolah = findViewById(R.id.chart);
        statSekolah.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=36&standalone=1&height=300");
        WebSettings webSettings = statSekolah.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);

    }
}