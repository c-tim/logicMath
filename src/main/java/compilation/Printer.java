package compilation;

public class Printer {

    public static configPrint currentConfig;


    /*public static void configPrintln(String text){
        currentPrinter.println(text);
    }*/

    public static void println(String text){
        print(text+"\n");
    }
    
    public static void print(String text){
        System.out.print(text);
    }

    /* Prints related to the differents steps  */
    public static void printLogFileAccess(boolean fileFound, String pathFile ){

        if (fileFound){
            printLogInput("File "+ pathFile+" found");
        }else{
            printLogInput("The file "+ pathFile+" has not been found");
        }
    }

    public static void printLogInput(String text){
        if (!currentConfig.Input){
            return;
        } 
        println(text);
    }

    public static void printLogDebugToken(String text){
        if (!currentConfig.debugToken){
            return;
        } 
        println("Debug Token :");
        println(text);
    }

    public static boolean isDebugParsingEnabled(){
        return currentConfig.debugParsing;
    }


    public Printer(){

        //create new config
        currentConfig = new configPrint();
    }
}
