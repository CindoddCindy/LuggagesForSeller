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
import com.cindodcindy.nitippembeli.model.pojo_konfirm.pojo_get_konfirm.Content;
import com.cindodcindy.nitippembeli.view.KonfirmDetailActivity;

import java.util.List;

public class ConfirmationAdapter extends RecyclerView.Adapter<ConfirmationAdapter.ConfirmationChild> {

    public List<com.cindodcindy.nitippembeli.model.pojo_konfirm.pojo_get_konfirm.Content> contentList;
    public Context context;

    public  ConfirmationAdapter(List<Content> contentList, Context context){
        this.contentList=contentList;
        this.context=context;

    }

    @NonNull
    @Override
    public ConfirmationChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.konfirmasi_item_layout, parent, false);
        ConfirmationChild mViewHolder = new ConfirmationChild(mView);

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmationChild holder, int position) {

        final Content content= contentList.get(position);
        holder.textView_sl_nama_penerima.setText(content.getNamaAkun());
        holder.textView_sl_no_rek.setText(content.getNoRek());
        holder.textView_sl_nama_bank.setText(content.getJenisBank());
        holder.textView_sl_jumlah_harga.setText(content.getJumlahBayar());
        holder.textView_sl_waktu_kirim.setText(content.getWaktuPembayaran());

        holder.cardView_confirm.setOnClickListener(new View.OnClickListener() {
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

                //nanati dihash code pake akun bank nitip
                //bundle.putString("namaAkun",content.getNamaAkun());
                //bundle.putString("noRek",content.getNoRek());
                //bundle.putString("jenisBank",content.getJenisBank());
                bundle.putString("jumlahBayar",content.getJumlahBayar());
                bundle.putString("waktubayar", content.getWaktuPembayaran());

                bundle.putString("lokasiBertemu", content.getLokasiJemputbarang());
                bundle.putString("jamAmbilBrg",content.getJamJemputBarang());
                bundle.putString("estimasisampai", content.getEstimasiSampai());

                Intent intent = new Intent(context, KonfirmDetailActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class  ConfirmationChild extends RecyclerView.ViewHolder{

        private TextView textView_sl_nama_penerima, textView_sl_no_rek, textView_sl_nama_bank, textView_sl_jumlah_harga,
        textView_sl_waktu_kirim;

        private CardView cardView_confirm;

        public ConfirmationChild(@NonNull View itemView) {
            super(itemView);
            textView_sl_nama_penerima=itemView.findViewById(R.id.tv_konf_rv_nama_akun_penerima);
            textView_sl_no_rek=itemView.findViewById(R.id.tv_konf_rv_no_rek);
            textView_sl_nama_bank=itemView.findViewById(R.id.tv_konf_rv_nama_bank);
            textView_sl_jumlah_harga=itemView.findViewById(R.id.tv_konf_rv_jumlah_uang);

            textView_sl_waktu_kirim=itemView.findViewById(R.id.tv_konf_rv_waktu_bayar);

            cardView_confirm=itemView.findViewById(R.id.cv_konf);
        }
    }
}
