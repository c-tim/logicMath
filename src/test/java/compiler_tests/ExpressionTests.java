package compiler_tests;

import compilation.error.CompilerException;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import compilation.MathCompiler;
import compilation.Printer;



public class ExpressionTests {
    MathCompiler compilerForTests;

    @BeforeAll
    public static void initPrinter() {
        Printer.init();
    }

    @BeforeEach
    public void initMathCompiler() {
        if(Printer.currentConfig.debugTestName){
            Printer.println("Next Test");
            Printer.printSeparatorLine();
        }
        compilerForTests = new MathCompiler();
    }

    @AfterEach
    public void NullifyAllVariablesAndPrintSeparator() {
        compilerForTests = null;
        if(Printer.currentConfig.debugTestName){
            Printer.printSeparatorLine();
        }
    }

    public void testCompilerWithCode(String code) throws CompilerException {
        System.setIn(new java.io.ByteArrayInputStream(code.getBytes()));
        compilerForTests.launchCompilation("/");
    }


    @Test
    @DisplayName("NoError empty code")
    public void testEmptyCode() {
        assertDoesNotThrow(() -> testCompilerWithCode(""));
    }



}
