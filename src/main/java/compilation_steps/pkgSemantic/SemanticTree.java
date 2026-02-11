package compilation_steps.pkgSemantic;

import compilation_steps.AST.ASTStartNode;
import compilation_steps.pkgSemantic.symbols.InfoTheory;
import compilation_steps.pkgSemantic.symbols.Scope;


public class SemanticTree {

    private ASTStartNode startNode;


    private Scope rootScope;
    private final SemanticAttribute<InfoTheory> attributesTheory;
    private final SemanticAttribute<Scope> attributesScope;


    public ASTStartNode getStartNode() {
        return startNode;
    }

    public SemanticTree(ASTStartNode startNode, Scope _rootScope, SemanticAttribute<InfoTheory> attributes_theory, SemanticAttribute<Scope> attributes_scope) {
        this.startNode = startNode;
        rootScope = _rootScope;
        attributesTheory = attributes_theory;
        attributesScope = attributes_scope;
    }

    public SemanticAttribute<Scope> getAttributesScope() {
        return attributesScope;
    }

    public SemanticAttribute<InfoTheory> getAttributesTheory() {
        return attributesTheory;
    }

    public Scope getRootScope() {
        return rootScope;
    }

}
