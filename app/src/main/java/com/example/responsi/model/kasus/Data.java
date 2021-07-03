package com.example.responsi.model.kasus;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("content")
	private ArrayList<ContentItem> content;

	public Metadata getMetadata(){
		return metadata;
	}

	public ArrayList<ContentItem> getContent(){
		return content;
	}
}