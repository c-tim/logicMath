package compilation_steps.AST;

import java.util.List;

/* This is a predicat*/
public class Definition extends ASTNode {

    Ident definitionId;

    List<ExprVariable> args;

    Expression expression;

    public Definition(Ident _definitionId,  ExprListPointer vars,Expression _expression) {
        super(Definition.class.getName());
        definitionId = _definitionId;
        expression = _expression;
        if (vars != null){
            args=turnExprToVar(vars);

        }else {
            args = null;
        }
    }

    public List<ExprVariable> turnExprToVar(ExprListPointer e){
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

    public static Definition create(Ident _definitionId, ExprListPointer _var,Expression _expression){
        return new Definition(_definitionId, _var,_expression);
    }

        @Override
        public String toString(){
            if (args == null) {
                return "Definition :"+expression.toString();

            }

            String vars_s = "";
                for (ExprVariable v : args){
                    vars_s += v.toString()+",";
                }


            return "Definition (vars :"+vars_s+"):"+expression.toString();
        }

}
