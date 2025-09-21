package validation_tests;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import compilation.Printer;
import compilation.fileHandler;

public class fileHandlerTests {

    @BeforeAll
    public static void initPrinter() {
        Printer.init();
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void pathCorrectTest() {
        Assertions.assertDoesNotThrow(() -> fileHandler.readFile("Peano.txt"));
    }

    @Test
    public void correctTextInFileTest() throws IOException {

        String contentFile = fileHandler.readFile("test.txt");
        Assertions.assertEquals("test", contentFile.toString());
    }
}
