package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.disdikdki.ide_disdik.model.Periode;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DataDinasActivity extends AppCompatActivity {

    ImageView back;
    TextView namaKadis, nipKadis, pangkatKadis, namaWaka, nipWaka, pangkatWaka,
            namaSekdis, nipSekdis, pangkatSekdis,
            namaPtk, nipPtk, pangkatPtk,
            namaPp, nipPp, pangkatPp,
            namaPaud, nipPaud, pangkatPaud,
            namaSd, nipSd, pangkatSd,
            namaSmpsma, nipSmpsma, pangkatSmpsma,
            namaSmk, nipSmk, pangkatSmk,
            namaPrasardik, nipPrasardik, pangkatPrasardik;
    ImageView btnSekdis, btnPtk, btnPp, btnPaud, btnSd, btnSmpsma, btnSmk, btnPrasardik;

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

        //eselon II
        namaKadis = findViewById(R.id.nama_kadis);
        nipKadis = findViewById(R.id.nip_kadis);
        pangkatKadis = findViewById(R.id.pangkat_kadis);
        namaWaka = findViewById(R.id.nama_waka);
        nipWaka = findViewById(R.id.nip_waka);
        pangkatWaka = findViewById(R.id.pangkat_waka);

        //eselon III
        namaSekdis = findViewById(R.id.tv_sekdis);
        nipSekdis = findViewById(R.id.tv_nipSekdis);
        pangkatSekdis = findViewById(R.id.tv_pangkatSekdis);

        namaPtk = findViewById(R.id.tv_ptk);
        nipPtk = findViewById(R.id.tv_nipPtk);
        pangkatPtk = findViewById(R.id.tv_pangkatPtk);

        namaPp = findViewById(R.id.tv_pp);
        nipPp = findViewById(R.id.tv_nipPp);
        pangkatPp = findViewById(R.id.tv_pangkatPp);

        namaPaud = findViewById(R.id.tv_paud);
        nipPaud = findViewById(R.id.tv_nipPaud);
        pangkatPaud = findViewById(R.id.tv_pangkatPaud);

        namaSd = findViewById(R.id.tv_sd);
        nipSd = findViewById(R.id.tv_nipSd);
        pangkatSd = findViewById(R.id.tv_pangkatSd);

        namaSmpsma = findViewById(R.id.tv_smpsma);
        nipSmpsma = findViewById(R.id.tv_nipSmpsma);
        pangkatSmpsma = findViewById(R.id.tv_pangkatSmpsma);

        namaSmk = findViewById(R.id.tv_smk);
        nipSmk = findViewById(R.id.tv_nipSmk);
        pangkatSmk = findViewById(R.id.tv_pangkatSmk);

        namaPrasardik = findViewById(R.id.tv_prasardik);
        nipPrasardik = findViewById(R.id.tv_nipPrasardik);
        pangkatPrasardik = findViewById(R.id.tv_pangkatPrasardik);

        btnSekdis = findViewById(R.id.btn_sekdis);
        btnPtk = findViewById(R.id.btn_ptk);
        btnPp = findViewById(R.id.btn_pp);
        btnPaud = findViewById(R.id.btn_paud);
        btnSd = findViewById(R.id.btn_sd);
        btnSmpsma = findViewById(R.id.btn_smpsma);
        btnSmk = findViewById(R.id.btn_smk);
        btnPrasardik = findViewById(R.id.btn_prasardik);

        Periode periode = new Periode("202206");

        Call<PejabatResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getPejabat(periode);

        call.enqueue(new Callback<PejabatResponse>() {
            @Override
            public void onResponse(Call<PejabatResponse> call, Response<PejabatResponse> response) {
                PejabatResponse pejabatResponse = response.body();
                Log.d("CHECK ISI DARI RESPONSE BODY", "ini dia --> " + response.body());
                if (pejabatResponse != null && pejabatResponse.getError() == null){
                    Log.i("debug", "onResponse: SUCCESSFUL");
                    pejabats = pejabatResponse.getPejabatArrayList();
                    //kadis
                    namaKadis.setText(pejabats.get(0).getNama());
                    nipKadis.setText(pejabats.get(0).getNip());
                    pangkatKadis.setText(pejabats.get(0).getPangkat());
                    //wakadis
                    namaWaka.setText(pejabats.get(1).getNama());
                    nipWaka.setText(pejabats.get(1).getNip());
                    pangkatWaka.setText(pejabats.get(1).getPangkat());

                    //sekdis
                    namaSekdis.setText(pejabats.get(2).getNama());
                    nipSekdis.setText(pejabats.get(2).getNip());
                    pangkatSekdis.setText(pejabats.get(2).getPangkat());
                    btnSekdis.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DataDinasActivity.this, DataDinasSekdisActivity.class);
//                            intent.putExtra("id_sekdis", pejabats.get(2).getId());
                            startActivity(intent);
                        }
                    });

                    //ptk
                    namaPtk.setText(pejabats.get(3).getNama());
                    nipPtk.setText(pejabats.get(3).getNip());
                    pangkatPtk.setText(pejabats.get(3).getPangkat());
                    btnPtk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DataDinasActivity.this, DataDinasPtkActivity.class);
