package compilation_steps.AST;

public abstract class AstDefaultVisitor {

    public void defaultVisit(ASTNode node) {
        for (ASTNode nodeChild : node.getChildren()) {
            nodeChild.accept(this);
        }
    }

    public void visit(ASTStartNode node) {
        defaultVisit(node);
    }
}
