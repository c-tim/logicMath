package compilation_steps.AST;

import java.util.List;
import java.util.Objects;

public class ExprEqual extends Expression{


    //List<ExprVariable> liste_variables;
    Ident left_expression;
    Ident right_expression;

    public ExprEqual(Ident _left_expression, Ident _right_expression){
        super();
        left_expression=_left_expression;
        right_expression=_right_expression;
    }


    public static ExprEqual create(Ident _left_expression, Ident _right_expression){
        return new ExprEqual(_left_expression, _right_expression);
    }

    @Override
    public String toString(){
        return "equal";
    }

}
