package dev.psychocoders.sathchalein.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.demono.adapter.InfinitePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import dev.psychocoders.sathchalein.R;

public class FrontSliderAdapter extends InfinitePagerAdapter {
    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public View getItemView(int i, View view, ViewGroup viewGroup) {
        ImageView images = new ImageView(viewGroup.getContext());
        images.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        switch (i) {
            case 0:
                images.setImageResource(R.drawable.ajmer);
                break;
            case 1:
                images.setImageResource(R.drawable.darjeeling);
                break;
            case 2:
                images.setImageResource(R.drawable.taj);
                break;
            case 3:
                images.setImageResource(R.drawable.varanasi);
                break;
        }
        return images;
    }
}
