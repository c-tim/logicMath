package compilation_steps.syntax;

import compilation_steps.*;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ScannerBuffer;
import java_cup.runtime.Scanner;
import java_cup.runtime.lr_parser;

public class cupParser {


    private ComplexSymbolFactory csf;
    private Scanner lexer;
    private ScannerBuffer scanBuffer;
    private lr_parser parser;

    public cupParser(){

        this.csf = new java_cup.runtime.ComplexSymbolFactory();
		this.lexer = new Yylex(new java.io.InputStreamReader(System.in), this.csf);
		this.scanBuffer = new java_cup.runtime.ScannerBuffer(this.lexer);
		this.parser = new parser(this.scanBuffer, this.csf);
    }
}
