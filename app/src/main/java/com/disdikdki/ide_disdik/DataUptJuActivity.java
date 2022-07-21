package com.disdikdki.ide_disdik;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.Pejabat;
import com.disdikdki.ide_disdik.model.PejabatResponse;
import com.disdikdki.ide_disdik.model.Unit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataUptJuActivity extends AppCompatActivity {

    ImageView back;
    TextView jabatanStaf, namaStaf, nipStaf, pangkatStaf;

    ArrayList<Pejabat> pejabats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_upt_kasubbag);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        jabatanStaf = findViewById(R.id.tvJabatan);
        namaStaf = findViewById(R.id.tvNamaStaf);
        nipStaf = findViewById(R.id.tvNipStaf);
        pangkatStaf = findViewById(R.id.tvPangkatStaf);

        Unit unit = new Unit("202206", "UPT");

        Call<PejabatResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getDataSd(unit);

        call.enqueue(new Callback<PejabatResponse>() {
            @Override
            public void onResponse(Call<PejabatResponse> call, Response<PejabatResponse> response) {
                PejabatResponse pejabatResponse = response.body();
                Log.d("CHECK ISI DARI RESPONSE BODY", "ini dia --> " + response.body());
                if (pejabatResponse != null && pejabatResponse.getError() == null) {
                    Log.i("debug", "onResponse: SUCCESSFUL");
                    pejabats = pejabatResponse.getPejabatArrayList();
                    jabatanStaf.setText(pejabats.get(9).getJabatan());
                    namaStaf.setText(pejabats.get(9).getNama());
                    nipStaf.setText(pejabats.get(9).getNip());
                    pangkatStaf.setText(pejabats.get(9).getPangkat());
                }
            }

            @Override
            public void onFailure(Call<PejabatResponse> call, Throwable t) {

            }
        });
    }
}