package dev.psychocoders.sathchalein.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.models.DestinationModel;

public class PopularDestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<DestinationModel> models;

    public PopularDestAdapter(ArrayList<DestinationModel> models){
        this.models = models;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerView.ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_card_small, viewGroup, false)) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView.findViewById(R.id.card_view);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);
        imageView.setImageResource(models.get(i).getImgres());
        TextView textView = (TextView) view.findViewById(R.id.textView2);
        textView.setText(models.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
