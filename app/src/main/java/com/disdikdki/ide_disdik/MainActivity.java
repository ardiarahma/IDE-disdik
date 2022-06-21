package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.disdikdki.ide_disdik.adapter.SliderAdapter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SliderView sliderView;
    int[] images = {R.drawable.slide_img1,
            R.drawable.slide_img2,
            R.drawable.slide_img3,
            R.drawable.slide_img4,
            R.drawable.slide_img5,
            R.drawable.slide_img7};

    WebView statSekolah;

    CardView btnDataSekolah, btnDataRekap, btnDataSKPD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statSekolah = findViewById(R.id.barChart);
        statSekolah.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=24&standalone=1&height=400");
        WebSettings webSettings = statSekolah.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);


        sliderView = findViewById(R.id.image_slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

        //==== MAIN MENU ====
        btnDataSekolah = findViewById(R.id.btn_dataSekolah);
        btnDataRekap = findViewById(R.id.btn_dataRekap);
        btnDataSKPD = findViewById(R.id.btn_dataSKPD);

        btnDataSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataSekolahActivity.class);
                startActivity(intent);
            }
        });

        btnDataRekap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataRekapActivity.class);
                startActivity(intent);
            }
        });

        btnDataSKPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataSkpdActivity.class);
                startActivity(intent);
            }
        });

    }
}