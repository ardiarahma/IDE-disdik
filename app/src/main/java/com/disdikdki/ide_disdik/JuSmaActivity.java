package com.disdikdki.ide_disdik;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.disdikdki.ide_disdik.adapter.SmaAdapter;
import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.Sekolah;
import com.disdikdki.ide_disdik.model.SekolahBody;
import com.disdikdki.ide_disdik.model.SekolahResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JuSmaActivity extends AppCompatActivity {

    ImageView back;
    RecyclerView rvSma;

    ArrayList<SekolahResponse> sekolahResponses;
    ArrayList<Sekolah> sekolahs;
    SmaAdapter smaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_sma);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        rvSma = findViewById(R.id.rv_sekolahSma);

        SekolahBody body = new SekolahBody("SMA", "Jakarta Utara", 1000, 0);

        Call<SekolahResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getSmaJu(body);

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
                    rvSma.setLayoutManager(layoutManager);
                    rvSma.setItemAnimator(new DefaultItemAnimator());
                    rvSma.setHasFixedSize(true);
                    smaAdapter = new SmaAdapter(sekolahs, JuSmaActivity.this);
                    rvSma.setAdapter(smaAdapter);
                    smaAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<SekolahResponse> call, Throwable t) {

            }
        });
    }
}