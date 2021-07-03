package com.example.responsi.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.responsi.model.rs.RsItem;
import com.example.responsi.model.rs.RsResponse;
import com.example.responsi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RsViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<RsItem>> rsDataItem = new MutableLiveData<>();

    public void setRsData(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiRs().getRsResponse().enqueue(new Callback<RsResponse>() {
            @Override
            public void onResponse(Call<RsResponse> call, Response<RsResponse> response) {
                RsResponse rsResponse  = response.body();
                if (rsResponse != null){
                    ArrayList<RsItem> rsItems = rsResponse.getData();
                    rsDataItem.postValue(rsItems);
                }
            }

            @Override
            public void onFailure(Call<RsResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<RsItem>> getRsItem(){
        return rsDataItem;
    }
}
