package compilation_steps.AST;

import java.util.List;
import java.util.Objects;

public class ExprEqual extends Expression{


    //List<ExprVariable> liste_variables;
    Expression left_expression;
    Expression right_expression;

    public ExprEqual(Expression _left_expression, Expression _right_expression){
        super();
        left_expression=_left_expression;
        right_expression=_right_expression;
    }


    public static ExprEqual create(Expression _left_expression, Expression _right_expression){
        return new ExprEqual(_left_expression, _right_expression);
    }

}
