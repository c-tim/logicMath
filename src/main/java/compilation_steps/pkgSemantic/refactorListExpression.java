package compilation_steps.pkgSemantic;

import compilation.Printer;
import compilation_steps.AST.*;

public class refactorListExpression extends AstDefaultVisitor {

    public refactorListExpression(SemanticTree tree) {
        tree.getStartNode().accept(this);
    }
/*

    @Override
    public void visit(ExprList node) {
        node.refactorList();
    }

    @Override
    public void visit(ExprQuantificateur node) {
        node.refactorList();
        visitChildren(node);
    }

    @Override
    public void visit(Predicat node) {
        node.refactorList();
        visitChildren(node);

    }

    @Override
    public void visit(ListVariables node) {
        node.refactorList();
        visitChildren(node);

    }

    @Override
    public void visit(ExprVariable node) {
        node.refactorList();
        visitChildren(node);

    }
    @Override
    public void visit(ListArgPredicat node) {
        node.refactorList();
        visitChildren(node);

    }
*/



}
