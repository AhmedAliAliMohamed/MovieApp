package com.example.movieapp.ui.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.Servers;
import com.example.movieapp.models.ModelForRecommendation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelForRecommend extends ViewModel {

    public MutableLiveData<ModelForRecommendation> movieRecommendation = new MutableLiveData<>();

    public void getMovieRecommendation(int movieId){
        Servers.getSERVICES().getMovieRecommendation(movieId).enqueue(new Callback<ModelForRecommendation>() {
            @Override
            public void onResponse(Call<ModelForRecommendation> call, Response<ModelForRecommendation> response) {
                movieRecommendation.setValue(response.body());
                Log.i("AHmed","EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"+movieRecommendation);
            }

            @Override
            public void onFailure(Call<ModelForRecommendation> call, Throwable t) {
                Log.i("ahmed","RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR"+t.getMessage());

            }
        });
    }
}
