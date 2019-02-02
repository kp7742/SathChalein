package dev.psychocoders.sathchalein.activites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.SearchView;

import com.github.demono.AutoScrollViewPager;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.adapters.FrontSliderAdapter;
import dev.psychocoders.sathchalein.listeners.QueryTextListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbar.setTitle(" ");

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.setExpanded(true);

        AutoScrollViewPager slider = (AutoScrollViewPager) findViewById(R.id.slideshow);
        slider.setAdapter(new FrontSliderAdapter());
        slider.startAutoScroll();

        SearchView search = (SearchView) findViewById(R.id.search_button);
        search.setOnQueryTextListener(new QueryTextListener());
        search.setQueryHint("Destinations");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        return true;
                    case R.id.navigation_destinations:
                        return true;
                    case R.id.navigation_localguide:
                        return true;
                }
                return false;
            }
        });
    }
}
