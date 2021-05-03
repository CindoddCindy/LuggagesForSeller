package com.cindodcindy.nitippembeli.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cindodcindy.nitippembeli.R;
import com.cindodcindy.nitippembeli.model.pojo_done.pojo_get_done.Content;
import com.cindodcindy.nitippembeli.view.BookingDetailActivity;

import java.util.List;

public class DoneAdapter extends RecyclerView.Adapter<DoneAdapter.DoneChild> {

    public List<com.cindodcindy.nitippembeli.model.pojo_done.pojo_get_done.Content> contentList;
    public Context context;

    public  DoneAdapter(List<com.cindodcindy.nitippembeli.model.pojo_done.pojo_get_done.Content> contentList, Context context){
        this.contentList=contentList;
        this.context=context;

    }

    @NonNull
    @Override
    public DoneChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.done_item_layout, parent, false);
        DoneChild mViewHolder = new DoneChild(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DoneChild holder, int position) {

        final Content content= contentList.get(position);
        holder.textView_diterima_oleh.setText(content.getDiterimaOleh());
        holder.textView_tgal_diterima.setText(content.getTanggalBarangTiba());

        holder.cardView_done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putLong("id_seller", content.getIdSeller());
                bundle.putString("asal",content.getAsal());
                bundle.putString("tujuan",content.getTujuan());
                bundle.putString("tglgo",content.getTanggalBerangkat());
                bundle.putString("tglarr",content.getTanggalTiba());
                bundle.putString("jamgo", content.getJamBerangkat());
                bundle.putString("jamarr",content.getJamTiba());
                bundle.putString("namapenjual",content.getNamaPenjual());
                bundle.putString("kapasitas",content.getKapasitas());
                bundle.putString("jenisbarang",content.getJenisBarang());
                bundle.putString("harga", content.getHargaBagasi());

                bundle.putString("asalBr",content.getAlamatPembeli());
                bundle.putString("tujuanBr",content.getAlamatPenerima());
                bundle.putString("pengirim",content.getNamaPembeli());
                bundle.putString("penerima",content.getNamaPenerima());
                bundle.putString("jenisBr", content.getJenisBarangKirim());
                bundle.putString("beratBr",content.getKapasitasBarang());

                bundle.putString("tanggalBarangTiba",content.getTanggalBarangTiba());
                bundle.putString("namaPenerimaBarang",content.getDiterimaOleh());
                bundle.putString("lokasiBarangDiterima",content.getLokasiBarangDiterima());

                Intent intent = new Intent(context, BookingDetailActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class DoneChild extends RecyclerView.ViewHolder{
        private TextView textView_diterima_oleh, textView_tgal_diterima;
        private CardView cardView_done_btn;

        public DoneChild(@NonNull View itemView) {
            super(itemView);

            textView_diterima_oleh=itemView.findViewById(R.id.tv_done_rv_nama_penerima);
            textView_tgal_diterima=itemView.findViewById(R.id.tv_done_rv_tgal_diterima);
            cardView_done_btn=itemView.findViewById(R.id.cv_done);

        }
    }
}
