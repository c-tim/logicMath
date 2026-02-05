package compilation_steps.AST;

public class ExprIs extends Expression{

    Ident var_left, var_right;

    public ExprIs(Ident var_left, Ident var_right) {
        this.var_left = var_left;
        this.var_right = var_right;
    }

    public static ExprIs create(Ident _left_expression, Ident _right_expression){
        return new ExprIs(_left_expression, _right_expression);
    }

    @Override
    public String toString(){
        return var_left.toString() + "is" + var_right.toString();
    }
}
