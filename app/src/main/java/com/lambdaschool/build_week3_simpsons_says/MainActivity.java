package com.lambdaschool.build_week3_simpsons_says;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
}
