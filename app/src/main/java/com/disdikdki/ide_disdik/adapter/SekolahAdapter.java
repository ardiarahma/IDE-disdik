package com.disdikdki.ide_disdik.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.disdikdki.ide_disdik.R;
import com.disdikdki.ide_disdik.model.DataSekolah;
import com.disdikdki.ide_disdik.model.Sekolah;

import java.util.ArrayList;
import java.util.LinkedList;

public class SekolahAdapter extends RecyclerView.Adapter<SekolahAdapter.ViewHolder>{

    private ArrayList<Sekolah> sekolahs;
    private ArrayList<Sekolah> filteredSekolah;
    private Context context;
//    private SekolahFilter sekolahFilter;
    private DataSekolah dataSekolah;
    private static final int LOADING = 0;
    private static final int ITEM = 0;
    private boolean isLoadingAdded = false;

    public SekolahAdapter(ArrayList<Sekolah> sekolahs, Context context) {
        this.sekolahs = sekolahs;
        this.context = context;
    }

    public void setSekolahs(ArrayList<Sekolah> sekolahs) {
        this.sekolahs = sekolahs;
    }

    @NonNull
    @Override
    public SekolahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sekolah, parent, false);
//        RecyclerView.ViewHolder viewHolder = null;
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//
//        switch (viewType){
//            case ITEM:
//                View viewItem = inflater.inflate(R.layout.item_sekolah, parent, false);
//                viewHolder = new ViewHolder(viewItem);
//                break;
//            case LOADING:
//                View viewLoading = inflater.inflate(R.layout.item_progress, parent, false);
//                viewHolder = new LoadingViewHolder(viewLoading);
//                break;
//        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SekolahAdapter.ViewHolder holder, int position) {
        Sekolah sekolah = sekolahs.get(position);
//        switch (getItemViewType(position)){
//            case ITEM:
//
//                break;
//            case LOADING:
//                LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
//                loadingViewHolder.progressBar.setVisibility(View.VISIBLE);
//
//        }

//        ViewHolder sekolahViewHolder = (SekolahViewHolder) holder;
        holder.tvNamaSekolah.setText(sekolah.getNama_sekolah());
        holder.tvNpsn.setText(sekolah.getNpsn());
        holder.tvAlamat.setText(sekolah.getAlamat());

        holder.namasekolah = sekolah.getNama_sekolah();
        holder.npsn = sekolah.getNpsn();
        holder.alamat = sekolah.getAlamat();
        holder.kel = sekolah.getKelurahan();
        holder.kec = sekolah.getKecamatan();
        holder.kota = sekolah.getKota();
        holder.kel = sekolah.getKelurahan();
        holder.sudin = sekolah.getSudin();
        holder.telp = sekolah.getNoTelp();
        holder.kepsek = sekolah.getNama_kepsek();
        holder.hpkepsek = sekolah.getNoHp_kepsek();
        holder.jmlGuru = sekolah.getJumlah_guru();
        holder.jmlPesdik = sekolah.getJumlah_pesdik();
        holder.jmlTendik = sekolah.getJumlah_tendik();
    }

    @Override
    public int getItemCount() {
        return sekolahs.size();
    }

    public void updateList(ArrayList<Sekolah> filteredList){
        sekolahs = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private String namasekolah, npsn, alamat, kel, kec, kota, prov, sudin, telp, kepsek, hpkepsek;
        private int jmlPesdik, jmlGuru, jmlTendik;
        private TextView tvNamaSekolah, tvNpsn, tvAlamat;
        private TextView tvSekolah, tvNpsnSekolah, tvAlamatSekolah, tvKelurahan, tvKecamatan, tvKota, tvSudin,
                tvNoTelp, tvNamaKepsek, tvTelpKepsek, tvJumlahPesdik, tvJumlahGuru, tvJumlahTendik;
        private LinearLayout itemSekolah;
        private ImageView close;
        Dialog dialogSekolah;

        ViewHolder(View itemView){
            super(itemView);

            tvNamaSekolah = itemView.findViewById(R.id.tv_namaSekolah);
            tvNpsn = itemView.findViewById(R.id.tv_itemNPSN);
            tvAlamat = itemView.findViewById(R.id.tv_itemAlamat);
            itemSekolah = itemView.findViewById(R.id.itemSekolah);
            itemSekolah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog();
                }
            });
        }

        public void showDialog(){
            dialogSekolah = new Dialog(itemView.getContext());
            Window window = dialogSekolah.getWindow();
            dialogSekolah.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialogSekolah.setCancelable(true);
            dialogSekolah.setCanceledOnTouchOutside(true);
            dialogSekolah.setContentView(R.layout.dialog_sekolah);
            dialogSekolah.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            int width = metrics.widthPixels;
            int height = metrics.heightPixels;

            dialogSekolah.getWindow().setLayout(width, height);
            window.setGravity(Gravity.CENTER_VERTICAL);

            close = dialogSekolah.findViewById(R.id.close_dialog);
            tvSekolah = dialogSekolah.findViewById(R.id.tv_Sekolah);
            tvNpsnSekolah = dialogSekolah.findViewById(R.id.tv_getNpsn);
            tvAlamatSekolah = dialogSekolah.findViewById(R.id.tv_alamat);
            tvKelurahan = dialogSekolah.findViewById(R.id.tv_kelurahan);
            tvKecamatan = dialogSekolah.findViewById(R.id.tv_kecamatan);
            tvKota = dialogSekolah.findViewById(R.id.tv_kota);
            tvSudin = dialogSekolah.findViewById(R.id.tv_sudin);
            tvNoTelp = dialogSekolah.findViewById(R.id.tv_tlp);
            tvNamaKepsek = dialogSekolah.findViewById(R.id.tv_kepsek);
            tvTelpKepsek = dialogSekolah.findViewById(R.id.tv_tlpKepsek);
            tvJumlahGuru = dialogSekolah.findViewById(R.id.tv_jumlahGuru);
            tvJumlahPesdik = dialogSekolah.findViewById(R.id.tv_jumlahPesdik);
            tvJumlahTendik = dialogSekolah.findViewById(R.id.tv_jumlahTendik);

            tvSekolah.setText(String.valueOf(namasekolah));
            tvNpsnSekolah.setText(String.valueOf(npsn));
            tvAlamatSekolah.setText(String.valueOf(alamat));
            tvKelurahan.setText(String.valueOf(kel));
            tvKecamatan.setText(String.valueOf(kec));
            tvKota.setText(String.valueOf(kota));
            tvSudin.setText(String.valueOf(sudin));
            tvNoTelp.setText(String.valueOf(telp));
            tvNamaKepsek.setText(String.valueOf(kepsek));
            tvTelpKepsek.setText(String.valueOf(hpkepsek));
            tvJumlahGuru.setText(String.valueOf(jmlGuru));
            tvJumlahPesdik.setText(String.valueOf(jmlPesdik));
            tvJumlahTendik.setText(String.valueOf(jmlTendik));

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogSekolah.dismiss();
                }
            });

            dialogSekolah.show();
        }

    }

//    public class LoadingViewHolder extends RecyclerView.ViewHolder{
//        private ProgressBar progressBar;
//        public LoadingViewHolder(View itemView){
//            super(itemView);
//            progressBar = itemView.findViewById(R.id.loadmore_progress);
//        }
//    }
}
