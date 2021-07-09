package com.example.movieapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class movieDetailsFragment extends Fragment {

    private ImageView backdrop;

    private TextView movieTitle;

    private TextView duration;

    private TextView releaseDate;

    private TextView averageRating;

    private TextView genres;

    private TextView overview;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Context context= this.getContext();
        View view= inflater.inflate(R.layout.movie_detail_screen,
                container, false);

        backdrop= (ImageView)view.findViewById(R.id.movie_Backdrop);
        movieTitle= (TextView)view.findViewById(R.id.movie_Title);
        duration= (TextView)view.findViewById(R.id.duration);
        releaseDate= (TextView)view.findViewById(R.id.releaseDate);
        averageRating= (TextView)view.findViewById(R.id.averageRating);
        genres= (TextView)view.findViewById(R.id.genres);
        overview= (TextView)view.findViewById(R.id.overview);


        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        movieDetailsAPI movieDApi= retrofit.create(movieDetailsAPI.class);

        Call call = movieDApi.getResults(getArguments().getString("movieId"));

        call.enqueue(new Callback(){

            @Override
            public void onResponse(Call call, Response response){
                if(!response.isSuccessful()){
                    movieTitle.setText("Code: "+response.code());

                    return;
                }

                movieDetails movieD= (movieDetails)response.body();

                Glide.with(context).load("https://image.tmdb.org/t/p/original/"+movieD.getBackdrop_path()).into(backdrop);
                movieTitle.setText(movieD.getTitle());
                String durationT= String.valueOf(movieD.getRuntime())+" minutos";
                duration.setText(durationT);
                releaseDate.setText(movieD.getRelease_date());
                averageRating.setText(movieD.getVote_average().toString());
                overview.setText(movieD.getOverview());
                backdrop.setClipToOutline(true);
                for(genre g :movieD.getGenres()){
                    genres.append(g.getName()+"  ");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t){}

        });


        return view;
    }




}
