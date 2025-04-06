package com.jabberpoint;

public class SlideBuilder
{
    // The object being built
    private Slide slideInProgress;

    /**
     * Starts the building process by creating a new Slide instance.
     */
    public SlideBuilder()
    {
        this.slideInProgress = new Slide();
    }

    /**
     * Sets the title for the slide being built.
     *
     * @param title The title text.
     * @return The builder instance for chaining.
     */
    public SlideBuilder withTitle(String title)
    {
        this.slideInProgress.setTitle(title);
        return this;
    }

    /**
     * Adds a TextItem to the slide being built.
     *
     * @param level The indentation level.
     * @param text  The text content.
     * @return The builder instance for chaining.
     */
    public SlideBuilder addTextItem(int level, String text)
    {
        this.slideInProgress.append(new TextItem(level, text));
        return this;
    }

    /**
     * Adds a BitmapItem to the slide being built.
     *
     * @param level    The indentation level.
     * @param filename The path to the image file.
     * @return The builder instance for chaining.
     */
    public SlideBuilder addBitmapItem(int level, String filename)
    {
        this.slideInProgress.append(new BitmapItem(level, filename));
        return this;
    }

    /**
     * Adds an existing SlideItem (could be TextItem, BitmapItem, or others)
     * to the slide being built.
     *
     * @param item The SlideItem to add.
     * @return The builder instance for chaining.
     */
    public SlideBuilder addItem(SlideItem item)
    {
        this.slideInProgress.append(item);
        return this;
    }

    /**
     * Finalizes the build process and returns the completed Slide.
     *
     * @return The fully constructed Slide object.
     */
    public Slide build()
    {
        // You could add validation here if needed (e.g., ensure title exists)
        Slide completedSlide = this.slideInProgress;
        // Reset for potential reuse of the builder instance
        this.slideInProgress = new Slide();
        return completedSlide;
    }
}
