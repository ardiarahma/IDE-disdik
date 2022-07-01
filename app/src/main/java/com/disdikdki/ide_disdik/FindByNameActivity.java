package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.disdikdki.ide_disdik.model.SekolahResponse;
import com.disdikdki.ide_disdik.model.DataSekolah;
import com.disdikdki.ide_disdik.model.Sekolah;

import java.util.ArrayList;

public class FindByNameActivity extends AppCompatActivity {

    ImageView back, search;
    RecyclerView rv_sekolah;
    ArrayList<DataSekolah> dataSekolahArrayList;
    ArrayList<Sekolah> sekolahArrayList;
//    SekolahAdapter sekolahAdapter;
    SekolahResponse sekolahResponse;
    Context context;

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

        search = findViewById(R.id.btn_find);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findByName();
            }
        });

        rv_sekolah = findViewById(R.id.rv_sekolah);

//        String form_data = "{\"datasource\":{\"id\":9,\"type\":\"table\"},\"force\":false,\"queries\":[{\"time_range\":\"No+filter\",\"granularity\":null,\"filters\":[],\"extras\":{\"time_grain_sqla\":\"P1D\",\"time_range_endpoints\":[\"inclusive\",\"exclusive\"],\"having\":\"\",\"having_druid\":[],\"where\":\"\"},\"applied_time_extras\":{},\"columns\":[\"nama_satuan_pendidikan\",\"npsn\",\"jenjang\",\"status_sekolah\",\"alamat\",\"KELURAHAN\",\"KECAMATAN\",\"sudin\",\"kota\",\"nomor_telepon\",\"JUMLAH_PD\",\"JUMLAH_GURU\",\"JUMLAH_TENDIK\",\"nama_kepala_sekolah\"],\"orderby\":[[\"npsn\",true]],\"annotation_layers\":[],\"row_limit\":10000,\"timeseries_limit\":0,\"order_desc\":true,\"url_params\":{},\"custom_params\":{},\"custom_form_data\":{},\"post_processing\":[]}],\"form_data\":{\"viz_type\":\"table\",\"datasource\":\"9__table\",\"slice_id\":35,\"url_params\":{},\"time_range_endpoints\":[\"inclusive\",\"exclusive\"],\"granularity_sqla\":null,\"time_grain_sqla\":\"P1D\",\"time_range\":\"No+filter\",\"query_mode\":\"raw\",\"groupby\":[],\"all_columns\":[\"nama_satuan_pendidikan\",\"npsn\",\"jenjang\",\"status_sekolah\",\"alamat\",\"KELURAHAN\",\"KECAMATAN\",\"sudin\",\"kota\",\"nomor_telepon\",\"JUMLAH_PD\",\"JUMLAH_GURU\",\"JUMLAH_TENDIK\",\"nama_kepala_sekolah\"],\"percent_metrics\":[],\"adhoc_filters\":[],\"order_by_cols\":[\"[\\\"npsn\\\",+true]\"],\"row_limit\":10000,\"server_page_length\":10,\"include_time\":false,\"order_desc\":true,\"table_timestamp_format\":\"smart_date\",\"page_length\":20,\"include_search\":true,\"show_cell_bars\":false,\"color_pn\":true,\"conditional_formatting\":[],\"extra_form_data\":{},\"force\":false,\"result_format\":\"json\",\"result_type\":\"results\"},\"result_format\":\"json\",\"result_type\":\"results\"}";
//        String token = "IjRkMDZiM2E2OTc0OTMyMmM4MzU5NzdjMjA1YWM3ZmY1MTc4ZTg2YmMi.YrQP7A.ZP4FJE0Tkj3zGjZhFu8Iibo8J7Y";
//        Log.d("CHECK FORM DATA", form_data);
//        sekolahAdapter = new SekolahAdapter(FindByNameActivity.this, sekolahArrayList);

//        Call<ListSekolahResponse> call = RetrofitClient
//                .getInstance()
//                .getAPI()
//                .getAllSchool(token, form_data);
//
//        call.enqueue(new Callback<ListSekolahResponse>() {
//            @Override
//            public void onResponse(Call<ListSekolahResponse> call, Response<ListSekolahResponse> response) {
//                ListSekolahResponse listSekolahResponse = response.body();
//                TextView code = findViewById(R.id.code);
//                code.setText("Response code nya adalah " + response.code());
//                Log.d("TAG", "Response body : " + response.body());
//                Log.d("TAG", "Response body : " + response.code());
//                sekolahArrayList = listSekolahResponse.getDataSekolahs().get(0).getSekolahs();
//                Log.d("CHECK", "LIST " + sekolahArrayList);
//                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//                rv_sekolah.setLayoutManager(layoutManager);
//                rv_sekolah.setItemAnimator(new DefaultItemAnimator());
//                rv_sekolah.setHasFixedSize(true);
//                sekolahAdapter = new SekolahAdapter(FindByNameActivity.this, sekolahArrayList);
//                rv_sekolah.setAdapter(sekolahAdapter);
//                sekolahAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onFailure(Call<ListSekolahResponse> call, Throwable t) {
//
//            }
//        });
        
    }

    public void findByName(){
        //..
    }
}