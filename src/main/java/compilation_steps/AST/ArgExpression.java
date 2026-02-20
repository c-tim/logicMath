package compilation_steps.AST;

public class ArgExpression extends Expression implements ArgPredicat {

    public Expression expr;

    public ArgExpression(Expression expr) {
        super(ArgExpression.class.toString());

        this.expr = expr;
        addChild(expr);
    }

    public static ArgExpression create(Expression e){
        return new ArgExpression(e);
    }
}
