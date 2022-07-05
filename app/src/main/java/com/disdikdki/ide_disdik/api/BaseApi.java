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

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSchool();

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

    //Jakut
    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPaudJu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPkbmJu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSdJu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSlbJu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmpJu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmaJu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmkJu(
            @Body() SekolahBody sekolahBody
    );

    //Jakbar
    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPaudJb(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPkbmJb(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSdJb(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSlbJb(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmpJb(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmaJb(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmkJb(
            @Body() SekolahBody sekolahBody
    );

    //Jaksel
    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPaudJs(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPkbmJs(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSdJs(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSlbJs(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmpJs(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmaJs(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmkJs(
            @Body() SekolahBody sekolahBody
    );

    //Jaktim
    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPaudJt(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPkbmJt(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSdJt(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSlbJt(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmpJt(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmaJt(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmkJt(
            @Body() SekolahBody sekolahBody
    );

    //P1000
    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPaudSeribu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getPkbmSeribu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSdSeribu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSlbSeribu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmpSeribu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmaSeribu(
            @Body() SekolahBody sekolahBody
    );

    @Headers("Content-Type: application/json")
    @POST("sekolah")
    Call<SekolahResponse> getSmkSeribu(
            @Body() SekolahBody sekolahBody
    );

}
