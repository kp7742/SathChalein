package dev.psychocoders.sathchalein.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.psychocoders.sathchalein.R;

public class MainFragment extends Fragment {
    static MainFragment mainFragment;

    public static MainFragment instance(){
        if(mainFragment == null){
            mainFragment = new MainFragment();
        }
        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main_content, container, false);
    }
}
