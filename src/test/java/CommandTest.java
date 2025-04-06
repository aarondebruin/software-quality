import com.jabberpoint.Slide;
import com.jabberpoint.commands.*;
import com.jabberpoint.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {
    private Presentation presentation;
    private Frame parentFrame;
    @BeforeEach
    public void setUp() {
        presentation = new Presentation();
        parentFrame = new Frame();
    }

    @Test
    public void testOpenCommand() {
        OpenCommand openCommand = new OpenCommand(presentation, parentFrame);

        openCommand.execute();

        assertEquals(0, presentation.getSize());
    }

    @Test
    public void testSaveCommand() {
        SaveCommand saveCommand = new SaveCommand(presentation, null);

        Slide slide = new Slide();
        slide.setTitle("Slide 1");
        presentation.append(slide);

        saveCommand.execute();

        assertEquals(1, presentation.getSize());
    }

    @Test
    public void testNewCommand() {
        NewCommand newCommand = new NewCommand(presentation);

        Slide slide = new Slide();
        slide.setTitle("Slide 1");
        presentation.append(slide);

        newCommand.execute();

        assertEquals(0, presentation.getSize());
    }
    @Test
    public void testNextCommand() {
        NextCommand nextCommand = new NextCommand(presentation);
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(0);
        nextCommand.execute();
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testPrevCommand() {
        PrevCommand prevCommand = new PrevCommand(presentation);
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(1);
        prevCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
    }
}
