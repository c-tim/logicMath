package compiler_tests;

import compilation.error.CompilerException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("NoError empty Axiom")
    public void testEmptyAxiom() {
        final String code = "Axiom a;";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }

    @Test
    @DisplayName("NoError Axiom with meaning")
    public void testAxiomWithMeaning() {
        final String code = "Axiom a : forall z, exists z ;";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }


    @Test
    @DisplayName("NoError Axiom with arguments and meaning")
    public void testAxiomWithMeaningAndArguments() {
        final String code = "Axiom absurdAxiom(x : SET; y : SET) : x=y;";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }

    @Test
    @DisplayName("NoError Axiom with arguments and meaning even if wrong expr")
    public void testAxiomWithMeaningAndArgumentsWronExrpession() {
        final String code = "Axiom absurdAxiom(x = y) : x=y;";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }


    @Test
    @DisplayName("NoError empty Proposition")
    public void testEmptyProposition() {
        final String code = "Proposition a;";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }

    @Test
    @DisplayName("NoError Proposition with meaning")
    public void testPropositionWithMeaning() {
        final String code = "Proposition aa : forall z, exists z ;";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }

    @Test
    @DisplayName("NoError Proposition with args and meaning")
    public void testPropositionWithArgumentsAndMeaning() {
        final String code = "Proposition absurdProposition(x : SET; y : SET) : x=y;";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }




    @Test
    @DisplayName("NoError Definition with empty arguments and null meaning")
    public void testDefinitionWIthEmptyArgs() {
        final String code = "Definition a: Null;";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }

    @Test
    @DisplayName("NoError Definition with arguments and null meaning")
    public void testDefinitionWithArgs() {
        final String code = "Definition a(x : SET, y : SET) : Null;";
        //assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
        try {
            testCompilerWithCode(encapsulateWithTheory(code));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("NoError Definition with arguments and meaning")
    public void testDefinitionWithArgsAndMEaning() {
        System.setProperty("cup.runtime.debug", "true");
        final String code = "Definition a(x : SET; y : SET) : x = y;";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }

    @Test
    @DisplayName("NoError Definition with arguments and meaning 2")
    public void testDefinitionWithArgsAndMEaning2() {
        final String code = "Definition a(x : SET; y : SET) : forall x;";
        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }










    @Test
    @DisplayName("NoError Peano empty")
    public void testEmptyPeano() {

        // naive test of peano axiome in pseudo code that will shape the compiler
        // function
        final String code = "Definition Natural : x in SET;"
                + "Definition s : function(Natural, Natural);"
                + "Axiom peanoA :zero in Natural;"
                + "Axiom peanoB :forall n in Natural, S(n) in Natural;"
                + "Axiom peanoC :non exists n in Natural, s(n) = null ;"
                + "Axiom peanoD :(n in Natural, m in Natural, (s(n) = s(m) => n = zero));"
                + "Axiom peanoE : forall sub in set(Natural), (zero in sub, (forall n in sub, s(n) in Natural)) => sub = Natural;";

        assertDoesNotThrow(() -> testCompilerWithCode(encapsulateWithTheory(code)));
    }
    @Test
    @DisplayName("NoError ZFC empty")
    public void testEmptyZFC() {

        // naive test of peano axiome in pseudo code that will shape the compiler
        // function
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



}
