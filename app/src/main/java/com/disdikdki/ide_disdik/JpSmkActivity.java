package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.disdikdki.ide_disdik.adapter.SmkAdapter;
import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.Sekolah;
import com.disdikdki.ide_disdik.model.SekolahBody;
import com.disdikdki.ide_disdik.model.SekolahResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JpSmkActivity extends AppCompatActivity {

    ImageView back;
    RecyclerView rvSmkJp;

    ArrayList<SekolahResponse> sekolahResponses;
    ArrayList<Sekolah> sekolahs;
    SmkAdapter smkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jp_smk);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        rvSmkJp = findViewById(R.id.rv_sekolahSmk);

        SekolahBody body = new SekolahBody("SMK", "Jakarta Pusat", 1000, 0);

        Call<SekolahResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getSmkJp(body);

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
                    rvSmkJp.setLayoutManager(layoutManager);
                    rvSmkJp.setItemAnimator(new DefaultItemAnimator());
                    rvSmkJp.setHasFixedSize(true);
                    smkAdapter = new SmkAdapter(sekolahs, JpSmkActivity.this);
                    rvSmkJp.setAdapter(smkAdapter);
                    smkAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<SekolahResponse> call, Throwable t) {

            }
        });
    }
}