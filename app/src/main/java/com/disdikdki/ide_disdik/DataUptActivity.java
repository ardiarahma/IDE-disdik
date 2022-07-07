package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.disdikdki.ide_disdik.R;
import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.Pejabat;
import com.disdikdki.ide_disdik.model.PejabatResponse;
import com.disdikdki.ide_disdik.model.Unit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataUptActivity extends AppCompatActivity {

    ImageView back;
    TextView jabatanStaf1, jabatanStaf2, jabatanStaf3, jabatanStaf4, jabatanStaf5, jabatanStaf6,
            jabatanStaf7, jabatanStaf8,
            namaStaf1, nipStaf1, pangkatStaf1,
            namaStaf2, nipStaf2, pangkatStaf2,
            namaStaf3, nipStaf3, pangkatStaf3,
            namaStaf4, nipStaf4, pangkatStaf4,
            namaStaf5, nipStaf5, pangkatStaf5,
            namaStaf6, nipStaf6, pangkatStaf6,
            namaStaf7, nipStaf7, pangkatStaf7,
            namaStaf8, nipStaf8, pangkatStaf8;
    LinearLayout btnJp, btnJu, btnJb, btnJs, btnJt, btnP4op, btnP3paud, btnPusda;

    ArrayList<Pejabat> pejabats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_upt);

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

        jabatanStaf4 = findViewById(R.id.tvJabatan4);
        namaStaf4 = findViewById(R.id.tvNamaStaf4);
        nipStaf4 = findViewById(R.id.tvNipStaf4);
        pangkatStaf4 = findViewById(R.id.tvPangkatStaf4);

        jabatanStaf5 = findViewById(R.id.tvJabatan5);
        namaStaf5 = findViewById(R.id.tvNamaStaf5);
        nipStaf5 = findViewById(R.id.tvNipStaf5);
        pangkatStaf5 = findViewById(R.id.tvPangkatStaf5);

        jabatanStaf6 = findViewById(R.id.tvJabatan6);
        namaStaf6 = findViewById(R.id.tvNamaStaf6);
        nipStaf6 = findViewById(R.id.tvNipStaf6);
        pangkatStaf6 = findViewById(R.id.tvPangkatStaf6);

        jabatanStaf7 = findViewById(R.id.tvJabatan7);
        namaStaf7 = findViewById(R.id.tvNamaStaf7);
        nipStaf7 = findViewById(R.id.tvNipStaf7);
        pangkatStaf7 = findViewById(R.id.tvPangkatStaf7);

        jabatanStaf8 = findViewById(R.id.tvJabatan8);
        namaStaf8 = findViewById(R.id.tvNamaStaf8);
        nipStaf8 = findViewById(R.id.tvNipStaf8);
        pangkatStaf8 = findViewById(R.id.tvPangkatStaf8);

        Unit unit = new Unit("202206", "UPT");

        Call<PejabatResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getDataUpt(unit);

        call.enqueue(new Callback<PejabatResponse>() {
            @Override
            public void onResponse(Call<PejabatResponse> call, Response<PejabatResponse> response) {
                PejabatResponse pejabatResponse = response.body();
                Log.d("CHECK ISI DARI RESPONSE BODY", "ini dia --> " + response.body());
                if (pejabatResponse != null && pejabatResponse.getError() == null) {
                    Log.i("debug", "onResponse: SUCCESSFUL");
                    pejabats = pejabatResponse.getPejabatArrayList();
                    //p4op
                    jabatanStaf1.setText(pejabats.get(0).getJabatan());
                    namaStaf1.setText(pejabats.get(0).getNama());
                    nipStaf1.setText(pejabats.get(0).getNip());
                    pangkatStaf1.setText(pejabats.get(0).getPangkat());
                    //p3paud
                    jabatanStaf2.setText(pejabats.get(1).getJabatan());
                    namaStaf2.setText(pejabats.get(1).getNama());
                    nipStaf2.setText(pejabats.get(1).getNip());
                    pangkatStaf2.setText(pejabats.get(1).getPangkat());
                    //pusda
                    jabatanStaf3.setText(pejabats.get(2).getJabatan());
                    namaStaf3.setText(pejabats.get(2).getNama());
                    nipStaf3.setText(pejabats.get(2).getNip());
                    pangkatStaf3.setText(pejabats.get(2).getPangkat());
                    //jp
                    jabatanStaf4.setText(pejabats.get(3).getJabatan());
                    namaStaf4.setText(pejabats.get(3).getNama());
                    nipStaf4.setText(pejabats.get(3).getNip());
                    pangkatStaf4.setText(pejabats.get(3).getPangkat());
                    //ju
                    jabatanStaf5.setText(pejabats.get(4).getJabatan());
                    namaStaf5.setText(pejabats.get(4).getNama());
                    nipStaf5.setText(pejabats.get(4).getNip());
                    pangkatStaf5.setText(pejabats.get(4).getPangkat());
                    //jb
                    jabatanStaf6.setText(pejabats.get(5).getJabatan());
                    namaStaf6.setText(pejabats.get(5).getNama());
                    nipStaf6.setText(pejabats.get(5).getNip());
                    pangkatStaf6.setText(pejabats.get(5).getPangkat());
                    //js
                    jabatanStaf7.setText(pejabats.get(6).getJabatan());
                    namaStaf7.setText(pejabats.get(6).getNama());
                    nipStaf7.setText(pejabats.get(6).getNip());
                    pangkatStaf7.setText(pejabats.get(6).getPangkat());
                    //jt
                    jabatanStaf8.setText(pejabats.get(7).getJabatan());
                    namaStaf8.setText(pejabats.get(7).getNama());
                    nipStaf8.setText(pejabats.get(7).getNip());
                    pangkatStaf8.setText(pejabats.get(7).getPangkat());
                }
            }

            @Override
            public void onFailure(Call<PejabatResponse> call, Throwable t) {

            }
        });
    }
}