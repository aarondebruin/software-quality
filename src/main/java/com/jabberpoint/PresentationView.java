package com.jabberpoint;

/**
 * Interface for components that can display a presentation.
 * Implements Interface Segregation Principle by having a focused interface.
 */
public interface PresentationView
{
    /**
     * Updates the view with the current presentation and slide.
     *
     * @param presentation The presentation
     * @param slide        The current slide
     */
    void update(Presentation presentation, Slide slide);
}
