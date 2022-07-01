package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.disdikdki.ide_disdik.R;
import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.Pejabat;
import com.disdikdki.ide_disdik.model.PejabatResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DataDinasActivity extends AppCompatActivity {

    ImageView back;
    TextView namaKadis, nipKadis, pangkatKadis, namaWaka, nipWaka, pangkatWaka;

    ArrayList<Pejabat> pejabats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_dinas);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        namaKadis = findViewById(R.id.nama_kadis);
        nipKadis = findViewById(R.id.nip_kadis);
        pangkatKadis = findViewById(R.id.pangkat_kadis);
        namaWaka = findViewById(R.id.nama_waka);
        nipWaka = findViewById(R.id.nip_waka);
        pangkatWaka = findViewById(R.id.pangkat_waka);

        String periode_id = "202206";

        Call<PejabatResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getPejabat(periode_id);

        call.enqueue(new Callback<PejabatResponse>() {
            @Override
            public void onResponse(Call<PejabatResponse> call, Response<PejabatResponse> response) {
                PejabatResponse pejabatResponse = response.body();
                Log.d("CHECK ISI DARI RESPONSE BODY", "ini dia --> " + response.body());
                if (pejabatResponse.getError().equals(null)){
                    Log.i("debug", "onResponse: SUCCESSFUL");
                    pejabats = pejabatResponse.getPejabatArrayList();
                    //kadis
                    namaKadis.setText(pejabats.get(0).getNama());
                    nipKadis.setText(pejabats.get(0).getNip());
                    pangkatKadis.setText(pejabats.get(0).getPangkat());
                    //wakadis
                    namaWaka.setText(pejabats.get(1).getNama());
                    nipWaka.setText(pejabats.get(1).getNip());
                    nipWaka.setText(pejabats.get(1).getPangkat());
                }else {
                    Log.i("debug", "onResponse: FAILED");
                    Toast.makeText(getApplicationContext(), "Gagal dalam mengambil data", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PejabatResponse> call, Throwable t) {
                Log.d("Pejabat", t.getMessage());
            }
        });
    }
}