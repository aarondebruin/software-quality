
import com.jabberpoint.core.SlideItem;
import com.jabberpoint.mementoPattern.slide.SlideCaretaker;
import com.jabberpoint.mementoPattern.slide.SlideMemento;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SlideCaretakerTest {

    @Test
    void testSaveAndGetLastMemento() {
        SlideCaretaker caretaker = new SlideCaretaker();

        Vector<SlideItem> items1 = new Vector<>();
        Vector<SlideItem> items2 = new Vector<>();

        SlideMemento memento1 = new SlideMemento("Title1", items1);
        SlideMemento memento2 = new SlideMemento("Title2", items2);

        caretaker.saveMemento(memento1);
        caretaker.saveMemento(memento2);

        assertEquals(memento2, caretaker.getLastMemento());
        assertEquals(memento1, caretaker.getLastMemento());
        assertNull(caretaker.getLastMemento());
    }
}
