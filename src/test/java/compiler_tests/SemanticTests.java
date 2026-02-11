package compiler_tests;

import compilation.compilSteps;
import compilation.error.CompilerException;
import org.junit.jupiter.api.*;

import compilation.MathCompiler;
import compilation.Printer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SemanticTests {


    MathCompiler compilerForTests;

    @BeforeAll
    public static void initPrinter() {
        //The compiler is by default at syntax, we push to semantic
        Printer.init(compilSteps.SEMANTIC);
        Printer.currentConfig.debugToken = false;
        Printer.currentConfig.debugParsing = false;

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

    public static String encapsulateWithTheory(String mathCode) {
        final String beforeText = "Theory test {";
        final String afterText = "}";
        return beforeText + mathCode + afterText;
    }

    public void testCompilerWithCode(String code) throws CompilerException {
        System.setIn(new java.io.ByteArrayInputStream(code.getBytes()));
        compilerForTests.launchCompilation("/");
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


    //show the tree
    @Test
    @DisplayName("NoError display ZFC")
    public void NoErrorSyntaxDisplayASTTree() {
        final String code = "Axiom extensionalite (x : SET; y : SET) : x = y <=> (forall z : SET, (z in x <=> z in y));  " +
                "Axiom shemaComprehension(P : Proposition; x : SET) : forall y : SET, forall z : SET, (z in y => z in x and P(z)); " +
                " Axiom NullExist : exists x, non (exists y, y in x);  " +
                "Axiom paire(x : SET; y : SET): exists z, forall w, (w in z <=> w=x or w=y) ; " +
                " Definition x is Subset(y : SET) : forall w, (w in x=>w in y); " +
                " Axiom PowerSet(x : SET) : exists y, forall z, (z in y<=> z is subset(x));  " +
                "Axiom union(x : SET) : exists y, forall z, (z in y <=> exists w, (w in x and z in w));  " +
                "Definition Y is singleton(X : SET) : forall z, (z in Y => z = X);  " +
                "Axiom infinity : exists x ,( null in x and forall y, (y in x => union(y,singleton(y)) in x));";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));

    }

/* The following tests are coming in pair : one with the redefinition and the other without*/

    @Test
    @DisplayName("Theory redefinition")
    public void TheoryRedefinition() {
        final String code = "Theory conflit {  " +
                "Axiom conflit : exists z; " +
                "}";
        assertThrows(CompilerException.class,() -> testCompilerWithCode(code));

    }

    @Test
    @DisplayName("Theory without redefinition")
    public void NoErrorTheoryDefinition() {
        final String code = "Theory conflit {  " +
                "Axiom conflitAvoided : exists z; " +
                "}";
        assertDoesNotThrow(() -> testCompilerWithCode(code));

    }

    @Test
    @DisplayName("Proposition redefinition")
    public void PropositionRedefinition() {
        final String code = "Theory th {  " +
                "Axiom conflit : exists z; " +
                "Axiom conflit : exists y; " +
                "}";
        assertThrows(CompilerException.class,() -> testCompilerWithCode(code));

    }

    @Test
    @DisplayName("Proposition without redefinition")
    public void NoErrorPropositionDefinition() {
        final String code = "Theory th {  " +
                "Axiom conflict : exists z; " +
                "Axiom conflictAvoided : exists y; " +
                "}";
        assertDoesNotThrow(() -> testCompilerWithCode(code));
    }

    @Test
    @DisplayName("Expression redefinition")
    public void ExpressionRedefinition() {
        final String code = "Theory th {  " +
                "Axiom a : exists z, exists z; " +
                "}";
        assertThrows(CompilerException.class,() -> testCompilerWithCode(code));

    }

    @Test
    @DisplayName("Expression without redefinition")
    public void NoErrorExpressionDefinition() {
        final String code = "Theory th {  " +
                "Axiom a : exists z, exists notZ; " +
                "}";
        assertDoesNotThrow(() -> testCompilerWithCode(code));
    }

    @Test
    @DisplayName("No error Expression redefinition in other proposition")
    public void ExpressionRedefinition2() {
        final String code = "Theory th {  " +
                "Axiom a : exists z, exists w; " +
                "Axiom b : exists z, exists y; " +
                "}";
        assertDoesNotThrow(() -> testCompilerWithCode(code));

    }







}
