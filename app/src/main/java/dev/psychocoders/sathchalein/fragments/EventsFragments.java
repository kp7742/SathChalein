package dev.psychocoders.sathchalein.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.adapters.EventsAdapter;
import dev.psychocoders.sathchalein.models.ImageModel;

public class EventsFragments extends Fragment {
    private static EventsFragments eventsFragments;

    public static EventsFragments instance(){
        if(eventsFragments == null){
            eventsFragments = new EventsFragments();
        }
        return eventsFragments;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_events, container, false);

        ArrayList<ImageModel> models = new ArrayList<>();
        models.add(new ImageModel("Diwali",R.drawable.diwali));
        models.add(new ImageModel("Eid",R.drawable.eid));
        models.add(new ImageModel("Holi",R.drawable.holi));
        models.add(new ImageModel("Independenceday",R.drawable.independenceday));
        models.add(new ImageModel("Rath Yatra",R.drawable.rath_yatra));

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.events);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new EventsAdapter(models));
        return v;
    }
}
