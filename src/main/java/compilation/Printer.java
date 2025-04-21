package compilation;

public class Printer {

    public static configPrint currentConfig;

    /*
     * public static void configPrintln(String text){
     * currentPrinter.println(text);
     * }
     */

    public static void println(String text) {
        print(text + "\n");
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void printSeparatorLine() {
        println("------------------------");
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
    public static void PIECode(String text) {
        if (!currentConfig.debugInputCode) {
            return;
        }
        println("Input Code :");
        println(text);
        printSeparatorLine();
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
