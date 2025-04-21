package compiler_tests;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import compilation.MathCompiler;
import compilation.Printer;

public class LexSyntaxTests {

    MathCompiler compilerForTests;

    @BeforeAll
    public static void initPrinter() {
        Printer.init();
    }

    @BeforeEach
    public void initMathCompiler() {
        compilerForTests = new MathCompiler();
    }

    @AfterEach
    public void NullifyAllVariables() {
        compilerForTests = null;
    }

    public static String encapsulateWithTheory(String mathCode) {
        final String beforeText = "Theory {";
        final String afterText = "}";
        return beforeText + mathCode + afterText;
    }

    public void testCompilerWithCode(String code) {
        // Printer.PIECode(code);
        System.setIn(new java.io.ByteArrayInputStream(code.getBytes()));
        compilerForTests.launchCompilation("/");
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testEmptyCode() {
        assertDoesNotThrow(() -> testCompilerWithCode(""));
    }

    @Test
    public void testEmptyTheory() {
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory("")));
    }
}
