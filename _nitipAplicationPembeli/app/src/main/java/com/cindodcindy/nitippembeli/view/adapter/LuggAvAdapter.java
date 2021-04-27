package com.cindodcindy.nitippembeli.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LuggAvAdapter extends RecyclerView.Adapter<LuggAvAdapter.LugChild> {

    @NonNull
    @Override
    public LugChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull LugChild holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class LugChild extends RecyclerView.ViewHolder{

        public LugChild(@NonNull View itemView) {
            super(itemView);
        }
    }
}
