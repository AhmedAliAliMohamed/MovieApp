package com.example.movieapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.models.ModelForActors;

import java.util.ArrayList;
import java.util.List;

public class AdapterForActors extends RecyclerView.Adapter<AdapterForActors.MyHolder> {
    private  Context context;
    private List<ModelForActors.CastBean> castBeans = new ArrayList<>();
    private ModelForActors.CastBean  modelCast ;

    public AdapterForActors(Context context) {
        this.context = context;
    }

    public void setCastBeans(List<ModelForActors.CastBean> castBeans) {
        this.castBeans = castBeans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_actors,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        modelCast= castBeans.get(position);
        holder.textViewActorName.setText(modelCast.getName());
        holder.textViewCharacter.setText(modelCast.getCharacter());


    }

    @Override
    public int getItemCount() {
        return castBeans.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textViewActorName;
        TextView textViewCharacter;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textViewActorName = itemView.findViewById(R.id.text_actor_name);
            textViewCharacter = itemView.findViewById(R.id.text_character);
        }
    }
}
