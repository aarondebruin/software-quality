import com.jabberpoint.Presentation;
import com.jabberpoint.menuItems.ViewMenuItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewMenuItemTest {

    @BeforeAll
    static void setupHeadless() {
        System.setProperty("java.awt.headless", "true");
    }

    @Test
    void viewMenuContainsCorrectItems() {
        Presentation dummyPresentation = new Presentation();
        ViewMenuItem viewMenu = new ViewMenuItem(dummyPresentation);

        assertEquals("View", viewMenu.getLabel());

        assertEquals(3, viewMenu.getItemCount());

        assertEquals("Next", viewMenu.getItem(0).getLabel());
        assertEquals("Prev", viewMenu.getItem(1).getLabel());
        assertEquals("Go to", viewMenu.getItem(2).getLabel());
    }
}
