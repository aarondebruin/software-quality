import com.jabberpoint.core.*;
import com.jabberpoint.io.XMLAccessor;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class XMLAccessorTest {

    private XMLAccessor accessor;
    private Path tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        accessor = new XMLAccessor();
        tempFile = Files.createTempFile("test_presentation", ".xml");
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testSaveAndLoadFile() throws IOException {
        Presentation presentation = new Presentation();
        presentation.setTitle("Test Presentation");

        Slide slide = new Slide();
        slide.append(new TextItem(1, "Dit is een testtekst"));
        slide.append(new BitmapItem(2, "testimage.png"));
        presentation.append(slide);

        accessor.saveFile(presentation, tempFile.toString());

        Presentation loadedPresentation = new Presentation();

    }

}
