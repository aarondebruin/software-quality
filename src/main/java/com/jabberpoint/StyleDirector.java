package com.jabberpoint;

import java.awt.Color;

/**
 * StyleDirector provides methods to create predefined styles using the StyleBuilder.
 * This class follows the Director role in the Builder pattern, orchestrating the
 * construction of complex objects using the builder.
 */
public class StyleDirector
{
    private final StyleBuilderInterface builder;

    public StyleDirector(StyleBuilderInterface builder)
    {
        this.builder = builder;
    }

    /**
     * Creates a title style (level 0)
     */
    public PresentationStyle createTitleStyle()
    {
        return builder.withIndent(0).withColor(Color.red).withFontSize(48).withLeading(20).build();
    }

    /**
     * Creates a heading style (level 1)
     */
    public PresentationStyle createHeadingStyle()
    {
        return builder.withIndent(20).withColor(Color.blue).withFontSize(40).withLeading(10).build();
    }

    /**
     * Creates a subheading style (level 2)
     */
    public PresentationStyle createSubheadingStyle()
    {
        return builder.withIndent(50).withColor(Color.black).withFontSize(36).withLeading(10).build();
    }

    /**
     * Creates a body style (level 3)
     */
    public PresentationStyle createBodyStyle()
    {
        return builder.withIndent(70).withColor(Color.black).withFontSize(30).withLeading(10).build();
    }

    /**
     * Creates a footnote style (level 4)
     */
    public PresentationStyle createFootnoteStyle()
    {
        return builder.withIndent(90).withColor(Color.black).withFontSize(24).withLeading(10).build();
    }

    /**
     * Creates a style based on a level number
     */
    public PresentationStyle createStyleForLevel(int level)
    {
        return switch (level)
        {
            case 0 -> createTitleStyle();
            case 1 -> createHeadingStyle();
            case 2 -> createSubheadingStyle();
            case 3 -> createBodyStyle();
            default -> createFootnoteStyle();
        };
    }
}
