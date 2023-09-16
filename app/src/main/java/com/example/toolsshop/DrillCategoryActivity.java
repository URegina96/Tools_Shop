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

public class DrillCategoryActivity extends AppCompatActivity {

    private ListView listViewDrills;

    private ArrayList<Drill> drills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        drills =new ArrayList<>();
        //создаем дрели добавляя в ArrayList
        drills.add(new Drill(getString(R.string.drill_one_title),getString(R.string.drill_one_info),R.drawable.onedrill));
        drills.add(new Drill(getString(R.string.drill_two_title),getString(R.string.drill_two_info),R.drawable.twodrill));
        drills.add(new Drill(getString(R.string.drill_three_title),getString(R.string.drill_three_info),R.drawable.threedrill));

        listViewDrills=findViewById(R.id.listViewDrills);
        //адаптер (относится к нашей активности, элементы размещались по выбранному  макету, встроенному в ad, пи что бы выводился массив - список drills)
        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,drills);
        //устанавливаем адаптер в наш listViewDrills
        listViewDrills.setAdapter(adapter);

        //добавляем слушателя событий (для клика)
        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override //передаем анонимный класс в качестве параметра
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drill drill =drills.get(position);

                Intent intent = new Intent(getApplicationContext(), DrillDetailActivity.class);
                intent.putExtra("title",drill.getTitle());
                intent.putExtra("info",drill.getInfo());
                intent.putExtra("resId",drill.getImageResourceId());
                startActivity(intent);



            }
        });
    }
}