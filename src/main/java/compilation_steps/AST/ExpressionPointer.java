package compilation_steps.AST;

public class ExpressionPointer extends Expression implements ArgPointer{

    public Expression expr;

    public ExpressionPointer(Expression expr) {
        this.expr = expr;
    }

    public static ExpressionPointer create(Expression e){
        return new ExpressionPointer(e);
    }
}
