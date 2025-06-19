package commands;

import com.jabberpoint.Presentation;
import com.jabberpoint.Slide;
import com.jabberpoint.commandPattern.commands.NextCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextCommandTest {

    private Presentation presentation;
    private NextCommand nextCommand;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        nextCommand = new NextCommand(presentation);
    }

    @Test
    void testEmptyPresentation() {
        nextCommand.execute();

        assertEquals(-1, presentation.getSlideNumber(), "Slide nummer moet -1 zijn");
        assertNull(presentation.getCurrentSlide(), "Huidge slides moet null zijn");
    }

    @Test
    void testNextSlide() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(0);
        assertEquals(0, presentation.getSlideNumber(), "Slide nummer moet null zijn");

        nextCommand.execute();

        assertEquals(1, presentation.getSlideNumber(), "Slide moet 1 zijn");
        assertEquals("Slide 2", presentation.getCurrentSlide().getTitle(), "Huidige slide moet Slide 2 zijn");
    }

    @Test
    void testLastSlide() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(1);
        assertEquals(1, presentation.getSlideNumber(), "Slide nummer moet 1 zijn");

        nextCommand.execute();

        assertEquals(1, presentation.getSlideNumber(), "Slide nummer moet 1 zijn");
        assertEquals("Slide 2", presentation.getCurrentSlide().getTitle(), "Slide moet Slide 2 zijn");
    }
}