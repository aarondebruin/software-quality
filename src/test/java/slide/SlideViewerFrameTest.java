package slide;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import com.jabberpoint.core.Presentation;
import com.jabberpoint.view.SlideViewerFrame;

import java.awt.Dimension;

public class SlideViewerFrameTest {

    @BeforeAll
    public static void setUpHeadless() {
        System.setProperty("java.awt.headless", "false");
    }

    @Test
    public void testConstructorDoesNotThrowInTestMode() {
        Presentation pres = new Presentation();
        SlideViewerFrame frame = new SlideViewerFrame("Test Title", pres, true);

        assertNotNull(frame);
        assertEquals("Jabberpoint 1.6 - OU", frame.getTitle());
        assertEquals(new Dimension(SlideViewerFrame.WIDTH, SlideViewerFrame.HEIGHT), frame.getSize());
    }

    @Test
    public void testSetupWindowAddsComponents() {
        Presentation pres = new Presentation();
        SlideViewerFrame frame = new SlideViewerFrame("Test Title", pres, true);

        frame.setupWindow(frame.getContentPane().getComponent(0) instanceof com.jabberpoint.view.SlideViewerComponent
                ? (com.jabberpoint.view.SlideViewerComponent)frame.getContentPane().getComponent(0)
                : null, pres);

        assertEquals("Jabberpoint 1.6 - OU", frame.getTitle());

        assertTrue(frame.getContentPane().getComponentCount() > 0);

        assertNotNull(frame.getMenuBar());

        assertEquals(new Dimension(SlideViewerFrame.WIDTH, SlideViewerFrame.HEIGHT), frame.getSize());

    }
}
