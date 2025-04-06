package commands;

import com.jabberpoint.Presentation;
import com.jabberpoint.Slide;
import com.jabberpoint.commands.NewCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewCommandTest {

    private Presentation presentation;
    private NewCommand newCommand;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        newCommand = new NewCommand(presentation);
    }

    @Test
    void testClearsEmptyPresentation() {
        newCommand.execute();

        assertEquals(0, presentation.getSize(), "Presentation groote moet 0 zijn");
        assertEquals(-1, presentation.getSlideNumber(), "Slide nummer moet -1 zijn");
        assertNull(presentation.getCurrentSlide(), "Huidige slide moet null zijn");
    }

    @Test
    void testClearPresentationWithSlides() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        presentation.append(slide1);
        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide2);
        presentation.setSlideNumber(1);
        assertEquals(2, presentation.getSize(), "Presentation moet 2 slides hebben");
        assertEquals(1, presentation.getSlideNumber(), "Slide nummer moet 1 zijn");

        newCommand.execute();

        assertEquals(0, presentation.getSize(), "Presentation groote moet 0 zijn");
        assertEquals(-1, presentation.getSlideNumber(), "Slide nummer moet -1 zijn");
        assertNull(presentation.getCurrentSlide(), "Huidige slide moet null zijn");
    }
}