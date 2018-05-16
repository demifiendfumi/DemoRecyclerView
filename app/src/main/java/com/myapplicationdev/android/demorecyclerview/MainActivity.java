package com.myapplicationdev.android.demorecyclerview;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter ra;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call view from xml
        recyclerView = (RecyclerView)findViewById(R.id. rLV);
        recyclerView.setHasFixedSize(true);
        //get current context as parameter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //dummy test
        listItems = new ArrayList<>();
        for (int i = 0; i<=10; i++){
            ListItem listItem = new ListItem(
                    "heading" + (i+1),
                    "dummy text"
            );

            listItems.add(listItem);
        }

        //initialise adapter using listItem
        ra = new ItemAdapter(listItems, this);

        recyclerView.setAdapter(ra);
    }
}
