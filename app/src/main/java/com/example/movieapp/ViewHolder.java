package com.example.movieapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{

    private ImageView poster;

    private TextView title;

    private TextView releaseDate;

    private TextView averageRating;

    private RelativeLayout relativeLayout;

    private TextView id;

    public ViewHolder(View itemView) {

        super(itemView);

        poster= (ImageView)itemView.findViewById(R.id.NPMPoster);
        title= (TextView)itemView.findViewById(R.id.NPMTitle);
        releaseDate= (TextView)itemView.findViewById(R.id.NPMReleaseDate);
        averageRating=(TextView)itemView.findViewById(R.id.NPMAverageRating);
        relativeLayout=(RelativeLayout)itemView.findViewById(R.id.NPMRelativeLayout);
        id= (TextView)itemView.findViewById(R.id.NPMID);


    }
    //Setters
    public void setPoster(ImageView poster) {
        this.poster = poster;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public void setReleaseDate(TextView releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAverageRating(TextView averageRating) {
        this.averageRating = averageRating;
    }

    public void setRelativeLayout(RelativeLayout relativeLayout) {
        this.relativeLayout = relativeLayout;
    }

    public void setId(TextView id) {
        this.id = id;
    }

    //Getters
    public ImageView getPoster() {
        return poster;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getReleaseDate() {
        return releaseDate;
    }

    public TextView getAverageRating() {
        return averageRating;
    }

    public RelativeLayout getRelativeLayout() {
        return relativeLayout;
    }

    public TextView getId() {
        return id;
    }
}
