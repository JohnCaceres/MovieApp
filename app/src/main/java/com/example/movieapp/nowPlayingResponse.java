package com.example.movieapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class nowPlayingResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<nowPlayingMovie> results;

    @SerializedName("total_pages")
    private int total_pages;


    public List<nowPlayingMovie> getResults() {
        return results;
    }

    public int getTotal_pages() {
        return total_pages;
    }
}
