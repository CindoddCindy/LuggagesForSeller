package com.cindodcindy.nitippembeli.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cindodcindy.nitippembeli.R;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentChild> {

    @NonNull
    @Override
    public PaymentChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentChild holder, int position) {

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
