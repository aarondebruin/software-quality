package com.jabberpoint;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class Slide
{
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    protected String title; // de titel wordt apart bewaard
    protected Vector<SlideItem> items; // de slide-items worden in een Vector bewaard

    public Slide()
    {
        items = new Vector<SlideItem>();
    }

    // Voeg een SlideItem toe
    public void append(SlideItem anItem)
    {
        items.addElement(anItem);
    }

    // geef de titel van de slide
    public String getTitle()
    {
        return title;
    }

    // verander de titel van de slide
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    // Maak een TextItem van String, en voeg het TextItem toe
    public void append(int level, String message)
    {
        append(new TextItem(level, message));
    }

    // geef het betreffende SlideItem
    public SlideItem getSlideItem(int number)
    {
        return items.elementAt(number);
    }

    // geef alle SlideItems in een Vector
    public Vector<SlideItem> getSlideItems()
    {
        return items;
    }

    // geef de afmeting van de Slide
    public int getSize()
    {
        return items.size();
    }

    // teken de slide (behouden voor backward compatibility)
    public void draw(Graphics g, Rectangle area, ImageObserver view)
    {
        // Delegeer naar de SlideRenderer voor SOLID
        SlideRenderer renderer = new SlideRenderer(g, area, view);
        accept(renderer);
    }

    /**
     * Accepteert een SlideVisitor om de slide te renderen of te verwerken.
     * Implementeert het Visitor pattern voor Open/Closed Principle.
     *
     * @param visitor De visitor die de slide zal verwerken
     */
    public void accept(SlideVisitor visitor)
    {
        visitor.visitSlide(this);
    }

    // geef de schaal om de slide te kunnen tekenen (behouden voor backward compatibility)
    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }
}
