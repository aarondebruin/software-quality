import com.jabberpoint.Presentation;
import com.jabberpoint.PresentationBuilder;
import com.jabberpoint.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PresentationBuilderTest {

    private PresentationBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new PresentationBuilder();
    }

    @Test
    void testBuildEmptyPresentation() {
        Presentation presentation = builder.build();

        assertEquals("", presentation.getTitle(), "Title moet leeg zijn");
        assertEquals(0, presentation.getSize(), "Presentation groote moet leeg zijn");
    }

    @Test
    void testWithTitle() {
        Presentation presentation = builder.withTitle("Test Title").build();

        assertEquals("Test Title", presentation.getTitle(), "Title moet Test Title zijn");
        assertEquals(0, presentation.getSize(), "Presentation moet geen slides heben");
    }

    @Test
    void testAddSlide() {
        Slide slide = new Slide();
        slide.setTitle("Test Slide");

        Presentation presentation = builder.addSlide(slide).build();
        assertEquals("", presentation.getTitle(), "Title moet leeg zijn");
        assertEquals(1, presentation.getSize(), "Presentation size moet 1 zijn");
        assertEquals(slide, presentation.getSlide(0), "Slide moet toegevoegd worden");
        assertEquals("Test Slide", presentation.getSlide(0).getTitle(), "Slide title moet Test Slide zijn");
    }

    @Test
    void testAddSlides() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        List<Slide> slides = new ArrayList<>();
        slides.add(slide1);
        slides.add(slide2);

        Presentation presentation = builder.addSlides(slides).build();

        assertEquals("", presentation.getTitle(), "Title moet leeg zijn");
        assertEquals(2, presentation.getSize(), "Presentation moet 2 slides hebben");
        assertEquals(slide1, presentation.getSlide(0), "Eeerste slide moet slide1 zijn");
        assertEquals("Slide 1", presentation.getSlide(0).getTitle(), "Slide title moet Slide 1 zijn");
        assertEquals(slide2, presentation.getSlide(1), "tweede slide moet slide2 zijn");
        assertEquals("Slide 2", presentation.getSlide(1).getTitle(), "Tweede slide title moet Slide 2 zijn");
    }
}