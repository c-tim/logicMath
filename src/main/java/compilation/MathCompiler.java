
/**
 * Hello world!
 */

package compilation;

import compilation.error.CompilerException;
import compilation_steps.AST.ASTStartNode;
import compilation_steps.pkgSemantic.Semantic;
import compilation_steps.pkgSemantic.SemanticTree;
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
                //Printer.PIECodeInSystemIn(new java.io.FileInputStream(input));

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

    public void launchCompilation() throws CompilerException {
        launchCompilation("/");
    }

    public void launchCompilation(String pathInput) throws CompilerException {
        manageInputFile(pathInput);

        // Now the code is in System.In
        // Printer.PIECode(System.in.toString());
        // Step 1
        printLaunchStep("Lexical Analysis");
        ASTStartNode axiom;

             axiom = new Syntax().execute();


             printLaunchStep("Semantical Analysis");


            if (axiom == null || axiom.linked_Theory == null) {
                Printer.printError("No theory : compilation aborted");
                return;
            }
            SemanticTree semanticTree = new Semantic(axiom).execute();


    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Printer.init();
        try {
            new MathCompiler().launchCompilation("/home/tim/Documents/GitHub/logicMath/src/test/resources/Peano.txt");
        } catch (CompilerException e) {
            throw new RuntimeException(e);
        }
    }
}
