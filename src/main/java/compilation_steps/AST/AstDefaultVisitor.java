package compilation_steps.AST;

import compilation.Printer;

public abstract class AstDefaultVisitor {


    public void defaultVisit(ASTNode node) {
        defaultBehaviour(node);
        visitChildren(node);
    }

    public void visitChildren(ASTNode node){
        for (ASTNode nodeChild : node.getChildren()) {
            nodeChild.accept(this);
        }
    }

    //Default action performed by the node
    public void defaultBehaviour(ASTNode node){
    }

    public void visit(ASTNode node) {
        Printer.printError("Node action not implemented");
    }


    public void visit(ASTList node) {
        defaultVisit(node);
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
    public void visit(ExprQuantificateur node) {
        defaultVisit(node);
    }


    public void visit(ExprList node) {
        defaultVisit(node);
    }


    public void visit(Expression node) {
        defaultVisit(node);
    }

    public void visit(ExprExists node) {
        defaultVisit(node);
    }
    public void visit(ArgExpression node) {
        defaultVisit(node);
    }



    public void visit(ExprForall node){
        defaultVisit(node);
    }

    public void visit(ExprIs node) {
        defaultVisit(node);
    }



    public void visit(ListArgPredicat node) {
        defaultVisit(node);
    }

    public void visit(ExprNull node) {
        defaultVisit(node);
    }


    public void visit(Predicat node) {
        defaultVisit(node);
    }


    public void visit(ExprVariable node) {
        defaultVisit(node);
    }

    public void visit(ArgVar node) {
        defaultVisit(node);
    }

    public void visit(ExprCallPredicat node) {defaultVisit(node);}

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
