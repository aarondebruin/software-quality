package com.jabberpoint;

import java.awt.Color;
import java.awt.Font;

public class Style implements PresentationStyle
{
    private static final String FONTNAME = "Helvetica";
    private final int indent;
    private final Color color;
    private final Font font;
    private final int fontSize;
    private final int leading;

    // Package-private constructor for builder
    Style(int indent, Color color, int fontSize, int leading)
    {
        this.indent = indent;
        this.color = color;
        this.fontSize = fontSize;
        this.font = new Font(FONTNAME, Font.BOLD, fontSize);
        this.leading = leading;
    }

    @Override
    public int getIndent()
    {
        return indent;
    }

    @Override
    public Color getColor()
    {
        return color;
    }

    @Override
    public Font getFont(float scale)
    {
        return font.deriveFont(fontSize * scale);
    }

    @Override
    public int getLeading()
    {
        return leading;
    }

    @Override
    public int getFontSize()
    {
        return fontSize;
    }

    @Override
    public String toString()
    {
        return "[" + indent + "," + color + "; " + fontSize + " on " + leading + "]";
    }

    public static Style getStyle(int level)
    {
        StyleDirector director = new StyleDirector(new StyleBuilder());
        return (Style) director.createStyleForLevel(level);
    }
}
