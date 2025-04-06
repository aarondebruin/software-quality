import com.jabberpoint.Presentation;
import com.jabberpoint.Slide;
import com.jabberpoint.presentation.PresentationMemento;
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

    @Test
    public void testPrevSlide() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        presentation.append(slide1);

        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide2);

        presentation.setSlideNumber(1);
        presentation.prevSlide();
        assertEquals("Slide 1", presentation.getCurrentSlide().getTitle());
    }

    @Test
    public void testNextSlide() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        presentation.append(slide1);

        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide2);

        presentation.setSlideNumber(0);
        presentation.nextSlide();
        assertEquals("Slide 2", presentation.getCurrentSlide().getTitle());
    }

    @Test
    public void testClearPresentation() {
        Slide slide = new Slide();
        slide.setTitle("Slide 1");
        presentation.append(slide);

        presentation.clear();
        assertEquals(0, presentation.getSize());
        assertNull(presentation.getCurrentSlide());
    }

    @Test
    public void testGetSlide() {
        Slide slide = new Slide();
        slide.setTitle("Slide 1");
        presentation.append(slide);

        Slide retrievedSlide = presentation.getSlide(0);
        assertEquals("Slide 1", retrievedSlide.getTitle());
    }

    @Test
    public void testInvalidSlideNumber() {
        Slide slide = presentation.getSlide(-1);
        assertNull(slide);
        slide = presentation.getSlide(0);
        assertNull(slide);
    }

    @Test
    public void testCreateMemento() {
        presentation.setTitle("Test Presentation");
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        presentation.append(slide1);

        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide2);
        presentation.setSlideNumber(0);

        PresentationMemento memento = presentation.createMemento();

        assertEquals("Test Presentation", memento.getTitle());
        assertEquals(2, memento.getSlides().size());
        assertEquals(0, memento.getCurrentSlideNumber());
    }

    @Test
    public void testRestoreMemento() {
        presentation.setTitle("Original Presentation");
        Slide slide1 = new Slide();
        slide1.setTitle("Original Slide 1");
        presentation.append(slide1);

        presentation.setSlideNumber(0);
        PresentationMemento memento = presentation.createMemento();

        presentation.setTitle("Modified Presentation");
        presentation.append(new Slide());

        presentation.restoreMemento(memento);

        assertEquals("Original Presentation", presentation.getTitle());
        assertEquals(1, presentation.getSize());
        assertEquals("Original Slide 1", presentation.getSlide(0).getTitle());
        assertEquals(0, presentation.getSlideNumber()); // Huidige slide moet ook 0 zijn
    }
}
