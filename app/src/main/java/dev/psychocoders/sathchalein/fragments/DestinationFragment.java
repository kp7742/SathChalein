package dev.psychocoders.sathchalein.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.adapters.DestinationAdapter;
import dev.psychocoders.sathchalein.models.ImageModel;

public class DestinationFragment extends Fragment {
    static DestinationFragment destinationFragment;

    public static DestinationFragment instance(){
        if(destinationFragment == null){
            destinationFragment = new DestinationFragment();
        }
        return destinationFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_destination, container, false);

        ArrayList<ImageModel> models = new ArrayList<>();
        models.add(new ImageModel("Ajmer",R.drawable.ajmer));
        models.add(new ImageModel("Dargeeling",R.drawable.darjeeling));
        models.add(new ImageModel("Taj",R.drawable.taj));
        models.add(new ImageModel("Varanasi",R.drawable.varanasi));
        models.add(new ImageModel("Konrak",R.drawable.konark));
        models.add(new ImageModel("Mountains",R.drawable.img_mountain));
        models.add(new ImageModel("PinkCity",R.drawable.pink_city));
        models.add(new ImageModel("Somnath",R.drawable.somath));

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.destinations);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new DestinationAdapter(models));
        return v;
    }
}
