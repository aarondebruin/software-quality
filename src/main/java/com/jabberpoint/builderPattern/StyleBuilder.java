package com.jabberpoint.builderPattern;

import com.jabberpoint.core.PresentationStyle;
import com.jabberpoint.core.Style;
import com.jabberpoint.core.StyleBuilderInterface;

import java.awt.Color;

public class StyleBuilder implements StyleBuilderInterface
{
    private int indent;
    private Color color = Color.black; // default
    private int fontSize = 24; // default
    private int leading = 10; // default

    public StyleBuilder()
    {
    }

    @Override
    public StyleBuilder setIndent(int indent)
    {
        this.indent = indent;
        return this;
    }

    @Override
    public StyleBuilder setColor(Color color)
    {
        this.color = color;
        return this;
    }

    @Override
    public StyleBuilder setFontSize(int fontSize)
    {
        this.fontSize = fontSize;
        return this;
    }

    @Override
    public StyleBuilder setLeading(int leading)
    {
        this.leading = leading;
        return this;
    }

    @Override
    public PresentationStyle build()
    {
        return new Style(indent, color, fontSize, leading);
    }
}
