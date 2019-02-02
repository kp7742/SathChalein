package dev.psychocoders.sathchalein.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.github.demono.AutoScrollViewPager;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.adapters.SlideShowAdapter;

public class MainFragment extends Fragment {
    static MainFragment mainFragment;

    public static MainFragment instance(){
        if(mainFragment == null){
            mainFragment = new MainFragment();
        }
        return mainFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        AutoScrollViewPager slider = (AutoScrollViewPager) v.findViewById(R.id.slideshow);
        slider.setAdapter(new SlideShowAdapter());
        slider.startAutoScroll();

        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) v.findViewById(R.id.populardestview);
        RecyclerView recyclerView = (RecyclerView) horizontalScrollView.findViewById(R.id.populardest);

        return v;
    }
}
