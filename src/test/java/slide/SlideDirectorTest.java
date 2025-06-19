package slide;

import com.jabberpoint.builderPattern.SlideBuilder;
import com.jabberpoint.core.Slide;
import com.jabberpoint.core.SlideItem;
import com.jabberpoint.core.TextItem;
import com.jabberpoint.director.SlideDirector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class SlideDirectorTest {

    private SlideDirector director;
    private SlideBuilder builder;

    @BeforeEach
    public void setUp() {
        director = new SlideDirector();
        builder = new SlideBuilder();
    }

    @Test
    public void testConstructDemoSlide() {
        Slide slide = director.constructDemoSlide(builder);

        assertNotNull(slide);
        assertEquals("JabberPoint Demo", slide.getTitle());
        assertEquals(5, slide.getSize());

        Vector<SlideItem> items = slide.getSlideItems();
        assertTrue(items.get(0) instanceof TextItem);
        assertTrue(((TextItem) items.get(0)).getText().contains("A demonstration slide"));
    }

    @Test
    public void testConstructTitleSlide() {
        Slide slide = director.constructTitleSlide(builder, "Welcome!");

        assertNotNull(slide);
        assertEquals("Welcome!", slide.getTitle());
        assertEquals(0, slide.getSize());
    }

    @Test
    public void testConstructTextSlide() {
        Slide slide = director.constructTextSlide(builder, "Main Points", "Point 1", "Point 2", "Point 3");

        assertNotNull(slide);
        assertEquals("Main Points", slide.getTitle());
        assertEquals(3, slide.getSize());

        SlideItem item = slide.getSlideItem(1);
        assertTrue(item instanceof TextItem);
        assertEquals("Point 2", ((TextItem) item).getText());
    }

    @Test
    public void testConstructImageSlide() {
        Slide slide = director.constructImageSlide(builder, "Image Title", "images/example.png");

        assertNotNull(slide);
        assertEquals("Image Title", slide.getTitle());
        assertEquals(1, slide.getSize());

        SlideItem item = slide.getSlideItem(0);
        // We weten niet zeker of dit een BitmapItem of TextItem is zonder jouw klasse
        assertNotNull(item);
        assertTrue(item.toString().contains("images/example.png"));
    }
}
