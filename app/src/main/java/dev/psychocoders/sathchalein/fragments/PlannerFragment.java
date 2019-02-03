package dev.psychocoders.sathchalein.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.psychocoders.sathchalein.R;

public class PlannerFragment extends Fragment {
    static PlannerFragment plannerFragment;

    public static PlannerFragment instance(){
        if(plannerFragment == null){
            plannerFragment = new PlannerFragment();
        }
        return plannerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_myplanner, container, false);
        return v;
    }
}
