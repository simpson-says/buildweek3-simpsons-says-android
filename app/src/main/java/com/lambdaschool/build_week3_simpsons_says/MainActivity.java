package com.lambdaschool.build_week3_simpsons_says;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;

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
}
