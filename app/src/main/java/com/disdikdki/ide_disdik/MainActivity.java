package com.disdikdki.ide_disdik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.disdikdki.ide_disdik.adapter.SliderAdapter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SliderView sliderView;
    int[] images = {R.drawable.slide_img1,
            R.drawable.slide_img2,
            R.drawable.slide_img3,
            R.drawable.slide_img4,
            R.drawable.slide_img5,
            R.drawable.slide_img7};

    BarChart barChart;
    BarDataSet barDataset1, barDataset2;
    ArrayList barEntries;
    String[] sekolah = new String[]{"SD", "SMP", "SMA", "SMK"};

    CardView btnDataSekolah, btnDataRekap, btnDataSKPD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

        //bar chart
        barChart = findViewById(R.id.barChart);
        //create new dataset
        barDataset1 = new BarDataSet(getBarEntriesOne(), "Negeri");
        barDataset1.setColor(getApplicationContext().getResources().getColor(R.color.bar_negeri));
        barDataset2 = new BarDataSet(getBarEntriesTwo(), "Swasta");
        barDataset2.setColor(getApplicationContext().getResources().getColor(R.color.bar_swasta));

        BarData data = new BarData(barDataset1, barDataset2);
        barChart.setData(data);
        barChart.getDescription().setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(sekolah));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(3);

        float barSpace = 0.1f;
        float groupSpace = 0.5f;

        //bar width
        data.setBarWidth(0.15f);
        barChart.getXAxis().setAxisMinimum(0);
        barChart.animate();

        barChart.groupBars(0, groupSpace, barSpace);

        // below line is to invalidate
        // our bar chart.
        barChart.invalidate();

        //==== MAIN MENU ====
        btnDataSekolah = findViewById(R.id.btn_dataSekolah);
        btnDataRekap = findViewById(R.id.btn_dataRekap);
        btnDataSKPD = findViewById(R.id.btn_dataSKPD);

        btnDataSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataSekolahActivity.class);
                startActivity(intent);
            }
        });

        btnDataRekap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataRekapActivity.class);
                startActivity(intent);
            }
        });

        btnDataSKPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataSkpdActivity.class);
                startActivity(intent);
            }
        });


//        //dummy data
//        ArrayList<BarEntry> data_sekolah = new ArrayList<>();
//        data_sekolah.add(new BarEntry(Integer.parseInt("SD"), 2000));
//        data_sekolah.add(new BarEntry(Integer.parseInt("SD"), 1200));
//        data_sekolah.add(new BarEntry(Integer.parseInt("SMP"), 600));
//        data_sekolah.add(new BarEntry(Integer.parseInt("SMP"), 1100));
//        data_sekolah.add(new BarEntry(Integer.parseInt("SMA"), 200));
//        data_sekolah.add(new BarEntry(Integer.parseInt("SMA"), 500));
//        data_sekolah.add(new BarEntry(Integer.parseInt("SMK"), 100));
//        data_sekolah.add(new BarEntry(Integer.parseInt("SMK"), 700));
//
//        BarDataSet barDataSet = new BarDataSet(data_sekolah, "Statistik Data Sekolah");
//        barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
//        barDataSet.setValueTextColor(Color.DKGRAY);
//        barDataSet.setValueTextSize(10f);
//
//        BarData barData = new BarData(barDataSet);
//        barChart.setFitBars(true);
//        barChart.setData(barData);
//        barChart.getDescription().setText("contoh ajasih ini");
//        barChart.animateY(2000);

    }

    private ArrayList<BarEntry> getBarEntriesOne(){
        barEntries = new ArrayList<>();

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        barEntries.add(new BarEntry(1f, 2000));
        barEntries.add(new BarEntry(2f, 600));
        barEntries.add(new BarEntry(3f, 200));
        barEntries.add(new BarEntry(4f, 100));
        return barEntries;
    }

    // array list for second set.
    private ArrayList<BarEntry> getBarEntriesTwo() {

        // creating a new array list
        barEntries = new ArrayList<>();

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        barEntries.add(new BarEntry(1f, 1200));
        barEntries.add(new BarEntry(2f, 1100));
        barEntries.add(new BarEntry(3f, 500));
        barEntries.add(new BarEntry(4f, 700));
        return barEntries;
    }
}