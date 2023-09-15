package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listViewTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //скрываем ActionBar (если он есть)
        ActionBar actionBar = getSupportActionBar(); //получили его ссылку
        if (actionBar != null) {
            actionBar.hide();
        }
        //работа со "слушателями событий", тут onClick не подойдет, т.к. клик будет распространятся на весь спиннер-каталог, а не на определенные элементы в нем, тогда нам нужен доступ к listView
        listViewTools = findViewById(R.id.listViewTools);
        //setOnItemClickListener - интерфейс, поэтому передаем в качестве параметра объект класса , который реализует данный интерфейс
        //создаем анонимный класс new AdapterView.OnItemClickListener()
        listViewTools.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                switch (position) { //позиция дрели = 0
                    case 0: //тогда переходим в новую активность, для этого создаем intent
                        Intent intent = new Intent(getApplicationContext(), DrillCategoryActivity.class);
                        startActivity(intent);
                        break;
                }

                switch (position) { //позиция дрели = 0
                    case 1: //тогда переходим в новую активность, для этого создаем intent
                        Intent intent = new Intent(getApplicationContext(), ScrewdriversCategoryActivity.class);
                        startActivity(intent);
                        break;
                }

                switch (position) { //позиция дрели = 0
                    case 2: //тогда переходим в новую активность, для этого создаем intent
                        Intent intent = new Intent(getApplicationContext(), HammersCategoryActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}