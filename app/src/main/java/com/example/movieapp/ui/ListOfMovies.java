package com.example.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.movieapp.R;
import com.example.movieapp.adapters.AdapterForPopular;
import com.example.movieapp.models.ModelForHome;
import com.example.movieapp.ui.viewmodels.ViewModelForHome;

import java.util.ArrayList;
import java.util.List;

public class ListOfMovies extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterForPopular adapterForPopular;
    ViewModelForHome viewModel;
    List<ModelForHome.ResultsBean> model = new ArrayList<>();
    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_movies);

        viewModel = ViewModelProviders.of(this).get(ViewModelForHome.class);
        viewModel.getPopluarMovie();
       recyclerView = findViewById(R.id.recycler_Home);
       recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapterForPopular = new AdapterForPopular(this,model);
       recyclerView.setAdapter(adapterForPopular);

       viewModel.data.observe(this, new Observer<ModelForHome>() {
           @Override
           public void onChanged(ModelForHome modelForHome) {
               adapterForPopular.setList(modelForHome.getResults());

               adapterForPopular.setOnClickListener(new AdapterForPopular.setOnClickListener() {
                   @Override
                   public void onClickListener(int position) {
                       itemId = modelForHome.getResults().get(position).getId();
                       Intent toDetailOfMovie = new Intent(ListOfMovies.this, DetailsOfMovie.class);
                       toDetailOfMovie.putExtra("movieId",itemId);
                       startActivity(toDetailOfMovie);
                   }
               });
           }
       });





    }
}