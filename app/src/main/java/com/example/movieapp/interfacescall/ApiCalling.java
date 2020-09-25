package com.example.movieapp.interfacescall;

import com.example.movieapp.models.ModelForActors;
import com.example.movieapp.models.ModelForDetailMovie;
import com.example.movieapp.models.ModelForHome;
import com.example.movieapp.models.ModelForRecommendation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCalling {

    //Get Movie Popular
    @GET("movie/popular?api_key=7ca11e2b62de055509e9b58e13b6dcd5&language=en-US")
    public Call<ModelForHome> getPopularMovie();

    //Get Movie Details
    @GET("movie/{movie_id}?api_key=7ca11e2b62de055509e9b58e13b6dcd5&language=en-US")
    public  Call<ModelForDetailMovie> getDetailMovie(@Path("movie_id") int movieId);

    //Get Movie Recommendations
    @GET("movie/{movie_id}/recommendations?api_key=7ca11e2b62de055509e9b58e13b6dcd5&language=en-US&page=1")
    public  Call<ModelForRecommendation> getModelRecommendations(@Path("movie_id") int movieId);

    @GET("movie/{movie_id}/credits?api_key=7ca11e2b62de055509e9b58e13b6dcd5")
    public Call<ModelForActors> getActors(@Path("movie_Id") int movieId);



}
