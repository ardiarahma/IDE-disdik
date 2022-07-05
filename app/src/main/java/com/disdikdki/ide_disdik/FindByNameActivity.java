package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.disdikdki.ide_disdik.adapter.PaudJpAdapter;
import com.disdikdki.ide_disdik.adapter.SekolahAdapter;
import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.SekolahResponse;
import com.disdikdki.ide_disdik.model.DataSekolah;
import com.disdikdki.ide_disdik.model.Sekolah;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FindByNameActivity extends AppCompatActivity {

    ImageView back, search;
    RecyclerView rvSekolah;
    ArrayList<SekolahResponse> sekolahResponses;
    ArrayList<Sekolah> sekolahs;
    SekolahAdapter sekolahAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_by_name);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        search = findViewById(R.id.btn_find);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                findByName();

            }
        });

        rvSekolah = findViewById(R.id.rv_sekolah);

        Call<SekolahResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getSchool();

        call.enqueue(new Callback<SekolahResponse>() {
            @Override
            public void onResponse(Call<SekolahResponse> call, Response<SekolahResponse> response) {
                SekolahResponse sekolahResponse = response.body();
                Log.d("CHECK ISI DARI RESPONSE BODY", "ini dia --> " + response.body());
                if (sekolahResponse != null && sekolahResponse.getError() == null){
                    Log.i("debug", "onResponse: SUCCESSFUL");
                    sekolahs = sekolahResponse.getSekolahs();
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    rvSekolah.setLayoutManager(layoutManager);
                    rvSekolah.setItemAnimator(new DefaultItemAnimator());
                    rvSekolah.setHasFixedSize(true);
                    sekolahAdapter = new SekolahAdapter(sekolahs, FindByNameActivity.this);
                    rvSekolah.setAdapter(sekolahAdapter);
                    sekolahAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<SekolahResponse> call, Throwable t) {

            }
        });
    }
}