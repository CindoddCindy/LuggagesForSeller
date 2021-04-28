package com.cindodcindy.nitippembeli.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.cindodcindy.nitippembeli.R;

public class BookingDetailActivity extends AppCompatActivity {

    //data jasa
    private TextView textView_asal, textView_tujuan, textView_date_going, textView_date_arive,
            textView_time_going, textView_time_arrive, textView_nama_penjual, textView_harga, textView_jenis_barang, textView_kapasitas;


    //data buyer

    private TextView textView_by_asal, textView_by_tujuan, textView_by_pengirim, textView_by_penerima, textView_by_jenis_barang, textView_by_berat_brg;



    //btn

    private  TextView textView_btn_edit_kirim_booking, textView_btn_hapus_booking, textView_btn_back_dari_booking;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);

        //data jasa

        textView_asal=findViewById(R.id.id_tv_book_det_lugg_asal);
        textView_tujuan=findViewById(R.id.tv_book_det_lugg_tujuan);
        textView_date_going=findViewById(R.id.tv_book_det_lugg_tgal_going);
        textView_date_arive=findViewById(R.id.tv_book_det_lugg_tgal_arr);
        textView_time_going=findViewById(R.id.tv_book_det_lugg_time_going);
        textView_time_arrive=findViewById(R.id.tv_book_det_lugg_time_arr);
        textView_nama_penjual=findViewById(R.id.tv_book_det_lugg_nama_seller);
        textView_harga=findViewById(R.id.tv_book_det_lugg_price);
        textView_jenis_barang=findViewById(R.id.tv_book_det_lugg_type);
        textView_kapasitas=findViewById(R.id.tv_book_det_lugg_height);

        //data pembeli

        textView_by_asal=findViewById(R.id.tv_book_det_by_asal);
        textView_by_tujuan=findViewById(R.id.tv_book_det_by_tujuan);
        textView_by_pengirim=findViewById(R.id.tv_book_det_by_pengirim);
        textView_by_penerima=findViewById(R.id.tv_book_det_by_penerima);
        textView_by_jenis_barang=findViewById(R.id.tv_book_det_by_jenis_barang);
        textView_by_berat_brg=findViewById(R.id.tv_book_det_by_berat_barang);

        textView_btn_edit_kirim_booking=findViewById(R.id.tv_book_det_btn_edit_booking);
        textView_btn_hapus_booking=findViewById(R.id.tv_book_det_btn_hapus_booking);
        textView_btn_back_dari_booking=findViewById(R.id.tv_book_det_btn_back);

    }
}