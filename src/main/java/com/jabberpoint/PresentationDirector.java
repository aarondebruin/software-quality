package com.jabberpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Director class that knows how to build specific types of presentations.
 * Implements Single Responsibility Principle by focusing on presentation creation.
 */
public class PresentationDirector
{
    private final SlideDirector slideDirector;

    /**
     * Creates a new PresentationDirector with a SlideDirector.
     */
    public PresentationDirector()
    {
        this.slideDirector = new SlideDirector();
    }

    /**
     * Creates a new PresentationDirector with a specific SlideDirector.
     *
     * @param slideDirector The SlideDirector to use
     */
    public PresentationDirector(SlideDirector slideDirector)
    {
        this.slideDirector = slideDirector;
    }

    /**
     * Loads a demo presentation.
     *
     * @param view The view component
     * @return The loaded demo presentation
     * @throws IOException If loading fails
     */
    public Presentation createDemoPresentation(SlideViewerComponent view) throws IOException
    {
        Presentation presentation = new Presentation();
        presentation.setTitle("Demo Presentation");
        presentation.setShowView(view);
        Accessor.getDemoAccessor().loadFile(presentation, "");
        return presentation;
    }

    /**
     * Loads a presentation from an XML file.
     *
     * @param filename The XML file to load
     * @param view     The view component
     * @return The loaded presentation
     * @throws IOException If loading fails
     */
    public Presentation createXMLPresentation(String filename, SlideViewerComponent view) throws IOException
    {
        Presentation presentation = new Presentation();
        presentation.setShowView(view);
        new XMLAccessor().loadFile(presentation, filename);
        return presentation;
    }

    /**
     * Creates an empty presentation with just a title.
     *
     * @param title The presentation title
     * @param view  The view component
     * @return The created presentation
     */
    public Presentation createEmptyPresentation(String title, SlideViewerComponent view)
    {
        Presentation presentation = new Presentation();
        presentation.setTitle(title);
        presentation.setShowView(view);
        return presentation;
    }

    /**
     * Creates a standard presentation with a title and some default slides.
     *
     * @param title The presentation title
     * @param view  The view component
     * @return The created presentation
     */
    public Presentation createStandardPresentation(String title, SlideViewerComponent view)
    {
        Presentation presentation = new Presentation();
        presentation.setTitle(title);
        presentation.setShowView(view);
        SlideBuilder slideBuilder = new SlideBuilder();
        // Create standard slides
        Slide titleSlide = slideDirector.constructTitleSlide(slideBuilder, title);
        presentation.append(titleSlide);
        slideBuilder = new SlideBuilder(); // Reset builder
        Slide introSlide = slideBuilder.withTitle("Introduction").addTextItem(1, "Welcome to " + title).addTextItem(2, "This presentation covers:").addTextItem(3, "Important topic 1").addTextItem(3, "Important topic 2").build();
        presentation.append(introSlide);
        slideBuilder = new SlideBuilder(); // Reset builder
        Slide conclusionSlide = slideBuilder.withTitle("Conclusion").addTextItem(1, "Thank you for your attention").addTextItem(2, "Questions?").build();
        presentation.append(conclusionSlide);
        return presentation;
    }

    /**
     * Creates a presentation from an existing list of slides.
     *
     * @param title  The presentation title
     * @param view   The view component
     * @param slides The slides to include
     * @return The created presentation
     */
    public Presentation createPresentationFromSlides(String title, SlideViewerComponent view, List<Slide> slides)
    {
        Presentation presentation = new Presentation();
        presentation.setTitle(title);
        presentation.setShowView(view);
        for (Slide slide : slides)
        {
            presentation.append(slide);
        }
        return presentation;
    }
}
