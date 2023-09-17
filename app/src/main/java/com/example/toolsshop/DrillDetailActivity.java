package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewDrill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //присваиваем значение
        textViewTitle = findViewById(R.id.textViewDrillsDetailTitle);
        textViewInfo = findViewById(R.id.textViewDrillsDetailInfo);
        imageViewDrill = findViewById(R.id.imageViewLogoDrillsDetail);
        //теперь нужно получить информацию, которую нужно вывести
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);
//теперь вызываем, если все нормально
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewDrill.setImageResource(resId);


        }else { //или отправляем пользователя обратно
            Intent backToCategory =new Intent(this,DrillCategoryActivity.class);
            startActivity(backToCategory);

        }

    }
}