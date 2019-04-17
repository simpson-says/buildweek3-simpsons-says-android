package com.lambdaschool.build_week3_simpsons_says;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Search extends AppCompatActivity implements DetailsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final Context context = this;

        Button buttonSearch = findViewById(R.id.button_search_search);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataAccessObject dao = new DataAccessObject();
                ArrayList<Quote> quoteArrayList = dao.getData();
                DetailsFragment.OnFragmentInteractionListener interactionListener = (DetailsFragment.OnFragmentInteractionListener) context; //TODO: Delete this and get proper handle
                RecyclerView recyclerView = findViewById(R.id.recycler_view_search_results);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                SearchListAdapter searchListAdapter = new SearchListAdapter(quoteArrayList, interactionListener); //TODO: Replace this variable with the proper interactionListener
                recyclerView.setAdapter(searchListAdapter);
                recyclerView.setHasFixedSize(true);
            }
        });
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
        bundle.putSerializable(DetailsFragment.ARG_PARAM, quote);
        detailsFragment.setArguments(bundle);
/*        getSupportFragmentManager().beginTransaction()
                .replace(R.id.linear_layout_fragment_search, detailsFragment)
                .addToBackStack(null)
                .commit();*/
        detailsFragment.show(getSupportFragmentManager(),"details");
    }
}
