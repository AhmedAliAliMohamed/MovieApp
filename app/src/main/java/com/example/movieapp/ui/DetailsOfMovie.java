package com.example.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.adapters.AdapterForRecommendations;
import com.example.movieapp.models.ModelForDetailMovie;
import com.example.movieapp.models.ModelForRecommendation;
import com.example.movieapp.ui.viewmodels.ViewModelForDetails;
import com.example.movieapp.ui.viewmodels.ViewModelForRecommend;

import java.util.ArrayList;
import java.util.List;

public class DetailsOfMovie extends AppCompatActivity {
   private int id  ;
   private ViewModelForDetails viewModelForDetails;
   private ViewModelForRecommend modelForRecommend;
   private ImageView imageDetails ;
   private TextView textTitleDetails;
   private RatingBar ratingBarDetails;
   private TextView textAverageRate;
   private TextView textOverView;


   private RecyclerView recyclerRecommendation;
   private AdapterForRecommendations adapterForRecommendations;
   List<ModelForRecommendation.ResultsBean> listForRecommendations = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_movie);


        recyclerRecommendation = findViewById(R.id.recycler_recommend);
        adapterForRecommendations = new AdapterForRecommendations(this,listForRecommendations);
        recyclerRecommendation.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerRecommendation.setAdapter(adapterForRecommendations);


        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("movieId");
        viewModelForDetails = ViewModelProviders.of(this).get(ViewModelForDetails.class);
        modelForRecommend = ViewModelProviders.of(this).get(ViewModelForRecommend.class);
        viewModelForDetails.getDetailMovie(id);
        modelForRecommend.getMovieRecommendation(id);



        viewModelForDetails.data.observe(this, new Observer<ModelForDetailMovie>() {
            @Override
            public void onChanged(ModelForDetailMovie modelForDetailMovie) {
                imageDetails = findViewById(R.id.image_poster_details);
                textTitleDetails = findViewById(R.id.text_title_movie_details);
                ratingBarDetails = findViewById(R.id.rate_view_details);
                textAverageRate = findViewById(R.id.text_avrage_rate_details);
                TextView  textDateMovieDetails= findViewById(R.id.text_movie_date_details);
                textOverView = findViewById(R.id.text_over_view_details);
                float rating = (float)modelForDetailMovie.getVote_average();

                Glide.with(getApplicationContext()).load("http://image.tmdb.org/t/p/w185"+modelForDetailMovie.getPoster_path()).into(imageDetails);
                textTitleDetails.setText(modelForDetailMovie.getOriginal_title());
                ratingBarDetails.setRating(rating);
                textAverageRate.setText(modelForDetailMovie.getVote_average()+"");
                textDateMovieDetails.setText(modelForDetailMovie.getRelease_date());
                textOverView.setText(modelForDetailMovie.getOverview());
            }
        });


        modelForRecommend.movieRecommendation.observe(this, new Observer<ModelForRecommendation>() {
            @Override
            public void onChanged(ModelForRecommendation modelForRecommendation) {
                adapterForRecommendations.setList(modelForRecommendation.getResults());
            }
        });




    }
}