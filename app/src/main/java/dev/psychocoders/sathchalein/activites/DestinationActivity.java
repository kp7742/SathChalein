package dev.psychocoders.sathchalein.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.adapters.RecyclerViewAdapter;
import dev.psychocoders.sathchalein.models.DataModel;

public class DestinationActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ArrayList<DataModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel("Agra", R.drawable.ajmer, "#09A9FF"));
        arrayList.add(new DataModel("Varanasi", R.drawable.darjeeling, "#3E51B1"));
        arrayList.add(new DataModel("Ajmer", R.drawable.taj, "#673BB7"));
        arrayList.add(new DataModel("Delhi", R.drawable.varanasi, "#4BAA50"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
