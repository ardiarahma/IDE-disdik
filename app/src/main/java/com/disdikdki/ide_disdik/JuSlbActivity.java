package com.disdikdki.ide_disdik;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.disdikdki.ide_disdik.adapter.SlbJpAdapter;
import com.disdikdki.ide_disdik.adapter.SlbJuAdapter;
import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.Sekolah;
import com.disdikdki.ide_disdik.model.SekolahBody;
import com.disdikdki.ide_disdik.model.SekolahResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JuSlbActivity extends AppCompatActivity {

    ImageView back;
    RecyclerView rvSlb;

    ArrayList<SekolahResponse> sekolahResponses;
    ArrayList<Sekolah> sekolahs;
    SlbJuAdapter slbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_slb);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        rvSlb = findViewById(R.id.rv_sekolahSlb);

        SekolahBody body = new SekolahBody("SLB", "Jakarta Utara", 1000, 0);

        Call<SekolahResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getSlbJu(body);

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
                    rvSlb.setLayoutManager(layoutManager);
                    rvSlb.setItemAnimator(new DefaultItemAnimator());
                    rvSlb.setHasFixedSize(true);
                    slbAdapter = new SlbJuAdapter(sekolahs, JuSlbActivity.this);
                    rvSlb.setAdapter(slbAdapter);
                    slbAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<SekolahResponse> call, Throwable t) {

            }
        });
    }
}