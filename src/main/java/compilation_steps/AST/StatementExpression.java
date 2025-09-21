package compilation_steps.AST;

public class StatementExpression extends Statement{


    Expression linked_expression;

    public StatementExpression(Expression _expression) {
        super(_expression);
        linked_expression=_expression;

    }


    public static StatementExpression create(Expression _linked_expression){
        return new StatementExpression(_linked_expression);
    }

}
