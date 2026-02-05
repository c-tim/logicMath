package compilation_steps.AST;

public abstract class AstDefaultVisitor {

    public void visit(ASTList node) {
        defaultVisit(node);
    }

    public void defaultVisit(ASTNode node) {
        for (ASTNode nodeChild : node.getChildren()) {
            nodeChild.accept(this);
        }
    }

    public void visit(ASTStartNode node) {
        defaultVisit(node);
    }

    public void visit(Definition node) {
        defaultVisit(node);
    }

    public void visit(ExprEqual node) {
        defaultVisit(node);
    }

    public void visit(Expression node) {
        defaultVisit(node);
    }

    public void visit(ExpressionPointer node) {
        defaultVisit(node);
    }

    public void visit(ExprExists node) {
        defaultVisit(node);
    }

    public void visit(ExprForall node){
        defaultVisit(node);
    }

    public void visit(ExprIs node) {
        defaultVisit(node);
    }

    public void visit(ExprList node) {
        defaultVisit(node);
    }

    public void visit(ExprListPointer node) {
        defaultVisit(node);
    }

    public void visit(ExprNull node) {
        defaultVisit(node);
    }


    public void visit(ExprPredicat node) {
        defaultVisit(node);
    }

    public void visit(ExprQuantificateur node) {
        defaultVisit(node);
    }

    public void visit(ExprVariable node) {
        defaultVisit(node);
    }

    public void visit(ExprVarPlaceHolder node) {
        defaultVisit(node);
    }

    public void visit(ExprVarStatement node) {
        defaultVisit(node);
    }

    public void visit(Ident node){
        defaultVisit(node);
    }

    public void visit(ListVariables node){
        defaultVisit(node);
    }

    public void visit(objectType node) {
        defaultVisit(node);
    }

    public void visit(Property node) {
        defaultVisit(node);
    }


    public void visit(Proposition node) {
        defaultVisit(node);
    }

    public void visit(Statement node){
        defaultVisit(node);
    }

    public void visit(StatementExpression node){
        defaultVisit(node);
    }

    public void visit(Theory node) {
        defaultVisit(node);
    }

    public void visit(TheoryBody node){
        defaultVisit(node);
    }













}
