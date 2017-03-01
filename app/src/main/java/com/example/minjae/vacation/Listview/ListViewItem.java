package com.example.minjae.vacation.Listview;

import android.graphics.drawable.Drawable;

/**
 * Created by Minjae on 2017-02-16.
 */

public class ListViewItem {
    private Drawable icon;
    private String name;
    private String message;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
