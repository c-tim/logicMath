
/**
 * Hello world!
 */

package compilation;

import compilation.error.CompilerException;
import compilation_steps.AST.ASTStartNode;
import compilation_steps.pkgSyntax.Syntax;

public class MathCompiler {

    private void manageInputFile(String pathFile) {

        // if the input file is already in stdin
        if ("stdin".equals(pathFile) || "/".equals(pathFile) || pathFile.equals("")) {
            Printer.printLogInput("Reading file in input");
        } else {
            String input;
            try {
                input = Thread.currentThread().getContextClassLoader().getResource(pathFile).getPath();

                System.setIn(new java.io.FileInputStream(input));
                Printer.printLogFileAccess(true, pathFile);

            } catch (java.io.FileNotFoundException e) {
                Printer.printLogFileAccess(false, pathFile);
            } catch (NullPointerException e) {
                Printer.printLogFileAccess(false, pathFile);
            }
        }
    }

    private void printLaunchStep(String nameStep) {
        Printer.println("Compilation : step " + nameStep);
    }

    public void launchCompilation() {
        launchCompilation("/");
    }

    public void launchCompilation(String pathInput) {
        manageInputFile(pathInput);

        // Now the code is in System.In
        // Printer.PIECode(System.in.toString());
        // Step 1
        printLaunchStep("Lexical Analysis");

        try {
            ASTStartNode axiom = new Syntax().execute();
        } catch (CompilerException ex) {
            // TODO handle exceptions
        }

        printLaunchStep("Semantical Analysis");

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Printer.init();
        new MathCompiler().launchCompilation();
    }
}
