package commands;

import com.jabberpoint.Presentation;
import com.jabberpoint.Slide;
import com.jabberpoint.XMLAccessor;
import com.jabberpoint.commands.OpenCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Frame;

import static org.junit.jupiter.api.Assertions.*;

class OpenCommandTest {

    private Presentation presentation;
    private Frame frame;
    private OpenCommand openCommand;


    private static class TestAccessor extends XMLAccessor {
        @Override
        public void loadFile(Presentation presentation, String filename) {
            presentation.setTitle("Test Presentation");
            Slide slide = new Slide();
            slide.setTitle("Test Slide");
            presentation.append(slide);
        }
    }

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        frame = new Frame();
        openCommand = new OpenCommand(presentation, frame, new TestAccessor());
    }

    @Test
    void testLoadPresentation() {
        // Act
        openCommand.execute();

        // Assert
        assertEquals("Test Presentation", presentation.getTitle(), "Presentation title moet correct zijn");
        assertEquals(1, presentation.getSize(), "Presentation moet 1 slide hebben");
        assertEquals("Test Slide", presentation.getCurrentSlide().getTitle(), "Slide title moet gelijk zijn");
        assertEquals(0, presentation.getSlideNumber(), "Slide nummer moet 0 zijn");
    }
}