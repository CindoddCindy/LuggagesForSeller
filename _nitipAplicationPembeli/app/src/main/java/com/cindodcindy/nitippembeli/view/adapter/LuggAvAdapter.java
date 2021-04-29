package com.cindodcindy.nitippembeli.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cindodcindy.nitippembeli.R;
import com.cindodcindy.nitippembeli.model.pojo_jasa.pojo_get_jasa.Content;

import java.util.List;

public class LuggAvAdapter extends RecyclerView.Adapter<LuggAvAdapter.LugChild> {

    public List<Content> contentList;
    public Context context;

    public  LuggAvAdapter(List<Content> contentList,  Context context){
        this.contentList=contentList;
        this.context=context;

    }

    @NonNull
    @Override
    public LugChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.luggage_avaliable_item, parent, false);
        LugChild mViewHolder = new LugChild(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LugChild holder, int position) {

        final Content content= contentList.get(position);
        holder.textView_asal.setText(content.getAsal());
        holder.textView_tujuan.setText(content.getTujuan());
        holder.textView_date_going.setText(content.getTanggalBerangkat());
        holder.textView_time_going.setText(content.getJamBerangkat());
        holder.textView_date_arive.setText(content.getTanggalTiba());
        holder.textView_time_arrive.setText(content.getJamTiba());
        holder.textView_nama_penjual.setText(content.getNamaPenjual());
        holder.textView_harga.setText(content.getHargaBagasi());
        holder.textView_kapasitas.setText(content.getKapasitas());
        holder.textView_jenis_barang.setText(content.getJenisBarang());


    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public  class LugChild extends RecyclerView.ViewHolder{

        private TextView textView_asal, textView_tujuan, textView_date_going, textView_date_arive,
                textView_time_going, textView_time_arrive, textView_nama_penjual, textView_harga, textView_jenis_barang, textView_kapasitas;



        public LugChild(@NonNull View itemView) {
                super(itemView);

            textView_asal=itemView.findViewById(R.id.id_tv_item_lugg_asal);
            textView_tujuan=itemView.findViewById(R.id.tv_item_lugg_tujuan);
            textView_date_going=itemView.findViewById(R.id.tv_item_lugg_tgal_going);
            textView_date_arive=itemView.findViewById(R.id.tv_item_lugg_tgal_arr);
            textView_time_going=itemView.findViewById(R.id.tv_item_lugg_time_going);
            textView_time_arrive=itemView.findViewById(R.id.tv_item_lugg_time_arr);
            textView_nama_penjual=itemView.findViewById(R.id.tv_item_lugg_nama_seller);
            textView_harga=itemView.findViewById(R.id.tv_item_lugg_price);
            textView_jenis_barang=itemView.findViewById(R.id.tv_item_lugg_type);
            textView_kapasitas=itemView.findViewById(R.id.tv_item_lugg_height);

        }
    }
}
