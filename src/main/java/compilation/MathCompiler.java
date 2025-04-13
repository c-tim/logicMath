
/**
 * Hello world!
 */

package compilation;

import compilation.error.CompilerException;
import compilation_steps.AST.ASTStartNode;
import compilation_steps.pkgSyntax.Syntax;

public class MathCompiler {

    private void manageInputFile(String pathFile){

        
        // if the input file is in stdin 
        if ("stdin".equals(pathFile) || "/".equals(pathFile)) {
             Printer.printLogInput("Reading file in input");
        } else {
            String input = Thread.currentThread().getContextClassLoader().getResource(pathFile).getPath();
            try {
                System.setIn(new java.io.FileInputStream(input));
                Printer.printLogFileAccess(true, pathFile);

               }
             catch (java.io.FileNotFoundException e) {
                Printer.printLogFileAccess(false, pathFile);
            }
        }
    }

    private void printLaunchStep(String nameStep) {
        Printer.println("Compilation : étape " + nameStep);
    }

    private void launchCompilation() {
        launchCompilation("/");
    }

    private void launchCompilation(String pathInput) {
        manageInputFile(pathInput);

        // Step 1
        printLaunchStep("Analyse Lexicale");
    
        try {
            ASTStartNode axiom = new Syntax().execute();
        } catch (CompilerException ex) {
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        new MathCompiler().launchCompilation();
    }
}
