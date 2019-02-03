package dev.psychocoders.sathchalein.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.psychocoders.sathchalein.R;

public class ProfileFragment extends Fragment {
    static ProfileFragment profileFragmentt;

    public static ProfileFragment instance(){
        if(profileFragmentt == null){
            profileFragmentt = new ProfileFragment();
        }
        return profileFragmentt;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_user_profile, container, false);
        return v;
    }
}
