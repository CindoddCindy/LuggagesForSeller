package com.cindodcindy.nitippembeli.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cindodcindy.nitippembeli.R;

public class DoneAdapter extends RecyclerView.Adapter<DoneAdapter.DoneChild> {

    @NonNull
    @Override
    public DoneChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DoneChild holder, int position) {

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
