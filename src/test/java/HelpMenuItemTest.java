import com.jabberpoint.Presentation;
import com.jabberpoint.menuItems.HelpMenuItem;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class HelpMenuItemTest {

    @Test
    void helpMenuContainsAboutItem() {
        Frame dummyFrame = new Frame();
        HelpMenuItem helpMenu = new HelpMenuItem(dummyFrame);

        assertEquals("Help", helpMenu.getLabel());

        assertEquals(1, helpMenu.getItemCount());

        MenuItem aboutItem = helpMenu.getItem(0);
        assertEquals("About", aboutItem.getLabel());
    }
}
