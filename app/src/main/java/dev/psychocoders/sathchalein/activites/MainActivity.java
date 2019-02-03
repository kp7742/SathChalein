package dev.psychocoders.sathchalein.activites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import dev.psychocoders.sathchalein.fragments.DestinationFragment;
import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.fragments.MainFragment;
import dev.psychocoders.sathchalein.fragments.PlannerFragment;
import dev.psychocoders.sathchalein.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setFragment(0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // Handle navigation view item clicks here.
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        setFragment(0);
                        break;
                    case R.id.nav_destination:
                        setFragment(1);
                        break;
                    case R.id.nav_events:
                        setFragment(2);
                        break;
                    case R.id.nav_my_plans:
                        setFragment(3);
                        break;
                    case R.id.nav_my_profile:
                        setFragment(4);
                        break;
                    case R.id.nav_my_bookings:
                        setFragment(5);
                        break;
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setFragment(int i){
        Fragment fragment;
        switch (i){
            case 0:
                fragment = MainFragment.instance();
                break;
            case 1:
                fragment = DestinationFragment.instance();
                break;
            case 2:
                fragment = MainFragment.instance();
                break;
            case 3:
                fragment = PlannerFragment.instance();
                break;
            case 4:
                fragment = ProfileFragment.instance();
                break;
            case 5:
                fragment = MainFragment.instance();
                break;
            default:
                fragment = MainFragment.instance();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.placeholder,fragment).commit();
    }
}
