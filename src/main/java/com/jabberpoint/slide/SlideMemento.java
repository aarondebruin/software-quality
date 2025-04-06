package com.jabberpoint.slide;

import com.jabberpoint.SlideItem;

import java.util.Vector;

public class SlideMemento {
    private final String title;
    private final Vector<SlideItem> items;

    public SlideMemento(String title, Vector<SlideItem> items) {
        this.title = title;
        this.items = new Vector<>(items); // deep copy
    }

    public String getTitle() {
        return title;
    }

    public Vector<SlideItem> getItems() {
        return new Vector<>(items); // return copy
    }
}
