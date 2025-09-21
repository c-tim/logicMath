package compilation_steps.pkgSemantic;

import compilation_steps.AST.ASTStartNode;
import compilation_steps.symbols.Scope;

public class SemanticTree {

    public ASTStartNode getStartNode() {
        return startNode;
    }

    private ASTStartNode startNode;

    private Scope rootScope;

    public SemanticTree(ASTStartNode startNode) {
        this.startNode = startNode;
    }
}
