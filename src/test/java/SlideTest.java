import com.jabberpoint.core.Slide;
import com.jabberpoint.core.SlideItem;
import com.jabberpoint.core.TextItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SlideTest {

    private Slide slide;

    @BeforeEach
    void setUp() {
        slide = new Slide();
    }

    @Test
    void testInitialState() {
        assertNull(slide.getTitle(), "Titel moet null zijn");
        assertEquals(0, slide.getSize(), "Groote moet 0 zijn");
        assertNotNull(slide.getSlideItems(), "Slides moet leeg zijn");
        assertEquals(0, slide.getSlideItems().size(), "Slideitems moet 0 zijn");
    }

    @Test
    void testSetAndGetTitle() {
        slide.setTitle("Test Title");
        assertEquals("Test Title", slide.getTitle(), "Titel moet ingesteld zijn");
    }

    @Test
    void testAppendSlideItem() {
        SlideItem item = new TextItem(1, "Test Item");
        slide.append(item);
        assertEquals(1, slide.getSize(), "Groote moet 1 zijn");
        assertEquals(item, slide.getSlideItem(0), "Nieuwe item moet op 0 staan");
        assertEquals(1, slide.getSlideItems().size(), "Slideitems moet 1 zijn");
    }

    @Test
    void testAppendTextItem() {
        slide.append(2, "Test Text");
        assertEquals(1, slide.getSize(), "Groote moet 1 zijn");
        SlideItem item = slide.getSlideItem(0);
        assertTrue(item instanceof TextItem, "Item moet een TextItem zijn");
        assertEquals(2, item.getLevel(), "TextItem level moet 2 zijn");
        assertEquals("Test Text", ((TextItem) item).getText(), "TextItem text moet overheen komen");
    }

    @Test
    void testGetSlideItemInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> slide.getSlideItem(0),
                "Het ophalen van een item op index 0 op een lege dia zou IndexOutOfBoundsException moeten geven");

        slide.append(new TextItem(1, "Item"));
        assertThrows(IndexOutOfBoundsException.class, () -> slide.getSlideItem(1),
                "Het ophalen van een item op een ongeldige index zou IndexOutOfBoundsException moeten geven");
    }

    @Test
    void testGetSlideItemsEdit() {
        // Arrange
        SlideItem item = new TextItem(1, "Test Item");
        slide.append(item);

        // Act
        Vector<SlideItem> items = slide.getSlideItems();
        items.addElement(new TextItem(2, "New Item")); // Wijzig de geretourneerde Vector

        // Assert
        assertEquals(2, slide.getSize(), "Slide groote moet 2 zijn");
        assertEquals(2, slide.getSlideItems().size(), "Slide items moet 2 zijn");
        assertEquals(item, slide.getSlideItem(0), "Orignele item moet op 0 staan");
        assertEquals("New Item", ((TextItem) slide.getSlideItem(1)).getText(), "New item moet worden toegevoegd");
    }

}

