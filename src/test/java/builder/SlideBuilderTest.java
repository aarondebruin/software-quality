package builder;

import com.jabberpoint.builderPattern.SlideBuilder;
import com.jabberpoint.core.BitmapItem;
import com.jabberpoint.core.Slide;
import com.jabberpoint.core.SlideItem;
import com.jabberpoint.core.TextItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlideBuilderTest {

    private SlideBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new SlideBuilder();
    }

    @Test
    void testBuildEmptySlide() {
        Slide slide = builder.build();

        assertNull(slide.getTitle(), "Title moet null zijn");
        assertEquals(0, slide.getSize(), "Slide groote moet 0 zijn");
    }

    @Test
    void testWithTitle() {
        Slide slide = builder.setTitle("Test Title").build();

        assertEquals("Test Title", slide.getTitle(), "Title moet Test Title zijn");
        assertEquals(0, slide.getSize(), "Slide groote moet 0 zijn");
    }

    @Test
    void testAddTextItem() {
        Slide slide = builder.addTextItem(1, "Test Text").build();

        assertNull(slide.getTitle(), "Title moet null izjn");
        assertEquals(1, slide.getSize(), "Slide groote moet 1 zijn");
        SlideItem item = slide.getSlideItem(0);
        assertTrue(item instanceof TextItem, "Item moet een TextItem zijn");
        assertEquals(1, item.getLevel(), "Item level moet 1 zijn");
        assertEquals("Test Text", ((TextItem) item).getText(), "Item text moet Test Text zijn");
    }

    @Test
    void testAddBitmapItem() {
        Slide slide = builder.addBitmapItem(2, "image.jpg").build();

        assertNull(slide.getTitle(), "Title moet null zijn");
        assertEquals(1, slide.getSize(), "Slide groote moet 1 zijn");
        SlideItem item = slide.getSlideItem(0);
        assertTrue(item instanceof BitmapItem, "Item moet een BitmapItem zijn");
        assertEquals(2, item.getLevel(), "Item level moet 2 zijn");
        assertEquals("image.jpg", ((BitmapItem) item).getName(), "Item filename moet image.jpg zijn");
    }

    @Test
    void testAddItem() {
        SlideItem customItem = new TextItem(3, "Custom Text");

        Slide slide = builder.addItem(customItem).build();

        assertNull(slide.getTitle(), "Title null zijn");
        assertEquals(1, slide.getSize(), "Slide moet 1 zijn");
        SlideItem item = slide.getSlideItem(0);
        assertEquals(customItem, item, "Item moet een CustomItem zijn");
        assertTrue(item instanceof TextItem, "Item moet een TextItem zijn");
        assertEquals(3, item.getLevel(), "Item level moet 3 zijn");
        assertEquals("Custom Text", ((TextItem) item).getText(), "Item text moet gelijk zijn");
    }

    @Test
    void testFullConfig() {
        Slide slide = builder
                .setTitle("Full Slide")
                .addTextItem(1, "Text Item")
                .addBitmapItem(2, "image.png")
                .addItem(new TextItem(3, "Custom Item"))
                .build();

        assertEquals("Full Slide", slide.getTitle(), "Title moet gelijk zijn");
        assertEquals(3, slide.getSize(), "Slide groote moet 3 zijn");

        SlideItem item1 = slide.getSlideItem(0);
        assertTrue(item1 instanceof TextItem, "Eerste item moet een TextItem zijn");
        assertEquals(1, item1.getLevel(), "Eerste item level moet 1 zijn");
        assertEquals("Text Item", ((TextItem) item1).getText(), "Eerste item text moet Text Item zijn");

        SlideItem item2 = slide.getSlideItem(1);
        assertTrue(item2 instanceof BitmapItem, "Tweede item moet een BitmapItem zijn");
        assertEquals(2, item2.getLevel(), "Tweede item level moet 2 zijn");
        assertEquals("image.png", ((BitmapItem) item2).getName(), "Tweede item moet image.png zijn");

        SlideItem item3 = slide.getSlideItem(2);
        assertTrue(item3 instanceof TextItem, "Derde item moet een TextItem zijn");
        assertEquals(3, item3.getLevel(), "Derde item level 3 zijn");
        assertEquals("Custom Item", ((TextItem) item3).getText(), "Derde item moet de text Custom Item zijn");
    }


}