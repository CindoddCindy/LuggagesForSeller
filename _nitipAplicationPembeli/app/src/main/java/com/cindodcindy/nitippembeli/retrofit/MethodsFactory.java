package com.cindodcindy.nitippembeli.retrofit;

import com.cindodcindy.nitippembeli.model.pojo_jasa.pojo_get_jasa.NitipGetAllLuggageAscRespon;
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
/*
    @Headers({
            "Content-Type:application/json"
    })
    @POST("luggages/users/{userId}/luggages")
    Call<NitipPostLuggageRespon> sellerPostJasa(@Path("userId") Long user_id, @Body JsonObject body);


 */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("luggages/get/all/luggages")
    Call<NitipGetAllLuggageAscRespon> buyerGetAscLuggage();

}
