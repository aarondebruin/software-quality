package com.jabberpoint;

import java.util.ArrayList;

/**
 * Presentation holds the slides in the presentation.
 * <p>
 * There is only one instance of this class present.
 */
public class Presentation
{
    private String showTitle; // the title of the presentation
    private ArrayList<Slide> showList; // an ArrayList with the Slides
    private int currentSlideNumber; // the slide number of the current Slide
    private SlideViewerComponent slideViewComponent; // the view component for the Slides

    // Package-private constructor to allow builder access but restrict others
    Presentation()
    {
        clear();
    }

    public int getSize()
    {
        return showList.size();
    }

    public String getTitle()
    {
        return showTitle;
    }

    public void setTitle(String nt)
    {
        showTitle = nt;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
    }

    // get the number of the current slide
    public int getSlideNumber()
    {
        return currentSlideNumber;
    }

    // change the current slide number and notify the window
    public void setSlideNumber(int number)
    {
        currentSlideNumber = number;
        if (slideViewComponent != null)
        {
            slideViewComponent.update(this, getCurrentSlide());
        }
    }

    // go to the previous slide unless you're at the beginning of the presentation
    public void prevSlide()
    {
        if (currentSlideNumber > 0)
        {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    // go to the next slide unless you're at the end of the presentation
    public void nextSlide()
    {
        if (currentSlideNumber < (showList.size() - 1))
        {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    // clear the presentation to be ready for the next one
    void clear()
    {
        showList = new ArrayList<Slide>();
        setSlideNumber(-1);
    }

    // add a slide to the presentation
    public void append(Slide slide)
    {
        showList.add(slide);
    }

    // get a slide with a specific slide number
    public Slide getSlide(int number)
    {
        if (number < 0 || number >= getSize())
        {
            return null;
        }
        return showList.get(number);
    }

    // get the current Slide
    public Slide getCurrentSlide()
    {
        return getSlide(currentSlideNumber);
    }

    public void exit(int n)
    {
        System.exit(n);
    }
}
