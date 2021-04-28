package com.cindodcindy.nitippembeli.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cindodcindy.nitippembeli.R;

public class PaymentDetailActivity extends AppCompatActivity {

    //data bayar kepada
    private TextView textView_sl_nama_penerima, textView_sl_jumlah_uang, textView_sl_tgl_tf,textView_sl_nama_bank;

    //data dibayar oleh
    private TextView textView_by_nama_penerima, textView_by_jumlah_uang, textView_by_tgl_tf,textView_by_nama_bank;


    //data jasa
    private TextView textView_asal, textView_tujuan, textView_date_going, textView_date_arive,
            textView_time_going, textView_time_arrive, textView_nama_penjual, textView_harga, textView_jenis_barang, textView_kapasitas;


    //data buyer

    private TextView textView_by_asal, textView_by_tujuan, textView_by_pengirim, textView_by_penerima, textView_by_jenis_barang, textView_by_berat_brg;

//button
    private TextView textView_btn_edit_payment, textView_btn_hapus_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);

        textView_sl_nama_penerima=findViewById(R.id.tv_sl_pay_det_nama_pengirim);
        textView_sl_jumlah_uang=findViewById(R.id.tv_sl_pay_det_jumlah_uang);
        textView_sl_tgl_tf=findViewById(R.id.tv_sl_pay_det_tgal_tf);
        textView_sl_nama_bank=findViewById(R.id.tv_sl_pay_det_nama_bank);

        textView_by_nama_penerima=findViewById(R.id.tv_by_pay_det_nama_pengirim);
        textView_by_jumlah_uang=findViewById(R.id.tv_by_pay_det_harga);
        textView_by_tgl_tf=findViewById(R.id.tv_by_pay_det_tgal_tf);
        textView_by_nama_bank=findViewById(R.id.tv_by_pay_det_nama_bank);

        //data jasa

        textView_asal=findViewById(R.id.id_tv_pay_det_lugg_asal);
        textView_tujuan=findViewById(R.id.tv_pay_det_lugg_tujuan);
        textView_date_going=findViewById(R.id.tv_pay_det_lugg_tgal_going);
        textView_date_arive=findViewById(R.id.tv_pay_det_lugg_tgal_arr);
        textView_time_going=findViewById(R.id.tv_pay_det_lugg_time_going);
        textView_time_arrive=findViewById(R.id.tv_pay_det_lugg_time_arr);
        textView_nama_penjual=findViewById(R.id.tv_pay_det_lugg_nama_seller);
        textView_harga=findViewById(R.id.tv_pay_det_lugg_price);
        textView_jenis_barang=findViewById(R.id.tv_pay_det_lugg_type);
        textView_kapasitas=findViewById(R.id.tv_pay_det_lugg_height);

        //data pembeli

        textView_by_asal=findViewById(R.id.tv_pay_det_asal_by);
        textView_by_tujuan=findViewById(R.id.tv_pay_det_tujuan_by);
        textView_by_pengirim=findViewById(R.id.tv_pay_det_pengirim_by);
        textView_by_penerima=findViewById(R.id.tv_pay_det_penerima_by);
        textView_by_jenis_barang=findViewById(R.id.tv_pay_det_jenis_barang_by);
        textView_by_berat_brg=findViewById(R.id.tv_pay_det_berat_by);

        textView_btn_edit_payment=findViewById(R.id.tv_pay_det_btn_delete);
        textView_btn_edit_payment=findViewById(R.id.tv_btn_pay_det_edit);



    }
}