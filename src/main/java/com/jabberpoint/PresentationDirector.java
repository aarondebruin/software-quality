package com.jabberpoint;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Director class that knows how to build specific types of presentations
 */
public class PresentationDirector
{
    /**
     * Loads a demo presentation
     */
    public void loadDemoPresentation(Presentation presentation) throws IOException
    {
        Accessor.getDemoAccessor().loadFile(presentation, "");
    }

    /**
     * Loads a presentation from an XML file
     */
    public void loadXMLPresentation(Presentation presentation, String filename) throws IOException
    {
        new XMLAccessor().loadFile(presentation, filename);
    }

    /**
     * Creates an empty presentation with just a title
     */
    public Presentation createEmptyPresentation(String title, SlideViewerComponent viewer)
    {
        return new PresentationBuilder().withTitle(title).withSlideViewerComponent(viewer).build();
    }

    /**
     * Creates a standard presentation with a title and some default slides
     */
    public Presentation createStandardPresentation(String title, SlideViewerComponent viewer)
    {
        PresentationBuilder builder = new PresentationBuilder().withTitle(title).withSlideViewerComponent(viewer);
        // Add some default slides
        Slide titleSlide = new Slide();
        titleSlide.setTitle(title);
        // Add content to title slide
        Slide introSlide = new Slide();
        introSlide.setTitle("Introduction");
        // Add content to intro slide
        Slide conclusionSlide = new Slide();
        conclusionSlide.setTitle("Conclusion");
        // Add content to conclusion slide
        builder.addSlide(titleSlide).addSlide(introSlide).addSlide(conclusionSlide);
        return builder.build();
    }

    /**
     * Creates a presentation from an existing list of slides
     */
    public Presentation createPresentationFromSlides(String title, SlideViewerComponent viewer, ArrayList<Slide> slides)
    {
        return new PresentationBuilder().withTitle(title).withSlideViewerComponent(viewer).addSlides(slides).build();
    }
}
