package compilation_steps.AST;

import java.util.List;

/* This is a predicat*/
public class Definition extends ASTNode {

    Ident definitionId;

    List<ExprVariable> args;

    Expression expression;

    public Definition(Ident _definitionId,  Expression vars,Expression _expression) {
        super(Definition.class.getName());
        definitionId = _definitionId;
        expression = _expression;
        args=turnExprToVar(vars);
    }

    public List<ExprVariable> turnExprToVar(Expression e){
        return  e.getExternalVariable();
    }

    public Proposition turnToProposition(final boolean isAxiom){
        if(expression == null){
        return new Proposition(isAxiom, definitionId);

        }
        ExprList list = new ExprList(expression);
        list.addExpressionToListToStart(new ExprForall(args));
        Statement s = new StatementExpression(list);
        return new Proposition(isAxiom, definitionId, list);
    }

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public static Definition create(Ident _definitionId, Expression _var,Expression _expression){
        return new Definition(_definitionId, _var,_expression);
    }

}
