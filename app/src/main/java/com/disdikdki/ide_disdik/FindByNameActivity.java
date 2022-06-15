package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FindByNameActivity extends AppCompatActivity {

    ImageView back, search;
    RecyclerView rv_sekolah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_by_name);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindByNameActivity.this, DataSekolahActivity.class);
                startActivity(intent);
            }
        });

        search = findViewById(R.id.btn_find);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findByName();
            }
        });

//        rv_sekolah = findViewById(R.id.rv_sekolah);
        
    }

    public void findByName(){
        //..
    }
}