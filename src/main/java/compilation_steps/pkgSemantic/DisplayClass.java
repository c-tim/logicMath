package compilation_steps.pkgSemantic;

import compilation.Printer;
import compilation_steps.AST.*;

public class DisplayClass extends AstDefaultVisitor {



    // Count the depths of the node to display it with
    int depthLine = 0;

    // for code lisibility, call PIEDisplayClass with separator Depth (PIE : Print If Enabled = see configPrint)
    private void PIEClassWithDepth(String text) {
        Printer.PIEDisplayClass(text, depthLine);
    }



    public DisplayClass(SemanticTree tree) {
        tree.getStartNode().accept(this);
    }


    @Override
    public void visit(ASTList node) {
        defaultVisit(node);
    }

    @Override
    public void visit(ASTStartNode node) {
        Printer.PIEDisplayClass("Start Displaying AST Class :\n");
        defaultVisit(node);
    }

    @Override
    public void visit(Definition node) {
        PIEClassWithDepth(node.toString() + " {\n");
        depthLine++;
        defaultVisit(node);
        depthLine--;
        PIEClassWithDepth(" }\n");
    }

    @Override
    public void visit(ExprEqual node) {
        PIEClassWithDepth(node.toString());
    }

    @Override
    public void visit(Expression node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ArgExpression node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ExprExists node) {
        PIEClassWithDepth(node.toString());
    }

    @Override
    public void visit(ExprForall node) {
        PIEClassWithDepth(node.toString());
    }

    @Override
    public void visit(ExprIs node) {
        PIEClassWithDepth(node.toString());
    }

    @Override
    public void visit(ExprList node) {
        defaultVisit(node);
    }

    @Override
    public void visit(ListArgPredicat node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ExprNull node) {
        PIEClassWithDepth(node.toString());
    }

    @Override
    public void visit(Predicat node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ExprQuantificateur node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ExprVariable node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ArgVar node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ExprVarStatement node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(Ident node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(ListVariables node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(objectType node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(Property node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(Proposition node) {
        PIEClassWithDepth(node.toString()+"\n");
        depthLine++;
        defaultVisit(node);
        depthLine--;

    }

    @Override
    public void visit(Statement node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(StatementExpression node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }

    @Override
    public void visit(Theory node) {
        PIEClassWithDepth(node.toString() + " {\n");
        depthLine++;
        defaultVisit(node);
        depthLine--;
        PIEClassWithDepth(" }\n");
    }

    @Override
    public void visit(TheoryBody node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }


}

