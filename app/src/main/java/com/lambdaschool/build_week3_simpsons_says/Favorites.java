package com.lambdaschool.build_week3_simpsons_says;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Favorites extends AppCompatActivity implements DetailsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        DataAccessObject dao = new DataAccessObject();
        ArrayList<Quote> quoteArrayList = dao.getUserFavorites();
        DetailsFragment.OnFragmentInteractionListener interactionListener = this; //TODO: Delete this and get proper handle
        RecyclerView recyclerView = findViewById(R.id.recycler_view_favorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FavoritesListAdapter favoritesListAdapter = new FavoritesListAdapter(quoteArrayList, interactionListener); //TODO: Replace this variable with the proper interactionListener
        recyclerView.setAdapter(favoritesListAdapter);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onFragmentInteraction(Quote quote) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetailsFragment.ARG_PARAM, quote);
        detailsFragment.setArguments(bundle);
        detailsFragment.setStyle(DialogFragment.STYLE_NORMAL, 0);
        detailsFragment.show(getSupportFragmentManager(), DetailsFragment.ARG_PARAM);
    }
}
