package com.example.movieapp.ui.viewmodels;

import android.util.Log;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.Servers;
import com.example.movieapp.models.ModelForDetailMovie;
import com.example.movieapp.models.ModelForRecommendation;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelForDetails extends ViewModel {

   public MutableLiveData<ModelForDetailMovie> data = new MutableLiveData<>();


    public void getDetailMovie(int id) {
        Servers.getSERVICES().getDetailMovie(id).enqueue(new Callback<ModelForDetailMovie>() {
            @Override
            public void onResponse(Call<ModelForDetailMovie> call, Response<ModelForDetailMovie> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ModelForDetailMovie> call, Throwable t) {

            }
        });
    }


}
