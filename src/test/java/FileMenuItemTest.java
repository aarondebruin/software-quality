import com.jabberpoint.Presentation;
import com.jabberpoint.menuItems.FileMenuItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FileMenuItemTest {

    @BeforeAll
    static void setupHeadless() {
        System.setProperty("java.awt.headless", "true");
    }

    @Test
    void fileMenuContainsCorrectItems() {
        Frame dummyFrame = new Frame();
        Presentation dummyPresentation = new Presentation();
        FileMenuItem fileMenu = new FileMenuItem(dummyFrame, dummyPresentation);

        assertEquals(5, fileMenu.getItemCount());

        assertEquals("Open", fileMenu.getItem(0).getLabel());
        assertEquals("New", fileMenu.getItem(1).getLabel());
        assertEquals("Save", fileMenu.getItem(2).getLabel());
        assertEquals("-", fileMenu.getItem(3).getLabel());
        assertEquals("Exit", fileMenu.getItem(4).getLabel());
    }
}