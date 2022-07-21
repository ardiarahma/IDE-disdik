package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.CutOff;
import com.disdikdki.ide_disdik.model.CutoffResponse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SekolahP1000Activity extends AppCompatActivity {

    ImageView back;
    WebView statSekolah;
    CardView btnPaud, btnPkbm, btnSd, btnSlb, btnSmp, btnSma, btnSmk;

    TextView tvMonth, tvYear;
    Calendar dateNow = Calendar.getInstance(TimeZone.getDefault());
    int month = dateNow.get(Calendar.MONTH) + 1;
    int year = dateNow.get(Calendar.YEAR);
    ArrayList<CutOff> cutOffs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekolah_p1000);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        statSekolah = findViewById(R.id.chart);
        statSekolah.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=39&standalone=1&height=300");
        WebSettings webSettings = statSekolah.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);

        tvMonth = findViewById(R.id.tvMonth);
        tvYear = findViewById(R.id.tvYear);

        Call<CutoffResponse> call = RetrofitClient
                .getInstance().getAPI()
                .getCutoff();

        call.enqueue(new Callback<CutoffResponse>() {
            @Override
            public void onResponse(Call<CutoffResponse> call, Response<CutoffResponse> response) {
                CutoffResponse cutoffResponse = response.body();
                Log.d("CHECK ISI DARI RESPONSE BODY", "ini dia --> " + response.body());
                if (cutoffResponse != null && cutoffResponse.getError() == null){
                    Log.i("debug", "onResponse: SUCCESSFUL");
                    cutOffs = cutoffResponse.getCutOffs();
                    if (cutOffs.get(0).getBulan() == 1){
                        tvMonth.setText("Januari");
                    }else if (cutOffs.get(0).getBulan() == 2){
                        tvMonth.setText("Februari");
                    }else if (cutOffs.get(0).getBulan() == 3){
                        tvMonth.setText("Maret");
                    }else if (cutOffs.get(0).getBulan() == 4){
                        tvMonth.setText("April");
                    }else if (cutOffs.get(0).getBulan() == 5){
                        tvMonth.setText("Mei");
                    }else if (cutOffs.get(0).getBulan() == 6){
                        tvMonth.setText("Juni");
                    }else if (cutOffs.get(0).getBulan() == 7){
                        tvMonth.setText("Juli");
                    }else if (cutOffs.get(0).getBulan() == 8){
                        tvMonth.setText("Agustus");
                    }else if (cutOffs.get(0).getBulan() == 9){
                        tvMonth.setText("September");
                    }else if (cutOffs.get(0).getBulan() == 10){
                        tvMonth.setText("Oktober");
                    }else if (cutOffs.get(0).getBulan() == 11){
                        tvMonth.setText("November");
                    }else if (cutOffs.get(0).getBulan() == 12){
                        tvMonth.setText("Desember");
                    }
                    tvYear.setText(String.valueOf(cutOffs.get(0).getTahun_anggaran()));
                }
            }

            @Override
            public void onFailure(Call<CutoffResponse> call, Throwable t) {

            }
        });

        btnPaud = findViewById(R.id.btn_paud);
        btnPaud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahP1000Activity.this, SeribuPaudActivity.class);
                startActivity(intent);
            }
        });

        btnPkbm = findViewById(R.id.btn_pkbm);
        btnPkbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahP1000Activity.this, SeribuPkbmActivity.class);
                startActivity(intent);
            }
        });

        btnSd = findViewById(R.id.btn_sd);
        btnSd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahP1000Activity.this, SeribuSdActivity.class);
                startActivity(intent);
            }
        });

        btnSlb = findViewById(R.id.btn_slb);
        btnSlb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahP1000Activity.this, SeribuSlbActivity.class);
                startActivity(intent);
            }
        });

        btnSmp = findViewById(R.id.btn_smp);
        btnSmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahP1000Activity.this, SeribuSmpActivity.class);
                startActivity(intent);
            }
        });

        btnSma = findViewById(R.id.btn_sma);
        btnSma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahP1000Activity.this, SeribuSmaActivity.class);
                startActivity(intent);
            }
        });

        btnSmk = findViewById(R.id.btn_smk);
        btnSmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SekolahP1000Activity.this, SeribuSmkActivity.class);
                startActivity(intent);
            }
        });

    }
}