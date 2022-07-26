package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.disdikdki.ide_disdik.api.RetrofitClient;
import com.disdikdki.ide_disdik.model.Rekap;
import com.disdikdki.ide_disdik.model.RekapResponse;

import java.text.DecimalFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRekapActivity extends AppCompatActivity {

    ImageView back;
    WebView pchartSekolah, pchartPesdik, pchartGuru, pchartTendik,
            bchartSekolahWil, bchartPesdikWil, bchartGuruWil, bchartTendikWil;
    TextView jumlahSekolah, jumlahPesdik, jumlahGuru, jumlahTendik;

    ArrayList<Rekap> rekaps;

    DecimalFormat formater = new DecimalFormat("#,###,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_rekap);

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataRekapActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        jumlahSekolah = findViewById(R.id.tv_jumlahSekolah);
        jumlahPesdik = findViewById(R.id.tv_jumlahPesdik);
        jumlahGuru = findViewById(R.id.tv_jumlahGuru);
        jumlahTendik = findViewById(R.id.tv_jumlahTendik);

        Call<RekapResponse> call = RetrofitClient
                .getInstance()
                .getAPI()
                .getRekap();

        call.enqueue(new Callback<RekapResponse>() {
            @Override
            public void onResponse(Call<RekapResponse> call, Response<RekapResponse> response) {
                RekapResponse rekapResponse = response.body();
                Log.d("CHECK ISI DARI RESPONSE BODY", "ini dia --> " + response.body());
                if (rekapResponse != null && rekapResponse.getError() == null){
                    Log.i("debug", "onResponse : SUCCESSFUL");
                    rekaps = rekapResponse.getRekapArrayList();
                    jumlahSekolah.setText(String.valueOf(formater.format(rekaps.get(0).getJumlahSekolah())));
                    jumlahPesdik.setText(String.valueOf(formater.format(rekaps.get(0).getJumlahPesdik())));
                    jumlahGuru.setText(String.valueOf(formater.format(rekaps.get(0).getJumlahGuru())));
                    jumlahTendik.setText(String.valueOf(formater.format(rekaps.get(0).getJumlahTendik())));
                }else {
                    Log.i("debug", "onResponse: FAILED");
                    Toast.makeText(getApplicationContext(), "Gagal dalam mengambil data", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<RekapResponse> call, Throwable t) {

            }
        });

        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        cookieManager.setAcceptCookie(false);

        pchartSekolah = findViewById(R.id.pchart_sekolah);
        pchartSekolah.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?height=300dp&form_data=%7B%22viz_type%22%3A%22pie%22%2C%22datasource%22%3A%224__table%22%2C%22slice_id%22%3A29%2C%22url_params%22%3A%7B%22standalone%22%3A%221%22%2C%22height%22%3A%22300%22%7D%2C%22time_range_endpoints%22%3A%5B%22inclusive%22%2C%22exclusive%22%5D%2C%22granularity_sqla%22%3Anull%2C%22time_range%22%3A%22No+filter%22%2C%22groupby%22%3A%5B%22jenjang%22%5D%2C%22metric%22%3A%22count%22%2C%22adhoc_filters%22%3A%5B%5D%2C%22row_limit%22%3A1000%2C%22sort_by_metric%22%3Atrue%2C%22color_scheme%22%3A%22d3Category20c%22%2C%22show_labels_threshold%22%3A%220%22%2C%22show_legend%22%3Afalse%2C%22legendType%22%3A%22plain%22%2C%22legendOrientation%22%3A%22top%22%2C%22label_type%22%3A%22key%22%2C%22number_format%22%3A%22%2Cd%22%2C%22date_format%22%3A%22smart_date%22%2C%22show_labels%22%3Atrue%2C%22labels_outside%22%3Atrue%2C%22label_line%22%3Atrue%2C%22outerRadius%22%3A80%2C%22donut%22%3Atrue%2C%22innerRadius%22%3A34%2C%22extra_form_data%22%3A%7B%7D%7D&standalone=1");
        WebSettings webSettings = pchartSekolah.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);

        pchartPesdik = findViewById(R.id.pchart_pesdik);
//        pchartPesdik.loadUrl("\"https://dashboard.pusdatikomdik.id/superset/explore/?r=68&standalone=1&height=300");
        pchartPesdik.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=43&standalone=1&height=300");
        WebSettings webSettings1 = pchartPesdik.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        webSettings1.setBuiltInZoomControls(true);
        webSettings1.setLoadWithOverviewMode(true);

        pchartGuru = findViewById(R.id.pchart_guru);
        pchartGuru.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=44&standalone=1&height=300");
        WebSettings webSettings2 = pchartGuru.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        webSettings2.setBuiltInZoomControls(true);
        webSettings2.setLoadWithOverviewMode(true);

        pchartTendik = findViewById(R.id.pchart_tendik);
        pchartTendik.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=69&standalone=1&height=300");
//        pchartTendik.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=54&standalone=1&height=300");
        WebSettings webSettings3 = pchartTendik.getSettings();
        webSettings3.setJavaScriptEnabled(true);
        webSettings3.setBuiltInZoomControls(true);
        webSettings3.setLoadWithOverviewMode(true);

        bchartSekolahWil = findViewById(R.id.bchart_sekolah);
        bchartSekolahWil.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=45&standalone=1&height=400");
        WebSettings webSettings4 = bchartSekolahWil.getSettings();
        webSettings4.setJavaScriptEnabled(true);
        webSettings4.setBuiltInZoomControls(true);

        bchartPesdikWil = findViewById(R.id.bchart_pesdik);
        bchartPesdikWil.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=48&standalone=1&height=400");
        WebSettings webSettings5 = bchartPesdikWil.getSettings();
        webSettings5.setJavaScriptEnabled(true);
        webSettings5.setBuiltInZoomControls(true);

        bchartGuruWil = findViewById(R.id.bchart_guru);
        bchartGuruWil.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=49&standalone=1&height=400");
        WebSettings webSettings6 = bchartGuruWil.getSettings();
        webSettings6.setJavaScriptEnabled(true);
        webSettings6.setBuiltInZoomControls(true);

        bchartTendikWil = findViewById(R.id.bchart_tendik);
        bchartTendikWil.loadUrl("https://dashboard.pusdatikomdik.id/superset/explore/?r=50&standalone=1&height=400");
        WebSettings webSettings7 = bchartTendikWil.getSettings();
        webSettings7.setJavaScriptEnabled(true);
        webSettings7.setBuiltInZoomControls(true);
    }
}