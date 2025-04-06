package com.jabberpoint.presentation;

import com.jabberpoint.slide.SlideMemento;

import java.util.ArrayList;

public class PresentationMemento {
    private final String title;
    private final ArrayList<SlideMemento> slides;
    private final int currentSlideNumber;

    public PresentationMemento(String title, ArrayList<SlideMemento> slides, int currentSlideNumber) {
        this.title = title;
        this.slides = new ArrayList<>(slides); // deep copy
        this.currentSlideNumber = currentSlideNumber;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<SlideMemento> getSlides() {
        return new ArrayList<>(slides); // return copy
    }

    public int getCurrentSlideNumber() {
        return currentSlideNumber;
    }
}
