package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.disdikdki.ide_disdik.adapter.SekolahAdapter;
import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.DataSekolah;
import com.disdikdki.ide_disdik.model.SekolahResponse;
import com.disdikdki.ide_disdik.model.Sekolah;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindByNameActivity extends AppCompatActivity {

    ImageView back, search;
    RecyclerView rvSekolah;
    ArrayList<SekolahResponse> sekolahResponses;
    ArrayList<Sekolah> sekolahs, sekolahArrayList;
    SekolahAdapter sekolahAdapter;
    Context context;
    TextInputEditText etNamaSekolah;
//    LinearLayout ll_no_data, sekolah_data;
//    ShimmerFrameLayout sfl_loading;
    NestedScrollView nsv_datasekolah;
//    View v_dummy;
    LottieAnimationView av_loading;
    int limit = 10000, offset = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_by_name);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        search = findViewById(R.id.btn_find);
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                findByName();
//
//            }
//        });

        context = this;

//        ll_no_data = findViewById(R.id.ll_no_data);
//        sfl_loading = findViewById(R.id.sfl_loading);
//        sekolah_data = findViewById(R.id.sekolah_master);
//        v_dummy = findViewById(R.id.v_dummy);
//        av_loading = findViewById(R.id.av_loading);

        nsv_datasekolah = findViewById(R.id.nsv_master);
        etNamaSekolah = findViewById(R.id.et_namaSekolah);
        rvSekolah = findViewById(R.id.rv_sekolah);

        etNamaSekolah.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                DataSekolah searchSekolah = new DataSekolah(etNamaSekolah.getText().length());

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

//        nsv_datasekolah.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (offset != 1) {
//                    if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
//                        if (sekolahs.size() > 0){
//                            sekolahArrayList = new ArrayList<>(sekolahs.size());
//                            sekolahArrayList.addAll(sekolahArrayList);
//                            sekolahAdapter = new SekolahAdapter(sekolahArrayList, context);
//                            rvSekolah.setAdapter(sekolahAdapter);
//                            offset += 10;
//                        }else {
//                            offset = -1;
//                        }
//                    }
//                }
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDataSekolah();
    }

    public void getDataSekolah() {
//        offset = 50;
        DataSekolah limit = new DataSekolah(500, 50);


        Call<SekolahResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getSchool(limit);

        call.enqueue(new Callback<SekolahResponse>() {
            @Override
            public void onResponse(Call<SekolahResponse> call, Response<SekolahResponse> response) {
                SekolahResponse sekolahResponse = response.body();
                Log.d("CHECK ISI DARI RESPONSE BODY", "ini dia --> " + response.body());
//                Toast.makeText(context, response.body().toString(), Toast.LENGTH_LONG).show();
                if (sekolahResponse != null && sekolahResponse.getError() == null) {
                    Log.i("debug", "onResponse: SUCCESSFUL");
                    sekolahs = sekolahResponse.getSekolahs();
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    rvSekolah.setLayoutManager(layoutManager);
                    rvSekolah.setItemAnimator(new DefaultItemAnimator());
                    rvSekolah.setHasFixedSize(true);
                    sekolahAdapter = new SekolahAdapter(sekolahs, FindByNameActivity.this);
                    rvSekolah.setAdapter(sekolahAdapter);
                    sekolahAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<SekolahResponse> call, Throwable t) {

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
        sekolahAdapter.updateList(filteredList);
    }


}