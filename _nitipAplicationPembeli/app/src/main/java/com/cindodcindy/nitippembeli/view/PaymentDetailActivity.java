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

    private TextView textView_phone_penerima;

    private TextView textView_phone_pengirim;

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

        //phone

        textView_phone_penerima=findViewById(R.id.tv_by_pay_det_phone_penerima_brg);
        textView_phone_pengirim=findViewById(R.id.tv_by_pay_det_phone_pengirim);

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

    public void GetDataPayment(){

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

            textView_sl_nama_penerima.setText(bundle.getString("namaAkun"));
            textView_sl_jumlah_uang.setText(bundle.getString("UangSejumlah"));
            textView_sl_tgl_tf.setText(bundle.getString("tglTfPengirim"));
            textView_sl_nama_bank.setText(bundle.getString("BankPengirim"));

            textView_by_nama_penerima.setText(bundle.getString("namaAkun"));
            textView_by_jumlah_uang.setText(bundle.getString("jumlahBayar"));
            textView_by_tgl_tf.setText(bundle.getString("waktubayar"));
            textView_by_nama_bank.setText(bundle.getString("jenisBank"));

            textView_phone_penerima.setText(bundle.getString("phonePenerima"));
            textView_phone_pengirim.setText(bundle.getString("phonePengirim"));


        }


        }
}