package com.example.toolsshop;

import androidx.annotation.NonNull;

public class Drill {

    private String title;
    private String info;
    private int imageResourceId;

    public Drill(String title,String info,int imageResourceId){
        this.title=title;
        this.info=info;
        this.imageResourceId=imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
    //показываем какой именно элемент надо выводить, переопределяем метод


    @NonNull
    @Override
    public String toString() { //когда дрель преобразуется в строку, то выводилось ее название
        return title;
    }
}
