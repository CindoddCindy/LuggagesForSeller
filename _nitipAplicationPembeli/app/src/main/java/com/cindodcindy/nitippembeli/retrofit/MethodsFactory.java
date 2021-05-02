package com.cindodcindy.nitippembeli.retrofit;

import com.cindodcindy.nitippembeli.model.pojo_booking.pojo_get_booking.NitipGetBookingRespon;
import com.cindodcindy.nitippembeli.model.pojo_booking.pojo_post_booking.NitipPostBooking;
import com.cindodcindy.nitippembeli.model.pojo_jasa.pojo_get_jasa.NitipGetAllLuggageAscRespon;
import com.cindodcindy.nitippembeli.model.pojo_konfirm.pojo_get_konfirm.NitipGetConfirmRespon;
import com.cindodcindy.nitippembeli.model.pojo_payments.pojo_post_payments.NitipPostPaymentRespon;
import com.cindodcindy.nitippembeli.model.pojo_regis_login.pojo_login.NitipLoginRespon;
import com.cindodcindy.nitippembeli.model.pojo_regis_login.pojo_regis.NitipRegisRespon;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MethodsFactory {

    @Headers({
            "Content-Type:application/json"
    })
    @POST("auth/registration")
    Call<NitipRegisRespon> buyersRegistration(@Body JsonObject body);

    @Headers({
            "Content-Type:application/json"
    })
    @POST("auth/login")
    Call<NitipLoginRespon> buyerLogin(@Body JsonObject body);

    @Headers({
            "Content-Type:application/json"
    })
    @POST("/booking/users/{userId}/bookings")
    Call<NitipPostBooking> sendBookingToMe(@Path("userId") Long user_id, @Body JsonObject body);


    @Headers({
            "Content-Type:application/json"
    })
    @POST("/booking/users/{userId}/bookings")
    Call<NitipPostBooking> sendBookingToSeller(@Path("userId") Long user_id, @Body JsonObject body);

    @Headers({
            "Content-Type:application/json"
    })
    @GET("luggages/get/all/luggages")
    Call<NitipGetAllLuggageAscRespon> buyerGetAscLuggage();

    @Headers({
            "Content-Type:application/json"
    })
    @GET("booking/users/{userId}/bookings")
    Call<NitipGetBookingRespon> buyerGetOwnBookingList(@Path("userId") Long user_id);


    @Headers({
            "Content-Type:application/json"
    })
    @GET("confirmation/users/{userId}/confirmations")
    Call<NitipGetConfirmRespon> buyerGetConfirmList(@Path("userId") Long user_id);

    @Headers({
            "Content-Type:application/json"
    })
    @POST("payment/users/{userId}/payments")
    Call<NitipPostPaymentRespon> sendPaymentToSeller(@Path("userId") Long user_id, @Body JsonObject body);

    @Headers({
            "Content-Type:application/json"
    })
    @POST("payment/users/{userId}/payments")
    Call<NitipPostPaymentRespon> sendPaymentToMe(@Path("userId") Long user_id, @Body JsonObject body);

    @Headers({
            "Content-Type:application/json"
    })
    @GET("payment/users/{userId}/payments")
    Call<NitipGetPaymentRespon> buyerGetPaymentsList(@Path("userId") Long user_id);




}
