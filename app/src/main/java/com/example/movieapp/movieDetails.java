package com.example.movieapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class movieDetails {

    @SerializedName("genres")
    private List<genre> genres;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("title")
    private String title;

    @SerializedName("runtime")
    private int runtime;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("vote_average")
    private Double vote_average;

    @SerializedName("overview")
    private String overview;

    public List<genre> getGenres() {
        return genres;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getTitle() {
        return title;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }
}
