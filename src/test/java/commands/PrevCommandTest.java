package commands;

import com.jabberpoint.Presentation;
import com.jabberpoint.Slide;
import com.jabberpoint.commandPattern.commands.PrevCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrevCommandTest {

    private Presentation presentation;
    private PrevCommand prevCommand;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        prevCommand = new PrevCommand(presentation);
    }

    @Test
    void testEmptyPresentation() {
        prevCommand.execute();

        assertEquals(-1, presentation.getSlideNumber(), "Slide nummmer moet -1 blijven");
        assertNull(presentation.getCurrentSlide(), "Huidige slide moet null zijn");
    }

    @Test
    void testToPreviousSlide() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(1); // Start op tweede slide
        assertEquals(1, presentation.getSlideNumber(), "Slide nummer moet 1 zijn");

        prevCommand.execute();

        assertEquals(0, presentation.getSlideNumber(), "Slide nummer moet 0 zijn");
        assertEquals("Slide 1", presentation.getCurrentSlide().getTitle(), "Huidige slide moe Slide 1 zijn");
    }

    @Test
    void testFirstSlide() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(0);
        assertEquals(0, presentation.getSlideNumber(), "Slide nummmer moet 0 zijn");

        prevCommand.execute();

        assertEquals(0, presentation.getSlideNumber(), "Slide nummmer moet 0 zijn");
        assertEquals("Slide 1", presentation.getCurrentSlide().getTitle(), "Slide moet Slide 1 zijn");
    }
}