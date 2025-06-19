package style;

import com.jabberpoint.core.Style;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.awt.Font;

import static org.junit.jupiter.api.Assertions.*;

class StyleTest {

    @Test
    void testConstructorAndGetters() {
        int indent = 10;
        Color color = Color.RED;
        int fontSize = 20;
        int leading = 15;

        Style style = new Style(indent, color, fontSize, leading);

        assertEquals(indent, style.getIndent());
        assertEquals(color, style.getColor());
        assertEquals(fontSize, style.getFontSize());
        assertEquals(leading, style.getLeading());

        Font font = style.getFont(1.0f);
        assertEquals("Helvetica", font.getName());
        assertEquals(Font.BOLD, font.getStyle());
        assertEquals(fontSize, font.getSize());

        Font scaledFont = style.getFont(1.5f);
        assertEquals(fontSize * 1.5f, scaledFont.getSize2D(), 0.001);
    }

    @Test
    void testToStringContainsExpectedParts() {
        Style style = new Style(5, Color.BLUE, 18, 12);
        String str = style.toString();

        assertTrue(str.contains("5"));
        assertTrue(str.contains("java.awt.Color"));
        assertTrue(str.contains("18"));
        assertTrue(str.contains("12"));
    }
}
