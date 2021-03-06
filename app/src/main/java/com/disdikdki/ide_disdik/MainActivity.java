package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.CookieSyncManager;
import android.webkit.CookieManager;

import com.disdikdki.ide_disdik.adapter.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

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

        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        cookieManager.setAcceptCookie(false);

        statSekolah.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });


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