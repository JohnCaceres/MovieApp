package com.example.movieapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface movieDetailsAPI {

    @GET ("{movie_id}?api_key=42ff13d9febcf04828b126663e236995&language=es-MX")
    Call<movieDetails> getResults(@Path(value= "movie_id", encoded = true) String movieId);


}
