package com.example.movieapp.adapters;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.models.ModelForRecommendation;

import java.util.ArrayList;
import java.util.List;


public class AdapterForRecommendations extends RecyclerView.Adapter<AdapterForRecommendations.MyHolder> {
    private Context context;
    private List<ModelForRecommendation.ResultsBean> list = new ArrayList<>();
   private ModelForRecommendation.ResultsBean  resultsBean = new ModelForRecommendation.ResultsBean();

    public AdapterForRecommendations(Context context, List<ModelForRecommendation.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<ModelForRecommendation.ResultsBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_recommend,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        resultsBean = list.get(position);
        Glide.with(context).load("http://image.tmdb.org/t/p/w185"+resultsBean.getPoster_path()).into(holder.imageViewRecommend);
        holder.textViewTitleRecommend.setText(resultsBean.getTitle());
        holder.ratingBarRecommend.setRating(resultsBean.getVote_average());
        holder.textViewAverageRateRecommend.setText(resultsBean.getVote_average()+"");
        holder.textViewDateRecommend.setText(resultsBean.getRelease_date());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageViewRecommend ;
        TextView textViewTitleRecommend;
        RatingBar ratingBarRecommend;
        TextView textViewAverageRateRecommend;
        TextView textViewDateRecommend;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageViewRecommend = itemView.findViewById(R.id.image_recommend);
            textViewTitleRecommend = itemView.findViewById(R.id.text_title_recommend);
            ratingBarRecommend = itemView.findViewById(R.id.rate_view_recommend);
            textViewAverageRateRecommend = itemView.findViewById(R.id.text_avrage_rate_recommend);
            textViewDateRecommend = itemView.findViewById(R.id.text_date_recommend);
        }
    }
}
