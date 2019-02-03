package dev.psychocoders.sathchalein.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.utils.Prefs;

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
        TextView email = (TextView) v.findViewById(R.id.email);
        email.setText(Prefs.with(getContext()).read("username"));
        return v;
    }
}
