import com.jabberpoint.Presentation;
import com.jabberpoint.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PresentationTest {
    private Presentation presentation;

    @BeforeEach
    public void setUp() {
        presentation = new Presentation();
    }

    @Test
    public void testSetTitle() {
        presentation.setTitle("Test Presentation");
        assertEquals("Test Presentation", presentation.getTitle());
    }

    @Test
    public void testAppendSlide() {
        Slide slide = new Slide();
        slide.setTitle("Slide 1");
        presentation.append(slide);

        assertEquals(1, presentation.getSize());
        assertEquals("Slide 1", presentation.getSlide(0).getTitle());
    }

    @Test
    public void testCurrentSlide() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        presentation.append(slide1);

        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide2);

        presentation.setSlideNumber(0);
        assertEquals("Slide 1", presentation.getCurrentSlide().getTitle());

        presentation.nextSlide();
        assertEquals("Slide 2", presentation.getCurrentSlide().getTitle());
    }

}
