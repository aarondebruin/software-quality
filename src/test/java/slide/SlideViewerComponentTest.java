package slide;

import com.jabberpoint.core.Presentation;
import com.jabberpoint.core.Slide;
import com.jabberpoint.view.SlideViewerComponent;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.Dimension;

import static org.junit.jupiter.api.Assertions.*;

public class SlideViewerComponentTest {

    private Presentation presentation;
    private Slide slide;
    private JFrame frame;
    private SlideViewerComponent component;
    @BeforeAll
    public static void setUpHeadless() {
        System.setProperty("java.awt.headless", "false");
    }

    @BeforeEach
    public void setup() {
        presentation = new Presentation();
        presentation.setTitle("Test Presentation");

        slide = new Slide();
        presentation.append(slide);
        presentation.setSlideNumber(0);

        frame = new JFrame();

        component = new SlideViewerComponent(presentation, frame);
    }

    @Test
    public void testGetPreferredSize() {
        Dimension dim = component.getPreferredSize();
        assertEquals(Slide.WIDTH, dim.width);
        assertEquals(Slide.HEIGHT, dim.height);
    }


    @Test
    public void testUpdateWithSlide() {
        Slide anotherSlide = new Slide();
        presentation.append(anotherSlide);
        presentation.setSlideNumber(1);

        component.update(presentation, anotherSlide);
        assertEquals("Test Presentation", frame.getTitle());
    }




}
