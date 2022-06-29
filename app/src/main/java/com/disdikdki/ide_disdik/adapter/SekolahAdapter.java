package com.disdikdki.ide_disdik.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.disdikdki.ide_disdik.R;
import com.disdikdki.ide_disdik.model.Sekolah;

import java.util.ArrayList;


public class SekolahAdapter extends RecyclerView.Adapter<SekolahAdapter.ViewHolder>{

    Context context;
    private ArrayList<Sekolah> sekolahs;

    public SekolahAdapter(Context context, ArrayList<Sekolah> sekolahs) {
        this.context = context;
        this.sekolahs = sekolahs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        View view = inflater.inflate(R.layout.item_sekolah, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sekolah sekolah = sekolahs.get(position);
        holder.tv_namaSekolah.setText(sekolah.getNama_satuan_pendidikan());
        holder.tv_npsn.setText(sekolah.getNpsn());
        holder.tv_alamat.setText(sekolah.getAlamat());
    }

    //    @Override
//    public void onBindViewHolder(final SekolahAdapter.ViewHolder holder, int position) {
//        Sekolah sekolah = sekolahs.get(position);
//        holder.tv_namaSekolah.setText(sekolah.getNama_satuan_pendidikan());
//        holder.tv_npsn.setText(sekolah.getNpsn());
//        holder.tv_alamat.setText(sekolah.getAlamat());
//    }

    @Override
    public int getItemCount() {
        return sekolahs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private int npsn;
        private String nama_sekolah, alamat;
        private TextView tv_namaSekolah, tv_npsn, tv_alamat;
        private LinearLayout itemSekolah;

        public ViewHolder(View itemView){
            super(itemView);
            itemSekolah = itemView.findViewById(R.id.itemSekolah);
            tv_namaSekolah = itemView.findViewById(R.id.tv_namaSekolah);
            tv_npsn = itemView.findViewById(R.id.tv_itemNPSN);
            tv_alamat = itemView.findViewById(R.id.tv_itemAlamat);
            itemSekolah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
