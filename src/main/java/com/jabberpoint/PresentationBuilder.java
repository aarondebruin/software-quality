package com.jabberpoint;

import java.util.ArrayList;

/**
 * Builder class for creating Presentation objects
 */
public class PresentationBuilder
{
    private String title;
    private SlideViewerComponent viewerComponent;
    private ArrayList<Slide> slides = new ArrayList<>();

    public PresentationBuilder()
    {
    }

    public PresentationBuilder withTitle(String title)
    {
        this.title = title;
        return this;
    }

    public PresentationBuilder withSlideViewerComponent(SlideViewerComponent component)
    {
        this.viewerComponent = component;
        return this;
    }

    public PresentationBuilder addSlide(Slide slide)
    {
        this.slides.add(slide);
        return this;
    }

    public PresentationBuilder addSlides(ArrayList<Slide> slides)
    {
        this.slides.addAll(slides);
        return this;
    }

    public Presentation build()
    {
        Presentation presentation = new Presentation();
        if (title != null)
        {
            presentation.setTitle(title);
        }
        if (viewerComponent != null)
        {
            presentation.setShowView(viewerComponent);
        }
        for (Slide slide : slides)
        {
            presentation.append(slide);
        }
        return presentation;
    }
}
