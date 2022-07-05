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

import com.disdikdki.ide_disdik.adapter.SdAdapter;
import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.SekolahResponse;
import com.disdikdki.ide_disdik.model.Sekolah;
import com.disdikdki.ide_disdik.model.SekolahBody;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JpSdActivity extends AppCompatActivity {

    ImageView back;
    RecyclerView rvSdJp;

    ArrayList<SekolahResponse> sekolahResponses;
    ArrayList<Sekolah> sekolahs;
    SdAdapter sdAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jp_sd);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        rvSdJp = findViewById(R.id.rv_sekolahSd);

        SekolahBody body = new SekolahBody("SD", "Jakarta Pusat", 1000, 0);

        Call<SekolahResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getSdJp(body);

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
                    rvSdJp.setLayoutManager(layoutManager);
                    rvSdJp.setItemAnimator(new DefaultItemAnimator());
                    rvSdJp.setHasFixedSize(true);
                    sdAdapter = new SdAdapter(sekolahs, JpSdActivity.this);
                    rvSdJp.setAdapter(sdAdapter);
                    sdAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<SekolahResponse> call, Throwable t) {

            }
        });
    }
}