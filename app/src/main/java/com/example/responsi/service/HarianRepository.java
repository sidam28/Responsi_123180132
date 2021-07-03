package com.example.responsi.service;



import com.example.responsi.model.kasus.HarianResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HarianRepository {
    @GET("rekapitulasi_v2/jabar/harian")
    Call<HarianResponse> getKasusResponse();
}