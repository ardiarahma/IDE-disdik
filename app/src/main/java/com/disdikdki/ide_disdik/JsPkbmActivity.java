package com.disdikdki.ide_disdik;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.disdikdki.ide_disdik.adapter.JenjangAdapter;
import com.disdikdki.ide_disdik.adapter.PkbmAdapter;
import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.Sekolah;
import com.disdikdki.ide_disdik.model.SekolahBody;
import com.disdikdki.ide_disdik.model.SekolahResponse;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsPkbmActivity extends AppCompatActivity {

    ImageView back;
    RecyclerView rvPkbm;
    TextInputEditText etNamaSekolah;

    ArrayList<SekolahResponse> sekolahResponses;
    ArrayList<Sekolah> sekolahs;
    JenjangAdapter pkbmAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_pkbm);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        rvPkbm = findViewById(R.id.rv_sekolahPkbm);
        etNamaSekolah = findViewById(R.id.et_namaSekolah);

        SekolahBody body = new SekolahBody("PKBM", "Jakarta Selatan", 1000, 0);

        Call<SekolahResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getPkbmJs(body);

        call.enqueue(new Callback<SekolahResponse>() {
            @Override
            public void onResponse(Call<SekolahResponse> call, Response<SekolahResponse> response) {
                SekolahResponse sekolahResponse = response.body();
                Log.d("CHECK ISI DARI RESPONSE BODY", "ini dia --> " + response.body());
                if (sekolahResponse != null && sekolahResponse.getError() == null) {
                    Log.i("debug", "onResponse: SUCCESSFUL");
                    sekolahs = sekolahResponse.getSekolahs();
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    rvPkbm.setLayoutManager(layoutManager);
                    rvPkbm.setItemAnimator(new DefaultItemAnimator());
                    rvPkbm.setHasFixedSize(true);
                    pkbmAdapter = new JenjangAdapter(sekolahs, JsPkbmActivity.this);
                    rvPkbm.setAdapter(pkbmAdapter);
                    pkbmAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<SekolahResponse> call, Throwable t) {

            }
        });
        etNamaSekolah.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    public void filter(String text) {
        ArrayList<Sekolah> filteredList = new ArrayList<>();
        for (Sekolah d : sekolahs) {
            if (d.getNama_sekolah().contains(text.toLowerCase())) {
                filteredList.add(d);
            } else if (d.getNama_sekolah().contains(text.toUpperCase())) {
                filteredList.add(d);
            }
        }
        pkbmAdapter.updateList(filteredList);
    }
}