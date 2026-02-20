package compilation_steps.AST;

import java.util.List;

public class Expression extends ASTNode implements ArgPredicat {

    protected boolean isAssertion;


    public Expression(String className) {
        super(className);
    }

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    /* This getter is used so that it can be overidden by exprList, which use the value of its child*/
    public boolean isValidAssertion(){
        return isAssertion;
    }

    /*public static Expression create(){
        return new Expression();
    }*/

    public ASTList<ExprVariable> getExternalVariable(){
        return null;
    }

    public void refactorList(ASTNode n){

    }

    @Override
    public String toString() {
        return "Expr"+labelClass;
    }
}
