package commands;

import com.jabberpoint.Accessor;
import com.jabberpoint.Presentation;
import com.jabberpoint.Slide;
import com.jabberpoint.XMLAccessor;
import com.jabberpoint.commands.SaveCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Frame;

import static org.junit.jupiter.api.Assertions.*;

class SaveCommandTest {

    private Presentation presentation;
    private Frame frame;
    private SaveCommand saveCommand;
    private TestAccessor testAccessor;

    private static class TestAccessor extends XMLAccessor {
        private boolean wasSaved = false;
        private Presentation savedPresentation;
        private String savedFilename;

        @Override
        public void saveFile(Presentation presentation, String filename) {
            this.wasSaved = true;
            this.savedPresentation = presentation;
            this.savedFilename = filename;
        }

        public boolean wasSaved() {
            return wasSaved;
        }

        public Presentation getSavedPresentation() {
            return savedPresentation;
        }

        public String getSavedFilename() {
            return savedFilename;
        }

        public void reset() {
            wasSaved = false;
            savedPresentation = null;
            savedFilename = null;
        }
    }

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        frame = new Frame();
        testAccessor = new TestAccessor();
        saveCommand = new SaveCommand(presentation, frame, testAccessor);
    }

    @Test
    void testExecuteSavesEmptyPresentation() {
        testAccessor.reset();

        saveCommand.execute();

        assertTrue(testAccessor.wasSaved(), "Saved");
        assertEquals(presentation, testAccessor.getSavedPresentation(), "Juiste presentation");
        assertEquals("dump.xml", testAccessor.getSavedFilename(), "Bestandsnaam moet dump.xml zijn'");
    }

    @Test
    void testExecuteSavesPresentationWithSlides() {
        Slide slide = new Slide();
        slide.setTitle("Test Slide");
        presentation.append(slide);
        presentation.setTitle("Test Presentation");
        testAccessor.reset();

        saveCommand.execute();

        assertTrue(testAccessor.wasSaved(), "Saved");
        assertEquals(presentation, testAccessor.getSavedPresentation(), "Presentation moet opgesalgen zijn");
        assertEquals("dump.xml", testAccessor.getSavedFilename(), "Bestandsnaam moet dump.xml zijn");
        assertEquals("Test Presentation", testAccessor.getSavedPresentation().getTitle(), "Presentation moet Test Presentation zijn");
        assertEquals(1, testAccessor.getSavedPresentation().getSize(), "Presentation moet 1 slide hebben");
    }
}