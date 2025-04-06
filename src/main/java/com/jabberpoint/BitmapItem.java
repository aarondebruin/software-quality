package com.jabberpoint;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BitmapItem extends SlideItem
{
    private BufferedImage bufferedImage;
    private String imageName;
    protected static final String FILE = "Bestand ";
    protected static final String NOTFOUND = " niet gevonden";

    public BitmapItem(int level, String name)
    {
        super(level);
        imageName = name;
        try
        {
            if (name != null && !name.isEmpty())
            {
                bufferedImage = ImageIO.read(new File(imageName));
            }
        } catch (IOException e)
        {
            System.err.println(FILE + imageName + NOTFOUND);
        }
    }

    public BitmapItem()
    {
        this(0, null);
    }

    public String getName()
    {
        return imageName;
    }

    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle)
    {
        if (bufferedImage == null)
        {
            return new Rectangle((int) (myStyle.getIndent() * scale), 0, 0, 0);
        }
        return new Rectangle((int) (myStyle.getIndent() * scale), 0, (int) (bufferedImage.getWidth(observer) * scale), ((int) (myStyle.getLeading() * scale)) + (int) (bufferedImage.getHeight(observer) * scale));
    }

    public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer)
    {
        if (bufferedImage == null)
        {
            return; // Skip drawing if image couldn't be loaded
        }
        int width = x + (int) (myStyle.getIndent() * scale);
        int height = y + (int) (myStyle.getLeading() * scale);
        g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale), (int) (bufferedImage.getHeight(observer) * scale), observer);
    }

    public String toString()
    {
        return "BitmapItem[" + getLevel() + "," + imageName + "]";
    }
}
