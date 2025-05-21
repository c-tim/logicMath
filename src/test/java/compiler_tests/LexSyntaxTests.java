package compiler_tests;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("NoError empty code")
    public void testEmptyCode() {
        assertDoesNotThrow(() -> testCompilerWithCode(""));
    }

    @Test
    @DisplayName("NoError empty Theory")
    public void testEmptyTheory() {
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory("")));
    }

    @Test
    @DisplayName("NoError Peano empty")
    public void testEmptyPeano() {

        // naive test of peano axiome in pseudo code that will shape the compiler
        // function
        final String code = "Definition Natural : Set();"
                + "Definition s : function[Natural,Natural]();"
                + "Axiom peanoA :0 in Natural;"
                + "Axiom peanoB :for n in Natural, S(n) in Natural;"
                + "Axiom peanoC :(n in Natural, s(n) = 0) not exist;"
                + "Axiom peanoD :(n in Natural, m in Natural, (s(n) = s(m) => n = m));"
                + "Axiom peanoE : Let sub : Set(Natural), (0 in sub, (for n in sub, s(n) in Natural)) => sub = Natural;";

        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }
}
