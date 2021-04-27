package com.cindodcindy.nitippembeli.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        public ConfirmationChild(@NonNull View itemView) {
            super(itemView);
        }
    }
}
