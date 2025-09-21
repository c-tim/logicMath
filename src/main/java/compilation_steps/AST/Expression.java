package compilation_steps.AST;

import java.util.List;

public class Expression extends ASTNode {

    protected boolean isAssertion;


    public Expression() {
        super(Expression.class.getName());
    }

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }


    /* This getter is used so that it can be overidden by exprList, which use the value of its child*/
    public boolean isValidAssertion(){
        return isAssertion;
    }

    public static Expression create(){
        return new Expression();
    }

    public List<ExprVariable> getExternalVariable(){
        return null;
    }
}
