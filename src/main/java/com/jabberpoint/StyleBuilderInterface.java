package com.jabberpoint;

import java.awt.Color;

public interface StyleBuilderInterface
{
    StyleBuilderInterface setIndent(int indent);

    StyleBuilderInterface setColor(Color color);

    StyleBuilderInterface setFontSize(int fontSize);

    StyleBuilderInterface setLeading(int leading);

    PresentationStyle build();
}
