package com.cindodcindy.nitippembeli.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cindodcindy.nitippembeli.R;
import com.cindodcindy.nitippembeli.model.pojo_booking.pojo_post_booking.NitipPostBooking;
import com.cindodcindy.nitippembeli.model.pojo_regis_login.pojo_regis.NitipRegisRespon;
import com.cindodcindy.nitippembeli.retrofit.MethodsFactory;
import com.cindodcindy.nitippembeli.retrofit.RetrofitHandle;
import com.cindodcindy.nitippembeli.shared_pref.SpHandle;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputBookingActivity extends AppCompatActivity {

    //data jasa
    private TextView textView_asal, textView_tujuan, textView_date_going, textView_date_arive,
            textView_time_going, textView_time_arrive, textView_nama_penjual, textView_harga, textView_jenis_barang, textView_kapasitas;

    //data buyer

    private EditText editText_by_asal, editText_by_tujuan, editText_by_pengirim, editText_by_penerima, editText_by_jenis_barang, editText_by_berat_brg;



    //btn

    private  TextView textView_btn_kirim_booking;

    private SpHandle spHandle;


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

        spHandle=new SpHandle(InputBookingActivity.this);

        textView_btn_kirim_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText_by_asal.getText().toString().isEmpty()&&editText_by_tujuan.getText().toString().isEmpty()&&
                        editText_by_pengirim.getText().toString().isEmpty()&&editText_by_penerima.getText().toString().isEmpty()
                        &&editText_by_jenis_barang.getText().toString().isEmpty()&&editText_by_berat_brg.getText().toString().isEmpty()){
                    editText_by_asal.setError("nama belum diisi");
                    editText_by_tujuan.setError("email belum diisi");
                    editText_by_pengirim.setError("nomor telepon belum diisi");
                    editText_by_penerima.setError("password belum diisi");
                    editText_by_jenis_barang.setError("nomor telepon belum diisi");
                    editText_by_berat_brg.setError("password belum diisi");



                }else {



                }

            }
        });

    }

    public void getDataLuggage(){

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

    public void sendMyBookingToMe(){

        String asalBy = editText_by_asal.getText().toString();
        String tujuanBy = editText_by_tujuan.getText().toString();
        String pengirimBy = editText_by_pengirim.getText().toString();
        String penerimaBy = editText_by_penerima.getText().toString();
        String jenisBarangby = editText_by_jenis_barang.getText().toString();
        String beratbarangby = editText_by_berat_brg.getText().toString();

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
        jsonObject.addProperty("id_buyer", idBuyer);
        jsonObject.addProperty("id_seller",idSeller);





        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<NitipPostBooking> postBookingCall= methodsFactory.sendBookingToMe(idBuyer,jsonObject);
        postBookingCall.enqueue(new Callback<NitipPostBooking>() {
            @Override
            public void onResponse(Call<NitipPostBooking> call, Response<NitipPostBooking> response) {
                if(response.isSuccessful()){



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(InputBookingActivity.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(InputBookingActivity.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(InputBookingActivity.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(InputBookingActivity.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<NitipPostBooking> call, Throwable t) {
                Toast.makeText(InputBookingActivity.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });




    }


    public void sendMyBookingToSeller(){

        String asalBy = editText_by_asal.getText().toString();
        String tujuanBy = editText_by_tujuan.getText().toString();
        String pengirimBy = editText_by_pengirim.getText().toString();
        String penerimaBy = editText_by_penerima.getText().toString();
        String jenisBarangby = editText_by_jenis_barang.getText().toString();
        String beratbarangby = editText_by_berat_brg.getText().toString();

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
        jsonObject.addProperty("id_buyer", idBuyer);
        jsonObject.addProperty("id_seller",idSeller);





        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<NitipPostBooking> postBookingCall= methodsFactory.sendBookingToSeller(idBuyer,jsonObject);
        postBookingCall.enqueue(new Callback<NitipPostBooking>() {
            @Override
            public void onResponse(Call<NitipPostBooking> call, Response<NitipPostBooking> response) {
                if(response.isSuccessful()){



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(InputBookingActivity.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(InputBookingActivity.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(InputBookingActivity.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(InputBookingActivity.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<NitipPostBooking> call, Throwable t) {
                Toast.makeText(InputBookingActivity.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });





    }

    public void sendBooking(){
        sendMyBookingToMe();
        sendMyBookingToSeller();
    }
}