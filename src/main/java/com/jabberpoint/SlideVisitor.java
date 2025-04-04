package com.jabberpoint;

public interface SlideVisitor
{
    /**
     * Bezoekt een slide om deze te verwerken.
     *
     * @param slide De slide om te bezoeken
     */
    void visitSlide(Slide slide);
}
