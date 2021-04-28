package com.cindodcindy.nitippembeli.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookingAdapter  extends RecyclerView.Adapter<BookingAdapter.BookingChild> {

    @NonNull
    @Override
    public BookingChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BookingChild holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BookingChild  extends RecyclerView.ViewHolder{

        public BookingChild(@NonNull View itemView) {
            super(itemView);
        }
    }
}
