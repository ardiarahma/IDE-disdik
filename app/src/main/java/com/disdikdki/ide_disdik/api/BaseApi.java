package com.disdikdki.ide_disdik.api;

import com.disdikdki.ide_disdik.model.RekapResponse;
import com.disdikdki.ide_disdik.model.SekolahBody;
import com.disdikdki.ide_disdik.model.SekolahResponse;
import com.disdikdki.ide_disdik.model.PejabatResponse;
import com.disdikdki.ide_disdik.model.Periode;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BaseApi {

//    @Headers("Content-Type: application/json")
//    @FormUrlEncoded
//    @POST("chart/data")
//    Call<ListSekolahResponse> getAllSchool(
//            @Field("csrf_token") String token,
//            @Field("form_data") String form_data
//    );

    @Headers("Content-Type: application/json")
    @POST("pejabat")
    Call<PejabatResponse> getPejabat(
            @Body() Periode periode_id
    );

    @Headers("Content-Type: application/json")
    @POST("rekap")
    Call<RekapResponse> getRekap();

    //Jakpus
    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPaudJp(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPkbmJp(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSdJp(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSlbJp(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmpJp(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmaJp(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmkJp(
            @Body() SekolahBody sekolahBody
    );

}
