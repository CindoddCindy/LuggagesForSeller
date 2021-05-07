package com.cindodcindy.nitippembeli.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cindodcindy.nitippembeli.R;
import com.cindodcindy.nitippembeli.model.pojo_payments.pojo_post_payments.NitipPostPaymentRespon;
import com.cindodcindy.nitippembeli.retrofit.MethodsFactory;
import com.cindodcindy.nitippembeli.retrofit.RetrofitHandle;
import com.cindodcindy.nitippembeli.shared_pref.SpHandle;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentDirectActivity extends AppCompatActivity {

    //data jasa
    private TextView textView_asal, textView_tujuan, textView_date_going, textView_date_arive,
            textView_time_going, textView_time_arrive, textView_nama_penjual, textView_harga, textView_jenis_barang, textView_kapasitas;


    //data buyer input
    private EditText editText_by_asal, editText_by_tujuan, editText_by_pengirim, editText_by_penerima, editText_by_jenis_barang, editText_by_berat_brg;

    private SpHandle spHandle;


    //data pay
    private TextView textView_sl_nama_penerima, textView_sl_no_rek, textView_sl_nama_bank, textView_sl_jumlah_harga,
            textView_sl_waktu_kirim;

    private EditText editText_nama_tf, editText_bank_asal, editText_tgal_tf, editText_jumlah_uang_bayar_bagasi;

    private EditText editText_phone_penerima, editText_phone_pengirim;

    private TextView textView_btn_kirim_data_bayar_bagasi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_direct);

        //data jasa

        textView_asal=findViewById(R.id.tv_dir_pay_in_lugg_asal);
        textView_tujuan=findViewById(R.id.tv_dir_pay_in_lugg_tujuan);
        textView_date_going=findViewById(R.id.tv_dir_pay_in_lugg_tgal_going);
        textView_date_arive=findViewById(R.id.tv_dir_pay_in_lugg_tgal_arr);
        textView_time_going=findViewById(R.id.tv_dir_pay_in_lugg_time_going);
        textView_time_arrive=findViewById(R.id.tv_dir_pay_in_lugg_time_arr);
        textView_nama_penjual=findViewById(R.id.tv_dir_pay_in_lugg_nama_seller);
        textView_harga=findViewById(R.id.tv_dir_pay_in_lugg_price);
        textView_jenis_barang=findViewById(R.id.tv_dir_pay_in_lugg_price);
        textView_kapasitas=findViewById(R.id.tv_dir_pay_in_lugg_height);

        //data pembeli

        spHandle=new SpHandle(PaymentDirectActivity.this);

        editText_by_asal=findViewById(R.id.et_dir_pay_book_in_by_alamat_pengirim);
        editText_by_tujuan=findViewById(R.id.et_dir_pay_book_in_by_alamat_penerima);
        editText_by_pengirim=findViewById(R.id.et_dir_pay_in_by_nama_pengirim);
        editText_by_penerima=findViewById(R.id.et_dir_pay_book_in_by_nama_penerima);
        editText_by_jenis_barang=findViewById(R.id.et_dir_pay_book_in_by_jenis_barang);
        editText_by_berat_brg=findViewById(R.id.et_dir_pay_book_in_by_berat_kg);
        editText_phone_penerima=findViewById(R.id.et_dir_pay_book_in_by_phone_penerima);
        editText_by_pengirim=findViewById(R.id.et_dir_pay_book_in_by_phone_pengirim);
        //data_bayar jasa bagasai

        textView_sl_nama_penerima=findViewById(R.id.tv_dir_pay_in_tf_nama_akun_penerima);
        textView_sl_no_rek=findViewById(R.id.tv_dir_pay_in_tf_in_no_rek);
        textView_sl_nama_bank=findViewById(R.id.tv_dir_pay_in_tf_nama_bank);
        textView_sl_jumlah_harga=findViewById(R.id.tv_dir_pay_in_tf_jumlah_uang);

        textView_sl_waktu_kirim=findViewById(R.id.tv_pay_in_tf_waktu_bayar);

        //data pembayar

        editText_nama_tf=findViewById(R.id.et_dir_pay_in_by_tf_nama_pengirim);
        editText_bank_asal=findViewById(R.id.et_dir_pay_in_by_tf_bank_asal);
        editText_tgal_tf=findViewById(R.id.et_pay_in_by_tf_tgal_tf);
        editText_jumlah_uang_bayar_bagasi=findViewById(R.id.et_dir_pay_in_by_tf_jumlah_uang);

        textView_btn_kirim_data_bayar_bagasi=findViewById(R.id.tv_dir_pay_in_btn_bayar);

        textView_btn_kirim_data_bayar_bagasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_by_asal.getText().toString().isEmpty()&&editText_by_tujuan.getText().toString().isEmpty()&&
                        editText_by_pengirim.getText().toString().isEmpty()&&editText_by_penerima.getText().toString().isEmpty()
                        &&editText_by_jenis_barang.getText().toString().isEmpty()&&editText_by_berat_brg.getText().toString().isEmpty()&&
                editText_nama_tf.getText().toString().isEmpty()&&editText_bank_asal.getText().toString().isEmpty()&& editText_tgal_tf.getText().toString().isEmpty()&&editText_jumlah_uang_bayar_bagasi.getText().toString().isEmpty()

                ){
                    editText_by_asal.setError("nama belum diisi");
                    editText_by_tujuan.setError("email belum diisi");
                    editText_by_pengirim.setError("nomor telepon belum diisi");
                    editText_by_penerima.setError("password belum diisi");
                    editText_by_jenis_barang.setError("nomor telepon belum diisi");
                    editText_by_berat_brg.setError("password belum diisi");
                    editText_nama_tf.setError("Field Kosong");
                    editText_bank_asal.setError("Field Kosong");
                    editText_tgal_tf.setError("Field Kosong");
                    editText_jumlah_uang_bayar_bagasi.setError("Field Kosong");




                }else {



                }

            }
        });

    }

    public  void getDataLuggageAv(){
        if(getIntent().getExtras()!=null){
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
            textView_harga.setText(bundle.getString("kapasitas"));
            textView_kapasitas.setText(bundle.getString("jenisbarang"));
            textView_jenis_barang.setText(bundle.getString("harga"));



        }
    }

    public void paymentDirect(){

        String asalBy =  editText_by_asal.getText().toString();
        String tujuanBy = editText_by_tujuan.getText().toString();
        String pengirimBy = editText_by_pengirim.getText().toString();
        String penerimaBy = editText_by_penerima.getText().toString();
        String jenisBarangby = editText_by_jenis_barang.getText().toString();
        String beratbarangby = editText_by_berat_brg.getText().toString();


        String tfNamaPengirim=editText_nama_tf.getText().toString();
        String tfBankPengirim=editText_bank_asal.getText().toString();
        String tfTanggalUangKirim=editText_tgal_tf.getText().toString();
        String tfJumlhaUangKirim=editText_jumlah_uang_bayar_bagasi.getText().toString();

        String tfNamaPenerima=textView_sl_nama_penerima.getText().toString();
        String tfNorekPenerima=textView_sl_no_rek.getText().toString();
        String tfBankPenerima=textView_sl_nama_bank.getText().toString();
        String tfJumlhaPenerima=textView_sl_jumlah_harga.getText().toString();
        String tfWaktuBayarPenerima=textView_sl_waktu_kirim.getText().toString();



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

        jsonObject.addProperty("namaPenerimUang",tfNamaPenerima );
        jsonObject.addProperty("noRekPenerimaUang",tfNorekPenerima);
        jsonObject.addProperty("bankPenerimaUang", tfBankPenerima);
        jsonObject.addProperty("jumlahTfPenerimaUang",tfJumlhaPenerima );
        jsonObject.addProperty("waktuPenerimaUang", tfWaktuBayarPenerima);



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
        Call<NitipPostPaymentRespon> postPaymentResponCall= methodsFactory.sendPaymentToAdmin(idBuyer,jsonObject);
        postPaymentResponCall.enqueue(new Callback<NitipPostPaymentRespon>() {
            @Override
            public void onResponse(Call<NitipPostPaymentRespon> call, Response<NitipPostPaymentRespon> response) {
                if(response.isSuccessful()){



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(PaymentDirectActivity.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(PaymentDirectActivity.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(PaymentDirectActivity.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(PaymentDirectActivity.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<NitipPostPaymentRespon> call, Throwable t) {
                Toast.makeText(PaymentDirectActivity.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });



    }
}