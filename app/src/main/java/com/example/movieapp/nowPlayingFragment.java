package com.example.movieapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class nowPlayingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Context context= this.getContext();
        View view= inflater.inflate(R.layout.now_playing_list,
                container, false);

        RecyclerView recyclerView = view.findViewById(R.id.NPMRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        nowPlayingAPI npApi= retrofit.create(nowPlayingAPI.class);
        Call call= npApi.getResults("1");

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(!response.isSuccessful()){
                    Toast.makeText(context,"Response unsuccessful",Toast.LENGTH_LONG).show();

                    return;
                }

                nowPlayingResponse npResponse= (nowPlayingResponse)response.body();
                adapter adp= new adapter(context,npResponse.getResults(), Navigation.findNavController(view));
                if(npResponse.getTotal_pages()>1){
                    for(int i=2; i<=npResponse.getTotal_pages();i++){
                        call= npApi.getResults(String.valueOf(i));
                        call.enqueue(new Callback() {
                            @Override
                            public void onResponse(Call call, Response response1) {
                                if(!response.isSuccessful()){
                                    Toast.makeText(context,"Response unsuccessful during loop",Toast.LENGTH_LONG).show();

                                    return;
                                }
                                nowPlayingResponse npr=(nowPlayingResponse)response1.body();
                                adp.addResults(npr.getResults());


                            }

                            @Override
                            public void onFailure(Call call, Throwable t) {
                                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();

                            }
                        });
                    }

                }


                recyclerView.setAdapter(adp);



            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });




        return view;
    }


}
