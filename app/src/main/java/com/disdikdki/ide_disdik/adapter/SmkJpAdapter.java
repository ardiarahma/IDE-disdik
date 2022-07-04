package com.disdikdki.ide_disdik.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.disdikdki.ide_disdik.R;
import com.disdikdki.ide_disdik.model.Sekolah;

import java.util.ArrayList;

public class SmkJpAdapter extends RecyclerView.Adapter<SmkJpAdapter.ViewHolder>{

    private ArrayList<Sekolah> sekolahs;
    private Context context;

    public SmkJpAdapter(ArrayList<Sekolah> sekolahs, Context context) {
        this.sekolahs = sekolahs;
        this.context = context;
    }

    @NonNull
    @Override
    public SmkJpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sekolah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SmkJpAdapter.ViewHolder holder, int position) {
        Sekolah sekolah = sekolahs.get(position);
//        holder.tvNamaSekolah = sekolah.getNama_sekolah();
        holder.tvNamaSekolah.setText(sekolah.getNama_sekolah());
//        holder.tvNpsn = sekolah.getNpsn();
        holder.tvNpsn.setText(sekolah.getNpsn());
//        holder.tvAlamat = sekolah.getAlamat();
        holder.tvAlamat.setText(sekolah.getAlamat());
    }

    @Override
    public int getItemCount() {
        return sekolahs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private String npsn;
        private TextView tvNamaSekolah, tvNpsn, tvAlamat;
        private LinearLayout itemSekolah;
        Dialog dialogSekolah;

        ViewHolder(View itemView){
            super(itemView);

            tvNamaSekolah = itemView.findViewById(R.id.tv_namaSekolah);
            tvNpsn = itemView.findViewById(R.id.tv_itemNPSN);
            tvAlamat = itemView.findViewById(R.id.tv_itemAlamat);
            itemSekolah = itemView.findViewById(R.id.itemSekolah);

//            ll_itemSekolah.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dialogSekolah = new Dialog(itemView)
//                }
//            });
        }
    }
}
