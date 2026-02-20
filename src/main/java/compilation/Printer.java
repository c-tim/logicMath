package compilation;

import compilation_steps.pkgSemantic.SemanticTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Printer {
    //Display the depths in the Printer
    final static String charSeparator = " - ";

    public static configPrint currentConfig;

    /*
     * public static void configPrintln(String text){
     * currentPrinter.println(text);
     * }
     */
    public static void printError(String errorText){
        println("[Error] "+ errorText);
    }

    public static void println(String text) {
        print(text + "\n");
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void printSeparatorLine() {
        println("------------------------");
    }


    public static String AddTextSeparator(String text, int depthLine) {
        String returnedText = "";
        for (int i = 0; i < depthLine; i++) {
            returnedText += charSeparator;
        }
        return returnedText + text;
    }

    public static void PrintIfEnabled(String text, boolean configOpyion, int ident){
       PrintIfEnabled(AddTextSeparator(text, ident), configOpyion);
    }

    public static void PrintIfEnabled(String text, boolean configOpyion){
        if(configOpyion){
            print(text);
        }
    }

    /* Prints related to the differents steps */
    public static void printLogFileAccess(boolean fileFound, String pathFile) {

        if (fileFound) {
            printLogInput("File " + pathFile + " found");
        } else {
            if (pathFile.equals("")) {
                printLogInput("The given text is not recognised as valid path");
            } else {
                printLogInput("The file " + pathFile + " has not been found");
            }
            printLogInput("Reading content of text as code");
        }
    }

    public static void printLogInput(String text) {
        if (!currentConfig.Input) {
            return;
        }
        println(text);
    }

    public static void printLogDebugToken(String text) {
        if (!currentConfig.debugToken) {
            return;
        }
        println("Debug Token :");
        println(text);
    }

    /** Print If Enabled (debugInput) the given code */
    public static void PIECodeInSystemIn(FileInputStream input) {
        if (!currentConfig.debugInputCode) {
            return;
        }
        println("Input Code :");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        try {
            // Read a line of text from System.in
            String inputText = reader.readLine();
            while ((inputText = reader.readLine()) != null) {
                println(inputText);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
            printError("Cannot print code");
        }

        printSeparatorLine();
    }


    public static void PIEDisplayClass(String text){
        PrintIfEnabled(text, currentConfig.debugClassName);
    }

    public static void PIEDisplayClass(String text, int depth){
        PrintIfEnabled(AddTextSeparator(text,depth), currentConfig.debugClassName);
    }



    public static void PIEDisplaySymbolTab(SemanticTree tree){
        if (!currentConfig.debugSymTab){
            return;
        }
        println("= Table des symboles (passe1)");
        tree.getRootScope().toPrint();
    }

    public static void PIEShowsSymbolsEroors(final String text){
        PrintIfEnabled(text, currentConfig.printErrorsSymbols);
    }

    public static boolean isDebugParsingEnabled() {
        return currentConfig.debugParsing;
    }

    public static void init() {
        // create new config
        currentConfig = new configPrint(compilSteps.SYNTAX);
    }

    public static void init(compilSteps step) {
        // create new config
        currentConfig = new configPrint(step);
    }

    public Printer() {
        init();
    }
}
