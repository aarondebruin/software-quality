package com.jabberpoint;

import java.awt.Color;

public class StyleBuilder {
    private int indent;
    private Color color = Color.black; // default
    private int fontSize = 24; // default
    private int leading = 10; // default

    public StyleBuilder() {
        // Default constructor
    }

    public StyleBuilder withIndent(int indent) {
        this.indent = indent;
        return this;
    }

    public StyleBuilder withColor(Color color) {
        this.color = color;
        return this;
    }

    public StyleBuilder withFontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public StyleBuilder withLeading(int leading) {
        this.leading = leading;
        return this;
    }

    public Style build() {
        return new Style(indent, color, fontSize, leading);
    }
}