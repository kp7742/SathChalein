package dev.psychocoders.sathchalein.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.psychocoders.sathchalein.R;

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
        return v;
    }
}
