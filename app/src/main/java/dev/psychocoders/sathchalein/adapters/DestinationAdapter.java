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
import dev.psychocoders.sathchalein.models.ImageModel;

public class DestinationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ImageModel> models;

    public DestinationAdapter(ArrayList<ImageModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerView.ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_card_big, viewGroup, false)) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView.findViewById(R.id.card_view);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(models.get(i).getImgres());
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(models.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
