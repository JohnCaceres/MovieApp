package com.example.movieapp;

import com.google.gson.annotations.SerializedName;

public class nowPlayingMovie {

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("vote_average")
    private Double vote_average;

    public String getRelease_date() {
        return release_date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public String getPoster_path() { return poster_path; }

}
