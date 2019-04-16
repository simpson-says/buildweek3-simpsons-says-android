package com.lambdaschool.build_week3_simpsons_says;

import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetailsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        DataAccessObject dao = new DataAccessObject();
        ArrayList<Quote> quoteArrayList = dao.getData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view_search_results);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SearchListAdapter searchListAdapter = new SearchListAdapter(quoteArrayList);
        recyclerView.setAdapter(searchListAdapter);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onFragmentInteraction(Quote quote) {

/*
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container, new ItemListFragment())
                .commit();
*/

        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("details", quote);
        detailsFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout_details, detailsFragment)
                .addToBackStack(null)
                .commit();
    }
}
