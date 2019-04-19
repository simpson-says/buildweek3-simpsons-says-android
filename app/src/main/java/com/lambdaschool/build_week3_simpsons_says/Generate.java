package com.lambdaschool.build_week3_simpsons_says;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Generate extends AppCompatActivity implements GenerateFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        ArrayList<Character> characterArrayList = new ArrayList<>();
        characterArrayList.add(new Character("Homer", R.drawable.homer));
        characterArrayList.add(new Character("Marge", R.drawable.marge));
        characterArrayList.add(new Character("Bart", R.drawable.bart));
        characterArrayList.add(new Character("Lisa", R.drawable.lisa));
        characterArrayList.add(new Character("Grampa", R.drawable.grampa));
        characterArrayList.add(new Character("Moe", R.drawable.moe));
        characterArrayList.add(new Character("Skinner", R.drawable.skinner));

        GenerateFragment.OnFragmentInteractionListener interactionListener = this; //TODO: Delete this and get proper handle
        RecyclerView recyclerView = findViewById(R.id.recycler_view_generate);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GenerateListAdapter generateListAdapter = new GenerateListAdapter(characterArrayList, interactionListener); //TODO: Replace this variable with the proper interactionListener
        recyclerView.setAdapter(generateListAdapter);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onFragmentInteraction(Character character) {
        GenerateFragment generateFragment = new GenerateFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(GenerateFragment.ARG_PARAM, character);
        generateFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.constraint_layout_generate_fragment, generateFragment)
                .addToBackStack(null)
                .commit();
    }
}
