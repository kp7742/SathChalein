package dev.psychocoders.sathchalein.listeners;

import android.widget.SearchView;

public class QueryTextListener implements SearchView.OnQueryTextListener {

    public QueryTextListener(){

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        /*
        if(list.contains(query)){
            adapter.getFilter().filter(query);
        } else{
            Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
        }
         */
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //adapter.getFilter().filter(newText);
        return false;
    }
}
