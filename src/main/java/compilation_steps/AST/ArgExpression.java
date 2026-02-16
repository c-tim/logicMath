package compilation_steps.AST;

public class ArgExpression extends Expression implements ArgPredicat {

    public Expression expr;

    public ArgExpression(Expression expr) {
        this.expr = expr;
    }

    public static ArgExpression create(Expression e){
        return new ArgExpression(e);
    }
}
