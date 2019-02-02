package dev.psychocoders.sathchalein.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.models.DataModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<DataModel> mValues;
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<DataModel> values) {
        mValues = values;
        mContext = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        RelativeLayout relativeLayout;
        DataModel item;

        ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.textView);
            imageView = (ImageView) v.findViewById(R.id.imageView);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);
        }

        void setData(DataModel item) {
            this.item = item;
            textView.setText(item.text);
            imageView.setImageResource(item.drawable);
            relativeLayout.setBackgroundColor(Color.parseColor(item.color));
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder Vholder, int position) {
        Vholder.setData(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}