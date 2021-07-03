package com.example.responsi.service;



import com.example.responsi.model.rs.RsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RsRepository {
    @GET("sebaran_v2/jabar/faskes")
    Call<RsResponse> getRsResponse();
}