//                            intent.putExtra("id_sekdis", pejabats.get(2).getId());
                            startActivity(intent);
                        }
                    });
                    //pp
                    namaPp.setText(pejabats.get(8).getNama());
                    nipPp.setText(pejabats.get(8).getNip());
                    pangkatPp.setText(pejabats.get(8).getPangkat());
                    btnPp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DataDinasActivity.this, DataDinasPpActivity.class);
//                            intent.putExtra("id_sekdis", pejabats.get(2).getId());
                            startActivity(intent);
                        }
                    });
                    //paud
                    namaPaud.setText(pejabats.get(7).getNama());
                    nipPaud.setText(pejabats.get(7).getNip());
                    pangkatPaud.setText(pejabats.get(7).getPangkat());
                    btnPaud.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DataDinasActivity.this, DataDinasPaudActivity.class);
//                            intent.putExtra("id_sekdis", pejabats.get(2).getId());
                            startActivity(intent);
                        }
                    });
                    //sd
                    namaSd.setText(pejabats.get(4).getNama());
                    nipSd.setText(pejabats.get(4).getNip());
                    pangkatSd.setText(pejabats.get(4).getPangkat());
                    btnSd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DataDinasActivity.this, DataDinasSdActivity.class);
//                            intent.putExtra("id_sekdis", pejabats.get(2).getId());
                            startActivity(intent);
                        }
                    });
                    //smpsma
                    namaSmpsma.setText(pejabats.get(5).getNama());
                    nipSmpsma.setText(pejabats.get(5).getNip());
                    pangkatSmpsma.setText(pejabats.get(5).getPangkat());
                    btnSmpsma.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DataDinasActivity.this, DataDinasSmpsmaActivity.class);
//                            intent.putExtra("id_sekdis", pejabats.get(2).getId());
                            startActivity(intent);
                        }
                    });
                    //smk
                    namaSmk.setText(pejabats.get(6).getNama());
                    nipSmk.setText(pejabats.get(6).getNip());
                    pangkatSmk.setText(pejabats.get(6).getPangkat());
                    btnSmk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DataDinasActivity.this, DataDinasSmkActivity.class);
//                            intent.putExtra("id_sekdis", pejabats.get(2).getId());
                            startActivity(intent);
                        }
                    });
                    //prasardik
                    namaPrasardik.setText(pejabats.get(9).getNama());
                    nipPrasardik.setText(pejabats.get(9).getNip());
                    pangkatPrasardik.setText(pejabats.get(9).getPangkat());
                    btnPrasardik.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DataDinasActivity.this, DataDinasPrasardikActivity.class);
//                            intent.putExtra("id_sekdis", pejabats.get(2).getId());
                            startActivity(intent);
                        }
                    });

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