import com.jabberpoint.Style;
import com.jabberpoint.TextItem;
import org.junit.jupiter.api.Test;

import java.awt.Font;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import static org.junit.jupiter.api.Assertions.*;

class TextItemTest {

    @Test
    void testGetTextReturnsCorrectString() {
        TextItem item = new TextItem(1, "Hello World");
        assertEquals("Hello World", item.getText());
    }

    @Test
    void testGetTextReturnsEmptyWhenNull() {
        TextItem item = new TextItem(1, null);
        assertEquals("", item.getText());
    }

    @Test
    void testToStringRepresentation() {
        TextItem item = new TextItem(2, "Test");
        assertEquals("TextItem[2,Test]", item.toString());
    }

    @Test
    void testDefaultConstructor() {
        TextItem item = new TextItem();
        assertEquals("No Text Given", item.getText());
        assertEquals(0, item.getLevel());
    }


}
