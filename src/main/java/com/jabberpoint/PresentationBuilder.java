package com.jabberpoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder class for creating Presentation objects.
 * Implements Builder pattern for flexible object creation.
 */
public class PresentationBuilder
{
    private String title = "";
    private SlideViewerComponent viewComponent = null;
    private final List<Slide> slides = new ArrayList<>();

    /**
     * Sets the title for the presentation being built.
     *
     * @param title The presentation title
     * @return The builder instance for chaining
     */
    public PresentationBuilder setTitle(String title)
    {
        this.title = title;
        return this;
    }

    /**
     * Sets the view component for the presentation being built.
     *
     * @param component The view component
     * @return The builder instance for chaining
     */
    public PresentationBuilder setSlideViewerComponent(SlideViewerComponent component)
    {
        this.viewComponent = component;
        return this;
    }

    /**
     * Adds a slide to the presentation being built.
     *
     * @param slide The slide to add
     * @return The builder instance for chaining
     */
    public PresentationBuilder addSlide(Slide slide)
    {
        this.slides.add(slide);
        return this;
    }

    /**
     * Builds the presentation with the configured properties.
     *
     * @return The built Presentation object
     */
    public Presentation build()
    {
        return new Presentation(title, slides, viewComponent);
    }
}
