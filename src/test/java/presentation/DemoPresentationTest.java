package presentation;

import com.jabberpoint.core.Presentation;
import com.jabberpoint.core.Slide;
import com.jabberpoint.core.SlideItem;
import com.jabberpoint.core.TextItem;
import com.jabberpoint.io.DemoPresentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DemoPresentationTest {

    private DemoPresentation demoAccessor;
    private Presentation presentation;

    @BeforeEach
    void setUp() {
        demoAccessor = new DemoPresentation();
        presentation = new Presentation();
    }

    @Test
    void testLoadDemoPresentation() throws IOException {
        demoAccessor.loadFile(presentation, "");

        assertEquals("Demonstratie presentatie", presentation.getTitle());
        assertEquals(4, presentation.getSize());

        Slide slide1 = presentation.getSlide(0);
        assertNotNull(slide1);
        assertEquals("JabberPoint Demo", slide1.getTitle());
        assertTrue(slide1.getSlideItems().size() > 0);

        Slide slide2 = presentation.getSlide(1);
        assertEquals("Builder Pattern Benefits", slide2.getTitle());
        assertEquals(0, slide2.getSize());

        Slide slide3 = presentation.getSlide(2);
        assertEquals("Key Benefits", slide3.getTitle());
        assertEquals(3, slide3.getSize());
        SlideItem item = slide3.getSlideItem(0);
        assertTrue(item instanceof TextItem);
        assertTrue(((TextItem) item).getText().contains("Separates"));

        Slide slide4 = presentation.getSlide(3);
        assertEquals("Manual Construction Example", slide4.getTitle());
        assertTrue(slide4.getSize() >= 3);
    }

    @Test
    void testSaveFileThrowsException() {
        assertThrows(IOException.class, () -> demoAccessor.saveFile(presentation, "demo.xml"));
    }
}
