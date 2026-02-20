package compilation_steps.pkgSemantic;

import compilation.Printer;
import compilation_steps.AST.*;

public class DisplayClass extends AstDefaultVisitor {



    // Count the depths of the node to display it with
    int depthLine = 0;

    // for code lisibility, call PIEDisplayClass with separator Depth (PIE : Print If Enabled = see configPrint)
    private void PIEClassWithDepth(String text) {
        Printer.PIEDisplayClass(text+"\n", depthLine);
    }



    public DisplayClass(SemanticTree tree) {
        tree.getStartNode().accept(this);
    }

    public void visitChildrenWithDepth(ASTNode n){
        depthLine++;
        for (ASTNode nodeChild : n.getChildren()) {
            nodeChild.accept(this);
        }
        depthLine--;
    }

    @Override
    public void defaultBehaviour(ASTNode n){
        PIEClassWithDepth(n.toString());
    }

    /*@Override
    public void visit(ASTList n){
        Printer.PIEDisplayClass("[");
        if(!n.getChildren().isEmpty()) {
            depthLine++;
            for (Object e : n) {
                defaultVisit((ASTNode) e);
            }
            depthLine--;
        }
        Printer.PIEDisplayClass("]");
    }*/




    @Override
    public void visit(ASTStartNode node) {
        Printer.PIEDisplayClass("Start Displaying AST Class :\n");
        defaultVisit(node);
    }

    @Override
    public void visit(Definition node) {
        PIEClassWithDepth(" Definition {");
        visitChildrenWithDepth(node);
        PIEClassWithDepth("}");
    }

    @Override
    public void visit(ExprEqual node) {
        PIEClassWithDepth(" Equal :");
        visitChildrenWithDepth(node);
    }


    @Override
    public void visit(ArgExpression node) {
        //PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ExprExists node) {
        PIEClassWithDepth(" EXISTS :");
        visitChildrenWithDepth(node);
    }

    @Override
    public void visit(ExprForall node) {
        PIEClassWithDepth(" FORALL :");
        visitChildrenWithDepth(node);
    }

    @Override
    public void visit(ExprIs node) {
        PIEClassWithDepth(" IS_expr :");
        visitChildrenWithDepth(node);
    }

    @Override
    public void visit(ExprList node) {
        PIEClassWithDepth("Expr[");
        visitChildrenWithDepth(node);
        PIEClassWithDepth("    ]");


    }

    @Override
    public void visit(ListArgPredicat node) {
       // PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ExprNull node) {
        PIEClassWithDepth("Null");
        visitChildrenWithDepth(node);
    }

    @Override
    public void visit(ExprQuantificateur node) {
        //PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ExprVariable node) {
        PIEClassWithDepth("Vars[");
        visitChildrenWithDepth(node);
        PIEClassWithDepth("    ]");
    }

    @Override
    public void visit(ArgVar node) {
        //PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ExprCallPredicat node) {
        PIEClassWithDepth("/////");
        defaultVisit(node);
    }

    @Override
    public void visit(Ident node) {
        //PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ListVariables node) {
        //PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }



    @Override
    public void visit(Proposition node) {
        PIEClassWithDepth(node.toString()+"{");
        visitChildrenWithDepth(node);
        PIEClassWithDepth(" }");

    }

    @Override
    public void visit(Statement node) {
        //PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(StatementExpression node) {
        //PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }



    @Override
    public void visit(Theory node) {
        PIEClassWithDepth("Theory {");
        visitChildrenWithDepth(node);
        PIEClassWithDepth(" }");
    }

    /*
    @Override
    public void visit(Expression n){
        Printer.PIEDisplayClass("ERROR : no implementation for this expression : "+n.toString()+"\n");
    }
*/



}

