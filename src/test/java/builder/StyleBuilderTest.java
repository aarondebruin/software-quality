package builder;

import com.jabberpoint.builderPattern.StyleBuilder;
import com.jabberpoint.core.PresentationStyle;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

class StyleBuilderTest {

    @Test
    void testDefaultValues() {
        StyleBuilder builder = new StyleBuilder();
        PresentationStyle style = builder.build();

        // Standaardwaarden uit jouw builder:
        assertEquals(0, style.getIndent());
        assertEquals(Color.black, style.getColor());
        assertEquals(24, style.getFontSize());
        assertEquals(10, style.getLeading());
    }

    @Test
    void testSetIndent() {
        StyleBuilder builder = new StyleBuilder();
        builder.setIndent(15);
        PresentationStyle style = builder.build();
        assertEquals(15, style.getIndent());
    }

    @Test
    void testSetColor() {
        StyleBuilder builder = new StyleBuilder();
        Color red = Color.RED;
        builder.setColor(red);
        PresentationStyle style = builder.build();
        assertEquals(red, style.getColor());
    }

    @Test
    void testSetFontSize() {
        StyleBuilder builder = new StyleBuilder();
        builder.setFontSize(30);
        PresentationStyle style = builder.build();
        assertEquals(30, style.getFontSize());
    }

    @Test
    void testSetLeading() {
        StyleBuilder builder = new StyleBuilder();
        builder.setLeading(12);
        PresentationStyle style = builder.build();
        assertEquals(12, style.getLeading());
    }

    @Test
    void testChainedMethods() {
        StyleBuilder builder = new StyleBuilder();
        PresentationStyle style = builder
                .setIndent(5)
                .setColor(Color.BLUE)
                .setFontSize(18)
                .setLeading(8)
                .build();

        assertEquals(5, style.getIndent());
        assertEquals(Color.BLUE, style.getColor());
        assertEquals(18, style.getFontSize());
        assertEquals(8, style.getLeading());
    }
}
