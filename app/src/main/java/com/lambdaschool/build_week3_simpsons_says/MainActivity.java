package com.lambdaschool.build_week3_simpsons_says;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataAccessObject dao=new DataAccessObject();
        ArrayList<Quote> quoteArrayList=dao.getData();
    }
}
