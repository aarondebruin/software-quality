// PresentationStyle.java
package com.jabberpoint.core;

import java.awt.Color;
import java.awt.Font;

public interface PresentationStyle
{
    int getIndent();

    Color getColor();

    Font getFont(float scale);

    int getLeading();

    int getFontSize();
}
