package com.jabberpoint;

public class SlideDirector
{
    /**
     * Constructs a typical demonstration slide.
     *
     * @param builder The SlideBuilder to use for construction.
     * @return The constructed demo Slide.
     */
    public Slide constructDemoSlide(SlideBuilder builder)
    {
        return builder.withTitle("JabberPoint Demo").addTextItem(1, "A demonstration slide").addTextItem(2, "Item 1 using the builder").addTextItem(1, "Adding different items").addTextItem(3, "Sub-item A").addTextItem(3, "Sub-item B").build();
    }

    /**
     * Constructs a simple slide with only a title.
     *
     * @param builder The SlideBuilder to use for construction.
     * @param title   The title for the slide.
     * @return The constructed title Slide.
     */
    public Slide constructTitleSlide(SlideBuilder builder, String title)
    {
        return builder.withTitle(title).build();
    }

    /**
     * Constructs a slide with a title and several level-1 text points.
     *
     * @param builder The SlideBuilder to use for construction.
     * @param title   The title for the slide.
     * @param points  Variable number of text strings for level 1 items.
     * @return The constructed text Slide.
     */
    public Slide constructTextSlide(SlideBuilder builder, String title, String... points)
    {
        builder.withTitle(title);
        for (String point : points)
        {
            builder.addTextItem(1, point); // Assuming level 1 for simplicity
        }
        return builder.build();
    }

    /**
     * Constructs a slide with a title and an image.
     *
     * @param builder   The SlideBuilder to use for construction.
     * @param title     The title for the slide.
     * @param imagePath The path to the image.
     * @return The constructed image Slide.
     */
    public Slide constructImageSlide(SlideBuilder builder, String title, String imagePath)
    {
        return builder.withTitle(title).addBitmapItem(1, imagePath).build();
    }
}
