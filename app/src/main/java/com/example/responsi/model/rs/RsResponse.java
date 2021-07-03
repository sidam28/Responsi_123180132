package com.example.responsi.model.rs;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RsResponse {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<RsItem> data;

	public int getStatusCode(){
		return statusCode;
	}

	public ArrayList<RsItem> getData(){
		return data;
	}
}