package com.example.movieapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.models.ModelForHome;
import com.example.movieapp.ui.DetailsOfMovie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterForPopular extends RecyclerView.Adapter<AdapterForPopular.MyHolder> {

   private List<ModelForHome.ResultsBean> list = new ArrayList<>();
   private    Context context;
   private    ModelForHome.ResultsBean model;
   private setOnClickListener onClickListener;
   private int position;



    public interface setOnClickListener{
        public void onClickListener(int position);
    }

    public void  setOnClickListener(setOnClickListener setOnClickListener){
        this.onClickListener = setOnClickListener;
    }


    public AdapterForPopular(Context context,List<ModelForHome.ResultsBean>list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<ModelForHome.ResultsBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterForPopular.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_home,parent,false);
        return new MyHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForPopular.MyHolder holder, int position) {
        model = list.get(position);
        double rate = model.getVote_average();
        float rateing = (float)rate;
        Glide.with(context).load("http://image.tmdb.org/t/p/w185"+model.getPoster_path()).into(holder.imageForPopular);
        holder.nameForMovie.setText(model.getTitle());
        holder.ratingView.setRating(rateing);
        holder.avgRatingView.setText(model.getVote_average()+"");
        holder.dateMovie.setText(model.getRelease_date());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageForPopular;
        TextView nameForMovie;
        RatingBar ratingView;
        TextView avgRatingView;
        TextView dateMovie;
        public MyHolder(@NonNull View itemView, final setOnClickListener setOnClickListener) {
            super(itemView);

            imageForPopular = itemView.findViewById(R.id.image_Home);
            nameForMovie = itemView.findViewById(R.id.text_title_home);
            ratingView = itemView.findViewById(R.id.rate_view);
            avgRatingView = itemView.findViewById(R.id.text_avrage_rate);
            dateMovie = itemView.findViewById(R.id.text_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickListener != null){
                        position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            setOnClickListener.onClickListener(position);
                            notifyDataSetChanged();

                        }
                    }
                }
            });
        }
    }
}
