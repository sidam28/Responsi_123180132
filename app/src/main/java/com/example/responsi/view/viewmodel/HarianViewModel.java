package com.example.responsi.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.responsi.model.kasus.ContentItem;
import com.example.responsi.model.kasus.Data;
import com.example.responsi.model.kasus.HarianResponse;
import com.example.responsi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HarianViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<ContentItem>> listContent = new MutableLiveData<>();

    public void setKasusData(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiKasus().getKasusResponse().enqueue(new Callback<HarianResponse>() {
            @Override
            public void onResponse(Call<HarianResponse> call, Response<HarianResponse> response) {
                assert response.body() != null;
                Data kasusResponse = response.body().getData();
                if (kasusResponse!=null){
                    ArrayList<ContentItem> contentItems = kasusResponse.getContent();
                    listContent.postValue(contentItems);
                }
            }

            @Override
            public void onFailure(Call<HarianResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<ContentItem>> getKasusContentItem(){
        return listContent;
    }
}
