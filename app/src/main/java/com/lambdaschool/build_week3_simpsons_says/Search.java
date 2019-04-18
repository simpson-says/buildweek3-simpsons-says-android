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

//                InputMethodManager inputManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                //editTextSearchEntry.setInputType(0);
//                if (view != null) {
//                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//                }
                //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
        detailsFragment.setStyle(DialogFragment.STYLE_NORMAL, 0);
/*        getSupportFragmentManager().beginTransaction()
                .replace(R.id.linear_layout_fragment_search, detailsFragment)
                .addToBackStack(null)
                .commit();*/
        detailsFragment.show(getSupportFragmentManager(), DetailsFragment.ARG_PARAM);
    }
}
