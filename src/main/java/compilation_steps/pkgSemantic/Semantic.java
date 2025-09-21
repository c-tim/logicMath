package compilation_steps.pkgSemantic;

import compilation_steps.AST.ASTStartNode;

public class Semantic {


    private final SemanticTree semanticTree;

    public Semantic(ASTStartNode startNode) {
        this.semanticTree = new SemanticTree(startNode);
    }

    public SemanticTree execute(){
        new DisplayClass(semanticTree);
        return semanticTree;
    }
}
