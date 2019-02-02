package dev.psychocoders.sathchalein.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.SearchView;

import com.github.demono.AutoScrollViewPager;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.adapters.FrontSliderAdapter;
import dev.psychocoders.sathchalein.fragments.MainFragment;
import dev.psychocoders.sathchalein.listeners.QueryTextListener;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment(0);

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
        search.setQueryHint("Where do You Want to Go?");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        setFragment(0);
                        return true;
                    case R.id.navigation_destinations:
                        setFragment(1);
                        return true;
                    case R.id.navigation_localguide:
                        setFragment(6);
                        return true;
                }
                return false;
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        setFragment(0);
                        return true;
                    case R.id.nav_destination:
                        setFragment(1);
                        return true;
                    case R.id.nav_events:
                        setFragment(2);
                        return true;
                    case R.id.nav_my_plans:
                        setFragment(3);
                        return true;
                    case R.id.nav_my_profile:
                        setFragment(4);
                        return true;
                    case R.id.nav_my_bookings:
                        setFragment(5);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setFragment(int id){
        /*
        Fragment fragment;
        switch (id) {
            case 0:
                fragment = MainFragment.instance();
                break;
            default:
                fragment = MainFragment.instance();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, fragment).commit();
        */
    }
}
