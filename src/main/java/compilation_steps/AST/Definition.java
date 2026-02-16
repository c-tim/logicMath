package compilation_steps.AST;

import java.util.List;

/* This is a predicat*/
public class Definition extends Predicat {



    Ident typeIs;
    public Ident getTypeIs() {
        return typeIs;
    }
    /*public List<ExprVariable> getArgs() {
        return args;
    }*/

    //List<ExprVariable> args;




    public Definition(Ident _definitionId, ListArgPredicat l, Expression _expression, Ident _typeIs) {
        super(_definitionId,  l,  _expression);

        typeIs = _typeIs;

        /*if (vars != null){
            args=turnExprToVar(vars);

        }else {
            args = null;
        }*/
    }

    public List<ExprVariable> turnExprToVar(ListArgPredicat e){
        return  e.getExternalVariable();
    }


    /*public Proposition turnToProposition(final boolean isAxiom){
        if(expression == null){
             return new Proposition(isAxiom, definitionId);

        }
        ExprList list = new ExprList(expression);
        list.addExpressionToListToStart(new ExprForall(args));
        Statement s = new StatementExpression(list);
        return new Proposition(isAxiom, definitionId, list);
    }*/

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public static Definition create(Ident _definitionId, ListArgPredicat _var, Expression _expression){
        return new Definition(_definitionId, _var,_expression,null);
    }

    //variante of definition using "is" statement, example : x is prime
    public static Definition createWithIs(Ident _definitionId, ListArgPredicat _var, Expression _expression, Ident typeIs){
        return new Definition(_definitionId, _var,_expression, typeIs);
    }

        @Override
        public String toString(){
           /* if (args == null) {
                return "Definition :"+expression.toString();

            }
*/
            String vars_s = "";
                for (ExprVariable v : list_var_in_pointers){
                    vars_s += v.toString()+",";
                }


            return "Definition (vars :"+vars_s+"):"+expression.toString();
        }

}
