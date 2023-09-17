package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ScrewdriversCategoryActivity extends AppCompatActivity {
    private ListView listViewScrewdrivers;
    private ArrayList<Screwdriver> screwdrivers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screwdrivers_category);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        screwdrivers = new ArrayList<>();
        screwdrivers.add(new Screwdriver(getString(R.string.screwdrivers_one_title), getString(R.string.screwdrivers_one_info), R.drawable.screwdriversone));
        screwdrivers.add(new Screwdriver(getString(R.string.screwdrivers_two_title), getString(R.string.screwdrivers_two_info), R.drawable.screwdriverstwo));
        screwdrivers.add(new Screwdriver(getString(R.string.screwdrivers_three_title), getString(R.string.screwdrivers_three_info), R.drawable.screwdriversthree));

        listViewScrewdrivers = findViewById(R.id.listViewScrewdrivers);

        ArrayAdapter<Screwdriver>adapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, screwdrivers);
        listViewScrewdrivers.setAdapter(adapter);

        listViewScrewdrivers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Screwdriver screwdriver =screwdrivers.get(position);

                Intent intent = new Intent(getApplicationContext(), ScrewdriverDetailActivity.class);
                intent.putExtra("title",screwdriver.getTitle());
                intent.putExtra("info",screwdriver.getInfo());
                intent.putExtra("resId",screwdriver.getImageResourceId());
                startActivity(intent);

            }
        });



    }
}