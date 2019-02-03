package dev.psychocoders.sathchalein.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.demono.AutoScrollViewPager;

import java.util.ArrayList;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.adapters.PopularDestAdapter;
import dev.psychocoders.sathchalein.adapters.SlideShowAdapter;
import dev.psychocoders.sathchalein.models.ImageModel;

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

        ArrayList<ImageModel> models = new ArrayList<>();
        models.add(new ImageModel("Ajmer",R.drawable.ajmer));
        models.add(new ImageModel("Dargeeling",R.drawable.darjeeling));
        models.add(new ImageModel("Taj",R.drawable.taj));
        models.add(new ImageModel("Varanasi",R.drawable.varanasi));


        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.populardest);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.clearAnimation();
        recyclerView.setAdapter(new PopularDestAdapter(models));

        TextView destViewall = (TextView) v.findViewById(R.id.destViewall);
        destViewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().sendBroadcast(new Intent("MyCustomIntent").setAction("dev.psychocoders.sathchalein.DestinationFrag"));
            }
        });
        return v;
    }
}
