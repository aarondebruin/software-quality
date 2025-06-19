package style;

import com.jabberpoint.builderPattern.StyleBuilder;
import com.jabberpoint.core.PresentationStyle;
import com.jabberpoint.director.StyleDirector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

class StyleDirectorTest {

    private StyleDirector director;

    @BeforeEach
    void setUp() {
        director = new StyleDirector(new StyleBuilder());
    }

    @Test
    void testCreateTitleStyle() {
        PresentationStyle style = director.createTitleStyle();
        assertEquals(0, style.getIndent());
        assertEquals(Color.RED, style.getColor());
        assertEquals(48, style.getFontSize());
        assertEquals(20, style.getLeading());
    }

    @Test
    void testCreateHeadingStyle() {
        PresentationStyle style = director.createHeadingStyle();
        assertEquals(20, style.getIndent());
        assertEquals(Color.BLUE, style.getColor());
        assertEquals(40, style.getFontSize());
        assertEquals(10, style.getLeading());
    }

    @Test
    void testCreateSubheadingStyle() {
        PresentationStyle style = director.createSubheadingStyle();
        assertEquals(50, style.getIndent());
        assertEquals(Color.BLACK, style.getColor());
        assertEquals(36, style.getFontSize());
        assertEquals(10, style.getLeading());
    }

    @Test
    void testCreateBodyStyle() {
        PresentationStyle style = director.createBodyStyle();
        assertEquals(70, style.getIndent());
        assertEquals(Color.BLACK, style.getColor());
        assertEquals(30, style.getFontSize());
        assertEquals(10, style.getLeading());
    }

    @Test
    void testCreateFootnoteStyle() {
        PresentationStyle style = director.createFootnoteStyle();
        assertEquals(90, style.getIndent());
        assertEquals(Color.BLACK, style.getColor());
        assertEquals(24, style.getFontSize());
        assertEquals(10, style.getLeading());
    }

    @Test
    void testCreateStyleForLevel() {
        PresentationStyle style0 = director.createStyleForLevel(0);
        PresentationStyle expected0 = director.createTitleStyle();
        assertEquals(expected0.getIndent(), style0.getIndent());
        assertEquals(expected0.getColor(), style0.getColor());
        assertEquals(expected0.getFontSize(), style0.getFontSize());
        assertEquals(expected0.getLeading(), style0.getLeading());

        PresentationStyle style1 = director.createStyleForLevel(1);
        PresentationStyle expected1 = director.createHeadingStyle();
        assertEquals(expected1.getIndent(), style1.getIndent());
        assertEquals(expected1.getColor(), style1.getColor());
        assertEquals(expected1.getFontSize(), style1.getFontSize());
        assertEquals(expected1.getLeading(), style1.getLeading());
    }
}
