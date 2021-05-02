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
import com.cindodcindy.nitippembeli.model.pojo_payments.pojo_get_payments.Content;
import com.cindodcindy.nitippembeli.view.KonfirmDetailActivity;
import com.cindodcindy.nitippembeli.view.PaymentDetailActivity;

import java.util.List;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentChild> {

    public List<com.cindodcindy.nitippembeli.model.pojo_payments.pojo_get_payments.Content> contentList;
    public Context context;

    public  PaymentAdapter(List<Content> contentList, Context context){
        this.contentList=contentList;
        this.context=context;

    }

    @NonNull
    @Override
    public PaymentChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_item_layout, parent, false);
        PaymentChild mViewHolder = new PaymentChild(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentChild holder, int position) {
        final Content content= contentList.get(position);
        holder.textView_sl_nama_penerima.setText(content.getNamaPenerimUang());
        holder.textView_jumlah_uang.setText(content.getUangSejumlah());
        holder.textView_tgl_tf.setText(content.getTanggalTransfer());
        holder.textView_sl_nama_bank.setText(content.getBankPenerimaUang());

        holder.cardView_pay.setOnClickListener(new View.OnClickListener() {
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

                bundle.putString("namaAkun",content.getNamaPenerima());
                bundle.putString("jenisBank",content.getBankPenerimaUang());
                bundle.putString("jumlahBayar",content.getJumlahTfPenerimaUang());
                bundle.putString("waktubayar", content.getWaktuPenerimaUang());

                bundle.putString("namaPengirimUang", content.getNamaPengirimUang());
                bundle.putString("BankPengirim",content.getBankPengirimUang());
                bundle.putString("tglTfPengirim", content.getTanggalTransfer());
                bundle.putString("UangSejumlah", content.getUangSejumlah());

                Intent intent = new Intent(context, PaymentDetailActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class PaymentChild extends RecyclerView.ViewHolder{

        private TextView textView_sl_nama_penerima, textView_jumlah_uang, textView_tgl_tf,textView_sl_nama_bank;

        private CardView cardView_pay;


        public PaymentChild(@NonNull View itemView) {
            super(itemView);

            textView_sl_nama_penerima=itemView.findViewById(R.id.tv_pay_rv_nama_pengirim);
            textView_jumlah_uang=itemView.findViewById(R.id.tv_pay_rv_jumlah_uang);
            textView_tgl_tf=itemView.findViewById(R.id.tv_pay_rv_tgal_tf);
            textView_sl_nama_bank=itemView.findViewById(R.id.tv_pay_rv_nama_bank);


            cardView_pay=itemView.findViewById(R.id.cv_payment);
        }
    }
}
