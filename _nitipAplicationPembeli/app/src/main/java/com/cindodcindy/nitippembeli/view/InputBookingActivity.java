package com.cindodcindy.nitippembeli.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.cindodcindy.nitippembeli.R;

public class InputBookingActivity extends AppCompatActivity {

    //data jasa
    private TextView textView_asal, textView_tujuan, textView_date_going, textView_date_arive,
            textView_time_going, textView_time_arrive, textView_nama_penjual, textView_harga, textView_jenis_barang, textView_kapasitas;

    //data buyer

    private EditText editText_by_asal, editText_by_tujuan, editText_by_pengirim, editText_by_penerima, editText_by_jenis_barang, editText_by_berat_brg;

    //btn

    private  TextView textView_btn_kirim_booking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_booking);

        //data jasa

        textView_asal=findViewById(R.id.id_tv_book_in_item_lugg_asal);
        textView_tujuan=findViewById(R.id.tv_book_in_item_lugg_tujuan);
        textView_date_going=findViewById(R.id.tv_book_in_item_lugg_tgal_going);
        textView_date_arive=findViewById(R.id.tv_book_in_item_lugg_tgal_arr);
        textView_time_going=findViewById(R.id.tv_book_in_item_lugg_time_going);
        textView_time_arrive=findViewById(R.id.tv_book_in_item_lugg_time_arr);
        textView_nama_penjual=findViewById(R.id.tv_book_in_item_lugg_nama_seller);
        textView_harga=findViewById(R.id.tv_book_in_item_lugg_price);
        textView_jenis_barang=findViewById(R.id.tv_book_in_item_lugg_type);
        textView_kapasitas=findViewById(R.id.tv_book_in_item_lugg_height);

        //data pembeli

        editText_by_asal=findViewById(R.id.et_book_in_by_alamat_pengirim);
        editText_by_tujuan=findViewById(R.id.et_book_in_by_alamat_penerima);
        editText_by_pengirim=findViewById(R.id.et_book_in_by_nama_pengirim);
        editText_by_penerima=findViewById(R.id.et_book_in_by_nama_penerima);
        editText_by_jenis_barang=findViewById(R.id.et_book_in_by_jenis_barang);
        editText_by_berat_brg=findViewById(R.id.et_book_in_by_berat_kg);

        textView_btn_kirim_booking=findViewById(R.id.tv_book_in_by_btn_order_bagasi);

    }
}