package com.jabberpoint;

import java.io.IOException;

/**
 * An accessor that provides a static demonstration presentation.
 * It extends Accessor and uses the SlideBuilder/SlideDirector pattern.
 */
public class DemoPresentation extends Accessor
{
    /**
     * Loads a predefined demo presentation into the given Presentation object.
     * Uses SlideBuilder and SlideDirector for slide creation.
     *
     * @param presentation   The Presentation object to load slides into.
     * @param unusedFilename This parameter is ignored for the demo.
     * @throws IOException Not actually thrown by this implementation, but
     *                     required by the abstract class signature.
     */
    @Override
    public void loadFile(Presentation presentation, String unusedFilename) throws IOException
    {
        // Optional: Clear any existing slides in the presentation first
        // presentation.clear(); // Add this if Presentation has a clear method
        // Set a title for the demo presentation
        presentation.setTitle(DEMO_NAME); // Using constant from Accessor
        // Use the director for predefined slide structures
        SlideDirector director = new SlideDirector();
        // Slide 1: Use the director for a standard demo slide
        // Create a new builder for each slide construction
        Slide slide1 = director.constructDemoSlide(new SlideBuilder());
        presentation.append(slide1);
        // Slide 2: Use the director for a title slide
        Slide slide2 = director.constructTitleSlide(new SlideBuilder(), "Builder Pattern Benefits");
        presentation.append(slide2);
        // Slide 3: Use the director for a text slide
        Slide slide3 = director.constructTextSlide(new SlideBuilder(), "Key Benefits", "Separates construction & representation", "Allows different representations", "Controls construction process");
        presentation.append(slide3);
        // Slide 4: Build manually using the builder for custom structure
        Slide slide4 = new SlideBuilder().withTitle("Manual Construction Example").addTextItem(1, "Mixing item types:").addBitmapItem(2, "jabberpoint.jpg") // Ensure jabberpoint.jpg exists
                .addTextItem(3, "Image caption (level 3)").addTextItem(1, "End of manual slide.").build();
        presentation.append(slide4);
    }

    /**
     * Saving is not supported for the demo presentation.
     *
     * @param presentation The presentation object (ignored).
     * @param filename     The filename (ignored).
     * @throws IOException Always thrown as this operation is unsupported.
     */
    @Override
    public void saveFile(Presentation presentation, String filename) throws IOException
    {
        throw new IOException("Saving is not supported for the Demo Presentation.");
    }
}
