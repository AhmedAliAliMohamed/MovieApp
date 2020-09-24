package com.example.movieapp.ui.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.Servers;
import com.example.movieapp.models.ModelForHome;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelForHome extends ViewModel {

    public MutableLiveData<ModelForHome> data = new MutableLiveData<>();

    public void getPopluarMovie(){
        Servers.getSERVICES().getPopular().enqueue(new Callback<ModelForHome>() {
            @Override
            public void onResponse(Call<ModelForHome> call, Response<ModelForHome> response) {
                data.setValue(response.body());
            }
            @Override
            public void onFailure(Call<ModelForHome> call, Throwable t) {
            }
        });
    }
}
