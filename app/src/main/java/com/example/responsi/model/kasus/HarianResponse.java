package com.example.responsi.model.kasus;

import com.google.gson.annotations.SerializedName;

public class HarianResponse {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private Data data;

	public int getStatusCode(){
		return statusCode;
	}

	public Data getData(){
		return data;
	}
}