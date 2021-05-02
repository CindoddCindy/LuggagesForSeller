package com.cindodcindy.nitippembeli.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cindodcindy.nitippembeli.R;
import com.cindodcindy.nitippembeli.model.pojo_booking.pojo_post_booking.NitipPostBooking;
import com.cindodcindy.nitippembeli.model.pojo_payments.pojo_post_payments.NitipPostPaymentRespon;
import com.cindodcindy.nitippembeli.retrofit.MethodsFactory;
import com.cindodcindy.nitippembeli.retrofit.RetrofitHandle;
import com.cindodcindy.nitippembeli.shared_pref.SpHandle;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputPaymentActivity extends AppCompatActivity {

    private SpHandle spHandle;

    //data jasa
    private TextView textView_asal, textView_tujuan, textView_date_going, textView_date_arive,
            textView_time_going, textView_time_arrive, textView_nama_penjual, textView_harga, textView_jenis_barang, textView_kapasitas;


    //data buyer

    private TextView textView_by_asal, textView_by_tujuan, textView_by_pengirim, textView_by_penerima, textView_by_jenis_barang, textView_by_berat_brg;

    //data pay
    private TextView textView_sl_nama_penerima, textView_sl_no_rek, textView_sl_nama_bank, textView_sl_jumlah_harga,
            textView_sl_waktu_kirim;

    private EditText editText_nama_tf, editText_bank_asal, editText_tgal_tf, editText_jumlah_uang_bayar_bagasi,
    editText_phone_pengirim, editText_phone_penerima;


    private TextView textView_btn_kirim_data_bayar_bagasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_payment);

        spHandle=new SpHandle(InputPaymentActivity.this);

        //data jasa

        textView_asal=findViewById(R.id.tv_pay_in_lugg_asal);
        textView_tujuan=findViewById(R.id.tv_pay_in_lugg_tujuan);
        textView_date_going=findViewById(R.id.tv_pay_in_lugg_tgal_going);
        textView_date_arive=findViewById(R.id.tv_pay_in_lugg_tgal_arr);
        textView_time_going=findViewById(R.id.tv_pay_in_lugg_time_going);
        textView_time_arrive=findViewById(R.id.tv_pay_in_lugg_time_arr);
        textView_nama_penjual=findViewById(R.id.tv_pay_in_lugg_nama_seller);
        textView_harga=findViewById(R.id.tv_pay_in_lugg_price);
        textView_jenis_barang=findViewById(R.id.tv_pay_in_lugg_price);
        textView_kapasitas=findViewById(R.id.tv_pay_in_lugg_height);

        //data pembeli

        textView_by_asal=findViewById(R.id.tv_pay_in_by_asal);
        textView_by_tujuan=findViewById(R.id.tv_pay_in_by_tujuan);
        textView_by_pengirim=findViewById(R.id.tv_pay_in_by_pengirim);
        textView_by_penerima=findViewById(R.id.tv_pay_in_by_penerima);
        textView_by_jenis_barang=findViewById(R.id.tv_pay_in_by_jenis_barang);
        textView_by_berat_brg=findViewById(R.id.tv_pay_in_by_berat_barang);

        //data_bayar jasa bagasai

        textView_sl_nama_penerima=findViewById(R.id.tv_pay_in_tf_nama_akun_penerima);
        textView_sl_no_rek=findViewById(R.id.tv_pay_in_tf_in_no_rek);
        textView_sl_nama_bank=findViewById(R.id.tv_pay_in_tf_nama_bank);
        textView_sl_jumlah_harga=findViewById(R.id.tv_pay_in_tf_jumlah_uang);

        textView_sl_waktu_kirim=findViewById(R.id.tv_pay_in_tf_waktu_bayar);

        //data pembayar

        editText_nama_tf=findViewById(R.id.et_pay_in_by_tf_nama_pengirim);
        editText_bank_asal=findViewById(R.id.et_pay_in_by_tf_bank_asal);
        editText_tgal_tf=findViewById(R.id.et_pay_in_by_tf_tgal_tf);
        editText_jumlah_uang_bayar_bagasi=findViewById(R.id.et_pay_in_by_tf_jumlah_uang);

        editText_phone_penerima=findViewById(R.id.et_pay_in_by_tf_phone_penerima_brg);
        editText_phone_pengirim=findViewById(R.id.et_pay_in_by_tf_phone_pengguna_brg);

        textView_btn_kirim_data_bayar_bagasi=findViewById(R.id.tv_pay_in_btn_bayar);

        textView_btn_kirim_data_bayar_bagasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText_nama_tf.getText().toString().isEmpty()&&editText_bank_asal.getText().toString().isEmpty()&& editText_tgal_tf.getText().toString().isEmpty()&&editText_jumlah_uang_bayar_bagasi.getText().toString().isEmpty()){
                    editText_nama_tf.setError("Field Kosaong");
                    editText_bank_asal.setError("Field Kosaong");
                    editText_tgal_tf.setError("Field Kosaong");
                    editText_jumlah_uang_bayar_bagasi.setError("Field Kosaong");




                }else {



                }
            }
        });

    }

    public void getPyamentFromConfirmDetail(){

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

            textView_sl_waktu_kirim.setText(bundle.getString("waktubayar"));




        }


    }

    public void sendPaymentToMe(){

        String asalBy = textView_by_asal.getText().toString();
        String tujuanBy = textView_by_tujuan.getText().toString();
        String pengirimBy = textView_by_pengirim.getText().toString();
        String penerimaBy = textView_by_penerima.getText().toString();
        String jenisBarangby = textView_by_jenis_barang.getText().toString();
        String beratbarangby = textView_by_berat_brg.getText().toString();

        String tfNamaPengirim=editText_nama_tf.getText().toString();
        String tfBankPengirim=editText_bank_asal.getText().toString();
        String tfTanggalUangKirim=editText_tgal_tf.getText().toString();
        String tfJumlhaUangKirim=editText_jumlah_uang_bayar_bagasi.getText().toString();

        String tfPhonePhonePenerima=editText_phone_penerima.getText().toString();
        String tfPhonePengirim=editText_phone_pengirim.getText().toString();

        Long idSeller=spHandle.getIdSeller();
        Long idBuyer=spHandle.getIdBuyer();

        //data jasa
        String asalSl = textView_asal.getText().toString();
        String tujuanSl  = textView_tujuan.getText().toString();
        String tgalGoSl =  textView_date_going.getText().toString();
        String tgalArrSl =  textView_date_arive.getText().toString();
        String timeGoSl =  textView_time_going.getText().toString();
        String timeArrSl = textView_time_arrive.getText().toString();
        String namaPenjualSl  =  textView_nama_penjual.getText().toString();
        String hargaSl  =  textView_harga.getText().toString();
        String jenisBarangsl  = textView_jenis_barang.getText().toString();
        String kapasitasSl =  textView_kapasitas.getText().toString();




        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("namaPengirimUang", tfNamaPengirim);
        jsonObject.addProperty("bankPengirimUang",tfBankPengirim);
        jsonObject.addProperty("tanggalTransfer", tfTanggalUangKirim);
        jsonObject.addProperty("uangSejumlah", tfJumlhaUangKirim);
        jsonObject.addProperty("phonePenerimaBarang", tfPhonePhonePenerima);
        jsonObject.addProperty("phonePengirimBarang", tfPhonePengirim);

        jsonObject.addProperty("idBuyer", idBuyer);
        jsonObject.addProperty("idSeller",idSeller);


        jsonObject.addProperty("namaPembeli",pengirimBy );
        jsonObject.addProperty("alamatPembeli",asalBy);
        jsonObject.addProperty("alamatPenerima",tujuanBy );
        jsonObject.addProperty("namaPenerima",penerimaBy );
        jsonObject.addProperty("jenisBarangKirim",jenisBarangby );
        jsonObject.addProperty("kapasitasBarang",beratbarangby );

        jsonObject.addProperty("namaPenjual",namaPenjualSl );
        jsonObject.addProperty("asal",asalSl );
        jsonObject.addProperty("tujuan",tujuanSl );
        jsonObject.addProperty("tanggalBerangkat",tgalGoSl );
        jsonObject.addProperty("jamBerangkat",timeGoSl );
        jsonObject.addProperty("tanggalTiba",tgalArrSl);
        jsonObject.addProperty("jamTiba", timeArrSl);
        jsonObject.addProperty("kapasitas",kapasitasSl);
        jsonObject.addProperty("jenisBarang", jenisBarangsl);
        jsonObject.addProperty("hargaBagasi", hargaSl);





        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<NitipPostPaymentRespon> postPaymentResponCall= methodsFactory.sendPaymentToMe(idBuyer,jsonObject);
        postPaymentResponCall.enqueue(new Callback<NitipPostPaymentRespon>() {
            @Override
            public void onResponse(Call<NitipPostPaymentRespon> call, Response<NitipPostPaymentRespon> response) {
                if(response.isSuccessful()){



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(InputPaymentActivity.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(InputPaymentActivity.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(InputPaymentActivity.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(InputPaymentActivity.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<NitipPostPaymentRespon> call, Throwable t) {
                Toast.makeText(InputPaymentActivity.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });




    }

    public void sendPayemntToAdmin(){

        String asalBy = textView_by_asal.getText().toString();
        String tujuanBy = textView_by_tujuan.getText().toString();
        String pengirimBy = textView_by_pengirim.getText().toString();
        String penerimaBy = textView_by_penerima.getText().toString();
        String jenisBarangby = textView_by_jenis_barang.getText().toString();
        String beratbarangby = textView_by_berat_brg.getText().toString();

        String tfNamaPengirim=editText_nama_tf.getText().toString();
        String tfBankPengirim=editText_bank_asal.getText().toString();
        String tfTanggalUangKirim=editText_tgal_tf.getText().toString();
        String tfJumlhaUangKirim=editText_jumlah_uang_bayar_bagasi.getText().toString();

        String tfPhonePhonePenerima=editText_phone_penerima.getText().toString();
        String tfPhonePengirim=editText_phone_pengirim.getText().toString();

        Long idSeller=spHandle.getIdSeller();
        Long idBuyer=spHandle.getIdBuyer();

        //data jasa
        String asalSl = textView_asal.getText().toString();
        String tujuanSl  = textView_tujuan.getText().toString();
        String tgalGoSl =  textView_date_going.getText().toString();
        String tgalArrSl =  textView_date_arive.getText().toString();
        String timeGoSl =  textView_time_going.getText().toString();
        String timeArrSl = textView_time_arrive.getText().toString();
        String namaPenjualSl  =  textView_nama_penjual.getText().toString();
        String hargaSl  =  textView_harga.getText().toString();
        String jenisBarangsl  = textView_jenis_barang.getText().toString();
        String kapasitasSl =  textView_kapasitas.getText().toString();




        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("namaPengirimUang", tfNamaPengirim);
        jsonObject.addProperty("bankPengirimUang",tfBankPengirim);
        jsonObject.addProperty("tanggalTransfer", tfTanggalUangKirim);
        jsonObject.addProperty("uangSejumlah", tfJumlhaUangKirim);
        jsonObject.addProperty("phonePenerimaBarang", tfPhonePhonePenerima);
        jsonObject.addProperty("phonePengirimBarang", tfPhonePengirim);

        jsonObject.addProperty("idBuyer", idBuyer);
        jsonObject.addProperty("idSeller",idSeller);


        jsonObject.addProperty("namaPembeli",pengirimBy );
        jsonObject.addProperty("alamatPembeli",asalBy);
        jsonObject.addProperty("alamatPenerima",tujuanBy );
        jsonObject.addProperty("namaPenerima",penerimaBy );
        jsonObject.addProperty("jenisBarangKirim",jenisBarangby );
        jsonObject.addProperty("kapasitasBarang",beratbarangby );

        jsonObject.addProperty("namaPenjual",namaPenjualSl );
        jsonObject.addProperty("asal",asalSl );
        jsonObject.addProperty("tujuan",tujuanSl );
        jsonObject.addProperty("tanggalBerangkat",tgalGoSl );
        jsonObject.addProperty("jamBerangkat",timeGoSl );
        jsonObject.addProperty("tanggalTiba",tgalArrSl);
        jsonObject.addProperty("jamTiba", timeArrSl);
        jsonObject.addProperty("kapasitas",kapasitasSl);
        jsonObject.addProperty("jenisBarang", jenisBarangsl);
        jsonObject.addProperty("hargaBagasi", hargaSl);





        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<NitipPostPaymentRespon> postPaymentResponCall= methodsFactory.sendPaymentToMe(idBuyer,jsonObject);
        postPaymentResponCall.enqueue(new Callback<NitipPostPaymentRespon>() {
            @Override
            public void onResponse(Call<NitipPostPaymentRespon> call, Response<NitipPostPaymentRespon> response) {
                if(response.isSuccessful()){



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(InputPaymentActivity.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(InputPaymentActivity.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(InputPaymentActivity.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(InputPaymentActivity.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<NitipPostPaymentRespon> call, Throwable t) {
                Toast.makeText(InputPaymentActivity.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });




    }


}