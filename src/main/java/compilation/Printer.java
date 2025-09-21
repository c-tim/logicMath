package compilation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Printer {

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

    public static boolean isDebugParsingEnabled() {
        return currentConfig.debugParsing;
    }

    public static void init() {
        // create new config
        currentConfig = new configPrint();
    }

    public Printer() {
        init();
    }
}
