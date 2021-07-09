package com.example.movieapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface nowPlayingAPI {

    @GET ("now_playing?api_key=42ff13d9febcf04828b126663e236995&language=es-MX")
    Call<nowPlayingResponse> getResults(@Query("page")String pageNum);


}
