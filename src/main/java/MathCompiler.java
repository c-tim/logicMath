

/**
 * Hello world!
 */
public class MathCompiler {


    private void printLaunchStep(String nameStep){
        Printer.println("Compilation : étape "+nameStep);
    }

    private void launchCompilation(){
        //Step 1 
        printLaunchStep("Analyse Lexicale");
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
        new MathCompiler().launchCompilation();
    }
}
