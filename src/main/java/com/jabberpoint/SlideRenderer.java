package com.jabberpoint;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 * Een SlideVisitor implementatie die een slide rendert.
 * Implementeert Single Responsibility Principle door rendering logica te scheiden.
 */
public class SlideRenderer implements SlideVisitor
{
    private Graphics graphics;
    private Rectangle area;
    private ImageObserver observer;

    /**
     * Maakt een nieuwe SlideRenderer met de benodigde context.
     *
     * @param graphics De graphics context om in te tekenen
     * @param area     Het gebied waarin de slide moet worden getekend
     * @param observer De ImageObserver voor het laden van afbeeldingen
     */
    public SlideRenderer(Graphics graphics, Rectangle area, ImageObserver observer)
    {
        this.graphics = graphics;
        this.area = area;
        this.observer = observer;
    }

    /**
     * Bezoekt en rendert een slide.
     *
     * @param slide De slide om te renderen
     */
    @Override
    public void visitSlide(Slide slide)
    {
        float scale = getScale(area);
        int y = area.y;
        // De titel wordt apart behandeld
        SlideItem titleItem = new TextItem(0, slide.getTitle());
        Style style = Style.getStyle(titleItem.getLevel());
        titleItem.draw(area.x, y, scale, graphics, style, observer);
        y += titleItem.getBoundingBox(graphics, observer, scale, style).height;
        for (int number = 0; number < slide.getSize(); number++)
        {
            SlideItem slideItem = slide.getSlideItem(number);
            style = Style.getStyle(slideItem.getLevel());
            slideItem.draw(area.x, y, scale, graphics, style, observer);
            y += slideItem.getBoundingBox(graphics, observer, scale, style).height;
        }
    }

    /**
     * Berekent de schaal om de slide te kunnen tekenen.
     *
     * @param area Het gebied waarin de slide moet worden getekend
     * @return De schaalfactor
     */
    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) Slide.WIDTH), ((float) area.height) / ((float) Slide.HEIGHT));
    }
}
