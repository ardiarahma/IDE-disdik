package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.Pejabat;
import com.disdikdki.ide_disdik.model.PejabatResponse;
import com.disdikdki.ide_disdik.model.Unit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataDinasSmpsmaActivity extends AppCompatActivity {

    ImageView back;
    TextView jabatanStaf1, jabatanStaf2, jabatanStaf3,
            namaStaf1, nipStaf1, pangkatStaf1,
            namaStaf2, nipStaf2, pangkatStaf2,
            namaStaf3, nipStaf3, pangkatStaf3;

    ArrayList<Pejabat> pejabats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_dinas_smpsma);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        jabatanStaf1 = findViewById(R.id.tvJabatan);
        namaStaf1 = findViewById(R.id.tvNamaStaf);
        nipStaf1 = findViewById(R.id.tvNipStaf);
        pangkatStaf1 = findViewById(R.id.tvPangkatStaf);

        jabatanStaf2 = findViewById(R.id.tvJabatan2);
        namaStaf2 = findViewById(R.id.tvNamaStaf2);
        nipStaf2 = findViewById(R.id.tvNipStaf2);
        pangkatStaf2 = findViewById(R.id.tvPangkatStaf2);

        jabatanStaf3 = findViewById(R.id.tvJabatan3);
        namaStaf3 = findViewById(R.id.tvNamaStaf3);
        nipStaf3 = findViewById(R.id.tvNipStaf3);
        pangkatStaf3 = findViewById(R.id.tvPangkatStaf3);

        Unit unit = new Unit("202206", "DINAS PENDIDIKAN");

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
                    //kurikulum
//                    jabatanStaf1.setText(pejabats.get(17).getJabatan());
//                    namaStaf1.setText(pejabats.get(17).getNama());
//                    nipStaf1.setText(pejabats.get(17).getNip());
//                    pangkatStaf1.setText(pejabats.get(17).getPangkat());
                    //pdpk
                    jabatanStaf2.setText(pejabats.get(15).getJabatan());
                    namaStaf2.setText(pejabats.get(15).getNama());
                    nipStaf2.setText(pejabats.get(15).getNip());
                    pangkatStaf2.setText(pejabats.get(15).getPangkat());
                    //kelembagaan
                    jabatanStaf3.setText(pejabats.get(16).getJabatan());
                    namaStaf3.setText(pejabats.get(16).getNama());
                    nipStaf3.setText(pejabats.get(16).getNip());
                    pangkatStaf3.setText(pejabats.get(16).getPangkat());
                }
            }

            @Override
            public void onFailure(Call<PejabatResponse> call, Throwable t) {

            }
        });
    }
}