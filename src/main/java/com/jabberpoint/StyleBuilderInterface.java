// StyleBuilderInterface.java
package com.jabberpoint;

import java.awt.Color;

public interface StyleBuilderInterface
{
    StyleBuilderInterface withIndent(int indent);

    StyleBuilderInterface withColor(Color color);

    StyleBuilderInterface withFontSize(int fontSize);

    StyleBuilderInterface withLeading(int leading);

    PresentationStyle build();
}
