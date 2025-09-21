package compiler_tests;

import compilation.MathCompiler;
import compilation.Printer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class MathVerificationTests {

        MathCompiler compilerForTests;


        public static String encapsulateWithTheory(String mathCode) {
            final String beforeText = "Theory {";
            final String afterText = "}";
            return beforeText + mathCode + afterText;
        }

    }
