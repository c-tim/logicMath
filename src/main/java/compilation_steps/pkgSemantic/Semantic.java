package compilation_steps.pkgSemantic;

import compilation.error.CompilerException;
import compilation_steps.AST.ASTStartNode;
import compilation_steps.pkgSemantic.symbols.InfoTheory;
import compilation_steps.pkgSemantic.symbols.Scope;


public class Semantic {


    private final SemanticTree semanticTree;

    public Semantic(ASTStartNode startNode) {
        this.semanticTree = new SemanticTree(startNode, new Scope(null, "Root"), new SemanticAttribute<InfoTheory>(), new SemanticAttribute<Scope>());
    }

    public SemanticTree execute() throws CompilerException {
        new DisplayClass(semanticTree);
        int errors = new BuildSymbolTable(semanticTree).execute();
        if (errors>0){
            throw new CompilerException(errors + "errors found during Symbol Table construction");
        }
        return semanticTree;
    }
}
