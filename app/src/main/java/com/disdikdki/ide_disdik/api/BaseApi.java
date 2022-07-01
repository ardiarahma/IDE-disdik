package com.disdikdki.ide_disdik.api;

import com.disdikdki.ide_disdik.model.ListSekolahResponse;
import com.disdikdki.ide_disdik.model.PejabatResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BaseApi {

    @FormUrlEncoded
    @POST("chart/data")
    Call<ListSekolahResponse> getAllSchool(
            @Field("csrf_token") String token,
            @Field("form_data") String form_data
    );

    @Headers("Content-Type: application/json")
    @POST("pejabat")
    Call<PejabatResponse> getPejabat(
            @Body String periode_id
    );

}
