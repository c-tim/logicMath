package compilation_steps;



import compilation.Printer;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Scanner;
import java_cup.runtime.ScannerBuffer;
import java_cup.runtime.Symbol;
import java_cup.runtime.lr_parser;

public class cupParser {

    private ComplexSymbolFactory csf;
    private Scanner lexer;
    private ScannerBuffer scanBuffer;
    private lr_parser parser;

    private Symbol result_parsing;

    public cupParser() {

        this.csf = new java_cup.runtime.ComplexSymbolFactory();
        this.lexer = new Yylex(new java.io.InputStreamReader(System.in), this.csf);
        this.scanBuffer = new java_cup.runtime.ScannerBuffer(this.lexer);
        this.parser = new parser(this.scanBuffer, this.csf);
    }

    public Object execute() {
        Object axiom = null;
        result_parsing = null;
        try {
            if (Printer.isDebugParsingEnabled()) {
                result_parsing = parser.debug_parse();
            } else {
                result_parsing = parser.parse();
            }

            if (result_parsing == null || result_parsing.sym != 0) {
                Printer.println("Parsing ends with symbol: " + result_parsing);
            } else {
                axiom = result_parsing.value;
                Printer.println("Parsing OK, Axiom = " + axiom);
            }

        } catch (Exception e) {
            Printer.println(e.getMessage());
        }

        finally {
            Printer.printLogDebugToken(this.scanBuffer.getBuffered().toString());

        }
        return axiom;
    }
}
