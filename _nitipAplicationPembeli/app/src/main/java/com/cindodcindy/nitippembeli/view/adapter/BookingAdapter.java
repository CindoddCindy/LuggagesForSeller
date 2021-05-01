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
import com.cindodcindy.nitippembeli.model.pojo_booking.pojo_get_booking.Content;
import com.cindodcindy.nitippembeli.view.BookingDetailActivity;
import com.cindodcindy.nitippembeli.view.KonfirmDetailActivity;

import java.util.List;

public class BookingAdapter  extends RecyclerView.Adapter<BookingAdapter.BookingChild> {

    public List<com.cindodcindy.nitippembeli.model.pojo_booking.pojo_get_booking.Content> contentList;
    public Context context;

    public  BookingAdapter(List<Content> contentList, Context context){
        this.contentList=contentList;
        this.context=context;

    }

    @NonNull
    @Override
    public BookingChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_item_layout, parent, false);
        BookingChild mViewHolder = new BookingChild(mView);


        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookingChild holder, int position) {
        final Content content= contentList.get(position);
        holder.textView_asal.setText(content.getAsal());
        holder.textView_tujuan.setText(content.getTujuan());
        holder.textView_date_going.setText(content.getTanggalBerangkat());
        holder.textView_date_arive.setText(content.getTanggalTiba());
        holder.textView_time_going.setText(content.getJamBerangkat());
        holder.textView_time_arrive.setText(content.getJamTiba());
        holder.textView_nama_penjual.setText(content.getNamaPenjual());
        holder.textView_harga.setText(content.getHargaBagasi());
        holder.textView_kapasitas.setText(content.getKapasitas());
        holder.textView_jenis_barang.setText(content.getJenisBarang());

        holder.cardView_booking_adapter.setOnClickListener(new View.OnClickListener() {
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

                Intent intent = new Intent(context, BookingDetailActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public class BookingChild  extends RecyclerView.ViewHolder{

        private TextView textView_asal, textView_tujuan, textView_date_going, textView_date_arive,
                textView_time_going, textView_time_arrive, textView_nama_penjual, textView_harga, textView_jenis_barang, textView_kapasitas;

        private CardView cardView_booking_adapter;

        public BookingChild(@NonNull View itemView) {
            super(itemView);
            textView_asal=itemView.findViewById(R.id.id_tv_book_item_lugg_asal);
            textView_tujuan=itemView.findViewById(R.id.tv_book_item_lugg_tujuan);
            textView_date_going=itemView.findViewById(R.id.tv_book_item_lugg_tgal_going);
            textView_date_arive=itemView.findViewById(R.id.tv_book_item_lugg_tgal_arr);
            textView_time_going=itemView.findViewById(R.id.tv_book_item_lugg_time_going);
            textView_time_arrive=itemView.findViewById(R.id.tv_book_item_lugg_time_arr);
            textView_nama_penjual=itemView.findViewById(R.id.tv_book_item_lugg_nama_seller);
            textView_harga=itemView.findViewById(R.id.tv_book_item_lugg_price);
            textView_jenis_barang=itemView.findViewById(R.id.tv_book_item_lugg_type);
            textView_kapasitas=itemView.findViewById(R.id.tv_book_item_lugg_height);

            cardView_booking_adapter=itemView.findViewById(R.id.cv_book_det_lugg_av);
        }
    }
}
