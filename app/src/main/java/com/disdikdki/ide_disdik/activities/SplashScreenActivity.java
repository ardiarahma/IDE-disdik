package com.disdikdki.ide_disdik.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.disdikdki.ide_disdik.R;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView bg, app_logo, app_name;
    LottieAnimationView ss_process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        bg = findViewById(R.id.img_bg);
        app_logo = findViewById(R.id.ic_logo);
//        app_name = findViewById(R.id.app_name);
//        ss_process = findViewById(R.id.ss_anim);

        new Handler().postDelayed((Runnable) () -> {
            Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(i);
        }, 5000);
//        bg.animate().translationY(-2000).setDuration(1000).setStartDelay(4000);
//        app_logo.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
//        app_name.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
//        ss_process.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        
    }
}