import com.jabberpoint.core.SlideItem;
import com.jabberpoint.core.Style;
import com.jabberpoint.mementoPattern.slide.SlideMemento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class CopySlideItem extends SlideItem {
    private final String text;

    public CopySlideItem(int level, String text) {
        super(level);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
        return new Rectangle(0, 0, 100, 30); // Dummy waarden
    }

    @Override
    public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer) {
    }
}

public class SlideMementoTest {
    private SlideMemento slideMemento;

    @BeforeEach
    public void setUp() {
        Vector<SlideItem> items = new Vector<>();
        items.add(new CopySlideItem(1, "Item 1"));
        items.add(new CopySlideItem(2, "Item 2"));
        slideMemento = new SlideMemento("Test Slide", items);
    }

    @Test
    public void testGetTitle() {
        assertEquals("Test Slide", slideMemento.getTitle());
    }

    @Test
    public void testGetItems() {
        Vector<SlideItem> items = slideMemento.getItems();
        assertEquals(2, items.size());
        assertTrue(items.get(0) instanceof CopySlideItem);
        assertTrue(items.get(1) instanceof CopySlideItem);
    }

}
