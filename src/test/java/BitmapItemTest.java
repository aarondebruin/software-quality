import com.jabberpoint.BitmapItem;
import com.jabberpoint.Style;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

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
