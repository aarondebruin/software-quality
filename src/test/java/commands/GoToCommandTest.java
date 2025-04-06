package commands;

import com.jabberpoint.Presentation;
import com.jabberpoint.Slide;
import com.jabberpoint.commands.GoToCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoToCommandTest {

    private Presentation presentation;
    private GoToCommand goToCommand;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
    }

    @Test
    void testValidNumber() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(0);
        goToCommand = new GoToCommand(presentation, "2");

        goToCommand.execute();

        assertEquals(1, presentation.getSlideNumber(), "Slide nummer moet 1 zijn");
        assertEquals("Slide 2", presentation.getCurrentSlide().getTitle(), "Huidige slide moet Slide 2 zijn");
    }

    @Test
    void testInvalidNumber() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        presentation.append(slide1);
        presentation.setSlideNumber(0);
        goToCommand = new GoToCommand(presentation, "abc");

        goToCommand.execute();

        assertEquals(0, presentation.getSlideNumber(), "Slide nummer moet niet veranderen");
        assertEquals("Slide 1", presentation.getCurrentSlide().getTitle(), "Huidige slide moet Slide 1 zijn");
    }

    @Test
    void testOutOfBoundsNumber() {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        presentation.append(slide1);
        presentation.setSlideNumber(0);
        goToCommand = new GoToCommand(presentation, "5");

        goToCommand.execute();

        assertEquals(0, presentation.getSlideNumber(), "Slide nummer moet 0 zijn");
        assertEquals("Slide 1", presentation.getCurrentSlide().getTitle(), "Slide moet Slide 1 zijn");
    }
}