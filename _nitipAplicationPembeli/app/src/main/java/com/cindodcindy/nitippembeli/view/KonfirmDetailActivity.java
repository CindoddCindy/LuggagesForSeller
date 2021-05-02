package com.cindodcindy.nitippembeli.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cindodcindy.nitippembeli.R;

public class KonfirmDetailActivity extends AppCompatActivity {
    //data payment
    private TextView textView_sl_nama_penerima, textView_sl_no_rek, textView_sl_nama_bank, textView_sl_jumlah_harga,
            textView_sl_waktu_kirim, textView_lokasi_jemput, textView_jam_jemput, textView_estimasi;
    //btn
    private TextView textView_btn_hapus_konfirm, textView_bayar_jasa;

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
        textView_estimasi=findViewById(R.id.tv_konf_det_estimasi_brg_tiba);


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
        textView_bayar_jasa=findViewById(R.id.tv_konf_det_btn_bayar_jasa);

        textView_bayar_jasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    public  void getConfirmDetail(){

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
            textView_sl_no_rek.setText(bundle.getString("noRek"));
            textView_sl_nama_bank.setText(bundle.getString("jenisBank"));
            textView_sl_jumlah_harga.setText(bundle.getString("jumlahBayar"));
            textView_sl_waktu_kirim.setText(bundle.getString("waktubayar"));
            textView_lokasi_jemput.setText(bundle.getString("lokasiBertemu"));
            textView_jam_jemput.setText(bundle.getString("jamAmbilBrg"));
            textView_estimasi.setText(bundle.getString("estimasisampai"));




        }



    }

    public void konfirmPayLuggage(){
        Bundle bundle = new Bundle();
        //bundle.putLong("id_seller", content.getIdSeller());
        bundle.putString("asal",textView_asal.getText().toString());
        bundle.putString("tujuan",textView_tujuan.getText().toString());
        bundle.putString("tglgo",textView_date_going.getText().toString());
        bundle.putString("tglarr",textView_date_arive.getText().toString());
        bundle.putString("jamgo", textView_time_going.getText().toString());
        bundle.putString("jamarr",textView_time_arrive.getText().toString());
        bundle.putString("namapenjual",textView_nama_penjual.getText().toString());
        bundle.putString("kapasitas",textView_kapasitas.getText().toString());
        bundle.putString("jenisbarang",textView_jenis_barang.getText().toString());
        bundle.putString("harga", textView_harga.getText().toString());

        bundle.putString("asalBr",textView_by_asal.getText().toString());
        bundle.putString("tujuanBr",textView_by_tujuan.getText().toString());
        bundle.putString("pengirim",textView_by_pengirim.getText().toString());
        bundle.putString("penerima",textView_by_penerima.getText().toString());
        bundle.putString("jenisBr", textView_by_jenis_barang.getText().toString());
        bundle.putString("beratBr",textView_by_berat_brg.getText().toString());

        // di komen krn mau bayar ke rek nitip
        //bundle.putString("namaAkun",textView_sl_nama_penerima.getText().toString());
        //bundle.putString("noRek",textView_sl_no_rek.getText().toString());
        //bundle.putString("jenisBank",textView_sl_nama_bank.getText().toString());
        //bundle.putString("jumlahBayar",textView_sl_jumlah_harga.getText().toString());
        bundle.putString("waktubayar", textView_sl_waktu_kirim.getText().toString());

       // bundle.putString("lokasiBertemu", textView_lokasi_jemput.getText().toString());
       // bundle.putString("jamAmbilBrg",textView_jam_jemput.getText().toString());
       // bundle.putString("estimasisampai", textView_estimasi.getText().toString());

        Intent intent = new Intent(KonfirmDetailActivity.this, InputPaymentActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}