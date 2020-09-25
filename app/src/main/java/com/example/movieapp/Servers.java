package com.example.movieapp;

import com.example.movieapp.interfacescall.ApiCalling;
import com.example.movieapp.models.ModelForActors;
import com.example.movieapp.models.ModelForDetailMovie;
import com.example.movieapp.models.ModelForHome;
import com.example.movieapp.models.ModelForRecommendation;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servers {
    private  static final String URL_BASE="https://api.themoviedb.org/3/";
    private ApiCalling apiCalling;
    private static Servers SERVICES;


    public Servers() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiCalling = retrofit.create(ApiCalling.class);
    }

    public static Servers getSERVICES() {
        if (null == SERVICES){
            SERVICES = new Servers();
        }
        return SERVICES;
    }

    public Call<ModelForHome> getPopular(){
        return apiCalling.getPopularMovie();
    }

    public Call<ModelForDetailMovie> getDetailMovie(int movieId){return  apiCalling.getDetailMovie(movieId);}

    public Call<ModelForRecommendation> getMovieRecommendation(int movieIdRecommend){return apiCalling.getModelRecommendations(movieIdRecommend);}

    public Call<ModelForActors> getActors(int movieId){return apiCalling.getActors(movieId);}

}
