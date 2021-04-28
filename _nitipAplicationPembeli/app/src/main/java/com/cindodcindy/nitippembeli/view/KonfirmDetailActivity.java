package com.cindodcindy.nitippembeli.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cindodcindy.nitippembeli.R;

public class KonfirmDetailActivity extends AppCompatActivity {
    //data payment
    private TextView textView_sl_nama_penerima, textView_sl_no_rek, textView_sl_nama_bank, textView_sl_jumlah_harga,
            textView_sl_waktu_kirim, textView_lokasi_jemput, textView_jam_jemput;
    //btn
    private TextView textView_btn_hapus_konfirm;

    //data jasa
    private TextView textView_asal, textView_tujuan, textView_date_going, textView_date_arive,
            textView_time_going, textView_time_arrive, textView_nama_penjual, textView_harga, textView_jenis_barang, textView_kapasitas;


    //data buyer

    private TextView textView_by_asal, textView_by_tujuan, textView_by_pengirim, textView_by_penerima, textView_by_jenis_barang, textView_by_berat_brg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirm_detail);

        textView_sl_nama_penerima=findViewById(R.id.tv_konf_det_nama_akun_penerima);
        textView_sl_no_rek=findViewById(R.id.tv_konf_det_no_rek);
        textView_sl_nama_bank=findViewById(R.id.tv_konf_det_nama_bank);
        textView_sl_jumlah_harga=findViewById(R.id.tv_konf_det_jumlah_uang);

        textView_sl_waktu_kirim=findViewById(R.id.tv_konf_det_waktu_bayar);
        textView_lokasi_jemput=findViewById(R.id.tv_konf_det_lok_antar);
        textView_jam_jemput=findViewById(R.id.tv_konf_det_wktu_antar);


        //data jasa

        textView_asal=findViewById(R.id.id_tv_konf_det_lugg_asal);
        textView_tujuan=findViewById(R.id.tv_konf_det_lugg_tujuan);
        textView_date_going=findViewById(R.id.tv_konf_det_lugg_tgal_going);
        textView_date_arive=findViewById(R.id.tv_konf_det_lugg_tgal_arr);
        textView_time_going=findViewById(R.id.tv_konf_det_lugg_time_going);
        textView_time_arrive=findViewById(R.id.tv_konf_det_lugg_time_arr);
        textView_nama_penjual=findViewById(R.id.tv_konf_det_lugg_nama_seller);
        textView_harga=findViewById(R.id.tv_konf_det_lugg_price);
        textView_jenis_barang=findViewById(R.id.tv_konf_det_lugg_price);
        textView_kapasitas=findViewById(R.id.tv_konf_det_lugg_price);

        //data pembeli

        textView_by_asal=findViewById(R.id.tv_konf_det_by_asal);
        textView_by_tujuan=findViewById(R.id.tv_konf_det_by_tujuan);
        textView_by_pengirim=findViewById(R.id.tv_konf_det_by_pengirim);
        textView_by_penerima=findViewById(R.id.tv_konf_det_by_penerima);
        textView_by_jenis_barang=findViewById(R.id.tv_konf_det_by_jenis_barang);
        textView_by_berat_brg=findViewById(R.id.tv_konf_det_by_height);

        textView_btn_hapus_konfirm=findViewById(R.id.tv_konf_det_btn_delete);



    }
}