package com.jabberpoint;

import java.awt.Color;
import java.awt.Font;

public class Style {
    private static final String FONTNAME = "Helvetica";
    protected int indent;
    protected Color color;
    protected Font font;
    protected int fontSize;
    protected int leading;

    // Make constructor protected since we're using builder
    protected Style(int indent, Color color, int fontSize, int leading) {
        this.indent = indent;
        this.color = color;
        this.fontSize = fontSize;
        this.font = new Font(FONTNAME, Font.BOLD, fontSize);
        this.leading = leading;
    }

    // Static factory method to get styles
    public static Style getStyle(int level) {
        return switch (level) {
            case 0 -> new StyleBuilder()
                    .withIndent(0)
                    .withColor(Color.red)
                    .withFontSize(48)
                    .withLeading(20)
                    .build();
            case 1 -> new StyleBuilder()
                    .withIndent(20)
                    .withColor(Color.blue)
                    .withFontSize(40)
                    .withLeading(10)
                    .build();
            case 2 -> new StyleBuilder()
                    .withIndent(50)
                    .withColor(Color.black)
                    .withFontSize(36)
                    .withLeading(10)
                    .build();
            case 3 -> new StyleBuilder()
                    .withIndent(70)
                    .withColor(Color.black)
                    .withFontSize(30)
                    .withLeading(10)
                    .build();
            default -> new StyleBuilder()
                    .withIndent(90)
                    .withColor(Color.black)
                    .withFontSize(24)
                    .withLeading(10)
                    .build();
        };
    }

    public String toString() {
        return "[" + indent + "," + color + "; " + fontSize + " on " + leading + "]";
    }

    public Font getFont(float scale) {
        return font.deriveFont(fontSize * scale);
    }
}