package presentation;

import com.jabberpoint.mementoPattern.presentation.PresentationCaretaker;
import com.jabberpoint.mementoPattern.presentation.PresentationMemento;
import com.jabberpoint.mementoPattern.slide.SlideMemento;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PresentationCaretakerTest {

    @Test
    void saveAndRetrieveMemento() {
        PresentationCaretaker caretaker = new PresentationCaretaker();

        ArrayList<SlideMemento> slides1 = new ArrayList<>();
        ArrayList<SlideMemento> slides2 = new ArrayList<>();

        PresentationMemento memento1 = new PresentationMemento("Titel 1", slides1, 0);
        PresentationMemento memento2 = new PresentationMemento("Titel 2", slides2, 1);

        caretaker.saveMemento(memento1);
        caretaker.saveMemento(memento2);

        PresentationMemento last = caretaker.getLastMemento();
        assertNotNull(last);
        assertEquals("Titel 2", last.getTitle());
        assertEquals(1, last.getCurrentSlideNumber());

        PresentationMemento secondLast = caretaker.getLastMemento();
        assertNotNull(secondLast);
        assertEquals("Titel 1", secondLast.getTitle());
        assertEquals(0, secondLast.getCurrentSlideNumber());
    }

    @Test
    void getLastMementoReturnsNullWhenEmpty() {
        PresentationCaretaker caretaker = new PresentationCaretaker();
        assertNull(caretaker.getLastMemento());
    }
}
