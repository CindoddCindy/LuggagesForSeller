package com.cindodcindy.nitippembeli.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        public PaymentChild(@NonNull View itemView) {
            super(itemView);
        }
    }
}
