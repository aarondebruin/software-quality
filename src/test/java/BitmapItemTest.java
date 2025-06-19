import com.jabberpoint.core.BitmapItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitmapItemTest {

    @Test
    void testGetNameReturnsCorrectValue() {
        BitmapItem item = new BitmapItem(1, "example.jpg");
        assertEquals("example.jpg", item.getName());
    }

    @Test
    void testToStringReturnsCorrectFormat() {
        BitmapItem item = new BitmapItem(2, "image.png");
        assertEquals("BitmapItem[2,image.png]", item.toString());
    }
}
