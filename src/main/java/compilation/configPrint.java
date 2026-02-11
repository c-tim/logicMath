package compilation;

public class configPrint {

    /*
     * All of these variables are for Debugging, they are for the moment all in
     * final
     */

    // Informations related to the search of Input File
    public boolean Input = false;

    // for the moment the debugParse doesnt work
    public boolean debugParsing = true;

    // Display the tokens
    public boolean debugToken = true;

    // Display the code given to the MathCompiler
    public final boolean debugInputCode = true;

    // Display the locations of the node
    public final boolean debugASTLocation = true;

    // Display the labels of the node in the AST
    public final boolean debugClassName= true;

    public final boolean debugTestName= true;

    public final boolean debugSymTab= true;

    public final boolean printErrorsSymbols = true;

    //Stating how far the compilation is acted
    public compilSteps levelCompilation;


    public configPrint(compilSteps levelCompilation) {
        this.levelCompilation = levelCompilation;
    }
}
