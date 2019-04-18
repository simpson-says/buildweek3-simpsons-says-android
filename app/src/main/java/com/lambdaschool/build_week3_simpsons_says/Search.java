package com.lambdaschool.build_week3_simpsons_says;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Search extends AppCompatActivity implements DetailsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final Context context = this;
        final View view = this.getCurrentFocus();

        Button buttonSearch = findViewById(R.id.button_search_search);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextSearchEntry = findViewById(R.id.edit_text_search_entry);
                String searchText = editTextSearchEntry.getText().toString();
                DataAccessObject dao = new DataAccessObject();
                ArrayList<Quote> quoteArrayList = dao.searchForQuotes(searchText);
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
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetailsFragment.ARG_PARAM, quote);
        detailsFragment.setArguments(bundle);
        detailsFragment.setStyle(DialogFragment.STYLE_NORMAL, 0);
        detailsFragment.show(getSupportFragmentManager(), DetailsFragment.ARG_PARAM);
    }
}
