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

    public void visit(ASTList node) {
        defaultVisit(node);
    }

    public void visit(Proposition node) {
        defaultVisit(node);
    }

    public void visit(Theory node) {
        defaultVisit(node);
    }

    public void visit(Expression node) {
        defaultVisit(node);
    }

    public void visit(Definition node) {
        defaultVisit(node);
    }

    public void visit(Property node) {
        defaultVisit(node);
    }

    public void visit(objectType node) {
        defaultVisit(node);
    }

    public void visit(Ident node){
        defaultVisit(node);
    }

    public void visit(TheoryBody node){
        defaultVisit(node);
    }
}
