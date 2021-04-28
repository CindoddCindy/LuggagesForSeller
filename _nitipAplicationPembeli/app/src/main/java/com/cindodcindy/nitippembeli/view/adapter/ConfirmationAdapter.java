package com.cindodcindy.nitippembeli.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cindodcindy.nitippembeli.R;

public class ConfirmationAdapter extends RecyclerView.Adapter<ConfirmationAdapter.ConfirmationChild> {

    @NonNull
    @Override
    public ConfirmationChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmationChild holder, int position) {

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
