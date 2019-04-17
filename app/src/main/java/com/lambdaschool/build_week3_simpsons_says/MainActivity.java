package com.lambdaschool.build_week3_simpsons_says;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;



/*        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container, new ItemListFragment())
                .commit();*/
        LoginFragment loginFragment = new LoginFragment();
/*        Bundle bundle = new Bundle();
        bundle.putSerializable(DetailsFragment.ARG_PARAM, quote);
        loginFragment.setArguments(bundle);*/
        loginFragment.setStyle(DialogFragment.STYLE_NORMAL, 0);
        loginFragment.setCancelable(false);
/*        getSupportFragmentManager().beginTransaction()
                .replace(R.id.linear_layout_fragment_search, loginFragment)
                .addToBackStack(null)
                .commit();*/
        loginFragment.show(getSupportFragmentManager(), LoginFragment.ARG_PARAM);


        Button buttonSearch = findViewById(R.id.button_search_activity);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Search.class);
                startActivity(intent);
            }
        });
        Button buttonGenerate = findViewById(R.id.button_generate_activity);
        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Generate.class);
                startActivity(intent);
            }
        });
        Button buttonFavorites = findViewById(R.id.button_favorites_activity);
        buttonFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Favorites.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFragmentInteraction(String username) {

    }
}
