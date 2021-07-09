package com.example.movieapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class adapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;

    private List<nowPlayingMovie> results;

    private NavController navController;

    public adapter (Context c, List<nowPlayingMovie> data, NavController navC){
        context=c;
        results=data;
        navController=navC;
    }

    public void addResults(List<nowPlayingMovie> list){
        results.addAll(list);
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        final nowPlayingMovie movie= results.get(position);
        holder.getTitle().setText(movie.getTitle());
        holder.getAverageRating().setText(String.format(movie.getVote_average().toString()));
        holder.getReleaseDate().setText(movie.getRelease_date());
        Glide.with(context).load("https://image.tmdb.org/t/p/original/"+movie.getPoster_path()).into(holder.getPoster());

        holder.getRelativeLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("movieId", String.valueOf(movie.getId()));
                navController.navigate(R.id.action_nowPlayingFragment_to_movieDetailsFragment,bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
