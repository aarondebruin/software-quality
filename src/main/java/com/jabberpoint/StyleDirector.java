package com.jabberpoint;

import java.awt.Color;

/**
 * StyleDirector provides methods to create predefined styles using the StyleBuilder.
 * This class follows the Director role in the Builder pattern, orchestrating the
 * construction of complex objects using the builder.
 */
public class StyleDirector {
    
    /**
     * Creates a title style (level 0)
     */
    public Style createTitleStyle() {
        return new StyleBuilder()
                .withIndent(0)
                .withColor(Color.red)
                .withFontSize(48)
                .withLeading(20)
                .build();
    }
    
    /**
     * Creates a heading style (level 1)
     */
    public Style createHeadingStyle() {
        return new StyleBuilder()
                .withIndent(20)
                .withColor(Color.blue)
                .withFontSize(40)
                .withLeading(10)
                .build();
    }
    
    /**
     * Creates a subheading style (level 2)
     */
    public Style createSubheadingStyle() {
        return new StyleBuilder()
                .withIndent(50)
                .withColor(Color.black)
                .withFontSize(36)
                .withLeading(10)
                .build();
    }
    
    /**
     * Creates a body text style (level 3)
     */
    public Style createBodyStyle() {
        return new StyleBuilder()
                .withIndent(70)
                .withColor(Color.black)
                .withFontSize(30)
                .withLeading(10)
                .build();
    }
    
    /**
     * Creates a footnote style (level 4)
     */
    public Style createFootnoteStyle() {
        return new StyleBuilder()
                .withIndent(90)
                .withColor(Color.black)
                .withFontSize(24)
                .withLeading(10)
                .build();
    }
    
    /**
     * Creates an emphasis style with dark red color
     */
    public Style createEmphasisStyle() {
        return new StyleBuilder()
                .withIndent(30)
                .withColor(new Color(153, 0, 0)) // Dark red
                .withFontSize(32)
                .withLeading(12)
                .build();
    }
    
    /**
     * Creates a quote style with dark green color and larger indent
     */
    public Style createQuoteStyle() {
        return new StyleBuilder()
                .withIndent(60)
                .withColor(new Color(0, 102, 0)) // Dark green
                .withFontSize(28)
                .withLeading(14)
                .build();
    }
    
    /**
     * Creates a code block style with monospace-like appearance
     */
    public Style createCodeStyle() {
        return new StyleBuilder()
                .withIndent(50)
                .withColor(new Color(0, 0, 102)) // Dark blue
                .withFontSize(24)
                .withLeading(8)
                .build();
    }
    
    /**
     * Creates a style for important notes or warnings
     */
    public Style createWarningStyle() {
        return new StyleBuilder()
                .withIndent(40)
                .withColor(new Color(204, 102, 0)) // Orange
                .withFontSize(30)
                .withLeading(15)
                .build();
    }
    
    /**
     * Creates a style based on a level number
     * This method provides the same functionality as Style.getStyle()
     * but uses the Director pattern
     */
    public Style createStyleForLevel(int level) {
        return switch (level) {
            case 0 -> createTitleStyle();
            case 1 -> createHeadingStyle();
            case 2 -> createSubheadingStyle();
            case 3 -> createBodyStyle();
            default -> createFootnoteStyle();
        };
    }
}
