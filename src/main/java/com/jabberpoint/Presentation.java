package com.jabberpoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Presentation holds the slides in the presentation.
 * Implementeert Single Responsibility Principle door zich te richten op het beheren van slides.
 */
public class Presentation
{
    private String title; // the title of the presentation
    private final ArrayList<Slide> slides; // a List with the Slides
    private int currentSlideNumber; // the slide number of the current Slide
    private SlideViewerComponent slideViewComponent; // the view component for the Slides

    // Default constructor for backward compatibility
    public Presentation()
    {
        this.title = "";
        this.slides = new ArrayList<>();
        this.currentSlideNumber = -1;
    }

    // Constructor for use with builder
    Presentation(String title, List<Slide> slides, SlideViewerComponent slideViewComponent)
    {
        this.title = title;
        this.slides = new ArrayList<>(slides); // Defensive copy
        this.currentSlideNumber = slides.isEmpty() ? -1 : 0;
        this.slideViewComponent = slideViewComponent;
        updateView();
    }

    /**
     * Gets the number of slides in the presentation.
     *
     * @return The number of slides
     */
    public int getSize()
    {
        return slides.size();
    }

    /**
     * Gets the title of the presentation.
     *
     * @return The presentation title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets the title of the presentation.
     *
     * @param newTitle The new title
     */
    public void setTitle(String newTitle)
    {
        this.title = newTitle;
    }

    /**
     * Sets the view component for the presentation.
     *
     * @param slideViewComponent The view component
     */
    public void setShowView(SlideViewerComponent slideViewComponent)
    {
        this.slideViewComponent = slideViewComponent;
        updateView();
    }

    /**
     * Gets the current slide number.
     *
     * @return The current slide number
     */
    public int getSlideNumber()
    {
        return currentSlideNumber;
    }

    /**
     * Sets the current slide number and updates the view.
     *
     * @param number The new slide number
     */
    public void setSlideNumber(int number)
    {
        if (number >= -1 && number < getSize())
        {
            currentSlideNumber = number;
            updateView();
        }
    }

    /**
     * Navigates to the previous slide.
     */
    public void prevSlide()
    {
        if (currentSlideNumber > 0)
        {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    /**
     * Navigates to the next slide.
     */
    public void nextSlide()
    {
        if (currentSlideNumber < (getSize() - 1))
        {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    /**
     * Clears the presentation.
     * For backward compatibility.
     */
    public void clear()
    {
        slides.clear();
        setSlideNumber(-1);
    }

    /**
     * Adds a slide to the presentation.
     * For backward compatibility.
     *
     * @param slide The slide to add
     */
    public void append(Slide slide)
    {
        slides.add(slide);
    }

    /**
     * Gets a slide with a specific slide number.
     *
     * @param number The slide number
     * @return The slide, or null if the number is invalid
     */
    public Slide getSlide(int number)
    {
        if (number < 0 || number >= getSize())
        {
            return null;
        }
        return slides.get(number);
    }

    /**
     * Gets the current slide.
     *
     * @return The current slide, or null if there is no current slide
     */
    public Slide getCurrentSlide()
    {
        return getSlide(currentSlideNumber);
    }

    /**
     * Gets an unmodifiable view of all slides.
     *
     * @return Unmodifiable list of slides
     */
    public List<Slide> getAllSlides()
    {
        return Collections.unmodifiableList(slides);
    }

    /**
     * Updates the view with the current slide.
     */
    private void updateView()
    {
        if (slideViewComponent != null)
        {
            slideViewComponent.update(this, getCurrentSlide());
        }
    }

    /**
     * Exits the application.
     *
     * @param status The exit status
     */
    public void exit(int status)
    {
        System.exit(status);
    }
}
