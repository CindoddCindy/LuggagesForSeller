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

        //btn

        textView_btn_edit_kirim_booking=findViewById(R.id.tv_book_det_btn_edit_booking);
        textView_btn_hapus_booking=findViewById(R.id.tv_book_det_btn_hapus_booking);
        textView_btn_back_dari_booking=findViewById(R.id.tv_book_det_btn_back);

    }

    public void getDataFromItem(){

        if(getIntent().getExtras()!=null) {
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();

            // spHandle.setSpIdConfirmOrderEdit(SpHandle.SP_ID_CONFIRM_ORDER_EDIT, bundle.getLong("id_customer"));
            //spHandle.setSpIdConfirmOrder(SpHandle.SP_ID_CONFIRM_ORDER,bundle.getLong("id_confirm"));
            textView_asal.setText(bundle.getString("asal"));
            textView_tujuan.setText(bundle.getString("tujuan"));
            textView_date_going.setText(bundle.getString("tglgo"));
            textView_date_arive.setText(bundle.getString("tglarr"));
            textView_time_going.setText(bundle.getString("jamgo"));
            textView_time_arrive.setText(bundle.getString("jamarr"));
            textView_nama_penjual.setText(bundle.getString("namapenjual"));
            textView_harga.setText(bundle.getString("harga"));
            textView_kapasitas.setText(bundle.getString("kapasitas"));
            textView_jenis_barang.setText(bundle.getString("jenisbarang"));

            textView_by_asal.setText(bundle.getString("asalBr"));
            textView_by_tujuan.setText(bundle.getString("tujuanBr"));
            textView_by_pengirim.setText(bundle.getString("pengirim"));
            textView_by_penerima.setText(bundle.getString("penerima"));
            textView_by_jenis_barang.setText(bundle.getString("jenisBr"));
            textView_by_berat_brg.setText(bundle.getString("beratBr"));

        }



    }
}